package com.serviceexample;

import java.util.List;
import java.util.Random;

import javax.xml.ws.handler.Handler; 
import javax.xml.ws.Binding; 
import javax.xml.ws.BindingProvider; 

public class clientmain {

	public static void main(String[] args) {
		
		
		String username = "akash";
		String password = "goyal";
		String email = "akash";

		Random rand = new Random();
		int groupid = rand.nextInt(101) + 1;
					
		Employeebean emp = new Employeebean();
		emp.setUsername(username);
		emp.setPassword(password);
		emp.setEmail(email);
		emp.setGroupid(groupid);
        System.out.println("before");
        
        EmployeeService empservice = new EmployeeService();
        EmployeeSEI port = empservice.getEmployeePort();
        System.out.println(port.addEmployeeMethod(emp));
		//String endpoint = "http://localhost:8091/services";
		

	}
	
}
