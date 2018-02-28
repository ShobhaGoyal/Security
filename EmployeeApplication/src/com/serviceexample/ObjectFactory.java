
package com.serviceexample;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.serviceexample package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddEmployeeMethodResponse_QNAME = new QName("http://serviceExample.com", "addEmployeeMethodResponse");
    private final static QName _GetEmployeeMethodResponse_QNAME = new QName("http://serviceExample.com", "getEmployeeMethodResponse");
    private final static QName _AddEmployeeMethod_QNAME = new QName("http://serviceExample.com", "addEmployeeMethod");
    private final static QName _GetEmployeeMethod_QNAME = new QName("http://serviceExample.com", "getEmployeeMethod");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.serviceexample
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEmployeeMethod }
     * 
     */
    public GetEmployeeMethod createGetEmployeeMethod() {
        return new GetEmployeeMethod();
    }

    /**
     * Create an instance of {@link AddEmployeeMethod }
     * 
     */
    public AddEmployeeMethod createAddEmployeeMethod() {
        return new AddEmployeeMethod();
    }

    /**
     * Create an instance of {@link GetEmployeeMethodResponse }
     * 
     */
    public GetEmployeeMethodResponse createGetEmployeeMethodResponse() {
        return new GetEmployeeMethodResponse();
    }

    /**
     * Create an instance of {@link AddEmployeeMethodResponse }
     * 
     */
    public AddEmployeeMethodResponse createAddEmployeeMethodResponse() {
        return new AddEmployeeMethodResponse();
    }

    /**
     * Create an instance of {@link Employeebean }
     * 
     */
    public Employeebean createEmployeebean() {
        return new Employeebean();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmployeeMethodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceExample.com", name = "addEmployeeMethodResponse")
    public JAXBElement<AddEmployeeMethodResponse> createAddEmployeeMethodResponse(AddEmployeeMethodResponse value) {
        return new JAXBElement<AddEmployeeMethodResponse>(_AddEmployeeMethodResponse_QNAME, AddEmployeeMethodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeeMethodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceExample.com", name = "getEmployeeMethodResponse")
    public JAXBElement<GetEmployeeMethodResponse> createGetEmployeeMethodResponse(GetEmployeeMethodResponse value) {
        return new JAXBElement<GetEmployeeMethodResponse>(_GetEmployeeMethodResponse_QNAME, GetEmployeeMethodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmployeeMethod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceExample.com", name = "addEmployeeMethod")
    public JAXBElement<AddEmployeeMethod> createAddEmployeeMethod(AddEmployeeMethod value) {
        return new JAXBElement<AddEmployeeMethod>(_AddEmployeeMethod_QNAME, AddEmployeeMethod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeeMethod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceExample.com", name = "getEmployeeMethod")
    public JAXBElement<GetEmployeeMethod> createGetEmployeeMethod(GetEmployeeMethod value) {
        return new JAXBElement<GetEmployeeMethod>(_GetEmployeeMethod_QNAME, GetEmployeeMethod.class, null, value);
    }

}
