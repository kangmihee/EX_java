package Model_view_con_ex;
import java.sql.*;
import java.util.*;
import jdbc_test.*;
import oracle.jdbc.*;

public class EX_Model {
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int total;
	private float avr;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public float getAvr() {
		return avr;
	}
	public void setAvr(float avr) {
		this.avr = avr;
	}
}
