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
public class MoTorbike extends Xe{
    private String dongCo;
    private int maLuc;

    public MoTorbike(String dongCo, int maLuc, String ma, String ten, String hang, String mauSac, String bienSo, String trangThai, double gia, int odo) {
        super(ma, ten, hang, mauSac, bienSo, trangThai, gia, odo);
        this.dongCo = dongCo;
        this.maLuc = maLuc;
    }

    public MoTorbike() {
    }

   

    
    
    public void nhap(){
        Scanner s = new Scanner(System.in);
    super.nhap();
     System.out.print("Nhap bien so xe : ");
        super.setBienSo(s.nextLine());
        System.out.print("Nhap odo xe : ");
        super.setOdo(Integer.valueOf(s.nextLine()));
               
           System.out.println("moi bn chon nguyen lieu: xang, dien");
           dongCo = s.nextLine();
         

        System.out.println("moi bn nhap ma luc : ");
        maLuc =s.nextInt();
    
    }
    
            
           
    
}
