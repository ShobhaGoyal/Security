package GeneticAlgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
	
	private static int POPULATION_SIZE = 300;
	public static Vector<Vector<String>> genetic_input;
	private Vector<Integer> length = new Vector<Integer>();
	public static Vector<String> TARGETSTR;
	public static Vector<MNode> mnode_Rest = new Vector<MNode>();
	public static Vector<Integer> patternstatus = new Vector<Integer>();
	//private int attributecount = 0;
	
	private boolean getTargetInput(Scanner sc)
	{
		TARGETSTR = new Vector<String>();
		
		while(sc.hasNext())
		{
			String line;			
			if((line = sc.nextLine()).isEmpty())
				break;
			TARGETSTR.addElement(line);
		}
		
		if(TARGETSTR.isEmpty())
			return false;
		
		return true;
	}
	/*private void findattributescount() throws FileNotFoundException
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
		
	}*/
	/*public void findMnode_Restriction(List<MNode> mnodelist) throws TransformerException
	{
		
		for(int i=0;i<mnodelist.size();i++)
		{			
			MNode mnode = mnodelist.get(i);
			
			if(mnode.getRestriction()!=null)
			{
				mnode_Rest.addElement(mnode);
			}
		}
		
		
	}*/
	
	public boolean generateGeneticIp(Scanner sc) throws TransformerException, FileNotFoundException
	{
		genetic_input = new Vector<Vector<String>>();
		boolean status = getTargetInput(sc);
		if(status == false)
			return false;
		
		System.out.println(TARGETSTR);
		
		XMLParser parser = new XMLParser();
		List<MNode> mnodelist = new ArrayList<MNode>(parser.getMNodeList());
		//mnodelist = parser.getMNodeList();
		
		//findMnode_Restriction(mnodelist);
		
		//System.out.println(mnodelist.size());
		int j=0;
		int patternaddonce = 0;
		
		while(j++<POPULATION_SIZE)
		{
			Vector<String> temp = new Vector<String>();
			int index = -1;
			
			for(int i=0;i<mnodelist.size();i++)
			{			
				MNode mnode = mnodelist.get(i);
				
				if(mnode.getRestriction()!=null)
				{
					index++;
					//System.out.println(mnode.getElem_name());
					//mnode.getRestriction().print();
					
					Restriction r = mnode.getRestriction();
					//System.out.println(mnode.getElem_name()+" "+index);
					int len = TARGETSTR.get(index).length();
					//System.out.println("LENGTH"+len);
					int st=0;
					String pattern;
					
					/*if(r.getLength()!=null)
					{
						len = Integer.parseInt(r.getLength()); st =1;
					}
					else if(r.getMaxLength()!=null)
						len = Integer.parseInt(r.getMaxLength());
					else
						len = 50;*/
					
					if(mnode.getRestriction().getPattern()!=null && !mnode.getRestriction().getPattern().isEmpty())
					{
						pattern = (String)mnode.getRestriction().getPattern().get(0);
						//System.out.println(pattern);
						if(patternaddonce == 0)
							patternstatus.addElement(1);
					}
					else
					{
						pattern = "[a-z0-9A-Z`~!@#$%^&*()_{}-+=:;\"'<,>.?/]";
						if(patternaddonce == 0)
							patternstatus.addElement(0);
					}
						//pattern = "[a-z0-9A-Z]";
				//	if(st==1)
						pattern += "{"+len+"}";
					//else
					//	pattern += "{1,"+len+"}";
				
					Generex generex = new Generex(pattern);
					String randomStr = generex.random();
					//System.out.println("Before: "+randomStr+"  "+randomStr.length());
					if(randomStr.length()>len)
						randomStr = randomStr.substring(0,len);
					//System.out.println("After: "+randomStr+"  "+randomStr.length());
					temp.add(randomStr);
				}				
			}
			genetic_input.add(temp);
			patternaddonce = 1;
			
		}
		System.out.println(genetic_input);
		return true;
	}
	
	/*public static void main(String args[]) throws FileNotFoundException, TransformerException
	{
		Initialization in = new Initialization();
		//in.findattributescount();
		 File f = new File("src/maliciousIp.txt");
		Scanner sc = new Scanner(f).useDelimiter("\\n");
		in.generateGeneticIp(sc);
	}*/
	
}
