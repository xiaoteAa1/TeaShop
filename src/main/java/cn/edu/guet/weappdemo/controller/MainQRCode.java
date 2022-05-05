package cn.edu.guet.weappdemo.controller;

import cn.edu.guet.weappdemo.controller.user.ShoppingCartController;
import cn.edu.guet.weappdemo.pay.WXPay;

/**
 * 调用微信二维码支付接口
 */
public class MainQRCode {
    public static void main(String[] args) {
        String url = "http://4s770d5857.qicp.vip:12275";
        // 用户信息
        String username = "username,无极;";
        // 用户订单备注
        String remark = "remark,无:";
        // 订单信息
        String itemInfo1 = "id,26;name,芝芝乳品;price,18.00;amount,2#";
        String itemInfo2 = "id,25;name,安慕希可可;price,20.00;amount,3;";
        String itemInfos = itemInfo1 + itemInfo2;
        // 订单部分信息（对应attach附加信息）
        String message = username + remark + itemInfos;
        // 生成二维码并传入参数信息进行支付
        WXPay.unifiedOrder(message,"1",url);

    }

    /**
     * 测试用的方法
     * @param message 订单部分信息
     * @param total_fee 订单金额
     * @param url 回调域名
     */
    public static void testCreateQRCode (String message,String total_fee,String url){
        WXPay.unifiedOrder(message,total_fee,url);
    }

    /**
     * 将回调url域名写死，就调用此方法，
     * @param message 订单部分信息
     * @param total_fee 订单金额
     */
    public static void createQRCode (String message,String total_fee){
        System.out.println(message + "----------------2");
        WXPay.unifiedOrder(message,total_fee,"http://4s770d5857.qicp.vip:12275");
    }
}
