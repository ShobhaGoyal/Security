package GetXsdConstraints;
import java.util.ArrayList;
import java.util.List;

/** Represents an "attribute" schema definition.
 * 
 * @author Jos� �ngel Arrechea
 *
 */
public class XSDAttribute {

	private String name;
	private boolean required;
	private String type;
	private List<String> options = new ArrayList<String>();
	private String defaultValue;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
  public String getDefaultValue() {
    return defaultValue;
  }
  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }
	
	

}