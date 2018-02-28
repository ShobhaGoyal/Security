
package com.serviceexample;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "EmployeeSEI", targetNamespace = "http://serviceExample.com")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EmployeeSEI {


    /**
     * 
     * @param empUsernameInputParam
     * @param empPasswordInputParam
     * @return
     *     returns java.util.List<com.serviceexample.Employeebean>
     */
	
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEmployeeMethod", targetNamespace = "http://serviceExample.com", className = "com.serviceexample.GetEmployeeMethod")
    @ResponseWrapper(localName = "getEmployeeMethodResponse", targetNamespace = "http://serviceExample.com", className = "com.serviceexample.GetEmployeeMethodResponse")
    @Action(input = "http://serviceExample.com/EmployeeSEI/getEmployeeMethodRequest", output = "http://serviceExample.com/EmployeeSEI/getEmployeeMethodResponse")
    public List<Employeebean> getEmployeeMethod(
        @WebParam(name = "EmpUsernameInputParam", targetNamespace = "http://serviceExample.com")
        String empUsernameInputParam,
        @WebParam(name = "EmpPasswordInputParam", targetNamespace = "http://serviceExample.com")
        String empPasswordInputParam);

    /**
     * 
     * @param employeeTypeInputParam
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addEmployeeMethod", targetNamespace = "http://serviceExample.com", className = "com.serviceexample.AddEmployeeMethod")
    @ResponseWrapper(localName = "addEmployeeMethodResponse", targetNamespace = "http://serviceExample.com", className = "com.serviceexample.AddEmployeeMethodResponse")
    @Action(input = "http://serviceExample.com/EmployeeSEI/addEmployeeMethodRequest", output = "http://serviceExample.com/EmployeeSEI/addEmployeeMethodResponse")
    public boolean addEmployeeMethod(
        @WebParam(name = "EmployeeTypeInputParam", targetNamespace = "http://serviceExample.com")
        Employeebean employeeTypeInputParam);

}