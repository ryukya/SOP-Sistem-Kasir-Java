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
public class cLogin {
    mPegawai m= new mPegawai();
    login l= new login();
    public cLogin(){
         l.setVisible(true);
        this.l.ListenerMulai(new tombolLogin());
        System.out.println("berjalan");
    }
      class tombolLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
      
        String ID=l.getID();
        String pass=l.getpas();
        ceklogin(ID,pass);
        }
        
      }
      public void ceklogin(String ID,String pass) {
 boolean tes = false;
          String nama = ID.toLowerCase();//namanya dijadikan lowercase
        String password = pass;
        if(nama.isEmpty()){
            l.setMessage("maaf ID tidak boleh kosong");
        } else if(pass.isEmpty()){
            l.setMessage("maaf password anda masih kosong");
        }
        else
        {
 tes=m.cek(nama, password);
            
      if(tes==true){
           l.dispose();
                    cUtama x= new cUtama(ID);
      }
      else{
      l.setHasil("maaf password atau ID anda salah");}
      
      }
      }
      
      
}
