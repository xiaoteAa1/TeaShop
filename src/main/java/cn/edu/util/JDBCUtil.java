package cn.edu.util;

import java.sql.*;

/*
JDBC工具类
*目的：简化书写
*分析：1、注册驱动也抽取
        2、抽取一个方法获取连接对象
            需求：不想传递参数（麻烦），还得保证工具类的通用性
            解决：配置文件,创建一个文件名,文件后缀名需要为"properities"
            driverClass=com.mysql.jdbc.Driver
                url=
                user=
                passwrod=
 */
public class JDBCUtil {
    private static String url = "jdbc:mysql://120.79.223.83:3306/teaShop?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static String user = "root";
    private static String password = "lxj123456";
    private static String driver;

    //获取连接对象
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    public static void close(ResultSet rs, Statement stm, Connection con){
        //资源释放
        if(stm !=null){
            try {
                stm.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }if(con !=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }if(rs !=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

