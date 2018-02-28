package GetXsdConstraints;

import java.util.HashMap;
import java.util.List;

public class MNode {

	private Restriction r;
	private String elem_name;
	private HashMap<String,String> attributes;
	private String parent;
	private String textvalue;
	
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getTextvalue() {
		return textvalue;
	}
	public void setTextvalue(String textvalue) {
		this.textvalue = textvalue;
	}
	public HashMap<String,String> getAttributes() {
		return attributes;
	}
	public void setAttributes(HashMap<String,String> attributes) {
		this.attributes = attributes;
	}
	public Restriction getRestriction() {
		return r;
	}
	public void setRestriction(Restriction r) {
		this.r = r;
	}
	public String getElem_name() {
		return elem_name;
	}
	public void setElem_name(String elem_name) {
		this.elem_name = elem_name;
	}
	
	
}
