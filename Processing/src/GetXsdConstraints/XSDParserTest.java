package GetXsdConstraints;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/** Test class for XSDParser.
 * 
 * @author José Ángel Arrechea
 *
 */
public class XSDParserTest {

  public void parse(String data) {
	  
    try {
      URL url = XSDParserTest.class.getClassLoader().getResource(
          "xsd/schema.xsd");
  
      XSDElement mainElement = XSDParser.parseXSD(url, data);
     /* // Print all data
      System.out.println("=============== Only some elements =======================");
      //printData(mainElement, 0);

      //mainElement = XSDParser.parseXSD(url, "database");
      // Print all data
      System.out.println("\n\n=============== All elements =======================");
     // printData(mainElement, 0);
      
      */
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /*
  private static void printData(XSDElement xsdElement, int level) {

    String margin = StringUtils.repeat(" ", level);

    System.out.println(margin + "Element " + xsdElement.getName() + " ->"
        + " minOcurres=" + xsdElement.getMinOcurrs() + " maxOcurres="
        + xsdElement.getMaxOcurrs() + " unbounded="
        + xsdElement.isMaxOcurrsUnbounded() + " type=" + xsdElement.getType()
        + " default=" + xsdElement.getDefaultValue());

    for (XSDAttribute attribute : xsdElement.getAttributes()) {
      System.out.println(margin + "-- " + attribute.getName() + " ->"
          + " type=" + attribute.getType() + " required="
          + attribute.isRequired() + " default=" + attribute.getDefaultValue());
      for (String option : attribute.getOptions()) {
        System.out.println(margin + "---- " + option);
      }
    }
    if (xsdElement.getChildren().size() > 0) {
      System.out.println(margin + "Children of " + xsdElement.getName());
      for (XSDElement child : xsdElement.getChildren()) {
        printData(child, level + 2);
      }
    }

  }*/

}