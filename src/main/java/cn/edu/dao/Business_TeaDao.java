package cn.edu.dao;

import cn.edu.domain.Tea;

import java.util.List;


/**
 *@author  LXJ
 *@date    2022/04/18 16:08
 */
public interface Business_TeaDao {

    /*
        尝试将该奶茶添加进入数据库
    */
    boolean addTea(Tea tea);

    /*
        修改奶茶属性： 名称、备注信息、类型、价格
     */
    boolean updateTeaName(String name);
    boolean updateRemark(String remark);
    boolean updateTeaType(int type);
    boolean updateTeaPrice(double price);


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
        尝试将指定id对应的奶茶删除
    */
    boolean deleteTea(int id);
}
