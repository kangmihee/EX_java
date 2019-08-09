package com.member;

import java.sql.Connection; // 연결
import java.sql.PreparedStatement; // 쿼리실행
import java.sql.ResultSet; // 쿼리결과
import java.util.ArrayList; // 데이터 배열 처리
import java.util.List;// ArrayList의 부모 : 부모는 자식을 품을 수 없다.

import com.member.MemberDto;


// singleton => 1번만 인스턴스
// MemberDao a = new MemberDao(); -> (인스턴스)불가능
public class MemberDao { // DB에 접속해서 쿼리를 실행하는 business logic (절차순서)
	private static MemberDao dao; // 공용변수
	private MemberDao() {} // 디폴트 생성자
	public static MemberDao getInstance() {
		if(dao==null) {
			dao= new MemberDao();
		}
		return dao;
	}
	
	public boolean insert(MemberDto dto) { // 성공/실패
		// connection 객체 -> statement 얻고 -> 쿼리문 준비 -> 실행
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false; // 기본이 실패
		
		try { // 예외처리는 프로그램은 계속되어야 한다.
			conn = new DBConnect().getConn();
			
			// DB에 시퀀스 생성 -> create sequence member_seq;
			String sql = "INSERT INTO member (num,name,addr)" + "VALUES(member_seq.NEXTVAL,?,?)"; 
			
			pstmt = conn.prepareStatement(sql); // 쿼리 실행 객체 생성
			pstmt.setString(1, dto.getName()); // 매게변수 등록
			pstmt.setString(2, dto.getAddr());
			// 객체 지향  프로그래밍은 내부 은닉
			// 실행하는 방법 그리고 리턴값만 확인
			int flag = pstmt.executeUpdate(); // DB에서 변화되어진 행수
			if(flag>0) {
				isSuccess = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally { // 무조건 한번은 실행
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {}
		}
		return isSuccess;
	}
	public List<MemberDto> getList(){
		Connection conn = null;
		PreparedStatement pstmt = null; // sql실행
		ResultSet rs = null; // select 의 결과물
		List<MemberDto> list = new ArrayList<MemberDto>();
		try {
			conn = new DBConnect().getConn(); // db연결
			String sql = "SELECT num, name, addr FROM member ORDER BY num DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				MemberDto dto = new MemberDto(num, name, addr);
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {}
		}
		return list;
	}
	public MemberDto getData(int num) {
		Connection conn = null; // 연결 point
		PreparedStatement pstmt = null; // 쿼리문 수행
		ResultSet rs = null; // 수행
		MemberDto dto = null; // 레코드 셀이 변환된 클래스
		try {
			conn = new DBConnect().getConn();
			String sql = "SELECT name, addr FROM member WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				dto = new MemberDto(num, name, addr);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {}
			}
			return dto;
		}
	
	public boolean upDate(MemberDto dto) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      boolean isSuccess = false;
	      try {
	         conn = new DBConnect().getConn();
	         String sql = "UPDATE member SET name=? ,addr=? WHERE num=? ";
	         pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getName());
				pstmt.setString(2, dto.getAddr());
				pstmt.setInt(3,  dto.getNum());
	         int flag = pstmt.executeUpdate();
	         if (flag > 0) {
	            isSuccess = true;
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if(pstmt!=null) pstmt.close();
	            if(conn!=null) conn.close();
	         } catch (Exception e) {}
	      }
	      return isSuccess;
	   }
	
	public boolean delete(int num) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean isSuccess = false;
        try {
           conn = new DBConnect().getConn();
           String sql = "DELETE FROM member WHERE NUM=?";
           pstmt = conn.prepareStatement(sql);
           pstmt.setInt(1,  num);
           int flag = pstmt.executeUpdate();
           if (flag > 0) {
              isSuccess = true;
           }
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
           try {
              if (pstmt != null) pstmt.close();
              if (conn != null) conn.close();
           } catch (Exception e) {}
        }
        return isSuccess;
     }
}
























