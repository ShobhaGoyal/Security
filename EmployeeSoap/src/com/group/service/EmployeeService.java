package com.group.service;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import javax.jws.HandlerChain;
import javax.jws.WebService;

import com.group.bean.Employeebean;

import javax.jws.HandlerChain;

@HandlerChain(file = "com/group/service/handler-chain.xml")

@WebService(endpointInterface = "com.group.service.EmployeeSEI",serviceName = "EmployeeService",portName="EmployeePort",targetNamespace="http://serviceExample.com")
public class EmployeeService implements EmployeeSEI {

	private Connection con;
	private Statement stmt;
	
	private void setConnection()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/information","root","123");
			stmt = con.createStatement();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Override
	public boolean addEmployee(Employeebean emp) {
		// TODO Auto-generated method stub
		if(emp==null)
		{
			return false;
		}
		String query = "";
		try{
			String username = emp.getUsername();
			String password = emp.getPassword();
			//int userid = emp.getUserid();
			int groupid = emp.getGroupid();
			String email = emp.getEmail();
			
			setConnection();
			
			query = "select * from employee where username='"+username+"';";
			
		    
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next())
			{ // user already present
				con.close();
				return false;
			}
			
			query = "insert into employee(groupid,username,password,email) values("+groupid+",'"+username+"','"+password+"','"+email+"');";
			stmt.executeUpdate(query);
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(query+"    "+e);
			return false;
		}

		return true;
	}

	@Override
	public List<Employeebean> getEmployee(String username, String password) {
		
		List<Employeebean> employees = new ArrayList<Employeebean>();
        String query = "";
		try{
			
			setConnection();
			
			query = "select * from employee where username = '"+username+"' and password = '"+password+"';";
			ResultSet rs=stmt.executeQuery(query);  
			
			while(rs.next())  
			{				
				Employeebean emp = new Employeebean();
				
				emp.setUsername(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
				emp.setUserid(rs.getInt(1));
				emp.setGroupid(rs.getInt(2));
				emp.setEmail(rs.getString("email"));
				employees.add(emp);
			}
			con.close();  
			}
		   catch(Exception e){ System.out.println(query + "\n" +e);}  
		
		if(employees.isEmpty())
			return null;
		else
			return employees;
	}
}
