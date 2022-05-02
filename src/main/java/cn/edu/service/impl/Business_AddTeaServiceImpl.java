package cn.edu.service.impl;

import cn.edu.dao.Business_AddTeaDao;
import cn.edu.dao.impl.Business_AddTeaDaoImpl;
import cn.edu.domain.Tea;
import cn.edu.service.Business_AddTeaSevice;

/**
 *@author   ZHH
 *@date    2022/04/19 16:08
 */
public class Business_AddTeaServiceImpl implements Business_AddTeaSevice {
    Business_AddTeaDao businessAddTeaDao = new Business_AddTeaDaoImpl();
    /**
     * 新增奶茶
     * @param tea
     * @return
     */
    @Override
    public boolean addTea(Tea tea) {
        boolean addTea = businessAddTeaDao.addTea(tea);
        return addTea;
    }
}
