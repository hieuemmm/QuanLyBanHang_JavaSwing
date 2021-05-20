-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 20, 2021 lúc 06:05 PM
-- Phiên bản máy phục vụ: 10.4.19-MariaDB
-- Phiên bản PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlybanhang_javaswing`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `ID` int(6) NOT NULL,
  `SoLuongMua` int(6) DEFAULT NULL,
  `MaSP` int(6) DEFAULT NULL,
  `MaDH` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`ID`, `SoLuongMua`, `MaSP`, `MaDH`) VALUES
(1, 2, 7, 1),
(2, 2, 8, 1),
(3, 1, 6, 2),
(4, 3, 5, 2),
(5, 5, 4, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhmucsanpham`
--

CREATE TABLE `danhmucsanpham` (
  `MaDanhMuc` int(6) NOT NULL,
  `TenDanhMuc` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `danhmucsanpham`
--

INSERT INTO `danhmucsanpham` (`MaDanhMuc`, `TenDanhMuc`) VALUES
(1, 'Danh mục Demo'),
(2, 'Nguyên liệu thô'),
(3, 'Thành phẩm'),
(4, 'Vật liệu đóng gói'),
(5, 'Máy móc'),
(6, 'Đang tiến hành'),
(8, 'Các mặt hàng văn phòng phẩm');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `MaDonHang` int(6) NOT NULL,
  `TK` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `MaTT` int(6) DEFAULT NULL,
  `SDT` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiaChiNhanHang` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayTao` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`MaDonHang`, `TK`, `MaTT`, `SDT`, `DiaChiNhanHang`, `NgayTao`) VALUES
(1, 'khachhang', 1, '0398627782', '48 Cao Thắng, TP. Đà Nẵng', '2021-05-18'),
(2, 'khachhang', 4, '0398627782', '48 Cao Thắng, TP. Đà Nẵng', '2021-05-12');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhomnguoidung`
--

CREATE TABLE `nhomnguoidung` (
  `MaNhomNguoiDung` int(6) NOT NULL,
  `TenNhomNguoiDung` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhomnguoidung`
--

INSERT INTO `nhomnguoidung` (`MaNhomNguoiDung`, `TenNhomNguoiDung`) VALUES
(1, 'Administrator'),
(2, 'Nhân Viên'),
(3, 'Khách Hàng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSanPham` int(6) NOT NULL,
  `MaDM` int(6) DEFAULT NULL,
  `TenSanPham` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuong` int(6) NOT NULL,
  `GiaMua` int(6) NOT NULL,
  `GiaBan` int(6) NOT NULL,
  `MoTa` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MaSanPham`, `MaDM`, `TenSanPham`, `SoLuong`, `GiaMua`, `GiaBan`, `MoTa`) VALUES
(1, 1, 'Demo Product', 48, 100, 500, ''),
(2, 2, 'qqqqqqq123123', 21312, 55, 12312, '12312'),
(3, 2, 'Lúa mì', 69, 2, 5, ''),
(4, 2, 'Gỗ', 12, 780, 1069, ''),
(5, 5, 'Máy khoan sàn dao động W1848', 26, 299, 66, ''),
(6, 5, 'Máy Cắt Mini', 123, 280, 450, 'Sửa thử'),
(7, 3, 'Life Breakfast Cereal-3 Pk', 107, 3, 7, ''),
(8, 3, 'Chicken of the Sea Sardines W', 110, 13, 20, ''),
(9, 3, 'Disney Woody - Action Figure', 67, 29, 55, ''),
(10, 3, 'Đồ chơi dòng Hasbro Marvel Legends', 106, 219, 322, ''),
(11, 4, 'Chip đóng gói', 78, 21, 31, ''),
(12, 8, 'Máy rút băng để bàn cổ điển 38', 160, 5, 10, ' '),
(13, 4, 'Bọc đệm bong bóng nhỏ', 199, 8, 19, ' '),
(16, 2, '123123', 21312, 3123, 12312, '12312');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `TaiKhoan` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MatKhau` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Ten` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNhomND` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`TaiKhoan`, `MatKhau`, `Ten`, `MaNhomND`) VALUES
('admin', 'admin', 'Admin', 1),
('huynhanh123', '12311312', 'Huỳnh Lê Tuấn Anha', 2),
('khachhang', 'khachhang', 'Nguyễn Văn A', 3),
('nhanvien', 'nhanvien', 'Nguyễn Hồng Gấm', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trangthaidonhang`
--

CREATE TABLE `trangthaidonhang` (
  `MaTrangThai` int(6) NOT NULL,
  `TenTrangThai` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `trangthaidonhang`
--

INSERT INTO `trangthaidonhang` (`MaTrangThai`, `TenTrangThai`) VALUES
(1, 'Chưa Duyệt'),
(2, 'Đang Giao'),
(3, 'Hủy'),
(4, 'Hoàn Thành');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `MaSanPham` (`MaSP`),
  ADD KEY `MaDonHang` (`MaDH`);

--
-- Chỉ mục cho bảng `danhmucsanpham`
--
ALTER TABLE `danhmucsanpham`
  ADD PRIMARY KEY (`MaDanhMuc`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`MaDonHang`),
  ADD KEY `TaiKhoan` (`TK`),
  ADD KEY `MaTrangThai` (`MaTT`);

--
-- Chỉ mục cho bảng `nhomnguoidung`
--
ALTER TABLE `nhomnguoidung`
  ADD PRIMARY KEY (`MaNhomNguoiDung`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSanPham`),
  ADD KEY `MaDanhMuc` (`MaDM`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`TaiKhoan`),
  ADD KEY `MaNhomNguoiDung` (`MaNhomND`);

--
-- Chỉ mục cho bảng `trangthaidonhang`
--
ALTER TABLE `trangthaidonhang`
  ADD PRIMARY KEY (`MaTrangThai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `ID` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `danhmucsanpham`
--
ALTER TABLE `danhmucsanpham`
  MODIFY `MaDanhMuc` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `MaDonHang` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `nhomnguoidung`
--
ALTER TABLE `nhomnguoidung`
  MODIFY `MaNhomNguoiDung` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MaSanPham` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `trangthaidonhang`
--
ALTER TABLE `trangthaidonhang`
  MODIFY `MaTrangThai` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD CONSTRAINT `chitietdonhang_ibfk_1` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSanPham`),
  ADD CONSTRAINT `chitietdonhang_ibfk_2` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDonHang`);

--
-- Các ràng buộc cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD CONSTRAINT `donhang_ibfk_1` FOREIGN KEY (`TK`) REFERENCES `taikhoan` (`TaiKhoan`),
  ADD CONSTRAINT `donhang_ibfk_2` FOREIGN KEY (`MaTT`) REFERENCES `trangthaidonhang` (`MaTrangThai`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaDM`) REFERENCES `danhmucsanpham` (`MaDanhMuc`);

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`MaNhomND`) REFERENCES `nhomnguoidung` (`MaNhomNguoiDung`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
