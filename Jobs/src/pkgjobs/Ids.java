package pkgjobs;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
* Ids class. Used for all things related to importing the Employee information into the txt file.
* Includes an employee number generator, and checks for duplicate ID's (All id's begin with 'W').
*/

public class Ids {
	
	/**
	 * Takes the information from Data Class, and creates an ID using the idNumGen() Method below
  	 * Appends the information to the file, in a comma seperated list.
         * Returns the id number(used in JobGui)
	 */
	public String id(Data d) throws IOException {
		String name = d.getName();
		String dept = d.getDept();
		String pos = d.getPos();
		String salary = d.getSalary();
		String gender = d.getGender();
		String id = idNumGen();
		
			    
		BufferedWriter attach = new BufferedWriter(new FileWriter("id.txt", true));
		attach.append(id + "," + name + "," + dept + "," + pos + "," + salary + "," + gender + "\n");		    
		attach.close();
		
		return id;
	}
	/**
	 * Employee ID generator.
  	 * Each ID is 5 numbers, with a W in front of them
    	 * The loop serves the purpose of checking for duplicates within a seperate ID list.
      	 * If no duplicates are found, the new ID is placed into the idNumbers file, and the id is returned to the method above.
	 */
	public String idNumGen() throws IOException {
		String id = "W";
		Random gen = new Random();
		
		for(int count = 0 ; count <= 4 ; count++) {
			int idnum;
			idnum = gen.nextInt(9);
			id = id + idnum;
		}

		String line;
		BufferedReader search = new BufferedReader(new FileReader("idNumbers.txt"));
			while ((line = search.readLine()) != null) {
				if(id == line) {
					return idNumGen();	
				}
			}
			BufferedWriter attach = new BufferedWriter(new FileWriter("idNumbers.txt", true));
			attach.append(id + "," + "\n");
			attach.close();
			
					
		
		
		return id;
		
	}
}
