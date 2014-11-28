<%@page import="stores.LoginState"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login - Migraine DiaryLogin</title>
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
                    
            <div id="login">		
                <form method="POST"  action="Login">                    
                <table>
                    
                    <tr>
                	<th>Username: </th>
                	<td><input type="text" name="username"></td>
                    </tr>
                    <tr>
                	<th>Password: </th>
                	<td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <th><input type="submit" value="Login"></th>
                        <td><a href="Register.jsp">Not Registered?</a></td>
                    </tr>
                </table>  
                </form>                
            </div>                    
            <footer>
                <p>GCKK</p>
            </footer>		
	</body>
</html>