package com.java.login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3307/stmp";
	static String dbId = "root";
	static String dbPw = "1234";
	
	Connection conn = null;
	
	//중복 체크
	public boolean duplicateCheck(String id) {
		this.dbConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean result = false;
		
		try {
			String sql = "select count(*) cnt from user where id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				int cnt = rs.getInt("cnt");
				if(cnt > 0) result = true;
				else result = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeRs(rs);
			this.closePst(pst);
			this.closeDB(conn);
		}
		return result;
	}
	
	//회원 가입
	public boolean register(UserDTO user) {
		this.dbConn();
		boolean result = true;
		PreparedStatement pst = null;
		try {
			conn.setAutoCommit(false);
			String sql = "insert into user values (?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getId());
			pst.setString(2, user.getPw());
			pst.setString(3, user.getName());
			pst.setString(4, user.getBirth());
			pst.setString(5, user.getPhone());
			pst.setString(6, user.getEmail());
			
			if(1 == pst.executeUpdate()) {
				result = true;
			} else {
				result = false;
			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			this.closePst(pst);
			this.closeDB(conn);
		}
		return result;
	}
	
	//ID 찾기
	public String findUserId(String name, String birth) {
		this.dbConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String result = null;
		try {
			String sql = "select id from user where name=? and birth=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, birth);
			rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getString("id");
			} else {
				result = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeRs(rs);
			this.closePst(pst);
			this.closeDB(conn);
		}
		return result;
	}
	
	//PW 찾기
	public String findUserPw(String id, String phone) {
		this.dbConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String result = null;
		try {
			String sql = "select pw from user where id=? and phone=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, phone);
			rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getString("pw");
			} else {
				result = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeRs(rs);
			this.closePst(pst);
			this.closeDB(conn);
		}
		return result;
	}
	
	//로그인
	public String login(String id, String pw) {
		this.dbConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String result = null;
		try {
			String sql = "select name from user where id=? and pw=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getString("name");
			} else {
				result = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeRs(rs);
			this.closePst(pst);
			this.closeDB(conn);
		}
		return result;
	}
	
	//아이디 확인
	public UserDTO confirmUser(String id) {
		this.dbConn();
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user where id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String birth = rs.getString("birth");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				
				UserDTO dto = new UserDTO(id, pw, name, birth, phone,email);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeRs(rs);
			this.closePst(pst);
			this.closeDB(conn);
		}
		return dtos.get(0);
	}
	
	//정보 수정
	public boolean modifyUser(UserDTO userDTO) {
		this.dbConn();
		boolean result = true;
		try {
			conn.setAutoCommit(false);
			String sql = "update user set pw=?, name=?, birth=?, phone=?, email=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, userDTO.getPw());
			pst.setString(2, userDTO.getName());
			pst.setString(3, userDTO.getBirth());
			pst.setString(4, userDTO.getPhone());
			pst.setString(5, userDTO.getEmail());
			pst.setString(6, userDTO.getId());
			if(1 == pst.executeUpdate()) {
				result = true;
			} else {
				result = false;
			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return result;
	}
	
	//회원 탈퇴
	public boolean deleteUser(String id) {
		this.dbConn();
		boolean result = true;
		try {
			conn.setAutoCommit(false);
			String sql = "delete from user where id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			if(1 == pst.executeUpdate()) {
				result = true;
			} else {
				result = false;
			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return result;
	}
	
	private void dbConn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void closeRs(ResultSet rs) {
		try {
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void closePst(PreparedStatement pst) {
		try {
			if(pst != null) pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void closeDB(Connection conn) {
		try {
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}