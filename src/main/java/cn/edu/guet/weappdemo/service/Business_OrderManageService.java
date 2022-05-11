package cn.edu.guet.weappdemo.service;
/*
 * @author  tlj
 * @date  2022/5/10 21:06
 */

public interface Business_OrderManageService {
    //获得当前订单的数据，并将数据存在object[][]中
    Object[][] getCurrentOrder();

    //获得异常订单的信息，并将数据存在object[][]中
    Object[][] getWrongOrder();

    //获得已完成的历史订单的信息，并将数据存在object[][]中
    Object[][] getFinishOrder();

    //获得二维表的列名,被controller层调用
    String[] getOrderColumnNames();
}
