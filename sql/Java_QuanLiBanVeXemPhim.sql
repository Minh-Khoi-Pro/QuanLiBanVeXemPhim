create database [Java_QuanLiBanVeXemPhim]

use [Java_QuanLiBanVeXemPhim]

CREATE TABLE CHITIETVEXEMPHIM (
	MaChiTiet	nvarchar (30) not null primary key,
	MaVe	nvarchar(30) not null,
	MaGhe	nvarchar(30) not null
);

CREATE TABLE PHONGCHIEUPHIM (
	MaPhong	nvarchar(30) NOT NULL,
	TenPhong	nvarchar(30) NOT NULL,
	TrangThai	TEXT NOT NULL,
	SoGhe	INTEGER NOT NULL,
	PRIMARY KEY(MaPhong)
);

CREATE TABLE GHE (
	MaGhe	nvarchar(30) NOT NULL,
	MaPhong	nvarchar(30) NOT NULL,
	PRIMARY KEY(MaGhe),
	FOREIGN KEY(MaPhong) REFERENCES PHONGCHIEUPHIM(MaPhong)
);

CREATE TABLE PHIM (
	MaPhim	nvarchar(30) NOT NULL,
	TenPhim	nvarchar(30) NOT NULL,
	QuocGia	nvarchar(30) NOT NULL,
	DaoDien	nvarchar(30) NOT NULL,
	NamSanXuat	int NOT NULL,
	ThoiLuong	int NOT NULL,
	TheLoai nvarchar(30) NOT NULL,
	PRIMARY KEY(MaPhim)
);

CREATE TABLE VE (
	MaVe nvarchar(30) not null,
	MaPhim nvarchar(30),
	MaPhong nvarchar(30),
	SoGhe INTEGER,
	NgayLap	TEXT,
	XuatChieu TEXT,
	TongTien REAL,
	PRIMARY KEY (MaVe)
);

CREATE TABLE NHANVIEN (
	MaNhanVien	nvarchar(30) NOT NULL,
	HoTen TEXT NOT NULL,
	NamSinh	int NOT NULL,
	DiaChi TEXT NOT NULL,
	GioiTinh TEXT NOT NULL,
	Email TEXT NOT NULL,
	SoDienThoai	TEXT NOT NULL,
	PRIMARY KEY(MaNhanVien)
);

CREATE TABLE VE_NHANVIEN(
	MaVe nvarchar(30) not null,
	MaNhanVien nvarchar(30) not null,
	PRIMARY KEY (MaVe, MaNhanVien),
	FOREIGN KEY (MaVe) REFERENCES VE(MaVe),
	FOREIGN KEY (MaNhanVien) REFERENCES NHANVIEN(MaNhanVien)
)

CREATE TABLE LICHCHIEUPHIM (
	MaLichChieu	nvarchar(30) NOT NULL,
	MaPhong	nvarchar(30) NOT NULL,
	MaPhim	nvarchar(30) NOT NULL,
	NgayChieu	Date NOT NULL,
	GioBatDau	time NOT NULL,
	ThoiLuong	int NOT NULL,
	SoVeToiDa	int NOT NULL,
	GiaVe	int NOT NULL,
	PRIMARY KEY(MaLichChieu),
	FOREIGN KEY(MaPhong) REFERENCES PHONGCHIEUPHIM(MaPhong)
);

insert into PHIM values('P1', N'aaa', N'bbb', N'ccc', 2025, 7, 'fdbfdbcv')
insert into PHIM values('P2', N'aaa', N'bbb', N'ccc', 2023, 6, 'fdsg')
insert into PHIM values('P3', N'dnsdbvs', N'sfbgdgs', N'sgsagas', 2026, 8, 'fbdfbdf')
select * from PHIM