package pfe.nebular.server;

public class ConvPanel extends javax.swing.JPanel {
    
    public ConvPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConvText = new javax.swing.JTextField();
        ConvScroll = new javax.swing.JScrollPane();
        ConvArea = new javax.swing.JTextArea();
        ConvBtn = new javax.swing.JButton();
        ConvTitre = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));

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
                        .addComponent(ConvText, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ConvBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
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
                    .addComponent(ConvBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ConvTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvTextActionPerformed
        write(ConvText.getText());
    }//GEN-LAST:event_ConvTextActionPerformed

    private void ConvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvBtnActionPerformed
        write(ConvText.getText());
    }//GEN-LAST:event_ConvBtnActionPerformed

    public void write(String msg){
        if(!msg.isEmpty() && !msg.isBlank()){
            System.out.println(msg);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ConvArea;
    private javax.swing.JButton ConvBtn;
    private javax.swing.JScrollPane ConvScroll;
    private javax.swing.JTextField ConvText;
    public javax.swing.JLabel ConvTitre;
    // End of variables declaration//GEN-END:variables
}
