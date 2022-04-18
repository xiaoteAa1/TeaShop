package cn.edu.domain;

public class Tea {
    private int teaId;//奶茶编号
    private String name;//奶茶名称
    private String remark;//对奶茶的备注信息
    private String type;//奶茶类型
    private double price;//奶茶价格

    //==标识属性==
    private int remain;//奶茶剩余数量

    //==统计属性==
    private int sales;//奶茶销量
    private int daySales;//日销量
    private int monthSales;//月销量
    private int yearSales;//年销量

    public Tea(String name) {
        this.name = name;
    }

    public Tea(String name, String remark, String type, double price) {
        this.name = name;
        this.remark = remark;
        this.type = type;
        this.price = price;
    }

    public Tea(int teaId, String name, String remark, String type, double price, int remain, int sales, int daySales, int monthSales, int yearSales) {
        this.teaId = teaId;
        this.name = name;
        this.remark = remark;
        this.type = type;
        this.price = price;
        this.remain = remain;
        this.sales = sales;
        this.daySales = daySales;
        this.monthSales = monthSales;
        this.yearSales = yearSales;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "Tea{" +
                "teaId=" + teaId +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", remain=" + remain +
                ", sales=" + sales +
                ", daySales=" + daySales +
                ", monthSales=" + monthSales +
                ", yearSales=" + yearSales +
                '}';
    }



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
}