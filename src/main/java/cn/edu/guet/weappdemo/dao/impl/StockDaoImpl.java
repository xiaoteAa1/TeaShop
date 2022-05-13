package cn.edu.guet.weappdemo.dao.impl;

import cn.edu.guet.weappdemo.dao.StockDao;
import cn.edu.guet.weappdemo.util.ConnectionHandler;
import cn.edu.guet.weappdemo.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *@author  TJH
 *@date    2022/05/01 16:08
 */
public class StockDaoImpl implements StockDao {
    @Override
    public void updateStock(int item_id, int stock) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionHandler.getConn();
            System.out.println("StockDaoImpl："+conn.hashCode());
//            String sql = "UPDATE store SET count=count-? WHERE teaId=?";
            String sql = "update store set count=count-?  WHERE teaId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, stock);
            pstmt.setInt(2, item_id);

            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new SQLException("库存更新失败");
        }
    }
}
