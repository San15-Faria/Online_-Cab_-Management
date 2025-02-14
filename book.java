package cab_booking;

import java.sql.*;
import javax.swing.JOptionPane;
public class Book extends javax.swing.JFrame {
Connection con=Connect.connectdb();
PreparedStatement ps=null;
ResultSet rs=null;
    public Book() {
        initComponents();
                setLocationRelativeTo(null);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        phoneno = new javax.swing.JTextField();
        ppl = new javax.swing.JTextField();
        start = new javax.swing.JTextField();
        last = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        BACK = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        comboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Phone no");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 150, 44));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No of people");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 200, 44));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 124, 44));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("To");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 124, 44));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("From");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 124, 44));

        name.setBackground(new java.awt.Color(204, 204, 204));
        name.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 715, 44));

        phoneno.setBackground(new java.awt.Color(204, 204, 204));
        phoneno.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(phoneno, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 715, 41));

        ppl.setBackground(new java.awt.Color(204, 204, 204));
        ppl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(ppl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 715, 44));

        start.setBackground(new java.awt.Color(204, 204, 204));
        start.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        getContentPane().add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 715, 47));

        last.setBackground(new java.awt.Color(204, 204, 204));
        last.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(last, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 715, 44));

        submit.setBackground(new java.awt.Color(51, 153, 255));
        submit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        submit.setText("SUBMIT");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 640, 158, 44));

        reset.setBackground(new java.awt.Color(255, 0, 51));
        reset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 640, 158, 44));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("BOOK A CAB");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 400, 52));

        BACK.setBackground(new java.awt.Color(0, 51, 204));
        BACK.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BACK.setForeground(new java.awt.Color(255, 255, 255));
        BACK.setText("BACK");
        BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKActionPerformed(evt);
            }
        });
        getContentPane().add(BACK, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 120, 40));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Type");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 136, 44));

        comboBox.setBackground(new java.awt.Color(204, 204, 204));
        comboBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hatchback", "Sedans", "Suvs" }));
        getContentPane().add(comboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 710, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WhatsApp Image 2024-11-11 at 19.23.48_5a4d16c9.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 720));

        pack();
    }// </editor-fold>                        

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void startActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        name.setText("");
        phoneno.setText("");
        ppl.setText("");
        start.setText("");
        last.setText("");
    }                                     

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
       String checkQuery = "SELECT COUNT(*) FROM Cab_booking WHERE Name = ?";
       String insertQuery = "INSERT INTO Cab_booking (Name, phone_no, No_of_people, Type, Start, Final) VALUES (?, ?, ?, ?, ?, ?)";
try {
    // Validate that none of the required fields are empty
    if (name.getText().isEmpty() || phoneno.getText().isEmpty() || ppl.getText().isEmpty() ||
        comboBox.getSelectedItem() == null|| start.getText().isEmpty() || last.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(null, "All fields are required. Please fill in all information.");
        return; // Exit if any required field is empty
    }
    // Check if the name already exists
    ps = con.prepareStatement(checkQuery);
    ps.setString(1, name.getText()); // Set the Name value from user input
    ResultSet rs = ps.executeQuery();
    rs.next(); // Move to the first row

    if (rs.getInt(1) > 0) {
        // If a record with the same name exists, show an error message
        JOptionPane.showMessageDialog(null, "Name already exists. Please enter a unique name.");
    } else {
        // Proceed with the insert if the name is unique and fields are not null
        ps = con.prepareStatement(insertQuery);
        ps.setString(1, name.getText());
        ps.setString(2, phoneno.getText());
        ps.setString(3, ppl.getText());
        ps.setString(4, comboBox.getSelectedItem().toString());
        ps.setString(5, start.getText());
        ps.setString(6, last.getText());

        int rowsInserted = ps.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null, "Record Inserted Successfully");
            dispose();
            new Userinterface().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Insert Operation Failed");
        }
    }
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

    }                                      

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
                dispose();
         new Userinterface().setVisible(true);
    }                                    

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BACK;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField last;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phoneno;
    private javax.swing.JTextField ppl;
    private javax.swing.JButton reset;
    private javax.swing.JTextField start;
    private javax.swing.JButton submit;
    // End of variables declaration                   
}
