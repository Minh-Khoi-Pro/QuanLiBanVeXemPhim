package dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import enity.Phim;

public class Phim_DAO implements Serializable{
	public Phim_DAO() {
		
	}
	
	public ArrayList<Phim> getAllPhim() {
	    ArrayList<Phim> dsPhim = new ArrayList<Phim>();
	    Connection con = null;
	    CallableStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        ConnectDB.getInstance();
	        con = ConnectDB.getConnection();
	        
	        // Gọi Stored Procedure
	        stmt = con.prepareCall("{CALL GetAllPhim()}");
	        
	        // Thực hiện câu lệnh và lấy kết quả
	        rs = stmt.executeQuery();

	        while (rs.next()) {
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
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng kết nối và các đối tượng liên quan
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return dsPhim;
	}

	
	public boolean create(Phim phim) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
		int n = 0;
		try {
//			stmt = con.prepareStatement("Insert into Phim values (?,?,?,?,?,?,?)");
			CallableStatement stmt = con.prepareCall("{Call AddPhim(?, ?, ?, ?, ?, ?, ?)}");
			stmt.setString(1,  phim.getMaPhim());
			stmt.setString(2, phim.getTenPhim());
			stmt.setString(3, phim.getQuocGia());
			stmt.setString(4, phim.getDaoDien());
			stmt.setInt(5, phim.getNamSX());
			stmt.setInt(6, phim.getThoiLuong());
			stmt.setString(7,  phim.getTheLoai());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, this, "Lỗi" + e.getMessage(), n);
		}
		finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		}
		return n > 0;
	}
	
	public boolean remove(Phim phim) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
		int n = 0;
		try {
			CallableStatement stmt = con.prepareCall("{Call DeletePhim(?)}");
			stmt.setString(1, phim.getMaPhim());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	
	public boolean updatePhim(Phim phim) {
        // Kết nối đến cơ sở dữ liệu
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        boolean isUpdated = false;
        
        // Khai báo CallableStatement
        CallableStatement stmt = null;
        try {
            // Chuẩn bị gọi stored procedure
            stmt = con.prepareCall("{Call UpdatePhim(?, ?, ?, ?, ?, ?, ?)}");
            stmt.setString(1, phim.getMaPhim());
            stmt.setString(2, phim.getTenPhim());
            stmt.setString(3, phim.getQuocGia());
            stmt.setString(4, phim.getDaoDien());
            stmt.setInt(5, phim.getNamSX());
            stmt.setInt(6, phim.getThoiLuong());
            stmt.setString(7, phim.getTheLoai());
            
            // Thực hiện câu lệnh cập nhật
            int rowsAffected = stmt.executeUpdate();
            isUpdated = rowsAffected > 0; // Nếu có dòng bị ảnh hưởng, thì cập nhật thành công
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ
        } finally {
        	if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        	if (con != null) {
        		try {
        			con.close();
        		} catch (SQLException e) {
        			e.printStackTrace();
        		}
        	}
        }
        return isUpdated; // Trả về kết quả
    }
	
}
