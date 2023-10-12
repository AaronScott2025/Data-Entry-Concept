package pkgjobs;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Ids {
	
	
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
					idNumGen();	
				}
			}
			BufferedWriter attach = new BufferedWriter(new FileWriter("idNumbers.txt", true));
			attach.append(id + "," + "\n");
			attach.close();
			
					
		
		
		return id;
		
	}
}
