package com.group.service;

import javax.xml.ws.Endpoint;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

	public class StartPointListener extends HttpServlet {		
		 
		    public void init() throws ServletException
		    {
		    	Endpoint.publish("http://localhost:8091/services", new EmployeeService());
				System.out.println("Service published");
		    }
		}
	  
