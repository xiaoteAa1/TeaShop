package cn.edu.dao;

import cn.edu.domain.Tea;

/**
 *@author   ZHH
 *@date    2022/04/19 16:08
 */
public interface Business_AddTeaDao {
    /*
        尝试将该奶茶添加进入数据库
    */
    boolean addTea(Tea tea);
}
