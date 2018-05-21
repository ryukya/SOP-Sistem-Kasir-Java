/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Said eO
 */
public class koneksi {

    Connection koneksi;

    public koneksi() {
        try {
            String username = "root";
            String password = "";
            String database = "cc";
            String url = "jdbc:mysql://localhost:3306/" + database;
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi berhasil");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Koneksi gagal. Kesalahan: " + e);
        }
    }

    public DefaultTableModel select(String query) {
        DefaultTableModel hasilQueryDTM = null;
        try {
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            ResultSetMetaData metaData = rs.getMetaData();
            Vector<String> namakolom = new Vector<>();
            int banyakKolom = metaData.getColumnCount();
            for (int column = 1; column <= banyakKolom; column++) {
                namakolom.add(metaData.getColumnName(column));
            }
            Vector<Vector<String>> hasilQuery = new Vector<Vector<String>>();
            while (rs.next()) {
                Vector<String> satuBaris = new Vector<>();
                for (int columnIndex = 1; columnIndex <= banyakKolom; columnIndex++) {
                    satuBaris.add(rs.getString(columnIndex));
                }
                hasilQuery.add(satuBaris);
            }
            hasilQueryDTM = new DefaultTableModel(hasilQuery, namakolom);
        } catch (SQLException e) {
            System.out.println("Kesalahan:" + e);
        }
        return hasilQueryDTM;
    }

    public void insertUpdateDelete(String query) {
        try {
            Statement stmt = koneksi.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            System.out.println("Kesalahan:" + e);
        }
    }

    public String[] getData(String query, int kolom) {
        String data[] = null;
        try {
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.last();
            int panjangBaris = rs.getRow();
            rs.beforeFirst();
            System.out.println(panjangBaris);
            data = new String[panjangBaris];
            int i = 0;
            while (rs.next()) {
                data[i++] = rs.getString(kolom);
            }
        } catch (SQLException e) {
            System.out.println("Kesalahan:" + e);
        }
        return data;
    }
     
}

