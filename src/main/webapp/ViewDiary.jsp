<%@page import="com.datastax.driver.core.ResultSet"%>
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
              <%DiaryInfo dInfo = (DiaryInfo) request.getAttribute("DiaryInfo");%>
			<ul> 
				<li><a href="index.jsp" >Home</a></li>
				<li><a href="ViewProfile.jsp">View Profile</a></li>
				<li><a href="ViewDiary.jsp">View Diary</a></li>
				<li><a href="AddDiary.jsp">Add To Diary</a></li>
				<li><a href="Help.jsp">Help</a> </li>
			</ul>
    	</menu>
	 
		<h1>Migraine Diary</h1>
		<div id="content">
			<h3>Your Diary</h3>
				<p>Username: <%=dInfo.getDescription()%></p>
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
