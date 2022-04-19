package cn.edu.dao.impl;

import cn.edu.dao.Business_TeaDao;
import cn.edu.domain.Tea;
import cn.edu.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        return null;
    }

    @Override
    public List<Tea> getAllTeaByType(int type) {
        return null;
    }

    @Override
    public Tea getTeaByName(String name) {
        return null;
    }

    @Override
    public Tea getTeaById(int id) {
        return null;
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
