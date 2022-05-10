package cn.edu.guet.weappdemo.dao;
/*
 * @author  tlj
 * @date  2022/5/1 19:57
 */

import cn.edu.guet.weappdemo.domain.Order;

import java.util.LinkedList;

//将订单信息存入数据库
public interface Business_OrderDao {
    //当前未完成的订单查询,订单正在制作，还未完成，属性status=0
    LinkedList<Order> getCurrentOrder();

    //异常订单查询，订单失败，属性status=-1
    LinkedList<Order> getWrongOrder();

    //历史订单查询,订单成功并结束，属性status=1
    LinkedList<Order> getFinishOrder();
}
