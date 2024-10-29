package enity;

import java.io.Serializable;
import java.util.Objects;

public class Phim implements Serializable{
	private String maPhim, tenPhim, quocGia, daoDien, theLoai;
	private int namSX, thoiLuong;
	
	public Phim(String maPhim) {
		this.maPhim = maPhim;
	}
	public Phim(String maPhim, String tenPhim, String quocGia, String daoDien, int namSX,
			int thoiLuong, String theLoai) {
		super();
		this.maPhim = maPhim;
		this.tenPhim = tenPhim;
		this.quocGia = quocGia;
		this.daoDien = daoDien;
		this.theLoai = theLoai;
		this.namSX = namSX;
		this.thoiLuong = thoiLuong;
	}
	
	public String getMaPhim() {
		return maPhim;
	}

	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}

	public String getTenPhim() {
		return tenPhim;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}

	public String getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}

	public String getDaoDien() {
		return daoDien;
	}

	public void setDaoDien(String daoDien) {
		this.daoDien = daoDien;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public int getNamSX() {
		return namSX;
	}

	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}

	public int getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhim);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Phim other = (Phim) obj;
		return Objects.equals(maPhim, other.maPhim);
	}

	@Override
	public String toString() {
		return "Phim [maPhim=" + maPhim + ", tenPhim=" + tenPhim + ", quocGia=" + quocGia + ", daoDien=" + daoDien
				+ ", thoiLuong=" + thoiLuong + ", namSX=" + namSX + ", theLoai=" + theLoai + "]";
	}

	

	
}
