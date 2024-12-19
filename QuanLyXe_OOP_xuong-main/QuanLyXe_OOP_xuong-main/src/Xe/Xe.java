/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Xe;

import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Xe {
    private String ma, ten, hang, mauSac, bienSo, trangThai;
    private double gia;
    private Integer odo;

    public Xe(String ma, String ten, String hang, String mauSac, String bienSo, String trangThai, double gia, int odo) {
        this.ma = ma;
        this.ten = ten;
        this.hang = hang;
        this.mauSac = mauSac;
        this.bienSo = bienSo;
        this.trangThai = trangThai;
        this.gia = gia;
        this.odo = odo;
    }

    public Xe() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getOdo() {
        return odo;
    }

    public void setOdo(int odo) {
        this.odo = odo;
    }
    
      public String checkStatus() {
        String tinhTrangXe = "";
        if (odo==null) {
            if (odo < 200) {
                tinhTrangXe = "Xe moi";
            } else if (odo <= 8000) {
                tinhTrangXe = "Xe luot moi";
            } else if (odo <= 100000) {
                tinhTrangXe = "Xe cu tot";
            } else if (odo <= 150000) {
                tinhTrangXe = "Xe cu kha";
            } else if (odo > 150000) {
                tinhTrangXe = "Xe qua cu";
            }
        } else {
            tinhTrangXe = getTrangThai();
        }
        return tinhTrangXe;
    }
    
    public void nhap(){
        Scanner s = new Scanner(System.in);
        System.out.println("moi bn nhap ma xe: ");
        ma = s.nextLine();
         System.out.println("moi bn nhap ten xe: ");
        ten = s.nextLine();
         System.out.println("moi bn nhap hang xe: ");
        hang = s.nextLine();
         System.out.println("moi bn nhap gia xe: ");
        gia = s.nextDouble();
            s.nextLine();
         System.out.println("moi bn nhap mau sac xe: ");
        mauSac = s.nextLine();
    
        
         s.nextLine();
    
    }
    
    public void xuat(){
        System.out.printf("ma xe la: %s | ten xe la: %s | hang xe la: %s\ngia la: %.2f\nmau sac la: %s\n", this.ma,this.ten,this.hang,this.gia,this.mauSac);
    
    }
}
