package cn.edu.guet.weappdemo.dao.impl;

import cn.edu.guet.weappdemo.dao.User_OrderDao;
import cn.edu.guet.weappdemo.domain.Order;
import cn.edu.guet.weappdemo.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HHS
 * @date 2022/05/01 11:37
 */
public class User_OrderDaoImpl implements User_OrderDao {
    Connection conn;
    PreparedStatement pstm;
    Statement stm;
    ResultSet rs;

    @Override
    public Order getOrderById(int id) {
        Order order = new Order();
        try {
            String sql = "SELECT * FROM order_ WHERE id = ?";

            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                order.setId(id);
                order.setMch_id(rs.getInt("mch_id"));
                order.setOut_trade_no(rs.getString("out_trade_no"));
                order.setTransaction_id(rs.getString("transaction_id"));
                order.setStart_time(rs.getTimestamp("start_time"));
                order.setUsername(rs.getString("username"));
                order.setList(rs.getString("list"));
                order.setAmount(rs.getDouble("amount"));
                order.setStatus(rs.getInt("status"));
                order.setRemark(rs.getString("remark"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(rs, stm, conn);
        }
        return order;
    }

    @Override
    public Order getOrderByMchId(int mch_id) {
        Order order = new Order();
        try {
            String sql = "SELECT * FROM order_ WHERE mch_id = ?";

            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, mch_id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                order.setId(rs.getInt("id"));
                order.setMch_id(mch_id);
                order.setOut_trade_no(rs.getString("out_trade_no"));
                order.setTransaction_id(rs.getString("transaction_id"));
                order.setStart_time(rs.getTimestamp("start_time"));
                order.setUsername(rs.getString("username"));
                order.setList(rs.getString("list"));
                order.setAmount(rs.getDouble("amount"));
                order.setStatus(rs.getInt("status"));
                order.setRemark(rs.getString("remark"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(rs, stm, conn);
        }
        return order;
    }

    @Override
    public Order getOrderByOutTradeId(String out_trade_no) {
        Order order = new Order();
        try {
            String sql = "SELECT * FROM order_ WHERE out_trade_no = ?";

            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, out_trade_no);
            rs = pstm.executeQuery();

            while (rs.next()) {
                order.setId(rs.getInt("id"));
                order.setMch_id(rs.getInt("mch_id"));
                order.setOut_trade_no(out_trade_no);
                order.setTransaction_id(rs.getString("transaction_id"));
                order.setStart_time(rs.getTimestamp("start_time"));
                order.setUsername(rs.getString("username"));
                order.setList(rs.getString("list"));
                order.setAmount(rs.getDouble("amount"));
                order.setStatus(rs.getInt("status"));
                order.setRemark(rs.getString("remark"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(rs, stm, conn);
        }
        return order;
    }

    @Override
    public Order getOrderByTransactionId(String transaction_id) {
        Order order = new Order();
        try {
            String sql = "SELECT * FROM order_ WHERE transaction_id = ?";

            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, transaction_id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                order.setId(rs.getInt("id"));
                order.setMch_id(rs.getInt("mch_id"));
                order.setOut_trade_no(rs.getString("out_trade_no"));
                order.setTransaction_id(transaction_id);
                order.setStart_time(rs.getTimestamp("start_time"));
                order.setUsername(rs.getString("username"));
                order.setList(rs.getString("list"));
                order.setAmount(rs.getDouble("amount"));
                order.setStatus(rs.getInt("status"));
                order.setRemark(rs.getString("remark"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(rs, stm, conn);
        }
        return order;
    }

    @Override
    public Order getOrderByUsername(String username) {
        Order order = new Order();
        try {
            String sql = "SELECT * FROM order_ WHERE username = ?";

            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            rs = pstm.executeQuery();

            while (rs.next()) {
                order.setId(rs.getInt("id"));
                order.setMch_id(rs.getInt("mch_id"));
                order.setOut_trade_no(rs.getString("out_trade_no"));
                order.setTransaction_id(rs.getString("transaction_id"));
                order.setStart_time(rs.getTimestamp("start_time"));
                order.setUsername(username);
                order.setList(rs.getString("list"));
                order.setAmount(rs.getDouble("amount"));
                order.setStatus(rs.getInt("status"));
                order.setRemark(rs.getString("remark"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(rs, stm, conn);
        }
        return order;
    }

    @Override
    public List<Order> getOrdersByStatus(int status) {
        List<Order> res = new ArrayList<>();
        try {
            String sql = "SELECT * FROM order_ WHERE status = ?";

            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, status);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int mch_id = rs.getInt("mch_id");
                String out_trade_no = rs.getString("out_trade_no");
                String transaction_no = rs.getString("transaction_id");
                Timestamp start_time = rs.getTimestamp("start_time");
                String username = rs.getString("username");
                String list = rs.getString("list");
                double amount = rs.getDouble("amount");
                String remark = rs.getString("remark");

                Order order = new Order(id, mch_id, out_trade_no, transaction_no, start_time, username, list, amount, status, remark);
                res.add(order);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(rs, stm, conn);
        }
        return res;
    }

    @Override
    public List<Order> getAll() {
        List<Order> res = new ArrayList<>();
        try {
            String sql = "SELECT * FROM order_";

            conn = JDBCUtils.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                int mch_id = rs.getInt("mch_id");
                String out_trade_no = rs.getString("out_trade_no");
                String transaction_no = rs.getString("transaction_id");
                Timestamp start_time = rs.getTimestamp("start_time");
                String username = rs.getString("username");
                String list = rs.getString("list");
                double amount = rs.getDouble("amount");
                int status = rs.getInt("status");
                String remark = rs.getString("remark");

                Order order = new Order(id, mch_id, out_trade_no, transaction_no, start_time, username, list, amount, status, remark);
                res.add(order);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(rs, stm, conn);
        }
        return res;
    }
}
