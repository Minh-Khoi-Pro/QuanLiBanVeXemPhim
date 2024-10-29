package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import enity.Phim;

public class Phim_DAO implements Serializable{
	public Phim_DAO() {
		
	}
	
	public ArrayList<Phim> getAllPhim(){
		ArrayList<Phim> dsPhim = new ArrayList<Phim>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from PHIM";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				String maPhim = rs.getString(1);
				String tenPhim = rs.getString(2);
				String quocGia = rs.getString(3);
				String daoDien = rs.getString(4);
				int namSX = rs.getInt(5);
				int thoiLuong = rs.getInt(6);
				String theLoai = rs.getString(7);
				Phim phim = new Phim(maPhim, tenPhim, quocGia, daoDien, namSX, thoiLuong, theLoai);
				dsPhim.add(phim);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhim;
	}
	
	public boolean create(Phim phim) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Insert into Phim values (?,?,?,?,?,?,?)");
			stmt.setString(1,  phim.getMaPhim());
			stmt.setString(2, phim.getTenPhim());
			stmt.setString(3, phim.getQuocGia());
			stmt.setString(4, phim.getDaoDien());
			stmt.setInt(5, phim.getNamSX());
			stmt.setInt(6, phim.getThoiLuong());
			stmt.setString(7,  phim.getTheLoai());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	
	public boolean remove(Phim phim) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from Phim where MaPhim = ?");
			stmt.setString(1, phim.getMaPhim());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	
}
