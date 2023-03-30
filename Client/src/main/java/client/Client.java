package client;

import classes.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.Integer.max;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.swing.*;

public class Client extends javax.swing.JFrame {

    
    public Client() {
        initComponents();
    }

    Socket socket;
    User userLog;
    ArrayList<Conversation> tabConv = new ArrayList<>();
    static ArrayList<Entity> tabEntity = new ArrayList<>();
    int n = 25491937;
    DataInputStream inData;
    DataOutputStream outData;
    static SecretKey secretKeyDef;
    
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
        SideBarUser = new javax.swing.JLabel();
        SideBarTitre = new javax.swing.JLabel();
        NewConvBtn = new javax.swing.JButton();
        CenterPanel = new javax.swing.JPanel();
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

        SideBarUser.setBackground(new java.awt.Color(204, 255, 255));
        SideBarUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SideBarUser.setText("CONTACTS");
        SideBar.add(SideBarUser);

        SideBarTitre.setBackground(new java.awt.Color(204, 255, 255));
        SideBarTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SideBarTitre.setText("CONTACTS");
        SideBar.add(SideBarTitre);

        NewConvBtn.setText("Create Conv");
        NewConvBtn.setMaximumSize(new java.awt.Dimension(81, 18));
        NewConvBtn.setMinimumSize(new java.awt.Dimension(81, 18));
        NewConvBtn.setPreferredSize(new java.awt.Dimension(81, 18));
        NewConvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewConvBtnActionPerformed(evt);
            }
        });
        SideBar.add(NewConvBtn);

        CommPanel.add(SideBar, java.awt.BorderLayout.LINE_START);

        CenterPanel.setLayout(new java.awt.CardLayout());
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
            String input, send, tmp;
            String[] split;
            
            
            
            //SAISIE
            System.out.println("Saisie");
            send = LoginText.getText() + ";_;" + String.valueOf(LoginMdp.getPassword()).hashCode();
            write(send);
            
            
            //USER
            System.out.println("User");
            input = Cryptage.decrypt(inData.readUTF(), secretKeyDef);
            split = input.split(";_;");
            System.out.println(Arrays.toString(split));
            if(split[1].equals("false")){
                //traitement mauvais login
            }else{
                userLog = User.deconcat(split[1]);
                tmp = (Integer.parseInt(split[0])+1) + "";
                write(tmp);
                SideBarUser.setText(userLog.nom + " " + userLog.prenom);
                //CONV
                System.out.println("Conv");

                input = Cryptage.decrypt(inData.readUTF(), secretKeyDef);
                System.out.println(input);
                split = input.split(";_;");
                tabConv = Conversation.deconcatTab(split[1]);
                tmp = (Integer.parseInt(split[0])+1) + "";
                write(tmp);


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
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void NewConvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewConvBtnActionPerformed
        for(int i = 0; i < CenterPanel.getComponentCount(); i++){
            if(CenterPanel.getComponents()[i].getName().equals("NewConvPanel")){
                CenterPanel.getComponents()[i].setVisible(true);
            }
            else{
                CenterPanel.getComponents()[i].setVisible(false);
            }
        }
        
    }//GEN-LAST:event_NewConvBtnActionPerformed

    public void createConv(){
        
        BackGroundPanel backGround = new BackGroundPanel();
        backGround.setVisible(true);
        backGround.setName("BackGround");
        
        CenterPanel.add(backGround);
        ArrayList<ConvPanel> tabPanel = new ArrayList<>();
        
        NewConvPanel newConvPanel = new NewConvPanel();
        newConvPanel.setVisible(false);
        newConvPanel.setName("NewConvPanel");
        CenterPanel.add(newConvPanel);
        
        
        SideBar.setLayout(new GridLayout(max(tabConv.size()+2, 10), 0));
        for(Conversation conv : tabConv){
            
            ConvPanel convPanel = new ConvPanel(socket, userLog.id, conv.id);
            convPanel.ConvTitre.setText(conv.nom);
            convPanel.setVisible(false);
            convPanel.setName(conv.nom);
            CenterPanel.add(convPanel);
            tabPanel.add(convPanel);
            
            Entity ent = new Entity(convPanel, conv);
            tabEntity.add(ent);
            JButton btn = new JButton(conv.nom);
            btn.setSize(81,18);
            btn.addActionListener((ActionEvent e) -> {
                showPanel(tabPanel, conv.nom);
                backGround.setVisible(false);
                newConvPanel.setVisible(false);
            });
            SideBar.add(btn);
        }
    }
    
    public void showPanel(ArrayList<ConvPanel> tabPanel, String panelName){
        for (int i = 0; i < tabPanel.size(); i++) {
            if (tabPanel.get(i).getName().equals(panelName)) {
                tabPanel.get(i).setVisible(true);
            } else {
                tabPanel.get(i).setVisible(false);
            }
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
            //Variable
            System.out.println("Var creation");
            inData = new DataInputStream(socket.getInputStream());
            outData = new DataOutputStream(socket.getOutputStream());
            String input, send, tmp;
            String[] split;
            
            //init clé
            //recup mac + ip 
            String pass = "777005";
            SecretKey secretKeyTmp = Cryptage.generateKeyTemp(pass);
            
            System.out.println("Echange clés");
            input = inData.readUTF();
            input = Cryptage.decrypt(input, secretKeyTmp);
            split = input.split(";_;");
            tmp = (Integer.parseInt(split[0])+1) + "";
            secretKeyDef = Cryptage.generateKeyDef(split[1]);
            write(tmp);
            
            
            //Authentification
            System.out.println("Authentification");
            
            int alan = 100;
            long r = (long) (Math.random()*(n-2)+1);
            long x = (r * r) % n;
            send = x + "";
            long[] tabV = new long[alan];
            long[] tabV2 = new long[alan];
            long[] tabZ = new long[alan];
            
            for(int i = 0; i<alan; i++){
                tabV[i] = (int) (Math.random()*(n-2)+1);
                tabV2[i] = (tabV[i] * tabV[i]) % n;
                send = send + ";" + tabV2[i];
            }
            
            write(send);
            
            input = Cryptage.decrypt(inData.readUTF(), secretKeyDef);   
            split = input.split(";");
            
            for(int i = 0; i<alan; i++){
                if("0".equals(split[i])){
                    tabZ[i] = tabV[i];
                }
                if("1".equals(split[i])){
                    tabZ[i] = (r * tabV[i]) % n;
                }
            }
            
            send = tabZ[0] + "";
            for(int i = 1; i<alan; i++){
                send += ";" + tabZ[i];
            }
            
            write(send);
            
            
            input = Cryptage.decrypt(inData.readUTF(), secretKeyDef);
            if(input.equals("true")){
                ArpPanel.setVisible(false);
                LoginPanel.setVisible(true);
                
            }else{
                JOptionPane.showMessageDialog(ArpPanel, "Authentication failed.");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private void write(String send){
        send = Cryptage.encrypt(send, secretKeyDef);
        try{
            outData.writeUTF(send);
            outData.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    public static SecretKey getKeyDef(){
        return secretKeyDef;
    }
        
    public static Integer tryParse(String text) {
        try {
            return Integer.valueOf(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public static ArrayList<Entity> getTabEntity(){
        return tabEntity;
    }
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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

        java.awt.EventQueue.invokeLater(() -> {
            new Client().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ArpButton;
    private javax.swing.JLabel ArpIpLabel;
    private javax.swing.JTextField ArpIpText;
    private javax.swing.JPanel ArpPanel;
    private javax.swing.JLabel ArpPortLabel;
    private javax.swing.JTextField ArpPortText;
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
    private javax.swing.JLabel SideBarUser;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
