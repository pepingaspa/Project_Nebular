package pfe.nebular.client;

import classes.*;
import classes.Conversation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Client extends javax.swing.JFrame {

    DataOutputStream out;
    public Client() {
        initComponents();
    }

    Socket socket;
    int idExp, idConv = 1;
    static ArrayList<Entity> tabEnt;
    User loggedUser;
    

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
        LoginPanel = new javax.swing.JPanel();
        LoginTitre = new javax.swing.JLabel();
        LoginPseudo = new javax.swing.JTextField();
        LoginMdp = new javax.swing.JTextField();
        LoginBtn = new javax.swing.JButton();
        CommPanel = new javax.swing.JPanel();
        SidePanel = new javax.swing.JPanel();
        CenterPanel = new javax.swing.JPanel();

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
        setPreferredSize(new java.awt.Dimension(600, 600));
        setSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(new java.awt.CardLayout());

        ArpIpLabel.setText("Enter Server Ip :");

        ArpPortLabel.setText("Enter Server Port");

        ArpPortText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArpPortTextActionPerformed(evt);
            }
        });

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

        LoginTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginTitre.setText("Expéditeur");

        LoginPseudo.setToolTipText("Username - Pseudo - Mail");

        LoginMdp.setToolTipText("Password");
        LoginMdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginMdpActionPerformed(evt);
            }
        });

        LoginBtn.setText("LOG IN");
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
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(LoginPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(LoginPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LoginPanelLayout.createSequentialGroup()
                            .addGap(233, 233, 233)
                            .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LoginMdp, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LoginTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LoginTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(LoginPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
                .addComponent(LoginMdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(LoginBtn)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        getContentPane().add(LoginPanel, "card4");

        CommPanel.setLayout(new java.awt.BorderLayout());

        SidePanel.setBackground(new java.awt.Color(204, 204, 204));
        SidePanel.setMinimumSize(new java.awt.Dimension(150, 450));
        SidePanel.setPreferredSize(new java.awt.Dimension(150, 450));
        SidePanel.setLayout(new java.awt.GridLayout(10, 0));
        CommPanel.add(SidePanel, java.awt.BorderLayout.LINE_START);

        CenterPanel.setLayout(new java.awt.CardLayout());
        CommPanel.add(CenterPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(CommPanel, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ArpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArpButtonActionPerformed
        String ip = ArpIpText.getText();
        String port = ArpPortText.getText();
        connectToServer(ip, port);
    }//GEN-LAST:event_ArpButtonActionPerformed

    
    private void LoginMdpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginMdpActionPerformed
        login();        
    }//GEN-LAST:event_LoginMdpActionPerformed

    private void login(){
        
        String saisie = LoginPseudo.getText()+";;;"+LoginMdp.getText().hashCode();
        
        boolean verif = false;
        List<Conversation> list;
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(saisie);
            out.flush();
            
            
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Object tmp = in.readUTF();
            int idExp = tryParse((String) tmp);
            if(idExp > 0){
                verif = true;
            }
            
            ObjectInputStream inObj = new ObjectInputStream(socket.getInputStream());
            list = (List<Conversation>) inObj.readObject();
            createButton(list);
            
        } catch (IOException ex) {
            System.out.println("Write failed");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(verif){
            
            
            LoginPanel.setVisible(false);
            CommPanel.setVisible(true);
                        
            ThreadListening listening;
            try {
                listening = new ThreadListening(socket);
                listening.start();
            } catch (IOException ex) {
                System.out.println("Failed lunch thread");
            }
        }
    }
    
    private void ArpPortTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArpPortTextActionPerformed
        String ip = ArpIpText.getText();
        String port = ArpPortText.getText();
        connectToServer(ip, port);
    }//GEN-LAST:event_ArpPortTextActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        login();
    }//GEN-LAST:event_LoginBtnActionPerformed

    public void createButton(List<Conversation> list){
        tabEnt = new ArrayList<Entity>();
        
        for(Conversation conv : list){
            
            JButton btn = new JButton(conv.nom);
            btn.setName("Btn"+conv.idConv);
            btn.setSize(50,50);
            btn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    idConv = conv.idConv;
                    hidePanel(""+idConv);
                    CommPanel.updateUI();
                }
                
            });
            SidePanel.add(btn).setVisible(true);
            CommPanel.updateUI();
            
            ConvPanel convPanel = new ConvPanel(socket, idExp, conv.idConv);
            convPanel.setName(""+conv.idConv);
            convPanel.ConvTitre.setText(conv.nom);
            CenterPanel.add(convPanel).setVisible(false);
            CommPanel.updateUI();
            Entity ent = new Entity(convPanel, conv);
            tabEnt.add(ent);
        }

    }

    private void hidePanel(String nom){
        for(Entity ent : tabEnt){
            if(ent.convPanel.getName().equals(nom)){
                ent.convPanel.setVisible(true);
            }else{
                ent.convPanel.setVisible(false);
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
            ArpPanel.setVisible(false);
            LoginPanel.setVisible(true);
            out = new DataOutputStream(socket.getOutputStream());
            
        } catch (IOException ex) {
            System.out.println("Can not connet to the server !");
        }
        
    }
    
    
    public static JTextArea getArea(int tmpId){
        for(Entity  ent : tabEnt){
            if(ent.conv.idConv == tmpId){
                return ent.convPanel.ConvArea;
            }
        }
        return null;
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
    private javax.swing.JPanel CenterPanel;
    private javax.swing.JPanel CommPanel;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JTextField LoginMdp;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JTextField LoginPseudo;
    private javax.swing.JLabel LoginTitre;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
