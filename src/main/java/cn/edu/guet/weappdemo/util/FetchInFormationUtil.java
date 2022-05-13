package cn.edu.guet.weappdemo.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: tjh
 * @Date: 2022/05/02/10:53
 * @Description: 解析订单信息字符串，返回相应信息
 */
public class FetchInFormationUtil {

    /**
     *
     * @param idList 商品id和对应的购买量
     * @return 返回map形式的商品id和对应的购买量
     */
    public static Map<String,String> getIdAmount (String idList){
        System.out.println(idList + "------getIdAmount");
        // 获取不同商品id和对应的购买量
        String[] idAmount = idList.split(";");
        Map<String,String> item_list = new HashMap<>();
        for (String id_list : idAmount){
            String[] idAndList = id_list.split(",");
            item_list.put(idAndList[0], idAndList[1]);
        }
        System.out.println(item_list + "---------item_list");
        return item_list;
    }

    /**
     *
     * @param itemMessage 部分订单信息
     * @return 解析该部分订单信息，并返回部分订单信息列表
     */
    public static List<String> getInformationFromItemMessage (String itemMessage){
        System.out.println(itemMessage);
        List<String> list = new ArrayList<>();
        // 分别获取用户信息与订单信息
        String [] usrAndItemInfo = itemMessage.split(":");
        String [] userInfo = usrAndItemInfo[0].split(";");
        // 从用户信息里获取用户名和备注
        String username = userInfo[0].split(",")[1];
        String remark = userInfo[1].split(",")[1];

        // 获取订单信息
        String obj[] = usrAndItemInfo[1].split("#");
        // 商品id和对应的购买量
        StringBuffer id_amount = new StringBuffer();
        // 订单金额
        double totalPrice = 0;
        // 订单列表
        StringBuffer teaList = new StringBuffer();
        for (String item : obj) {
            // 开始获取部分订单信息
            String tea[] = item.split(";");
            String tea_id = tea[0].split(",")[1];
            String tea_name = tea[1].split(",")[1];
            String tea_price = tea[2].split(",")[1];
            String tea_amount = tea[3].split(",")[1];
            // 奶茶id和数量
            id_amount.append(tea_id + "," + tea_amount + ";");
            // 订单列表
            teaList.append(tea_name + " " + tea_amount + " ");
            // 计算商品总价
            totalPrice += Double.parseDouble(tea_price) * Integer.parseInt(tea_amount);
        }
        // 将获取的订单信息加入到list
        list.add(username);
        list.add(remark);
        list.add(new String (id_amount));
        list.add(new String (teaList));
        list.add(String.valueOf(totalPrice));
        System.out.println(list + "-----list");
        return list;
    }
}
