
package bankmanagementsystem;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;

public class Fast_Cash extends javax.swing.JFrame {

   String cardno,pinNumber;
   double balance=0;
   
   SQL_Connection c1;
    public Fast_Cash(String cardno,String pinNumber) {
        setUndecorated(true);
        initComponents();
        this.cardno=cardno;
        this.pinNumber=pinNumber;
        try
        {
                String sql;
                c1=new SQL_Connection();
                sql="select *from bank_account where accountNumber ='"+cardno+"' and pin ='"+pinNumber+"'";
                ResultSet r1=c1.s1.executeQuery(sql);
                while(r1.next())
                {
                    if(r1.getString("type").equals("Deposit"))
                    {
                        balance+=Double.parseDouble(r1.getString("amount"));
                    }
                    else
                    {
                        balance-=Double.parseDouble(r1.getString("amount"));
                    }
                    
                }
                System.out.println(balance);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,"Error is "+e,"Error!!",0);
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,"Other Error is "+e,"Error!!",0);
        }
    }

    @SuppressWarnings("unchecked")
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 626));
        getContentPane().setLayout(null);

        jButton11.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton11.setText("Rs.500");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11);
        jButton11.setBounds(105, 345, 100, 20);

        jButton12.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton12.setText("Rs.2000");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12);
        jButton12.setBounds(105, 370, 100, 20);

        jButton13.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton13.setText("Rs.5000");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13);
        jButton13.setBounds(245, 370, 100, 20);

        jButton14.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton14.setText("Back");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14);
        jButton14.setBounds(245, 395, 100, 20);

        jButton9.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton9.setText("Rs.100");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(105, 320, 100, 20);

        jButton10.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton10.setText("Rs.200");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10);
        jButton10.setBounds(245, 320, 100, 20);

        jButton15.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton15.setText("Rs.1000");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15);
        jButton15.setBounds(245, 345, 100, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/atm.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 626);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton12jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12jButton5ActionPerformed
        CheckBalance(2000);
    }//GEN-LAST:event_jButton12jButton5ActionPerformed

    private void jButton13jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13jButton6ActionPerformed
            CheckBalance(5000);
        
    }//GEN-LAST:event_jButton13jButton6ActionPerformed
    
    private void jButton14jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14jButton7ActionPerformed
          this.setVisible(false);
          Transactions t1=new Transactions(cardno,pinNumber);
          t1.setVisible(true);
          t1.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton14jButton7ActionPerformed
    void CheckBalance(double amount)
    {
         String sql;
         Date date=new Date();
         System.out.println(date);
           if(balance<amount)
           {
               JOptionPane.showMessageDialog(this,"Insuffient Balance");
                    return;
           }
           try
           {
                sql="insert into bank_account values('"+cardno+"','"+pinNumber+"','"+date+"',"+"'Withdrawl','"+amount+"')";
                c1.s1.executeUpdate(sql);
                JOptionPane.showMessageDialog(this,"Withdraw Successfully "+amount);
                
                this.setVisible(false);
                Transactions t1=new Transactions(cardno,pinNumber);
                t1.setVisible(true);
                t1.setLocationRelativeTo(null);
                
           }
           catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,"Error is "+e,"Error!!",0);
        }
        catch(HeadlessException e)
        {
            JOptionPane.showMessageDialog(this,"Other Error is "+e,"Error!!",0);
        }
    }
    private void jButton9jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9jButton1ActionPerformed
        CheckBalance(100);
    }//GEN-LAST:event_jButton9jButton1ActionPerformed

    private void jButton10jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10jButton2ActionPerformed
    CheckBalance(200);
    }//GEN-LAST:event_jButton10jButton2ActionPerformed

    private void jButton15jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15jButton3ActionPerformed
        CheckBalance(1000);
    }//GEN-LAST:event_jButton15jButton3ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
         CheckBalance(500);
    }//GEN-LAST:event_jButton11ActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fast_Cash("","").setVisible(true);
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
    private javax.swing.JOptionPane jOptionPane1;
    // End of variables declaration//GEN-END:variables
}
