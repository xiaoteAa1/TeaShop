package cn.edu.guet.weappdemo.dao;
/*
 * @author  tlj
 * @date  2022/5/1 21:31
 */

public interface Business_UpdateDAO {
     //查询订单
     void SelectTea(int id,int mch_id,String out_trade_no,String transaction_id,
                       String start_time,String username,String list,double amount,
                       int status,String remark);

     //修改store表中的库存数量
     boolean UpdateTea(int id,int teaId,int count);

     //更新订单状态
     boolean updateTeaStatus(int status);

     //删除某个订单信息
     boolean DeleteTea(int id);
}

