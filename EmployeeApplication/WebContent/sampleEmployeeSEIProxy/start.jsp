<%@page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.serviceexample.*" %>
<%@ page import="java.util.Random" %>
<HTML>
<HEAD>
<TITLE>Index</TITLE>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
 <style type="text/css">
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
    

<form class="col s12" name="frm" method="post" action="start.jsp" align="center">
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
		<div class="input-field col s6">
		<i class="material-icons prefix">mail</i>
		<input type="text" name="email" >
		<label for="icon_prefix">E-mail</label>
		</div>
		<br>
		<br>
		 <button class="btn waves-effect waves-light" type="submit" name="add" value="ADD">ADD
    <i class="material-icons right">send</i>
  </button>
		</form>


<%

String button = request.getParameter("add");
if(button!=null)
{
String username = request.getParameter("username");
String password = request.getParameter("password");
String email = request.getParameter("email");

Random rand = new Random();
int groupid = rand.nextInt(101) + 1;
			
Employeebean emp = new Employeebean();
emp.setUsername(username);
emp.setPassword(password);
emp.setEmail(email);
emp.setGroupid(groupid);
System.out.println(emp.getUsername());
EmployeeService empservice = new EmployeeService();
EmployeeSEI port = empservice.getEmployeePort();
boolean returnvalue;

	returnvalue = port.addEmployeeMethod(emp);
	if(returnvalue == true)
	{
%>
		<script>alert("Entry is added successfully");</script>
<%		
	}
	else
	{
%>
		<script>alert("Username already exists. Try different username.");</script>
<%
	}
}
%>

</BODY>
<br><br><br>
<footer>
<ul class="pagination" align="center">
    <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
    <li class="active"><a href="start.jsp">1</a></li>
    <li class="waves-effect"><a href="getUser.jsp">2</a></li>
    <li class="disabled"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
 </ul>
 </footer>

</HTML>