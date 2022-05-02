package cn.edu.domain;

public class CarTea {

    private int teaId;//奶茶编号
    private String name;//奶茶名称
    private double price;//奶茶价格
    private String type;//奶茶类型


    public CarTea() {
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
