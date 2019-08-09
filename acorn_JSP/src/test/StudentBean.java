package test;

public class StudentBean implements java.io.Serializable{
	private String firstName = null;
	private String lastName = null;
	private int age = 0;
	
	public StudentBean() { // default 생성자는 반드시 있어야 함	
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) { // Integet로 하면 안됨
		this.age = age;
	}
}
