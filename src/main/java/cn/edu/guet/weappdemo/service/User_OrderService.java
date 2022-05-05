package cn.edu.guet.weappdemo.service;

import cn.edu.guet.weappdemo.domain.Order;
import java.util.List;

/**
 * @author HHS
 * @date 2022/04/30 22:00
 */
public interface User_OrderService {
    // SELECT
    Order getOrderById(int id);
    Order getOrderByMchId(int mch_id);
    Order getOrderByOutTradeId(String out_trade_no);
    Order getOrderByTransactionId(String transaction_id);
    Order getOrderByUsername(String username);
    List<Order> getOrdersByStatus(int status);

    // SELECT ALL
    List<Order> getAll();

}
