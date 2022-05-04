package cn.edu.guet.weappdemo.dao.impl;
/*
 * @author  tlj
 * @date  2022/5/1 21:34
 */


import cn.edu.guet.weappdemo.dao.Business_UpdateDAO;
import cn.edu.guet.weappdemo.domain.Order;
import cn.edu.guet.weappdemo.domain.Statistic;
import cn.edu.guet.weappdemo.domain.Tea;

import java.sql.*;

public class Business_UpdateDaoImpl implements Business_UpdateDAO {
    @Override
    //查询订单所有详细信息
    public void SelectTea(int id, int mch_id, String out_trade_no, String transaction_id,
                   String start_time, String username, String list, double amount,
                   int status, String remark) {
        ResultSet rs = null;
        Connection conn=null;
        PreparedStatement pstmt=null;
        try{
            String user="root";
            String dbPassword="lxj123456";
            String url="jdbc:mysql://120.79.223.83/teashop2?characterEncoding=utf-8&rewriteBatchedStatement=true";
            conn= DriverManager.getConnection(url,user,dbPassword);
            String sql="SELECT*FROM order";
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                rs.getInt(1);
                rs.getInt(2);
                rs.getString(3);
                rs.getString(4);
                rs.getString(5);
                rs.getString(6);
                rs.getString(7);
                rs.getDouble(8);
                rs.getInt(9);
                rs.getString(10);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //修改store中的库存订单
    @Override
    public boolean UpdateTea(int id,int teaId,int count) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        Order order=new Order();
        Tea tea=new Tea();
        Statistic statistic=new Statistic();
        try{
            String user="root";
            String dbPassword="lxj123456";
            String url="jdbc:mysql://120.79.223.83/teashop2?characterEncoding=utf-8&rewriteBatchedStatement=true";
            conn= DriverManager.getConnection(url,user,dbPassword);
            String sql="UPDATE store set count=? WHERE id=?,teaId=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(2, order.getId());
            pstmt.setInt(3, tea.getTeaId());
            pstmt.setInt(1, count-statistic.getSales());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    //修改奶茶订单状态
    @Override
    public boolean updateTeaStatus(int status) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        Order order=new Order();
        try {
            String user = "root";
            String dbPassword = "lxj123456";
            String url = "jdbc:mysql://120.79.223.83/teashop2?characterEncoding=utf-8&rewriteBatchedStatement=true";
            conn= DriverManager.getConnection(url,user,dbPassword);
            String sql = "UPDATE order set status=? WHERE id=?,username=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(2,order.getId());
            pstmt.setString(3,order.getUsername());

            //有疑问如何判断奶茶是否做完？
            if(true){
                //订单成功并结束
                order.setStatus(1);
                pstmt.setInt(1,order.getStatus());
            }else  if(false){
                //订单进行中
                order.setStatus(0);
                pstmt.setInt(1,order.getStatus());
            }else{
                //订单失败
                order.setStatus(-1);
                pstmt.setInt(1,order.getStatus());
            }
            pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    //从order表中删除某个订单信息
    @Override
    public boolean DeleteTea(int id) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        Order order=new Order();
        try {
            String user = "root";
            String dbPassword = "lxj123456";
            String url = "jdbc:mysql://120.79.223.83/teashop2?characterEncoding=utf-8&rewriteBatchedStatement=true";
            conn= DriverManager.getConnection(url,user,dbPassword);
            String sql = "DELETE*FROM order WHERE id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,order.getId());
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
