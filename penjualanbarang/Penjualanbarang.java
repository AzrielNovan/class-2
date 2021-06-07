/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualanbarang;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
/**
 *
 * @author dell
 */
public class Penjualanbarang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //Inisialisasi objek untuk masing-masing kelas  
      Scanner input = new Scanner (System.in);
      DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
      DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
      
    //Deklarasi variabel
    int jum=0, i=0;
    double total_bayar=0;
    
    //Deklarasi array
    int [] kode = new int[5];
    int [] qty = new int[5];
    int [] harga = new int[5];
    double [] sub_total = new double[5];
    double [] diskon= new double [5];
    String [] barang = new String[5];
         
      System.out.println("PROGRAM JAVA TENTANG PENJUALAN BARANG");
         
      System.out.print("Masukan Jumlah Beli : ");
      jum=input.nextInt();
      System.out.println(" ");
      
      //Masukkan elemen didalam array
      for (i=0; i<jum;i++){
              System.out.print("Masukan Kode Barang Ke-"+(i+1)+" : ");
              kode[i]=input.nextInt();
              System.out.print("Masukan qty Ke-"+(i+1)+" : ");
              qty[i]=input.nextInt();
              
    //Menentukan barang berdasarkan kode yang dimasukkan
     switch (kode[i]){
                  case 1 : 
                            barang[i]="Mouse Bluetooth 5.0  ";
                            harga[i]=14999;
                            diskon[i]=0.010;
                            break;
                  case 2 : 
                            barang[i]="Headphone Eksternal  ";
                            harga[i]=257000;
                            diskon[i]=0.05;
                            break;
                  case 3 : 
                            barang[i]="Power Bank 10.000 mAh";
                            harga[i]=159000;
                            diskon[i]=0.018;
                            break;
                  case 4 : 
                            barang[i]="Tripod Kamera        ";
                            harga[i]=309200;
                            diskon[i]=0.012;
                            break;
                  case 5 : 
                            barang[i]="Smart Watch Xiomi    ";
                            harga[i]=899000;
                            diskon[i]=0.025;
                            break;
                  default : 
                            System.out.println("Kode Barang Tidak Tersedia");
              }
         }
    //Pengaturan format number
         formatRp.setCurrencySymbol("Rp. ");
          formatRp.setMonetaryDecimalSeparator(',');
          formatRp.setGroupingSeparator('.');
          kursIndonesia.setDecimalFormatSymbols(formatRp);
          
          System.out.println(" ");
          System.out.println("No   Nama Barang             Harga            QTY  Diskon   Sub Total");  
          
    //Menampilkan seluruh elemen di dalam array
    for (i=0; i<jum;i++){ 
             sub_total[i]=((qty[i]*harga[i])-(qty[i]*harga[i]*diskon[i]));
             total_bayar+=sub_total[i];
              System.out.println(i+1+"    "+barang[i]+"   "+kursIndonesia.format(harga[i])+"    "+qty[i]+"     "+(int)(diskon[i]*100)+"%"+"     "+kursIndonesia.format(sub_total[i])); 
          }
          System.out.println(" ");
          
          //Menampilkan total bayar
          System.out.println("Total Bayar : "+kursIndonesia.format(total_bayar));
    }
    
}
