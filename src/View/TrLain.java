/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import com.sun.org.apache.bcel.internal.Constants;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;//koding untuk mengimport swing tabel
/**
 *
 * @author S855
 */
public class TrLain extends javax.swing.JFrame {
//koneksi tk=new koneksi();
    /**
     * Creates new form login
     */
    public TrLain() {
        initComponents();
        
    }
   public void ListenerBack(ActionListener act){
        back.addActionListener(act);
    }
   
   public void ListenerRekam(ActionListener act){
        Rekam.addActionListener(act);
    }
     
      public String getTr(){
       String data=String.valueOf( trans.getSelectedItem());
       return data;
    }
      public String getnominal(){
          return nominal.getText();
      }
//       public void setTabel(){
//       String data=String.valueOf( trans.getSelectedItem());
//       
//    }
       public void setjurnal(DefaultTableModel m){
           tabel.setModel(m);
       }
       
        public void setPesan(String X) {
         JOptionPane.showMessageDialog(rootPane, X);

    }
// 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        trans = new javax.swing.JComboBox();
        Rekam = new javax.swing.JButton();
        back = new javax.swing.JButton();
        nominal = new javax.swing.JTextField();
        bagrou = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Trans", "Keterangan", "Debet", "Credit"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 280, 660, 250));

        trans.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pembayaran Iklan", "Penerimaan piutang" }));
        trans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transActionPerformed(evt);
            }
        });
        getContentPane().add(trans, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 190, 40));

        Rekam.setText("Rekam");
        getContentPane().add(Rekam, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 90, 40));

        back.setText("Back");
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 540, 110, 50));
        getContentPane().add(nominal, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 130, 30));

        bagrou.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/backPBO.png"))); // NOI18N
        getContentPane().add(bagrou, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void transActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrLain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrLain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrLain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrLain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrLain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Rekam;
    private javax.swing.JButton back;
    private javax.swing.JLabel bagrou;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nominal;
    private javax.swing.JTable tabel;
    private javax.swing.JComboBox trans;
    // End of variables declaration//GEN-END:variables
}
