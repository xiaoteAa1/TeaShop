package cn.edu.guet.weappdemo.service;

import cn.edu.guet.weappdemo.domain.Tea;

import java.sql.SQLException;

/**
 *@author  ZHH
 *@date    2022/04/30 14:08
 * @version 2.0
 */
public interface Business_AddTeaSevice {
    /**
     * 新增奶茶
     * @param tea
     * @return
     */
    boolean addTea(Tea tea) throws SQLException;

}
