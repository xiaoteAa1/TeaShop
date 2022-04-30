package cn.edu.dao.impl;

import cn.edu.dao.Business_AddTeaDao;
import cn.edu.domain.SingleTea;
import cn.edu.domain.Tea;
import cn.edu.util.JDBCUtil;

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
    /**
     * 添加奶茶
     * @param singleTea
     * @return
     */
    @Override
    public boolean addTea(SingleTea singleTea) {


        try {
            conn = JDBCUtil.getConnection();
            String sql = "Insert Into tea (name,remark,type,price,isSale) " +
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
            JDBCUtil.close(rs,state,conn);
        }

        return false;
    }

}
