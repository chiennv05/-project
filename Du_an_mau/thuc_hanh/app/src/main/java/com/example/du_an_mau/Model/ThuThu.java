package com.example.du_an_mau.Model;

public class ThuThu {
    String matt, hoten, matkhau;
    int quyen;

    public ThuThu(String matt, String hoten, String matkhau, int quyen) {
        this.matt = matt;
        this.hoten = hoten;
        this.matkhau = matkhau;
        this.quyen = quyen;
    }

    public String getMatt() {
        return matt;
    }

    public void setMatt(String matt) {
        this.matt = matt;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getQuyen() {
        return quyen;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
