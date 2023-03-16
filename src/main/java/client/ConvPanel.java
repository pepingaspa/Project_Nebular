package client;

import classes.Cryptage;
import classes.Message;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import javax.swing.JFileChooser;

public class ConvPanel extends javax.swing.JPanel {
    
    DataOutputStream out;
    public int idExp, idConv;
    SecretKey keyDef;
    
    public ConvPanel(Socket tmpSocket, int idExp, int idConv) {
        initComponents();
        this.idExp = idExp;
        this.idConv = idConv;
        this.keyDef = Client.getKeyDef();
        try {
            this.out = new DataOutputStream(tmpSocket.getOutputStream());
        } catch (IOException ex) {
            System.out.println("CONVPANEL : Can not create object");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConvText = new javax.swing.JTextField();
        ConvScroll = new javax.swing.JScrollPane();
        ConvArea = new javax.swing.JTextArea();
        ConvBtn = new javax.swing.JButton();
        ConvTitre = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));

        ConvText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvTextActionPerformed(evt);
            }
        });

        ConvArea.setColumns(20);
        ConvArea.setRows(5);
        ConvScroll.setViewportView(ConvArea);

        ConvBtn.setText("Send");
        ConvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvBtnActionPerformed(evt);
            }
        });

        ConvTitre.setForeground(new java.awt.Color(255, 255, 255));
        ConvTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setText("File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConvTitre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ConvScroll)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ConvText, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ConvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ConvTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConvScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConvText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConvBtn)
                    .addComponent(jButton1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ConvTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvTextActionPerformed
        write(ConvText.getText());
    }//GEN-LAST:event_ConvTextActionPerformed

    private void ConvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvBtnActionPerformed
        write(ConvText.getText());
    }//GEN-LAST:event_ConvBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int ret = fileChooser.showOpenDialog(this);
        if(ret == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            write(file);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void write(String content){
        if(!content.isEmpty() && !content.isBlank()){
            try {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            Message msg = new Message(0, idConv, idExp, true, content, true, myDateObj.format(myFormatObj));
            ConvArea.setText(ConvArea.getText()+msg.affichage()+"\n");
            String send = Cryptage.encrypt(msg.concat(), keyDef);
            out.writeUTF(send);
            out.flush();
            ConvText.setText("");
            
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void write(File file){
        try{
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            Message msg = new Message(0, idConv, idExp, true, file, true, myDateObj.format(myFormatObj));
            ConvArea.setText(ConvArea.getText() + "File sent" + "\n");
            String send = Cryptage.encrypt(msg.concat(), keyDef);
            System.out.println("SEND FILE");
            //découpage
            out.writeUTF(send);
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea ConvArea;
    private javax.swing.JButton ConvBtn;
    private javax.swing.JScrollPane ConvScroll;
    private javax.swing.JTextField ConvText;
    public javax.swing.JLabel ConvTitre;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
