package com.GuestBoard;

import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.ArrayList; 
import java.util.List;

import com.GuestBoard.DBConnect;
import com.GuestBoard.GuestDto;

public class GuestDao {
	private static GuestDao dao;  
	private GuestDao() {} 
	public static GuestDao getInstance() {
		if(dao==null) {
			dao= new GuestDao();
		}
		return dao;
	}
	
	public List<GuestDto> getList(){
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		List<GuestDto> list = new ArrayList<GuestDto>();
		try {
			conn = new DBConnect().getConn(); 
			String sql = "SELECT num, writer, title, content, regdate FROM borad ORDER BY num DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String regdate = rs.getString("regdate");
				
				GuestDto dto = new GuestDto(num, writer, title,content,regdate);
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

	
	public boolean insert(GuestDto dto) { 
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false; 
		
		try { 
			conn = new DBConnect().getConn();
			String sql = "INSERT INTO borad (num,writer,title,content,regdate)" + "VALUES(borad_seq.NEXTVAL,?,?,?,?)"; 
			
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, dto.getWriter()); 
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getRegdate());
			
			int flag = pstmt.executeUpdate();
			if(flag>0) {
				isSuccess = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally { 
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {}
		}
		return isSuccess;
	}
	public GuestDto getData(int num) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      GuestDto dto = null;
	      try {
	         conn = new DBConnect().getConn();
	         String sql = "SELECT writer, title, content, regdate FROM borad WHERE num=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, num);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            String writer = rs.getString("writer");
	            String title = rs.getString("title");
	            String content = rs.getString("content");
	            String regdate = rs.getString("regdate");
	            dto = new GuestDto(num, writer, title, content, regdate);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if(rs!=null) rs.close();
	            if(pstmt!=null) pstmt.close();
	            if(conn!=null) conn.close();
	         } catch (Exception e) {}
	      }
	      return dto;
	   }
	
	public boolean update(GuestDto dto) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      boolean isSuccess = false;
	      try {
	         conn = new DBConnect().getConn();
	         String sql = "UPDATE borad SET writer=?, title=?, content=?, regdate=? WHERE num=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, dto.getWriter());
	         pstmt.setString(2, dto.getTitle());
	         pstmt.setString(3, dto.getContent());
	         pstmt.setString(4, dto.getRegdate());;
	         pstmt.setInt(5, dto.getNum());
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
           String sql = "DELETE FROM borad WHERE NUM=?";
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
