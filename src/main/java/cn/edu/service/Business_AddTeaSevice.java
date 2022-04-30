package cn.edu.service;

import cn.edu.domain.SingleTea;
import cn.edu.domain.Tea;
/**
 *@author  ZHH
 *@date    2022/04/30 14:08
 * @version 2.0
 */
public interface Business_AddTeaSevice {
    /**
     * 新增奶茶
     * @param singleTea
     * @return
     */
    boolean addTea(SingleTea singleTea);
}
