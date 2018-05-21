/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author S855
 */
public class mTransLain {

    koneksi tk;
    koneksi tk2;
    koneksi tk3;
    koneksi tk4;koneksi tk5;
    public mTransLain() {
        this.tk = new koneksi();
        this.tk2= new koneksi();
        this.tk3= new koneksi();
this.tk4= new koneksi();
this.tk5=new koneksi();

    }

//    public Boolean cek(String nama, String password) {
//
//        System.out.println(" user : " + nama);
//        System.out.println(" password :" + password);
//
//        String query = "select * from petugas";
//
//        String hasil[] = tk.getData(query, 1);
//        String hasil1[] = tk.getData(query, 4);
//        boolean par = false;
//        for (int i = 0; i < hasil.length; i++) {
//
//            System.out.println("hasil ke " + (i + 1) + hasil[i]);
//            System.out.println("hasil ke " + (i + 1) + hasil1[i]);
//            if (nama.equals(hasil[i])) {
//                if (password.equals(hasil1[i])) {
//                    par = true;
//                }
//            }
//        }
//        return par;
//    }

    public String [] getakun(){
        String query="select* from  kartu_akun";
       return  tk.getData(query, 1);
    }
    public String [] getNamaB( String kk){
        String query="select *from kartu_persediaan where ID_kategori='"+kk+"' ";
   
        return  tk.getData(query, 3);
    }
      public String [] getID_B( String kk){
        String query="select  ID_barang from kartu_persediaan where  Nama_barang='"+kk+"' ";
   
        return  tk.getData(query, 1);
    }
        public String [] getHargaB( String kk){
        String query="select Harga_Beli from kartu_persediaan where  Nama_barang='"+kk+"' ";
   
        return  tk.getData(query, 1);
    }
          public String [] getHargaJ( String kk){
        String query="select Harga_Jual from kartu_persediaan where  Nama_barang='"+kk+"' ";
   
        return  tk.getData(query, 1);
    }
    
 public DefaultTableModel modelT(String ID) {
     
        String query = "Select `ID_barang`, `id_akun`, `Nama_barang`, `Jumlah`, `Harga_Beli`, `Harga_Jual`,Nama_Kategori "
                + "from kartu_persediaan p join kategori k on k.ID_kategori=p.ID_kategori where Nama_barang='"+ID+"'  ";
        // query diatas merupakan query untuk menampilkan data pegawai dan jenis kelaminnya
        //(alamat tidak ditampilkan)
        DefaultTableModel model = tk.select(query);
        return model;
    }
 
 
  public DefaultTableModel modelBB(String ID) {
     
        String query = "select ID_Akun, Keterangan ,Debet, Kredit, Tanggal from jurnal_umum where ID_Akun='"+ID+"' ";
        // query diatas merupakan query untuk menampilkan data pegawai dan jenis kelaminnya
        //(alamat tidak ditampilkan)
        DefaultTableModel model = tk.select(query);
        return model;
    }
 
 
  public DefaultTableModel modelJU(String ID) {
        String query = "Select * "
                + "from jurnal_umum  ";
        // query diatas merupakan query untuk menampilkan data pegawai dan jenis kelaminnya
        //(alamat tidak ditampilkan)
        DefaultTableModel model = tk.select(query);
        return model;
    }
  public DefaultTableModel modeltr(String ll) {
        String query = "Select * "
                + "from jurnal_umum    where Keterangan='"+ll+"'";
        // query diatas merupakan query untuk menampilkan data pegawai dan jenis kelaminnya
        //(alamat tidak ditampilkan)
        DefaultTableModel model = tk.select(query);
        return model;
    }

  public boolean inputpiut(String id, String  lala,String jumlah){
         Date tanggal = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(tanggal));
        String quer2; String quer3;
          quer2="INSERT INTO `cc`.`jurnal_umum` (`ID_Jurnal`, `ID_Transaksi`, `ID_pegawai`, `ID_Akun`, `Keterangan`, `Debet`, `Kredit`, `Tanggal`) VALUES "
            + "(NULL, NULL, '"+id+"', '10001', '"+lala+"', '"+jumlah+"', '0', '"+sdf.format(tanggal)+"');";
            quer3="INSERT INTO `cc`.`jurnal_umum` (`ID_Jurnal`, `ID_Transaksi`, `ID_pegawai`, `ID_Akun`, `Keterangan`, `Debet`, `Kredit`, `Tanggal`) VALUES "
            + "(NULL, NULL, '"+id+"', '1000', '"+lala+"', '0', '"+jumlah+"', '"+sdf.format(tanggal)+"');";
       tk.insertUpdateDelete(quer2);
       tk2.insertUpdateDelete(quer3);
       return true;
  }
   public boolean inputListrik(String id, String  lala,String jumlah){
         Date tanggal = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(tanggal));
        String quer2; String quer3;
          quer2="INSERT INTO `cc`.`jurnal_umum` (`ID_Jurnal`, `ID_Transaksi`, `ID_pegawai`, `ID_Akun`, `Keterangan`, `Debet`, `Kredit`, `Tanggal`) VALUES "
            + "(NULL, NULL, '"+id+"', '6001', '"+lala+"', '"+jumlah+"', '0', '"+sdf.format(tanggal)+"');";
            quer3="INSERT INTO `cc`.`jurnal_umum` (`ID_Jurnal`, `ID_Transaksi`, `ID_pegawai`, `ID_Akun`, `Keterangan`, `Debet`, `Kredit`, `Tanggal`) VALUES "
            + "(NULL, NULL, '"+id+"', '10001', '"+lala+"', '0', '"+jumlah+"', '"+sdf.format(tanggal)+"');";
       tk.insertUpdateDelete(quer2);
       tk2.insertUpdateDelete(quer3);
       return true;
  }
   
}
