///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Controller;
//
///**
// *
// * @author S855
// */
//public class cTransaksi {
//      String id;
//    String Level;
//    public cTransaksi(String ID, String Level){
//        id=ID;
//        this.Level=Level;
//    } 
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.koneksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
import View.transaksi;
import javax.swing.JOptionPane;
import Model.mTransaksi;
/**
 *
 * @author S855
 */
public class cTransaksi {

    String id;
    String Level;
    transaksi p = new transaksi();
    mTransaksi mm = new mTransaksi();
int indeks;
Double totbayar;
String namaK[];
    public cTransaksi(String ID, String Level) {
        
        this.id = ID;
        this.Level = Level;
        p.setVisible(true);
        this.p.ListenerBack(new tombolBack());
  this.p.ListenerCreate(new tombolCreate());
  this.p.ListenerBayar(new tombolBayar());
//    //    this.p.ListenerDelete(new tombolDelete());
      this.p.ListenerEdit(new tombolEdit());
    this.p.ListenerRefresh(new tombolRefresh());
  // this.p.ListenerTabel( new tabelSelected());
        this.p.ListenerKK(new tabelkk());
       // this.p.getTableValue(int a, int b);
       // showtabel();
        setKK();
        //p.disbanEdit();
      //  p.disbanDelete();

    }
//=====================================================================================================================================

    public void showtabel(String nB) {

        DefaultTableModel viewt = this.mm.modelT( nB);
        p.setTabel(viewt);
        
    }
//=====================================================================================================================================


    class tombolBack implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            p.setVisible(false);
            cUtama lg = new cUtama(id);

        }
    }
    
    public Double jumlah(){
           String namaP=p.getnamaB(); boolean cek= true;
        String kuant=p.getQty();
             String disk=p.getDisc();
           String hjual=mm.getHargaJ(namaP)[0];
           if(kuant.isEmpty()||hjual.isEmpty()||disk.isEmpty()){
               p.setPesan("tidak boleh ad kolom yang kosong"); cek=false;
           }    
           if(cek==true){Double satuan=Double.parseDouble(kuant);Double potong=Double.parseDouble(disk);Double jual=Double.parseDouble(hjual);
           Double jm= (satuan*jual)-potong;
               p.setTobay(jm.toString());
  return jm;}
           else{
               return null;
           }
    }
     class tombolBayar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String namaP=p.getnamaB();
             String uang=p.getUang();Double money=Double.parseDouble(uang); 
             String kuant=p.getQty();Double satuan=Double.parseDouble(kuant);
             String disk=p.getDisc();Double potong=Double.parseDouble(disk);
             
             String  hbeli=mm.getHargaB(namaP)[0] ; Double beli=Double.parseDouble(hbeli);
             String hjual=mm.getHargaJ(namaP)[0];Double jual=Double.parseDouble(hjual);
             String IDB=mm.getID_B(namaP)[0];
             String datee=p.getTGL();
            System.out.println("=="+hbeli);
            double jml=jumlah();
            boolean mimi; boolean min=false;
            String KK=  p.getKK();
            if(KK.equals("MM")){
                if(satuan<5){
                p.setPesan("Untuk minuman Jumlahnya harus lebih dari 5");}else {
            if(money<jml){
                p.setPesan("uang anda tidak mencukupi");
            }
            else{ min=true;
            mimi=    mm.input1(id, IDB, satuan, jml ,datee,  beli,potong);
            
            }
            }
        }else{min=true;}
            if(mimi=true&&min==true){
                mimi=    mm.input1(id, IDB, satuan, jml ,datee,  beli,potong);
            
                Double kembali=money-jml;p.setBali(kembali.toString());
           p.setPesan(" transaksi berhasil disimpan. Kembali anda sebesar "+kembali); }
 //     boolean ver=cekfield( Kuantitas, Diskon,  uang, jumlah) ;
//  if(ver==true){
//      boolean trans=mm.input1(ID_P, ID_B, Kuantitas, tb,tanggal,  HargaB,Diskon);
//     if(trans==true){
//         Double kembalian;
//         kembalian=Double.parseDouble(uang)-totbayar;
//      p.setPesan("Terima kasih telah berbelanja Kembalian anda adalah "+totbayar);
//     }
//  }
//            int row= p.getRowTable();
//        
//             String Kuantitas=p.getQty();
//             String Diskon =p.getDisc();
//             String uang =p.getUang();
//    
//             
//             String tanggal=p.getTGL();
//             String ID_P=id;
//             String nmb=p.getnamaB();String ID_B;
//             String [] iidb=mm.getID_B(nmb);
//             String [] hhb=mm.getHargaB(nmb);
//             String [] hhj=mm.getHargaJ(nmb);
//             String HargaB;String HargaJ;
//             for(int i=0;i<2;i++){
//                 ID_B=iidb[1];
//             HargaB=hhb[1];
//             HargaJ=hhj[1];
//             }
//             System.out.println("---"+HargaJ+"--"+HargaB);
//             Double jumlah = null;
//                  Double ku=   Double.parseDouble(Kuantitas);
//                    Double hr= Double.parseDouble(HargaJ);
//                    Double d= Double.parseDouble(Diskon);
//  totbayar=totbayar+jumlah;
//  String tb=totbayar.toString();
  
        }
    }
    
     class tabelkk implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
          String KK=  p.getKK();
           setnamaB(KK);
        }
    }
        public  void setKK(){
    String[] nKK=mm.getKK();
    for(int i=0;i<nKK.length;i++){
        p.setKategori(nKK[i]);
        System.out.println(""+nKK[i]);
    }
}
     public  void setnamaB(String ID){
         System.out.println("ini berjalan");
         p.hapusNB();
    String[] nKK=mm.getNamaB(ID);
    for(int i=0;i<nKK.length;i++){
        
        System.out.println(""+nKK[i]);
        String barg=nKK[i];
        p.setNamaB(barg);
        
    }
}
    //=====================================================================================================================================

//    class tabelSelected implements  MouseListener{
//        
////        @Override
////        public void mousePressed(ActionEvent e) {
////            p.setVisible(false);
////            cUtama lg = new cUtama(id);
////
////      
////       Object indeks = p.getTableValue(row, kolom);
////    }
//
//        @Override
//        public void mouseClicked(MouseEvent e) {
//      
//   }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//        int row= p.getRowTable();
//        
//             String Kuantitas=p.getQty();
//             String Diskon =p.getDisc();
//             String uang =p.getUang();
//    
//             
//             
//             String ID_P=id;
//             String ID_B=(String)p.getTableValue(0);
//             String HargaB=(String)p.getTableValue(4);
//             String HargaJ= (String)p.getTableValue(5);
//             Double tb=Double.parseDouble(Kuantitas)*Double.parseDouble(HargaJ)-Double.parseDouble(Diskon);
//             
//            
//            if(ID_P.isEmpty()){
//                } else{
//                p.disbanCreate();
//                
//            }
////            
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//       //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//      //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//    }
////=====================================================================================================================================

    class tombolEdit implements ActionListener {
        //nanti dilihat kalo sudah ad nimnya gak boleh didaftarkan lagi

        @Override
        public void actionPerformed(ActionEvent e) {
          Double jm= jumlah();
        }
    }
//=====================================================================================================================================

    class tombolCreate implements ActionListener {
        //nanti dilihat kalo sudah ad nimnya gak boleh didaftarkan lagi

        @Override
        public void actionPerformed(ActionEvent e) {
            indeks++;
            String ID = p.getnamaB();
               
//            for(int i=0;i<=indeks;i++){
//                namaK[i]=ID;
//            }
                showtabel(ID);
            
        }
    }
//    //=====================================================================================================================================
//
    class tombolRefresh implements ActionListener {
        // SAAT DIREFRESH GAK ADA BARIS TABEL YANG TERSELEKSI

        @Override
        public void actionPerformed(ActionEvent e) {
            p.dispose();
new cTransaksi(id, Level);
            
        }
    }
//    //=====================================================================================================================================
//
//   class tombolDelete implements ActionListener {
//        //nanti dilihat kalo sudah ad nimnya gak boleh didaftarkan lagi
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String ID = p.getNIM();
//            String Nama = p.getNama();
//            String Pass = p.getpas();
//            String JK = p.getJK();
//            String Level = p.getLevel();
//            boolean ver = cekfield(ID, Nama, Pass, JK, Level);
//            System.out.println("hasil ver =" + ver);
//            if (cekfield(ID, Nama, Pass, JK, Level) == true) {
//                mm.deleteP(ID, Nama, Pass, JK, Level);
//                showtabel();
//            } else {
//                System.out.println("ada kesalahan");
//            }
//        }
//    }   
////=====================================================================================================================================
//
    public boolean cekfield(String Kuantitas, String Diskon, String uang,String jumlah) {
       String qty=Kuantitas;
       String disk= Diskon;
       String money= uang;
       Double tot=Double.parseDouble( jumlah);
       Double byr=Double.parseDouble( uang);
boolean lunas=true;
       boolean kosong = true;
        boolean format = true;
        if (qty.isEmpty() || disk.isEmpty() || money.isEmpty() ) {
            kosong = false;
        }
        for (int i = 0; i < qty.length(); i++) {
            if ((qty.charAt(i) >= 48 && qty.charAt(i) <= 57) ) {
            } else {
                System.out.println("a");

                format = false;
            }
        }
Double kuan=(Double)p.getTableValue(3);
Double r=Double.parseDouble(qty);
if(r>kuan){
    format=false;
}

        for (int i = 0; i < disk.length(); i++) {
            if ((disk.charAt(i) >= 48 && disk.charAt(i) <= 57) ) {
            } else {
                System.out.println("a");

                format = false;
            }
        }
        
        for (int i = 0; i < money.length(); i++) {
            if ((money.charAt(i) >= 48 && money.charAt(i) <= 57) ) {
            } else {
                System.out.println("a");

                format = false;
            }
        }
        if (tot>byr){
            lunas=false;
        }
        if (format == false) {
            p.setPesan("Format atau jumlah pesanan tidak sesuai");
        } else {
            if (kosong == false) {
                p.setPesan("tidak boleh ada borang yang dikosongi");
            } else if(lunas==false){
                p.setPesan("uang anda tidak mencukupi");
            }
        }
        if (format == false || kosong == false || lunas==false) {
            return false;
        } else {
            return true;
        }
    }
//  //=====================================================================================================================================

 
}

