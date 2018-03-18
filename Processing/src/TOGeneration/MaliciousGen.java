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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
	private static int rewritestatus = 0;
	private static int tagindex = 0;
	private static int is_attackhappened = 0;
	
	public void remove() throws TransformerException, ParserConfigurationException, IOException, SAXException
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		doc = db.newDocument();
		
		XMLParser parser = new XMLParser();
		List<MNode> mnodelist = parser.getMNodeList();
		
		LinkedHashMap<MNode,MNode> rewritetags = new LinkedHashMap<MNode,MNode>();
		
		Map<String,MNode> element_MNode_Map = new HashMap<String,MNode>();
		List<MNode> elements = XMLParser.elements;
		
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
			    			//System.out.println(par);
			    			MNode parent_of_text = element_MNode_Map.get(par); // text node doesn't contain restriction, its parent does.
			    			
			    			Random randomNum = new Random();
			    			int attack = randomNum.nextInt(2);
			    			
			    			if(attack==0 && rewritestatus==0)
			    			{
			    				System.out.println("No attack on "+parent_of_text.getElem_name());
			    			}
			    			if((attack==0 && rewritestatus==1) || attack==1 || (elements.get(elements.size()-1).getElem_name()==parent_of_text.getElem_name() && is_attackhappened!=1))
			    			{
			    				
			    				AttackManager attackobj = new AttackManager();
			    							    				
			    				if(rewritestatus == 0)
			    				{
			    					do
			    					{
				    					attack = randomNum.nextInt(4);
					    				switch(attack)
					    				{
					    				case 0: mnode = attackobj.addmetacharacter(mnode,parent_of_text); is_attackhappened = 1;
					    						break;
					    				case 1: mnode = attackobj.addrandomclosingtag(mnode,parent_of_text); is_attackhappened = 1;
					    						break;
					    				case 2: attackobj.duplicatetag(mnode,parent_of_text); is_attackhappened = 1;
					    						break;
					    				case 3: // to find index of this node in elements of XMLParser
					    						tagindex = 0;
					    						for(MNode x : elements)
					    						{
					    							if(x.getElem_name() == parent_of_text.getElem_name())
					    								break;
					    							tagindex++;
					    						}
					    						if(tagindex!=(elements.size()-1))   //i.e not last element because rewrite tag attack won't be possible then
					    						{
					    							mnode = attackobj.rewritetag(mnode,parent_of_text); is_attackhappened = 1;
					    							rewritestatus = 1;
					    						}
					    						else
					    							System.out.println("1 No attack on "+parent_of_text.getElem_name());
					    						break;
					    				}	
			    					}while(is_attackhappened!=1);
			    				}
			    				else
			    				{
			    					Random rd = new Random();
			    					int finish = rd.nextInt(3);
			    					System.out.println(finish+" "+tagindex+" "+mnode.getTextvalue());
			    					if(finish == 1 || tagindex==(elements.size()-2))
			    					{
			    						String val = "-->";
			    						if(!rewritetags.isEmpty())
			    						{
			    							for(Map.Entry<MNode,MNode> e : rewritetags.entrySet())
			    							{
			    								MNode nod = e.getKey();
			    								MNode pare = e.getValue();
			    								
			    								val += "<" + pare.getElem_name() + ">";
			    								val += nod.getTextvalue();
			    								val += "</" + pare.getElem_name() + ">";
			    							}
			    						}

		    							val += "<" + parent_of_text.getElem_name() + ">";
		    							val += mnode.getTextvalue();
		    							mnode.setTextvalue(val);
			    						rewritestatus = 0;
			    					}
			    					else
			    					{
			    						tagindex++;
			    						rewritetags.put(mnode, parent_of_text);
			    					}
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
