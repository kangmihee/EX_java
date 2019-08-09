package swingTest;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
// 좌표점의 우넝점 : 좌상단 TopLeft
// 사각형 : 좌상단의 우하단점 (x,y)
// JFrame -> Panel -> JButton
// JFrame인스턴스 방식 : 상속, 클래스 내에서 멤버변수 인스턴스
public class PanelTest {
	PanelTest(){
		JFrame f = new JFrame("Panel 출력");
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 80, 200, 200); // x, y, width, height
		panel.setBackground(Color.gray); // Color.gray는 static 변수
		//컴퓨터의 컬러값 : RGB(Red, Green, Blue)-1Byte씩,  
			
		JButton b1 = new JButton("Button 1");
		b1.setBounds(50, 100, 80, 30); // x, y, width, height
		b1.setBackground(Color.yellow);
		
		JButton b2 = new JButton("Button 2");
		b2.setBounds(100, 100, 80, 30); // x, y, width, height
		b2.setBackground(Color.green);
		
		JButton b = new JButton("click");
		b.setBounds(130, 100, 100, 40); // x, y, width, height
		
		panel.add(b);
		panel.add(b1);
		panel.add(b2);
		f.add(panel);
		f.setSize(400, 400);  // 프레임의 사이즈
		f.setLayout(null); // 자동으로 컴포넌트를 배치
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		}

	public static void main(String[] args) {
		new PanelTest();
	}
}
