package cn.edu.guet.weappdemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandler {

    public static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static Connection getConn() throws SQLException {
        /*
        为了保证OrderDaoImpl和StockDaoImpl中的Connection是同一个，我们做如下处理
         */
        Connection conn=threadLocal.get();
        /*
        null说明什么？
         */
        if(conn==null){
            String user = "root";
            String dbPassword = "lxj123456";
            String url = "jdbc:mysql://120.79.223.83:3306/teaShop2?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
            conn = DriverManager.getConnection(url, user, dbPassword);
            threadLocal.set(conn);
        }
        return conn;
    }
    public static void closeConnection() throws SQLException {
        Connection conn=threadLocal.get();
        if(conn!=null){
            conn.close();
            threadLocal.remove();
        }
    }
}
