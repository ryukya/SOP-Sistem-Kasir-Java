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
public class mPegawai {

    koneksi tk;

    public mPegawai() {
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

    public String getLevel(String ID) {
        String has = null;
        System.out.println(" user : " + ID);

        String query = "select * from petugas where Id_petugas = '" + ID + "'";

        String hasil[] = tk.getData(query, 2);

        boolean par = false;
        for (int i = 0; i < hasil.length; i++) {

            System.out.println("hasil ke " + (i + 1) + " =" + hasil[i]);
            has = hasil[i];
        }
        return has;
    }

    public Boolean input(String ID, String Nama, String Pass, String JK, String Level) {
        String query = "INSERT INTO `cc`.`petugas` ("
                + "Id_petugas,"
                + "ID_level, "
                + "Nama, "
                + "Password, "
                + "ID_jenis_kelamin, Status)"
                + "VALUES "
                + "( '" + ID + "', "
                + "'" + Level + "', "
                + "'" + Nama + "', "
                + "'" + Pass + "', "
                + "'" + JK + "','Aktif');";

        tk.insertUpdateDelete(query);
        return true;//diganti nanti ya kak jangan lupa hehe
    }

    public Boolean editP(String ID, String Nama, String Pass, String JK, String Level) {
        String quer = "UPDATE `cc`.`petugas` SET `Id_petugas` ='" + ID + "', `ID_level` = '" + Level + "',"
                + " `Nama` = '" + Nama + "', `Password` = '" + Pass + "', `ID_jenis_kelamin` = '" + JK + "', `Status` = 'Aktif' WHERE `petugas`.`Id_petugas` = '" + ID + "' ";
        String query = "UPDATE `cc`.`petugas` SET `Nama` = '" + Nama + "', "
                + "`ID_level` = '" + Level + "', `Password` = '" + Pass + "',"
                + " `ID_jenis_kelamin` = '" + JK + "'"
                + " WHERE `petugas`.`ID_level` = " + ID + ";";
        tk.insertUpdateDelete(quer);

        return true;
    }

    public Boolean deleteP(String ID, String Nama, String Pass, String JK, String Level) {
        String quer = "UPDATE `cc`.`petugas` SET `Id_petugas` ='" + ID + "', `ID_level` = '" + Level + "',"
                + " `Nama` = '" + Nama + "', `Password` = '" + Pass + "', `ID_jenis_kelamin` = '" + JK + "', `Status` = 'Tidak Aktif' WHERE `petugas`.`Id_petugas` = '" + ID + "' ";
        String query = "UPDATE `cc`.`petugas` SET `Nama` = '" + Nama + "', "
                + "`ID_level` = '" + Level + "', `Password` = '" + Pass + "',"
                + " `ID_jenis_kelamin` = '" + JK + "'"
                + " WHERE `petugas`.`ID_level` = " + ID + ";";
        tk.insertUpdateDelete(quer);

        return true;
    }

    public DefaultTableModel modelT() {
        String query = "SELECT * FROM petugas ";
        // query diatas merupakan query untuk menampilkan data pegawai dan jenis kelaminnya
        //(alamat tidak ditampilkan)
        DefaultTableModel model = tk.select(query);
        return model;
    }
}
