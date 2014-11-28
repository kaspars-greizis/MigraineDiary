<%@page import="java.lang.String"%>
<%@page import="stores.LoginState"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Migraine Diary</title>
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
                        <li><a href="/MigraineDiary/ViewDiary.jsp">View Diary</a></li>
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
            <h3>Welcome!</h3>
            <p>Create a migraine diary to track your migraines, medication and triggers to better manage how you cope with your migraines. </p>
            
            <p>Did you know: Some random fact about migraines I haven&rsquo;t looked for yet.</p>
            <p>
            <%if(lg==null){%>
            <a href="/MigraineDiary/Login.jsp">Login</a>
            <a href="Register.jsp">Not Registered?</a>
            <%}%>
            </p>
        </div>
        <footer>
            <p>GCKK</p>
	</footer>	
    </body>
</html>