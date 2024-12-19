/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Xe;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
        import java.util.Comparator;
/**
 *
 * @author Asus
 */
public class Quan_Ly_Xe {
    ArrayList<Xe> list = new ArrayList<>();
    Scanner s = new Scanner(System.in);
            
    public void nhap(){

        do {            
            System.out.print("1. Car , 2. MotorBike, 3. Bicycle, 4. Bus, 5. Truck :");
            int chon = s.nextInt();
            switch (chon) {
                case 1:
                    Car c = new Car();
                    c.nhap();
                    list.add(c);
                    break;
                     case 2:
                    MoTorbike m = new MoTorbike();
                    m.nhap();
                    list.add(m);
                    break;
                     case 3:
                    Bicycle b = new Bicycle();
                    b.nhap();
                    list.add(b);
                    break;
                     case 4:
                    Bus q = new Bus();
                    q.nhap();
                    list.add(q);
                    break;
                     case 5:
                    Truck t = new Truck();
                    t.nhap();
                    list.add(t);
                    break;
                     
                default:
                    System.out.println("moi bn chon lai:");
            }
            
            System.out.println("bn co muon nhap tiep khong :\n1. yes\n0. no");
            int tiep = s.nextInt();
            if(tiep==0){
                break;
            
            
            }
            
           
            
            
            
        } while (true);
    
    
    
    }
    
    public void xuat(){
        for (Xe x : list) {
            x.xuat();
        }
    
    }
    
    public void timKiem(){
        s.nextLine();
        System.out.println("moi bn nhap ma xe can tim kiem: ");
        String ma = s.nextLine();
         System.out.println("--------------- Thong tin xe muon tim ---------------");
        for (Xe item : list) {
            if(item.getMa().equalsIgnoreCase(ma)){
                item.xuat();
                break;
                
            
            
            }
            System.out.println("ma xe ban can tim k co: ");
        }
    
    
    }
    
    public void xoa(){
           s.nextLine();
        System.out.println("moi bn nhap ma xe muon xoa: ");
        String ma = s.nextLine();
        for (Xe item : list) {
            if(item.getMa().equalsIgnoreCase(ma)){
                list.remove(item);
                break;
            
            }
        }
        xuat();
    
    
    }
    
    public void capNhat(){
           s.nextLine();
        System.out.println("moi bn nhap ma xe muon cap nhat: ");
    String ma = s.nextLine();
        for (Xe xe : list) {
            if (xe.getMa().equalsIgnoreCase(ma) ) {
                xe.nhap();
                xe.xuat();
                break;
            }
            System.out.println("khong co ma bn muon nhap: ");
        }
    }
    
      public void timTheoKhoangGia(){
             s.nextLine();
        System.out.println("--- Nhap vao khoang gia ban muon tim ---");
        System.out.print("Nhap min gia :");
        double giaMin = Double.parseDouble(s.nextLine());
        System.out.print("Nhap vao max gia :");
        double giaMax = Double.parseDouble(s.nextLine());
        System.out.println("--- Danh sach xe co muc gia ban muon tim ---");
        for (Xe xe : list) {
            if(xe.getGia() >= giaMin && xe.getGia() <= giaMax){
                xe.xuat();
            }
        }
    }
    // sap xep theo ten
    public  void sapXepTheoTen(){
        Comparator<Xe> comp = (Xe o1, Xe o2) -> o1.getTen().compareTo(o2.getTen());
        Collections.sort(list,comp);
        System.out.println("---- Danh sach xe sap xep theo ten ----");
        xuat();
    }
    // sap xep theo gia
    public void sapXepTheoGia(){
       Comparator<Xe> comp = new Comparator<Xe>() {
           @Override
           public int compare(Xe o1, Xe o2) {
               return o1.getGia().compareTo(o2.getGia());
           }
       };
       Collections.sort(list, comp);
       xuat();
    }
    // sap xep theo gia cach 2
    public void sapXepTheoGia_C2(){
        Comparator<Xe> comp = (Xe o1, Xe o2) -> {
            if(o1.getGia() < o2.getGia()){
                return 1;
            }
            return -1;
        };
        Collections.sort(list,comp);
    }
    // top 5 xe gia cao nhat
    public void topGiaCao(){
        sapXepTheoGia_C2();
        System.out.println("------ Top 5 xe gia cao nhat ------");
        if(list.size() < 5){
            for(int i = 0; i <list.size(); i++){
                list.get(i).xuat();
            }
        }else{
            for(int i = 0 ; i< 5; i++){
                list.get(i).xuat();
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void menu(){
    int chon;
        do {            
         
     System.out.println("|========== Quan Ly Xe OOP Xuong ==========|");
        System.out.println("|1. Nhap danh sach xe                      |");
        System.out.println("|2. Xuat danh sach xe                      |");
        System.out.println("|3. Tim xe theo ma                         |");
        System.out.println("|4. Xoa xe theo ma                         |");
        System.out.println("|5. Cap nhat thong tin xe theo ma          |");
        System.out.println("|6. Tim xe theo khoang gia                 |");
        System.out.println("|7. Sap xep xe theo ten                    |");
        System.out.println("|8. Sap xep xe theo gia                    |");
        System.out.println("|9. Top 5 xe gia cao nhat                  |");
        System.out.println("|0. Thoat                                  |");
        System.out.println("|==========================================|");
        System.out.print("Chon chuc nang : ");
        chon = s.nextInt();
            switch (chon) {
                case 1:
                    System.out.println("Nhap sanh sach xe");
                    nhap();
                    break;
                case 2:
                   xuat();
                    break;
                case 3:
                    timKiem();
                    break;
                case 4:
                   xoa();
                    break;
                case 5:
                  capNhat();
                    break;
                case 6:
                    timTheoKhoangGia();
                    break;
                case 7:
                    sapXepTheoTen();
                    break;
                case 8:
                   sapXepTheoGia();
                    break;
                case 9:
                    topGiaCao();
                    break;
                case 0:
                
                default:
                    System.out.println("Chon sai chuc nang , chon lai (0 -> 9)");
            } 
       
        } while (true);
    }
}
