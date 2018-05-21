/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author S855
 */
public class mPersediaan {

    koneksi tk;

    public mPersediaan() {
        this.tk = new koneksi();

    }

    public Boolean cek(String nama, String password) {

        System.out.println(" user : " + nama);
        System.out.println(" password :" + password);

        String query = "select * from petugas";

        String hasil[] = tk.getData(query, 1);
        String hasil1[] = tk.getData(query, 4);
        boolean par = false;
        for (int i = 0; i < hasil.length; i++) {

            System.out.println("hasil ke " + (i + 1) + hasil[i]);
            System.out.println("hasil ke " + (i + 1) + hasil1[i]);
            if (nama.equals(hasil[i])) {
                if (password.equals(hasil1[i])) {
                    par = true;
                }
            }
        }
        return par;
    }

    public Boolean deleteP(String ID) {
        String quer = "DELETE FROM `cc`.`kartu_persediaan` WHERE `kartu_persediaan`.`ID_barang` = '"+ID+"';";
        tk.insertUpdateDelete(quer);

        return true;
    }

    public Boolean edit(String ID_brg, String NamaB, String Jumlah, String HargB, String HargJ, String Katego, String Id_akun) {
        String query = "UPDATE `cc`.`kartu_persediaan` SET `ID_barang` = '" + ID_brg + "', "
                + "`ID_akun` = '" + Id_akun + "', `Nama_barang` = '" + NamaB + "',"
                + " `Jumlah` = '" + Jumlah + "'" + " `ID_kategori` = '" + Katego + "'"
                + "`Harga_Beli` = '" + HargB + "', `Harga_Jual` = '" + HargJ + "'"
                + " WHERE `kartu_persediaan`.`ID_barang` = " + ID_brg + ";";
        String quer="UPDATE `cc`.`kartu_persediaan` SET `Nama_barang` = '"+NamaB+"', `Jumlah` = '"+Jumlah+"', "
                + "`Harga_Beli` = '"+HargB+"', `Harga_Jual` = '"+HargJ+"', `ID_kategori` = '"+Katego+"' WHERE `kartu_persediaan`.`ID_barang` = '"+ID_brg+"';";
        tk.insertUpdateDelete(quer);
        return true;//diganti nanti ya kak jangan lupa hehe
    }

    public Boolean input(String ID_brg, String NamaB, String Jumlah, String HargB, String HargJ, String Katego, String Id_akun) {

      

        String query = "INSERT INTO `cc`.`kartu_persediaan` (`ID_barang`, `id_akun`, `Nama_barang`, `Jumlah`, `Harga_Beli`, `Harga_Jual`, `ID_kategori`)"
                + "VALUES ('"+ID_brg+"', '3001', '"+NamaB+"', '"+Jumlah+"', '"+HargB+"', '"+HargJ+"', '"+Katego+"')";
        tk.insertUpdateDelete(query);

        return true;
    }

    public DefaultTableModel modelT() {
        String query = "Select `ID_barang`, `id_akun`, `Nama_barang`, `Jumlah`, "
                + "`Harga_Beli`, `Harga_Jual`,Nama_Kategori from kartu_persediaan p join kategori k on k.ID_kategori=p.ID_kategori ";
        // query diatas merupakan query untuk menampilkan data pegawai dan jenis kelaminnya
        //(alamat tidak ditampilkan)
        DefaultTableModel model = tk.select(query);
        return model;
    }
    public String [] getKK(){
        String query="select* from  kategori";
       return  tk.getData(query, 2);
    }
}
