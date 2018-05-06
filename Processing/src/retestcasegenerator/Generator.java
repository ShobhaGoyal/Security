package retestcasegenerator;

import com.mifmif.common.regex.Generex;
import java.io.*;
import java.util.Vector;

public class Generator {
	public static Vector<String> sqlinputs = new Vector<String>();
	
	public void generateSqlInput() throws FileNotFoundException, IOException{
	
		FileInputStream fstream = new FileInputStream("src/retestcasegenerator/strings.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		FileOutputStream fos = new FileOutputStream("src/retestcasegenerator/final.txt"); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));  
		
		String strLine;
		
		while ((strLine = br.readLine()) != null){
			Generex generex = new Generex(strLine);
			String randomStr = generex.random();
			//System.out.println(randomStr);
			sqlinputs.addElement(randomStr);
			bw.write(randomStr);
			bw.newLine();
			
		}

		br.close();
		bw.close();

	}
}
