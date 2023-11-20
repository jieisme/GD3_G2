create database PRO1041_SD18320_G2_AO_2Clothes
go
use PRO1041_SD18320_G2_AO_2Clothes

-- tao bang --
create table KhachHang(
ID int primary key ,
HoVaten nvarchar(50) NULL, 
SoDienThoai varchar(10) null,
DiaChi nvarchar(200) null,
); 

go

create table KhuyenMai(
ID int primary key ,
LoaiKhuyenMai int not null , 
GiamTheoPhamTram float not null,
GiamTheoGiaTien float not null,
SoLuong int not null,
ThoiGianBatDau date null,
ThoiGianKetThuc date null,
TrangThai int not null,
MoTa nvarchar(200) null
);
  
 go

create table SanPham(
ID int primary key ,
Ten nvarchar(50) not null,
DonViTinh nvarchar(20) not null,
MoTa nvarchar(200) null,
LoaiSanPhamID int not null,
TrangThaiBan int not null
);
  
go

create table HoaDon(
ID int not null primary key ,
NhanVienId int not null,
KhachHangId int null,
Trangthai int not null
);

go

create table HoaDonChiTiet(
ID int primary key,
HoaDonId int not null,
SanPhamChiTietId int not null,
KhuyenMaiID int not null,
GiaBan float not null,
SoLuong int not null,
TongTien Float not null ,
);

go

create table SanPhamChiTiet(
ID int primary key ,
SanPhamID int not null,
MauSacID int not null,
ChatLieuID int not null,
KichThuoc int not null,
DonGia float not null,
SoLuong int not null,
);

go

create table NhanVien(
ID int primary key ,
Username varchar(10) not null, 
MatKhau varchar(10) not null,
HoVaTen nvarchar(50) not null,
ChucVu int not null,
SoDienThoai varchar(10) not null,

);

go

create table LoaiSanPham(
ID int primary key ,
Loai nvarchar(50) not null,
);

go

create table MauSac(
ID int primary key ,
Ten nvarchar(50) not null,
);

go

create table ChatLieu(
ID int primary key,
Ten nvarchar(50) not null,
);

go

-- xet khoa ngoai --

alter table SanPhamChiTiet
add constraint fk_SanPhamID
foreign key (SanPhamID)
references SanPham(ID)
go
alter table SanPhamChiTiet
add constraint fk_MauSacID
foreign key (MauSacID)
references MauSac(ID)
go
alter table SanPhamChiTiet
add constraint fk_ChatLieuID
foreign key (ChatLieuID)
references ChatLieu(ID)
go
alter table SanPham
add constraint fk_LoaiSanPhamID
foreign key (LoaiSanPhamID)
references LoaiSanPham(ID)
go
alter table HoaDon
add constraint fk_NhanVienID
foreign key (NhanVienID)
references NhanVien(ID)
go
alter table HoaDon
add constraint fk_KhachHang2
foreign key (KhachHangID)
references KhachHang(ID)
go
alter table HoaDonChiTiet
add constraint fk_HoaDonID
foreign key (HoaDonID)
references HoaDon(ID)
go
alter table HoaDonChiTiet
add constraint fk_SanPhamChiTietID
foreign key (SanPhamChiTietID)
references SanPhamChiTiet(ID)
go
alter table HoaDonChiTiet
add constraint fk_KhuyenMaiID1
foreign key (KhuyenMaiID)
references KhuyenMai(ID)
go
-- thêm dữ liệu --
insert into LoaiSanPham 
values (0,N'Áo Thun'),
		(1,N'Áo Polo'),
		(2,N'Áo Sơ Mi'),
		(3,N'Áo Hoodie')
go
insert into ChatLieu
values (0, N'Vải Cotton'),
		(1,N'Vải Kaki'),
		(2,N'Vải Jeans'),
		(3,N'Vải Ren'),
		(4,N'Vải Lanh'),
		(5,N'Vải Waffle'),
		(6,N'Vải Nỉ bông')
go
insert into MauSac
values (0,N'Đen'),
		(1,N'Trắng'),
		(2,N'Đỏ'),
		(3,N'Hồng'),
		(4,N'Xanh lá'),
		(5,N'Xanh dương')
go

insert into SanPham
values (0,N'Áo thun sporty line shoulder',N'Chiếc','',0, 0),
		(1,N'Áo Polo united waffle shirt',N'Chiếc','',1, 0),
		(2,N'Ao sơ mi unisex waffle shirt',N'Chiếc','',2, 1),
		(3,N'Áo Hoodie morning star bunny',N'Chiếc','',3, 0)
go
select * from SanPham
select * from LoaiSanPham
select * from ChatLieu
select * from SanPhamChiTiet

ID int primary key ,
SanPhamID int not null,
MauSacID int not null,
ChatLieuID int not null,
KichThuoc int not null,
DonGia float not null,
SoLuong int not null,

x s m l xl
0 1 2 3 4

insert into SanPhamChiTiet
values (0, 0, 0, 0, 2, 185000, 10),
		(1, 0, 01, 01, 3, 185000, 8),
		(2, 0, 01, 01, 4, 185000, 7),
		(3, 0, 02, 01, 2, 185000, 1),
		(4, 0, 02, 01, 3, 185000, 5),
		(5, 0, 02, 01, 4, 185000, 6),




		USE [PRO1041_SD18320_G2_AO_2Clothes]
GO

UPDATE [dbo].[SanPham]
   SET [Ten] = N'Áo thun baby sheep cuteee'
      ,[DonViTinh] = N'Chiếc'
      ,[MoTa] = ''
      ,[LoaiSanPhamID] = 1
 WHERE ID = 6
GO
select * from SanPham
UPDATE [dbo].[SanPham]"
                + "   SET [Ten] = N'Áo thun baby sheep cuteee'\n"
                + "      ,[DonViTinh] = N'Chiếc'\n"
                + "      ,[MoTa] = ''\n"
                + "      ,[LoaiSanPhamID] = 1\n"
                + " WHERE ID = 6

				USE [PRO1041_SD18320_G2_AO_2Clothes]
GO

SELECT [ID]
      ,[Ten]
      ,[DonViTinh]
      ,[MoTa]
      ,[LoaiSanPhamID]
      ,[TrangThaiBan]
  FROM [dbo].[SanPham]
  WHERE ID = ?

GO
USE [PRO1041_SD18320_G2_AO_2Clothes]
GO

INSERT INTO [dbo].[SanPham]
           ([ID]
           ,[Ten]
           ,[DonViTinh]
           ,[MoTa]
           ,[LoaiSanPhamID]
           ,[TrangThaiBan])
     VALUES
           (?, ?, ?, ?, ?, ?)
GO


USE [PRO1041_SD18320_G2_AO_2Clothes]
GO

UPDATE [dbo].[SanPham]
   SET [Ten] = ?
      ,[DonViTinh] = ?
      ,[MoTa] = ?
      ,[LoaiSanPhamID] = ?
      ,[TrangThaiBan] = ?
 WHERE ID = ?
GO

