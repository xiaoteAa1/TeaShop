package cn.edu.service.impl;

import cn.edu.dao.Business_TeaDao;
import cn.edu.dao.impl.Business_TeaDaoImpl;
import cn.edu.domain.Tea;
import cn.edu.service.Business_TeaService;

import java.util.List;

/**
 *@author  LXJ
 *@date    2022/04/18 16:08
 */
public class Business_TeaServiceImpl implements Business_TeaService {
    Business_TeaDao businessTeaDao = new Business_TeaDaoImpl();


    /*
        获取所有奶茶信息
     */
    @Override
    public List<Tea> getAllTea() {

        List<Tea> tea = businessTeaDao.getAllTea();

        return tea;
    }
}
