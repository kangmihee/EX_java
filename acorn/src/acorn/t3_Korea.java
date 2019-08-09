package acorn;
//문제 : 대한민국의 국가 정보중 인구, 수도, 특성("아리랑, 경주박물관, 충주댐")을
//저장하는 클래스를 만들고 변수는 private로 하고 인구를 설정하고 인구를 리턴하는 set/get 함수를 작성하시오.
public class t3_Korea {
	public static void main(String[] args) {		
		/*방법1
		Korea k; //주소를 저장한 기억공간만 확보 - 실제주소는 없음 null
		k = new Korea();*/
		
		//방법2
		Korea ko = new Korea();
		
		ko.setPeople(5000); //0은 입력제한할 것
		int p = ko.getPeople();
		System.out.println("인구: " + p);
		
		ko.setSeoul("서울"); //
		String s = ko.getSeoul();
		System.out.println("수도: " + s);
		
		//주소를 저장하는 기억공간의 확보
		String[] list = ko.getCharacter(); //저장된 주소하고 character에 저장된 
		for(int i=0;i<list.length;i++){
			System.out.print(list[i] + " " );
		}
		
		//주소값이 넘어 갔는지 확인
		list[2] = "수안보";
		String[] list2 = ko.getCharacter();
		System.out.println(list2[2]);
		//수안보로 변경됨		
	
		Worker wo = new Worker();
		wo.setName("차은우");
		wo.setNo(25);
		wo.setDept("영업팀");	
		wo.print();	
		
		Document d1 = new Document(); //출력:클래스 생성순서는 1번째가 생성되었습니다.
		Document d2 = new Document("아리랑"); //출력:클래스 아리랑번째가 생성되었습니다.
		Document d3 = new Document(); //출력:클래스 생성순서는 2번째가 생성되었습니다.
		Document d4 = new Document(); //출력:클래스 생성순서는 3번째가 생성되었습니다.
		System.out.println(d4.count); //0으로 초기화... 출력:3
		System.out.println(d1.count); //0으로 초기화... 출력:3
	}
}

class Korea { //배열은 기본적으로  reference 이다.
	private int people =0;
	private String seoul;
	private String[] character = {"아리랑", "경주박물관", "충주댐"}; //실제데이터는 heap에 저장되어 있음

	public void setPeople(int p) {
		if(p < 1){ //제한
			System.out.println("인구는 1이상으로 설정하세요.");
			return;
		}
			people = p;
	}
	public void setSeoul(String s) {
		seoul = s;
	}
	public void setCharacter(String[] c) {
		character = c;
	}
	
	public int getPeople() {
		return people;
	}	
	public String getSeoul() {
		return seoul;
	}
	public String[] getCharacter() { //동적할당에 의한 reference를 리턴
		return character; // reference에 의한 리턴
	}		
	public void print() {
		System.out.println("대한민구의 인수구는: " + getPeople() + "명이다." + 
	                       "대한민구의 수도는: " + getSeoul() + "이다." + 
	                       "대한민구의 특성은: " + getCharacter() + "이 있다.");
		}
}

//사원 (name, no, dept(부서)를 작성하는 클래스를 작성하시오)
//생성자 오버로딩을 통해 입력이 없을 때 초기화하는 함수와 이름, 번호, 부서를 입력받는 생성자를 작성하시오
//멤버변수의 데이터 내용을 출력하는 print함수를 작성하시오

class Worker{
	private String name;
	private int no;
	private String dapt;
	//인스턴스 방법  
	
	/*public Worker() {
		name = "초기화";
		no = "사번입력";
		dept = "부서명입력";
		System.out.println("인자없는 생성자 호출됨!!!");
	}*/	
	public void setName(String n) {		
		name = n;
	}
	public void setNo(int number) {
		no = number;
	}
	public void setDept(String d) {
		dapt = d;
	}
		
	public String getName() {
		return name;
	}
	public int getNo() {
		return no;
	}
	public String getDept() {
		return dapt;
	}
	
	public void print() {
		System.out.println("이름은 " + getName() + "이다." + "\n" +
	                       "사원번호는 " + getNo() + "이다." + "\n" +
	                       "부서는 " + getDept() + "이다.");
		}
}

//static 변수 : 클래스 인스턴스 object들이 공용으로 사용하는 변수임
class Document {
	static int count = 0; //생성자에서 초기화하지 않음...정적변수(static)는 한번만 만들어 진다...때문에 각 클래스가 공용으로사용됨
	//학생 => 학교
	String name; //정적변수(static)가 아닌변수는 언제든지 초기화 가능(?)
	
	public Document(){ //생성자가 생성자를 호출
		this("생성순서는 " + ++count);
	}
	public Document(String name) {
		this.name = name;
		System.out.println("클래스 " + this.name + "번째가 생성되었습니다.");
	}
}

//결과출력:
//인구: 5000
//수도: 서울
//아리랑 경주박물관 충주댐 수안보
//이름은 차은우이다.
//사원번호는 25이다.
//부서는 영업팀이다.
//클래스 생성순서는 1번째가 생성되었습니다.
//클래스 아리랑번째가 생성되었습니다.
//클래스 생성순서는 2번째가 생성되었습니다.
//클래스 생성순서는 3번째가 생성되었습니다.
//3
//3
