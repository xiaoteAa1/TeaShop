package cn.edu.dao.impl;

import cn.edu.dao.Business_TeaDao;
import cn.edu.domain.Tea;

import java.util.List;

public class Business_TeaDaoImpl implements Business_TeaDao {
    @Override
    public boolean addTea(Tea tea) {
        return false;
    }

    @Override
    public boolean updateTeaName(String name) {
        return false;
    }

    @Override
    public boolean updateTeaImg(String url) {
        return false;
    }

    @Override
    public boolean updateDescription(String description) {
        return false;
    }

    @Override
    public boolean updateRemark(String remark) {
        return false;
    }

    @Override
    public boolean updateTeaType(int type) {
        return false;
    }

    @Override
    public boolean updateTeaPrice(double price) {
        return false;
    }

    @Override
    public List<Tea> getAllTea() {
        return null;
    }

    @Override
    public List<Tea> getAllTeaOnSale() {
        return null;
    }

    @Override
    public List<Tea> getAllTeaByType(int type) {
        return null;
    }

    @Override
    public Tea getTeaByName(String name) {
        return null;
    }

    @Override
    public Tea getTeaById(int id) {
        return null;
    }

    @Override
    public boolean deleteTea(int id) {
        return false;
    }
}
