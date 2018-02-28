package com.group.service;
import java.util.List;

import com.group.bean.Employeebean;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(name = "EmployeeSEI", targetNamespace="http://serviceExample.com")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL,parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)

public interface EmployeeSEI {
	
	@WebMethod(operationName = "addEmployeeMethod")
	public boolean addEmployee(@WebParam(name="EmployeeTypeInputParam",
	           targetNamespace="http://serviceExample.com")Employeebean emp);
	
	@WebMethod(operationName="getEmployeeMethod")
	public List<Employeebean> getEmployee(@WebParam(name="EmpUsernameInputParam",
	           targetNamespace="http://serviceExample.com")String username,@WebParam(name="EmpPasswordInputParam",
	           targetNamespace="http://serviceExample.com")String password);
}
