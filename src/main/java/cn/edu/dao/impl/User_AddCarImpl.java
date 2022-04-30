package cn.edu.dao.impl;

import cn.edu.dao.User_AddCar;
import cn.edu.domain.CarTea;
import cn.edu.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

            String sql = "SELECT * FROM `cartea`";

            conn = JDBCUtils.getConnection();
            sta = conn.createStatement();
            rs = sta.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");


                CarTea tea = new CarTea(id, name, price);
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
}
