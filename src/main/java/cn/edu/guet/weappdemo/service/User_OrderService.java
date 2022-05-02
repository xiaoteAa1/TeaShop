package cn.edu.guet.weappdemo.service;

import cn.edu.guet.weappdemo.domain.Order;
import java.util.List;

/**
 * @author HHS
 * @date 2022/04/30 22:00
 */
public interface User_OrderService {
    // SELECT
    List<Order> getAll();
    List<Order> getOrdersByStatus(int status);

}
