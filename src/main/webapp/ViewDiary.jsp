
<%@page import="stores.DiaryInfo"%>
<%@page import="stores.LoginState"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	
		<link rel="stylesheet" type="text/css" href="style.css" />
			<title>View Diary - Migraine Diary</title>
	</head>
	
	<body>
            <menu>
			<ul> 
				<li><a href="index.jsp" >Home</a></li>
				<li><a href="ViewProfile.jsp">View Profile</a></li>
				<li><a href="ViewDiary.jsp">View Diary</a></li>
				<li><a href="AddDiary.jsp">Add To Diary</a></li>
				<li><a href="Help.jsp">Help</a> </li>
			</ul>
    	</menu>
        
             <%LoginState lg = (LoginState) session.getAttribute("LoggedIn");%> 
	    <% String [] test = (String []) session.getAttribute("DiaryInfo");%>
		<h1>Migraine Diary</h1>
		<div id="content">
			<h3>Your Diary</h3>
				<p>Username: <%=lg.getUsername()%> </p>
                                
                             <% 
                                for(int i=0; i<test.length; i++){ %>
                                <p><b><ins> Entry <%=i %></ins></b></p>
                                <p> Description: <%=test[i]%> </p>
                             <p>Start <%=test[i+1]%> </p>
				<p>End <%=test[i+2] %> </p>
				<p>Severity <%=test[i+3]%></p>
				<p>Medicine <%=test[i+4] %> </p>
				<p>Trigger: <%=test[i+5] %></p>           
                                <% i=i+4;
                                } %>
		</div>
		<footer>
			<p>GCKK</p>
		</footer>
	</body>
</html>
