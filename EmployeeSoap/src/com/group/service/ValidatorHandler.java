package com.group.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

//import javax.wsdl.extensions.soap12.SOAP12Fault;
import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import com.sun.org.apache.xpath.internal.axes.ChildIterator;

public class ValidatorHandler implements SOAPHandler<SOAPMessageContext>{

	@Override
	public void close(MessageContext context) {
		System.out.println("closing at server side");
	}

	@Override
	public Set getHeaders() {
		System.out.println("Getting headers at server side");

		return null;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
	
		
		System.out.println("Handling message at server side ");
		//MESSAGE_OUTBOUND_PROPERTY is true for outbound messages and false for inbound messages
		//incoming messages(inbound) are validated at server side and client manipulates soap requests and send
		// to server so outgoing messages(outbound)
		
		Boolean isRequest = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		
		// for incoming messages
		if(!isRequest)
		{			
			try {
				SOAPMessage soapmsg = context.getMessage();
				/*SOAPEnvelope soapenv = soapmsg.getSOAPPart().getEnvelope();
				SOAPHeader soapheader = soapenv.getHeader();
				
				
				if(soapheader == null)
				{
					generateSOAPErrMessage(soapmsg,"no header found");
				}
				
				Iterator<SOAPHeaderElement> headersIt = soapheader.examineAllHeaderElements();
			       // I know there is only one header element
			       SOAPHeaderElement headerElement = headersIt.next();
			       
			       if(headerElement == null)
			       {
						generateSOAPErrMessage(soapmsg,"no header element found");
			    	}
			       else
			       {
			    	   java.util.Iterator i = headerElement.getChildElements();
			    	   if(!i.hasNext())
			    	   {
							generateSOAPErrMessage(soapmsg,"no username found");

			    	   }
			    	   SOAPElement e = (SOAPElement)i.next();
			    	   if(e.getValue()==null)
			    	   {
			    		   generateSOAPErrMessage(soapmsg,"username is null");
			    	   }
	                    String username = e.getValue();
	                    	
	                    if(!i.hasNext())
				    	   {
	    					generateSOAPErrMessage(soapmsg,"no password found");

				    	   }
	                    e = (SOAPElement)i.next();
	                    
	                    if(e.getValue()==null)
			    		{
	                    	generateSOAPErrMessage(soapmsg,"password is null");
			    		}
	                    
	                    String password = e.getValue();	                    
	                    System.out.println(username.equals("shobha"));
	                    if(!(username.equals("shobha") && password.equals("goyal")))
	                    {
	    					generateSOAPErrMessage(soapmsg,"Authentication problem: Invalid Credentials");
	                    }
			       }
			
				soapmsg.saveChanges();*/
				soapmsg.writeTo(System.out);
				System.out.println(soapmsg);
				
			} catch (SOAPException e) {				
				e.printStackTrace();
			} 
			catch (IOException e) {				
				e.printStackTrace();
			}
		}

		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("Handling faults at server side");
		return true;
	}

	private void generateSOAPErrMessage(SOAPMessage msg, String reason) {
	       try {
	          SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
	          SOAPFault soapFault = soapBody.addFault();
	          soapFault.setFaultString(reason);
	          throw new SOAPFaultException(soapFault);
	       }
	       catch(SOAPException e) { }
	    }

	
}
