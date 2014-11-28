<%@page import="stores.LoginState"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Register - Migraine Diary Login</title>
		<link rel="stylesheet" type="text/css" href="style.css" />
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
			
			<p>* required field.</p>
			<form method="POST" action="Register">
				<table>
					<tr>
						<th>Username: </th>
						<td><input type="text" name="username"> *</td>
					</tr>
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
						<th>Gender: </th>
						<td><input type="radio" name="gender" value="female">Female
						<input type="radio" name="gender" value="male">Male *</td>
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
                                        <br>
                                            <td><input type="submit" value="Register"></td>
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