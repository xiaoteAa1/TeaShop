package cn.edu.domain;

/**
 * tea store statistic表汇总的类
 */
public class Tea {
    private int teaId;//奶茶编号
    private String name;//奶茶名称
    private double price;//奶茶价格
    private String type;//奶茶类型
    private int isSale;//1表示可销售，0表示不销售，默认为1
    private String remark;//对奶茶的备注信息

    //==库存表属性==
    private int count;//奶茶剩余数量

    //==统计表属性==
    private int sales;//奶茶销量


    public Tea(){

    }

    public Tea(String name) {
        this.name = name;
    }

    public Tea(String name, String remark, String type, double price) {
        this.name = name;
        this.remark = remark;
        this.type = type;
        this.price = price;
    }

    public Tea(int teaId, String name, double price, String type, int isSale, String remark) {
        this.teaId = teaId;
        this.name = name;
        this.price = price;
        this.type = type;
        this.isSale = isSale;
        this.remark = remark;
    }

    public Tea(int teaId, String name, double price, String type, int isSale, String remark, int count, int sales) {
        this.teaId = teaId;
        this.name = name;
        this.price = price;
        this.type = type;
        this.isSale = isSale;
        this.remark = remark;
        this.count = count;
        this.sales = sales;
    }

    public int getIsSale() {
        return isSale;
    }

    public void setIsSale(int isSale) {
        this.isSale = isSale;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }


    @Override
    public String toString() {
        return "Tea{" +
                "teaId=" + teaId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isSale=" + isSale +
                ", remark='" + remark + '\'' +
                ", count=" + count +
                ", sales=" + sales +
                '}';
    }
}
