/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.mTransLain;
import View.bukubesar;
import javax.swing.table.DefaultTableModel;

import Model.koneksi;
import Model.mTransaksi;
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
public class cBB {
   String id;
    String Level;
    
    bukubesar p = new bukubesar();
    mTransLain mm = new mTransLain();
    public cBB(String ID, String Level){
        id=ID;
        this.Level=Level;
        p.setVisible(true);
     //   showtable();
        this.p.ListenerSearch(new tombolsearch());
        this.p.ListenerBack(new tombolBack());
        setakun();
    }
    
      public void showtabel() {

      
    }
       class tombolsearch implements ActionListener 
            {
        //nanti dilihat kalo sudah ad nimnya gak boleh didaftarkan lagi

        @Override
        public void actionPerformed(ActionEvent e) {
            String IDAkun=p.getAkun();
              DefaultTableModel viewt = mm.modelBB(IDAkun);
        p.setTabel(viewt);
           
        }
         
    }
        public  void setakun(){
    String[] nKK=mm.getakun();
    for(int i=0;i<nKK.length;i++){
        p.setAkun(nKK[i]);
        System.out.println(""+nKK[i]);
    }
}
          class tombolBack implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            p.setVisible(false);
            cUtama lg = new cUtama(id);

        }
    }
}
