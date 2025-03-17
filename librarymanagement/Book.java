/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import java.sql.*;
import javax.swing.JOptionPane;
public class Book extends javax.swing.JFrame {

    /**
     * Creates new form Book
     */
    public Book() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        Bid = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        pub = new javax.swing.JTextField();
        Save1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Close1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        year = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(325, 125));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Publisher Year");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 140, 33));

        Bid.setBackground(new java.awt.Color(255, 255, 204));
        Bid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Bid, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 103, 224, 34));

        name.setBackground(new java.awt.Color(255, 255, 204));
        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 177, 224, 32));

        pub.setBackground(new java.awt.Color(255, 255, 204));
        pub.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(pub, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 239, 224, 33));

        Save1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Save1.setText("Save");
        Save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save1ActionPerformed(evt);
            }
        });
        getContentPane().add(Save1, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 490, 138, 55));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Book ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 105, 34));

        Close1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Close1.setText("Close");
        Close1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Close1ActionPerformed(evt);
            }
        });
        getContentPane().add(Close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, 120, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 105, 32));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Publisher");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 105, 33));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Price");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 105, 34));

        price.setBackground(new java.awt.Color(255, 255, 204));
        price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 310, 224, 34));

        year.setBackground(new java.awt.Color(255, 255, 204));
        year.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(year, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 394, 224, 33));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagement/l1.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save1ActionPerformed
        // TODO add your handling code here:
        String bookID=Bid.getText();
        String Name=name.getText();
        String Publisher=pub.getText();
         String Price=price.getText();
          String PublishedYear=year.getText();
        try{
            Connection con=javaconnect.connectdb();
            Statement st=con.createStatement();
            st.executeUpdate("insert into Book values('"+bookID+"','"+Name+"','"+Publisher+"','"+Price+"','"+PublishedYear+"')");
            JOptionPane.showMessageDialog(null,"Successfully Updated");
            setVisible(false);
            new Book().setVisible(true);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            setVisible(false);
            new Book().setVisible(true);
        }
    }//GEN-LAST:event_Save1ActionPerformed

    private void Close1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Close1ActionPerformed
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_Close1ActionPerformed

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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Bid;
    private javax.swing.JButton Close1;
    private javax.swing.JButton Save1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField name;
    private javax.swing.JTextField price;
    private javax.swing.JTextField pub;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}
