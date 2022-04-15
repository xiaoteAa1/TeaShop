package cn.edu.dao;

import cn.edu.domain.Tea;

import java.util.List;

/*
    商家操作奶茶

    奶茶信息管理：
    增：添加新品种奶茶
    删：删除某一品种奶茶
    改：修改奶茶的某项信息
    查：查看指定内容相关的奶茶
 */
public interface Business_TeaDao {

    /*
        尝试将该奶茶添加进入数据库
    */
    boolean addTea(Tea tea);

    /*
        修改奶茶属性： 名称、图片、描述信息、备注信息、类型、价格
     */
    boolean updateTeaName(String name);
    boolean updateTeaImg(String url);
    boolean updateDescription(String description);
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
    List<Tea> getAllTeaByType(int type);
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
