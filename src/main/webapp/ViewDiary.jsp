<%@page import="stores.LoginState"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	
		<link rel="stylesheet" type="text/css" href="style.css" />
			<title>View Diary - Migraine Diary</title>
	</head>
	
	<body>
            <%LoginState lg = (LoginState) session.getAttribute("LoggedIn");%> 
            <menu>
                <ul> 
                    <li><a href="/MigraineDiary/index.jsp" >Home</a></li>
                    <% if (lg!=null){
                        if (lg.getLoginState()) {%>
                        <li><a href="/MigraineDiary/Profile/<%=lg.getUsername()%>">View Profile</a></li>
                        <li><a href="/MigraineDiary/ViewDiary.jsp">View Diary</a></li>
                    <%}}else{%>
                        <li><a href="/MigraineDiary/Login.jsp">Login</a></li>
                        <li><a href="/MigraineDiary/Login.jsp">View Diary</a></li>
                    <%}%>
                    
                    <li><a href="/MigraineDiary/AddDiary.jsp">Add To Diary</a></li>
                    <li><a href="/MigraineDiary/Help.jsp">Help</a> </li>
                </ul>
            </menu>
	 
		<h1>Migraine Diary</h1>
		<div id="content">
			<h3>Your Diary</h3>
				<p>Here is a breakdown of your statistics.</p>
				<p>Most Common Trigger: </p>
				<p>Pain Killer Most Effective: </p>
				<p>Average Migraines per Month: </p>
				<p>Last Migraine: </p>
				<p>Trigger: </p>
		</div>
		<footer>
			<p>GCKK</p>
		</footer>
	</body>
</html>