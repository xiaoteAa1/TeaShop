package cn.edu.guet.weappdemo.service.impl;

import cn.edu.guet.weappdemo.dao.Business_TeaDao;
import cn.edu.guet.weappdemo.dao.impl.Business_TeaDaoImpl;
import cn.edu.guet.weappdemo.domain.Tea;
import cn.edu.guet.weappdemo.service.Business_TeaService;


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

    @Override
    public Tea getTeaById(int id) {
        Tea teaById = businessTeaDao.getTeaById(id);
        return teaById;
    }
//
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

    @Override
    public int updateTea(Tea t) {
        int i = businessTeaDao.updateTea(t);
        return i;
    }

    @Override
    public int deleteById(int id) {
        int i = businessTeaDao.deleteById(id);
        return i;
    }
}
