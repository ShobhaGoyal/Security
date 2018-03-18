package TOGeneration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import GetXsdConstraints.MNode;
import GetXsdConstraints.Restriction;
import GetXsdConstraints.XSDAttribute;
import ParseXML.XMLParser;

public class ApplyMO {

	private static List<String> metacharacters;
	
	private static void initialise()
	{
		metacharacters = new ArrayList<String>();
		metacharacters.add("<");
		metacharacters.add(">");
		metacharacters.add("'");
		metacharacters.add("\"");
		metacharacters.add("&");
		metacharacters.add("&lt;");
		metacharacters.add("&gt;");
		metacharacters.add("&amp;");
		metacharacters.add("&apos;");
		metacharacters.add("&quot;");
		
	}
	
	public void applyoperator() throws TransformerException
	{
		initialise();
		
		XMLParser parser = new XMLParser();
		List<MNode> mnodelist = parser.getMNodeList();
		
		for(int i=0;i<mnodelist.size();i++)
		{
			Random rn = new Random();
			int index = rn.nextInt(metacharacters.size());
			String mut_op = metacharacters.get(index);
			
			MNode element = mnodelist.get(i);
			
			MNode newnode = new MNode();
			
			//////// need to change this/////
			newnode.setElem_name(element.getElem_name()+mut_op);
			newnode.setRestriction(element.getRestriction());
			newnode.setAttributes(element.getAttributes());
			newnode.setParent(element.getParent());
			newnode.setTextvalue(element.getTextvalue());
			mnodelist.set(i, newnode);
			////////////////////////////////
			
		}
		
		for(MNode mnode : mnodelist)
		   {
			   String elem = mnode.getElem_name();
			   Restriction r = mnode.getRestriction();
			   
			   System.out.println(elem+" "+mnode.getAttributes()+" => ");
			   if(r!=null)
				   r.print();
			   System.out.println(mnode.getParent()+" "+mnode.getTextvalue());
			  
		   }
	}
	public static void main(String args[]) throws TransformerException, ParserConfigurationException, IOException, SAXException
	{
		ApplyMO m = new ApplyMO();
		//m.applyoperator();
		
		MaliciousGen at = new MaliciousGen();
		at.remove();
	}
}
