/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import com.datastax.driver.core.Cluster;
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
import models.User;
import stores.LoginState;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Login", urlPatterns = {
    "/Login",
    "/Logout"
})
public class Login extends HttpServlet {

    Cluster cluster=null;


    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        
        User us=new User();
        us.setCluster(cluster);
        boolean isValid=us.IsValidUser(username, password);
        HttpSession session=request.getSession();
        System.out.println("Session in servlet "+session);
        if (isValid){
            LoginState lg= new LoginState();
            lg.setLoginState(true);
            lg.setUsername(username);
            //request.setAttribute("LoggedIn", lg);
            
            session.setAttribute("LoggedIn", lg);
            //session.setAttribute("login", request.getParameter("username"));
            System.out.println("Session in servlet "+session);
            System.out.println("Logged in");
            RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
	    rd.forward(request,response);
            
        }else{
            response.sendRedirect("/Login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        LoginState lg = (LoginState) session.getAttribute("LoggedIn");
        lg.setLoginState(false);
        lg.setUsername("visitor");
        request.setAttribute("LoggedIn", lg);
        String message = "You have successfully logged out! It was nice having you here.";
        request.setAttribute("message", message);
        System.out.println("TESTTING");
        session.invalidate();
        RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
        rd.forward(request, response);
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
