/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs;

import codes.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Ravindu Sandaruwan
 */
public class Admin extends javax.swing.JFrame {

    Connection conn= null;
    PreparedStatement pst =null;
    ResultSet rs =null;
    
    public Admin() {  
        initComponents();
        conn = DBconnect.connect();
    }
    
    //load doctors table
    public void doctors(){
    
        try {
            String sql = "SELECT type , name ,special , day from doctors";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
 
     }
    
    //dental load
    public void dental(){
    
        try {
            String sql = "SELECT Day , Time ,Doctor , Ward from dental";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
 
     }
    
    //load eye clinic
    public void eyeclinic(){
    
        try {
            String sql = "SELECT Day , Time ,Doctor , Ward from  eyeclinic";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
 
     }
 
    //inserting data to doctors
    public void insertDoctors(){
        String tag1 = t1.getText();
        String tag2 = t2.getText();
        String tag3 = t3.getText();
        String tag4 = t4.getText();
        try {
            
            String sql = "INSERT INTO doctors (type,name,special,day) VALUES ('"+tag1+"','"+tag2+"','"+tag3+"','"+tag4+"')";
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        doctors();
    
    }
    
    //showing table content in field
    public void tableData(){
        int row = table1.getSelectedRow();
        
        String tag1 = (String) table1.getValueAt(row,0);
        String tag2 = table1.getValueAt(row, 1).toString();
        String tag3 = table1.getValueAt(row,2).toString();
        String tag4 = table1.getValueAt(row,3).toString();
        
        t1.setText(tag1);
        t2.setText(tag2);
        t3.setText(tag3);
        t4.setText(tag4);
        
   }
    
  //update doctors
   public void updateDoctors(){
       
       int row = table1.getSelectedRow();
       
       String tag1= t1.getText();
       String tag2= t2.getText();
       String tag3= t3.getText();
       String tag4= t4.getText();
       
       try {
           String sql = "UPDATE doctors SET type='"+tag1+"',special='"+tag3+"',day='"+tag4+"' WHERE name='"+tag2+"' ";
           pst= conn.prepareStatement(sql);
           pst.execute();
           JOptionPane.showMessageDialog(null,"Updated");
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
       }
   
   }
   
   //update dental
   public void updateDental(){
       
       int row = table1.getSelectedRow();
       String tag1= t1.getText();
       String tag2= t2.getText();
       String tag3= t3.getText();
       String tag4= t4.getText();
       
       try {
           String sql = "UPDATE dental SET Time='"+tag2+"',Doctor='"+tag3+"',Ward='"+tag4+"' WHERE Day='"+tag1+"' ";
           pst= conn.prepareStatement(sql);
           pst.execute();
           JOptionPane.showMessageDialog(null,"Updated");
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
       }
   
   }
   
   //update eyeclinic
   public void updateEyeclinic(){
       
       String tag1= t1.getText();
       String tag2= t2.getText();
       String tag3= t3.getText();
       String tag4= t4.getText();
       
       try {
           String sql = "UPDATE eyeclinic SET Day='"+tag1+"', Time='"+tag2+"',Doctor='"+tag3+"',Ward='"+tag4+"' WHERE Day='"+tag1+"' ";
           pst= conn.prepareStatement(sql);
           pst.execute();
           JOptionPane.showMessageDialog(null,"Updated");
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
       }
   
   } 
   
   //deleteDoctors
   public void deleteDoctors(){
       int check = JOptionPane.showConfirmDialog(null, "Do you want to delete");
       
      
       String name= t2.getText();
       
       
       if(check==0){
           try {
               String sql = "DELETE FROM doctors WHERE name='"+name+"'";
               pst= conn.prepareStatement(sql);
               pst.execute();
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e);
           }
      }   
   } 
  
   //deletedental
   public void deleteDental(){
       int check = JOptionPane.showConfirmDialog(null, "Do you want to delete");
       
      
       String Day= t1.getText();
       
       
       if(check==0){
           try {
               String sql = "DELETE FROM dental WHERE Day='"+Day+"'";
               pst= conn.prepareStatement(sql);
               pst.execute();
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e);
           }
      }   
   }
   
   //delet Eyeclinic
   public void deleteEyeclinic(){
       int check = JOptionPane.showConfirmDialog(null, "Do you want to delete");
       
      
       String Day= t1.getText();
       
       
       if(check==0){
           try {
               String sql = "DELETE FROM eyeclinic WHERE Day='"+Day+"'";
               pst= conn.prepareStatement(sql);
               pst.execute();
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e);
           }
      }   
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
        table1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        tableBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        insertBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 480, 490));

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tableBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT TABLE", "Doctors Table", "Dental Clinic", "Eye Clinic" }));
        tableBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Table Name");

        l1.setText("L1");

        l2.setText("L2");

        l3.setText("L3");

        l4.setText("L4");

        t3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(tableBox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l1)
                            .addComponent(l2)
                            .addComponent(l3)
                            .addComponent(l4))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t1)
                            .addComponent(t2)
                            .addComponent(t3)
                            .addComponent(t4, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tableBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(l1))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(l2))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(l3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l4)
                    .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, 310));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        insertBtn.setText("Insert");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });
        jPanel5.add(insertBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        jPanel5.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        jPanel5.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        jPanel5.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 70, -1));

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel5.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 70, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 260, 180));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void t3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t3ActionPerformed

    private void tableBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableBoxActionPerformed
        int choice = tableBox.getSelectedIndex();
        if(choice==1){
            doctors();
            l1.setText("Type");
            l2.setText("Name");
            l3.setText("Special");
            l4.setText("Day");
           
        }else if(choice==2){
            dental();
            l1.setText("Day");
            l2.setText("Time");
            l3.setText("Doctor");
            l4.setText("Ward");
        }else if(choice==3){
            eyeclinic();
            l1.setText("Day");
            l2.setText("Time");
            l3.setText("Doctor");
            l4.setText("Ward");
        }
    }//GEN-LAST:event_tableBoxActionPerformed

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        int choice = tableBox.getSelectedIndex();
        if(choice==1){
         insertDoctors();
        }else if(choice==2){
         JOptionPane.showMessageDialog(null,"Only can update");
        }else if(choice==3){
         JOptionPane.showMessageDialog(null,"Only can update");
        }

    }//GEN-LAST:event_insertBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        int choice = tableBox.getSelectedIndex();
        if(choice==1){
            //update doctors
            updateDoctors();
            doctors();
        }else if(choice==2){
            //update dental
            updateDental();
            dental();
        }else if(choice==3){
            //update eyeclinic
            updateEyeclinic();
            eyeclinic();
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        tableData();
    }//GEN-LAST:event_table1MouseClicked

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        intrfce m1 = new intrfce();
        m1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
       int choice = tableBox.getSelectedIndex();
        if(choice==1){
            //update doctors
            deleteDoctors();
            doctors();
        }else if(choice==2){
            //update dental
            deleteDental();
            dental();
        }else if(choice==3){
            //update eyeclinic
            deleteEyeclinic();
            eyeclinic();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTable table1;
    private javax.swing.JComboBox<String> tableBox;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
