/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.koneksi;
import Model.mTransaksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

import View.jurnal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
/**
 *
 * @author S855
 */
public class cJurnal {
     String id;
    String Level;
      jurnal p = new jurnal();
    mTransaksi mm = new mTransaksi();
    public cJurnal(String ID, String Level){
        id=ID;
        this.Level=Level;
      p.setVisible(true);
      showtabel();
      this.p.ListenerBack(new tombolBack());
    } 
    
    class tombolBack implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            p.setVisible(false);
            cUtama lg = new cUtama(id);

        }
    }
    
     public void showtabel() {

        DefaultTableModel viewt = this.mm.modelJU(id);
        p.setTabel(viewt);
    }

}
