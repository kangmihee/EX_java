package swingTest;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class EX_GUI_Sungjuk extends JFrame implements ActionListener {
	JFrame f = new JFrame("성적 관리프로그램");
	DefaultTableModel model; 
	JTable table;
	
	JLabel name = new JLabel("이름", JLabel.CENTER);
	JLabel kor = new JLabel("국어 점수", JLabel.CENTER);
	JLabel eng = new JLabel("영어 점수", JLabel.CENTER);
	JLabel mat = new JLabel("수학 점수", JLabel.CENTER);
	
	JTextField tfname = new JTextField();
	JTextField tfkor = new JTextField();
	JTextField tfeng = new JTextField();
	JTextField tfmat = new JTextField();
	
	JButton insertbutton = new JButton("추가");
	JButton deletebutton = new JButton("제거");
	JButton udatebutton = new JButton("수정");

	public EX_GUI_Sungjuk() {
		setLayout(null);
		String columnNames[] = {"이름", "국어", "영어", "수학", "총점", "평균"};
		
		model = new DefaultTableModel(columnNames,0);
		table = new JTable(model);
		
		JScrollPane scroll = new JScrollPane(table);
	
		name.setBounds(10, 10, 120, 50);
		kor.setBounds(10, 70, 120, 50);
		eng.setBounds(10, 130, 120, 50);
		mat.setBounds(10, 190, 120, 50);
		
		tfname.setBounds(140, 10, 120, 50);
		tfkor.setBounds(140, 70, 120, 50);
		tfeng.setBounds(140, 130, 120, 50);
		tfmat.setBounds(140, 190, 120, 50);
		
		insertbutton.setBounds(270, 10, 120, 50);
		deletebutton.setBounds(270, 70, 120, 50);
		udatebutton.setBounds(270, 130, 120, 50);

	    scroll.setBounds(415, 10, 770, 250);
		
		add(name); add(kor); add(eng); add(mat);
		add(tfname); add(tfkor); add(tfeng); add(tfmat);
		add(insertbutton); add(deletebutton); add(udatebutton);
		add(scroll);
		
		insertbutton.addActionListener(this);	
		deletebutton.addActionListener(this);	
		udatebutton.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==insertbutton) {
			set();
		}
		if(e.getSource()==deletebutton) {
			remove();
		}
		if(e.getSource()==udatebutton) {
			update();
		}
	}
	
	// 추가
	public void set() {
		String insertinto[] = new String[6];
		String name = tfname.getText();
		String kor = tfkor.getText();
		String eng = tfeng.getText();
		String mat = tfmat.getText();
		int total = Integer.parseInt(kor) +Integer.parseInt(eng)+Integer.parseInt(mat);
		float ave = total / 3;
		
		insertinto[0] =  name;
		insertinto[1] =  kor;
		insertinto[2] =  eng;
		insertinto[3] =  mat;
		insertinto[4] =  total+"";
		insertinto[5] =  ave+"";
		
		model.addRow(insertinto);
	
		tfname.setText("");
		tfkor.setText("");
		tfeng.setText("");
		tfmat.setText("");
	}
	
	// 제거
	public void remove() {
		model.removeRow(table.getSelectedRow());	
	}
	
	// 수정
	public void update() {
		String kor = tfkor.getText();
		String eng = tfeng.getText();
		String mat = tfmat.getText();
		int total = Integer.parseInt(kor) +Integer.parseInt(eng)+Integer.parseInt(mat);
		float ave = total / 3;
		
		int selection = table.getSelectedRow();	
		
		model.setValueAt(tfname.getText(), selection, 0);
		model.setValueAt(kor, selection, 1);
		model.setValueAt(eng, selection, 2);
		model.setValueAt(mat, selection, 3);
		model.setValueAt(total, selection, 4);
		model.setValueAt(ave, selection, 5);
	}
	
	

	public static void main(String[] args) {
		EX_GUI_Sungjuk gui_sj = new EX_GUI_Sungjuk();
		gui_sj.pack();
		gui_sj.setSize(1250,400);
		gui_sj.setVisible(true);
	}
}
