package cn.edu.guet.weappdemo.dao.impl;
/*
 * @author  tlj
 * @date  2022/5/1 21:34
 */


import cn.edu.guet.weappdemo.dao.Business_UpdateDAO;
import cn.edu.guet.weappdemo.domain.Order;
import cn.edu.guet.weappdemo.domain.Statistic;
import cn.edu.guet.weappdemo.domain.Tea;
import cn.edu.guet.weappdemo.util.JDBCUtils;

import java.sql.*;

public class Business_UpdateDaoImpl implements Business_UpdateDAO {
    Connection conn;
    PreparedStatement pstmt;

    //对订单修改页面返回的数据信息，更新数据库order表
    @Override
    public void setUpdateInformation(Order order) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "UPDATE `order_` set mch_id=?,out_trade_no=?,transaction_id=?,start_time=?,username=?,list=?,amount=?,status=?,remark=?"
                    +"WHERE id="+order.getId();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,order.getMch_id());
            pstmt.setString(2,order.getOut_trade_no());
            pstmt.setString(3,order.getTransaction_id());
            pstmt.setTimestamp(4,order.getStart_time());
            pstmt.setString(5,order.getUsername());
            pstmt.setString(6,order.getList());
            pstmt.setDouble(7,order.getAmount());
            pstmt.setInt(8,order.getStatus());
            pstmt.setString(9,order.getRemark());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
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
