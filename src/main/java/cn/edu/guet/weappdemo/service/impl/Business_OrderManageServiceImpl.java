package cn.edu.guet.weappdemo.service.impl;
/*
 * @author  tlj
 * @date  2022/5/10 21:06
 */

import cn.edu.guet.weappdemo.dao.impl.Business_OrderDaoImpl;
import cn.edu.guet.weappdemo.domain.Order;
import cn.edu.guet.weappdemo.service.Business_OrderManageService;

import java.util.LinkedList;

public class Business_OrderManageServiceImpl implements Business_OrderManageService {
    public Business_OrderManageServiceImpl() {
    }
    //获得当前订单的数据
    @Override
    public Object[][] getCurrentOrder(){
        Order order=new Order();
        Business_OrderDaoImpl orderDao=new Business_OrderDaoImpl();
        LinkedList list=orderDao.getCurrentOrder();
        String[] index=getOrderColumnNames();
        Object[][] data=new Object[list.size()][index.length];
        //向data中添加数据
        for(int i=0;i<list.size();i++){
            order= (Order) list.get(i);
            data[i][0]=order.getId();
            data[i][1]=order.getMch_id();
            data[i][2]=order.getOut_trade_no();
            data[i][3]=order.getTransaction_id();
            data[i][4]=order.getStart_time();
            data[i][5]=order.getUsername();
            data[i][6]=order.getList();
            data[i][7]=order.getAmount();
            data[i][8]=order.getStatus();
            data[i][9]=order.getRemark();
        }
        return data;
    }

    //获得异常订单的数据
    @Override
    public Object[][] getWrongOrder() {
        Order order=new Order();
        Business_OrderDaoImpl orderDao=new Business_OrderDaoImpl();
        LinkedList list=orderDao.getWrongOrder();
        String[] index=getOrderColumnNames();
        Object[][] data=new Object[list.size()][index.length];
        //向data中添加数据
        for(int i=0;i<list.size();i++){
            order= (Order) list.get(i);
            data[i][0]=order.getId();
            data[i][1]=order.getMch_id();
            data[i][2]=order.getOut_trade_no();
            data[i][3]=order.getTransaction_id();
            data[i][4]=order.getStart_time();
            data[i][5]=order.getUsername();
            data[i][6]=order.getList();
            data[i][7]=order.getAmount();
            data[i][8]=order.getStatus();
            data[i][9]=order.getRemark();
        }
        return data;
    }

    //获得已完成的历史订单数据
    @Override
    public Object[][] getFinishOrder() {
        Order order=new Order();
        Business_OrderDaoImpl orderDao=new Business_OrderDaoImpl();
        LinkedList list=orderDao.getFinishOrder();
        String[] index=getOrderColumnNames();
        Object[][] data=new Object[list.size()][index.length];
        //向data中添加数据
        for(int i=0;i<list.size();i++){
            order= (Order) list.get(i);
            data[i][0]=order.getId();
            data[i][1]=order.getMch_id();
            data[i][2]=order.getOut_trade_no();
            data[i][3]=order.getTransaction_id();
            data[i][4]=order.getStart_time();
            data[i][5]=order.getUsername();
            data[i][6]=order.getList();
            data[i][7]=order.getAmount();
            data[i][8]=order.getStatus();
            data[i][9]=order.getRemark();
        }
        return data;
    }

    //获得列名
    @Override
    public String[] getOrderColumnNames() {
        String[] index={"订单编号","商户id","未知","事务id","开始时间","用户名",
                "订单列表","总金额","完成状态","备注"};
        return index;
    }
}
