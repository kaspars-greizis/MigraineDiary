/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import com.datastax.driver.core.Cluster;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lib.CassandraHosts;
import models.DiaryModel;

/**
 *
 * @author garethlloyd
 */
@WebServlet(name = "Diary", urlPatterns = {"/Diary"})
public class Diary extends HttpServlet {

  Cluster cluster = null;
        @Override
	public void init(ServletConfig config) throws ServletException
	{
		cluster = CassandraHosts.getCluster();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String start = request.getParameter("start");
		String  end = request.getParameter("end");
		String details = request.getParameter("description");
		String medication = request.getParameter("medication");
		String triggers = request.getParameter("triggers");
		String severity = request.getParameter("severity");
		String user = request.getParameter("username");  
               
 
	       int severity1= Integer.parseInt(severity);
                DiaryModel diary = new DiaryModel();
		diary.setCluster(cluster);
		diary.addDiary(user, start, end, details, medication, triggers, severity1);
		response.sendRedirect("/MigraineDiary/Login.jsp");
	}

   
}
