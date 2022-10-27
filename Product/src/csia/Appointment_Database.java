/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csia;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;  
import java.text.SimpleDateFormat;
import java.util.Date;
import net.proteanit.sql.DbUtils;
import java.util.Locale;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VivoBook
 */
public class Appointment_Database extends javax.swing.JFrame {
        public Connection conn=null;
        public ResultSet rs = null;
        public PreparedStatement pst=null;
        public final void ShowTableData(){
     try{
 
        
        conn = ReusableClasses.dbconnection.connection();
        String populatedatabase = "SELECT * FROM clinic_database.appointments ORDER BY `Date`, `Time slot` DESC ;";     
        pst = conn.prepareStatement(populatedatabase);
        rs = pst.executeQuery();
        
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));     

     }catch(SQLException e){ 
         System.out.println(e);
     }
     }
        
     public void printtodaysschedule(){
            Date date = new Date();
            SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate= DateFor.format(date);
        
     try{
        String selectquerry ="SELECT * FROM `clinic_database`.`appointments` WHERE (`Date`='"+ stringDate + "');";
        pst = conn.prepareStatement(selectquerry);
        rs = pst.executeQuery();
          jTable1.setModel(DbUtils.resultSetToTableModel(rs));
          jTable1.print();
        ShowTableData();
     }catch(Exception e){
        
     }   
     }
     
     
        public void printtomorrowsschedule(){
        SimpleDateFormat formatfunction = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String formateddateeee = formatfunction.format(jDateChooser2.getDate());
         try{     
         conn = ReusableClasses.dbconnection.connection();
         String selectquerry ="SELECT * FROM `clinic_database`.`appointments` WHERE (`Date`='"+ formateddateeee + "');";
         pst = conn.prepareStatement(selectquerry);
         rs = pst.executeQuery(selectquerry);      
             jTable1.setModel(DbUtils.resultSetToTableModel(rs));
             jTable1.print();
         ShowTableData();
               
         }catch(Exception e){ 
         
         }
        
        
        }
        
     
     public void deletepassedappointments(){
            
         Date date = new Date();
         SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
         String stringDate= DateFor.format(date);
         System.out.println(stringDate);

     try{     
         conn = ReusableClasses.dbconnection.connection();
         String selectquerry ="SELECT * FROM `clinic_database`.`appointments`;";
         pst = conn.prepareStatement(selectquerry);
         rs = pst.executeQuery(selectquerry);
         while (rs.next()){
         String deletepastdatequerry="DELETE FROM clinic_database.appointments WHERE (`Date`<'"+ stringDate + "');";
         pst = conn.prepareStatement(deletepastdatequerry);
         pst.executeUpdate();
         }
         ShowTableData();      
     }catch(SQLException e){ 
      
     }
     }
     
    void approvedappointment(){
    String query = "INSERT INTO `clinic_database`.`appointments` (`First name`, `Last name`,`Patient ID`, `Doctor`, `Chair`, `Time slot`, `Date`,`ID` ) VALUES (?, ?, ?, ?, ?, ?, ?, ?);" ;
    SimpleDateFormat formatfunction = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    String formateddateeee = formatfunction.format(jDateChooser1.getDate());
    int i = new Random().nextInt(90000) + 1000;
    String str = String.valueOf(i);
    try{
    conn = ReusableClasses.dbconnection.connection();           
    pst = conn.prepareStatement(query);
            
            pst.setString(1, fname.getText());
            pst.setString(2, lname.getText());
            pst.setString(3, PatientID.getText());
            pst.setString(4, doctor.getSelectedItem().toString());
            pst.setString(5, chair.getSelectedItem().toString());
            pst.setString(6, timeslot.getSelectedItem().toString());
            pst.setString(7, formateddateeee);
            pst.setString(8, str);
            pst.executeUpdate();

            
    
    }catch(SQLException e){
    System.out.println(e);
  
    }
        
    }
    
    public void SendEmail(String to,String sub,String msg){
        //Get properties object   
        String from = "dentalclinicsara@gmail.com";
        String password = "sifrazasaru12";
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);       
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  
    
   
    /**
     * Creates new form Appointment
     */
public Appointment_Database() {
         initComponents();
         ShowTableData();
         deletepassedappointments();
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        doctor = new javax.swing.JComboBox<>();
        chair = new javax.swing.JComboBox<>();
        timeslot = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        PatientID = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        PrintTable = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 202, 212));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First name", "Last name", "Doctor", "Chair", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 623, -1));

        jButton2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("Cancel appointment");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 251, 203, -1));
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 56, 203, 29));

        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 56, 203, 29));

        doctor.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        doctor.setForeground(new java.awt.Color(102, 102, 102));
        doctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dr Sara", "Dr Ema", "Dr Anita" }));
        jPanel1.add(doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 114, 203, 29));

        chair.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        chair.setForeground(new java.awt.Color(102, 102, 102));
        chair.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blue Chair", "Green Chair" }));
        jPanel1.add(chair, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 114, 203, 29));

        timeslot.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        timeslot.setForeground(new java.awt.Color(102, 102, 102));
        timeslot.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:00-9:00", "9:15-10:15", "10:00-11:00", "11:00-12:00", "12:00-13:00", "15:00-16:00" }));
        jPanel1.add(timeslot, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 161, 203, 29));

        jButton3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 102, 102));
        jButton3.setText("Book appointment");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 208, 203, -1));
        jPanel1.add(PatientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 14, 203, 29));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 161, 203, 29));

        PrintTable.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        PrintTable.setForeground(new java.awt.Color(102, 102, 102));
        PrintTable.setText("Print today's schedule");
        PrintTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintTableActionPerformed(evt);
            }
        });
        jPanel1.add(PrintTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 209, -1, -1));

        jButton1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("Search by ID");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 13, 203, -1));

        jButton4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(102, 102, 102));
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(786, 387, 196, -1));

        jDateChooser2.setForeground(new java.awt.Color(102, 102, 102));
        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 293, 203, 29));

        jButton5.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(102, 102, 102));
        jButton5.setText("Print specific schedule");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 293, -1, -1));

        jButton6.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(102, 102, 102));
        jButton6.setText("Send email");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(786, 340, 196, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         
         String chaircomparison2 = chair.getSelectedItem().toString();
         String timeslotcomparison2 = timeslot.getSelectedItem().toString();
         String doctortcomparison2 = doctor.getSelectedItem().toString();
         SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
         String date = dcn.format(jDateChooser1.getDate());
         String selectquerry ="SELECT `Date`, `Chair`, `Time slot`,`Doctor`  FROM `clinic_database`.`appointments`;";
         
        
         
         try{
            conn = ReusableClasses.dbconnection.connection();           
            pst = conn.prepareStatement(selectquerry);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery (selectquerry);
            
               if (!rs.next()){
               
               approvedappointment();
               
               
               }else{
               while(rs.next()){
                
                String datecomparison1 = rs.getString("Date");
                String chaircomparison1 = rs.getString("Chair");
                String timeeslotcomparison1 = rs.getString("Time slot");
                String doctorcomparison1= rs.getString("Doctor");
      
                if(datecomparison1.equals(date) && chaircomparison1.equals(chaircomparison2)&& doctorcomparison1.equals(doctortcomparison2)&& timeeslotcomparison1.equals(timeslotcomparison2)){                       
                JOptionPane.showMessageDialog(null, "Appointment is already taken! Please try another one.");
            
                break;
                }
                if(rs.isAfterLast()){
            
                approvedappointment();
                rs.close();
                }               
              }
                if(rs.isAfterLast()){
            
                approvedappointment();
                rs.close();
                }
               }
               ShowTableData();
       }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e);
       }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
             try{
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            int rownumber = jTable1.getSelectedRow();
            String temporaryidentity=  model.getValueAt(rownumber, 7).toString();
            int finalidentity = Integer.parseInt(temporaryidentity);
            String deletequerry="DELETE FROM clinic_database.appointments WHERE (`ID` = '" + finalidentity +"');" ;
            conn = ReusableClasses.dbconnection.connection();
            pst = conn.prepareStatement(deletequerry);      
            pst.executeUpdate();

            ShowTableData();

            } catch(NumberFormatException | SQLException e){
            JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void PrintTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintTableActionPerformed
            printtodaysschedule();
    }//GEN-LAST:event_PrintTableActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     String SearchID = PatientID.getText();
     String searchquerry="Select * FROM `clinic_database`.`patients` WHERE (`ID` = '" + SearchID +"');" ;
     try{
      conn = ReusableClasses.dbconnection.connection();           
      pst = conn.prepareStatement(searchquerry);
      rs = pst.executeQuery(searchquerry);
      if(rs.next()){
      String name = rs.getString("First Name");
      String lastname = rs.getString("Last Name");
      fname.setText(name);
      lname.setText(lastname);
      }
   
    }catch(SQLException e){
     System.out.println(e);
     }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Dashboard Dash= new Dashboard ();
        Dash.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        String Firsttname = (model.getValueAt(selectedRowIndex, 0).toString());
        String Lastname = (model.getValueAt(selectedRowIndex, 1).toString());
        String ID = (model.getValueAt(selectedRowIndex, 2).toString());
        String Doctor = (model.getValueAt(selectedRowIndex, 3).toString());
        String Chair = (model.getValueAt(selectedRowIndex, 4).toString());
        String Timeslot = (model.getValueAt(selectedRowIndex, 5).toString());
        String Date = (model.getValueAt(selectedRowIndex, 6).toString());  
        String content = "Dear " + Firsttname+ " " + Lastname+ " \n " + 
                " Your appointment has been scheduled for the following date: " + Date+ " \n " +
                " Doctor: " + Doctor+" \n" +
                " Chair: "+ Chair + " \n"+
                "Time: " + Timeslot  +" ";
        String subject = "Appointment with the Dental Clinic Dr Sata";
     
       String populatedatabase = "SELECT `Email` FROM `clinic_database`.patients WHERE (`ID`='" + ID + "');";
         try{
        conn = ReusableClasses.dbconnection.connection();           
        pst = conn.prepareStatement(populatedatabase);
        rs = pst.executeQuery(populatedatabase);  
        if(rs.next()){
        String recepientemail = rs.getString("Email");
        SendEmail(recepientemail, subject, content);
        }
        
        }catch(SQLException e){
        System.out.println(e);
        }

            
                
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
printtomorrowsschedule();       
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Appointment_Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Appointment_Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Appointment_Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Appointment_Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Appointment_Database().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PatientID;
    private javax.swing.JButton PrintTable;
    private javax.swing.JComboBox<String> chair;
    private javax.swing.JComboBox<String> doctor;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lname;
    private javax.swing.JComboBox<String> timeslot;
    // End of variables declaration//GEN-END:variables
}
