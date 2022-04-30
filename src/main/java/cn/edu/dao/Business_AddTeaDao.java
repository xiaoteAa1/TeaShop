package cn.edu.dao;

import cn.edu.domain.SingleTea;
import cn.edu.domain.Tea;

/**
 *@author  ZHH
 *@date    2022/04/30 14:08
 * @version 2.0
 */
public interface Business_AddTeaDao {
    /*
        尝试将该奶茶添加进入数据库
    */
    boolean addTea(SingleTea singleTea);
}
