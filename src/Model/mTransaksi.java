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
public class mTransaksi {

    koneksi tk;
    koneksi tk2;
    koneksi tk3;
    koneksi tk4;koneksi tk5;
    public mTransaksi() {
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

    public String [] getKK(){
        String query="select* from  kategori";
       return  tk.getData(query, 2);
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
  public DefaultTableModel modelJU(String ID) {
        String query = "Select * "
                + "from jurnal_umum  ";
        // query diatas merupakan query untuk menampilkan data pegawai dan jenis kelaminnya
        //(alamat tidak ditampilkan)
        DefaultTableModel model = tk.select(query);
        return model;
    }

  
    public boolean input1(String id, String IDB, Double satuan, double jml, String datee, Double beli, Double potong) {
        Date tanggal = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(tanggal));
       
        
       //bentuknya datee berisi format sdf jadi ga dipakai System.out.println("tanggal="+datee);
              String quer2; String quer3;String quer4;
        String quer= "INSERT INTO `cc`.`transaksi` (`ID_transaksi`, `ID_petugas`, `ID_barang`, `kuantitas`, `total_penjualan`"
                + ", `Tanggal`, `Harga_barang`, `Potongan_penjualan`) "
                + "VALUES (NULL, '"+id+"', '"+IDB+"', '"+satuan+"', '"+jml+"', '"+sdf.format(tanggal)+"', '"+beli+"', '"+potong+"');";
        System.out.println("tanggal "+datee);
      
        String quer5="UPDATE `cc`.`kartu_persediaan` SET `Jumlah` = Jumlah-"+satuan+" WHERE `kartu_persediaan`.`ID_barang` = '"+IDB+"';";
if(potong.equals("0")){
     quer2="INSERT INTO `cc`.`jurnal_umum` (`ID_Jurnal`, `ID_Transaksi`, `ID_pegawai`, `ID_Akun`, `Keterangan`, `Debet`, `Kredit`, `Tanggal`) VALUES "
            + "(NULL, NULL, '"+id+"', '10001', 'penjualan tunai', '"+jml+"', '0', '"+sdf.format(tanggal)+"');";
             quer3="INSERT INTO `cc`.`jurnal_umum` (`ID_Jurnal`, `ID_Transaksi`, `ID_pegawai`, `ID_Akun`, `Keterangan`, `Debet`, `Kredit`, `Tanggal`) VALUES "
            + " (NULL, NULL, '"+id+"', '4001', 'penjualan tunai', '0', '"+jml+"', '"+sdf.format(tanggal)+"');";
tk2.insertUpdateDelete(quer2);System.out.println("2 selsai");
tk3.insertUpdateDelete(quer3);System.out.println("3 selsai");

}
 
else {
     quer2="INSERT INTO `cc`.`jurnal_umum` (`ID_Jurnal`, `ID_Transaksi`, `ID_pegawai`, `ID_Akun`, `Keterangan`, `Debet`, `Kredit`, `Tanggal`) VALUES "
            + "(NULL, NULL, '"+id+"', '10001', 'penjualan tunai', '"+jml+"', '0', '"+sdf.format(tanggal)+"');";
quer3= "INSERT INTO `cc`.`jurnal_umum` (`ID_Jurnal`, `ID_Transaksi`, `ID_pegawai`, `ID_Akun`, `Keterangan`, `Debet`, `Kredit`, `Tanggal`) VALUES "
            + "(NULL, NULL, '"+id+"', '4002', 'penjualan tunai', '"+potong+"', '0', '"+sdf.format(tanggal)+"');";
        quer4="INSERT INTO `cc`.`jurnal_umum` (`ID_Jurnal`, `ID_Transaksi`, `ID_pegawai`, `ID_Akun`, `Keterangan`, `Debet`, `Kredit`, `Tanggal`) VALUES "  
        + " (NULL, NULL, '"+id+"', '4001', 'penjualan tunai', '0', '"+jml+"', '"+sdf.format(tanggal)+"');";
tk2.insertUpdateDelete(quer2);System.out.println("2 selsai");
tk3.insertUpdateDelete(quer3);System.out.println("3 selsai");
tk4.insertUpdateDelete(quer4);System.out.println("4 selsai");


}
tk.insertUpdateDelete(quer);

tk5.insertUpdateDelete(quer5);
return true;
    }
}
