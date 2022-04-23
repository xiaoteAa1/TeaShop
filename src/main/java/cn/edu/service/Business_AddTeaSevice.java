package cn.edu.service;

import cn.edu.domain.Tea;
/**
 *@author   ZHH
 *@date    2022/04/19 16:08
 */
public interface Business_AddTeaSevice {
    /**
     * 新增奶茶
     * @param tea
     * @return
     */
    boolean addTea(Tea tea);
}
