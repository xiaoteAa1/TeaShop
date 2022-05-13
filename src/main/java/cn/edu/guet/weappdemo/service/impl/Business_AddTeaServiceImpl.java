package cn.edu.guet.weappdemo.service.impl;

import cn.edu.guet.weappdemo.dao.Business_AddTeaDao;

import cn.edu.guet.weappdemo.dao.impl.Business_AddTeaDaoImpl;

import cn.edu.guet.weappdemo.domain.SingleTea;
import cn.edu.guet.weappdemo.domain.Tea;
import cn.edu.guet.weappdemo.service.Business_AddTeaSevice;
import cn.edu.guet.weappdemo.util.ConnectionHandler;
import cn.edu.guet.weappdemo.util.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *@author  ZHH
 *@date    2022/04/30 14:08
 * @version 2.0
 */
public class Business_AddTeaServiceImpl implements Business_AddTeaSevice {
    Business_AddTeaDao businessAddTeaDao = new Business_AddTeaDaoImpl();
    Connection conn;
    /**
     * 新增奶茶
     * @param tea
     * @return
     */
    @Override
    public boolean addTea(Tea tea) throws SQLException {

//        conn= JDBCUtils.getConnection();
        conn = ConnectionHandler.getConn();

        //关闭mysql自动提交
        conn.setAutoCommit(false);

        /**
         * 将奶茶信息放入singletea实体类中
         */
        boolean addTea = businessAddTeaDao.addTea(new SingleTea(tea.getTeaId(),tea.getName()
                ,tea.getPrice(),tea.getType()
                ,tea.getIsSale(),tea.getRemark()));

        /**
         * 获取对应奶茶的id
         */
        int teaId = businessAddTeaDao.getTeaByName(tea.getName()).getTeaId();
        /**
         * 将count放入到库存表中
         */
        boolean addTeaStoreHouse = businessAddTeaDao.addTeaStoreHouse(teaId, tea.getCount());
        /**
         * 将sale放入到统计表中
         */
        boolean addTeaStatistics = businessAddTeaDao.addTeaStatistics(teaId, tea.getSales());


        /**
         * 加入事务
         */
        if (addTea && addTeaStoreHouse && addTeaStatistics){
            try {
                conn.commit();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            try {
                conn.rollback();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return addTea && addTeaStoreHouse &&addTeaStatistics;

    }



}
