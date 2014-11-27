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
import stores.ProfileInfo;

/**
 *
 * @author TheFractal
 */
public class ProfileModel {
    private Cluster cluster;
    private HttpSession session;
    private String username=null;
    private String first_name=null;
    private String last_name=null;
    private ProfileInfo p;
    private String dob=null;
    private String gender=null;
    private String employment=null;
    private String everyday_meds=null;
    private String known_triggers=null;
    
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
        
    }
    public ProfileInfo getProfileInfo(String username)throws ServletException, IOException{
        //HttpSession session = request.getSession();
        try ( //String first_name=HttpSession.getAttribute(login);
                Session csession = cluster.connect("migrainediary")) {
            ResultSet rs = null;
            ProfileInfo p = new ProfileInfo(username);
            PreparedStatement ps = csession.prepare("select first_name, last_name, dob, gender, employment, everyday_meds, known_triggers from migrainediary.users where username='"+username+"'"); 
            BoundStatement boundStatement = new BoundStatement(ps);
            rs = csession.execute(
                    boundStatement.bind() );
            if (rs.isExhausted()){
                System.out.println("No First Name returned");
                
            }else{
                for (Row row : rs){
                    first_name = row.getString("first_name");
                    System.out.println(first_name);  
                    last_name = row.getString("last_name");
                    dob = row.getString("dob");
                    gender = row.getString("gender");
                    employment = row.getString("employment");
                    everyday_meds = row.getString("everyday_meds");
                    known_triggers = row.getString("known_triggers");
                }
                //p.setUsername(username);
                p.setFirstname(first_name);
                System.out.println(first_name);  
                p.setLastname(last_name);
                System.out.println(last_name);
                p.setDOB(dob);
                p.setGender(gender);
                p.setEmployment(employment);
                p.setMedication(everyday_meds);
                p.setTriggers(known_triggers);
                
            }
            //p.setUser(UserName, first_name, last_name);
            //RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
            //rd.forward(request, response);
            csession.close();
            return p;
        }
    }
    public void setCluster(Cluster cluster) {
            this.cluster = cluster;
        }
}
