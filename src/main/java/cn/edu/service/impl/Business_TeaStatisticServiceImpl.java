package cn.edu.service.impl;

import cn.edu.dao.Business_TeaStatisticDao;
import cn.edu.dao.impl.Business_TeaStatisticDaoImpl;
import cn.edu.domain.Tea;
import cn.edu.service.Business_TeaStatisticService;

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



    public static void main(String[] args) {
        Business_TeaStatisticServiceImpl test = new Business_TeaStatisticServiceImpl();
        test.getAllTea();
    }



}
