/**
 * This is the Form were you can see every TV Show
 * that was watched by the user. Also provides info
 * about when the user started watching the TV Show
 * and when ended
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
public class TVShows extends javax.swing.JFrame {
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    int col[] = {80,195,95,95};
    
    /**
     * Constructor
     */
    public TVShows() {
        initComponents();
        
        Toolkit toolkit = getToolkit();
        Dimension size  = toolkit.getScreenSize();    
        setLocation(500, size.height/2 - getHeight()/2);             
        conn = db.java_db();      
        this.loadList();
        
        // set Jtable column width
        tbl_TVShowsList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setColumnWidth(col);
    }
    
    /**
     * 
     * Setting column width for jtable
     */
    private void setColumnWidth(int[] width){
        int x = tbl_TVShowsList.getColumnCount()-1;
        for(int i=0; i<=x; i++){
            TableColumn column = tbl_TVShowsList.getColumnModel().getColumn(i);
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

        btn_AddTVShow = new javax.swing.JButton();
        btn_editTVShow = new javax.swing.JButton();
        btn_deleteTVShow = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_TVShowsList = new javax.swing.JTable();
        btn_LoadTVShowList = new javax.swing.JButton();
        btn_OKTVShows = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TV Shows Consumptions");

        btn_AddTVShow.setText("Add");
        btn_AddTVShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddTVShowActionPerformed(evt);
            }
        });

        btn_editTVShow.setText("Edit");
        btn_editTVShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editTVShowActionPerformed(evt);
            }
        });

        btn_deleteTVShow.setText("Delete");
        btn_deleteTVShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteTVShowActionPerformed(evt);
            }
        });

        tbl_TVShowsList.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID", "Title", "Date Started", "Date Ended"
            }
        ));
        jScrollPane1.setViewportView(tbl_TVShowsList);

        btn_LoadTVShowList.setText("Load");
        btn_LoadTVShowList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoadTVShowListActionPerformed(evt);
            }
        });

        btn_OKTVShows.setText("OK");
        btn_OKTVShows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OKTVShowsActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_AddTVShow, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_editTVShow, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_deleteTVShow)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_LoadTVShowList, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_OKTVShows, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_AddTVShow)
                    .addComponent(btn_editTVShow)
                    .addComponent(btn_deleteTVShow))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_OKTVShows)
                    .addComponent(btn_LoadTVShowList))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     * Button that goes back to main menu
     */
    private void btn_OKTVShowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OKTVShowsActionPerformed
       
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_OKTVShowsActionPerformed

    /**
     * 
     * Button that loads the list
     */
    private void btn_LoadTVShowListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoadTVShowListActionPerformed
        
        this.loadList();
        // set Jtable column width
        tbl_TVShowsList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setColumnWidth(col);        
    }//GEN-LAST:event_btn_LoadTVShowListActionPerformed

    
    /**
     * 
     * Opens a NewEdit Window in Insert Mode
     */
    private void btn_AddTVShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddTVShowActionPerformed
                
        AddEditTVShowForm aetvform = new AddEditTVShowForm();
        aetvform.editRecID = 0;
        aetvform.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_AddTVShowActionPerformed

    /**
     * 
     * Opens a Window in Edit Mode
     */
    private void btn_editTVShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editTVShowActionPerformed
        
        int selRow = 0;
        int tvshowID = 0;
        

        selRow = tbl_TVShowsList.getSelectedRow();
        tvshowID = (int)tbl_TVShowsList.getValueAt(selRow, 0);
        
        this.loadRecord(tvshowID);
    }//GEN-LAST:event_btn_editTVShowActionPerformed

    /**
     * 
     * Deletes the selected record
     */
    private void btn_deleteTVShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteTVShowActionPerformed
        // TODO add your handling code here:
        int selRow = 0;
        int tvshowID = 0;
        

        selRow = tbl_TVShowsList.getSelectedRow();
        tvshowID = (int)tbl_TVShowsList.getValueAt(selRow, 0);
        
        AddEditTVShowForm.delete_TVShowRecord(tvshowID);
        this.loadList();        
    }//GEN-LAST:event_btn_deleteTVShowActionPerformed
    
    /**
     * 
     * Fetched a record from db
     */
    private void loadRecord(int tvshowID ) {    
        
        if(tvshowID < 0){
            JOptionPane.showMessageDialog(null, "No TV Show is Selected!");
        }
        
        String sql = "SELECT TVShowID AS 'TV Show ID', TVShowTitle AS 'TVShow Title', TVShowDateStart AS 'Date Started', TVShowDateEnd AS 'Date Ended' FROM TVShows WHERE TVshowID = ?";
        
        String TVShowTitle = "";
        String TVShowStartingDate = "";
        String TVShowEndingDate = "";
        
        try{

            pst = conn.prepareStatement(sql);    
            pst.setInt(1, tvshowID);
            rs = pst.executeQuery();            
            TVShowTitle = rs.getString(2);
            TVShowStartingDate = rs.getString(3);
            TVShowEndingDate = rs.getString(4);
            
            
            AddEditTVShowForm aetvf = new AddEditTVShowForm();
            
            aetvf.setVisible(true);
            aetvf.editRecID = tvshowID;
            
            Map<String, String> mymap = new HashMap<String, String>();
            mymap.put("TVShowID", Integer.toString(tvshowID) );
            mymap.put("TVShowTitle", TVShowTitle); 
            mymap.put("TVShowStartingDate", TVShowStartingDate);
            mymap.put("TVShowEndingDate", TVShowEndingDate);
            
            aetvf.loadRecordToForm(mymap);
            
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
        String sql = "SELECT TVShowID AS 'TV Show ID', TVShowTitle AS 'TV Show Title', TVShowDateStart AS 'Date Started', TVShowDateEnd AS 'Date Ended' FROM TVShows ORDER BY date(TVShowDateStart) DESC";

        try{

            pst = conn.prepareStatement(sql);           
            rs = pst.executeQuery();

            tbl_TVShowsList.setModel(DbUtils.resultSetToTableModel(rs));
            
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
            java.util.logging.Logger.getLogger(TVShows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TVShows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TVShows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TVShows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TVShows().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AddTVShow;
    private javax.swing.JButton btn_LoadTVShowList;
    private javax.swing.JButton btn_OKTVShows;
    private javax.swing.JButton btn_deleteTVShow;
    private javax.swing.JButton btn_editTVShow;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_TVShowsList;
    // End of variables declaration//GEN-END:variables
}
