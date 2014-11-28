/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import com.datastax.driver.core.Cluster;
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
import models.ViewDiaryModel;
import stores.DiaryInfo;
import stores.LoginState;

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
        cluster = CassandraHosts.getCluster();        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/ViewDiary.jsp");
        LoginState lg = (LoginState) session.getAttribute("LoggedIn");
        if (lg != null) {
            if (lg.getLoginState()) {
            user = lg.getUsername();
            System.out.println("Username: "+user);
            }}else{
            System.out.println("No user found");
        }
        try {            
            dmodel = new ViewDiaryModel();
            dmodel.setCluster(cluster);
            displayDiary(user, request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        } finally {
        }
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
