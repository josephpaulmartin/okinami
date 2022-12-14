/*
 * JFrPreferences.java
 */

package info.vannier.gotha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luc Vannier
 */
public class JFrPreferencesOptions extends javax.swing.JFrame {
    private static final long REFRESH_DELAY = 2000;

    /** Creates new form JFrPreferences */
    public JFrPreferencesOptions() {
        initComponents();
        customInitComponents();
        setupRefreshPreferencesTimer();
    }

    // This setupRefreshTimer is dedicated to refresh Preferences and not Tournament data
    
    private volatile boolean running = true;
    javax.swing.Timer timer = null;
    private void setupRefreshPreferencesTimer() {
        ActionListener taskPerformer;
        taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!running){
                    timer.stop();
                }
                updateAllViews();
            }
        };
        timer = new javax.swing.Timer((int) REFRESH_DELAY, taskPerformer);
        timer.start();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpHelpLanguage = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        grpTournaments = new javax.swing.ButtonGroup();
        pnlBasicPreferences = new javax.swing.JPanel();
        scpBasicPreferences = new javax.swing.JScrollPane();
        tblBasicPreferences = new javax.swing.JTable();
        btnClearBasicPreferences = new javax.swing.JButton();
        pnlInternetAccess = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ckbRatingLists = new javax.swing.JCheckBox();
        ckbPhotos = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        ckbTournaments = new javax.swing.JCheckBox();
        rdbAfterEverySave = new javax.swing.JRadioButton();
        rdbAfterEveryChange = new javax.swing.JRadioButton();
        btnHelp = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Preferences");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        pnlBasicPreferences.setBorder(javax.swing.BorderFactory.createTitledBorder("Basic OpenGotha Preferences"));
        pnlBasicPreferences.setLayout(null);

        tblBasicPreferences.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "key", "value"
            }
        ));
        scpBasicPreferences.setViewportView(tblBasicPreferences);

        pnlBasicPreferences.add(scpBasicPreferences);
        scpBasicPreferences.setBounds(10, 20, 564, 210);

        btnClearBasicPreferences.setText("Clear basic OpenGotha Preferences");
        btnClearBasicPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearBasicPreferencesActionPerformed(evt);
            }
        });
        pnlBasicPreferences.add(btnClearBasicPreferences);
        btnClearBasicPreferences.setBounds(10, 240, 564, 23);

        getContentPane().add(pnlBasicPreferences);
        pnlBasicPreferences.setBounds(106, 20, 584, 280);

        pnlInternetAccess.setBorder(javax.swing.BorderFactory.createTitledBorder("Internet access"));
        pnlInternetAccess.setLayout(null);

        jLabel1.setText("Enable Download for :");
        pnlInternetAccess.add(jLabel1);
        jLabel1.setBounds(10, 20, 180, 14);

        ckbRatingLists.setSelected(true);
        ckbRatingLists.setText("Rating lists");
        ckbRatingLists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbRatingListsActionPerformed(evt);
            }
        });
        pnlInternetAccess.add(ckbRatingLists);
        ckbRatingLists.setBounds(30, 40, 160, 23);

        ckbPhotos.setSelected(true);
        ckbPhotos.setText("Photos");
        ckbPhotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbPhotosActionPerformed(evt);
            }
        });
        pnlInternetAccess.add(ckbPhotos);
        ckbPhotos.setBounds(30, 70, 160, 23);

        jLabel2.setText("Enable Upload for :");
        pnlInternetAccess.add(jLabel2);
        jLabel2.setBounds(200, 20, 180, 14);

        ckbTournaments.setSelected(true);
        ckbTournaments.setText("Tournaments files");
        ckbTournaments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbTournamentsActionPerformed(evt);
            }
        });
        pnlInternetAccess.add(ckbTournaments);
        ckbTournaments.setBounds(210, 40, 150, 23);

        grpTournaments.add(rdbAfterEverySave);
        rdbAfterEverySave.setText("After every save");
        rdbAfterEverySave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAfterEverySaveActionPerformed(evt);
            }
        });
        pnlInternetAccess.add(rdbAfterEverySave);
        rdbAfterEverySave.setBounds(370, 30, 180, 23);

        grpTournaments.add(rdbAfterEveryChange);
        rdbAfterEveryChange.setText("After every change");
        rdbAfterEveryChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAfterEveryChangeActionPerformed(evt);
            }
        });
        pnlInternetAccess.add(rdbAfterEveryChange);
        rdbAfterEveryChange.setBounds(370, 60, 180, 23);

        getContentPane().add(pnlInternetAccess);
        pnlInternetAccess.setBounds(110, 320, 580, 140);

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/vannier/gotha/gothalogo16.jpg"))); // NOI18N
        btnHelp.setText("help");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        getContentPane().add(btnHelp);
        btnHelp.setBounds(110, 470, 120, 30);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose);
        btnClose.setBounds(250, 470, 440, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        cleanClose();
}//GEN-LAST:event_btnCloseActionPerformed

    private void cleanClose(){
        running = false;
        dispose();
    }

    private void btnClearBasicPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearBasicPreferencesActionPerformed
        Preferences prefsRoot = Preferences.userRoot();
        Preferences gothaPrefs = prefsRoot.node(Gotha.strPreferences);
        try {
            gothaPrefs.clear();
        } catch (BackingStoreException ex) {
            Logger.getLogger(JFrPreferencesOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gotha.setRatingListsDownloadEnabled(true);
        Gotha.setPhotosDownloadEnabled(true);
//        Gotha.setJournalingReportEnabled(true);

        updateAllViews();
    }//GEN-LAST:event_btnClearBasicPreferencesActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        Gotha.displayGothaHelp("Preferences frame");
}//GEN-LAST:event_btnHelpActionPerformed

    private void ckbPhotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbPhotosActionPerformed
         Gotha.setPhotosDownloadEnabled(this.ckbPhotos.isSelected());
    }//GEN-LAST:event_ckbPhotosActionPerformed

    private void ckbRatingListsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbRatingListsActionPerformed
        Gotha.setRatingListsDownloadEnabled(this.ckbRatingLists.isSelected());
    }//GEN-LAST:event_ckbRatingListsActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cleanClose();
    }//GEN-LAST:event_formWindowClosing

    private void ckbTournamentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbTournamentsActionPerformed
        updateTournamentUploadStatusFromControls();
    }//GEN-LAST:event_ckbTournamentsActionPerformed
    
    private void updateTournamentUploadStatusFromControls(){
            boolean btf = this.ckbTournaments.isSelected();
        boolean baes = this.rdbAfterEverySave.isSelected();
        if (btf && baes){
            Gotha.setTournamentUploadStatus(Gotha.TU_EVERYSAVE);
        }
        if (btf && !baes){
            Gotha.setTournamentUploadStatus(Gotha.TU_EVERYCHANGE);
        }
        if(!btf){
            Gotha.setTournamentUploadStatus(Gotha.TU_NONE);
        }
    
    }
    private void rdbAfterEverySaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAfterEverySaveActionPerformed
        updateTournamentUploadStatusFromControls();
    }//GEN-LAST:event_rdbAfterEverySaveActionPerformed

    private void rdbAfterEveryChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAfterEveryChangeActionPerformed
        updateTournamentUploadStatusFromControls();
    }//GEN-LAST:event_rdbAfterEveryChangeActionPerformed
        
    private void customInitComponents(){
        this.updateAllViews();
    }
    private void updateAllViews(){
        updatePnlPref();
        updatePnlInternetAccess();
    }
    
    private void updatePnlPref(){
        Preferences prefsRoot = Preferences.userRoot();
    
        Preferences gothaPrefs = prefsRoot.node(Gotha.strPreferences);  
        String[] strPrefs = null;
        try {
            strPrefs = gothaPrefs.keys();
        } catch (BackingStoreException ex) {
            Logger.getLogger(JFrPreferencesOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int len;
        if (strPrefs == null) len = 0;
        else len = strPrefs.length;
        DefaultTableModel model = (DefaultTableModel) tblBasicPreferences.getModel();
        model.setRowCount(len);
        for (int i = 0; i < len; i++){
            String key = strPrefs[i];
            String value = gothaPrefs.get(key, "def");            
            model.setValueAt(key, i, 0);
            model.setValueAt(value, i, 1);
        }
        
        Preferences gothaLogPrefs = prefsRoot.node(Gotha.strPreferences + "/log");
        String[] strLogPrefs = null;
        try {
            strLogPrefs = gothaLogPrefs.keys();
        } catch (BackingStoreException ex) {
            Logger.getLogger(JFrPreferencesOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        if (strPrefs == null) len = 0;
//        else len = strLogPrefs.length;
//        DefaultTableModel logModel = (DefaultTableModel) tblLogPreferences.getModel();
//        logModel.setRowCount(len);
//        for (int i = 0; i < len; i++){
//            String key = strLogPrefs[i];
//            String value = gothaLogPrefs.get(key, "def");
//            
//            logModel.setValueAt(key, i, 0);
//            logModel.setValueAt(value, i, 1);
//        }
    }

    private void updatePnlInternetAccess(){
        this.ckbRatingLists.setSelected(Gotha.isRatingListsDownloadEnabled());
        this.ckbPhotos.setSelected(Gotha.isPhotosDownloadEnabled());
//        this.ckbJournaling.setSelected(Gotha.isJournalingReportEnabled());
        
        if (Gotha.runningMode == Gotha.RUNNING_MODE_CLI){
            this.ckbTournaments.setVisible(false);
            this.rdbAfterEverySave.setVisible(false);
            this.rdbAfterEveryChange.setVisible(false);
            return;
        }

        if (Gotha.getTournamentUploadStatus() == Gotha.TU_NONE){
            this.ckbTournaments.setSelected(false);
            this.rdbAfterEverySave.setVisible(false);
            this.rdbAfterEveryChange.setVisible(false);
        }
        else{
            this.ckbTournaments.setSelected(true);
            this.rdbAfterEverySave.setVisible(true);
            this.rdbAfterEveryChange.setVisible(true);
            if (Gotha.getTournamentUploadStatus() == Gotha.TU_EVERYSAVE){
                this.rdbAfterEverySave.setSelected(true);
            }
            if (Gotha.getTournamentUploadStatus() == Gotha.TU_EVERYCHANGE){
                this.rdbAfterEveryChange.setSelected(true);
            }
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearBasicPreferences;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHelp;
    private javax.swing.JCheckBox ckbPhotos;
    private javax.swing.JCheckBox ckbRatingLists;
    private javax.swing.JCheckBox ckbTournaments;
    private javax.swing.ButtonGroup grpHelpLanguage;
    private javax.swing.ButtonGroup grpTournaments;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnlBasicPreferences;
    private javax.swing.JPanel pnlInternetAccess;
    private javax.swing.JRadioButton rdbAfterEveryChange;
    private javax.swing.JRadioButton rdbAfterEverySave;
    private javax.swing.JScrollPane scpBasicPreferences;
    private javax.swing.JTable tblBasicPreferences;
    // End of variables declaration//GEN-END:variables

}
