package data.dto;

import java.sql.Timestamp;

public class ShopDto {
    private String shopidx;
    private String sname;
    private int scount;
    private int sprice;
    private String scolor;
    private String sphoto;
    private Timestamp writeday;

    public ShopDto(String sname, int scount, int sprice, String scolor, String sphoto) {
        this.sname = sname;
        this.scount = scount;
        this.sprice = sprice;
        this.scolor = scolor;
        this.sphoto = sphoto;
    }

    public ShopDto() {
        super();
    }

    public int getSprice() {
        return sprice;
    }

    public void setSprice(int sprice) {
        this.sprice = sprice;
    }

    public String getShopidx() {
        return shopidx;
    }

    public void setShopidx(String shopidx) {
        this.shopidx = shopidx;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getScount() {
        return scount;
    }

    public void setScount(int scount) {
        this.scount = scount;
    }

    public String getScolor() {
        return scolor;
    }

    public void setScolor(String scolor) {
        this.scolor = scolor;
    }

    public String getSphoto() {
        return sphoto;
    }

    public void setSphoto(String sphoto) {
        this.sphoto = sphoto;
    }

    public Timestamp getWriteday() {
        return writeday;
    }

    public void setWriteday(Timestamp writeday) {
        this.writeday = writeday;
    }
}
