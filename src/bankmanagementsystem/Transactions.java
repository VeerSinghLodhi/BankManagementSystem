
package bankmanagementsystem;
import java.sql.*;
import javax.swing.JOptionPane;



public class Transactions extends javax.swing.JFrame {

    String cardno, pinNumber;
    public Transactions(String cardno,String pinNumber) {
        this.cardno=cardno;
        this.pinNumber=pinNumber;
        setUndecorated(true);
        initComponents();
    }
    
    public void Bank_Account()
    {
        try
        {
            String sql;
            SQL_Connection s=new SQL_Connection();
            sql="";
            s.s1.executeUpdate(sql);
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,"Error is "+e,"Error!!",0);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Other Error is "+e,"Error!!",0);
        }
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ATM");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton11.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton11.setText("Statement");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 345, 100, 20));

        jButton12.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton12.setText("Pin change");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 370, 100, 20));

        jButton13.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton13.setText("Balance");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 370, 100, 20));

        jButton14.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton14.setText("Exit");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 395, 100, 20));

        jButton9.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton9.setText("Deposit");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 320, 100, 20));

        jButton10.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton10.setText("withdraw");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 320, 100, 20));

        jButton15.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton15.setText("Fact Cash");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 345, 100, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select a Service");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/atm.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton15jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15jButton3ActionPerformed
        this.setVisible(false);
        Fast_Cash f1=new Fast_Cash(cardno,  pinNumber);
        f1.setVisible(true);
        f1.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton15jButton3ActionPerformed

    private void jButton10jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10jButton2ActionPerformed
        this.setVisible(false);
        Withdraw_Cash w1=new Withdraw_Cash(cardno,pinNumber);
        w1.setVisible(true);
        w1.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton10jButton2ActionPerformed

    private void jButton9jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9jButton1ActionPerformed
        this.setVisible(false);
        Deposit_Cash d1=new Deposit_Cash(cardno,pinNumber);
        d1.setVisible(true);
        d1.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton9jButton1ActionPerformed

    private void jButton14jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14jButton7ActionPerformed
        int c;
        c=JOptionPane.showConfirmDialog(this,"Are You Sure","??",2);

        if(c==0)
        System.exit(0);
    }//GEN-LAST:event_jButton14jButton7ActionPerformed

    private void jButton13jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13jButton6ActionPerformed

        this.setVisible(false);
        Balance_Enquiry b1=new Balance_Enquiry(cardno,pinNumber);
        b1.setVisible(true);
        b1.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton13jButton6ActionPerformed

    private void jButton12jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12jButton5ActionPerformed
        this.setVisible(false);
        Pin_Change p1=new Pin_Change(cardno,pinNumber);
        p1.setVisible(true);
        p1.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton12jButton5ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Mini_Statement m1=new Mini_Statement(cardno,pinNumber);
        m1.setVisible(true);
        m1.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton11ActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transactions("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JOptionPane jOptionPane1;
    // End of variables declaration//GEN-END:variables
}
