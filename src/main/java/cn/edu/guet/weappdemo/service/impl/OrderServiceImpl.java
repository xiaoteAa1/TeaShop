package cn.edu.guet.weappdemo.service.impl;

import cn.edu.guet.weappdemo.dao.OrderDao;
import cn.edu.guet.weappdemo.dao.StockDao;
import cn.edu.guet.weappdemo.dao.impl.OrderDaoImpl;
import cn.edu.guet.weappdemo.dao.impl.StockDaoImpl;
import cn.edu.guet.weappdemo.domain.Order;
import cn.edu.guet.weappdemo.service.OrderService;
import cn.edu.guet.weappdemo.util.JDBCUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author TJH
 * @date 2022/04/30 22:00
 */
public class OrderServiceImpl implements OrderService {


    @Override
    public void newOrder(Order order, Map<String,String> item_id_list) {
        Connection conn = null;
        try {
            OrderDao orderDao = new OrderDaoImpl();
            StockDao stockDao = new StockDaoImpl();

            conn = JDBCUtils.getConnection();
            System.out.println("OrderService：" + conn.hashCode());
            //开启事务（必须先有Connection）
            conn.setAutoCommit(false);

            orderDao.newOrder(order);

            Set<String> sets = item_id_list.keySet();
            Iterator<String> iter = sets.iterator();
            while(iter.hasNext()){
                String item_id = iter.next();
                String amount = item_id_list.get(item_id);
                stockDao.updateStock(Integer.parseInt(item_id), Integer.parseInt(amount));
            }

            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                conn.rollback();
                System.out.println("事务回滚.................................................");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
//            try {
////                JDBCUtils.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }

    }
}
