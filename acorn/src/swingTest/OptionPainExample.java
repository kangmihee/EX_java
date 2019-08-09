package swingTest;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 윈도우 어댑터를 상속 구현
// Listener는 인터페이스 

public class OptionPainExample extends WindowAdapter{
	JFrame f;
	String name;
	OptionPainExample(){
		f = new JFrame();
		
		// JOptionPane : YES or NO 를 선택하는 창 (간단한 다이얼로그)
		// 종속 되는 프레임을 지정한다.
		this.name = JOptionPane.showInputDialog(f, "Enter Name"); // showInputDialog는 f 에 종속
		System.out.println("입력한 것은 " + name); // Text mode에서 사용
		// 값을 확인할 때 사용
		f.addWindowListener(this); // 자신이 상속받아 오버라이딩한 것을 등록
		f.setSize(300, 300);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.setVisible(true);
	}
	// focus 얻을 때와 잃을 때
	// Activate 창이 화성화 되거나 비활성화 될 때 windowGainedFocus(색 진하게)/windowLostFocus(색 약하게)
	// windowClosed, windowClosing, windowOpened
	// 상태변화 : windowStateChanged

	public void WindowClosing(WindowEvent e) { // 어댑터 오버라이딩
		int a = new JOptionPane().showConfirmDialog(f, name);
		if(a == JOptionPane.YES_OPTION) { // enum현 변수 : 숫자,문자 둘다 사용가능(범주형일때 사용) 
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	public static void main(String[] args) { // 클래스 생성 -> 생성자 작동 -> 어댑터 객체도 등록
		new OptionPainExample();
	}
}
