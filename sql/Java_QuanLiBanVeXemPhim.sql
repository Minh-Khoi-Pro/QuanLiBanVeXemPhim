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

/*insert into PHIM values('P1', N'aaa', N'bbb', N'ccc', 2025, 7, 'fdbfdbcv')
insert into PHIM values('P2', N'aaa', N'bbb', N'ccc', 2023, 6, 'fdsg')
insert into PHIM values('P3', N'dnsdbvs', N'sfbgdgs', N'sgsagas', 2026, 8, 'fbdfbdf')
select * from PHIM */

CREATE PROCEDURE AddPhim 
    @MaPhim NVARCHAR(10),
    @TenPhim NVARCHAR(100),
    @QuocGia NVARCHAR(50),
    @DaoDien NVARCHAR(50),
    @NamSanXuat INT,
    @ThoiLuong INT,
    @TheLoai NVARCHAR(50)
AS
BEGIN
    INSERT INTO Phim(MaPhim, TenPhim, QuocGia, DaoDien, NamSanXuat, ThoiLuong, TheLoai)
    VALUES (@MaPhim, @TenPhim, @QuocGia, @DaoDien, @NamSanXuat, @ThoiLuong, @TheLoai);
END;

EXEC AddPhim 
    @MaPhim = 'P111',
    @TenPhim = N'One Piece',
    @QuocGia = N'Nhat Ban',
    @DaoDien = N'Oda',
    @NamSanXuat = 1997,
    @ThoiLuong = 1000,
    @TheLoai = N'Phieu Luu';

EXEC AddPhim 
    @MaPhim = 'P112',
    @TenPhim = N'Tham Tu Lung Danh Conan',
    @QuocGia = N'Nhat Ban',
    @DaoDien = N'GhoSho Aoyama',
    @NamSanXuat = 1997,
    @ThoiLuong = 1500,
    @TheLoai = N'Trinh Tham';

TRUNCATE TABLE PHIM; -- Xóa toàn bộ dữ liệu trong bảng PHIM

--Xóa 1 phim theo mã
CREATE PROCEDURE DeletePhim
@MaPhim NVARCHAR(10)
AS
BEGIN
   DELETE FROM Phim WHERE MaPhim = @MaPhim
END

EXEC DeletePhim
	@MaPhim = 'P111'

--Cập nhật phim
CREATE PROCEDURE UpdatePhim 
    @MaPhim NVARCHAR(30),
    @TenPhim NVARCHAR(100),
    @QuocGia NVARCHAR(50),
    @DaoDien NVARCHAR(50),
    @NamSanXuat INT,
    @ThoiLuong INT,
    @TheLoai NVARCHAR(50)
AS
BEGIN
    UPDATE PHIM
    SET TenPhim = @TenPhim,
        QuocGia = @QuocGia,
        DaoDien = @DaoDien,
        NamSanXuat = @NamSanXuat,
        ThoiLuong = @ThoiLuong,
        TheLoai = @TheLoai
    WHERE MaPhim = @MaPhim;
END;

EXEC UpdatePhim 
    @MaPhim = 'P111',
    @TenPhim = N'Phim Mới',
    @QuocGia = N'Việt Nam',
    @DaoDien = N'Nguyễn Văn A',
    @NamSanXuat = 2024,
    @ThoiLuong = 120,
    @TheLoai = N'Hài Hước';



CREATE PROCEDURE GetAllPhim
AS
	BEGIN
		SELECT * FROM PHIM;
	END

--EXEC sp_rename 'sp_GetAllPhim', 'GetAllPhim';


