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
public class Truck extends Xe{
    private String nhienLieu;
    private int choNgoi, trongTai;

   
    
    public void nhap(){
        Scanner s = new Scanner(System.in);
    super.nhap();
 System.out.print("Nhap bien so xe : ");
        super.setBienSo(s.nextLine());
        System.out.print("Nhap odo xe : ");
        super.setOdo(Integer.valueOf(s.nextLine()));
     
           System.out.println("moi bn chon nguyen lieu: xang, dien");
           nhienLieu = s.nextLine();
          
        
     
        System.out.println("moi bn nhap cho ngoi: ");
        choNgoi = s.nextInt();
        System.out.println("moi bn nhap trong tai: ");
        trongTai = s.nextInt();
                 
    }
    
   
        
        
    
}
