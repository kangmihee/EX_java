package swingTest;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
// ActionListener는 actionPerformed 한가지 뿐임

public class GetSelectedValueFromList extends JFrame implements ActionListener{
	private JList list;
	private JButton button;
	
	public GetSelectedValueFromList() {
		this.getContentPane().setLayout(new FlowLayout());
		Object[] data = {"사과","딸기","수박","배","감귤"};
		list = new JList(data);
		button = new JButton("check");
		button.addActionListener(this);
		add(list);
		add(button);
	}
	private static void createAndShowGUI() {
		JFrame frame = new GetSelectedValueFromList();
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("check")) {
			int index = list.getSelectedIndex();
			System.out.println("선택된 인덱스: " + index );
			String s = (String)list.getSelectedValue();
			System.out.println("선택된 값: " +s );
		}	
	}
	public static void main(String[] args) {
		createAndShowGUI();
	}
}
