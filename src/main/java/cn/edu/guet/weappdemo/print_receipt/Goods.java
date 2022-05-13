package cn.edu.guet.weappdemo.print_receipt;

public class Goods {
    private String gname; //商品名称
    private String price; //商品单价
    private String num; //商品数量
    private String total; //小计
    private String beiZhu; //备注

    public String getBeiZhu() {
        return beiZhu;
    }

    public void setBeiZhu(String beiZhu) {
        this.beiZhu = beiZhu;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gname='" + gname + '\'' +
                ", price='" + price + '\'' +
                ", num='" + num + '\'' +
                ", total='" + total + '\'' +
                ", beiZhu='" + beiZhu + '\'' +
                '}';
    }

    public Goods() {
    }


    public Goods(String gname, String price, String num, String total, String beiZhu) {
        this.gname = gname;
        this.price = price;
        this.num = num;
        this.total = total;
        this.beiZhu = beiZhu;
    }

    public String getGname() {
        return gname;
    }


    public void setGname(String gname) {
        this.gname = gname;
    }


    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
    }


    public String getNum() {
        return num;
    }


    public void setNum(String num) {
        this.num = num;
    }


    public String getTotal() {
        return total;
    }


    public void setTotal(String total) {
        this.total = total;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gname == null) ? 0 : gname.hashCode());
        result = prime * result + ((num == null) ? 0 : num.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((total == null) ? 0 : total.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Goods other = (Goods) obj;
        if (gname == null) {
            if (other.gname != null)
                return false;
        } else if (!gname.equals(other.gname))
            return false;
        if (num == null) {
            if (other.num != null)
                return false;
        } else if (!num.equals(other.num))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (total == null) {
            if (other.total != null)
                return false;
        } else if (!total.equals(other.total))
            return false;
        return true;
    }
}
