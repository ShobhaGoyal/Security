package TOGeneration;

import com.mifmif.common.regex.Generex;
import java.util.regex.Pattern;

public class generator {
	public static void main(String args[]) {
		/*String letter = "[a-z]";
		String digit = "[0-9]";
		String letterOrDigit = "[a-z0-9]";
		String val = letter + "+ | '" + letterOrDigit + "*' | " + digit + "+";
		String cond = "((" + val + ") = (" + val + ") \\| ){1,5} \\| 1 = 1;";
		String start = "SELECT " + letter + "+ FROM " + letter + "+ WHERE " + cond;*/
		String start = "[a-zA-Z0-9]{0,2}";
		// System.out.println(start);
		Generex generex = new Generex(start);
		// Generate random String
		String randomStr = generex.random();
		System.out.println(randomStr);

	}
}
