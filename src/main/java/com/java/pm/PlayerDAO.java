package com.java.pm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class PlayerDAO {
	static String driver = "org.sqlite.JDBC";
	static String url = "jdbc:sqlite:stmp.db";
	
	Connection conn = null;
	
	//등 번호 중복 체크
	public boolean duplicateCheck(int backNum) {
		this.dbConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean result = false;
		
		try {
			String sql = "select count(*) cnt from player where backNum = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, backNum);
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
	
	//선수 추가
	public boolean addPlayer(PlayerDTO playerDTO) {
		this.dbConn();
		boolean result = true;
		PreparedStatement pst = null;
		try {
			conn.setAutoCommit(false);
			String sql = "insert into player values (?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, playerDTO.getBackNum());
			pst.setString(2, playerDTO.getPos());
			pst.setString(3, playerDTO.getName());
			pst.setString(4, playerDTO.getBirth());
			pst.setString(5, playerDTO.getNationality());
			pst.setInt(6, playerDTO.getHeight());
			pst.setInt(7, playerDTO.getWeight());
			pst.setString(8, playerDTO.getComment());
			
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
	
	//선수 확인 후 데이터 추출 (등번호로 찾기)
	public PlayerDTO confirmPlayer(int backNum) {
		this.dbConn();
		List<PlayerDTO> list = new ArrayList<PlayerDTO>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from player where backNum = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, backNum);
			rs = pst.executeQuery();
			while (rs.next()) {
				PlayerDTO playerDTO = new PlayerDTO();
				playerDTO.setBackNum(rs.getInt("backNum"));
				playerDTO.setPos(rs.getString("pos"));
				playerDTO.setName(rs.getString("name"));
				playerDTO.setBirth(rs.getString("birth"));
				playerDTO.setNationality(rs.getString("nationality"));
				playerDTO.setHeight(rs.getInt("height"));
				playerDTO.setWeight(rs.getInt("weight"));
				playerDTO.setComment(rs.getString("comment"));
				list.add(playerDTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			this.closeRs(rs);
			this.closePst(pst);
			this.closeDB(conn);
		}
		return list.get(0);
	}
	public PlayerDTO confirmPlayer(String name) {
		this.dbConn();
		List<PlayerDTO> list = new ArrayList<PlayerDTO>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from player where name = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				PlayerDTO playerDTO = new PlayerDTO();
				playerDTO.setBackNum(rs.getInt("backNum"));
				playerDTO.setPos(rs.getString("pos"));
				playerDTO.setName(rs.getString("name"));
				playerDTO.setBirth(rs.getString("birth"));
				playerDTO.setNationality(rs.getString("nationality"));
				playerDTO.setHeight(rs.getInt("height"));
				playerDTO.setWeight(rs.getInt("weight"));
				playerDTO.setComment(rs.getString("comment"));
				list.add(playerDTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			this.closeRs(rs);
			this.closePst(pst);
			this.closeDB(conn);
		}
		return list.get(0);
	}
	
	public boolean updatePlayer(PlayerDTO playerDTO) {
		this.dbConn();
		PreparedStatement pst = null;
		boolean result = true;
		try {
			conn.setAutoCommit(false);
			String sql = "update player set pos=?, name=?, birth=?, nationality=?, height=?, weight=?, comment=? where backNum=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, playerDTO.getPos());
			pst.setString(2, playerDTO.getName());
			pst.setString(3, playerDTO.getBirth());
			pst.setString(4, playerDTO.getNationality());
			pst.setInt(5, playerDTO.getHeight());
			pst.setInt(6, playerDTO.getWeight());
			pst.setString(7, playerDTO.getComment());
			pst.setInt(8, playerDTO.getBackNum());
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
	
	public boolean deletePlayer(int backNum) {
		this.dbConn();
		boolean result = true;
		try {
			conn.setAutoCommit(false);
			String sql = "delete from player where backNum = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, backNum);
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
	
	public Vector getPlayer() {
		this.dbConn();
		Vector data = new Vector();
		PreparedStatement pst = null;
		ResultSet rs = null;
	    try {
	      String sql = "select * from player order by backNum asc";
	      pst = conn.prepareStatement(sql);
	      rs = pst.executeQuery();
	 
	      while (rs.next()) {
			String backNum = rs.getString("backNum");
			String pos = rs.getString("pos");
			String name = rs.getString("name");
			String birth = rs.getString("birth");
			String nationality = rs.getString("nationality");
			String height = rs.getString("height");
			String weight = rs.getString("weight");
			String comment = rs.getString("comment");
			
			Vector row = new Vector();
			row.add(backNum);
			row.add(pos);
			row.add(name);
			row.add(birth);
			row.add(nationality);
			row.add(height);
			row.add(weight);
			row.add(comment);
			
			data.add(row);
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
			this.closeRs(rs);
			this.closePst(pst);
			this.closeDB(conn);
		}

	    return data;
	}
	
	private void dbConn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
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
