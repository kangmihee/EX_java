package swingTest;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 당신의 성별은 이라는 라벨 추가
public class RadioButtonSimple extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	ButtonGroup  genderGroup   = new ButtonGroup();
	JRadioButton genderMale    = new JRadioButton("남");
	JRadioButton genderFemale  = new JRadioButton("여");
	JRadioButton genderUnknown = new JRadioButton("불상"); 
	JLabel genderlable = new JLabel("당신의 성별은?");
	
	public RadioButtonSimple() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		genderGroup.add(genderMale);
		genderGroup.add(genderFemale);
		genderGroup.add(genderUnknown);
		
		genderMale.addActionListener(this);
		genderFemale.addActionListener(this);
		genderUnknown.addActionListener(this);
		
		Box b1 = Box.createVerticalBox();
		b1.add(genderMale);
		b1.add(genderFemale);
		b1.add(genderUnknown);
		
		Container contentPane = this.getContentPane();
		contentPane.add(b1, BorderLayout.CENTER);
		contentPane.add(genderlable, BorderLayout.NORTH);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 라디오버튼은 isSelected 를 통해 on/off 확인 가능
			System.out.println(e.getSource());
			System.out.println(e.getActionCommand());
			System.out.println(e.paramString());
			if(genderMale.isSelected())
				System.out.println("남자");
			else if(genderFemale.isSelected())
				System.out.println("여자");
			else if(genderUnknown.isSelected())
				System.out.println("모름");	
	}

	public static void main(String[] args) {
		RadioButtonSimple bf = new RadioButtonSimple();
		bf.pack();
		bf.setVisible(true);	
	}
}
