package cn.edu.guet.weappdemo.dao;

import cn.edu.guet.weappdemo.domain.Tea;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HJK
 * @date 2022/05/01 11:32
 */
public interface Business_TeaStatisticDao {

    List<Tea> getAllTea();
    void updateStatistic (int teaId,int sale);

}
