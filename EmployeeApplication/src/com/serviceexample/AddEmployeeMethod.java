
package com.serviceexample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addEmployeeMethod complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addEmployeeMethod">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EmployeeTypeInputParam" type="{http://serviceExample.com}employeebean" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addEmployeeMethod", propOrder = {
    "employeeTypeInputParam"
})
public class AddEmployeeMethod {

    @XmlElement(name = "EmployeeTypeInputParam", namespace = "http://serviceExample.com")
    protected Employeebean employeeTypeInputParam;

    /**
     * Gets the value of the employeeTypeInputParam property.
     * 
     * @return
     *     possible object is
     *     {@link Employeebean }
     *     
     */
    public Employeebean getEmployeeTypeInputParam() {
        return employeeTypeInputParam;
    }

    /**
     * Sets the value of the employeeTypeInputParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link Employeebean }
     *     
     */
    public void setEmployeeTypeInputParam(Employeebean value) {
        this.employeeTypeInputParam = value;
    }

}
