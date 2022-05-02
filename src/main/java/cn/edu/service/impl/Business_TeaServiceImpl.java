package cn.edu.service.impl;

import cn.edu.dao.Business_TeaDao;
import cn.edu.dao.impl.Business_TeaDaoImpl;
import cn.edu.domain.Tea;
import cn.edu.service.Business_TeaService;

import java.util.List;

/**
 *@author  CCS/YJ
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

    @Override
    public Tea getTeaById(int id) {
        Tea teaById = businessTeaDao.getTeaById(id);
        return teaById;
    }

    @Override
    public Tea getTeaByName(String name) {
        Tea teaByName = businessTeaDao.getTeaByName(name);
        return teaByName;
    }

    @Override
    public List<Tea> getAllTeaByType(String type) {
        List<Tea> allTeaByType = businessTeaDao.getAllTeaByType(type);
        return allTeaByType;
    }

    @Override
    public List<Tea> getAllTeaOnSale() {
        List<Tea> allTeaOnSale = businessTeaDao.getAllTeaOnSale();
        return allTeaOnSale;
    }


}