package client;

import classes.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.Integer.max;
import java.net.Socket;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Client extends javax.swing.JFrame {

    
    public Client() {
        initComponents();
    }

    Socket socket;
    User userLog;
    ArrayList<Conversation> tabConv = new ArrayList<Conversation>();
    ArrayList<Entity> tabEntity = new ArrayList<Entity>();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ArpPanel = new javax.swing.JPanel();
        ArpIpLabel = new javax.swing.JLabel();
        ArpIpText = new javax.swing.JTextField();
        ArpPortLabel = new javax.swing.JLabel();
        ArpPortText = new javax.swing.JTextField();
        ArpButton = new javax.swing.JButton();
        CommPanel = new javax.swing.JPanel();
        SideBar = new javax.swing.JPanel();
        SideBarTitre = new javax.swing.JLabel();
        NewConvBtn = new javax.swing.JButton();
        CenterPanel = new javax.swing.JPanel();
        BackGround = new javax.swing.JPanel();
        LoginPanel = new javax.swing.JPanel();
        LoginTitre = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        LoginText = new javax.swing.JTextField();
        LoginMdp = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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
                        .addComponent(ArpIpText, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
                .addContainerGap(231, Short.MAX_VALUE))
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
                .addContainerGap(270, Short.MAX_VALUE))
        );

        getContentPane().add(ArpPanel, "card2");

        CommPanel.setLayout(new java.awt.BorderLayout());

        SideBar.setBackground(new java.awt.Color(204, 204, 204));
        SideBar.setPreferredSize(new java.awt.Dimension(150, 536));
        SideBar.setLayout(new java.awt.GridLayout(10, 0));

        SideBarTitre.setBackground(new java.awt.Color(204, 255, 255));
        SideBarTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SideBarTitre.setText("CONTACTS");
        SideBar.add(SideBarTitre);

        NewConvBtn.setText("Create Conv");
        NewConvBtn.setMaximumSize(new java.awt.Dimension(81, 18));
        NewConvBtn.setMinimumSize(new java.awt.Dimension(81, 18));
        NewConvBtn.setPreferredSize(new java.awt.Dimension(81, 18));
        SideBar.add(NewConvBtn);

        CommPanel.add(SideBar, java.awt.BorderLayout.LINE_START);

        CenterPanel.setLayout(new java.awt.CardLayout());

        BackGround.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        CenterPanel.add(BackGround, "card2");

        CommPanel.add(CenterPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(CommPanel, "card3");

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
                .addContainerGap(383, Short.MAX_VALUE))
            .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LoginPanelLayout.createSequentialGroup()
                    .addGap(252, 252, 252)
                    .addComponent(LoginText, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(397, Short.MAX_VALUE)))
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
                .addContainerGap(284, Short.MAX_VALUE))
            .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LoginPanelLayout.createSequentialGroup()
                    .addGap(155, 155, 155)
                    .addComponent(LoginText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(431, Short.MAX_VALUE)))
        );

        getContentPane().add(LoginPanel, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ArpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArpButtonActionPerformed
        String ip = ArpIpText.getText();
        String port = ArpPortText.getText();
        connectToServer(ip, port);
    }//GEN-LAST:event_ArpButtonActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        
        try {
            //Variable
            System.out.println("Var creation");
            DataInputStream inData = new DataInputStream(socket.getInputStream());
            DataOutputStream outData = new DataOutputStream(socket.getOutputStream());
            
            String input = "", send = "", tmp = "";
            String[] split;
            
            //Echange Clé
            System.out.println("Echange clés");
            
            
            //Authentification
            System.out.println("Authentification");
            
            
            //SAISIE
            System.out.println("Saisie");
            send = LoginText.getText() + ";_;" + String.valueOf(LoginMdp.getPassword()).hashCode();
            //cryptage send
            outData.writeUTF(send);
            outData.flush();
            
            
            //USER
            System.out.println("User");
            input = inData.readUTF();
            //decryptage input
            split = input.split(";_;");
            userLog = User.deconcat(split[1]);
            tmp = (Integer.parseInt(split[0])+1) + "";
            //cryptage tmp
            outData.writeUTF(tmp);
            outData.flush();
            
            
            //CONV
            System.out.println("Conv");
            
            input = inData.readUTF();
            //decryptage input
            System.out.println(input);
            split = input.split(";_;");
            tabConv = Conversation.deconcatTab(split[1]);
            //cryptage send
            tmp = (Integer.parseInt(split[0])+1) + "";
            //cryptage tmp
            outData.writeUTF(tmp);
            outData.flush();
            
            
            //TABUSERS
            System.out.println("Tab");
            
            
            //MESSAGE
            System.out.println("Msg");
            
            
            //Final Treatment
            System.out.println("Final Treatment");
            
            
            
            ThreadListening listening = new ThreadListening(socket);
            listening.start();
            
            createConv();
            
            LoginPanel.setVisible(false);
            CommPanel.setVisible(true); 
            
            
            
        } catch (IOException ex) {
            System.out.println("Cannot create threadlistening");
        }
    }//GEN-LAST:event_LoginBtnActionPerformed

    public void createConv(){
        
        
        SideBar.setLayout(new GridLayout(max(tabConv.size()+2, 10), 0));
        for(Conversation conv : tabConv){
            
            ConvPanel convPanel = new ConvPanel(socket, userLog.id, conv.id);
            convPanel.ConvTitre.setText(conv.nom);
            convPanel.setVisible(false);
            CenterPanel.add(convPanel);
            
            Entity ent = new Entity(convPanel, conv);
            tabEntity.add(ent);
            JButton btn = new JButton(conv.nom);
            btn.setSize(81,18);
            btn.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed( ActionEvent e ) {
                    showPanel(conv.id);
                }
            });
            SideBar.add(btn);
            
            
        }
        CommPanel.updateUI();
        
    }
    
    
    public void showPanel(int convId){
        for(Entity ent : tabEntity){
            if(ent.conv.id == convId){
                ent.convPanel.setVisible(true);
            }else{
                ent.convPanel.setVisible(true);
            }
            CenterPanel.updateUI();
        }
        
    }
    
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
    private javax.swing.JPanel BackGround;
    private javax.swing.JPanel CenterPanel;
    private javax.swing.JPanel CommPanel;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPasswordField LoginMdp;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JTextField LoginText;
    private javax.swing.JLabel LoginTitre;
    private javax.swing.JButton NewConvBtn;
    private javax.swing.JPanel SideBar;
    private javax.swing.JLabel SideBarTitre;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
