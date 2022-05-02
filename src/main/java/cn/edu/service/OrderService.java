package cn.edu.service;

import cn.edu.domain.Order;

import java.util.Map;

/**
 * @author TJH
 * @date 2022/05/01 14:00
 */
public interface OrderService {
    void newOrder (Order order, Map<String,String> item_id_list);
}
