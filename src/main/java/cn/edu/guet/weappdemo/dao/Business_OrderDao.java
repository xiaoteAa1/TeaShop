package cn.edu.guet.weappdemo.dao;
/*
 * @author  tlj
 * @date  2022/5/1 19:57
 */

//将订单信息存入数据库
public interface Business_OrderDao {
    void newOrder(int id,int mch_id,String out_trade_no,String transaction_id,
                  String start_time,String username,String list,double amount,
                  int status,String remark);
}
