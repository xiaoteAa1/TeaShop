package cn.edu.service;

import cn.edu.domain.Order;

import java.util.Map;


public interface OrderService {
    void newOrder (Order order, Map<String,String> item_id_list);
}
