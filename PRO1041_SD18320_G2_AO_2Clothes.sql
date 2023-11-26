create database PRO1041_SD18320_G2_AO_2Clothes
go
use PRO1041_SD18320_G2_AO_2Clothes

-- tao bang --
create table KhachHang(
ID int identity(0,1) primary key ,
HoVaten nvarchar(50) NULL, 
SoDienThoai varchar(10) null,
DiaChi nvarchar(200) null,
); 

go

create table KhuyenMai(
ID int identity(0,1) primary key ,
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
ID int identity(0,1) primary key ,
NhanVienId int not null,
KhachHangId int null,
Trangthai int not null
);

go

create table HoaDonChiTiet(
ID int identity(0,1) primary key,
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
ID int identity(0,1) primary key ,
Username varchar(10) not null, 
MatKhau varchar(10) not null,
HoVaTen nvarchar(50) not null,
ChucVu int not null,
SoDienThoai varchar(10) not null,
);

go

create table LoaiSanPham(
ID int identity(0,1) primary key ,
Loai nvarchar(50) not null,
);

go

create table MauSac(
ID int identity(0,1) primary key ,
Ten nvarchar(50) not null,
);

go

create table ChatLieu(
ID int identity(0,1)primary key,
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
values (N'Áo Thun'),
		(N'Áo Polo'),
		(N'Áo Sơ Mi'),
		(N'Áo Hoodie')
go
insert into ChatLieu
values (N'Vải Cotton'),
		(N'Vải Kaki'),
		(N'Vải Jeans'),
		(N'Vải Ren'),
		(N'Vải Lanh'),
		(N'Vải Waffle'),
		(N'Vải Nỉ bông')
go
insert into MauSac
values (N'Đen'),
		(N'Trắng'),
		(N'Đỏ'),
		(N'Hồng'),
		(N'Xanh lá'),
		(N'Xanh dương')
go

--TrangThai
-- Đang bán: 0
-- Ngừng kinh doanh: 1

insert into SanPham
values (0,N'Áo thun sporty line shoulder',N'Chiếc','',0, 0),
		(1,N'Áo Polo united waffle shirt',N'Chiếc','',1, 0),
		(2,N'Ao sơ mi unisex waffle shirt',N'Chiếc','',2, 1),
		(3,N'Áo Hoodie morning star bunny',N'Chiếc','',3, 0)
go
insert into SanPhamChiTiet
values (0, 0, 0, 0, 0, 185000, 10),
		(1, 0, 0, 1, 1, 185000, 8),
		(2, 0, 0, 1, 2, 185000, 0),
		(3, 0, 1, 1, 3, 185000, 1),
		(4, 0, 1, 1, 2, 185000, 0),
		(5, 0, 1, 1, 1, 185000, 6),
		(6, 1, 0, 5, 1, 189000, 6),
		(7, 1, 0, 5, 2, 189000, 10),
		(8, 2, 0, 5, 2, 185000, 13),
		(9, 2, 1, 5, 1, 185000, 0),
		(10, 3, 0, 6, 1, 299000, 53),
		(11, 3, 1, 6, 2, 299000, 53),
		(12, 3, 5, 6, 3, 299000, 53)
go
insert into NhanVien
values ('kietvt', 123, N'Vũ Tuấn Kiệt', 0, '0862132564'),
	   ('thuylq', 123, N'Lê Quang Thủy', 0, '0366554643'),
	   ('tamnv', 123, N'Nguyễn Văn Tâm', 0, '0385242365'),
	   ('kienht', 123, N'Hoàng Trung Kiên', 0, '0981545252'),
	   ('hoangnv', 123, N'Ngô Việt Hoàng', 0, '0387436760'),
	   ('user', 123, N'User Test', 0, '0000000000')
go
-- Quản lý: 0
-- Nhân viên: 1

go
insert into KhachHang
values (N'Vũ Tuấn A', '', ''),
	   (N'Vũ Tuấn B', '', N'Hà Nội'),
	   (N'Vũ Tuấn C', '0989999999', ''),
	   (N'Vũ Tuấn D', '', ''),
	   (N'Vũ Tuấn E', '0862862862', '')
go

-- LoaiKhuyenMai
-- Giảm theo % tổng hóa đơn: 0
-- Giảm theo số tiền tổng hóa đơn: 1

-- TrangThai
-- Đang hoạt động: 0
-- Không hoạt động: 1
insert into KhuyenMai
values (0, 50, 0, 10, '', '', 0, N'Giảm 50% trên tổng hóa đơn'),
	   (1, 0, 30000, 5, '', '', 0, N'Giảm 50k trên tổng hóa đơn')
go
--Trangthai
-- Đã thanh toán: 0
-- Chờ thanh toán: 1
insert into HoaDon
values (0, 0, 0),
	   (0, 0, 1)
go

insert into HoaDonChiTiet
values (0, 0, 0, 185000, 2, 185000)

go
--------VIEW TABLE---------
select * from SanPham
select * from LoaiSanPham
select * from ChatLieu
select * from SanPhamChiTiet
select * from  MauSac
select * from NhanVien
select * from KhachHang
select * from KhuyenMai
select * from HoaDon
select * from HoaDonChiTiet
