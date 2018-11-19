/*
 * Set of static methods for FTP Transfer
 */
package info.vannier.gotha;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luc
 */
public class FTPTransfer {
    
    public static FTPClient connectToFTPOGSite() throws Exception{ 
        String strHost = "home206369255.1and1-data.host";
        String strLogin = "u45348341-ogt";
        String strPassword = "LVua;0cnln";
        
        FTPClient client = new FTPClient();
        client.connect(strHost);
        client.login(strLogin, strPassword);
        
        return client;
    }
    
    // upload f to OG site
    public static String uploadByFTPToOGSite(TournamentInterface tournament, File f) {
        GeneralParameterSet gps = null;
        // What directory ?
        String shortName = "defaultTournament";
        
         try {
             gps = tournament.getTournamentParameterSet().getGeneralParameterSet();
             shortName = gps.getShortName();
         } catch (RemoteException ex) {
             Logger.getLogger(FTPTransfer.class.getName()).log(Level.SEVERE, null, ex);
         }
        String strBeginDate = new SimpleDateFormat("yyyyMMdd").format(gps.getBeginDate());
        String dirName = strBeginDate + "_" + shortName;
        String strCurDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filName = strCurDate + "_" + shortName;
    
        FTPClient client = null;
        try {
            client = connectToFTPOGSite();
        } catch (Exception ex) {
            Logger.getLogger(TournamentPublishing.class.getName()).log(Level.SEVERE, null, ex);
             return "Error - FTP connection has failed";
        }
            
        try {
            client.createDirectory(dirName);
        } catch (IllegalStateException ex) {
            Logger.getLogger(FTPTransfer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FTPIllegalReplyException ex) {
            Logger.getLogger(FTPTransfer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FTPException ex) {
            System.out.println("Directory already exists");
//            Logger.getLogger(FTPTransfer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FTPTransfer.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            client.changeDirectory(dirName);
        } catch (IllegalStateException ex) {
            Logger.getLogger(FTPTransfer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FTPTransfer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FTPIllegalReplyException ex) {
            Logger.getLogger(FTPTransfer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FTPException ex) {
            Logger.getLogger(FTPTransfer.class.getName()).log(Level.SEVERE, null, ex);            
        }
       
        File fil = new File(filName);
        try {
            client.upload(f);
            client.rename(f.getName(), fil.getName());
        } catch (IllegalStateException ex) {
            Logger.getLogger(FTPTransfer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FTPTransfer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FTPIllegalReplyException ex) {
            Logger.getLogger(FTPTransfer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FTPException ex) {
            Logger.getLogger(FTPTransfer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FTPDataTransferException ex) {
            Logger.getLogger(FTPTransfer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FTPAbortedException ex) {
            Logger.getLogger(FTPTransfer.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       try {
            client.disconnect(true);
        } catch (Exception ex) {
            Logger.getLogger(JFrPublish.class.getName()).log(Level.SEVERE, null, ex);
        }

        String strURL = "" + f.getName() + " has been successfully uploaded to opengotha.info/tournaments/" + dirName + "/" + f.getName();
        return strURL;
    }
    
}
