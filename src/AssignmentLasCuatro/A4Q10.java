/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentLasCuatro;

/**
 *
 * @author pritb9521
 */
public class A4Q10 extends javax.swing.JFrame {

    /**
     * Creates new form A4Q10
     */
    public A4Q10() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fahrenheit = new javax.swing.JTextField();
        celsius = new javax.swing.JTextField();
        ftoc = new javax.swing.JButton();
        ctof = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Papyrus", 0, 11)); // NOI18N
        jLabel1.setText("Degrees Fahrenheit");

        jLabel2.setFont(new java.awt.Font("Papyrus", 0, 11)); // NOI18N
        jLabel2.setText("Degrees Celsius");

        fahrenheit.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        fahrenheit.setText("Enter Value");

        celsius.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        celsius.setText("Enter Value");
        celsius.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celsiusActionPerformed(evt);
            }
        });

        ftoc.setText("F --> C");
        ftoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftocActionPerformed(evt);
            }
        });

        ctof.setText("C --> F");
        ctof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctofActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fahrenheit)
                    .addComponent(celsius, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ftoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ctof))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fahrenheit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftoc))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(celsius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ctof))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void celsiusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celsiusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_celsiusActionPerformed

    private void ftocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftocActionPerformed
        // Get the fahrenheit value and turn it into a int
        String fheit = fahrenheit.getText();
        double fahren = Double.parseDouble(fheit);
        
        // convert to celsius
        double celsiusNum = (((fahren - 32)*5)/9)*100;
        celsiusNum = Math.round(celsiusNum);
        celsiusNum = celsiusNum / 100;
        
        // Convert back to string
        String result = Double.toString(celsiusNum);
        
        // Display result
        celsius.setText(result);
    }//GEN-LAST:event_ftocActionPerformed

    private void ctofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctofActionPerformed
        
        // Get the fahrenheit value and turn it into a int
        String cel = celsius.getText();
        double sius = Double.parseDouble(cel);
        
        // convert to celsius
        double fahrenheitNum = (((sius * 9) / 5) + 32)*100;
        fahrenheitNum = Math.round(fahrenheitNum);
        fahrenheitNum = fahrenheitNum / 100;
        
        // Convert back to string
        String result = Double.toString(fahrenheitNum);
        
        // Display result
        fahrenheit.setText(result);
    }//GEN-LAST:event_ctofActionPerformed

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
            java.util.logging.Logger.getLogger(A4Q10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A4Q10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A4Q10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A4Q10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A4Q10().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField celsius;
    private javax.swing.JButton ctof;
    private javax.swing.JTextField fahrenheit;
    private javax.swing.JButton ftoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
