/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Statistics extends javax.swing.JFrame {

    /**
     * Creates new form Statistics
     */
    public Statistics() {
        initComponents();
        showBookDetails();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        back = new javax.swing.JButton();
        IssueTb = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        IssueTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        ReturnTable = new javax.swing.JTable();
        retu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(325, 125));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Books");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 24, -1, -1));

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Publisher", "Price", "Published Year"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bookTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 54, 742, 125));

        back.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 598, -1, -1));

        IssueTb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        IssueTb.setForeground(new java.awt.Color(255, 255, 51));
        IssueTb.setText("Issue Details");
        getContentPane().add(IssueTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 197, 105, 22));

        IssueTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(IssueTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 237, 742, 102));

        ReturnTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(ReturnTable);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 397, 742, 102));

        retu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        retu.setForeground(new java.awt.Color(255, 255, 51));
        retu.setText("Return Datails");
        getContentPane().add(retu, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 352, -1, 27));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagement/l1.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void showBookDetails() {
        try {
            Connection con = javaconnect.connectdb();
            Statement st = con.createStatement();
            String query = "SELECT * FROM Book";
            ResultSet rs = st.executeQuery(query);
            
            DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
            model.setRowCount(0); // Clear existing rows
            
            while (rs.next()) {
                String bookID = rs.getString("bookID");
                String name = rs.getString("name");
                String publisher = rs.getString("publisher");
                String price = rs.getString("price");
                String publishedYear = rs.getString("publishedYear");
                
                model.addRow(new Object[]{bookID, name, publisher, price, publishedYear});
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
                                     
    try {
        Connection con = javaconnect.connectdb();
        Statement st = con.createStatement();
        
        // Query for issues where the book is not returned
        ResultSet rs = st.executeQuery(
            "SELECT IssueB.studentID, Student.FirstName, IssueB.bookID, Book.Name, IssueB.issueDate, IssueB.dueDate " +
            "FROM Student " +
            "INNER JOIN IssueB ON Student.studentID = IssueB.studentID " +
            "INNER JOIN Book ON Book.bookID = IssueB.bookID " +
            "WHERE IssueB.returnBook = 'No'");
        IssueTable.setModel(DbUtils.resultSetToTableModel(rs));
        
        // Query for issues where the book is returned
        ResultSet rs1 = st.executeQuery(
            "SELECT IssueB.studentID, Student.FirstName, IssueB.bookID, Book.Name, IssueB.issueDate, IssueB.dueDate " +
            "FROM Student " +
            "INNER JOIN IssueB ON Student.studentID = IssueB.studentID " +
            "INNER JOIN Book ON Book.bookID = IssueB.bookID " +
            "WHERE IssueB.returnBook = 'Yes'");
        ReturnTable.setModel(DbUtils.resultSetToTableModel(rs1));
        
        rs.close();
        rs1.close();
        st.close();
        con.close();
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }

    }//GEN-LAST:event_formComponentShown

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statistics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable IssueTable;
    private javax.swing.JLabel IssueTb;
    private javax.swing.JTable ReturnTable;
    private javax.swing.JButton back;
    private javax.swing.JTable bookTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel retu;
    // End of variables declaration//GEN-END:variables
}
