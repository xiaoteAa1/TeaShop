package cn.edu.dao;

import cn.edu.domain.Order;
import java.util.List;

/**
 * @author HHS
 * @date 2022/05/01 11:32
 */
public interface User_OrderDao {
    // SELECT
    Order getOrderById(int id);// 订单id
    Order getOrderByMchId(int mch_id);// 商户id
    Order getOrderByOutTradeId(String out_trade_id);
    Order getOrderByTransactionId(String transaction_id);// 交易id
    Order getOrderByUsername(String username);// 用户名
    List<Order> getOrdersByStatus(int status);// 订单状态

    //SELECT ALL
    List<Order> getAll();
}
