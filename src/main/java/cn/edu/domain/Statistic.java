package cn.edu.domain;
/*
 * @author  tlj
 * @date  2022/5/1 22:24
 */

public class Statistic {
    private int id;//库存id
    private int teaid;//奶茶id
    private int sales;//总销售

    public Statistic(int id) {
        this.id = id;
    }

    public Statistic() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeaid() {
        return teaid;
    }

    public void setTeaid(int teaid) {
        this.teaid = teaid;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "id=" + id +
                ", teaid=" + teaid +
                ", sales=" + sales +
                '}';
    }
}

