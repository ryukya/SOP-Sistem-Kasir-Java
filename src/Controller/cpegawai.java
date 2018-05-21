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

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
import View.Pegawai;
import javax.swing.JOptionPane;

/**
 *
 * @author S855
 */
public class cpegawai {

    String id;
    String Level;
    Pegawai p = new Pegawai();
    mPegawai mm = new mPegawai();

    public cpegawai(String ID, String Level) {
        this.id = ID;
        this.Level = Level;
        p.setVisible(true);
        this.p.ListenerBack(new tombolBack());
        this.p.ListenerCreate(new tombolCreate());
        this.p.ListenerDelete(new tombolDelete());
        this.p.ListenerEdit(new tombolEdit());
        this.p.ListenerRefresh(new tombolRefresh());
        this.p.ListenerTabel( new tabelSelected());
       // this.p.getTableValue(int a, int b);
        showtabel();
        p.disbanEdit();
        p.disbanDelete();

    }
//=====================================================================================================================================

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
        
                  String ID = (String )p.getTableValue(0);
            String Nama = (String )p.getTableValue(2);
            String Pass = (String )p.getTableValue(3);
            String JK = (String )p.getTableValue(4);
            String Level = (String )p.getTableValue(1);
            p.setNIM(ID);
            p.setNama(Nama);
            p.setJK(JK);
            p.setLevel(Level);
            p.setpas(Pass);
            
            if(ID.isEmpty()){
                } else{
                p.disbanCreate();p.disbanNIM();
         p.enableDelete();
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
            String ID = p.getNIM();
            String Nama = p.getNama();
            String Pass = p.getpas();
            String JK = p.getJK();
            String Level = p.getLevel();
            boolean ver = cekfield(ID, Nama, Pass, JK, Level);
            System.out.println("hasil ver =" + ver);
            if (cekfield(ID, Nama, Pass, JK, Level) == true) {
                mm.editP(ID, Nama, Pass, JK, Level);
                showtabel();
            } else {
                System.out.println("ada kesalahan");
            }
        }
    }
//=====================================================================================================================================

    class tombolCreate implements ActionListener {
        //nanti dilihat kalo sudah ad nimnya gak boleh didaftarkan lagi

        @Override
        public void actionPerformed(ActionEvent e) {
            String ID = p.getNIM();
            String Nama = p.getNama();
            String Pass = p.getpas();
            String JK = p.getJK();
            String Level = p.getLevel();
            boolean ver = cekfield(ID, Nama, Pass, JK, Level);
            System.out.println("hasil ver =" + ver);
            if (ver == true) {
                mm.input(ID, Nama, Pass, JK, Level);
                showtabel();
            }
        }
    }
    //=====================================================================================================================================

    class tombolRefresh implements ActionListener {
        // SAAT DIREFRESH GAK ADA BARIS TABEL YANG TERSELEKSI

        @Override
        public void actionPerformed(ActionEvent e) {
            p.dispose();
new cpegawai(id, Level);
            
        }
    }
    //=====================================================================================================================================

   class tombolDelete implements ActionListener {
        //nanti dilihat kalo sudah ad nimnya gak boleh didaftarkan lagi

        @Override
        public void actionPerformed(ActionEvent e) {
            String ID = p.getNIM();
            String Nama = p.getNama();
            String Pass = p.getpas();
            String JK = p.getJK();
            String Level = p.getLevel();
            boolean ver = cekfield(ID, Nama, Pass, JK, Level);
            System.out.println("hasil ver =" + ver);
            if (cekfield(ID, Nama, Pass, JK, Level) == true) {
                mm.deleteP(ID, Nama, Pass, JK, Level);
                showtabel();
            } else {
                System.out.println("ada kesalahan");
            }
        }
    }   
//=====================================================================================================================================

    public boolean cekfield(String ID, String Nama, String Pass, String JK, String Level) {
        String Nma = Nama;
        String iid = ID;
        String pass = Pass;
        String JesK = JK;
        String Lvl = Level;
        boolean kosong = true;
        boolean format = true;
        if (Nma.isEmpty() || Lvl.isEmpty() || pass.isEmpty() || JesK.isEmpty() || iid.isEmpty()) {
            kosong = false;
        }
        for (int i = 0; i < Nma.length(); i++) {
            if ((Nma.charAt(i) >= 65 && Nma.charAt(i) <= 89) || (Nma.charAt(i) >= 97 && (Nma.charAt(i) <= 122))) {
            } else {
                System.out.println("d");//cek apkah bagiani in berjalan
                format = false;
            }
        }
        for (int i = 0; i < iid.length(); i++) {
            if ((iid.charAt(i) >= 48 && iid.charAt(i) <= 57) && iid.length() == 12) {
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

}
