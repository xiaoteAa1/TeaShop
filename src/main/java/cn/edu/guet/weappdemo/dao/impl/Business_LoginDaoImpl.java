package cn.edu.guet.weappdemo.dao.impl;

import cn.edu.guet.weappdemo.dao.Business_LoginDao;
import cn.edu.guet.weappdemo.util.ConnectionHandler;
import cn.edu.guet.weappdemo.util.JDBCUtils;

import java.sql.*;

public class Business_LoginDaoImpl implements Business_LoginDao {
    Connection conn;
    Statement sta;
    PreparedStatement psta;
    ResultSet rs;
    @Override
    public boolean login(String username, String password) {
        try {
            String sql = "SELECT COUNT(*) cnt FROM user WHERE username=? AND password=?";
            conn = ConnectionHandler.getConn();
            psta = conn.prepareStatement(sql);
            psta.setString(1,username);
            psta.setString(2,password);

            rs = psta.executeQuery();
            while(rs.next()){
                int cnt = rs.getInt("cnt");
                return cnt > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ConnectionHandler.closeConnection();
                JDBCUtils.close(rs,psta,null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

}
