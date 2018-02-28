package com.group.service;

import javax.xml.ws.Endpoint;

public class EmployeePublisher {
        
	public static void main(String args[])
	{   
		Endpoint.publish("http://localhost:8091/services", new EmployeeService());
		System.out.println("Service published");
	}   
}    
