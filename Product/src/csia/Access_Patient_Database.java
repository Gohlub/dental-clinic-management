/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csia;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author VivoBook
 */
public class Access_Patient_Database extends javax.swing.JFrame {
public Connection conn=null;
    public ResultSet rs = null;
    public PreparedStatement pst=null;
    
    public final void ShowTableData(){
    try{
    conn = ReusableClasses.dbconnection.connection();
    String populatedatabase = "SELECT * FROM `clinic_database`.patients;";
    pst = conn.prepareStatement(populatedatabase);
    rs = pst.executeQuery();
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));  
    jTable1.getColumnModel().getColumn(3).setMinWidth(0);
    jTable1.getColumnModel().getColumn(3).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(5).setMinWidth(0);
    jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(6).setMinWidth(0);
    jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(7).setMinWidth(0);
    jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(8).setMinWidth(0);
    jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(9).setMinWidth(0);
    jTable1.getColumnModel().getColumn(9).setMaxWidth(0);
    } catch(SQLException e){
        
    }
    }
    
    Patient_Data SelectedData = new Patient_Data();
  
    public Access_Patient_Database()
    {
        initComponents();
        ShowTableData();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ID = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 202, 212));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First name", "Last name", "Gender", "Age", "Phone number", "Address", "Designated doctor"
            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select patient");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("Search by ID");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jButton2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("Show all");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 102, 102));
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(139, 139, 139)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        
        
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased

    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        try{
        int selectedRowIndex = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        String ID = model.getValueAt(selectedRowIndex, 0).toString();
        String firstname = model.getValueAt(selectedRowIndex, 1).toString();
        String lastname = model.getValueAt(selectedRowIndex, 2).toString();
        String genders= model.getValueAt(selectedRowIndex, 3).toString();        
        String age = model.getValueAt(selectedRowIndex, 4).toString();
        String phonenumber = model.getValueAt(selectedRowIndex, 5).toString();
        String address = model.getValueAt(selectedRowIndex, 6).toString();
        String doctor =model.getValueAt(selectedRowIndex, 7).toString();
        String filep = model.getValueAt(selectedRowIndex, 8).toString();
    
        Patient_Data dataframe = new Patient_Data ();
        dataframe.setVisible(true);
        SelectedData.pack();
        SelectedData.setLocationRelativeTo(null);
        SelectedData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      
        Patient_Data.IDdat.setText(ID);
        Patient_Data.fnamedata.setText(firstname);
        Patient_Data.lnamedata.setText(lastname);
        Patient_Data.agedata.setText(age);
        
        switch(genders){
            case "Male":
            Patient_Data.genderdata.setText("Male");
            break;
            case "Female":
            Patient_Data.genderdata.setText("Female");
            break;

        }
        Patient_Data.phonenumberdata.setText(phonenumber);
        Patient_Data.addressdata.setText(address);
        switch(doctor){
            case "Dr Sara":
            Patient_Data.designateddoctordata.setText("Dr Sara");
                    break;
            case "Dr Ema":
             Patient_Data.designateddoctordata.setText("Dr Ema");
            break;
            case "Dr Anita":
             Patient_Data.designateddoctordata.setText("Dr Anita");
            break;
        } 
         Patient_Data.filepathdata.setText(filep);
        }catch(Exception e){
    System.out.println(e);
    
    }
      
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     String SearchID = ID.getText();
     String searchquerry="SELECT * FROM `clinic_database`.`patients` WHERE (`ID` = '" + SearchID +"');" ;
     
     try{
     pst = conn.prepareStatement(searchquerry);
     rs = pst.executeQuery();
     jTable1.setModel(DbUtils.resultSetToTableModel(rs));
     jTable1.getColumnModel().getColumn(3).setMinWidth(0);
     jTable1.getColumnModel().getColumn(3).setMaxWidth(0);
     jTable1.getColumnModel().getColumn(5).setMinWidth(0);
     jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
     jTable1.getColumnModel().getColumn(6).setMinWidth(0);
     jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
     jTable1.getColumnModel().getColumn(7).setMinWidth(0);
     jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
     jTable1.getColumnModel().getColumn(8).setMinWidth(0);
     jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
     jTable1.getColumnModel().getColumn(9).setMinWidth(0);
     jTable1.getColumnModel().getColumn(9).setMaxWidth(0);
    }catch(SQLException E){
    System.out.println(E);
     }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      try{
     conn = ReusableClasses.dbconnection.connection();
     String populatedatabase = "SELECT * FROM clinic_database.patients;";
     
     pst = conn.prepareStatement(populatedatabase);
     rs = pst.executeQuery();
     jTable1.setModel(DbUtils.resultSetToTableModel(rs));
     jTable1.getColumnModel().getColumn(3).setMinWidth(0);
     jTable1.getColumnModel().getColumn(3).setMaxWidth(0);
     jTable1.getColumnModel().getColumn(5).setMinWidth(0);
     jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
     jTable1.getColumnModel().getColumn(6).setMinWidth(0);
     jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
     jTable1.getColumnModel().getColumn(7).setMinWidth(0);
     jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
     jTable1.getColumnModel().getColumn(8).setMinWidth(0);
     jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
     jTable1.getColumnModel().getColumn(9).setMinWidth(0);
     jTable1.getColumnModel().getColumn(9).setMaxWidth(0);
     jTable1.getColumnModel().getColumn(8).setMinWidth(0);
     jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
    
    } catch(SQLException e){  
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       Dashboard Dash= new Dashboard ();
        Dash.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Access_Patient_Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Access_Patient_Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Access_Patient_Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Access_Patient_Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Access_Patient_Database().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
