package cn.edu.guet.weappdemo.service;

import cn.edu.guet.weappdemo.domain.Tea;

import java.util.List;

/**
 *@author  CCS/YJ
 *@date    2022/04/18 16:08
 */
public interface Business_TeaService {
    List<Tea> getAllTea();
    Tea getTeaById(int id);
    Tea getTeaByName(String name);
    List<Tea> getAllTeaByType(String type);
    List<Tea> getAllTeaOnSale();
    int updateTea(Tea t);
    int deleteById(int id);
}
