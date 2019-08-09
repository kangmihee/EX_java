package swingTest;
import javax.swing.*;


public class JTableTest {
	JFrame f;
	JTable j;
	{
		f = new JFrame();
		f.setTitle("JFrame 예");
		String[][] data = { // 데이터 배열
				{"오영생", "1011", "Deep Learning"},
				{"초기본", "6014", "IT"}
		};
		String[] columsNmaes = {"성명", "사원번호", "부서"};
		
		JButton inserttbutton = new JButton("추가");
		inserttbutton.setBounds(80, 40, 100, 100);
		
		f.add(inserttbutton);
		
		
		j = new JTable(data, columsNmaes);
		j.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(j); // 데이터가 많아지면 자동으로 스크롤 생김
		f.add(sp);
		f.setSize(500, 200);
		f.setVisible(true);	
	}

	public static void main(String[] args) {
		new JTableTest();
	}
}
