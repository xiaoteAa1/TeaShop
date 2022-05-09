package cn.edu.guet.weappdemo.service;

import cn.edu.guet.weappdemo.domain.Tea;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HJK
 * @date 2022/05/01 19:22
 */
public interface Business_TeaStatisticService {

    List<Tea> getAllTea();
    void updateStatistic (int teaId,int sale) throws SQLException;

}
