/**
 * This is the Form were you can see every book
 * that was read by the user. Also provides info
 * about when the reading started and when ended
 */
package myconsumptions;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Thodoris Kouleris
 */
public class Books extends javax.swing.JFrame {
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    int col[] = {60,200,95,95};
    
    /**
     * Constructor
     */
    public Books() {
        initComponents();
        
        Toolkit toolkit = getToolkit();
        Dimension size  = toolkit.getScreenSize();
        //setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);      
        setLocation(500, size.height/2 - getHeight()/2);             
        conn = db.java_db();
        this.loadList();
        
        tbl_books.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setColumnWidth(col);
        
    }
    /**
     * 
     * Setting column width for jtable
     */
    private void setColumnWidth(int[] width){
        int x = tbl_books.getColumnCount()-1;
        for(int i=0; i<=x; i++){
            TableColumn column = tbl_books.getColumnModel().getColumn(i);
            column.setPreferredWidth(width[i]);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_loadBooks = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_books = new javax.swing.JTable();
        btn_Ok = new javax.swing.JButton();
        btn_OpenBookForm = new javax.swing.JButton();
        btn_editBook = new javax.swing.JButton();
        btn_deleteBook = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Books");

        btn_loadBooks.setText("Load");
        btn_loadBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loadBooksActionPerformed(evt);
            }
        });

        tbl_books.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "BookID", "Book Title", "Starting Date", "Ending Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_books);
        if (tbl_books.getColumnModel().getColumnCount() > 0) {
            tbl_books.getColumnModel().getColumn(2).setMinWidth(60);
            tbl_books.getColumnModel().getColumn(2).setPreferredWidth(60);
            tbl_books.getColumnModel().getColumn(2).setMaxWidth(60);
            tbl_books.getColumnModel().getColumn(3).setMinWidth(60);
            tbl_books.getColumnModel().getColumn(3).setPreferredWidth(60);
            tbl_books.getColumnModel().getColumn(3).setMaxWidth(60);
        }

        btn_Ok.setText("OK");
        btn_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OkActionPerformed(evt);
            }
        });

        btn_OpenBookForm.setText("Add");
        btn_OpenBookForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OpenBookFormActionPerformed(evt);
            }
        });

        btn_editBook.setText("Edit");
        btn_editBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editBookActionPerformed(evt);
            }
        });

        btn_deleteBook.setText("Delete");
        btn_deleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_loadBooks)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Ok)
                        .addGap(16, 16, 16))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 266, Short.MAX_VALUE)
                .addComponent(btn_OpenBookForm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_editBook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_deleteBook)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_OpenBookForm)
                    .addComponent(btn_editBook)
                    .addComponent(btn_deleteBook))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Ok)
                    .addComponent(btn_loadBooks))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     * Load List button
     */
    private void btn_loadBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadBooksActionPerformed

        this.loadList();
        tbl_books.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setColumnWidth(col);
        
    }//GEN-LAST:event_btn_loadBooksActionPerformed
    /**
     * 
     * Open NewEdit Window in Insert Mode
     */
    private void btn_OpenBookFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OpenBookFormActionPerformed
        
        AddEditBookForm abf = new AddEditBookForm();
        abf.editRecID = 0;
        abf.setVisible(true);
        this.dispose();
                
    }//GEN-LAST:event_btn_OpenBookFormActionPerformed
    /**
     * 
     * Open NewEdit Window in Edit Mode
     */
    private void btn_editBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editBookActionPerformed
        // TODO add your handling code here:
        int selRow = 0;
        int bookID = 0;
        

        selRow = tbl_books.getSelectedRow();
        bookID = (int)tbl_books.getValueAt(selRow, 0);
        
        this.loadRecord(bookID);
        //System.out.println(bookID);
       
    }//GEN-LAST:event_btn_editBookActionPerformed
    
    /**
     * 
     * Fetches a book record from the DB
     */   
    private void loadRecord(int bookID ) {    
        
        if(bookID < 0){
            JOptionPane.showMessageDialog(null, "No book is Selected!");
        }
        
        String sql = "SELECT BookID AS 'Book ID', BookTitle AS 'Book Title', BookStartingDate AS 'Date Started', BookEndingDate AS 'Date Ended' FROM Books WHERE BookID = ?";
        
        String BookTitle = "";
        String BookStartingDate = "";
        String BookEndingDate = "";
        
        try{

            pst = conn.prepareStatement(sql);    
            pst.setInt(1, bookID);
            rs = pst.executeQuery();
            //rs.getString(1);
            BookTitle = rs.getString(2);
            BookStartingDate = rs.getString(3);
            BookEndingDate = rs.getString(4);
            
            
            AddEditBookForm adf = new AddEditBookForm();
            
            adf.setVisible(true);
            adf.editRecID = bookID;
            
            Map<String, String> mymap = new HashMap<String, String>();
            mymap.put("BookID", Integer.toString(bookID) );
            mymap.put("BookTitle", BookTitle); 
            mymap.put("BookStartingDate", BookStartingDate);
            mymap.put("BookEndingDate", BookEndingDate);
            
            adf.loadRecordToForm(mymap);
            rs.close();
            pst.close();            
            
            this.dispose();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                rs.close();
                pst.close();
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "DB Error!");
            }
        }                     
    }   
    
    /**
     * Load List function 
     */  
    private void loadList() {  
        
        // set Jtable column width
        tbl_books.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setColumnWidth(col);
        
        String sql = "SELECT BookID AS 'Book ID'"
                    + ", BookTitle AS 'Book Title'"
                    + ", BookStartingDate AS 'Date Started'"
                    + ", BookEndingDate AS 'Date Ended' "
                    + "FROM Books "
                    //+ "WHERE strftime('%Y',BookStartingDate) = ?"
                    + "ORDER BY date(BookStartingDate) DESC";

        try{

            pst = conn.prepareStatement(sql);        
            rs = pst.executeQuery();

            tbl_books.setModel(DbUtils.resultSetToTableModel(rs));
                        
            rs.close();
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                rs.close();
                pst.close();
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "DB Error!");
            }
        }
    }

    /**
     * 
     * OK button - Goes back to the main menu
     */
    private void btn_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OkActionPerformed

        MainMenu mm = new MainMenu();
        mm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_OkActionPerformed
    
    
    /**
     * 
     * Deletes a selected record
     */
    private void btn_deleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteBookActionPerformed
        // TODO add your handling code here:
        int selRow = 0;
        int bookID = 0;
        

        selRow = tbl_books.getSelectedRow();
        bookID = (int)tbl_books.getValueAt(selRow, 0);
        
        AddEditBookForm.delete_BookRecord(bookID);
        
        this.loadList();
    }//GEN-LAST:event_btn_deleteBookActionPerformed

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
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Books().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ok;
    private javax.swing.JButton btn_OpenBookForm;
    private javax.swing.JButton btn_deleteBook;
    private javax.swing.JButton btn_editBook;
    private javax.swing.JButton btn_loadBooks;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_books;
    // End of variables declaration//GEN-END:variables
}
