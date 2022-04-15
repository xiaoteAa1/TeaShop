package cn.edu.domain;

import java.util.HashMap;
import java.util.List;

public class Tea {
    //----------------------必须属性-------------------------
    private int teaId;//奶茶编号
    private String name;//奶茶名称

    //----------------------非必须属性-----------------------
    private String image;//奶茶的图片url地址
    private String description = "暂无~";//对奶茶的描述信息
    private String remark = "暂无~";//对奶茶的备注信息
    private int type = 100;//奶茶类型type，用于对奶茶进行分类。如0：招牌奶茶 1：芒果家族 2：清爽果茶 ... 100：其他类型。默认为100。
    private double price;//奶茶价格

    //==标识属性==
    private boolean isSale;//是否可以销售
    private int remain;//奶茶剩余数量

    //==统计属性==
    private int sales;//奶茶销量
    private int daySales;//日销量
    private int monthSales;//月销量
    private int yearSales;//年销量


//    /*
//        假设商品价格 price = ，对应[半塘、小杯、正常]
//        {糖量：{[多糖,1]、[少糖,-1]、[半塘,0]}
//         份量：{[大杯,4]、[中杯,2]、[小杯,0]}
//         冰量：{[多冰,2],[少冰,-1],[正常,0]} }。
//         例：
//         [多糖，大杯，多冰] = 10+1+4+2 = 17
//         [半塘、小杯、正常] = 10+0+0+0 = 10
//         [多糖，中杯，少冰] = 10+1+2-1 = 12
//
//         //---------------------------------------------
//
//         {S1 : {[s11,p11],[s12,p12],[s13,p13],
//          S2 : {[s21,p21],[s22,p22],
//          S3 : {[s31,p31],[s32,p32],[s33,p33],[s34,p34]}
//
//        即：{
//            S(0)[0][j(0)] ,
//            S(1)[1][j(1)],
//            ...
//            S(i)[i][j(i)],
//            S(i+1)[i+1][j(i+1)],
//            ...
//            S(N)[N-1][j(N-1)]
//            }
//        初始的选择组合为每一行从左往右第一个为 j = 0 的值
//
//
//        假设List的长度不超过100
//     */
//    private HashMap<String,List<String[]>> map;//奶茶可选属性


    public Tea(String name) {
        this.name = name;
    }

    public Tea(String name, String image, String description, String remark, int type, double price) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.remark = remark;
        this.type = type;
        this.price = price;
    }

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getDaySales() {
        return daySales;
    }

    public void setDaySales(int daySales) {
        this.daySales = daySales;
    }

    public int getMonthSales() {
        return monthSales;
    }

    public void setMonthSales(int monthSales) {
        this.monthSales = monthSales;
    }

    public int getYearSales() {
        return yearSales;
    }

    public void setYearSales(int yearSales) {
        this.yearSales = yearSales;
    }
}