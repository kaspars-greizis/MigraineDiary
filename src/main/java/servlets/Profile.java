/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lib.CassandraHosts;
import lib.Convertors;
import models.ProfileModel;
import stores.LoginState;
import stores.ProfileInfo;

/**
 *
 * @author TheFractal
 */
@WebServlet(name="Profile", urlPatterns = {"/Profile/*"})
//@WebServlet
public class Profile extends HttpServlet {
    private Cluster cluster;
    private HttpSession session;
    private String UserName="";
    private String first_name="null";
    private String last_name="null";
    private ProfileInfo p;
    private ProfileModel pmodel;
    
    public Profile(){
        super();
    }
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //UserProfile p = new UserProfile();
        /////New
        //ProfileModel pmodel = new ProfileModel();
        String value;
        System.out.println("test");
        RequestDispatcher rd = request.getRequestDispatcher("/ViewProfile.jsp");
        session=request.getSession();
        
        //UserName = (String) session.getAttribute("username");
        LoginState lg = (LoginState) session.getAttribute("LoggedIn");
        if (lg != null) {
            if (lg.getLoginState()) {
            UserName = lg.getUsername();
            System.out.println("Username: "+UserName);
            }}else{
            System.out.println("No user found");
        }
        //String args[] = Convertors.SplitRequestPath(request);
        try {
            
            pmodel = new ProfileModel();
            pmodel.setCluster(cluster);
            //displayProfile(username, request, response);
                    displayProfile(UserName, request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        } finally {
            //cluster.close();
        }
    }
    
    private void displayProfile(String username, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Display Profile information for "+username);
        RequestDispatcher rd = null;
        ProfileInfo proInfo = pmodel.getProfileInfo(username);
        rd = request.getRequestDispatcher("/ViewProfile.jsp");
        request.setAttribute("ProfileInfo", proInfo);

        rd.forward(request, response);
    }

}

