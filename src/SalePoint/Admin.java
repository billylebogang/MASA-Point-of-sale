/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SalePoint;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 *
 * @author lb19000961
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
    }
    
        public static String setDate(){ //method to get time
        
        LocalDate ate = LocalDate.now();
        String date = ate.toString();
        
       
     
        return date;
    }
     public static String setTime(){ //method to get date 
        LocalTime ime = LocalTime.now();
        
        String time = ime.toString();
        
       
     
        return time;
    } 
    String dat = setDate();
    
    public void registerLogout(String loguser){ // this method writes to a log file when they log out
         try{
            //creting a file write with file name
            
            
             BufferedWriter logfw = new BufferedWriter(new FileWriter("C:\\Users\\lebog\\OneDrive - biust.ac.bw\\Desktop\\login-regitser.txt", true)); //this will write to the cashier log
            
            String details1 = " MASA GENERAL DEALER \n     Fax:3314256 \n    Cell: 72187246 \n lebogangbilli@gmail.com \n \n"; //writing the store name
            logfw.append("\n user Admin log out! time :"+setTime()+"  date:"+setDate()); //appendin detail of log out
            logfw.append("\n ***************************************************\n");
            logfw.close(); //closing the file
        
        }
        catch(IOException e){ //catching the errors if the it fails to update
            e.printStackTrace();
            System.out.println("Not able to write into the file");
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
        addStockBtn = new javax.swing.JButton();
        addUserBtn = new javax.swing.JButton();
        stockListBtn = new javax.swing.JButton();
        soldStockbtn = new javax.swing.JButton();
        weeklyBtn = new javax.swing.JButton();
        montlyBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 0));

        addStockBtn.setBackground(new java.awt.Color(153, 153, 0));
        addStockBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        addStockBtn.setForeground(new java.awt.Color(255, 255, 255));
        addStockBtn.setText("Add stock");
        addStockBtn.setBorder(null);
        addStockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStockBtnActionPerformed(evt);
            }
        });

        addUserBtn.setBackground(new java.awt.Color(153, 153, 0));
        addUserBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        addUserBtn.setForeground(new java.awt.Color(255, 255, 255));
        addUserBtn.setText("Add user");
        addUserBtn.setBorder(null);
        addUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtnActionPerformed(evt);
            }
        });

        stockListBtn.setBackground(new java.awt.Color(153, 153, 0));
        stockListBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        stockListBtn.setForeground(new java.awt.Color(255, 255, 255));
        stockListBtn.setText("Stock List");
        stockListBtn.setBorder(null);
        stockListBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockListBtnActionPerformed(evt);
            }
        });

        soldStockbtn.setBackground(new java.awt.Color(153, 153, 0));
        soldStockbtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        soldStockbtn.setForeground(new java.awt.Color(255, 255, 255));
        soldStockbtn.setText("Stock sold");
        soldStockbtn.setBorder(null);
        soldStockbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soldStockbtnActionPerformed(evt);
            }
        });

        weeklyBtn.setBackground(new java.awt.Color(153, 153, 0));
        weeklyBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        weeklyBtn.setForeground(new java.awt.Color(255, 255, 255));
        weeklyBtn.setText("Weekly sales");
        weeklyBtn.setBorder(null);

        montlyBtn.setBackground(new java.awt.Color(153, 153, 0));
        montlyBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        montlyBtn.setForeground(new java.awt.Color(255, 255, 255));
        montlyBtn.setText("Monthly sales");
        montlyBtn.setBorder(null);
        montlyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montlyBtnActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 153, 0));
        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Admin Dashboard");

        jLabel2.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        jLabel2.setText("Masa General Dealer");

        logoutBtn.setBackground(new java.awt.Color(255, 0, 51));
        logoutBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Log out");
        logoutBtn.setBorder(null);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(soldStockbtn)
                    .addComponent(addStockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(weeklyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(montlyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(stockListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addStockBtn, addUserBtn, montlyBtn, soldStockbtn, stockListBtn, weeklyBtn});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addStockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stockListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(soldStockbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(weeklyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(montlyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addStockBtn, addUserBtn, montlyBtn, soldStockbtn, stockListBtn, weeklyBtn});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBtnActionPerformed
        // TODO add your handling code here:
        
        NewUser user = new NewUser(); //new object of the adding the user
        user.show();
        
        
    }//GEN-LAST:event_addUserBtnActionPerformed

    private void stockListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockListBtnActionPerformed
        // TODO add your handling code here:
        StockList stList= new StockList(); //new object of the adding the user
        stList.show();
        
        
    }//GEN-LAST:event_stockListBtnActionPerformed

    private void soldStockbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soldStockbtnActionPerformed
        // TODO add your handling code here:
        
        StockSold stsold = new StockSold();
        stsold.show();
       
    }//GEN-LAST:event_soldStockbtnActionPerformed

    private void montlyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montlyBtnActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_montlyBtnActionPerformed

    private void addStockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStockBtnActionPerformed

        // TODO add your handling code here:
        
        captureStock cap = new captureStock();
        cap.show();
        
    }//GEN-LAST:event_addStockBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
          //confirminng log out
          int conf = JOptionPane.showConfirmDialog(null,"You are about to be logged out", "confirm logout!", JOptionPane.DEFAULT_OPTION);
        // 0=ok
        if (conf == 0){
            Login in = new Login(); //creating a login screen object
            String cashier  = "admin";// gettin the value of logged in user
            registerLogout(cashier); //registering the log in to the file
            this.dispose();// diposing the screen
            in.show();
        }
    }//GEN-LAST:event_logoutBtnActionPerformed

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
    private javax.swing.JButton addStockBtn;
    private javax.swing.JButton addUserBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton montlyBtn;
    private javax.swing.JButton soldStockbtn;
    private javax.swing.JButton stockListBtn;
    private javax.swing.JButton weeklyBtn;
    // End of variables declaration//GEN-END:variables
}
