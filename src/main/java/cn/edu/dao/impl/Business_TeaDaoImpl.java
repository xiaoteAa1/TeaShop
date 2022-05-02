package cn.edu.dao.impl;

import cn.edu.dao.Business_TeaDao;
import cn.edu.domain.Tea;
import cn.edu.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *@author  LXJ
 *@date    2022/04/18 16:08
 */
public class Business_TeaDaoImpl implements Business_TeaDao {

    Connection conn;
    Statement sta;
    PreparedStatement psta;
    ResultSet rs;

    public static void main(String[] args) {
        new Business_TeaDaoImpl().getAllTea();
    }

    /*
        获得所有奶茶信息
     */
    @Override
    public List<Tea> getAllTea() {
        try {
            List<Tea> list = new ArrayList<>();

            String sql ="select t.*,IFNULL(s.count,0) count,IFNULL(sta.sale,0) sale from tea t left join \n" +
                    "store s on t.id=s.teaId left join statistic sta on t.id=sta.teaId";

            conn = JDBCUtils.getConnection();
            sta = conn.createStatement();
            rs = sta.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String type = rs.getString("type");
                int isSale = rs.getInt("isSale");
                String remark = rs.getString("remark");
                int count = rs.getInt("count");
                int sale = rs.getInt("sale");

                Tea tea = new Tea(id,name,price,type,isSale,remark,count,sale);
                list.add(tea);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtils.close(rs, sta,conn);
        }
    }


    @Override
    public List<Tea> getAllTeaOnSale() {
        List<Tea> res = new ArrayList<>();
        List<Tea> list = getAllTea();
        for(Tea t:list){
            if(t.getIsSale() == 1){
                res.add(t);
            }
        }
        return res;
    }

    @Override
    public List<Tea> getAllTeaByType(String ByType) {
        List<Tea> res = new ArrayList<>();
        List<Tea> list = getAllTea();
        for(Tea t:list){
            if(t.getType().equals(ByType)){
                res.add(t);
            }
        }
        return res;
    }

    @Override
    public Tea getTeaByName(String ByName) {
        try {
            String sql = "SELECT t.*,s.count,st.sale FROM tea t,store s,statistic st WHERE t.name=? AND s.teaId=t.id AND st.teaId=t.id";
            conn = JDBCUtils.getConnection();
            psta = conn.prepareStatement(sql);
            psta.setString(1,ByName);

            rs = psta.executeQuery();

            Tea tea = new Tea();
            while (rs.next()){
                int id = rs.getInt("id");
                double price = rs.getDouble("price");
                String type = rs.getString("type");
                int isSale = rs.getInt("isSale");
                String remark = rs.getString("remark");
                int count = rs.getInt("count");
                int sale = rs.getInt("sale");

                tea = new Tea(id,ByName,price,type,isSale,remark,count,sale);
                tea.setCount(count);
            }
            return tea;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtils.close(rs, psta,conn);
        }
    }

    @Override
    public Tea getTeaById(int Byid) {
        try {
            String sql = "SELECT t.*,s.count,st.sale FROM tea t,store s,statistic st WHERE t.id=? AND s.teaId=? AND st.teaId=?";
            conn = JDBCUtils.getConnection();
            psta = conn.prepareStatement(sql);
            psta.setInt(1,Byid);
            psta.setInt(2,Byid);
            psta.setInt(3,Byid);

            rs = psta.executeQuery();

            Tea tea = new Tea();
            while (rs.next()){
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String type = rs.getString("type");
                int isSale = rs.getInt("isSale");
                String remark = rs.getString("remark");
                int count = rs.getInt("count");
                int sale = rs.getInt("sale");

                tea = new Tea(Byid,name,price,type,isSale,remark,count,sale);
                tea.setCount(count);
            }
            return tea;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtils.close(rs, psta,conn);
        }
    }

}