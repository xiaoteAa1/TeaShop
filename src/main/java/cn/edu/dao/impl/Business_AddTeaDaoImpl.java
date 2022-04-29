package cn.edu.dao.impl;

import cn.edu.dao.Business_AddTeaDao;
import cn.edu.domain.Tea;
import cn.edu.util.JDBCUtils;

import java.sql.*;
/**
 *@author   ZHH
 *@date    2022/04/19 16:08
 */
public class Business_AddTeaDaoImpl implements Business_AddTeaDao {

    Connection conn;
    Statement state;
    ResultSet rs;
    PreparedStatement preparedStatement;
    /**
     * 添加奶茶
     * @param tea
     * @return
     */
    @Override
    public boolean addTea(Tea tea) {


        try {
            conn = JDBCUtils.getConnection();
            String sql = "Insert Into tea (name,price,type,isSale,remark) " +
                    "Values (?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,tea.getName());
            preparedStatement.setDouble(2,tea.getPrice());
            preparedStatement.setString(3,tea.getType());
            preparedStatement.setInt(4,tea.getIsSale());
            preparedStatement.setString(5,tea.getRemark());


            int row= preparedStatement.executeUpdate();

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

}
