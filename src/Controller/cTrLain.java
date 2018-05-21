/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.koneksi;
import Model.mTransLain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
import View.TrLain;
import javax.swing.JOptionPane;
import Model.mTransaksi;
/**
 *
 * @author S855
 */
public class cTrLain {
     String id;
    String Level;
    
    mTransLain mm= new mTransLain();
    TrLain p= new TrLain();
    public cTrLain(String ID, String Level){
        id=ID;
        this.Level=Level;
          this.id = ID;
        this.Level = Level;
        p.setVisible(true);
        this.p.ListenerBack(new tombolBack());
  this.p.ListenerRekam(new tombolCreate());
  
    }
    
    public void Kasus(String  lala, String jumlah ){
    if(lala.equals("Pembayaran Iklan"))
    { mm.inputListrik(id,lala,jumlah);
    }
    else if(lala.equals("Penerimaan piutang")){
    mm.inputpiut(id,lala,jumlah);
    
    }
        }
         class tombolBack implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            p.setVisible(false);
            cUtama lg = new cUtama(id);

        }
    }
         
         class tombolCreate implements ActionListener 
            {
        //nanti dilihat kalo sudah ad nimnya gak boleh didaftarkan lagi

        @Override
        public void actionPerformed(ActionEvent e) {
            String jumlah=p.getnominal();
           String ll=p.getTr();
            Kasus(ll,jumlah);
            
              DefaultTableModel viewt = mm.modeltr(ll);
        p.setjurnal(viewt);
           
        }
    }
}
