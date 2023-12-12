package com.java.tm;

import java.sql.*;
import java.util.ArrayList;

public class TacticsDAO {
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3307/stmp";
	static String dbId = "root";
	static String dbPw = "1234";
	
	Connection conn = null;
	
	public ArrayList<String> getPlayerName() {
		this.dbConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<String> name = new ArrayList<String>();
		name.add("선수를 선택하세요.");
	    try {
	      String sql = "select name from player order by backNum asc";
	      pst = conn.prepareStatement(sql);
	      rs = pst.executeQuery();
	 
	      while (rs.next()) {
			name.add(rs.getString("name"));
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
			this.closeRs(rs);
			this.closePst(pst);
			this.closeDB(conn);
		}
	    return name;
	}
	
	public ArrayList<String> getTacticsName(String category) {
		this.dbConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<String> name = new ArrayList<String>();
		if(category.equals("del")) {
			name.add("삭제할 전술을 선택하세요.");

		} else if(category.equals("intro")) {
			name.add("소개할 전술을 선택하세요.");
		} else if(category.equals("load")) {
			name.add("불러올 전술을 선택하세요.");
		} else {
			name.add("");
		}
	    try {
	      String sql = "select name from tactics order by name asc";
	      pst = conn.prepareStatement(sql);
	      rs = pst.executeQuery();
	 
	      while (rs.next()) {
			name.add(rs.getString("name"));
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
			this.closeRs(rs);
			this.closePst(pst);
			this.closeDB(conn);
		}
	    return name;
	}
	
	public boolean duplicateCheck(String name) {
		this.dbConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean result = false;
		
		try {
			String sql = "select count(*) cnt from tactics where name = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
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
	
	public boolean addTactics(TacticsDTO tacticsDTO) {
		this.dbConn();
		boolean result = true;
		PreparedStatement pst = null;
		try {
			conn.setAutoCommit(false);
			String sql = "insert into tactics values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, tacticsDTO.getName());
			pst.setString(2, tacticsDTO.getFormation());
			pst.setString(3, tacticsDTO.getP1());
			pst.setString(4, tacticsDTO.getP1_t());
			pst.setString(5, tacticsDTO.getP2());
			pst.setString(6, tacticsDTO.getP2_t());
			pst.setString(7, tacticsDTO.getP3());
			pst.setString(8, tacticsDTO.getP3_t());
			pst.setString(9, tacticsDTO.getP4());
			pst.setString(10, tacticsDTO.getP4_t());
			pst.setString(11, tacticsDTO.getP5());
			pst.setString(12, tacticsDTO.getP5_t());
			pst.setString(13, tacticsDTO.getP6());
			pst.setString(14, tacticsDTO.getP6_t());
			pst.setString(15, tacticsDTO.getP7());
			pst.setString(16, tacticsDTO.getP7_t());
			pst.setString(17, tacticsDTO.getP8());
			pst.setString(18, tacticsDTO.getP8_t());
			pst.setString(19, tacticsDTO.getP9());
			pst.setString(20, tacticsDTO.getP9_t());
			pst.setString(21, tacticsDTO.getP10());
			pst.setString(22, tacticsDTO.getP10_t());
			pst.setString(23, tacticsDTO.getP11());
			pst.setString(24, tacticsDTO.getP11_t());
			pst.setString(25, tacticsDTO.getComment());
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
		
	public boolean updateTactics(TacticsDTO tacticsDTO) {
		this.dbConn();
		PreparedStatement pst = null;
		boolean result = true;
		try {
			conn.setAutoCommit(false);
			String sql = "update tactics set formation=?, p1=?, p1_t=?, p2=?, p2_t=?, p3=?, p3_t=?, p4=?, p4_t=?, p5=?, p5_t=?,"
														   + " p6=?, p6_t=?, p7=?, p7_t=?, p8=?, p8_t=?, p9=?, p9_t=?, p10=?, p10_t=?,"
														   + " p11=?, p11_t=?, comment=? where name=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, tacticsDTO.getFormation());
			pst.setString(2, tacticsDTO.getP1());
			pst.setString(3, tacticsDTO.getP1_t());
			pst.setString(4, tacticsDTO.getP2());
			pst.setString(5, tacticsDTO.getP2_t());
			pst.setString(6, tacticsDTO.getP3());
			pst.setString(7, tacticsDTO.getP3_t());
			pst.setString(8, tacticsDTO.getP4());
			pst.setString(9, tacticsDTO.getP4_t());
			pst.setString(10, tacticsDTO.getP5());
			pst.setString(11, tacticsDTO.getP5_t());
			pst.setString(12, tacticsDTO.getP6());
			pst.setString(13, tacticsDTO.getP6_t());
			pst.setString(14, tacticsDTO.getP7());
			pst.setString(15, tacticsDTO.getP7_t());
			pst.setString(16, tacticsDTO.getP8());
			pst.setString(17, tacticsDTO.getP8_t());
			pst.setString(18, tacticsDTO.getP9());
			pst.setString(19, tacticsDTO.getP9_t());
			pst.setString(20, tacticsDTO.getP10());
			pst.setString(21, tacticsDTO.getP10_t());
			pst.setString(22, tacticsDTO.getP11());
			pst.setString(23, tacticsDTO.getP11_t());
			pst.setString(24, tacticsDTO.getComment());
			pst.setString(25, tacticsDTO.getName());
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
	
	public boolean delTactics(String name) {
		this.dbConn();
		boolean result = true;
		try {
			conn.setAutoCommit(false);
			String sql = "delete from tactics where name = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);
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
			this.closeDB(conn);
		}
		return result;
	}
	
	public TacticsDTO loadTactics(String name) {
		this.dbConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		TacticsDTO tactics = null;
		try {
			String sql = "select * from tactics where name = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				tactics = new TacticsDTO();
				tactics.setName(rs.getString("name"));
				tactics.setFormation(rs.getString("formation"));
				tactics.setP1(rs.getString("p1")); tactics.setP1_t(rs.getString("p1_t")); 
				tactics.setP2(rs.getString("p2")); tactics.setP2_t(rs.getString("p2_t")); 
				tactics.setP3(rs.getString("p3")); tactics.setP3_t(rs.getString("p3_t")); 
				tactics.setP4(rs.getString("p4")); tactics.setP4_t(rs.getString("p4_t")); 
				tactics.setP5(rs.getString("p5")); tactics.setP5_t(rs.getString("p5_t")); 
				tactics.setP6(rs.getString("p6")); tactics.setP6_t(rs.getString("p6_t")); 
				tactics.setP7(rs.getString("p7")); tactics.setP7_t(rs.getString("p7_t")); 
				tactics.setP8(rs.getString("p8")); tactics.setP8_t(rs.getString("p8_t")); 
				tactics.setP9(rs.getString("p9")); tactics.setP9_t(rs.getString("p9_t")); 
				tactics.setP10(rs.getString("p10")); tactics.setP10_t(rs.getString("p10_t")); 
				tactics.setP11(rs.getString("p11")); tactics.setP11_t(rs.getString("p11_t"));
				tactics.setComment(rs.getString("comment"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closePst(pst);
			this.closeRs(rs);
			this.closeDB(conn);
		}
		try {
			return tactics;
		} catch (Exception e) {
			return null;
		}
	}
	
	private void dbConn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
		} catch (Exception e) {
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
