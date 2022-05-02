package cn.edu.guet.weappdemo.controller;


import cn.edu.guet.weappdemo.domain.Order;
import cn.edu.guet.weappdemo.service.OrderService;
import cn.edu.guet.weappdemo.service.impl.OrderServiceImpl;
import cn.edu.guet.weappdemo.util.FetchInFormationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 接收二维码支付回调信息，并调用订单业务
 */
@RestController
@Slf4j
public class TestController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/auth")
    public String auth(@RequestParam("code") String code) {
        log.info("获取code");
        log.info("code : " + code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxd9a46e74fc279fcc&secret=7deb521448e11ddbc163fca849648198&code=" + code + "&grant_type=authorization_code";
        String response = restTemplate.getForObject(url, String.class);
        log.info("response = {}", response);
        return response;
    }

    @PostMapping("/result")
    public String result(HttpServletRequest request, HttpServletResponse res) {
        BufferedReader reader = null;
        try {
            reader = request.getReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = "";
        StringBuffer inputString = new StringBuffer();
        try {
            while ((line = reader.readLine()) != null) {
                inputString.append(line);
            }
            request.getReader().close();
            String response = inputString.toString();//接收的回调结果（支付成功后，腾讯调用我们的接口，并发数据给我们）
            System.out.println("回调结果：" + response);
            String pattern =
                    ".+<attach><!\\[CDATA\\[(.+);.+" +
                            "<mch_id><!\\[CDATA\\[(\\d{10}).+" +
                            "<out_trade_no><!\\[CDATA\\[(.{32}).+" +
                            "<time_end><!\\[CDATA\\[(\\d{14}).+" +
                            "<transaction_id><!\\[CDATA\\[(\\d{28})";
            Pattern r = Pattern.compile(pattern);
            // 现在创建 matcher 对象
            Matcher m = r.matcher(response);
            if (m.find()) {
                // 获取附加信息
                String itemInfo = m.group(1);
                // 商户号
                String mch_id = m.group(2);
                // 商户订单号
                String orderNo = m.group(3);
                // 微信订单号
                String transactionId = m.group(5);
                // 支付完成时间
                String orderTime = m.group(4);
                // 从itemMessage 获取用户及部分订单信息
                List<String> QRList = FetchInFormationUtil.getInformationFromItemMessage(itemInfo);
                // 获取用户名
                String username = QRList.get(0);
                // 获取订单备注信息
                String remark = QRList.get(1);
                // 获取商品id和对应购买量
                Map<String,String> item_list = FetchInFormationUtil.getIdAmount(QRList.get(2));
                // 获取订单列表
                String teaList = QRList.get(3);
                // 获取订单金额
                String totalPrice = QRList.get(4);
                // 时间转为Timestamp
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                Timestamp timestamp = new Timestamp(sdf.parse(orderTime).getTime());

                Order QROrder = new Order();
//                String id = UUID.randomUUID().toString().replace("-", "");
//                order.setId(Integer.parseInt(id));//会自动生成32个字符

                // 新建订单
                QROrder.setMch_id(Integer.parseInt(mch_id));
                QROrder.setOut_trade_no(orderNo);
                QROrder.setStart_time(timestamp);
                QROrder.setTransaction_id(transactionId);
                QROrder.setUsername(username);
                QROrder.setList(teaList);
                QROrder.setAmount(Double.parseDouble(totalPrice));
                QROrder.setStatus(1);
                QROrder.setRemark(remark);

                // 进行订单处理
                OrderService orderService = new OrderServiceImpl();
                // 将新的订单信息存入数据库
                orderService.newOrder(QROrder, item_list);


                /*
                    发信息给微信，告知微信官方，已收到通知
                */
                String result = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>" +
                        "<return_msg><![CDATA[OK]]></return_msg>" +
                        "</xml>";
                BufferedOutputStream out = new BufferedOutputStream(res.getOutputStream());
                out.write(result.getBytes());
                out.flush();
                out.close();
            }

           /*if(result_code.equals("SUCCESS") && return_code.equals("SUCCESS")){
                向订单表插入数据;INSERT
                更新库存;UPDATE
            }*/
            //JSONObject json = XmlUtil.XmlToJson(inputString.toString());
            //String appid=json.get("appid")+"";
            //String mch_id=json.get("mch_id")+"";
            /*if (json.getString("return_code").equals("SUCCESS")) {
                if (json.getString("result_code").equals("SUCCESS")) {
                    String transaction_id = json.get("transaction_id") + "";//微信支付订单号
                    String out_trade_no = json.get("out_trade_no") + "";//商户订单号
                    String openid = json.get("openid") + "";
                    String trade_type = json.get("trade_type") + "";
                    //接下来是做自己的业务处理
                    //开一个线程，更新订单状态
                    *//*WXPayFinishThread wxp = new WXPayFinishThread(openid, transaction_id, out_trade_no, trade_type);
                    wxp.start();*//*

                }
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
