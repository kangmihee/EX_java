package swingTest;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 문제: IT시험테스트를 보려고 한다. 3문제
// 1) 다음 중 데이터 타입이 아닌것은? 
// 		1.Float    2.Boolean   3.Char     4.println
// 2) 여러개의 유형의 데이터를 하나의 변수로 받고 싶다. 이럴 때 필요한 개념은?
// 		1. class   2. 상속     3. lambda   4. fileio
// 3) GUI 프로그래밍인 Swing에서 Componemt간 메시지 교환을 수단은?
// 		1. Button   2. Dialog  3. lable   4. Event

public class EX_ITtest extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	int count=0; int current=0;
	JLabel question = new JLabel("1) 다음 중 데이터 타입이 아닌것은? ");
	ButtonGroup group = new ButtonGroup();
	JRadioButton pro1 = new JRadioButton("Float");
	JRadioButton pro2 = new JRadioButton("Boolean");
	JRadioButton pro3 = new JRadioButton("Char");
	JRadioButton pro4 = new JRadioButton("println");
	JRadioButton pro5 = new JRadioButton("println"); // 화면에는 안보이고 선택
	
	JButton nextbutton = new JButton("다음문제");
	
	public EX_ITtest() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		nextbutton.addActionListener(this);	
		group.add(pro1);  // 한가지만 선택하기 위해서
		group.add(pro2); 
		group.add(pro3);  
		group.add(pro4);	
		group.add(pro5);
		Box b1 = Box.createVerticalBox(); // 하나의 덩어리로 출력
		b1.add(pro1);  
		b1.add(pro2);  
		b1.add(pro3);  
		b1.add(pro4);
		
		Container contentPane = this.getContentPane();
		contentPane.add(question, BorderLayout.NORTH);
		contentPane.add(b1, BorderLayout.CENTER);
		contentPane.add(nextbutton, BorderLayout.SOUTH);
	} 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==nextbutton) {
			if(check()) // 채점
				count=count+1;
			current++;
			set(); // 문제 변경
			if(current==2){
				nextbutton.setText("Result"); // 버튼 이름을 변경
			}
			if(current==3) {
				System.out.print("맞은 점수는" + count);
			}
		}
	}
	
	boolean check() {
		if(current==0) return(pro4.isSelected());
		if(current==1) return(pro2.isSelected());
		if(current==2) return(pro4.isSelected());
		else return false;
	}
	
	public void set() {
		pro5.setSelected(true);
		if(current ==0) {
			question.setText("1) 다음 중 데이터 타입이 아닌것은? ");
			pro1.setText("Float");
			pro2.setText("Boolean");
			pro3.setText("Char");
			pro4.setText("println");
		}
		if(current ==1) {
			question.setText("2) 여러개의 유형의 데이터를 하나의 변수로 받고 싶다. 이럴 때 필요한 개념은?");
			pro1.setText("class");
			pro2.setText("상속");
			pro3.setText("lambda");
			pro4.setText("fileio");
		}
		if(current ==2) {
			question.setText("3) GUI 프로그래밍인 Swing에서 Componemt간 메시지 교환을 수단은?");
			pro1.setText("Button");
			pro2.setText("Dialog");
			pro3.setText("lable");
			pro4.setText("Event");
		}
	}

	public static void main(String[] args) {
		EX_ITtest bf = new EX_ITtest();
		bf.pack();
		bf.setVisible(true);
	}
}
