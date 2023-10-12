package pkgjobs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Datfile {
	
	
	public String finder(String key) throws IOException {
		String line;
	
		BufferedReader search = new BufferedReader(new FileReader("id.txt"));
		while ((line = search.readLine()) != null) {
			String curr = line;
			String id = line.substring(0,6);
			System.out.println(id);
			if(key.equalsIgnoreCase(id)) {
				return curr;
			}
			
	}
		return "Cannot find employee";

	}
}


