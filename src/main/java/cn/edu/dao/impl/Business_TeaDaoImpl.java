package cn.edu.dao.impl;

import cn.edu.dao.Business_TeaDao;
import cn.edu.domain.Tea;
import cn.edu.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *@author  LXJ
 *@date    2022/04/18 16:08
 */
public class Business_TeaDaoImpl implements Business_TeaDao {

    Connection conn;
    Statement state;
    ResultSet rs;

    public static void main(String[] args) {
        new Business_TeaDaoImpl().getAllTea();
    }

    /*
        获得所有奶茶信息
     */
    @Override
    public List<Tea> getAllTea() {
        List<Tea> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tea";
            conn = JDBCUtil.getConnection();
            state = conn.createStatement();

            rs = state.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String remark = rs.getString("remark");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int isSale = rs.getInt("isSale");
                int remain = rs.getInt("remain");

                int sales = rs.getInt("sales");
                int daySales = rs.getInt("daySales");
                int monthSales = rs.getInt("monthSales");
                int yearSales = rs.getInt("yearSales");

                Tea tea = new Tea(id,name,remark,type,price,isSale,remain,sales,daySales,monthSales,yearSales);
                list.add(tea);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(rs,state,conn);
        }

        return list;
    }


    @Override
    public List<Tea> getAllTeaOnSale() {

        List<Tea> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tea where isSale = 1";
            conn = JDBCUtil.getConnection();
            state = conn.createStatement();

            rs = state.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String remark = rs.getString("remark");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int remain = rs.getInt("remain");
                int isSale = rs.getInt("isSale");
                int sales = rs.getInt("sales");
                int daySales = rs.getInt("daySales");
                int monthSales = rs.getInt("monthSales");
                int yearSales = rs.getInt("yearSales");

                Tea tea = new Tea(id,name,remark,type,price,isSale,remain,sales,daySales,monthSales,yearSales);
                list.add(tea);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(rs,state,conn);
        }

        return list;
    }

    @Override
    public List<Tea> getAllTeaByType(String ByType) {
        List<Tea> li = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Tea tea = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select * from tea where type = ?");
            ps.setString(1,ByType);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String remark = rs.getString("remark");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int remain = rs.getInt("remain");
                int sales = rs.getInt("sales");
                int isSale = rs.getInt("isSale");
                int daySales = rs.getInt("daySales");
                int monthSales = rs.getInt("monthSales");
                int yearSales = rs.getInt("yearSales");
                tea = new Tea(id,name,remark,type,price,isSale,remain,sales,daySales,monthSales,yearSales);
                li.add(tea);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(rs,state,conn);
        }
        return li;
    }

    @Override
    public Tea getTeaByName(String ByName) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Tea tea = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select * from tea where name = ?");
            ps.setString(1,ByName);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String remark = rs.getString("remark");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int remain = rs.getInt("remain");
                int isSale = rs.getInt("isSale");
                int sales = rs.getInt("sales");
                int daySales = rs.getInt("daySales");
                int monthSales = rs.getInt("monthSales");
                int yearSales = rs.getInt("yearSales");
                tea = new Tea(id,name,remark,type,price,isSale,remain,sales,daySales,monthSales,yearSales);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(rs,state,conn);
        }
        return tea;
    }

    @Override
    public Tea getTeaById(int Byid) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Tea tea = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select * from tea where id = ?");
            ps.setInt(1,Byid);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String remark = rs.getString("remark");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int remain = rs.getInt("remain");
                int sales = rs.getInt("sales");
                int isSale = rs.getInt("isSale");
                int daySales = rs.getInt("daySales");
                int monthSales = rs.getInt("monthSales");
                int yearSales = rs.getInt("yearSales");
                tea = new Tea(id,name,remark,type,price,isSale,remain,sales,daySales,monthSales,yearSales);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(rs,state,conn);
        }
//        return new Tea(12,"酸菜炒大肠","不加糖谢谢","不知道",98.8,
//                10,4,1,2,12);
        return tea;
    }


    @Override
    public boolean addTea(Tea tea) {
        return false;
    }

    @Override
    public boolean updateTeaName(String name) {
        return false;
    }

    @Override
    public boolean updateRemark(String remark) {
        return false;
    }

    @Override
    public boolean updateTeaType(int type) {
        return false;
    }

    @Override
    public boolean updateTeaPrice(double price) {
        return false;
    }



    @Override
    public boolean deleteTea(int id) {
        return false;
    }
}
