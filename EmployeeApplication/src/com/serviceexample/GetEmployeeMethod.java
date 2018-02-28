
package com.serviceexample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getEmployeeMethod complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getEmployeeMethod">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EmpUsernameInputParam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="EmpPasswordInputParam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEmployeeMethod", propOrder = {
    "empUsernameInputParam",
    "empPasswordInputParam"
})
public class GetEmployeeMethod {

    @XmlElement(name = "EmpUsernameInputParam", namespace = "http://serviceExample.com")
    protected String empUsernameInputParam;
    @XmlElement(name = "EmpPasswordInputParam", namespace = "http://serviceExample.com")
    protected String empPasswordInputParam;

    /**
     * Gets the value of the empUsernameInputParam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpUsernameInputParam() {
        return empUsernameInputParam;
    }

    /**
     * Sets the value of the empUsernameInputParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpUsernameInputParam(String value) {
        this.empUsernameInputParam = value;
    }

    /**
     * Gets the value of the empPasswordInputParam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpPasswordInputParam() {
        return empPasswordInputParam;
    }

    /**
     * Sets the value of the empPasswordInputParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpPasswordInputParam(String value) {
        this.empPasswordInputParam = value;
    }

}
