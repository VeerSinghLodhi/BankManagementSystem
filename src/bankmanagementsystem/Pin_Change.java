
package bankmanagementsystem;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
public class Pin_Change extends javax.swing.JFrame {

   String cardno,pinNumber;
    public Pin_Change(String cardno,String pinNumber) {
        setUndecorated(true);
        initComponents();
        this.cardno=cardno;
        this.pinNumber=pinNumber;
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Enter your pin");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 110, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter new pin");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 110, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Confirm pin");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 110, -1));

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 100, 25));

        jPasswordField2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 100, 25));

        jPasswordField3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(jPasswordField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 100, 25));

        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 370, 100, 20));

        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 395, 100, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/atm.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        Transactions t1=new Transactions(cardno,pinNumber);
        t1.setVisible(true);
        t1.setLocationRelativeTo(null);
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            String sql,sql1,sql2,sql3;
            char [] oPin=jPasswordField3.getPassword();
            char [] nPin1=jPasswordField2.getPassword();
            char [] nPin2=jPasswordField1.getPassword();
            
            
            String oldPin=new String(oPin);
            String newPin1=new String(nPin1);
            String newPin2=new String(nPin2);
            SQL_Connection c1=new SQL_Connection();
            
            sql="select count(*) from login where pin='"+oldPin+"'";
            ResultSet r1=c1.s1.executeQuery(sql);
            int c;
            r1.next();
            c=r1.getInt(1);
            if(c==0)
            {
                jOptionPane1.showMessageDialog(this,"Old PIN is incorrect!");
            }
            else
            {
                if(newPin1.equals(newPin2))
                {
                    sql1="Update signup3 set pin='"+newPin1+"' where pin='"+pinNumber+"'";
                    sql2="Update login set pin='"+newPin1+"' where pin='"+pinNumber+"'";
                    sql3="Update bank_account set pin='"+newPin1+"' where pin='"+pinNumber+"'";


                    c1.s1.executeUpdate(sql1);
                    c1.s1.executeUpdate(sql2);
                    c1.s1.executeUpdate(sql3);
                    c1.s1.executeUpdate("Commit");

                    JOptionPane.showMessageDialog(this,"PIN Updated");
                     this.setVisible(false);
                     Transactions t1=new Transactions(cardno,newPin1);
                     t1.setVisible(true);
                     t1.setLocationRelativeTo(null);
                     
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"PIN do not match");
                }
            }
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,"Error is "+e,"Error!!",0);
        }
        catch(HeadlessException e)
        {
            JOptionPane.showMessageDialog(this,"Other Error is "+e,"Error!!",0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pin_Change("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    // End of variables declaration//GEN-END:variables
}
