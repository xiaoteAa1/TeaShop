package cn.edu.service.impl;

import cn.edu.dao.Business_AddTeaDao;
import cn.edu.dao.Business_TeaDao;
import cn.edu.dao.impl.Business_AddTeaDaoImpl;
import cn.edu.dao.impl.Business_TeaDaoImpl;
import cn.edu.domain.SingleTea;
import cn.edu.domain.Tea;
import cn.edu.service.Business_AddTeaSevice;
/**
 *@author  ZHH
 *@date    2022/04/30 14:08
 * @version 2.0
 */
public class Business_AddTeaServiceImpl implements Business_AddTeaSevice {
    Business_AddTeaDao businessAddTeaDao = new Business_AddTeaDaoImpl();
    /**
     * 新增奶茶
     * @param singleTea
     * @return
     */
    @Override
    public boolean addTea(SingleTea singleTea) {
        boolean addTea = businessAddTeaDao.addTea(singleTea);
        return addTea;
    }
}
