package servlets;

//import java.util.Date;
//import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lib.CassandraHosts;
import models.User;

@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet
{
	Cluster cluster = null;
        @Override
	public void init(ServletConfig config) throws ServletException
	{
		cluster = CassandraHosts.getCluster();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String employment = request.getParameter("employment");
		String everyday_meds = request.getParameter("everyday_meds");
		String known_triggers = request.getParameter("known_triggers");
		
		User user = new User();
		user.setCluster(cluster);
		user.RegisterUser(username, password, first_name, last_name, dob, gender, employment, everyday_meds, known_triggers, true);
		response.sendRedirect("/MigraineDiary/Login.jsp");
	}
}