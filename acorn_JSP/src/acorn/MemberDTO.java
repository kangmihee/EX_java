package acorn;

public class MemberDTO {
	private int num; // 접근지정자 private : 외부에서 접근 불가/ public 
	private String name;
	private String addr;
	
	// 암묵적 생성자, 배열을 못 만들기 때문에 생성자 오버로딩을 하면 반드시 
	// 명시적으로 default 생성자를 생성해 주어야 한다.
	public MemberDTO() {} // 자동으로 생성
	
	public MemberDTO(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
