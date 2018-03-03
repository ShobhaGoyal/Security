package GetXsdConstraints;
import com.sun.xml.xsom.*;

import java.util.Iterator;
import java.util.Vector;

import org.apache.xerces.impl.dv.xs.XSSimpleTypeDecl;
import org.apache.xerces.xs.StringList;
import org.apache.xerces.xs.XSSimpleTypeDefinition;
import org.apache.xerces.xs.datatypes.ObjectList;


public class Restriction {
	 private Vector<String> enumeration = null; 
	 private String maxIncValue = null; 
	 private String minIncValue = null; 
	 private String maxExcValue = null; 
     private String minExcValue = null; 
	 private String length = null; 
	 private String maxLength = null; 
	 private String minLength = null; 
	 private StringList pattern = null; 
	 private String totalDigits = null; 
	 private String fractionDigits = null;
	 private String whitespace = null;
	 
	 public void initRestrictions(XSSimpleTypeDefinition xsType){ 
		   
		        enumeration =  new Vector<String>(); 
		        
		        this.length = xsType.getLexicalFacetValue(XSSimpleTypeDecl.FACET_LENGTH);
		        this.maxLength = xsType.getLexicalFacetValue(XSSimpleTypeDecl.FACET_MAXLENGTH);
		        this.minLength = xsType.getLexicalFacetValue(XSSimpleTypeDecl.FACET_MINLENGTH);
		        this.maxExcValue = xsType.getLexicalFacetValue(XSSimpleTypeDecl.FACET_MAXEXCLUSIVE);
		        this.minExcValue = xsType.getLexicalFacetValue(XSSimpleTypeDecl.FACET_MINEXCLUSIVE);
		        this.maxIncValue = xsType.getLexicalFacetValue(XSSimpleTypeDecl.FACET_MAXINCLUSIVE);
		        this.minIncValue = xsType.getLexicalFacetValue(XSSimpleTypeDecl.FACET_MININCLUSIVE);
		        this.totalDigits = xsType.getLexicalFacetValue(XSSimpleTypeDecl.FACET_TOTALDIGITS);
		        this.fractionDigits = xsType.getLexicalFacetValue(XSSimpleTypeDecl.FACET_FRACTIONDIGITS);
		        this.whitespace = xsType.getLexicalFacetValue(XSSimpleTypeDecl.FACET_WHITESPACE);
		        this.pattern = ((XSSimpleTypeDecl)xsType).getLexicalPattern();
		        if (xsType instanceof XSSimpleTypeDecl) {
		            ObjectList list = ((XSSimpleTypeDecl)xsType).getActualEnumeration();
		            if (list!=null && list.getLength()>0){
		                for (int k=0; k<list.getLength(); k++){
		                  enumeration.add((String)list.get(k));
		                }
		            }
		        }
	 }
	 
	 public Vector<String> getEnumeration() {
			return enumeration;
		}
		public String getMaxIncValue() {
			return maxIncValue;
		}
		public String getMinIncValue() {
			return minIncValue;
		}
		public String getMaxExcValue() {
			return maxExcValue;
		}
		public String getMinExcValue() {
			return minExcValue;
		}
		public String getLength() {
			return length;
		}
		public String getMaxLength() {
			return maxLength;
		}
		public String getMinLength() {
			return minLength;
		}
		public StringList getPattern() {
			return pattern;
		}
		public String getTotalDigits() {
			return totalDigits;
		}
		public String getFractionDigits() {
			return fractionDigits;
		}
		public String getWhitespace() {
			return whitespace;
		}
		
	 public void print()
	 {
		 System.out.println("maxIncValue: "+maxIncValue);
		 System.out.println("minIncValue: "+minIncValue);
		 System.out.println("maxExcValue: "+maxExcValue);
		 System.out.println("minExcValue: "+minExcValue);
		 System.out.println("length: "+length);
		 System.out.println("maxLength: "+maxLength);
		 System.out.println("minLength: "+minLength);
		 System.out.println("pattern: "+pattern);
		 System.out.println("totalDigits: "+totalDigits);
		 System.out.println("fractionDigits: "+fractionDigits);
		 System.out.println("whitespace: "+whitespace);
		 System.out.print("enumeration: "+enumeration);
		
		 System.out.println("\n");
	 }
}
