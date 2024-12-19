package com.nhom3.bduan1.models;

public class ThongBaoModels {
    int id;
    String tieuDe;
    String chiTiet;
    String ngay;

    public ThongBaoModels() {
    }

    public ThongBaoModels(int id, String tieuDe, String chiTiet, String ngay) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.chiTiet = chiTiet;
        this.ngay = ngay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
}