<%@page import="stores.LoginState"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	
		<link rel="stylesheet" type="text/css" href="style.css" />
			<title>Edit Profile - Migraine Diary</title>
	</head>
	
	<body>
            <%LoginState lg = (LoginState) session.getAttribute("LoggedIn");%>
            <h1>Migraine Diary</h1>
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
			<<h3>Edit Profile</h3>
			<p>Here you can change your details, click Save to store any changes.</p>
			<form method="POST" action="Update">
                            <input type="hidden" name="username" value="<%=lg.getUsername()%>">
				<table>                                        
					<tr>
						<th>Password: </th>
						<td><input type="password" name="password"> *</td>
					</tr>
					<tr>
						<th>First Name: </th>
						<td><input type="text" name="first_name"> *</td>
					</tr>
					<tr>
						<th>Last Name: </th>
						<td><input type="text" name="last_name"> *</td>
					</tr>
					<tr>
						<th>DOB: </th>
						<td><input type="date" name="dob"> *</td>
					</tr>
					<tr>
						<th>Employment: </th>
						<td><input type="text" name="employment"> *</td>
					</tr>
					<tr>
						<th>Everyday Medication: </th>
						<td><input type="text" name="everyday_meds"> *</td>
					</tr>
					<tr>
						<th>Known Triggers: </th>
						<td><input type="text" name="known_triggers"> *</td>
					</tr>
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