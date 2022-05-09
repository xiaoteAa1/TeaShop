package cn.edu.guet.weappdemo.dao.impl;

import cn.edu.guet.weappdemo.dao.Business_TeaStatisticDao;
import cn.edu.guet.weappdemo.domain.Tea;
import cn.edu.guet.weappdemo.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *@author  HJK
 *@date    2022/05/01 16:08
 */
public class Business_TeaStatisticDaoImpl implements Business_TeaStatisticDao {

    Connection conn;
    PreparedStatement pstm;
    Statement sta;
    ResultSet rs;

    //======================返回返回多条记录====================



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

    /**
     * 更新统计表
     * @param teaId 商品id
     * @param sale 商品销售量
     * @throws SQLException
     */
    @Override
    public void updateStatistic(int teaId,int sale) throws SQLException{
        String sql = "UPDATE statistic SET sale = sale + ? WHERE teaid = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,sale);
            pstm.setInt(2,teaId);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("更新统计表失败");
        }
    }
}
