package client;

import classes.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class Client extends javax.swing.JFrame {

    
    public Client() {
        initComponents();
    }

    Socket socket;
    int idExp;
    DataInputStream inData;
    DataOutputStream outData;
    User logUser;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArpPanel = new javax.swing.JPanel();
        ArpIpLabel = new javax.swing.JLabel();
        ArpIpText = new javax.swing.JTextField();
        ArpPortLabel = new javax.swing.JLabel();
        ArpPortText = new javax.swing.JTextField();
        ArpButton = new javax.swing.JButton();
        MsgPanel = new javax.swing.JPanel();
        MsgLabel = new javax.swing.JLabel();
        MsgText = new javax.swing.JTextField();
        LoginPanel = new javax.swing.JPanel();
        LoginTitre = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        LoginText = new javax.swing.JTextField();
        LoginMdp = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(new java.awt.CardLayout());

        ArpIpLabel.setText("Enter Server Ip :");

        ArpPortLabel.setText("Enter Server Port");

        ArpButton.setText("Reach");
        ArpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ArpPanelLayout = new javax.swing.GroupLayout(ArpPanel);
        ArpPanel.setLayout(ArpPanelLayout);
        ArpPanelLayout.setHorizontalGroup(
            ArpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArpPanelLayout.createSequentialGroup()
                .addGroup(ArpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ArpPanelLayout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(ArpIpLabel))
                    .addGroup(ArpPanelLayout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addGroup(ArpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ArpPortLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ArpPortText)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArpPanelLayout.createSequentialGroup()
                                .addComponent(ArpButton)
                                .addGap(17, 17, 17))))
                    .addGroup(ArpPanelLayout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(ArpIpText, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        ArpPanelLayout.setVerticalGroup(
            ArpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArpPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(ArpIpLabel)
                .addGap(36, 36, 36)
                .addComponent(ArpIpText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(ArpPortLabel)
                .addGap(65, 65, 65)
                .addComponent(ArpPortText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ArpButton)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        getContentPane().add(ArpPanel, "card2");

        MsgText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MsgTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MsgPanelLayout = new javax.swing.GroupLayout(MsgPanel);
        MsgPanel.setLayout(MsgPanelLayout);
        MsgPanelLayout.setHorizontalGroup(
            MsgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MsgPanelLayout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addGroup(MsgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MsgPanelLayout.createSequentialGroup()
                        .addComponent(MsgText, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MsgPanelLayout.createSequentialGroup()
                        .addComponent(MsgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188))))
        );
        MsgPanelLayout.setVerticalGroup(
            MsgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MsgPanelLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(MsgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(MsgText, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );

        getContentPane().add(MsgPanel, "card3");

        LoginTitre.setText("Expéditeur");

        LoginBtn.setText("Log In");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(LoginTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(LoginBtn))
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(LoginMdp, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(257, Short.MAX_VALUE))
            .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LoginPanelLayout.createSequentialGroup()
                    .addGap(252, 252, 252)
                    .addComponent(LoginText, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(271, Short.MAX_VALUE)))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(LoginTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(LoginMdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(LoginBtn)
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LoginPanelLayout.createSequentialGroup()
                    .addGap(155, 155, 155)
                    .addComponent(LoginText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(356, Short.MAX_VALUE)))
        );

        getContentPane().add(LoginPanel, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ArpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArpButtonActionPerformed
        String ip = ArpIpText.getText();
        String port = ArpPortText.getText();
        connectToServer(ip, port);
    }//GEN-LAST:event_ArpButtonActionPerformed

    private void MsgTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MsgTextActionPerformed
        try {
            Message msg = new Message(MsgText.getText(), idExp);
            outData.writeUTF(msg.Concat());
            outData.flush();
        } catch (IOException ex) {
            System.out.println("writing failed");
        }
        
    }//GEN-LAST:event_MsgTextActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        
        try {
            //Variable
            System.out.println("Var creation");
            inData = new DataInputStream(socket.getInputStream());
            outData = new DataOutputStream(socket.getOutputStream());
            
            //Echange Clé
            System.out.println("Echange clés");
            
            
            //Authentification
            System.out.println("Authentification");
            
            
            //Envoie saisie
            System.out.println("Saisie");
            String saisie = LoginText.getText() + ";_;" + Arrays.hashCode(LoginMdp.getPassword());
            outData.writeUTF(saisie);
            
            //Reception user
            System.out.println("User reception");
            
            
            //Reception Conv
            System.out.println("Conv reception");
            
            
            //Reception tabUsers
            System.out.println("Tab reception");
            
            
            //Reception Message
            System.out.println("Msg reception");
            
            
            //Final Treatment
            System.out.println("Final Treatment");
            
            idExp = Integer.parseInt(LoginText.getText());
            
            ThreadListening listening = new ThreadListening(socket, MsgText, MsgLabel);
            listening.start();
            LoginPanel.setVisible(false);
            MsgPanel.setVisible(true);
        } catch (IOException ex) {
            System.out.println("Cannot create threadlistening");
        }
        
        
    }//GEN-LAST:event_LoginBtnActionPerformed

    
    
    public void connectToServer(String tmpIp, String tmpPort){
        
        int port;
        if(!tmpPort.isEmpty()){
            port = tryParse(tmpPort);
        }else{
            port = 5000;
        }
        
        try {
            socket = new Socket(tmpIp, port);
            System.out.println("Connextion achieve");
            ArpPanel.setVisible(false);
            LoginPanel.setVisible(true);
            
            
        } catch (IOException ex) {
            System.out.println("Can not connet to the server !");
        }
        
    }
    
    
    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ArpButton;
    private javax.swing.JLabel ArpIpLabel;
    private javax.swing.JTextField ArpIpText;
    private javax.swing.JPanel ArpPanel;
    private javax.swing.JLabel ArpPortLabel;
    private javax.swing.JTextField ArpPortText;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPasswordField LoginMdp;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JTextField LoginText;
    private javax.swing.JLabel LoginTitre;
    private javax.swing.JLabel MsgLabel;
    private javax.swing.JPanel MsgPanel;
    private javax.swing.JTextField MsgText;
    // End of variables declaration//GEN-END:variables
}