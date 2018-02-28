package ParseXML;

import GetXsdConstraints.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;


public class XMLParser {
	
	public static final List<MNode> elements = new ArrayList<MNode>();	//contains only the nodes having values like username,userid,password,etc
	public static List<MNode> mnodelist= new ArrayList<MNode>();   // contains everything about a node
    private Document doc;	
    
	private void parseXmlFile() throws TransformerException{
		
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	
	try {
		//Using factory get an instance of document builder
		DocumentBuilder db = dbf.newDocumentBuilder();

		doc = db.newDocument();
		
		//parse using builder to get DOM representation of the XML file
		Document dom = db.parse("src/sampleMessage.xml");
		parseDocument(dom);
		
		/*TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(doc);
	    StreamResult result = new StreamResult(new File("src/editedMessage.xml"));
	    transformer.transform(source, result);
	    System.out.println("File saved!");*/

	}catch(ParserConfigurationException pce) {
		pce.printStackTrace();
	}catch(SAXException se) {
		se.printStackTrace();
	}catch(IOException ioe) {
		ioe.printStackTrace();
	}
	
  }
	
   private void getChild(Node node,Element parent)
   {
	   MNode mnode = new MNode();
	   HashMap<String,String> mnodeattr = new HashMap<String,String>();
	   
	   NodeList n = node.getChildNodes();
	   
	   Element x = parent;
	   if(!node.getNodeName().equals("#text"))
	   {
		   x = doc.createElement(node.getNodeName());
		   //System.out.println(x);
		   NamedNodeMap attributes = node.getAttributes();
	   
		   if(parent==null)
		   {
			   doc.appendChild(x);	
		   }
		   else
		   {   
			   parent.appendChild(x);
		   }	
		   
		   for(int i=0;i<attributes.getLength();i++)
		   {
			   Node attributeNode = attributes.item(i);
		       Attr attr = doc.createAttribute(attributeNode.getNodeName());
		       attr.setValue(attributeNode.getNodeValue());
		       x.setAttributeNode(attr);	
		       
		       mnodeattr.put(attributeNode.getNodeName(), attributeNode.getNodeValue());
		   }
	   }
	   
	   if(parent==null)
		   mnode.setParent(null);
		  
	   else
		   mnode.setParent(parent.getNodeName());
		  
	   mnode.setElem_name(node.getNodeName());
	   mnode.setAttributes(mnodeattr);
	   mnode.setTextvalue(node.getNodeValue());
	   mnodelist.add(mnode);
	   //System.out.println(mnode.getElem_name());
	   //System.out.println(mnode.getElem_name()+" "+mnode.getParent()+" "+mnode.getTextvalue());
	   if(n!=null && n.getLength()>0)
	   { 
		   for(int i = 0 ; i < n.getLength();i++) {
			   Node nod = n.item(i);
			  // System.out.println("child: "+nod.getNodeName());
			   if(!(nod.getNodeValue()== null) && !(nod.getNodeValue().equals("\n")) && !(nod.getNodeValue().equals("")))
			   {				
				   //elements.add(node.getNodeName());
				   elements.add(mnode);   // it contains only the nodes having values like {userid,email,username,password,email}
				   
			   }			  
			   getChild(nod,x);
		   }
		   
	   }
   }
   private void parseDocument(Document dom)
   {	   
	   NodeList nl = dom.getChildNodes();
	 
	   // Only the root element i.e node = S:Envelope/////////
	   
	   if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {

				Node node = nl.item(i);
			//	Element x = doc.createElement(node.getNodeName());
				//doc.appendChild(x);
				//Node prev = node;				
				getChild(node,null);				
			}
		}	   
   }
   
   public List<MNode> getMNodeList() throws TransformerException
   {
	   XMLParser xp = new XMLParser();
	   xp.parseXmlFile();
	   
	   XSDParserTest test = new XSDParserTest();
	   
	   for (MNode str : elements)
	   {
		  // System.out.println(str.getElem_name());
		   test.parse(str.getElem_name());
	   }
	   return XSDParser.new_mnodelist;   // new_mnodelist also contains restrictions now for each node present in elements array
	  
	  /* for(MNode mnode : mnodelist)
	   {
		   String elem = mnode.getElem_name();
		   Restriction r = mnode.getRestriction();
		   System.out.println(elem+" => ");
		   r.print();
	   }*/
	      
   }
}
