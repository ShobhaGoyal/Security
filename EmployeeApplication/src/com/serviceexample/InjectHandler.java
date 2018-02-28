package com.serviceexample;


import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Set;
























//import javax.wsdl.extensions.soap12.SOAP12Fault;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.commons.lang3.StringEscapeUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xpath.internal.axes.ChildIterator;

public class InjectHandler implements SOAPHandler<SOAPMessageContext>{

	@Override
	public void close(MessageContext context) {
		System.out.println("closing at client side");
	}

	@Override
	public Set getHeaders() {
		System.out.println("Getting headers at client side");

		return null;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
	
		
		System.out.println("Handling message at client side ");
		//MESSAGE_OUTBOUND_PROPERTY is true for outbound messages and false for inbound messages
		//incoming messages(inbound) are validated at server side and client manipulates soap requests and send
		// to server so outgoing messages(outbound)
		
		Boolean isRequest = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		
		// for outgoing messages
		if(isRequest)
		{			
			try {
				SOAPMessage soapmsg = context.getMessage();
					
				Source src = soapmsg.getSOAPPart().getContent();
				TransformerFactory tf = TransformerFactory.newInstance();
				Transformer transformer;
				try {
					transformer = tf.newTransformer();
					transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					transformer.  setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
					StreamResult result1 = new StreamResult(new StringWriter());
					transformer.transform(src, result1);
					
					
					String xmlString = result1.getWriter().toString()
							.replaceAll("&lt;", "<").
							replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&apos;", "'").replaceAll("&quot;","\"");
							//System.out.print(xmlString);
							
					DocumentBuilder db =  DocumentBuilderFactory.newInstance().newDocumentBuilder();
					InputSource is = new InputSource();
					is.setCharacterStream(new StringReader(xmlString));
					Document doc = db.parse(is);
					Source src123 = new DOMSource(doc);
					soapmsg.getSOAPPart().setContent(src123);
					
					BufferedWriter bw = new BufferedWriter(new FileWriter("/home/shobha/project-workspace/EmployeeApplication/src/com/serviceexample/soapmsg.txt",true));;
					
					 bw.write(xmlString);
					 bw.newLine();
					 bw.close();
					
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					
				}
				
				/*
				//File file = new File("soapmsg.txt");
				 FileOutputStream fout=new FileOutputStream("soapmsg.txt",true);  
				  ByteArrayOutputStream out = new ByteArrayOutputStream();
					 soapmsg.writeTo(out);
					 String Msg = new String(out.toByteArray());
					 String strMsg = StringEscapeUtils.escapeXml(Msg);
					 fout.close();
				 //soapmsg.writeTo(fout);
				 //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));
				 BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\cs\\4th yr\\PROJECT\\EmployeeApplication\\src\\com\\serviceexample\\soapmsg.txt",true));;
				
				 bw.write(strMsg);
				 bw.newLine();
				 bw.close();  */
				
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
