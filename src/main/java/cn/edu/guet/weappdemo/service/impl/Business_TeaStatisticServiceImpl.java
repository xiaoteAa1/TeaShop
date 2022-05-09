package cn.edu.guet.weappdemo.service.impl;

import cn.edu.guet.weappdemo.dao.Business_TeaStatisticDao;
import cn.edu.guet.weappdemo.dao.impl.Business_TeaStatisticDaoImpl;
import cn.edu.guet.weappdemo.domain.Tea;
import cn.edu.guet.weappdemo.service.Business_TeaStatisticService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HJK
 * @date 2022/05/01 19:00
 */
//查询奶茶的所有信息
public class Business_TeaStatisticServiceImpl implements Business_TeaStatisticService {

    Business_TeaStatisticDao business_teaStatisticDao=new Business_TeaStatisticDaoImpl();
    public List<Tea> getAllTea() {
        List<Tea> teaList = business_teaStatisticDao.getAllTea();

        return teaList;
    }

    @Override
    public void updateStatistic(int teaId, int sale) throws SQLException {
        business_teaStatisticDao.updateStatistic(teaId,sale);
    }


    public static void main(String[] args) {
        Business_TeaStatisticServiceImpl test = new Business_TeaStatisticServiceImpl();
        test.getAllTea();
    }



}
