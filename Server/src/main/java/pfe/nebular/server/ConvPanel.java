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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConvScroll)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ConvText, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ConvBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ConvScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
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
        System.out.println(msg);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ConvArea;
    private javax.swing.JButton ConvBtn;
    private javax.swing.JScrollPane ConvScroll;
    private javax.swing.JTextField ConvText;
    // End of variables declaration//GEN-END:variables
}
