package cn.edu.guet.weappdemo.dao.impl;

import cn.edu.guet.weappdemo.dao.OrderDao;
import cn.edu.guet.weappdemo.domain.Order;
import cn.edu.guet.weappdemo.util.ConnectionHandler;
import cn.edu.guet.weappdemo.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *@author  TJH
 *@date    2022/05/01 16:08
 */
public class OrderDaoImpl implements OrderDao {
    @Override
    public void newOrder(Order order) throws SQLException {
        Connection conn=null;
        try {
            conn= ConnectionHandler.getConn();
            System.out.println("OrderDaoImpl："+conn.hashCode());
            String sql="INSERT INTO order_ (mch_id,out_trade_no,transaction_id,start_time,username,list,amount,status,remark) " +
                    "VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,order.getMch_id());
            pstmt.setString(2,order.getOut_trade_no());
            pstmt.setString(3,order.getTransaction_id());
            pstmt.setTimestamp(4,order.getStart_time());
            pstmt.setString(5,order.getUsername());
            pstmt.setString(6,order.getList());
            pstmt.setDouble(7,order.getAmount());
            pstmt.setInt(8,order. getStatus());
            pstmt.setString(9,order.getRemark());

            pstmt.executeUpdate();//真正执行sql语句

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new SQLException("新增订单失败");
        }
    }
}
