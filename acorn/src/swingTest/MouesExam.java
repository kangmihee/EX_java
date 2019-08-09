package swingTest;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent; // 이벤트 객체
import java.awt.event.MouseListener; // 리스너는 component 에 달림
import java.awt.event.MouseMotionListener; 
// 리스너 : 

public class MouesExam extends JFrame implements MouseMotionListener, MouseListener{ 
	JLabel lable = new JLabel("마우스 드래그");
	JTextField jtextfiled = new JTextField();
	public MouesExam() {
		this.add(lable, "North");
		this.add(jtextfiled, "South");
		this.setSize(300, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}	
	public static void main(String[] args) {
		new MouesExam();
	}
		@Override
		public void mouseClicked(MouseEvent e) {} // MouseListener
		@Override
		public void mouseMoved(MouseEvent e) {}		
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseDragged(MouseEvent e) { // MotionEvent...
			jtextfiled.setText("(" + e.getX() + ", " + e.getY() + ")");} //이벤트 객체
		@Override
		public void mouseEntered(MouseEvent e) {
			jtextfiled.setText("마우스 안쪽?");}
		@Override
		public void mouseExited(MouseEvent e) {
			jtextfiled.setText("마우스 바깥쪽?");}
}
