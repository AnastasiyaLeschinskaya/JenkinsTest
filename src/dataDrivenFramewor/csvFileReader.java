package dataDrivenFramewor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class csvFileReader {
	
	public static List<String[]> get(String fileName){
		List<String[]> data = new ArrayList<String[]>();
		String testRow;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			while ((testRow = br.readLine()) !=null) {
				String[] line = testRow.split(",");
				data.add(line);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return data;
}
	

}
