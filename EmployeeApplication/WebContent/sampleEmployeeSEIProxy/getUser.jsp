<%@page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.serviceexample.*" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="javax.swing.*" %>
<HTML>
<HEAD>
<TITLE>GET USER</TITLE>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

<style type="text/css">

table{
    border: 1px solid black;
    border-collapse: collapse;
    margin-left:350px;
    width:50%;
}

th, td {
	border: 1px solid black;
    border-collapse: collapse;
    padding:7px;
    text-align : center;
}
form
{
   text-align: center;
    margin-top : 100px;
    margin-left: 400px;
    margin-right : 400px;
}
</style>
</HEAD>
<BODY>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
    
    
<form class="col s12" name="frm" method="post" action="getUser.jsp" align="center">
		<div class="input-field col s6">
		<i class="material-icons prefix">account_circle</i>
		<input type="text" name="username" >
		<label for="icon_prefix">Username</label>
		</div>
		<br>
		<div class="input-field col s6">
		<i class="material-icons prefix">lock</i>
		<input type="password" name="password" >
		<label for="icon_prefix">Password</label>
		</div>
		<br>
		<button class="btn waves-effect waves-light" type="submit" name="getuser" value="GET_USER">GET_USER
    		<i class="material-icons right">send</i>
  		</button>
  </form>

<%

String button = request.getParameter("getuser");
if(button!=null)
{
String username = request.getParameter("username");
String password = request.getParameter("password");
System.out.println(username+password);
EmployeeService empservice = new EmployeeService();
EmployeeSEI port = empservice.getEmployeePort();


ArrayList<Employeebean> employees = new ArrayList<Employeebean>(port.getEmployeeMethod(username,password));
	
if(!employees.isEmpty())	
  {
    
%>
    <br><br>
	<table align="center" class="striped">
	<tr>
		<th>SNO.</th>
    	<th>USERID</th>
    	<th>GROUPID</th> 
    	<th>USERNAME</th>
    	<th>PASSWORD</th>
    	<th>EMAIL</th>
  	</tr>
<%
	int sno = 1;
	for(Employeebean emp : employees)
		{
%>
		<tr>
			<td><%=sno%></td>
			<td><%=emp.getUserid()%></td>
			<td><%=emp.getGroupid()%></td>
			<td><%=emp.getUsername()%></td>
			<td><%=emp.getPassword()%></td>
			<td><%=emp.getEmail()%></td>
		</tr>
<%		
		sno++;
		}
%>
	</table>
<%		
   }
 else
 {
%>
	<script>alert("No such record found");</script>
<%
 }
	
}
%>
</BODY>

<br><br><br><br><br><br>
<footer>
<ul class="pagination" align="center">
    <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
    <li class="waves-effect"><a href="start.jsp">1</a></li>
    <li class="active"><a href="getUser.jsp">2</a></li>
    <li class="disabled"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
 </ul>
 </footer>
 
</HTML>