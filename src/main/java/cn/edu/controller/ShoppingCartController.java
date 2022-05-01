package cn.edu.controller;

import cn.edu.domain.Order;
import cn.edu.service.OrderService;
import cn.edu.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author liwei
 * @Date 2021-08-04 11:28
 * @Version 1.0
 */
@RestController
@Slf4j
public class ShoppingCartController {
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
                String itemInfo = m.group(1);

                System.out.println(itemInfo + "aaa");
                String obj[] = itemInfo.split("#");
                System.out.println(Arrays.toString(obj) + "bbb");
//                ArrayList<String> item_list = new ArrayList<>();
                Map<String,String> item_list = new HashMap<>();
                double totalPrice = 0;
                StringBuffer teaList = new StringBuffer();
                int total_amount = 0;
                for (String item : obj) {
                    String tea [] = item.split(";");
                    System.out.println(Arrays.toString(tea) + "ccc");
                    String tea_id = tea[0].split(",")[1];
                    String tea_name = tea[1].split(",")[1];
                    String tea_price = tea[2].split(",")[1];
                    String tea_amount = tea[3].split(",")[1];
                    // 奶茶id和数量
                    item_list.put(String.valueOf(tea_id),String.valueOf(tea_amount));
                    // 奶茶数量累加
                    total_amount += Integer.parseInt(tea_amount);
                    // 订单列表
                    teaList.append(tea_name + " " + tea_amount + " ");
                    // 计算商品总价
                    totalPrice += Double.parseDouble(tea_price) * Integer.parseInt(tea_amount);
                }

                String mch_id = m.group(2);
                String orderNo = m.group(3);
                String orderTime = m.group(4);
                String transactionId = m.group(5);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                Timestamp timestamp = new Timestamp(sdf.parse(orderTime).getTime());

                Order order = new Order();
                String id = UUID.randomUUID().toString().replace("-", "");
//                order.setId(Integer.parseInt(id));//会自动生成32个字符
                order.setMch_id(Integer.parseInt(mch_id));
                order.setOut_trade_no(orderNo);
                order.setStart_time(timestamp);
                order.setTransaction_id(transactionId);
                order.setUsername("aa");
                order.setList(new String(teaList));
                order.setAmount(totalPrice);
                order.setStatus(1);
                order.setRemark("无");

                // 进行订单处理
                OrderService orderService = new OrderServiceImpl();
                // 将新的订单信息存入数据库
                orderService.newOrder(order, item_list);


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
