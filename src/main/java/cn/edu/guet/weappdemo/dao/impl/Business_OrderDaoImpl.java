package cn.edu.guet.weappdemo.dao.impl;
/*
 * @author  tlj
 * @date  2022/5/1 20:05
 */

import cn.edu.guet.weappdemo.dao.Business_OrderDao;
import cn.edu.guet.weappdemo.domain.Order;
import cn.edu.guet.weappdemo.util.JDBCUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

//将订单信息存入数据库
public class Business_OrderDaoImpl implements Business_OrderDao {
    Connection conn;
    ResultSet rs;
    PreparedStatement pstmt;

    public static void main(String[] args) {
        LinkedList<Order> currentOrder = new Business_OrderDaoImpl().getCurrentOrder();
        System.out.println(currentOrder);
    }

    //订单管理模块中查询当前正在制作的订单信息,order表中属性status=0
    @Override
    public LinkedList<Order> getCurrentOrder() {
        //使用list存储数据
        LinkedList<Order> list = new LinkedList<>();
        try {
            //调用JDBCUtils类中的getConnection()方法进行数据库连接
            conn = JDBCUtils.getConnection();
            String sql = "SELECT*FROM `order` WHERE status=0";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Order order=new Order();
                order.setId(rs.getInt("id"));
                order.setMch_id(rs.getInt("mch_id"));
                order.setOut_trade_no(rs.getString("out_trade_no"));
                order.setTransaction_id(rs.getString("transaction_id"));
                order.setStart_time(rs.getTimestamp("start_time"));
                order.setUsername(rs.getString("username"));
                order.setList(rs.getString("list"));
                order.setAmount(rs.getDouble("amount"));
                order.setStatus(rs.getInt("status"));
                order.setRemark(rs.getString("remark"));
                list.add(order);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    //查询异常订单的信息，属性status=-1
    @Override
    public LinkedList<Order> getWrongOrder() {
        LinkedList<Order> list = new LinkedList<>();
        try {
            //调用JDBCUtils类中的getConnection()方法进行数据库连接
            conn = JDBCUtils.getConnection();
            String sql = "SELECT*FROM `order` WHERE status=-1";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Order order=new Order();
                order.setId(rs.getInt("id"));
                order.setMch_id(rs.getInt("mch_id"));
                order.setOut_trade_no(rs.getString("out_trade_no"));
                order.setTransaction_id(rs.getString("transaction_id"));
                order.setStart_time(rs.getTimestamp("start_time"));
                order.setUsername(rs.getString("username"));
                order.setList(rs.getString("list"));
                order.setAmount(rs.getDouble("amount"));
                order.setStatus(rs.getInt("status"));
                order.setRemark(rs.getString("remark"));
                list.add(order);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    //查询历史订单信息，即已制作完成且结束的订单，属性status=1
    @Override
    public LinkedList<Order> getFinishOrder() {
        LinkedList<Order> list = new LinkedList<>();
        try {
            //调用JDBCUtils类中的getConnection()方法进行数据库连接
            conn = JDBCUtils.getConnection();
            String sql = "SELECT*FROM `order` WHERE status=1";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Order order=new Order();
                order.setId(rs.getInt("id"));
                order.setMch_id(rs.getInt("mch_id"));
                order.setOut_trade_no(rs.getString("out_trade_no"));
                order.setTransaction_id(rs.getString("transaction_id"));
                order.setStart_time(rs.getTimestamp("start_time"));
                order.setUsername(rs.getString("username"));
                order.setList(rs.getString("list"));
                order.setAmount(rs.getDouble("amount"));
                order.setStatus(rs.getInt("status"));
                order.setRemark(rs.getString("remark"));
                list.add(order);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


}
