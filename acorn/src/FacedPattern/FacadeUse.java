package FacedPattern;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Facade pattern : 구조패턴의 일종
// Management class 이용해서 배후의 복잡함을 숨긴다.
// 기본클래스 => Wrapper class 를 만들어서 사용하는 것과 같은 논리
// 인터페이스를 이용해서 약속을 공유

public class FacadeUse {
	private static int choice;
	public static void main(String[] args) throws NumberFormatException, IOException{
		do{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			choice = Integer.parseInt(br.readLine());
			ShopKeeper sk = new ShopKeeper();
			switch (choice) {
			case 1:
				sk.iphoneSale();
				break;
			case 2:
				sk.samsungSale();
				break;
			case 3:
				sk.blackberrySale();
				break;
	
			default:
				System.out.println("구입한 것이 없습니다.");
				break;
			}
		}while(choice!=4);
	}
}

//결과출력:
//1
//아이폰7  
//65000 
//2
//삼성 갤럭시9  
//135000  
//3
//블랙베리  
//55000  
//4
//구입한 것이 없습니다.

