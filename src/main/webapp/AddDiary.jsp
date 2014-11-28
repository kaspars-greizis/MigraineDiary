<%@page import="stores.LoginState"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	
		<link rel="stylesheet" type="text/css" href="style.css" />
			<title>Add Diary - Migraine Diary</title>
	</head>
	
	<body>
            
	 
		<h1>Migraine Diary</h1>
                <%LoginState lg = (LoginState) session.getAttribute("LoggedIn");%>
            
            <menu>
                <ul> 
                    <li><a href="/MigraineDiary/index.jsp" >Home</a></li>
                    <% if (lg!=null){
                        if (lg.getLoginState()) {%>
                        <li><a href="/MigraineDiary/Profile/<%=lg.getUsername()%>">View Profile</a></li>
                        <li><a href="/MigraineDiary/ViewDiary">View Diary</a></li>
                        <li><a href="/MigraineDiary/AddDiary.jsp">Add To Diary</a></li>
                        <li><a href="/MigraineDiary/Help.jsp">Help</a> </li>
                        <li><a href="/MigraineDiary/Logout">Log out</a> </li>
                    <%}}else{%>
                        <li><a href="/MigraineDiary/Login.jsp">Login</a></li>
                        <li><a href="/MigraineDiary/Login.jsp">View Diary</a></li>
                        <li><a href="/MigraineDiary/AddDiary.jsp">Add To Diary</a></li>
                        <li><a href="/MigraineDiary/Help.jsp">Help</a> </li>
                    <%}%>
                </ul>
            </menu>
		<div id="content">
			<h3>Add Event to Diary</h3>
				<p>You must be logged in to add to diary</p>
				<form method="POST" action="Diary">
					<table>
						<tr>
							<th>Start Date: </th>
							<td><input type="date" name="start"></td>
						</tr>
						<tr>
							<th>End Date: </th>
							<td><input type="date" name="end"></td>
						</tr>
						<tr>
							<th>Details: </th>
							<td><input type="text" name="description"></td>
						</tr>
						<tr>
							<th>Medication Taken: </th>
							<td><input type="text" name="medication"></td>
						</tr>
						<tr>
							<th>Trigger: </th>
							<td><input type="text" name="triggers"></td>
						</tr>
						<tr>
							<th>Severity:	 </th>
							<td><input type="number" name="severity"></td>
						</tr>
                                                <tr>    
                                                        <th>Username: </th>
                                                        <td><input type="text" name="username"></td>
                                                 </tr>
                                                 <br/>
                                                 <tr>
                                                     <td><input type="submit" value="Save"></td>
                                                 </tr>
					</table>
					<br/>
					
				</form>
			</div>
        	<footer>
            	<p>GCKK</p>
        	</footer>
	</body>
</html>