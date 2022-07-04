-- INSERT

INSERT INTO [TheLoai]([TenTheLoai],[HIDE]) VALUES (?,?)

INSERT INTO [NhanVien]([HoTen],[SDT],[GioiTinh],[ChucVu],[MatKhau],[Hinh],[HIDE]) VALUES (?,?,?,?,?,?,?)

INSERT INTO [Phim]([TenPhim],[NgayKhoiChieu],[NgayKetThuc],[QuocGia],[MaTheLoai],[DinhDang],[Hinh],[MaNhanVien],[HIDE]) VALUES (?,?,?,?,?,?,?,?,?)

INSERT INTO [Phong]([SoHang],[HIDE]) VALUES (?,?)

INSERT INTO [LichChieu]([NgayChieu],[GioChieu],[MaPhim],[MaPhong],[HIDE]) VALUES (?,?,?,?,?)

EXEC sp_TaoGhe ?

INSERT INTO [KhuyenMai]([MaKM],[TenKM],[ThongTinKM],[MucGiamGia],[NgayBatDau],[NgayKetThuc],[MaNhanVien],[HIDE]) VALUES (?,?,?,?,?,?,?,?)--duongsua

INSERT INTO [KhachHangThanThiet]([Ten],[SDT],[Email],[NgayDK],[MucGiamGia],[SoLanSuDung],[MaNhanVien],[HIDE]) VALUES (?,?,?,?,?,?,?,?)

INSERT INTO [HoaDon]([TongTien],[MaKM],[MaKHTT],[MucGiamGia],[ThanhTien],[NgayLap],[MaNhanVien],[HIDE]) VALUES (?,?,?,?,?,?,?,?)

INSERT INTO [Ve]([MaPhim],[MaLichChieu],[MaPhong],[MaGhe]) VALUES (?,?,?,?)

INSERT INTO [DichVu]([MaDichVu],[TenDichVu],[GiaDichVu],[HIDE]) VALUES (?,?,?,?)

INSERT INTO [HoaDonChiTiet]([MaVe],[GiaTien],[SoLuong],[ThanhTien],[MaHoaDon],[HIDE]) VALUES (?,?,?,?,?,?) -- Vé
INSERT INTO [HoaDonChiTiet]([MaDichVu],[GiaTien],[SoLuong],[ThanhTien],[MaHoaDon],[HIDE]) VALUES (?,?,?,?,?,?) - Dịch vụ


--UPDATE
UPDATE [TheLoai] SET [TenTheLoai] = ?, [HIDE] = ? WHERE [MaTheLoai] = ?

UPDATE [NhanVien] SET [HoTen] = ?, [SDT] = ?, [GioiTinh] = ?, [ChucVu] = ?, [MatKhau] = ?, [HIDE] WHERE [MaNhanVien] = ?

UPDATE [Phim] SET [TenPhim] = ?, [NgayKhoiChieu] = ?, [QuocGia] = ?, [MaTheLoai] = ?,[DinhDang] = ?,[MaNhanVien] = ?,[HIDE] = ? WHERE [MaPhim] = ?

UPDATE [Phong] SET [SoHang] = ?, [HIDE] = ? WHERE [MaPhong] = ?

UPDATE [LichChieu] SET [NgayChieu] = ?, [GioChieu] = ?,[MaPhim] = ?,[MaPhong] = ?,[HIDE] = ? WHERE [MaLichChieu] = ?

Update KhuyenMai Set  [TenKM]=?, ThongTinKM=?,MucGiamGia=?,NgayBatDau=?,NgayKetThuc=?,MaNhanVien=? Where MaKM like ?--duongsua

UPDATE [KhachHangThanThiet] SET [Ten] = ?, [SDT] = ?, [Email] = ?, [NgayDK] = ?, [MucGiamGia] = ?, [SoLanSuDung] = ?, [MaNhanVien] = ?, [HIDE] = ? WHERE [MaKHTT] = ?

UPDATE [HoaDon] SET [TongTien] = ?, [MaKM] = ?, [MaKHTT] = ?, [MucGiamGia] = ?, [ThanhTien] = ?, [NgayLap] = ?, [MaNhanVien] = ?, [HIDE] = ? WHERE [MaHoaDon] = ?

UPDATE [Ve] SET [MaPhim] = ?, [MaLichChieu] = ?, [MaPhong] = ?, [MaGhe] = ? WHERE [MaVe] = ?

UPDATE [DichVu] SET [TenDichVu] = ?, [GiaDichVu] = ?, [HIDE] = ? WHERE [MaDichVu] = ?

UPDATE [HoaDonChiTiet] SET [MaDichVu] = ?, [GiaTien] = ?, [SoLuong] = ?, [ThanhTien] = ?, [MaHoaDon] = ?, [HIDE] = ? WHERE [MaHoaDonChiTiet] = ?

--SPOC
--EXEC SP_DOANHTHUTHEONAM ?
EXEC SP_DOANHTHUNAM
EXEC SP_DOANHTHUTHEOTHANG ?
EXEC SP_DOANHTHUTHANG
EXEC SP_DOANHTHUBETWEEN ? ?
EXEC SP_DOANHTHUPHIM ?
EXEC sp_TKKH_TheoThang ?
EXEC sp_TKKH_TheoNam ?
EXEC sp_TKLX_TheoPhim ?
EXEC sp_TKKH_TheoThangspc ?
EXEC sp_TKKH_TheoNamspc ?
