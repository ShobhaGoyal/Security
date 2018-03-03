package Attacks;

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
		 
		 if(patternlist == null)
			 pattern = ".";
		 else
			 pattern = (String) patternlist.get(0);
		System.out.println(pattern);
		 String str = "";
		 return str;
	 }
	 
	 private String generateString(int L,StringList pattern,int casetype)
	 {
		 System.out.println(pattern);
		 
		 String str = "";
		 switch(casetype)
		 {
		 case 0:	break;
		 case 1:	break;
		 case 2:	break;
		 }
		 return str;
	 }
	 
	public MNode addrandomclosingtag(MNode mnode,MNode parent)
	{
		Restriction res = parent.getRestriction();
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		int len;
		int minlen=0,maxlen=10;
		
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
				generateString(pattern);
			if(minLength != null && maxLength==null)
				generateString(minlen,pattern,0);
			else if(maxLength != null && minLength==null)
				generateString(maxlen,pattern,1);
		}
		else
		{
			len = Integer.parseInt(length);
			generateString(len,pattern,2);
		}
		return mnode;
	}
	
}
