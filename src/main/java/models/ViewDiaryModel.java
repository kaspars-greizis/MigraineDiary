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
    private String description [] = new String[5];
    private String start [];
    private String end [];
    private int severity [] ;
    private String medication [];
    private String triggers [] ;
    private String test [];
    private String severityString[];
    
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
        
    }
    @SuppressWarnings("empty-statement")
    public String[] getDiaryInfo(String username)throws ServletException, IOException{
        
         
         
         try ( 
            Session csession = cluster.connect("migrainediary")) {
            ResultSet rs = null;
            ResultSet rs1 = null;
            DiaryInfo d = new DiaryInfo(username);
             int i=0;
             int entries=0;
             int current=0;
             
              
             
        
            PreparedStatement ps = csession.prepare("select * from migrainediary.diary where username='"+username+"'"); 
            PreparedStatement ps1 = csession.prepare("Select Count(*) from diary where username='"+username+"'"); 
            BoundStatement boundStatement = new BoundStatement(ps);
            rs = csession.execute(
                    boundStatement.bind() );
            BoundStatement boundStatement1 = new BoundStatement(ps1);
            rs1 = csession.execute(
                    boundStatement1.bind() );
            if (rs1.isExhausted()){
                System.out.println("No First Name returned");
                
            }else{
                        for (Row row : rs1){
                        long diaryId1 = row.getLong("count");
                          entries = (int) diaryId1; 
            }
            }
                
              description = new String[entries];
              triggers = new String[entries];
              medication = new String[entries];
              start = new String[entries];
              end = new String[entries];
              severity = new int[entries];
              severityString= new String[entries];
              test = new String[(entries*6)];
              
            if (rs.isExhausted()){
                System.out.println("No First Name returned");
                
            }else{
                
                
                for (Row row : rs){
                       System.out.print("i:   ");
                      System.out.println(i);
                    
                    description[i] = row.getString("description");
                    start[i] = row.getString("start");
                    end[i] = row.getString("end");
                    severity[i] = row.getInt("severity");
                    medication[i] = row.getString("medication");
                    triggers[i] = row.getString("triggers");
                    severityString[i] = Integer.toString(severity[i]);
                    
                    
                      i++;
                   
                } 
            }
                
                
		   for(int r=0; r<entries; r++){
                      System.out.println(r);
                        test[(r*5)+(r*1)]= description[r];
                        test[(r*5)+(r*1)+1]= start[r];
                        test[(r*5)+(r*1)+2]= end[r];
                        test[(r*5)+(r*1)+3]= severityString[r];
                        test[(r*5)+(r*1)+4]= triggers[r];
                        test[(r*5)+(r*1) +5]= medication[r];
                }
             
             
            csession.close();
            return test;  
                    
    
            }
         }
    
    
    public void setCluster(Cluster cluster) {
            this.cluster = cluster;
        }
}
