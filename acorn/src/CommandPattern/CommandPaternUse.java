package CommandPattern;

// Command Pattern : 명령어를 실행하는 것이 목적
// 함수를 class화 한다.
// 구조를 보이기 위해 Document의 Command를 호출하기 위해서 
// 중간단계에서 인터페이스를 이용해서 함수를 class화 해서 작동
// 행동이 추가될 경우 class를 만들어서 전달해 주면됨 
// 행동이 추가되는 경우 : 행동 클래스를 생성해서 전달해주면 중간단계 프로그램 변화없이 추가가 가능함
// 구조를 바꾸지 않는다는것은 함수이름이 같기 때문에
// inheritance(상속관계) : 코드공유, 약속공유
// association(포함관계) : 구성물로 생성ㄱ하 종료를 책임지는 관계
// reference(참조관계) : 외부의 클래스를 참조해서 사용
// dependency(종속) : 외부의 클래스의 함수를 호출하는 관계

public class CommandPaternUse {
	public static void main(String[] args) {
		
		Document doc = new Document(); // 문서
		
		// 인터페이스
		ActionListernerCommand clickOpen = new ActionOpen(doc);
		
		//ActionListernerCommand clickSave = new ActionSave(doc);
		// 저장하는 방법의 추가 => 클래스만 생성 추가
		ActionListernerCommand clickSave = new ActionWrite(doc);
			
		// 메뉴옵션을 인터페이스 초기화
		MenuOptions menu = new MenuOptions(clickOpen, clickSave);
		menu.ClickOpen();
		menu.ClickSave();
	}
}

//결과출력:
//Document Opened
//Document Saved

// 주석처리후, ActionWrite의 함수 save로 주고 결과:
//Document Opened
//Document Saved

