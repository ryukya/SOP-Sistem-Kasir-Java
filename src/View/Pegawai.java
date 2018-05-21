/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.sun.org.apache.bcel.internal.Constants;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;//koding untuk mengimport swing tabel

/**
 *
 * @author S855
 */
public class Pegawai extends javax.swing.JFrame {

   // koneksi tk = new koneksi();
   // String IID = null;

    /**
     * Creates new form login
     */
    public Pegawai() {
        initComponents();
//        showData();
//        edit.setEnabled(false);
//        Delete.setEnabled(false);
    }

//    public void refresh() {
//        this.setVisible(false);
//        new Pegawai().setVisible(true);    //method untuk menampilkan data pada tabel
//    }
//
//    public int getRowTable() {
//        int row = tabel.getSelectedRow();// koding untuk menyimpan  angka baris yang diseleksi
//        return row;
//    }
////didrag terus di ctrl+r
//
//    public Object getTableValue(int row, int kolom) {//method untuk mengambil nilai pada baris dan kolom
//        Object value = tabel.getValueAt(row, kolom);
//        return value;
//    }
//
//    public void showData() {
//        String query = "SELECT Nama,User,Password,Angkatan,ID_Admin FROM petugas WHERE Status ='Aktif' ";
//        // query diatas merupakan query untuk menampilkan data pegawai dan jenis kelaminnya
//        //(alamat tidak ditampilkan)
//        DefaultTableModel model = tk.select(query);// method pembuatan model untuk memanggil tabel dengan bantuan koneksi tk
//        tabel.setModel(model);//koding untuk menampilkan tabel dari object model
//    }
//
//    public String getpas() {
//        char[] paswor = pasword.getPassword();
//        String paswor2 = "";
//        for (int i = 0; i < paswor.length; i++) {
//            paswor2 += paswor[i];
//        }
//        return paswor2;
//
//    }
//
//    public String getUser() {
//        return Nama.getText();
//    }

//    public boolean cekfield() {
//        String Nma = Nama.getText();// variabel untuk mengambil nomorpegawai dari textfield
//        String usr = User.getText();// variabel untuk mengambil namadepan dari textfield
//        String pass = pasword.getText();// variabel untuk mengambil namabelakang dari textfield
//        String anka = Angkatan.getText();
//        IID = ID.getText();
//
//        boolean kosong = true;
//        boolean format = true;
//        if (Nma.isEmpty() || usr.isEmpty() || pass.isEmpty() || anka.isEmpty() || IID.isEmpty()) {
//            kosong = false;
//        }
//        for (int i = 0; i < Nma.length(); i++) {
//           if ((Nma.charAt(i) >= 65 && Nma.charAt(i) <= 89) || (Nma.charAt(i) >= 97 && (Nma.charAt(i) <= 122)))
//            {
//            }else
//        {
//               System.out.println("d"); format=false;}
//        }
//        for (int i = 0; i < anka.length(); i++) {
//           if ((anka.charAt(i) >= 48 && anka.charAt(i) <= 57) &&anka.length()==4)
//            {
//            }else
//        {
//            System.out.println("a");      format=false;}
//        }
//        
//        for (int i = 0; i < IID.length(); i++) {
//           if ((IID.charAt(i) >= 48 && IID.charAt(i) <= 57) &&IID.length()==12)
//            {
//            }else
//        {
//              System.out.println("ini");  format=false;}
//        }
//        if(format==false){
//             JOptionPane.showMessageDialog(rootPane, "Format tidak sesuai");
//        } else{
//        if(kosong==false){
//             JOptionPane.showMessageDialog(rootPane, "Tidak boleh ada borang yang kosong");
//        }}
//        if(format==false||kosong==false){
//            return false;
//        }
//        else{
//            return true;
//        }
//    }
    public void setTabel(DefaultTableModel m){
          
         tabel.setModel(m);
    }
     
    
    public void ListenerCreate(ActionListener act){
        create.addActionListener(act);
    }
     
    public void ListenerEdit(ActionListener act){
        edit.addActionListener(act);
    }
     
    public void ListenerDelete(ActionListener act){
        Delete.addActionListener(act);
    }
     public void ListenerRefresh(ActionListener act){
        refresh.addActionListener(act);
    }
    public void ListenerBack(ActionListener act){
        back.addActionListener(act);
    }
    
    public void ListenerTabel( MouseListener act){
        tabel.addMouseListener(act );
    }
      public String getpas(){
       String data= pass.getText();
       return data;
    }
        public String getNIM(){
       String data= ID.getText();
       return data;
    }
          public String getNama(){
       String data= Nama.getText();
       return data;
    }
            public String getLevel(){
       String data= String.valueOf(level.getSelectedItem());
       return data;
    }
              public String getJK(){
       String data= String.valueOf(JKbox.getSelectedItem());
       return data;
    }
              
                public void setpas( String pas){
       
       pass.setText(pas);
    }
        public void setNIM( String nim){
       ID.setText(nim);
    }
          public void setNama(String nm){
       Nama.setText(nm);
    }
            public void setLevel(String lv){
                level.setSelectedItem(lv);
    }
              public void setJK( String JK){
JKbox.setSelectedItem(JK);
              }
              
 public Object getTableValue( int b) {
        Object value = tabel.getValueAt(getRowTable(), b);
        return value;
 }
  public int getRowTable() {
        int row = tabel.getSelectedRow();// koding untuk menyimpan  angka baris yang diseleksi
        return row;
    }
  
  public int getColTable() {
        int row = tabel.getSelectedColumn();// koding untuk menyimpan  angka baris yang diseleksi
        return row;
    }
  public void disbanCreate(){
      create.setEnabled(false);
  }
   public void disbanEdit(){
      edit.setEnabled(false);
  }
    public void disbanDelete(){
      Delete.setEnabled(false);
  }
     public void enableEdit(){
      edit.setEnabled(true);
  }
    public void enableDelete(){
      Delete.setEnabled(true);
  }
  public void disbanNIM(){
      ID.disable();
  }
// public Object getTableValue(int a, int b) {
//        Object value = tabel.getValueAt(a, b);
//        return value;
//    }
 public void setPesan(String X) {
         JOptionPane.showMessageDialog(rootPane, X);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nama = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        create = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        edit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        Delete = new javax.swing.JButton();
        JKbox = new javax.swing.JComboBox();
        level = new javax.swing.JComboBox();
        refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nama.setBackground(new java.awt.Color(255, 93, 122));
        getContentPane().add(Nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 160, 40));

        pass.setBackground(new java.awt.Color(255, 93, 122));
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 160, 40));

        jLabel2.setFont(new java.awt.Font("Onyx", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 102));
        jLabel2.setText("Jenis Kelamin");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 110, 60));

        jLabel3.setFont(new java.awt.Font("Onyx", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 102));
        jLabel3.setText("Nama ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 100, 60));

        jLabel4.setFont(new java.awt.Font("Onyx", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 102));
        jLabel4.setText("Level");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 90, 60));

        jLabel5.setFont(new java.awt.Font("Onyx", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 102));
        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 110, 60));

        back.setFont(new java.awt.Font("MS PGothic", 1, 36)); // NOI18N
        back.setForeground(new java.awt.Color(102, 102, 255));
        back.setText("Back");
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 520, 130, 40));

        create.setFont(new java.awt.Font("Nyala", 0, 36)); // NOI18N
        create.setForeground(new java.awt.Color(255, 51, 51));
        create.setText("Create");
        getContentPane().add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 130, 40));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 660, 100));

        edit.setFont(new java.awt.Font("Nyala", 0, 36)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 51, 51));
        edit.setText("Edit");
        getContentPane().add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 110, 40));

        jLabel6.setFont(new java.awt.Font("Onyx", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 102));
        jLabel6.setText("NIM");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 50, 40));

        ID.setBackground(new java.awt.Color(255, 93, 122));
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 400, 40));

        Delete.setFont(new java.awt.Font("Nyala", 0, 36)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 51, 51));
        Delete.setText("Ubah Status");
        getContentPane().add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, -1, 40));

        JKbox.setFont(new java.awt.Font("Onyx", 1, 18)); // NOI18N
        JKbox.setForeground(new java.awt.Color(204, 0, 102));
        JKbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "L", "P" }));
        getContentPane().add(JKbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 160, 40));

        level.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C" }));
        getContentPane().add(level, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 160, 40));

        refresh.setFont(new java.awt.Font("Nyala", 0, 36)); // NOI18N
        refresh.setForeground(new java.awt.Color(255, 51, 51));
        refresh.setText("Refresh");
        getContentPane().add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 460, -1, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/backPBO.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JTextField ID;
    private javax.swing.JComboBox JKbox;
    private javax.swing.JTextField Nama;
    private javax.swing.JButton back;
    private javax.swing.JButton create;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox level;
    private javax.swing.JPasswordField pass;
    private javax.swing.JButton refresh;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
