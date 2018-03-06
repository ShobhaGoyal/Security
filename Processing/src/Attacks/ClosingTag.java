package Attacks;

import java.util.Random;
import java.util.Vector;

import org.apache.xerces.xs.StringList;

import GetXsdConstraints.MNode;
import GetXsdConstraints.Restriction;
import com.mifmif.common.regex.Generex;

public class ClosingTag {
	
	 private Vector<String> enumeration = null; 
	 private String maxIncValue = null; 
	 private String minIncValue = null; 
	 private String maxExcValue = null; 
	 private String minExcValue = null; 
	 private String length = null; 
	 private String maxLength = null; 
	 private String minLength = null; 
	 private StringList pattern = null; 
	 
	 private String generateString(StringList patternlist)
	 {
		 String pattern;
		 
		 if(patternlist == null || patternlist.isEmpty())
			 pattern = "[a-zA-Z0-9]+";
		 else
			 pattern = (String) patternlist.get(0);
		System.out.println("1 "+pattern);
		
		Generex generex = new Generex(pattern);
		String randomStr = generex.random();
		
		Random rn = new Random();
		int ind = rn.nextInt(randomStr.length());
		randomStr = "</"+randomStr.substring(0, ind)+">"+randomStr.substring(ind,randomStr.length());
		System.out.println(randomStr);
		
		 return randomStr;
	 }
	 
	 private String generateString(int Lm,int LM,StringList patternlist,int casetype)
	 {
		
		 String pattern;
		 if(patternlist == null || patternlist.isEmpty())
		 {
			 pattern = "[a-zA-Z0-9]+";
		 }
		 else
			 pattern = (String) patternlist.get(0);
		 
		 System.out.println("2 "+pattern);		   
	     String randomStr = "";
	     
		 switch(casetype)
		 {
		 case 0:	pattern += "{"+Lm+",}";
			 		Generex generex = new Generex(pattern);
					randomStr = generex.random();			 			
			 		break;
			 		
		 case 1:	pattern += "{0,"+LM+"}";
		 			generex = new Generex(pattern);
		 			randomStr = generex.random();
		 			if(randomStr.length()>LM)
		 				randomStr = randomStr.substring(0,LM);
		 				
			 		break;
			 		
		 case 2:	pattern += "{"+Lm+","+LM+"}";
					generex = new Generex(pattern);
					randomStr = generex.random();
					if(randomStr.length()>LM)
						randomStr = randomStr.substring(0,LM);
			 		break;
		 }
		 
		int len = randomStr.length();
		Random rn = new Random();
		int ind = rn.nextInt(len);
		randomStr = "</"+randomStr.substring(0, ind)+">"+randomStr.substring(ind,len);
		System.out.println(randomStr);
		return randomStr;
	 }
	 
	public MNode addrandomclosingtag(MNode mnode,MNode parent)
	{
		Restriction res = parent.getRestriction();
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		int len;
		int minlen=0,maxlen=10;
		String value = "";
		
		if(res!=null)
		{
		 if(res.getEnumeration()!=null)
			 enumeration = res.getEnumeration(); 
		 if(res.getMaxIncValue()!=null)
			 maxIncValue = res.getMaxIncValue(); 
		 if(res.getMaxIncValue()!=null)
			 minIncValue = res.getMinIncValue(); 
		 if(res.getMaxExcValue()!=null)
			 maxExcValue = res.getMaxExcValue(); 
		 if(res.getMinExcValue()!=null)
			 minExcValue = res.getMinExcValue(); 
		 if(res.getLength()!=null)
			 length = res.getLength(); 
		 if(res.getMaxLength()!=null)
			 maxLength = res.getMaxLength(); 
		 if(res.getMinLength()!=null)
			 minLength = res.getMinLength(); 
		 if(res.getPattern()!=null)
			 pattern = res.getPattern(); 
		 
		}
		
		min = (minIncValue==null)?((minExcValue==null)?(min):(Integer.parseInt(minExcValue)+1)):(Integer.parseInt(minIncValue));
		max = (maxIncValue==null)?((maxExcValue==null)?(max):(Integer.parseInt(maxExcValue)-1)):(Integer.parseInt(maxIncValue));
		
		if(length==null)
		{
			if(minLength!=null)
			{
				minlen = Integer.parseInt(minLength);
			}
			if(maxLength!=null)
			{
				maxlen = Integer.parseInt(maxLength);
			}
				
			if(minLength==null && maxLength==null)
				value = generateString(pattern);
			if(minLength != null && maxLength==null)
				value = generateString(minlen,0,pattern,0);
			else if(maxLength != null && minLength==null)
				value = generateString(0,maxlen,pattern,1);
			else if(maxLength != null && minLength !=null)
				value = generateString(minlen,maxlen,pattern,2);
		}
		else
		{
			len = Integer.parseInt(length);
			value = generateString(len,len,pattern,2);
		}
		if(!value.equals(""))
			mnode.setTextvalue(value);
		return mnode;
	}
	
}
