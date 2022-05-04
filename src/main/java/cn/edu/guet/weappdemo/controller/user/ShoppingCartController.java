package cn.edu.guet.weappdemo.controller.user;

import cn.edu.guet.weappdemo.domain.Order;
import cn.edu.guet.weappdemo.pay.WXPay;
import cn.edu.guet.weappdemo.service.impl.OrderServiceImpl;
import cn.edu.guet.weappdemo.util.FetchInFormationUtil;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @Author: tjh
 * @Date: 2022/05/01/17:17
 * @Description: 微信付款码支付，支付成功后调用订单业务
 */
public class ShoppingCartController {


    /**
     *
     * @param auth_cod 付款码id
     * @param itemMessage 订单部分信息，格式为
     *       "username,用户名字;remark,备注信息:id,奶茶id;name,奶茶名字;price,奶茶单价;amount,奶茶数量;";
     *        示例：username,tai极;remark,无:id,26;name,芝芝乳品;price,18.00;amount,2#id,25;name,安慕希可可;price,20.00;amount,3;
     * @param total_fee
     * @throws Exception
     */
    public static void newOrderPaymentCode (String auth_cod,String itemMessage,String total_fee) throws Exception{
         /*
        付款码支付成功时，resultMessage返回成功的信息，该信息以逗号隔开，失败则返回空值“”
         */
        String resultMessage = WXPay.scanCodeToPay(auth_cod,itemMessage,total_fee);

        String [] itemInfo = resultMessage.split(",");

        // 支付成功，则以逗号隔开的信息字段为5,
        if (itemInfo.length == 5) {
            // 商户号
            String mch_id = itemInfo[1];
            // 商户订单号
            String out_trade_no = itemInfo[2];
            // 微信订单号
            String transaction_id = itemInfo[3];
            // 支付完成时间
            String start_time = itemInfo[4];

            // 时间转换为Timetamp
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            Timestamp timestamp = new Timestamp(sdf.parse(start_time).getTime());

            // 从itemMessage 获取用户及部分订单信息
            List<String> PayCodeList = FetchInFormationUtil.getInformationFromItemMessage(itemMessage);
            // 获取用户名
            String username = PayCodeList.get(0);
            // 获取订单备注信息
            String remark = PayCodeList.get(1);
            // 获取商品id和对应购买量
            Map<String,String> item_list = FetchInFormationUtil.getIdAmount(PayCodeList.get(2));
            // 获取订单列表
            String teaList = PayCodeList.get(3);
            // 获取订单金额
            String totalPrice = PayCodeList.get(4);

            // 新建订单
            Order PMOrder = new Order();
            PMOrder.setMch_id(Integer.parseInt(mch_id));
            PMOrder.setOut_trade_no(out_trade_no);
            PMOrder.setStart_time(timestamp);
            PMOrder.setTransaction_id(transaction_id);
            PMOrder.setUsername(username);
            PMOrder.setList(teaList);
            PMOrder.setAmount(Double.parseDouble(totalPrice));
            PMOrder.setStatus(1);
            PMOrder.setRemark(remark);

            // 进行订单事务
            OrderServiceImpl osi = new OrderServiceImpl();
            osi.newOrder(PMOrder, item_list);
        } else {
            System.out.println("微信支付失败~~~");
        }
    }
}
