/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lib.CassandraHosts;
import stores.DiaryInfo;
import stores.ProfileInfo;

/**
 *
 * @author TheFractal
 */
public class ViewDiaryModel {
    private Cluster cluster;
    private HttpSession session;
    private String username=null;
    private String description;
    private String start;
    private String end;
    private int severity;
    private String medication;
    private String triggers;
    
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
        
    }
    public DiaryInfo getDiaryInfo(String username)throws ServletException, IOException{
        
         
         
         try ( 
            Session csession = cluster.connect("migrainediary")) {
            ResultSet rs = null;
             DiaryInfo d = new DiaryInfo(username);
            
            PreparedStatement ps = csession.prepare("select * from migrainediary.diary where username='"+username+"'"); 
            BoundStatement boundStatement = new BoundStatement(ps);
            rs = csession.execute(
                    boundStatement.bind() );
            if (rs.isExhausted()){
                System.out.println("No First Name returned");
                
            }else{
                
                
                for (Row row : rs){
                    
                  
                    description = row.getString("description");
                    start = row.getString("start");
                    end = row.getString("end");
                    severity = row.getInt("severity");
                    medication = row.getString("medication");
                   triggers = row.getString("triggers");
                d.setUsername(username);
                d.setDescription(description);
                d.setStart(start);
                d.setEnd(end);
                d.setSeverity(severity);
                d.setMedication(medication);
                d.setTriggers(triggers);
                }
            }
        
                
            
           
            
            csession.close();
            return d;  
                    
    
    }
    }
    public void setCluster(Cluster cluster) {
            this.cluster = cluster;
        }
}
