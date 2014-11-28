/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lib.CassandraHosts;
import models.DiaryModel;
import models.ProfileModel;
import models.ViewDiaryModel;
import stores.DiaryInfo;
import stores.LoginState;
import stores.ProfileInfo;

/**
 *
 * @author garethlloyd
 */
@WebServlet(name = "ViewDiary", urlPatterns = {"/ViewDiary"})
public class ViewDiary extends HttpServlet {
    private Cluster cluster;
    private HttpSession session;
    private String description="";
    private String start="null";
    private String end="null";
    private int severity=0;
    private String medication="null";
    private String triggers="null";
    private String user="null";
    private DiaryInfo d;
    private ViewDiaryModel dmodel;
    
    public ViewDiary(){
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
        RequestDispatcher rd = request.getRequestDispatcher("/ViewDiary.jsp");
        session=request.getSession();
        
        //UserName = (String) session.getAttribute("username");
        LoginState lg = (LoginState) session.getAttribute("LoggedIn");
        if (lg != null) {
            if (lg.getLoginState()) {
            user = lg.getUsername();
            System.out.println("Username: "+user);
            }}else{
            System.out.println("No user found");
        }
        //String args[] = Convertors.SplitRequestPath(request);
        try {
            
            dmodel = new ViewDiaryModel();
            dmodel.setCluster(cluster);
            //displayProfile(username, request, response);
                    displayDiary(user, request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        } finally {
            //cluster.close();
        }
//        LoginState lg = (LoginState) session.getAttribute("LoggedIn");
//                        if (lg != null) {  
//                            if (lg.getLoginState()) {
//                                UserName = lg.getUsername();
//                                value = "success";
//                                //session.setAttribute("login", value);
//                                //session.setAttribute("username", p.getFirstName());
//                                System.out.println(value);
//                                pmodel.getProfileInfo(UserName);
//                            }else{
//                                value="fail: could not log in";
//                                session.setAttribute("login", value);
//                                System.out.println(value);
//                            }
//                        }else{
//                            value="fail: lg=null";
//                            session.setAttribute("login", value);
//                            System.out.println(value);
//                        }        
        ///Original down from here
        
        //rd.forward(request, response);
    }
    
    private void displayDiary (String user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Display Profile information for "+user);
        RequestDispatcher rd = null;
        DiaryInfo dInfo = dmodel.getDiaryInfo(user);
        
        rd = request.getRequestDispatcher("/ViewDiary.jsp");
        request.setAttribute("DiaryInfo", dInfo);

        rd.forward(request, response);
    }
}
