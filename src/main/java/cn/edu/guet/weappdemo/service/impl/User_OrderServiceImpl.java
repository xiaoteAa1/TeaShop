package cn.edu.guet.weappdemo.service.impl;

import cn.edu.guet.weappdemo.domain.Order;
import cn.edu.guet.weappdemo.dao.User_OrderDao;
import cn.edu.guet.weappdemo.dao.impl.User_OrderDaoImpl;
import cn.edu.guet.weappdemo.service.User_OrderService;

import java.util.List;

/**
 * @author HHS
 * @date 2022/05/01 14:37
 */
public class User_OrderServiceImpl implements User_OrderService {
    User_OrderDao uod = new User_OrderDaoImpl();

    @Override
    public Order getOrderById(int id) {
        return uod.getOrderById(id);
    }

    @Override
    public Order getOrderByMchId(int mch_id) {
        return uod.getOrderByMchId(mch_id);
    }

    @Override
    public Order getOrderByOutTradeId(String out_trade_no) {
        return uod.getOrderByOutTradeId(out_trade_no);
    }

    @Override
    public Order getOrderByTransactionId(String transaction_id) {
        return uod.getOrderByTransactionId(transaction_id);
    }

    @Override
    public Order getOrderByUsername(String username) {
        return uod.getOrderByUsername(username);
    }

    @Override
    public List<Order> getAll() {
        return uod.getAll();
    }

    @Override
    public List<Order> getOrdersByStatus(int status) {
        return uod.getOrdersByStatus(status);
    }
}
