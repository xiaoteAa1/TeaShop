package cn.edu.guet.weappdemo.dao.impl;

import cn.edu.guet.weappdemo.dao.User_AddCar;
import cn.edu.guet.weappdemo.domain.CarTea;
import cn.edu.guet.weappdemo.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WGJ
 * @date 2022/05/03 12:32
 */
public class User_AddCarImpl implements User_AddCar {
    Connection conn;
    Statement sta;
    PreparedStatement psta;
    ResultSet rs;

    @Override
    public List<CarTea> getTea() {
        try {
            List<CarTea> list = new ArrayList<>();

            String sql = "select t.*,IFNULL(s.count,0) count,IFNULL(sta.sale,0) sale from tea t left join \n" +
                    "store s on t.id=s.teaId left join statistic sta on t.id=sta.teaId";

            conn = JDBCUtils.getConnection();
            sta = conn.createStatement();
            rs = sta.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String type = rs.getString("type");
                int isSale = rs.getInt("isSale");
                String remark = rs.getString("remark");
                int count = rs.getInt("count");
                int sale = rs.getInt("sale");

                CarTea tea = new CarTea(id, name, price, type);
                list.add(tea);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.close(rs, sta, conn);
        }
    }

    @Override
    public boolean addTea(CarTea carTea) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "Insert Into cartea (id,name,price)"+" Values (?,?,?)";
            psta=conn.prepareStatement(sql);
            psta.setInt(1,carTea.getTeaId());
            psta.setString(2,carTea.getName());
            psta.setDouble(3,carTea.getPrice());

            int row = psta.executeUpdate();

            if(row>0){
                return  true;
            }else {
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs, sta, conn);
        }

        return false;
    }

    @Override
    public List<CarTea> getCarTea() {
        try {
            List<CarTea> list = new ArrayList<>();

            String sql = "select name,count(*) count,price*count(*) price from cartea group by name,price";

            conn = JDBCUtils.getConnection();
            sta = conn.createStatement();
            rs = sta.executeQuery(sql);
            int ordinal=1;

            while (rs.next()) {
                int id =ordinal;
                String name = rs.getString("name");
                int count =rs.getInt("count");
                double price = rs.getDouble("price");
                ordinal++;


                CarTea tea = new CarTea(id,name,count,price);
                list.add(tea);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.close(rs, sta, conn);
        }
    }

    // 多加一个获取购物车商品方法，为了获取teaid
    @Override
    public List<CarTea> getCarTea1() {
        try {
            List<CarTea> list = new ArrayList<>();

//            String sql = "select name,count(*) count,price*count(*) price from cartea group by name,price";
            String sql = "select id,name,count(*) count,price*count(*) price from cartea group by name,price,id";

            conn = JDBCUtils.getConnection();
            sta = conn.createStatement();
            rs = sta.executeQuery(sql);
            int ordinal=1;

            while (rs.next()) {
                int id =ordinal;
                String teaId = rs.getString("id");
                String name = rs.getString("name");
                int count =rs.getInt("count");
                double price = rs.getDouble("price");
                ordinal++;

                CarTea tea = new CarTea(Integer.parseInt(teaId),id,name,count,price);
//                CarTea tea = new CarTea(id,name,count,price);
                list.add(tea);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.close(rs, sta, conn);
        }
    }

    @Override
    public double getSumPrice() {
        double price = 0;
        try {
            String sql = "select SUM(price) from cartea";

            conn = JDBCUtils.getConnection();
            sta = conn.createStatement();
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                price = rs.getDouble("SUM(price)");
            }

            return price;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            JDBCUtils.close(rs, sta, conn);
        }
          return price;
    }

    @Override
    public boolean deleteTea(CarTea carTea) {
        try {
            String sql ="delete \n" +
                    "from cartea\n" +
                    "where name=? limit ?";
            conn=JDBCUtils.getConnection();
            psta =conn.prepareStatement(sql);
            psta.setString(1,carTea.getName());
            psta.setInt(2,carTea.getCount());
            int row=psta.executeUpdate();
            if(row>0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}

