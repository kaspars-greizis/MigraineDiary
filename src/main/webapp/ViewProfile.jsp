<%@page import="stores.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>	
            <link rel="stylesheet" type="text/css" href="/MigraineDiary/style.css" />
            <title>View Profile - Migraine Diary</title>
	</head>
	
	<body>
            <%ProfileInfo pInfo = (ProfileInfo) request.getAttribute("ProfileInfo");%>
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
			<h3>Your Profile</h3>
			<p>Here is your profile, you can change and add by clicking edit.</p>
			<p>Username: <%=pInfo.getUsername()%></p>
			<p>Name: <%=pInfo.getFirstname()%> <%=pInfo.getLastname()%></p>
			<p>Date of Birth: <%=pInfo.getDOB()%></p>
                        <p>Gender: <%=pInfo.getGender()%></p>
			<p>Current Medications: <%=pInfo.getMedication()%></p>
			<p>Triggers: <%=pInfo.getTriggers()%></p>
                        <p><a href="/MigraineDiary/EditProfile.jsp">Edit</a></p>
		</div>
		<footer>
			<p>GCKK</p>
		</footer>
	</body>
</html>