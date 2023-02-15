package server;

import classes.*;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Server extends javax.swing.JFrame {

    private static Server server = null;
    private ThreadServer ThreadServer;
    private JPanel[] tabPanel;
    

    private Server() {
        initComponents();
        this.tabPanel = new JPanel[]{
            AdminPanel, ServerPanel, CommPanel, DataPanel, MonitPanel
        };        
    }

    public static Server getServer() {
        return server;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AdminPanel = new javax.swing.JPanel();
        AdminLabel = new javax.swing.JLabel();
        AdminButton = new javax.swing.JButton();
        AdminText = new javax.swing.JPasswordField();
        ServerPanel = new javax.swing.JPanel();
        ServerPort = new javax.swing.JTextField();
        ServerStart = new javax.swing.JButton();
        ServerStop = new javax.swing.JButton();
        ServerDefault = new javax.swing.JLabel();
        ServerTitre = new javax.swing.JLabel();
        ToolBar = new javax.swing.JPanel();
        TBServer = new javax.swing.JButton();
        TBMonit = new javax.swing.JButton();
        TBComm = new javax.swing.JButton();
        TBData = new javax.swing.JButton();
        CommPanel = new javax.swing.JPanel();
        SidePanel = new javax.swing.JPanel();
        ToolBar1 = new javax.swing.JPanel();
        TBServer1 = new javax.swing.JButton();
        TBMonit1 = new javax.swing.JButton();
        TBComm1 = new javax.swing.JButton();
        TBData1 = new javax.swing.JButton();
        CenterPanel = new javax.swing.JPanel();
        DataPanel = new javax.swing.JPanel();
        DataTitre = new javax.swing.JLabel();
        ToolBar2 = new javax.swing.JPanel();
        TBServer2 = new javax.swing.JButton();
        TBMonit2 = new javax.swing.JButton();
        TBComm2 = new javax.swing.JButton();
        TBData2 = new javax.swing.JButton();
        MonitPanel = new javax.swing.JPanel();
        MonitTitre = new javax.swing.JLabel();
        ToolBar3 = new javax.swing.JPanel();
        TBServer3 = new javax.swing.JButton();
        TBMonit3 = new javax.swing.JButton();
        TBComm3 = new javax.swing.JButton();
        TBData3 = new javax.swing.JButton();
        MonitTotClient = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 700));
        getContentPane().setLayout(new java.awt.CardLayout());

        AdminPanel.setName("AdminPanel"); // NOI18N

        AdminLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AdminLabel.setText("Admin Password");

        AdminButton.setText("Login");
        AdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminButtonActionPerformed(evt);
            }
        });

        AdminText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdminPanelLayout = new javax.swing.GroupLayout(AdminPanel);
        AdminPanel.setLayout(AdminPanelLayout);
        AdminPanelLayout.setHorizontalGroup(
            AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AdminLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(AdminPanelLayout.createSequentialGroup()
                .addGroup(AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminPanelLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(AdminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AdminPanelLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(AdminText, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 279, Short.MAX_VALUE))
        );
        AdminPanelLayout.setVerticalGroup(
            AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminPanelLayout.createSequentialGroup()
                .addComponent(AdminLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(AdminText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addComponent(AdminButton)
                .addGap(98, 98, 98))
        );

        getContentPane().add(AdminPanel, "card2");
        AdminPanel.getAccessibleContext().setAccessibleName("");

        ServerPanel.setName("ServerPanel"); // NOI18N

        ServerPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerPortActionPerformed(evt);
            }
        });

        ServerStart.setText("Start");
        ServerStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerStartActionPerformed(evt);
            }
        });

        ServerStop.setText("Stop");
        ServerStop.setEnabled(false);
        ServerStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerStopActionPerformed(evt);
            }
        });

        ServerDefault.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ServerDefault.setText("Default port : 5000");

        ServerTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ServerTitre.setText("Enter a port to start the server :");

        TBServer.setText("Server");
        TBServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBServerActionPerformed(evt);
            }
        });

        TBMonit.setText("Monitoring");
        TBMonit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBMonitActionPerformed(evt);
            }
        });

        TBComm.setText("Communication");
        TBComm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBCommActionPerformed(evt);
            }
        });

        TBData.setText("DataBase");
        TBData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ToolBarLayout = new javax.swing.GroupLayout(ToolBar);
        ToolBar.setLayout(ToolBarLayout);
        ToolBarLayout.setHorizontalGroup(
            ToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ToolBarLayout.createSequentialGroup()
                .addComponent(TBServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBMonit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBComm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBData)
                .addGap(0, 266, Short.MAX_VALUE))
        );
        ToolBarLayout.setVerticalGroup(
            ToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ToolBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(ToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TBServer)
                    .addComponent(TBMonit)
                    .addComponent(TBComm)
                    .addComponent(TBData)))
        );

        javax.swing.GroupLayout ServerPanelLayout = new javax.swing.GroupLayout(ServerPanel);
        ServerPanel.setLayout(ServerPanelLayout);
        ServerPanelLayout.setHorizontalGroup(
            ServerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServerPanelLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(ServerStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ServerStop)
                .addGap(64, 64, 64))
            .addComponent(ServerTitre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ServerPanelLayout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(ServerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ServerPort, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(ServerDefault, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(ToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ServerPanelLayout.setVerticalGroup(
            ServerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServerPanelLayout.createSequentialGroup()
                .addComponent(ToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(ServerTitre)
                .addGap(18, 18, 18)
                .addComponent(ServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ServerDefault)
                .addGap(46, 46, 46)
                .addGroup(ServerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ServerStart)
                    .addComponent(ServerStop))
                .addContainerGap(207, Short.MAX_VALUE))
        );

        getContentPane().add(ServerPanel, "card3");
        ServerPanel.getAccessibleContext().setAccessibleName("");

        CommPanel.setName("CommPanel"); // NOI18N
        CommPanel.setLayout(new java.awt.BorderLayout());

        SidePanel.setBackground(new java.awt.Color(153, 153, 153));
        SidePanel.setPreferredSize(new java.awt.Dimension(150, 500));
        SidePanel.setLayout(new java.awt.GridLayout(10, 1));
        CommPanel.add(SidePanel, java.awt.BorderLayout.LINE_START);

        ToolBar1.setBackground(new java.awt.Color(255, 255, 255));

        TBServer1.setText("Server");
        TBServer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBServer1ActionPerformed(evt);
            }
        });

        TBMonit1.setText("Monitoring");
        TBMonit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBMonit1ActionPerformed(evt);
            }
        });

        TBComm1.setText("Communication");
        TBComm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBComm1ActionPerformed(evt);
            }
        });

        TBData1.setText("DataBase");
        TBData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBData1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ToolBar1Layout = new javax.swing.GroupLayout(ToolBar1);
        ToolBar1.setLayout(ToolBar1Layout);
        ToolBar1Layout.setHorizontalGroup(
            ToolBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ToolBar1Layout.createSequentialGroup()
                .addComponent(TBServer1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBMonit1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBComm1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBData1)
                .addGap(0, 266, Short.MAX_VALUE))
        );
        ToolBar1Layout.setVerticalGroup(
            ToolBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ToolBar1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(ToolBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TBServer1)
                    .addComponent(TBMonit1)
                    .addComponent(TBComm1)
                    .addComponent(TBData1)))
        );

        CommPanel.add(ToolBar1, java.awt.BorderLayout.PAGE_START);

        CenterPanel.setBackground(new java.awt.Color(255, 255, 255));
        CenterPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        CenterPanel.setLayout(new java.awt.CardLayout());
        CommPanel.add(CenterPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(CommPanel, "card4");
        CommPanel.getAccessibleContext().setAccessibleName("");

        DataPanel.setName("DataPanel"); // NOI18N

        DataTitre.setText("DataBase Panel");

        TBServer2.setText("Server");
        TBServer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBServer2ActionPerformed(evt);
            }
        });

        TBMonit2.setText("Monitoring");
        TBMonit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBMonit2ActionPerformed(evt);
            }
        });

        TBComm2.setText("Communication");
        TBComm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBComm2ActionPerformed(evt);
            }
        });

        TBData2.setText("DataBase");
        TBData2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBData2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ToolBar2Layout = new javax.swing.GroupLayout(ToolBar2);
        ToolBar2.setLayout(ToolBar2Layout);
        ToolBar2Layout.setHorizontalGroup(
            ToolBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ToolBar2Layout.createSequentialGroup()
                .addComponent(TBServer2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBMonit2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBComm2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBData2)
                .addGap(0, 266, Short.MAX_VALUE))
        );
        ToolBar2Layout.setVerticalGroup(
            ToolBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ToolBar2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(ToolBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TBServer2)
                    .addComponent(TBMonit2)
                    .addComponent(TBComm2)
                    .addComponent(TBData2)))
        );

        javax.swing.GroupLayout DataPanelLayout = new javax.swing.GroupLayout(DataPanel);
        DataPanel.setLayout(DataPanelLayout);
        DataPanelLayout.setHorizontalGroup(
            DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(DataTitre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(ToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DataPanelLayout.setVerticalGroup(
            DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addComponent(ToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(DataTitre)
                .addContainerGap(394, Short.MAX_VALUE))
        );

        getContentPane().add(DataPanel, "card5");

        MonitPanel.setName("MonitPanel"); // NOI18N

        MonitTitre.setText("Monitoring");

        TBServer3.setText("Server");
        TBServer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBServer3ActionPerformed(evt);
            }
        });

        TBMonit3.setText("Monitoring");
        TBMonit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBMonit3ActionPerformed(evt);
            }
        });

        TBComm3.setText("Communication");
        TBComm3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBComm3ActionPerformed(evt);
            }
        });

        TBData3.setText("DataBase");
        TBData3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBData3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ToolBar3Layout = new javax.swing.GroupLayout(ToolBar3);
        ToolBar3.setLayout(ToolBar3Layout);
        ToolBar3Layout.setHorizontalGroup(
            ToolBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ToolBar3Layout.createSequentialGroup()
                .addComponent(TBServer3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBMonit3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBComm3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBData3)
                .addGap(0, 266, Short.MAX_VALUE))
        );
        ToolBar3Layout.setVerticalGroup(
            ToolBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ToolBar3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(ToolBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TBServer3)
                    .addComponent(TBMonit3)
                    .addComponent(TBComm3)
                    .addComponent(TBData3)))
        );

        MonitTotClient.setText("0");

        javax.swing.GroupLayout MonitPanelLayout = new javax.swing.GroupLayout(MonitPanel);
        MonitPanel.setLayout(MonitPanelLayout);
        MonitPanelLayout.setHorizontalGroup(
            MonitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MonitPanelLayout.createSequentialGroup()
                .addGroup(MonitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MonitPanelLayout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(MonitTitre))
                    .addGroup(MonitPanelLayout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(MonitTotClient)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MonitPanelLayout.setVerticalGroup(
            MonitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MonitPanelLayout.createSequentialGroup()
                .addComponent(ToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(MonitTitre)
                .addGap(170, 170, 170)
                .addComponent(MonitTotClient)
                .addContainerGap(255, Short.MAX_VALUE))
        );

        getContentPane().add(MonitPanel, "card6");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //<editor-fold defaultstate="collapsed" desc=" Interaction graphique ">
    private void AdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminButtonActionPerformed
        verifPassword(AdminText.getPassword());
    }//GEN-LAST:event_AdminButtonActionPerformed

    private void ServerPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServerPortActionPerformed
        launchServer(ServerPort.getText());
    }//GEN-LAST:event_ServerPortActionPerformed

    private void ServerStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServerStartActionPerformed
        launchServer(ServerPort.getText());
    }//GEN-LAST:event_ServerStartActionPerformed

    private void ServerStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServerStopActionPerformed
        stopServer();
    }//GEN-LAST:event_ServerStopActionPerformed

    private void AdminTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminTextActionPerformed
        verifPassword(AdminText.getPassword());
    }//GEN-LAST:event_AdminTextActionPerformed

    private void TBServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBServerActionPerformed
        hidePanel("ServerPanel");
    }//GEN-LAST:event_TBServerActionPerformed

    private void TBMonitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBMonitActionPerformed
        hidePanel("MonitPanel");
    }//GEN-LAST:event_TBMonitActionPerformed

    private void TBCommActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBCommActionPerformed
        hidePanel("CommPanel");
    }//GEN-LAST:event_TBCommActionPerformed

    private void TBDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBDataActionPerformed
        hidePanel("DataPanel");
    }//GEN-LAST:event_TBDataActionPerformed

    private void TBServer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBServer1ActionPerformed
        hidePanel("ServerPanel");
    }//GEN-LAST:event_TBServer1ActionPerformed

    private void TBMonit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBMonit1ActionPerformed
        hidePanel("MonitPanel");
    }//GEN-LAST:event_TBMonit1ActionPerformed

    private void TBComm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBComm1ActionPerformed
        hidePanel("CommPanel");
    }//GEN-LAST:event_TBComm1ActionPerformed

    private void TBData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBData1ActionPerformed
        hidePanel("DataPanel");
    }//GEN-LAST:event_TBData1ActionPerformed

    private void TBServer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBServer3ActionPerformed
        hidePanel("ServerPanel");
    }//GEN-LAST:event_TBServer3ActionPerformed

    private void TBMonit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBMonit3ActionPerformed
        hidePanel("MonitPanel");
    }//GEN-LAST:event_TBMonit3ActionPerformed

    private void TBComm3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBComm3ActionPerformed
        hidePanel("CommPanel");
    }//GEN-LAST:event_TBComm3ActionPerformed

    private void TBData3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBData3ActionPerformed
        hidePanel("DataPanel");
    }//GEN-LAST:event_TBData3ActionPerformed

    private void TBServer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBServer2ActionPerformed
        hidePanel("ServerPanel");
    }//GEN-LAST:event_TBServer2ActionPerformed

    private void TBMonit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBMonit2ActionPerformed
        hidePanel("MonitPanel");
    }//GEN-LAST:event_TBMonit2ActionPerformed

    private void TBComm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBComm2ActionPerformed
        hidePanel("CommPanel");
    }//GEN-LAST:event_TBComm2ActionPerformed

    private void TBData2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBData2ActionPerformed
        hidePanel("DataPanel");
    }//GEN-LAST:event_TBData2ActionPerformed
    // </editor-fold>
    
    
    private void hidePanel(String panelName) {
        for (int i = 0; i < tabPanel.length; i++) {
            if (tabPanel[i].getName().equals(panelName)) {
                tabPanel[i].setVisible(true);
            } else {
                tabPanel[i].setVisible(false);
            }
        }
    }

    private void verifPassword(char[] input) {
        String tmp = new String(input);
        int tmpI = tmp.hashCode();
        int key = "123".hashCode();
        if (tmpI == key) {
            hidePanel("ServerPanel");
            initCommPanel();
        } else {
            String msg = "Wrong Password !";
            JOptionPane.showMessageDialog(this, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
            exit(0);
        }
    }

    private void initCommPanel() {
        //init tabUser

        //this.tabEntity = new ArrayList<Entity>();
        
        //Affichage btn
//        for (int i = 0; i < tabUser.length; i++) {
//            
//            JButton btn = new JButton(tabUser[i].nom + " " + tabUser[i].prenom);
//            btn.setName("Btn"+tabUser[i].id);
//            btn.setSize(50, 50);
//            btn.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    for(Entity ent : tabEntity){
//                        if(ent.button.getName().equals(btn.getName())){
//                            ent.convPanel.setVisible(true);
//                        }else{
//                            ent.convPanel.setVisible(false);
//                        }
//                    }
//                }
//            });
//            
//            SidePanel.add(btn).setVisible(true);
//            CommPanel.updateUI();
//            
//            ConvPanel convPanel = new ConvPanel();
//            convPanel.setName("Panel"+tabUser[i].id);
//            convPanel.ConvTitre.setText(tabUser[i].prenom + " " + tabUser[i].nom);
//            CenterPanel.add(convPanel).setVisible(false);
//            CommPanel.updateUI();
//            
//            Entity ent = new Entity(tabUser[i], btn, convPanel);
//            tabEntity.add(ent);
//            
//        }

    }

    private void launchServer(String input) {
        int port;
        if (input.isEmpty()) {
            port = 5000;
        } else {
            port = tryParse(input);
        }
        if (port != 0) {
            if (port >= 3000) {
                ThreadServer = new ThreadServer(port);
                if (ThreadServer.create) {
                    ThreadServer.start();
                    ServerStart.setEnabled(false);
                    ServerStop.setEnabled(true);
                    ServerPort.setEnabled(false);
                } else {
                    System.out.println("Server can not be created.");
                }
            } else {
                System.out.println("Port must be 3000 or more !");
            }

        } else {
            System.out.println("Port is not valid !");
        }
    }

    private void stopServer() {
        ServerStart.setEnabled(true);
        ServerStop.setEnabled(false);
        ServerPort.setEnabled(true);

        ThreadServer.running = false;
        try {
            ThreadServer.serverSocket.close();
        } catch (IOException ex) {
            System.out.println("Can not close server properly.");
        }
    }

    private static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                server = new Server();
                server.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminButton;
    private javax.swing.JLabel AdminLabel;
    private javax.swing.JPanel AdminPanel;
    private javax.swing.JPasswordField AdminText;
    public javax.swing.JPanel CenterPanel;
    public javax.swing.JPanel CommPanel;
    private javax.swing.JPanel DataPanel;
    private javax.swing.JLabel DataTitre;
    public javax.swing.JPanel MonitPanel;
    private javax.swing.JLabel MonitTitre;
    public javax.swing.JLabel MonitTotClient;
    private javax.swing.JLabel ServerDefault;
    private javax.swing.JPanel ServerPanel;
    private javax.swing.JTextField ServerPort;
    private javax.swing.JButton ServerStart;
    private javax.swing.JButton ServerStop;
    private javax.swing.JLabel ServerTitre;
    public javax.swing.JPanel SidePanel;
    private javax.swing.JButton TBComm;
    private javax.swing.JButton TBComm1;
    private javax.swing.JButton TBComm2;
    private javax.swing.JButton TBComm3;
    private javax.swing.JButton TBData;
    private javax.swing.JButton TBData1;
    private javax.swing.JButton TBData2;
    private javax.swing.JButton TBData3;
    private javax.swing.JButton TBMonit;
    private javax.swing.JButton TBMonit1;
    private javax.swing.JButton TBMonit2;
    private javax.swing.JButton TBMonit3;
    private javax.swing.JButton TBServer;
    private javax.swing.JButton TBServer1;
    private javax.swing.JButton TBServer2;
    private javax.swing.JButton TBServer3;
    private javax.swing.JPanel ToolBar;
    private javax.swing.JPanel ToolBar1;
    private javax.swing.JPanel ToolBar2;
    private javax.swing.JPanel ToolBar3;
    // End of variables declaration//GEN-END:variables
}
