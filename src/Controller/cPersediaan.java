/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.koneksi;
import Model.mPersediaan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import View.Persediaan;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author S855
 */
public class cPersediaan {
     String id;
    String Level;
    mPersediaan mm= new mPersediaan();
    Persediaan p= new Persediaan();
    public cPersediaan(String ID, String Level){
        id=ID;
        this.Level=Level;
        p.setVisible(true);
        showtabel();
        this.p.ListenerCreate(new tombolCreate());
        this.p.ListenerEdit(new tombolEdit());
   this.p.ListenerBack(new tombolBack());
    this.p.ListenerRefresh(new tombolRefresh());
    this.p.ListenerTabel(new tabelSelected());
    setKK();
            p.disbanEdit();
       
    }
    
      public void showtabel() {

        DefaultTableModel viewt = this.mm.modelT();
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
    //=====================================================================================================================================

        class tombolRefresh implements ActionListener {
        // SAAT DIREFRESH GAK ADA BARIS TABEL YANG TERSELEKSI

        @Override
        public void actionPerformed(ActionEvent e) {
            p.dispose();
           new cPersediaan(id, Level) ;
            
        }
    }
       //____________________________________________________________________________________________________________________________________________________________
            class tombolCreate implements ActionListener 
            {
        //nanti dilihat kalo sudah ad nimnya gak boleh didaftarkan lagi

        @Override
        public void actionPerformed(ActionEvent e) {
            String ID_brg = p.getID();
            String ID_akun= "3001";
            String NamaB=p.geNama();
            String Jumlah= p.getQty().toString();
            String HargB=p.getHBeli().toString();
            String HargJ=p.getHJual().toString();
            String Katego= konvertKK(p.getKK());
           
            boolean ver = cekfield(ID_brg, NamaB, Jumlah, HargB, HargJ,Katego);
            System.out.println("hasil ver =" + ver);
            if (ver == true) {
                mm.input(ID_brg, NamaB, Jumlah, HargB, HargJ,Katego,ID_akun);
                showtabel();
            }
        }
    }
public  String konvertKK(String k){
    String KK=k;
    String hasil;
    if(KK.equals("Makanan Berat")){
        hasil="MB";
    }
   else if(KK.equals("Makanan Ringan")){
        hasil="MK";
    }
    
   else if(KK.equals("Minuman")){
        hasil="MM";
    }
    else{hasil="OT";}
  System.out.println(KK+"=="+hasil);
    
    return hasil;
    
//    String[] nKK=mm.getKK();
//    for(int i=0;i<nKK.length;i++){
//        if(nKK[i]==KK);{
}
    
  class tabelSelected implements  MouseListener{
        
//        @Override
//        public void mousePressed(ActionEvent e) {
//            p.setVisible(false);
//            cUtama lg = new cUtama(id);
//
//      
//       Object indeks = p.getTableValue(row, kolom);
//    }

        @Override
        public void mouseClicked(MouseEvent e) {
      
   }

        @Override
        public void mousePressed(MouseEvent e) {
        int row= p.getRowTable();
         String ID_brg = (String )p.getTableValue(0);
            String ID_akun= "3001";
            String NamaB=(String )p.getTableValue(2);
            String Jumlah= (String )p.getTableValue(3);
            String HargB=(String )p.getTableValue(4);
            String HargJ=(String )p.getTableValue(5);
            String Katego= (String )p.getTableValue(6);
            p.setID(ID_brg);
            p.setNamaB(NamaB);
            p.setJumlah(Jumlah);
            p.setHargB(HargB);
            p.setHargJ(HargJ);
          //  p.seKatego(Katego);
            System.out.println("="+Jumlah);
          
            
            if(ID_brg.isEmpty()){
                } else{
                p.disbanCreate();p.disbanID();
//         p.enableDelete();
         p.enableEdit();
            }
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
       //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
      //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
//=====================================================================================================================================

    class tombolEdit implements ActionListener {
        //nanti dilihat kalo sudah ad nimnya gak boleh didaftarkan lagi

        @Override
        public void actionPerformed(ActionEvent e) {
            String ID_brg = p.getID();
            String ID_akun= "3001";
            String NamaB=p.geNama();
            String Jumlah= p.getQty().toString();
            String HargB=p.getHBeli().toString();
            String HargJ=p.getHJual().toString();
            String Katego= konvertKK(p.getKK());
            
            boolean ver = cekfield(ID_brg, NamaB, Jumlah, HargB, HargJ,Katego);
            System.out.println("hasil ver =" + ver);
         if (ver == true) {
                mm.edit(ID_brg, NamaB, Jumlah, HargB, HargJ,Katego,ID_akun);
                showtabel();
            } else {
                System.out.println("ada kesalahan");
            }
        }
    }
//=====================================================================================================================================

 
    //=====================================================================================================================================

   
   
//=====================================================================================================================================

    public boolean cekfield( String ID_brg, String NamaB, String Jumlah,  String HargB, String HargJ, String Katego) {
 String idbrg=ID_brg;
 String nB=NamaB;
 String jml= Jumlah;
 String Hb= HargB;
 String Hj=HargJ;
 String KK=Katego;
            String ID_akun= "3001";
        boolean kosong = true;
        boolean format = true;
        if (idbrg.isEmpty() || nB.isEmpty() || jml.isEmpty() || Hb.isEmpty() || Hj.isEmpty()||KK.isEmpty()) {
            kosong = false;
        }
        for (int i = 0; i < nB.length(); i++) {
            if ((nB.charAt(i) >= 65 && nB.charAt(i) <= 89) || (nB.charAt(i) >= 97 && (nB.charAt(i) <= 122)|| (nB.charAt(i)==32))) {
            } else {
                System.out.println("d"+i);//cek apkah bagiani in berjalan
                format = false;
            }
        }
        for (int i = 0; i < jml.length(); i++) {
            if (jml.charAt(i) >= 48 && jml.charAt(i) <= 57 ) {
            } else {
                System.out.println("a");

                format = false;
            }
        }
        for (int i = 0; i < Hb.length(); i++) {
            if (Hb.charAt(i) >= 48 && Hb.charAt(i) <= 57 ) {
            } else {
                System.out.println("a");

                format = false;
            }
        }

        
        for (int i = 0; i < Hj.length(); i++) {
            if (Hj.charAt(i) >= 48 && Hj.charAt(i) <= 57 ) {
            } else {
                System.out.println("a");

                format = false;
            }
        }
        if (format == false) {
            p.setPesan("Format tidak sesuai");
        } else {
            if (kosong == false) {
                p.setPesan("tidak boleh ada borang yang dikosongi");
            }
        }
        if (format == false || kosong == false) {
            return false;
        } else {
            return true;
        }
    }

//=====================================================================================================================================
public  void setKK(){
    String[] nKK=mm.getKK();
    for(int i=0;i<nKK.length;i++){
        p.setKategori(nKK[i]);
    }
}
}
