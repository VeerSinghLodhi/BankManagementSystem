
package bankmanagementsystem;
import java.awt.HeadlessException;
import java.util.Date;
import java.sql.*;
import javax.swing.JOptionPane;


public class Withdraw_Cash extends javax.swing.JFrame {

   String cardno,pinNumber;
    public Withdraw_Cash(String cardno,String pinNumber) {
        setUndecorated(true);
        initComponents();
        this.cardno=cardno;
        this.pinNumber=pinNumber;
        System.out.println(pinNumber);
        
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        jButton7.setText("Withdraw");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 365, 100, 20));

        jButton8.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton8.setText("Back");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 390, 100, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter Amount For Withdrawal");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 230, -1));

        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 210, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/atm.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7jButton1ActionPerformed
        try
        {
            String amount,sql1,sql2;
            double balance=0;
            Date date=new Date();
            
            amount=jTextField4.getText();
            double amo=Double.parseDouble(amount);
            if(amount.equals("") || amount.equals("0") || amo<0)
            {
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");
                jTextField4.requestFocus();
            }
            else
            {
            
            SQL_Connection c1=new SQL_Connection();
            sql1="select *from bank_account where accountNumber = '"+cardno+"'and pin ='"+pinNumber+"'";
            ResultSet r1=c1.s1.executeQuery(sql1);
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
            
            if(balance<Double.parseDouble(amount))
            {
                jOptionPane1.showMessageDialog(this,"Insuffient Balance");
                return;
            }
            
                sql2="insert into bank_account values('"+cardno+"','"+pinNumber+"','"+date+"',"+"'Withdrawl','"+amount+"')";
                System.out.println(sql2);
                c1.s1.executeUpdate(sql2);
                JOptionPane.showMessageDialog(this,amount+" Withdraw Successfully");
                
                
                this.setVisible(false);
                Transactions t1=new Transactions(cardno,pinNumber);
                t1.setVisible(true);
                t1.setLocationRelativeTo(null);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,"Error is "+e,"Error!!",0);
        }
        catch(HeadlessException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,"Other Error is "+e,"Error!!",0);
        }
    }//GEN-LAST:event_jButton7jButton1ActionPerformed

    private void jButton8jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8jButton2ActionPerformed
        this.setVisible(false);
        Transactions t1=new Transactions(cardno,pinNumber);
        t1.setVisible(true);
        t1.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton8jButton2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
        /*try
        {
            String amount=jTextField4.getText();
            for(int i=0;i<amount.length();i++)
            {
                char ch=amount.charAt(i);
                if(!((ch>=48) && (ch<=57)))
                {
                    JOptionPane.showMessageDialog(null,"Invalid Amount!!\nPlease Enter Valid Amount");
                    jTextField4.requestFocus();
                    break;
                }
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error is "+e);
        }*/
    }//GEN-LAST:event_jTextField4FocusLost

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Withdraw_Cash("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
