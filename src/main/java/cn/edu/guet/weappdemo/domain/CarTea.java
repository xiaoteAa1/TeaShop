package cn.edu.guet.weappdemo.domain;

public class CarTea {

    private int id;
    private int count;
    private int teaId;//奶茶编号
    private String name;//奶茶名称
    private double price;//奶茶价格
    private String type;//奶茶类型

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarTea() {
    }

    public CarTea(int id, String name, int count, double price) {
        this.id =id;
        this.name=name;
        this.count=count;
        this.price=price;
    }

    // 新增购物车奶茶构造方法，多加了teaId
    public CarTea(int teaId,int id, String name, int count, double price) {
        this.teaId = teaId;
        this.id =id;
        this.name=name;
        this.count=count;
        this.price=price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CarTea(int teaId, String name, double price, String type) {
        this.teaId = teaId;
        this.name = name;
        this.price = price;
        this.type = type;

    }

    public CarTea(int teaId, String name, double price) {
        this.teaId = teaId;
        this.name = name;
        this.price = price;
    }

    public CarTea(String name, int count, double price) {

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CarTea{" +
                "teaId=" + teaId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
