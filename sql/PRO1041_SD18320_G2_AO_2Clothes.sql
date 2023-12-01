create database PRO1041_SD18320_G2_AO_2Clothes
go
use PRO1041_SD18320_G2_AO_2Clothes

-- tao bang --
create table KhachHang(
ID int identity(0,1) primary key ,
HoVaten nvarchar(50) NULL, 
SoDienThoai varchar(10) null,
DiaChi nvarchar(200) null,
TrangThaiXoa int null,
); 

go

create table KhuyenMai(
ID int identity(0,1) primary key,
LoaiKhuyenMai int not null , 
GiamTheoPhanTram int not null,
GiamTheoGiaTien int not null,
SoLuong int not null,
ThoiGianBatDau date null,
ThoiGianKetThuc date null,
TrangThai int not null,
MoTa nvarchar(200) null,
TrangThaiXoa int null
);
  
 go

create table SanPham(
ID int primary key ,
Ten nvarchar(50) not null,
DonViTinh nvarchar(20) not null,
MoTa nvarchar(200) null,
LoaiSanPhamID int not null,
TrangThaiBan int not null,
TrangThaiXoa int null
);
  
go

create table HoaDon(
ID int identity(0,1) primary key ,
NhanVienId int not null,
KhachHangId int null,
KhuyenMaiID int null,
TongTienHang int not null,
TongTienDuocGiam int null,
TongTienPhaiTra int not null,
Trangthai	int not null,
TrangThaiXoa int null
);

go

create table HoaDonChiTiet(
ID int identity(0,1) primary key,
HoaDonId int not null,
SanPhamChiTietId int not null,
GiaBan int not null,
SoLuong int not null,        
TrangThaiXoa int null
);

go

create table SanPhamChiTiet(
ID int primary key ,
SanPhamID int not null,
MauSacID int not null,
ChatLieuID int not null,
KichThuoc int not null,
DonGia int not null,
SoLuong int not null,
TrangThaiXoa int null
);

go

create table NhanVien(
ID int identity(0,1) primary key ,
Username varchar(10) not null, 
MatKhau varchar(10) not null,
HoVaTen nvarchar(50) not null,
ChucVu int not null,
SoDienThoai varchar(10) not null,
TrangThaiXoa int null
);

go

create table LoaiSanPham(
ID int identity(0,1) primary key ,
Loai nvarchar(50) not null,
TrangThaiXoa int null
);

go

create table MauSac(
ID int identity(0,1) primary key ,
Ten nvarchar(50) not null,
TrangThaiXoa int null
);

go

create table ChatLieu(
ID int identity(0,1)primary key,
Ten nvarchar(50) not null,
TrangThaiXoa int null
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
alter table HoaDon
add constraint fk_KhuyenMaiID1
foreign key (KhuyenMaiID)
references KhuyenMai(ID)
go
-- thêm dữ liệu --
insert into LoaiSanPham 
values (N'Áo Thun', 0),
		(N'Áo Polo', 0),
		(N'Áo Sơ Mi', 0),
		(N'Áo Hoodie', 0)
go
insert into ChatLieu
values (N'Vải Cotton', 0),
		(N'Vải Kaki', 0),
		(N'Vải Jeans', 0),
		(N'Vải Ren', 0),
		(N'Vải Lanh', 0),
		(N'Vải Waffle', 0),
		(N'Vải Nỉ bông', 0)
go
insert into MauSac
values (N'Đen', 0),
		(N'Trắng', 0),
		(N'Đỏ', 0),
		(N'Hồng', 0),
		(N'Xanh lá', 0),
		(N'Xanh dương', 0)
go

--TrangThai
-- Đang bán: 0
-- Ngừng kinh doanh: 1

insert into SanPham
values (0,N'Áo thun sporty line shoulder',N'Chiếc','',0, 0, 0),
		(1,N'Áo Polo united waffle shirt',N'Chiếc','',1, 0, 0),
		(2,N'Ao sơ mi unisex waffle shirt',N'Chiếc','',2, 1, 0),
		(3,N'Áo Hoodie morning star bunny',N'Chiếc','',3, 0, 0)
go
insert into SanPhamChiTiet
values (0, 0, 0, 0, 0, 185000, 10, 0),
		(1, 0, 0, 1, 1, 185000, 8, 0),
		(2, 0, 0, 1, 2, 185000, 0, 0),
		(3, 0, 1, 1, 3, 185000, 1, 0),
		(4, 0, 1, 1, 2, 185000, 0, 0),
		(5, 0, 1, 1, 1, 185000, 6, 0),
		(6, 1, 0, 5, 1, 189000, 6, 0),
		(7, 1, 0, 5, 2, 189000, 10, 0),
		(8, 2, 0, 5, 2, 185000, 13, 0),
		(9, 2, 1, 5, 1, 185000, 0, 0),
		(10, 3, 0, 6, 1, 299000, 43, 0),
		(11, 3, 1, 6, 2, 299000, 65, 0),
		(12, 3, 5, 6, 3, 299000, 97, 0)
go
insert into NhanVien
values ('kietvt', 123, N'Vũ Tuấn Kiệt', 0, '0862132564', 0),
	   ('thuylq', 123, N'Lê Quang Thủy', 0, '0366554643', 0),
	   ('tamnv', 123, N'Nguyễn Văn Tâm', 0, '0385242365', 0),
	   ('kienht', 123, N'Hoàng Trung Kiên', 0, '0981545252', 0),
	   ('hoangnv', 123, N'Ngô Việt Hoàng', 0, '0387436760', 0),
	   ('user', 123, N'User Test', 0, '0000000000', 0)
go
-- Quản lý: 0
-- Nhân viên: 1

go
insert into KhachHang
values (N'Vũ Tuấn A', '', '', 0),
	   (N'Vũ Tuấn B', '', N'Hà Nội', 0),
	   (N'Vũ Tuấn C', '0989999999', '', 0),
	   (N'Vũ Tuấn D', '', '', 0),
	   (N'Vũ Tuấn E', '0862862862', '', 0)
go

-- LoaiKhuyenMai
-- Giảm theo % tổng hóa đơn: 0
-- Giảm theo số tiền tổng hóa đơn: 1

-- TrangThai
-- Đang hoạt động: 0
-- Không hoạt động: 1
insert into KhuyenMai
values (0, 50, 0, 10, '', '', 0, N'Giảm 50% trên tổng hóa đơn', 0),
	   (1, 0, 50000, 5, '', '', 0, N'Giảm 50k trên tổng hóa đơn', 0)
go
--Trangthai
-- Đã thanh toán: 0
-- Chưa thanh toán: 1

insert into HoaDon
values (0, 0, 0, 200000, 0, 100000, 0, 0),
	   (0, 1, 1, 200000, 1, 150000, 1, 0)
go

insert into HoaDonChiTiet
values (0, 0, 200000, 1, 0),
	   (1, 0, 200000, 1, 0)

go
--------VIEW TABLE---------
select * from SanPham
select * from LoaiSanPham
select * from ChatLieu
select * from SanPhamChiTiet
select * from MauSac
select * from NhanVien
select * from KhachHang
select * from KhuyenMai
select * from HoaDon
select * from HoaDonChiTiet