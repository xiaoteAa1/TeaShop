package cn.edu.controller;

import cn.edu.guet.weappdemo.pay.WXPay;

public class MainPayCode {
    public static void main(String[] args) {
        String url = "http://4s770d5857.qicp.vip/result";
        String message = "id,26;name,芝芝乳品;price,18.00;amount,2#id,25;name,安慕希可可;price,20.00;amount,3;";
        WXPay.unifiedOrder(message,18,url);
    }
}
