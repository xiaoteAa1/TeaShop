package cn.edu.guet.weappdemo.dao.impl;
/*
 * @author  tlj
 * @date  2022/5/1 20:05
 */

import cn.edu.guet.weappdemo.dao.Business_OrderDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//将订单信息存入数据库
public class Business_OrderDaoImpl implements Business_OrderDao {
    @Override
    public void newOrder(int id,int mch_id,String out_trade_no,String transaction_id,
                         String start_time,String username,String list,double amount,
                         int status,String remark) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        try{
            String sql="INSERT INTO order VALUES(?,?,?,?,?,?,?,?,?,?)";
            String user="root";
            String dbPassword="lxj123456";
            String url="jdbc:mysql://120.79.223.83/teashop2?characterEncoding=utf-8&rewriteBatchedStatement=true";

            conn= DriverManager.getConnection(url,user,dbPassword);
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.setInt(2,mch_id);
            pstmt.setString(3,out_trade_no);
            pstmt.setString(4,transaction_id);
            pstmt.setString(5,start_time);
            pstmt.setString(6,username);
            pstmt.setString(7,list);
            pstmt.setDouble(8,amount);
            pstmt.setInt(9,status);
            pstmt.setString(10,remark);

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

    }



}
