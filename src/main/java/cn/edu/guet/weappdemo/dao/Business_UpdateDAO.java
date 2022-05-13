package cn.edu.guet.weappdemo.dao;
/*
 * @author  tlj
 * @date  2022/5/1 21:31
 */

import cn.edu.guet.weappdemo.domain.Order;

public interface Business_UpdateDAO {
     //将修改订单页面的数据读取，并更新数据库的order表
     void setUpdateInformation(Order order);
     // 获取订单id，修改订单状态
     void updateStatus (String id);
}

