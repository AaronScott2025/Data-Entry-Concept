package pkgjobs;

public class Data {
	
	private String name;
	private String dept;
	private String pos;
	private String salary;
	private String gender;
	
	
	public Data() {
		name = "";
		dept = "";
		pos = "";
		salary = "";
		gender = "";
		
	}
	
	
	public Data(String name, String dept, String pos, String salary, String gender) {
		this.name = name;
		this.dept = dept;
		this.pos = pos;
		this.salary = salary;
		this.gender = gender;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getPos() {
		return pos;
	}


	public void setPos(String pos) {
		this.pos = pos;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void datFile() {
		
	}
	
}
