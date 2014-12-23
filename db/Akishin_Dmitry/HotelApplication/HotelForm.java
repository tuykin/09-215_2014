/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapplication;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DEAkishin
 */
public class HotelForm extends javax.swing.JFrame {

    public static Statement stmt = null;

    /**
     * Creates new form HotelForm
     */
    public HotelForm() {
        initComponents();
        createConnection();
        setLocation(100,100);
        setVisible(true);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new RoomsPanel(), BorderLayout.CENTER);
        mainPanel.revalidate();
    }

    private final String dbURL = "jdbc:mysql://localhost:3306/db_hotel?user=root";
    // jdbc Connection
    private Connection conn = null;

    private void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
            System.out.println("Connection established");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConsolePrint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void shutdown() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
            System.out.print("фомифдломи");
        } catch (SQLException sqlExcept) {
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

        signInButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Гостиница");

        signInButton.setText("Вход в систему");
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 391, Short.MAX_VALUE)
                .addComponent(signInButton))
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(signInButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //зашел ли кто-нибудь в систему
    private boolean signedIn = false;

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        if (signedIn) {
            mainPanel.removeAll();
            mainPanel.add(new RoomsPanel(), BorderLayout.CENTER);
            mainPanel.revalidate();
            signInButton.setText("Войти в систему");
            signedIn = false;
        } else {
            SignInDialog signInDialog = new SignInDialog(HotelForm.this, true);
            if (signInDialog.isSigningSuccessfull()) {
                mainPanel.removeAll();
                if (signInDialog.isSignerAdmin()) {
                    mainPanel.add(new EmployeePanel(signInDialog.getSignerId()),
                            BorderLayout.CENTER);
                } else {
                    mainPanel.add(new GuestPanel(signInDialog.getSignerId()),
                            BorderLayout.CENTER);
                }
                mainPanel.revalidate();
                signInButton.setText("Выйти из системы");
                signedIn = true;
            }
        }
    }//GEN-LAST:event_signInButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton signInButton;
    // End of variables declaration//GEN-END:variables
}