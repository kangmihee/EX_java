package swingTest;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTests {
	private static JDialog d;
	DialogTests(){
		JFrame f= new JFrame();
		d = new JDialog(f, "Dialog연습", true);
		// 위치 지정없이 즉 setBound없이 자동배치
		d.setLayout(new FlowLayout()); // 레이아웃 : 자동배치 : 순서대로 정렬
		
		JButton b = new JButton("OK");
		b.addActionListener(new ActionListener() 
		{ @Override
			public void actionPerformed(ActionEvent e) {
				DialogTests.d.setVisible(false);
			}
		});
		JButton b2 = new JButton("새로운 버튼");
		d.add(new JLabel("클릭시 다음 작업"));
		d.add(b);
		d.add(b2); // 버튼b 옆에 자동 배치 (setLayout(new FlowLayout())
		d.setSize(300, 300);
		d.setVisible(true); // 다이얼로그 출력
	}
	
	public static void main(String[] args) {
		new DialogTests();
	}
}
