package cn.edu.guet.weappdemo.dao;

import cn.edu.guet.weappdemo.domain.Tea;

import java.util.List;


/**

 *@author  CCS/YJ
 *@date    2022/04/18 16:08
 */
public interface Business_TeaDao {

    /*
        获得所有的奶茶
     */
    List<Tea> getAllTea();
    /*
        获取所有可销售的奶茶
     */
    List<Tea> getAllTeaOnSale();
    /*
        获取type类型对应的奶茶
     */
    List<Tea> getAllTeaByType(String type);
    /*
        通过奶茶名称获得单个奶茶对象
     */
    Tea getTeaByName(String name);
    /*
        通过奶茶id获得单个奶茶对象
     */
    Tea getTeaById(int id);

    /*
        修改奶茶信息
    */
    int updateTea(Tea t);

    /*
        删除奶茶信息
    */
    int deleteById(int id);
}
