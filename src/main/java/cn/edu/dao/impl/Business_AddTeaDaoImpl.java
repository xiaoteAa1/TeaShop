package cn.edu.dao.impl;

import cn.edu.dao.Business_AddTeaDao;
import cn.edu.domain.SingleTea;
import cn.edu.domain.Tea;
import cn.edu.util.JDBCUtils;

import java.sql.*;
/**
 *@author  ZHH
 *@date    2022/04/30 14:08
 * @version 2.0
 */
public class Business_AddTeaDaoImpl implements Business_AddTeaDao {

    Connection conn;
    Statement state;
    ResultSet rs;
    PreparedStatement preparedStatement;
    SingleTea singleTea=null;
    /**
     * 添加奶茶(奶茶名，奶茶种类，奶茶价格，奶茶备注，售卖情况)
     * @param singleTea
     * @return
     */
    @Override
    public boolean addTea(SingleTea singleTea) {


        try {
            conn = JDBCUtils.getConnection();
            String sql = "Insert Into tea (name,price,type,isSale,remark) " +
                    "Values (?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);


            preparedStatement.setString(1,singleTea.getName());
            preparedStatement.setString(2,singleTea.getRemark());
            preparedStatement.setString(3,singleTea.getType());
            preparedStatement.setDouble(4,singleTea.getPrice());
            preparedStatement.setInt(5,singleTea.getIsSale());

            int row= preparedStatement.executeUpdate();

            /**
             * 当row有数据时才能说明运行成功
             */
            if (row>0){
                return true;
            }else {
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs,state,conn);
        }

        return false;
    }
    /**
     * 根据奶茶名字寻找奶茶id
     * @param name
     * @return
     */
    @Override
    public SingleTea getTeaByName(String name) {

        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM tea WHERE name=?";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,name);


            rs= preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                double price = rs.getDouble("price");
                String type = rs.getString("type");
                int isSale = rs.getInt("isSale");
                String remark = rs.getString("remark");

                singleTea = new SingleTea(id,name,price,type,isSale,remark);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(rs,state,conn);
        }



        return singleTea;

    }


    /**
     * 将奶茶数量放进仓库表中
     * @param teaId
     * @param count
     * @return
     */
    @Override
    public boolean addTeaStoreHouse(int teaId,int count) {
        try {
            conn = JDBCUtil.getConnection();
            String sql = "Insert Into store (teaId, count) " +
                    "Values (?,?)";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1,teaId);
            preparedStatement.setInt(2,count);

            int row= preparedStatement.executeUpdate();

            /**
             * 当row有数据时才能说明运行成功
             */
            if (row>0){
                return true;
            }else {
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(rs,state,conn);
        }

        return false;
    }

    /**
     * 将奶茶放入统计表中
     * @param teaId
     * @param sale
     * @return
     */
    @Override
    public boolean addTeaStatistics(int teaId, int sale) {
        try {
            conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO statistic(teaId,sale) " +
                    "VALUES(?,?)";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1,teaId);
            preparedStatement.setInt(2,sale);

            int row= preparedStatement.executeUpdate();

            /**
             * 当row有数据时才能说明运行成功
             */
            if (row>0){
                return true;
            }else {
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(rs,state,conn);
        }

        return false;
    }


}
