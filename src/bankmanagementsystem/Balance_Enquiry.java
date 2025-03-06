
package bankmanagementsystem;
import java.sql.*;
import javax.swing.JOptionPane;

public class Balance_Enquiry extends javax.swing.JFrame {

    String cardno,pinNumber;
    public Balance_Enquiry(String cardno,String pinNumber) {
        setUndecorated(true);
        initComponents();
        this.cardno=cardno;
        this.pinNumber=pinNumber;
        try
        {
            String sql;
            double balance=0;
            SQL_Connection c1=new SQL_Connection();
            sql="select *from bank_account where accountNumber = '"+cardno+"' and pin ='"+pinNumber+"'";
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
            jLabel3.setText(""+balance);
        }
        
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,"Other Error is "+e,"Error!!",0);
        }
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 220, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Current Balance  :  ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 230, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 395, 100, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/atm.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(600, 626));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        Transactions t1=new Transactions(cardno,pinNumber);
        t1.setVisible(true);
        t1.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Balance_Enquiry("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JOptionPane jOptionPane1;
    // End of variables declaration//GEN-END:variables
}
