/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2018-01-14 19:52:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.sampleEmployeeSEIProxy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.serviceexample.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.swing.*;

public final class getUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.serviceexample");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("javax.swing");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Arrays");
    _jspx_imports_classes.add("java.util.Random");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("<HEAD>\r\n");
      out.write("<TITLE>GET USER</TITLE>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n");
      out.write("      <!--Import materialize.css-->\r\n");
      out.write("      <link type=\"text/css\" rel=\"stylesheet\" href=\"css/materialize.min.css\"  media=\"screen,projection\"/>\r\n");
      out.write("\r\n");
      out.write("      <!--Let browser know website is optimized for mobile-->\r\n");
      out.write("      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("table{\r\n");
      out.write("    border: 1px solid black;\r\n");
      out.write("    border-collapse: collapse;\r\n");
      out.write("    margin-left:350px;\r\n");
      out.write("    width:50%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th, td {\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("    border-collapse: collapse;\r\n");
      out.write("    padding:7px;\r\n");
      out.write("    text-align : center;\r\n");
      out.write("}\r\n");
      out.write("form\r\n");
      out.write("{\r\n");
      out.write("   text-align: center;\r\n");
      out.write("    margin-top : 100px;\r\n");
      out.write("    margin-left: 400px;\r\n");
      out.write("    margin-right : 400px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("      <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("<form class=\"col s12\" name=\"frm\" method=\"post\" action=\"getUser.jsp\" align=\"center\">\r\n");
      out.write("\t\t<div class=\"input-field col s6\">\r\n");
      out.write("\t\t<i class=\"material-icons prefix\">account_circle</i>\r\n");
      out.write("\t\t<input type=\"text\" name=\"username\" >\r\n");
      out.write("\t\t<label for=\"icon_prefix\">Username</label>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<div class=\"input-field col s6\">\r\n");
      out.write("\t\t<i class=\"material-icons prefix\">lock</i>\r\n");
      out.write("\t\t<input type=\"password\" name=\"password\" >\r\n");
      out.write("\t\t<label for=\"icon_prefix\">Password</label>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<button class=\"btn waves-effect waves-light\" type=\"submit\" name=\"getuser\" value=\"GET_USER\">GET_USER\r\n");
      out.write("    \t\t<i class=\"material-icons right\">send</i>\r\n");
      out.write("  \t\t</button>\r\n");
      out.write("  </form>\r\n");
      out.write("\r\n");


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
    

      out.write("\r\n");
      out.write("    <br><br>\r\n");
      out.write("\t<table align=\"center\" class=\"striped\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>SNO.</th>\r\n");
      out.write("    \t<th>USERID</th>\r\n");
      out.write("    \t<th>GROUPID</th> \r\n");
      out.write("    \t<th>USERNAME</th>\r\n");
      out.write("    \t<th>PASSWORD</th>\r\n");
      out.write("    \t<th>EMAIL</th>\r\n");
      out.write("  \t</tr>\r\n");

	int sno = 1;
	for(Employeebean emp : employees)
		{

      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>");
      out.print(sno);
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(emp.getUserid());
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(emp.getGroupid());
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(emp.getUsername());
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(emp.getPassword());
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(emp.getEmail());
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
		
		sno++;
		}

      out.write("\r\n");
      out.write("\t</table>\r\n");
		
   }
 else
 {

      out.write("\r\n");
      out.write("\t<script>alert(\"No such record found\");</script>\r\n");

 }
	
}

      out.write("\r\n");
      out.write("</BODY>\r\n");
      out.write("\r\n");
      out.write("<br><br><br><br><br><br>\r\n");
      out.write("<footer>\r\n");
      out.write("<ul class=\"pagination\" align=\"center\">\r\n");
      out.write("    <li class=\"disabled\"><a href=\"#!\"><i class=\"material-icons\">chevron_left</i></a></li>\r\n");
      out.write("    <li class=\"waves-effect\"><a href=\"start.jsp\">1</a></li>\r\n");
      out.write("    <li class=\"active\"><a href=\"getUser.jsp\">2</a></li>\r\n");
      out.write("    <li class=\"disabled\"><a href=\"#!\"><i class=\"material-icons\">chevron_right</i></a></li>\r\n");
      out.write(" </ul>\r\n");
      out.write(" </footer>\r\n");
      out.write(" \r\n");
      out.write("</HTML>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
