package cab_booking;
import java.sql.*;
import javax.swing.JOptionPane;

public class CreateAccount extends javax.swing.JFrame {
Connection con= Connect.connectdb();
PreparedStatement ps=null;
ResultSet rs=null;

    public CreateAccount() {
        initComponents();
        setLocationRelativeTo(null);
        Connect.connectdb();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        password1 = new javax.swing.JPasswordField();
        password2 = new javax.swing.JPasswordField();
        Create = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 80)); // NOI18N
        jLabel1.setText("Create account");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 550, 80));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 186, 270, 63));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Create Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 277, 230, 47));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Re-Enter Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 369, 250, 48));

        name.setBackground(new java.awt.Color(204, 204, 204));
        name.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 196, 720, 48));

        password1.setBackground(new java.awt.Color(204, 204, 204));
        password1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password1ActionPerformed(evt);
            }
        });
        getContentPane().add(password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 280, 720, 47));

        password2.setBackground(new java.awt.Color(204, 204, 204));
        password2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(password2, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 372, 720, 48));

        Create.setBackground(new java.awt.Color(51, 153, 255));
        Create.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Create.setText("Create");
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActionPerformed(evt);
            }
        });
        getContentPane().add(Create, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 566, 182, 59));

        Reset.setBackground(new java.awt.Color(255, 51, 51));
        Reset.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });
        getContentPane().add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 567, 182, 56));

        Back.setBackground(new java.awt.Color(0, 0, 255));
        Back.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 654, 135, 44));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo-1518126085714-4f983a88f6c5.jpeg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-540, -150, 1690, 890));

        pack();
    }// </editor-fold>                        

    private void password1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
       
    }                                         

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        name.setText("");
        password1.setText("");
        password2.setText("");
        
    }                                     

    private void CreateActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
         // TODO add your handling code here:
         if (!password1.getText().equals(password2.getText())) {
        JOptionPane.showMessageDialog(null, "Passwords do not match");
        return;
    }
    
    // Query to check for existing username
    String checkUserQuery = "SELECT * FROM Userlogin  WHERE Name=?";
    String insertQuery = "INSERT INTO Userlogin (Name, Password) VALUES (?, ?)";
    if (name.getText().isEmpty() || password2.getText().isEmpty() || password1.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(null, "All fields are required. Please fill in all information.");
        return; // Exit if any required field is empty
    }
    try {
        // Check if the username already exists
        ps = con.prepareStatement(checkUserQuery);
        ps.setString(1, name.getText());
        rs = ps.executeQuery();
        
        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Username already exists. Please choose another one.");
        } else {
            // Insert the new account if the username is unique
            ps = con.prepareStatement(insertQuery);
            ps.setString(1, name.getText());
            ps.setString(2, password1.getText());
            
            int result = ps.executeUpdate();
            
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Account created successfully");
                name.setText("");
                password1.setText("");
                password2.setText("");
                dispose();
                new Userinterface().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Account creation failed");
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
        
    }                                      

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        dispose();
                new UserLogin().setVisible(true);
    }                                    

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
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* CreateAccount and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Back;
    private javax.swing.JButton Create;
    private javax.swing.JButton Reset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField password1;
    private javax.swing.JPasswordField password2;
    // End of variables declaration                   
}
