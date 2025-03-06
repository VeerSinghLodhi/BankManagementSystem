
package bankmanagementsystem;
import java.sql.*;

public class LoginPage extends javax.swing.JFrame {

    
    public LoginPage() {
        initComponents();
        
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign In");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("WELCOME TO ATM");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(300, 60, 338, 48);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo.bank.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(190, 20, 100, 100);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Card No.");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(140, 170, 101, 35);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jPanel1.add(jTextField1);
        jTextField1.setBounds(290, 160, 343, 43);

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(290, 230, 343, 43);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PIN");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(140, 240, 42, 32);

        jButton1.setBackground(new java.awt.Color(0, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Sign In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(290, 330, 128, 34);

        jButton2.setBackground(new java.awt.Color(0, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(510, 330, 128, 34);

        jButton3.setBackground(new java.awt.Color(0, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Sign Up");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(290, 390, 343, 34);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loginBackground1.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 800, 500);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText(null);
        jPasswordField1.setText(null);
        jTextField1.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        SignUpPage1 s1=new SignUpPage1();
        s1.setVisible(true);
        s1.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        String cardno,pin,sql;
        cardno=jTextField1.getText();
        char [] p=jPasswordField1.getPassword();
        pin=new String(p);
        
        try
        {
            SQL_Connection s=new SQL_Connection();
            sql="select count(*) from login where card_number='"+cardno+"'and pin='"+pin+"'";
            System.out.println(sql);
            ResultSet r1;
            r1=s.s1.executeQuery(sql);
            r1.next();
            int c=r1.getInt(1);
            //System.out.println(c);
            
            if(c==0)
                jOptionPane1.showMessageDialog(this,"Invalid Card Number/Pin ","Invalid Information",0);
            else 
            {
                this.setVisible(false);
                Transactions a1=new Transactions(cardno,pin);
                a1.setVisible(true);
                a1.setLocationRelativeTo(null);
            }
            
            
            
        }
        catch(SQLException e)
        {
            jOptionPane1.showMessageDialog(this,"Error is "+e,"Error!!",0);
        }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(this,"Other Error is "+e,"Error!!",0);
        }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               LoginPage l1=new LoginPage();
                l1.setVisible(true);
                l1.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
