/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.koneksi;
import Model.mPegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.login;
import View.utama;

/**
 *
 * @author S855
 */
public class cUtama {
    utama nm=new utama();
    mPegawai a= new mPegawai();
    String id;
    String Level;
    
   //====================================================================================================
    public cUtama(String ID){
        this.id=ID;
        nm.setVisible(true);
       Level= getLevel(ID); 
        this.nm.ListenerLogout(new tombolOut());
        this.nm.ListenerAdmin(new tombolAdmin());
          this.nm.ListenerTrans( new tombolTrans()  );
           this.nm.ListenerTrLain(new tombolTrLain()   );

    this.nm.ListenerJurnal( new tombolJurnal());
    this.nm.ListenerKartuP( new tombolKartuP());
 //  this.nm.ListenerLap( new tombolLapKeu());
    this.nm.ListenerBB(new tombolBB());
    }
    
   //====================================================================================================
        public String getLevel( String ID){
            String cekID= ID;
           String level= a.getLevel(ID);
            System.out.println(" level ="+level);
            return level;
        }
        
   //====================================================================================================
    class tombolOut implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            nm.setVisible(false);
           cLogin lg= new cLogin();
   
        }
    }
    
   //====================================================================================================
    class tombolAdmin implements ActionListener {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("level ="+Level);
            if (Level.equals("C") || Level.equals("B")){
                  nm.dispose();
                    cpegawai x= new cpegawai(id,Level);
            }
            else{
                nm.setHasil("Maaf Anda tidak berhak untuk mengakses fitur ini");
            }
        }
    }
   //==================================================================================================== 
//       class tombolLapKeu implements ActionListener {
//        
//        
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.out.println("level ="+Level);
//            if (Level.equals("C") ){
//                  nm.dispose();
//                    cLaporan x= new cLaporan(id,Level);
//            }
//            else{
//                nm.setHasil("Maaf Anda tidak berhak untuk mengakses fitur ini");
//            }
//        }
//    }
    
   //====================================================================================================
       class tombolBB implements ActionListener {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("level ="+Level);
            if (Level.equals("C") || Level.equals("B")) {
                  nm.dispose();
                    cBB x= new cBB(id,Level);
            }
            else{
                nm.setHasil("Maaf Anda tidak berhak untuk mengakses fitur ini");
            }
        }
    }
       //====================================================================================================
        class tombolTrLain implements ActionListener {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("level ="+Level);
            if (Level.equals("C") || Level.equals("B")) {
                  nm.dispose();
                    cTrLain x= new cTrLain(id,Level);
            }
            else{
                nm.setHasil("Maaf Anda tidak berhak untuk mengakses fitur ini");
            }
            
        }
    }
       
       //====================================================================================================
       
            class tombolTrans implements ActionListener {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("level ="+Level);
                  nm.dispose();
                    cTransaksi x= new cTransaksi(id,Level);
            
            
        }
    }
       //====================================================================================================
         class tombolJurnal implements ActionListener {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("level ="+Level);
            if (Level.equals("C") || Level.equals("B")) {
                  nm.dispose();
                    cJurnal x= new cJurnal(id,Level);
            }
            else{
                nm.setHasil("Maaf Anda tidak berhak untuk mengakses fitur ini");
            }
        }
    }
       
       //====================================================================================================
                class tombolKartuP implements ActionListener {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("level ="+Level);
            if (Level.equals("C") || Level.equals("B")) {
                  nm.dispose();
                    cPersediaan x= new cPersediaan(id,Level);
            }
            else{
                nm.setHasil("Maaf Anda tidak berhak untuk mengakses fitur ini");
            }
        }
    }
       
         
           //====================================================================================================
         
         
           //====================================================================================================
}
