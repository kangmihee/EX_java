package test;

public class RegisterBean {  // Bean에서의 멤버변수는 다 소문자로
	private String mem_id;
	private String mem_passwd;
	private String mem_repasswd;
	private String mem_name;
	private String mem_email;
	private String mem_phone;
	private int mem_age;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_passwd() {
		return mem_passwd;
	}
	public void setMem_passwd(String mem_passwd) {
		this.mem_passwd = mem_passwd;
	}
	public String getMem_repasswd() {
		return mem_repasswd;
	}
	public void setMem_repasswd(String mem_repasswd) {
		this.mem_repasswd = mem_repasswd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public int getMem_age() {
		return mem_age;
	}
	public void setMem_age(int mem_age) {
		this.mem_age = mem_age;
	}
	
	

}
