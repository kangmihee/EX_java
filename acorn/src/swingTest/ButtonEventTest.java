package swingTest;
import java.awt.event.*;
import javax.swing.*;

public class ButtonEventTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("버튼연습"); // 프레임창을 얻음
		
		// 컴포넌트간 통신 : 이벤트에 의해 이루어짐 
		final JTextField tf = new JTextField(); // 텍스트입력 컴포넌트
		tf.setBounds(50, 50, 150, 20); // 위치와 크기지정
		JButton b = new JButton("버튼");
		b.setBounds(50, 100, 95, 30);
		
		// 리스너 추가 : 받을 이벤트를 지정
		b.addActionListener(new ActionListener(){ // 무명 클래스
			// ActionListener 이벤트 객체 : 이벤트 종류
			// 자동으로 이벤트 펌핑됨(Queue에서 보내는 정보)
			public void actionPerformed(ActionEvent e) { // 이벤트객체를 받아 실행
				tf.setText("안녕하세요 여러분,");  
				
			}
		});
		f.add(b);
		f.add(tf);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
	}
}
