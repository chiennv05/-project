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
public class Bicycle extends Xe{
    private String theLoai;

    public Bicycle(String theLoai, String ma, String ten, String hang, String mauSac, String bienSo, String trangThai, double gia, int odo) {
        super(ma, ten, hang, mauSac, bienSo, trangThai, gia, odo);
        this.theLoai = theLoai;
    }

    public Bicycle() {
    }

    
    public void nhap(){
        Scanner s = new Scanner(System.in);
           super.nhap();
        System.out.println("moi bn nhap the loai xe: ");
       theLoai = s.nextLine();
        System.out.println("nhap trang thai xe : ");
        super.setTrangThai(s.nextLine());
   }
    
   
    
}
