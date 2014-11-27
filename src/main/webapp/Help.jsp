<%@page import="stores.LoginState"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	
		<link rel="stylesheet" type="text/css" href="style.css" />
			<title>Help - Migraine Diary</title>
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
				<h3>Help</h3>
				<p>Here is some extra information and support.</p>
				<p>Migraines are a disabling neurological condition affecting around 8 million people in the UK alone, migraines and headaches are estimated to be costing the UK economy &pound;2.25 billion a year. The definition of migraine:</p>
				<p>&quot;A recurrent throbbing headache that typically affects one side of the head and is often accompanied by nausea and disturbed vision&quot;.</p>
				<p>Migraines are different with every sufferer and are often inherited via genetics. Often migraineurs have to change lifestyles, stick to routines or take medication in order to keep migraines in check.Treatment and diagnosis for migraines can be a lengthy process and can even take years, due to long waiting times to see certain specialists. During the diagnosis and treatment period patients are often told to keep âheadache diariesâ, many of these can be found online as well as paper based. Doctors analyse these to see certain trigger for migraines ie. lights, foods or even hormones and try to tailor medication to suit the patient.</p>
			</div>
			<footer>
				<p>GCKK &nbsp; 	&nbsp; 	&nbsp; 	&nbsp; 	&nbsp;http://www.migrainetrust.org&nbsp; 	&nbsp; 	&nbsp; 	&nbsp; 	&nbsp;https://ouchuk.org</p>
			</footer>
	</body>
</html>