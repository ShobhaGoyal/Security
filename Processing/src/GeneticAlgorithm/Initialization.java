package GeneticAlgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.xml.transform.TransformerException;

import org.apache.xerces.xs.StringList;

import com.mifmif.common.regex.Generex;

import GetXsdConstraints.MNode;
import GetXsdConstraints.Restriction;
import ParseXML.XMLParser;

public class Initialization {
	
	private Vector<Vector<String>> genetic_input = new Vector<Vector<String>>();
	private Vector<Integer> length = new Vector<Integer>();
	
	private int attributecount = 0;
	
	private void findattributescount() throws FileNotFoundException
	{
		File f = new File("src/maliciousIp.txt");
		Scanner sc = new Scanner(f);
		
		while(sc.hasNext())
		{
			String line = sc.next();
			if(line == "\n" || line=="" || line==null)
				break;
			attributecount++;
		}
		//System.out.println(attributecount);
		
	}
	
	private void generateGeneticIp() throws TransformerException
	{
		XMLParser parser = new XMLParser();
		List<MNode> mnodelist = parser.getMNodeList();
		//System.out.println(mnodelist.size());
		int j=0;
		while(j++<30)
		{
			Vector<String> temp = new Vector<String>();
			for(int i=0;i<mnodelist.size();i++)
			{			
				MNode mnode = mnodelist.get(i);
				if(mnode.getRestriction()!=null)
				{
					System.out.println(mnode.getElem_name());
					mnode.getRestriction().print();
					
					Restriction r = mnode.getRestriction();
					int len;
					int st=0;
					String pattern;
					
					if(r.getLength()!=null)
					{
						len = Integer.parseInt(r.getLength()); st =1;
					}
					else if(r.getMaxLength()!=null)
						len = Integer.parseInt(r.getMaxLength());
					else
						len = 50;
					
					if(mnode.getRestriction().getPattern()!=null && !mnode.getRestriction().getPattern().isEmpty())
					{
						pattern = (String)mnode.getRestriction().getPattern().get(0);						
					}
					else
						pattern = "[a-z0-9A-Z`~!@#$%^&*()_{}-+=:;\"'<,>.?/]";
					
					if(st==1)
						pattern += "{"+len+"}";
					else
						pattern += "{1,"+len+"}";
				
					Generex generex = new Generex(pattern);
					String randomStr = generex.random();
					if(randomStr.length()>len)
						randomStr = randomStr.substring(0,len);
					
					temp.add(randomStr);
				}				
			}
			genetic_input.add(temp);
		}
		System.out.println(genetic_input);
	}
	
	public static void main(String args[]) throws FileNotFoundException, TransformerException
	{
		Initialization in = new Initialization();
		in.findattributescount();
		in.generateGeneticIp();
	}
	
}
