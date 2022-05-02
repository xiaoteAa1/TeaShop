package cn.edu.dao;

import cn.edu.domain.SingleTea;
import cn.edu.domain.Tea;

/**
 *@author  ZHH
 *@date    2022/04/30 14:08
 * @version 2.0
 */
public interface Business_AddTeaDao {
    /**
     将奶茶添加进入数据库
     */
    boolean addTea(SingleTea singleTea);

    /**
     * 根据奶茶名字寻找奶茶id
     * @param name
     * @return
     */
    SingleTea getTeaByName(String name);

    /**
     * 将奶茶放入仓库中
     * @param teaId
     * @param count
     * @return
     */
    boolean addTeaStoreHouse(int teaId,int count);

    /**
     * 将奶茶放入统计表中
     * @param teaId
     * @param sale
     * @return
     */
    boolean addTeaStatistics(int teaId,int sale);
}
