/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myconsumptions;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author darkheart
 */
public class AddEditBookForm extends javax.swing.JFrame {
    
    Connection conn = null;    
    PreparedStatement pst = null;
    int editRecID = 0;
    
    /**
     * Creates new form AddBookForm
     */
    public AddEditBookForm( ) {
        initComponents();
        conn = db.java_db();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();     
        setLocation(500, size.height/2 - getHeight()/2);   
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
        jLabel3 = new javax.swing.JLabel();
        txt_bookTitle = new javax.swing.JTextField();
        cal_dateBookStarted = new com.toedter.calendar.JDateChooser();
        cal_dateBookEnded = new com.toedter.calendar.JDateChooser();
        btn_saveBook = new javax.swing.JButton();
        btn_CancelBook = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Book Information");

        jLabel1.setText("Title");

        jLabel2.setText("Date Started");

        jLabel3.setText("Date Ended");

        cal_dateBookStarted.setDateFormatString("yyyy-MM-dd");

        cal_dateBookEnded.setDateFormatString("yyyy-MM-dd");

        btn_saveBook.setText("Save");
        btn_saveBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveBookActionPerformed(evt);
            }
        });

        btn_CancelBook.setText("Cancel");
        btn_CancelBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_CancelBook)
                        .addGap(18, 18, 18)
                        .addComponent(btn_saveBook)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cal_dateBookEnded, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cal_dateBookStarted, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 21, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cal_dateBookStarted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cal_dateBookEnded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_CancelBook)
                    .addComponent(btn_saveBook))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveBookActionPerformed
        // TODO add your handling code here:
        if(this.editRecID > 0){
            this.update_BookRecord();
        }else{
            this.insert_new_BookRecord();
        }
    }//GEN-LAST:event_btn_saveBookActionPerformed

    private void btn_CancelBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelBookActionPerformed
        // TODO add your handling code here:
        Books bp = new Books();
        bp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_CancelBookActionPerformed

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
            java.util.logging.Logger.getLogger(AddEditBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEditBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEditBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEditBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEditBookForm().setVisible(true);
            }
        });
    }
    // Clear All function
    public void clearAll(){
        
        txt_bookTitle.setText("");
        cal_dateBookStarted.setDate(null);
        cal_dateBookEnded.setDate(null);
    }
    public static void delete_BookRecord(int bookID){
        if(bookID <=0){
            JOptionPane.showMessageDialog(null,"No Valid Record Selected");
        }
        int BookID = bookID;
        Connection conn = db.java_db();  
        
        System.out.println(conn);
                
        try {
            String sql ="DELETE FROM Books WHERE BookID = ?";
            
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1,Integer.toString(BookID));
                pst.execute();
                JOptionPane.showMessageDialog(null,"Data deleted successfully");
            }

       }
       catch (SQLException | HeadlessException e){
          
           JOptionPane.showMessageDialog(null,e);
       }
       finally {
            try{                
               
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }            
        }
    }
    //update book record
    public void update_BookRecord(){
        if(this.editRecID <= 0){
            JOptionPane.showMessageDialog(null,"No Valid Record Selected");
        }
        int BookID = this.editRecID;        
        
        try {
            String sql ="UPDATE Books SET " 
                        + "BookTitle = ?"
                        + ",BookStartingDate = ?"
                        + ",BookEndingDate = ?"
                        +"WHERE BookID = ?";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1,txt_bookTitle.getText());
            pst.setString(2,((JTextField)cal_dateBookStarted.getDateEditor().getUiComponent()).getText());
            pst.setString(3,((JTextField)cal_dateBookEnded.getDateEditor().getUiComponent()).getText() );
            pst.setString(4,Integer.toString(BookID));
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data is saved successfully");

       }
       catch (Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
       finally {
            try{                
                pst.close();
                //clearAll();
                Books bp = new Books();
                bp.setVisible(true);
                this.dispose();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }            
        }         
        
    }
    
    // Insert new book Record
    public void insert_new_BookRecord(){
        try {
            String sql ="insert into Books " 
                        + "(BookTitle, BookStartingDate,BookEndingDate) "
                        + "values (?,?,?)";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1,txt_bookTitle.getText());
            pst.setString(2,((JTextField)cal_dateBookStarted.getDateEditor().getUiComponent()).getText());
            pst.setString(3,((JTextField)cal_dateBookEnded.getDateEditor().getUiComponent()).getText() );            
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data is saved successfully");

       }
       catch (Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
       finally {
            try{                
                pst.close();
                //clearAll();
                Books bp = new Books();
                bp.setVisible(true);
                this.dispose();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }            
        }         
    }
    
    //Load Record to Form
    public void loadRecordToForm(Map data) throws ParseException{
        
        txt_bookTitle.setText( (String)data.get("BookTitle") );
        String dateStartInString = (String)data.get("BookStartingDate");
        
        String dateEndInString = (String)data.get("BookEndingDate");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date BookStartingDate = sdf.parse(dateStartInString);
        java.util.Date BookEndingDate = sdf.parse(dateEndInString);


        cal_dateBookStarted.setDate(BookStartingDate);
        cal_dateBookEnded.setDate(BookEndingDate);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CancelBook;
    private javax.swing.JButton btn_saveBook;
    private com.toedter.calendar.JDateChooser cal_dateBookEnded;
    private com.toedter.calendar.JDateChooser cal_dateBookStarted;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_bookTitle;
    // End of variables declaration//GEN-END:variables
}
