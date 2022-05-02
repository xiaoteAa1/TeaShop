package cn.edu.guet.weappdemo.dao;

import java.sql.SQLException;

/**
 * 操作库存表
 * 接口只规定能做什么
 */
/**
 * @author TJH
 * @date 2022/05/01 11:32
 */
public interface StockDao {
    /*
    更新哪个商品的库存？
    更新的数量是多少？
     */
    void updateStock(int item_id, int stock) throws SQLException;
}
