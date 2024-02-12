/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tasks.management.system;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author bassamemad000
 */
public class LeaderMissions extends javax.swing.JFrame {
    String MissionName;
    int id;
    int employeeID;
    boolean isApproved;
    DefaultTableModel model;
    /**
     * Creates new form LeaderMissions
     */
    public LeaderMissions() {
        initComponents();
        showmissions();
    }
  public void showmissions(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tasksmanagement","root","1234");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from mission");
            while(rs.next()){
                MissionName=rs.getString("misionName");
                id=rs.getInt("id");
                employeeID=rs.getInt("employee_id");
                isApproved=rs.getBoolean("isApproved");
                Object[] obj={id,MissionName,employeeID,isApproved} ;
                model=(DefaultTableModel) LeaderMissionsTable.getModel();
                model.addRow(obj); 
            }
        }
        catch(ClassNotFoundException | SQLException e){
}
}
  
  
  //cerate mission  
  
  
  public boolean createmission(){
      boolean isAdded=false;
     MissionName=missionname.getText();
     employeeID=Integer.parseInt( employeeid.getText());
    
     try{
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tasksmanagement","root","1234");
          String sql="insert into mission(misionName, employee_id) values(?, ?)";
         PreparedStatement pst =con.prepareStatement(sql);
            pst.setString(1,MissionName);
            pst.setInt(2,employeeID);
            int rowCount=pst.executeUpdate();
            if (rowCount>0){
                isAdded=true;
            }
            else 
            {    isAdded=false;}
            
    }
    catch (Exception e){
        e.printStackTrace();
    } 
       return isAdded;
     
  }
  
  
  //update mission
  public boolean updatemission(){
      boolean isUpdated=false;
     MissionName=missionname.getText();
     employeeID=Integer.parseInt( employeeid.getText());
     id=Integer.parseInt( theid.getText());
     
      try{
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tasksmanagement","root","1234");
          String sql="update mission set misionName=?, employee_id=? where id=?";
         PreparedStatement pst =con.prepareStatement(sql);    
            pst.setString(1,MissionName);
            pst.setInt(2,employeeID);
            pst.setInt(3,id);
            int rowCount=pst.executeUpdate();
            if (rowCount>0){
                isUpdated=true;
            }
            else 
            {    isUpdated=false;}           
    }
    catch (Exception e){
        e.printStackTrace();
    } 
      return isUpdated;
  }
  
  
  //delete
  
  public boolean deletemission(){
       boolean isDeleted=false;
        id=Integer.parseInt( theid.getText());
       try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tasksmanagement","root","1234");
            String sql="delete from mission where id=?";
            PreparedStatement pst =con.prepareStatement(sql); 
            pst.setInt(1,id);
            int rowCount=pst.executeUpdate();
            if (rowCount>0){
                isDeleted=true;
            }
            else 
            {    isDeleted=false;}
            
       }
      catch (Exception e){
        e.printStackTrace();
    } 
      return isDeleted;
      
  }
  public void cleartable(){
      DefaultTableModel model =(DefaultTableModel) LeaderMissionsTable.getModel();
      model.setRowCount(0);
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
        leaderleave = new javax.swing.JButton();
        leadershowtasks = new javax.swing.JButton();
        createmission3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        createmission = new javax.swing.JButton();
        updatemission = new javax.swing.JButton();
        deletemission = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        LeaderMissionsTable = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        missionname = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        employeeid = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        theid = new javax.swing.JTextField();
        exit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        leaderleave.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        leaderleave.setText("Leave Requests");
        leaderleave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leaderleaveMouseClicked(evt);
            }
        });
        leaderleave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderleaveActionPerformed(evt);
            }
        });

        leadershowtasks.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        leadershowtasks.setText("Tasks");
        leadershowtasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leadershowtasksMouseClicked(evt);
            }
        });
        leadershowtasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leadershowtasksActionPerformed(evt);
            }
        });

        createmission3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        createmission3.setText("LOGOUT");
        createmission3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createmission3MouseClicked(evt);
            }
        });
        createmission3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createmission3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leadershowtasks, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaderleave)
                    .addComponent(createmission3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(leaderleave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(leadershowtasks, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createmission3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        createmission.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        createmission.setText("CREATE MISSION");
        createmission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createmissionActionPerformed(evt);
            }
        });

        updatemission.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        updatemission.setText("Update mission");
        updatemission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatemissionActionPerformed(evt);
            }
        });

        deletemission.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        deletemission.setText("Delete mission");
        deletemission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletemissionActionPerformed(evt);
            }
        });

        LeaderMissionsTable.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        LeaderMissionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MISSION NAME", "EMPLOYEE_ID", "isApproved"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        LeaderMissionsTable.setColumnSelectionAllowed(true);
        LeaderMissionsTable.setRowHeight(25);
        LeaderMissionsTable.setSelectionBackground(new java.awt.Color(204, 204, 255));
        LeaderMissionsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LeaderMissionsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(LeaderMissionsTable);
        LeaderMissionsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (LeaderMissionsTable.getColumnModel().getColumnCount() > 0) {
            LeaderMissionsTable.getColumnModel().getColumn(0).setResizable(false);
            LeaderMissionsTable.getColumnModel().getColumn(1).setResizable(false);
            LeaderMissionsTable.getColumnModel().getColumn(2).setResizable(false);
            LeaderMissionsTable.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(createmission)
                .addGap(120, 120, 120)
                .addComponent(updatemission)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deletemission)
                .addGap(102, 102, 102))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createmission, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updatemission, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletemission, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel23.setText("MISSIONS");

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel25.setText("MISSION NAME:");

        missionname.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel26.setText("EMPLOYEE ID:");

        employeeid.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel27.setText("      ID        :");

        theid.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        theid.setEnabled(false);
        theid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theidActionPerformed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(271, 271, 271)
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(missionname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(283, 283, 283)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(employeeid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(theid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel23))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(exit)))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(missionname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(theid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createmissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createmissionActionPerformed
            if (createmission()==true){
                JOptionPane.showMessageDialog(this,"mission added");
                cleartable();                     
             showmissions(); 
            }
            else{
                JOptionPane.showMessageDialog(this,"mission failed to add");
            }
        
        
    }//GEN-LAST:event_createmissionActionPerformed

    private void LeaderMissionsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeaderMissionsTableMouseClicked
                int row=LeaderMissionsTable.getSelectedRow();
               model=(DefaultTableModel) LeaderMissionsTable.getModel();
                missionname.setText((String) model.getValueAt(row,1));
                employeeid.setText(model.getValueAt(row,2).toString()); 
                theid.setText(model.getValueAt(row, 0).toString());
    }//GEN-LAST:event_LeaderMissionsTableMouseClicked

    private void updatemissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatemissionActionPerformed
        
        if (updatemission()==true){
                JOptionPane.showMessageDialog(this,"mission updated");
                cleartable();                     
             showmissions(); 
            }
            else{
                JOptionPane.showMessageDialog(this,"mission failed to update");
            }
    }//GEN-LAST:event_updatemissionActionPerformed

    private void deletemissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletemissionActionPerformed
        if (deletemission()==true){
                JOptionPane.showMessageDialog(this,"mission deleted");
                cleartable();                     
             showmissions(); 
            }
            else{
                JOptionPane.showMessageDialog(this,"mission failed to delete");
            }
        
    }//GEN-LAST:event_deletemissionActionPerformed

    private void leaderleaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderleaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leaderleaveActionPerformed

    private void leadershowtasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leadershowtasksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leadershowtasksActionPerformed

    private void createmission3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createmission3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_createmission3ActionPerformed

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    private void leaderleaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leaderleaveMouseClicked
        
        LeaderLeave leave=new LeaderLeave();
        this.dispose();
        leave.setVisible(true);
    }//GEN-LAST:event_leaderleaveMouseClicked

    private void leadershowtasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leadershowtasksMouseClicked
        LeaderShowTasks showtasks =new LeaderShowTasks();
        this.dispose();
        showtasks.setVisible(true);
    }//GEN-LAST:event_leadershowtasksMouseClicked

    private void createmission3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createmission3MouseClicked
        Login login =new Login();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_createmission3MouseClicked

    private void theidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_theidActionPerformed

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
            java.util.logging.Logger.getLogger(LeaderMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeaderMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeaderMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeaderMissions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeaderMissions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable LeaderMissionsTable;
    private javax.swing.JButton createmission;
    private javax.swing.JButton createmission3;
    private javax.swing.JButton deletemission;
    private javax.swing.JTextField employeeid;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton leaderleave;
    private javax.swing.JButton leadershowtasks;
    private javax.swing.JTextField missionname;
    private javax.swing.JTextField theid;
    private javax.swing.JButton updatemission;
    // End of variables declaration//GEN-END:variables
}
