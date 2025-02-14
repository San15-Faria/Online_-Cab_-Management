package cab_booking;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Admin extends javax.swing.JFrame {
Connection con = Connect.connectdb();
PreparedStatement ps=null;
ResultSet rs=null;

    public Admin() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        delete = new javax.swing.JButton();
        view = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        AdminLogin = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        Userlogins = new javax.swing.JButton();
        Request = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(240, 40, 140));
        setBounds(new java.awt.Rectangle(50, 50, 50, 50));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        delete.setBackground(new java.awt.Color(255, 255, 51));
        delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        delete.setText("Cancel Booking");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 260, 53));

        view.setBackground(new java.awt.Color(255, 255, 51));
        view.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        view.setText("View Bookings");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        getContentPane().add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 260, 50));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 80)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("OPERATIONS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 540, 60));

        AdminLogin.setBackground(new java.awt.Color(255, 255, 51));
        AdminLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AdminLogin.setText("View AdminLogins");
        AdminLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminLoginActionPerformed(evt);
            }
        });
        getContentPane().add(AdminLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 260, 50));

        Back.setBackground(new java.awt.Color(51, 51, 255));
        Back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 645, 120, 40));

        Userlogins.setBackground(new java.awt.Color(255, 255, 0));
        Userlogins.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Userlogins.setText("View Userlogins");
        Userlogins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserloginsActionPerformed(evt);
            }
        });
        getContentPane().add(Userlogins, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 570, 260, 50));

        Request.setBackground(new java.awt.Color(255, 255, 51));
        Request.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Request.setText("View Requests");
        Request.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestActionPerformed(evt);
            }
        });
        getContentPane().add(Request, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 260, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WhatsApp Image 2024-11-11 at 19.23.46_595adb07.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, 0, 1130, 700));

        pack();
    }// </editor-fold>                        

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        dispose();
                new DeleteBooking().setVisible(true);
                
    }                                      

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
           setLocationRelativeTo(null);
          String fetchQuery = "SELECT Name, phone_no, No_of_people, Type, Start, Final FROM Cab_booking";

        try {
            // Prepare the SQL statement
            ps = con.prepareStatement(fetchQuery);
            rs = ps.executeQuery();
            // Create table model and column names
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Name");
            tableModel.addColumn("Phone Number");
            tableModel.addColumn("No. of People");
            tableModel.addColumn("Type");
            tableModel.addColumn("Start");
            tableModel.addColumn("Final");
            // Fill table model with data from the result set
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getString("Name"),
                    rs.getString("phone_no"),
                    rs.getString("No_of_people"),
                    rs.getString("Type"),
                    rs.getString("Start"),
                    rs.getString("Final")
                });
            }
            // Create the JTable with the table model
            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            // Create a JFrame to display the table
            JFrame frame = new JFrame("Cab Booking Records");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(scrollPane);
            frame.setSize(800, 400);
            frame.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fetching data: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + ex.getMessage());
            }
        }
    }                                    

    private void AdminLoginActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
           setLocationRelativeTo(null);
         String fetchQuery = "SELECT Name,Password FROM LOGIN";

        try {
            // Prepare the SQL statement
            ps = con.prepareStatement(fetchQuery);
            rs = ps.executeQuery();

            // Create table model and column names
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Name");
            tableModel.addColumn("Password");

            // Fill table model with data from the result set
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getString("Name"),
                    rs.getString("Password")
                });
            }

            // Create the JTable with the table model
            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);

            // Create a JFrame to display the table
            JFrame frame = new JFrame("Cab Login Records");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(scrollPane);
            frame.setSize(800, 400);
            frame.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fetching data: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + ex.getMessage());
            }
        }
    }                                          

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
         dispose();
       new Start().setVisible(true);
               
        
    }                                    

    private void UserloginsActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        setLocationRelativeTo(null);
         String fetchQuery = "SELECT Name,Password FROM UserLOGIN";

        try {
            // Prepare the SQL statement
            ps = con.prepareStatement(fetchQuery);
            rs = ps.executeQuery();

            // Create table model and column names
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Name");
            tableModel.addColumn("Password");

            // Fill table model with data from the result set
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getString("Name"),
                    rs.getString("Password")
                });
            }

            // Create the JTable with the table model
            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);

            // Create a JFrame to display the table
            JFrame frame = new JFrame("User Login Records");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(scrollPane);
            frame.setSize(800, 400);
            frame.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fetching data: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + ex.getMessage());
            }
        }
        
    }                                          

    private void RequestActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
         setLocationRelativeTo(null);
         String fetchQuery = "SELECT Name,Request FROM Request";

        try {
            // Prepare the SQL statement
            ps = con.prepareStatement(fetchQuery);
            rs = ps.executeQuery();

            // Create table model and column names
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Name");
            tableModel.addColumn("Request");

            // Fill table model with data from the result set
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getString("Name"),
                    rs.getString("Request")
                });
            }

            // Create the JTable with the table model
            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);

            // Create a JFrame to display the table
            JFrame frame = new JFrame("User Request Records");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(scrollPane);
            frame.setSize(800, 400);
            frame.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fetching data: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + ex.getMessage());
            }
        }
        
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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new Admin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton AdminLogin;
    private javax.swing.JButton Back;
    private javax.swing.JButton Request;
    private javax.swing.JButton Userlogins;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton view;
    // End of variables declaration                   
}
