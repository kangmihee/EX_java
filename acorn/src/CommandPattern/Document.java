package CommandPattern;
// Command는 함수를 class화 하자

public class Document {
	
	public void open() {
		System.out.println("Document Opened");
	}
	public void save() {
		System.out.println("Document Saved");
	}
}
