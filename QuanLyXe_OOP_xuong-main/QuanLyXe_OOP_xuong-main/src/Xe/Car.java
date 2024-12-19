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
public class Car extends Xe{
    private String dongCo;
    private int door, choNgoi;

    public Car(String dongCo, int door, int choNgoi, String ma, String ten, String hang, String mauSac, String bienSo, String trangThai, double gia, int odo) {
        super(ma, ten, hang, mauSac, bienSo, trangThai, gia, odo);
        this.dongCo = dongCo;
        this.door = door;
        this.choNgoi = choNgoi;
    }

   

   
  

    public Car() {
    }

   
    @Override
    public void nhap(){
        Scanner s = new Scanner(System.in);
    super.nhap();
        System.out.println("moi bn nhap bien so: ");
    super.setBienSo(s.nextLine());
        System.out.println("nhap odo xe : ");
        super.setOdo(Integer.valueOf(s.nextInt()));
    
                 s.nextLine();
        System.out.println("moi bn chon nguyen lieu: xang, dau, dien");
        dongCo = s.nextLine();
          
       
        System.out.println("moi bn nhap so door: ");
        door = s.nextInt();
        System.out.println("moi bn nhap cho ngoi: ");
        choNgoi = s.nextInt();
   }
    
    
}
