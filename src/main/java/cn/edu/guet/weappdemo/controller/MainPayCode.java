package cn.edu.guet.weappdemo.controller;

import cn.edu.guet.weappdemo.controller.user.ShoppingCartController;

/**
 * @Author: tjh
 * @Date: 2022/05/02/0:27
 * @Description: 调用微信付款码支付
 */
public class MainPayCode {
    public static void main(String[] args) throws Exception {
       /* String itemMessage = "username,tai极;remark,无:id,26;name,芝芝乳品;price,18.00;amount,2#id,25;name,安慕希可可;price,20.00;amount,3;";
        ShoppingCartController.newOrderPaymentCode("134341834360647441",itemMessage,"1");*/


    }

    /**
     *
     * @param auth_cod 付款码id
     * @param message 部分订单信息
     * @param total_fee 订单金额
     */
    public static void payCode (String auth_cod,String message,String total_fee) throws Exception {
        ShoppingCartController.newOrderPaymentCode(auth_cod,message,total_fee);
    }

}
