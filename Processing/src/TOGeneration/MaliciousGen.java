package TOGeneration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import GetXsdConstraints.MNode;
import ParseXML.XMLParser;

public class MaliciousGen {

	Document doc;
	HashMap<String,Element> corresp_parent = new HashMap<String,Element>();
	
	public void remove() throws TransformerException, ParserConfigurationException, IOException, SAXException
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		doc = db.newDocument();
		
		XMLParser parser = new XMLParser();
		List<MNode> mnodelist = parser.getMNodeList();
		Map<String,MNode> element_MNode_Map = new HashMap<String,MNode>();
		
		
		for(int i=0;i<mnodelist.size();i++)
		{			
			MNode mnode = mnodelist.get(i);
			
			String element = mnode.getElem_name();
			element_MNode_Map.put(element, mnode);
			
			HashMap<String,String> attributes = mnode.getAttributes();
			
			Element child = null;
			Text textnode = null;
			String parent = mnode.getParent();
			
			if(!element.equals("#text"))
			{				
				//System.out.println(element);
				child = doc.createElement(element);
				
				for(Map.Entry<String, String> e : attributes.entrySet())
				{
					String attname = e.getKey();
					String attvalue = e.getValue();					
					Attr attr = doc.createAttribute(attname);
				    attr.setValue(attvalue);
				    child.setAttributeNode(attr);									
				}
			}
			else
			{
				textnode = doc.createTextNode(mnode.getTextvalue());
			}				
				
			
			
			if(parent == null)
			{
				doc.appendChild(child);
				corresp_parent.put(child.getNodeName(), child);
			}
			else
			{
			    if(corresp_parent.containsKey(parent))
			    {
			    	if(element.equals("#text"))
			    	{
			    		
			    		if(mnode.getTextvalue().length()!=1)
			    		{	
			    			String par = mnode.getParent();
			    			MNode parent_of_text = element_MNode_Map.get(par); // text node doesn't contain restriction, its parent does.
			    			
			    			Random randomNum = new Random();
			    			int attack = randomNum.nextInt(2);
			    			
			    			if(attack==0)
			    			{
			    				System.out.println("No attack on "+mnode.getTextvalue());
			    			}
			    			else
			    			{
			    				AttackManager attackobj = new AttackManager();
			    				attack = randomNum.nextInt(4);
			    				switch(attack)
			    				{
			    				case 0: mnode = attackobj.addmetacharacter(mnode);
			    						break;
			    				case 1: mnode = attackobj.addrandomclosingtag(mnode,parent_of_text);
			    						break;
			    				case 2: attackobj.duplicatetag(mnode,parent_of_text);break;
			    				case 3: attackobj.rewritetag(mnode);break;
			    				}		

	    						textnode.setNodeValue(mnode.getTextvalue());
			    			}
			    		}
			    		
			    		corresp_parent.get(parent).appendChild(textnode);
			    	}
			    	else
			    	{
			    		corresp_parent.get(parent).appendChild(child);
			    		corresp_parent.put(child.getNodeName(), child);
			    	}
			    }
			    else
			    {
			    	Element parent_elem = doc.createElement(parent);
			    	if(element.equals("#text"))
			    		corresp_parent.get(parent).appendChild(textnode);
			    	else
			    	{
			    		parent_elem.appendChild(child);
			    		corresp_parent.put(child.getNodeName(), child);
			    	}
			    }
			}

		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(doc);
	    
	    StringWriter stringwriter = new StringWriter();
	    StreamResult result = new StreamResult(stringwriter);
	    transformer.transform(source, result);
	    String malicious = stringwriter.toString().replaceAll("&lt;", "<").
				replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&apos;", "'").replaceAll("&quot;","\"");;
	   	    
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/editedMessage_xml", true)));
	    out.println(malicious+"\n");
	    out.close();
				
		System.out.println("File has saved");
	}
	
}
