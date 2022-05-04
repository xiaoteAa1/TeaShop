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
    public List<Order> getAll() {
        return uod.getAll();
    }

    @Override
    public List<Order> getOrdersByStatus(int status) {
        return uod.getOrdersByStatus(status);
    }
}
