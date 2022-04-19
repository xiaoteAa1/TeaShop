package cn.edu.dao.impl;

import cn.edu.dao.Business_AddTeaDao;
import cn.edu.domain.Tea;
import cn.edu.util.JDBCUtil;

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
            conn = JDBCUtil.getConnection();
            String sql = "Insert Into tea (name,remark,type,price,remain,isSale,sales,daySales,monthSales,yearSales) " +
                    "Values (?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,tea.getName());
            preparedStatement.setString(2,tea.getRemark());
            preparedStatement.setString(3,tea.getType());
            preparedStatement.setDouble(4,tea.getPrice());
            preparedStatement.setInt(5,tea.getRemain());
            preparedStatement.setInt(6,tea.getIsSale());
            preparedStatement.setInt(7,tea.getSales());
            preparedStatement.setInt(8,tea.getDaySales());
            preparedStatement.setInt(9,tea.getMonthSales());
            preparedStatement.setInt(10,tea.getYearSales());

            int row= preparedStatement.executeUpdate();

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
