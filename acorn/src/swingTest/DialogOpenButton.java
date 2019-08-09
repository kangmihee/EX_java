package swingTest;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.AncestorListener;

public class DialogOpenButton {
	DialogOpenButton(){
		JFrame f = new JFrame("다이얼로그창 띄우기");
		JButton b = new JButton(new ImageIcon("D:\\은우.jpg"));
		b.setBounds(10, 10, 490, 590);
		b.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				new DialogOpen();
				}
			});
		f.add(b);
		f.setSize(600,700);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new DialogOpenButton();

	}
}