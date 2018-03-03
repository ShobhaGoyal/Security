package Attacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.transform.TransformerException;

import GetXsdConstraints.MNode;
import GetXsdConstraints.Restriction;
import ParseXML.XMLParser;

public class Metacharacter {

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
	
	public MNode addmetacharacter(MNode mnode) throws TransformerException
	{
			initialise();
		
			Random rn = new Random();
			int index = rn.nextInt(metacharacters.size());
			String mut_op = metacharacters.get(index);
			
			String value = mnode.getTextvalue();
			int len = value.length();
			Random rm = new Random();
			int replace_at = rm.nextInt(len);
			String malvalue = value.substring(0,replace_at)+mut_op+value.substring(replace_at,len);
			mnode.setTextvalue(malvalue);
		
		return mnode;
	}
}
