package cn.edu.service.impl;

import cn.edu.domain.Order;
import cn.edu.dao.User_OrderDao;
import cn.edu.dao.impl.User_OrderDaoImpl;
import cn.edu.service.User_OrderService;

import java.util.List;

/**
 * @author HHS
 * @date 2022/05/01 14:37
 */
public class User_OrderServiceImpl implements User_OrderService {
    User_OrderDao uod = new User_OrderDaoImpl();

    @Override
    public List<Order> getAll() {
        return uod.getAll();
    }

    @Override
    public List<Order> getOrdersByStatus(int status) {
        return uod.getOrdersByStatus(status);
    }
}
