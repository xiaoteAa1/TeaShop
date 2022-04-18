package cn.edu.domain;

import java.util.Date;

public class Order {
    private int orderId;//订单编号
    private int userId;//用户编号(虚拟编号)
    private int teaId;//奶茶编号
    private Date startTime;//订单发起时间

    /*
        订单状态status
        0：正在制作奶茶
        1：订单已成功
        -1：订单失败
     */
    private int status;
    private String remark;

    public Order() {
    }
    public Order(int orderId, int userId, int teaId, Date startTime, int status, String remark) {
        this.orderId = orderId;
        this.userId = userId;
        this.teaId = teaId;
        this.startTime = startTime;
        this.status = status;
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
