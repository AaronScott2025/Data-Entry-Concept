package pkgjobs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
* Datfile class, uses BufferedReader to locate the key(Employee ID)
* Returns the Id, along with all of the employee information if found
* If not found, Returns an error message
*/

public class Datfile {
	
	
	public String finder(String key) throws IOException {
		String line;
		BufferedReader search = new BufferedReader(new FileReader("id.txt"));
		while ((line = search.readLine()) != null) {
			String curr = line; //Current Full Line
			String id = line.substring(0,6); //Just the ID
			if(key.equalsIgnoreCase(id)) { //IgnoreCase doesnt check for Deep Copy
				return curr; //Found ID
			}
			
	}
		return "Cannot find employee"; //No ID found

	}
}


