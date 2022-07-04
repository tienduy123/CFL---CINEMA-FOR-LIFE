USE QL_RAPPHIM
GO

CREATE PROC sp_PhimTheoLichChieu
as Begin
	SELECT CONCAT(TenPhim,' ', NgayChieu, ' ',GioChieu) as PHIM
	FROM LichChieu lc
		INNER JOIN Phim ph ON lc.MaPhim = ph.MaPhim
	GROUP BY ph.TenPhim, NgayChieu, GioChieu
End
GO

CREATE PROC sp_TaoGhe(@MaPhong VARCHAR(10), @time varchar(10))
as begin
	DECLARE @i int = 1, @j int =1, @maHang varchar(50)
	DECLARE @Hang varchar(50) = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
	DECLARE @soHang int = 14
	while @i <= @soHang 
		begin
			SET @maHang = SUBSTRING(@Hang,@i,1)
			while @j <=10
				begin
					if @i > 4 
						insert into Ghe values (@maHang + CAST(@j AS varchar(5)),1,100000, @MaPhong,@time, 0)
					else 
						insert into Ghe values (@maHang + CAST(@j AS varchar(5)),0,50000, @MaPhong,@time, 0)
					set @j = @j +1
				end
				set @j = 1
				set @i = @i +1
		end
end
GO

create proc sp_timeSeat(@MaPhong VARCHAR(10))
as begin
	declare @h int =17, @m int = 0, @time varchar(10)
	while @h <= 23
		begin
			if @m % 2 = 0 set @time = concat(cast(@h as varchar(5)),':','00')
			if @m % 2 != 0 set @time = concat(cast(@h as varchar(5)),':','30')
			exec sp_TaoGhe @MaPhong , @time
			set @m = @m + 1
			set @h = @h + (@m % 2)
		end
end
go

CREATE PROCEDURE SP_DOANHTHUTHEONAM @year varchar(4)
	AS BEGIN
		SELECT 
		COUNT(MAHOADON) AS 'SOHOADON',
		SUM(THANHTIEN) AS 'TONG',YEAR(NGAYLAP) as 'Nam'
		FROM HOADON
		WHERE YEAR(ngaylap) like @YEAR
		group by YEAR(ngaylap)
	END
GO

CREATE PROCEDURE SP_DOANHTHUNAM
	AS BEGIN
		SELECT 
		COUNT(MAHOADON) AS 'SOHOADON',
		SUM(THANHTIEN) AS 'TONG',YEAR(NGAYLAP) as 'Nam'
		FROM HOADON
		group by YEAR(NGAYLAP)
	END
GO

CREATE PROCEDURE SP_DOANHTHUTHEOTHANG @MONTH varchar(2)
	AS BEGIN
		SELECT 
		COUNT(MAHOADON) AS 'SOHOADON',
		SUM(THANHTIEN) AS 'TONG',MONTH(NGAYLAP) as 'Nam'
		FROM HOADON
		WHERE MONTH(NGAYLAP) like @MONTH
		group by MONTH(NGAYLAP)
	END
GO

CREATE PROCEDURE SP_DOANHTHUTHANG  @year varchar(4)
	AS BEGIN
		SELECT 
		COUNT(MAHOADON) AS 'SOHOADON',
		SUM(THANHTIEN) AS 'TONG',MONTH(NGAYLAP) as 'Nam'
		FROM HOADON
		where year(ngaylap) = @year
		group by MONTH(NGAYLAP) 
	END
GO

CREATE PROCEDURE SP_DOANHTHUBETWEEN @TIME1 DATE, @TIME2 DATE
	AS BEGIN
		SELECT 
		COUNT(MAHOADON) AS 'SOHOADON',
		SUM(THANHTIEN) AS 'TONG'
		FROM HOADON
		WHERE NGAYLAP BETWEEN @TIME1 AND @TIME2
	END
GO

CREATE PROCEDURE SP_DOANHTHUPHIM @YEAR VARCHAR(4)
	AS BEGIN
		SELECT VE.MAPHIM AS 'MAPHIM',
		SUM(HOADON.THANHTIEN) AS 'DOANHTHU',
		YEAR(HOADON.NGAYLAP) AS 'NAM'
		FROM ve JOIN HOADONCHITIET
		ON VE.MAVE=HOADONCHITIET.MAVE
		JOIN HOADON ON HOADONCHITIET.MAHOADON = HOADON.MAHOADON
		WHERE MAPHIM LIKE MAPHIM AND YEAR(HOADON.NGAYLAP) LIKE @YEAR
		GROUP BY MAPHIM,YEAR(HOADON.NGAYLAP)
	END
GO

CREATE PROCEDURE sp_TKKH_TheoThang (@Thang INT)
as BEGIN
	SELECT COUNT(khtt.MaKHTT) as SoLuongKhachHang,
		MONTH(khtt.NgayDK) as ThangDangKy
	FROM KhachHangThanThiet khtt
	WHERE MONTH(khtt.NgayDK) = @Thang
	GROUP BY khtt.MaKHTT, MONTH(khtt.NgayDK)
END
GO

CREATE PROCEDURE sp_TKKH_TheoNam (@Nam INT)
as BEGIN
	SELECT COUNT(khtt.MaKHTT) as SoLuongKhachHang,
		YEAR(khtt.NgayDK) as NamDangKy
	FROM KhachHangThanThiet khtt
	WHERE YEAR(khtt.NgayDK) = @Nam
	GROUP BY khtt.MaKHTT, YEAR(khtt.NgayDK)
END
GO

CREATE PROCEDURE sp_TKLX_TheoPhim (@MaPhim VARCHAR(10))
as BEGIN
	SELECT ph.TenPhim,
		COUNT(hdct.MAVE) as SoLuongNguoiXem
	FROM Phim ph
		INNER JOIN Ve v ON ph.MaPhim = v.MaPhim
		INNER JOIN HoaDonChiTiet hdct ON v.MaVe = hdct.MAVE
	WHERE ph.MaPhim = @MaPhim
	GROUP BY ph.TenPhim
	ORDER BY COUNT(hdct.MAVE) DESC
END
GO

CREATE PROCEDURE sp_TKKH_TheoThangspc (@Thang INT)
as BEGIN
	SELECT Ten, SoLanSuDung, MONTH(NgayDK) as ThangDangKy
	FROM KhachHangThanThiet
	WHERE MONTH(NgayDK) = @Thang
	GROUP BY MaKHTT, Ten, SoLanSuDung, MONTH(NgayDK)
END
GO

CREATE PROCEDURE sp_TKKH_TheoNamspc (@Nam INT)
as BEGIN
	SELECT Ten, SoLanSuDung, YEAR(NgayDK) as NamDangKy
	FROM KhachHangThanThiet
	WHERE YEAR(NgayDK) = @Nam
	GROUP BY MaKHTT, Ten, SoLanSuDung, YEAR(NgayDK)
END
GO

CREATE PROCEDURE SP_SUKIENDANGDIENRA @TIMENOW DATE
	AS BEGIN
		SELECT 
		* FROM KhuyenMai
		WHERE @TIMENOW BETWEEN NgayBatDau AND NgayKetThuc AND HIDE=0
	END
GO

create PROCEDURE sp_TKDT_TungThangTheoNam (@Nam INT)
as BEGIN
	select month(ngaylap),sum(tongtien) from hoadon where year(ngaylap) = @Nam group by month(NgayLap) 
	 
END
GO

create PROCEDURE sp_TKDT_TungNgayTheoThang(@Nam INT, @Thang INT)
as BEGIN
select day(ngaylap) as 'Ngay',count(mave) as 'TongVe',count(madichvu) as 'TongDichVu', sum(hoadonchitiet.thanhtien)  as 'TongTienNgay'
from hoadonchitiet inner join hoadon on HoaDonChiTiet.MaHoaDon = HoaDon.MaHoaDon
where month(ngaylap) = @Thang and year(ngaylap) = @Nam group by DAY(ngaylap)
END
GO

create PROCEDURE sp_DTTungNam
as begin
select year(ngaylap) as 'Nam', count(mave) as 'TongVe',count(madichvu) as 'TongDichVu', sum(hoadonchitiet.thanhtien)  as 'TongTien'
from hoadonchitiet inner join hoadon on HoaDonChiTiet.MaHoaDon = HoaDon.MaHoaDon
group by year(ngaylap)
end 
go

create PROCEDURE sp_DTTungThang(@nam int)
as begin
select month(ngaylap) as 'Thang', count(mave) as 'TongVe',count(madichvu) as 'TongDichVu', sum(hoadonchitiet.thanhtien)  as 'TongTien'
from hoadonchitiet inner join hoadon on HoaDonChiTiet.MaHoaDon = HoaDon.MaHoaDon where year(ngaylap) = @nam
group by month(ngaylap)
end 
go

create PROCEDURE sp_DTThang(@nam int, @thang int)
as begin
select ngaylap as 'Ngay', count(mave) as 'TongVe',count(madichvu) as 'TongDichVu', sum(hoadonchitiet.thanhtien)  as 'TongTien'
from hoadonchitiet inner join hoadon on HoaDonChiTiet.MaHoaDon = HoaDon.MaHoaDon where year(ngaylap) = @nam and month(ngaylap) = @thang
group by ngaylap
end 
go

create PROCEDURE sp_TKLX_TheoThang(@thang int, @nam int)
as
begin
select TenPhim,count(hdct.MaVe) from HoaDonChiTiet hdct 
inner join hoadon hd on hdct.MaHoaDon=hd.MaHoaDon
inner join ve on ve.MaVe = hdct.MaVe inner join Phim on ve.MaPhim = phim.MaPhim
where MONTH(ngaylap) = @thang and year(ngaylap) = @nam 
group by TenPhim, month(NgayLap)
end
go

create PROCEDURE sp_TKLX_TheoNam(@nam int)
as
begin
select MONTH(hd.NgayLap) as 'Thang',count(hdct.Mave) as 'LuotXem' from HoaDonChiTiet hdct 
inner join hoadon hd on hdct.MaHoaDon=hd.MaHoaDon
inner join ve on ve.MaVe = hdct.MaVe
where year(hd.NgayLap) = @nam 
group by month(hd.NgayLap)
end
go

Create proc sp_doanhThuHomNay
as
begin
select sum(thanhtien) from hoadon	where day(ngaylap) = day(getDate()) 
and month(ngaylap) = month(getdate()) 
and YEAR(ngaylap) = year(getdate())
group by day(ngaylap),month(ngaylap) ,YEAR(ngaylap)
end
go

Create proc sp_doanhThuHomQua
as
begin
select sum(thanhtien) from hoadon	where day(ngaylap) = day(DATEADD(day, -1, CAST(GETDATE() AS date)))
and month(ngaylap) = month(DATEADD(day, -1, CAST(GETDATE() AS date)))
and YEAR(ngaylap) = year(DATEADD(day, -1, CAST(GETDATE() AS date)))
group by day(ngaylap),month(ngaylap) ,YEAR(ngaylap)
end
go

Create proc sp_doanhThuDichVuHomNay
as
begin
select sum(HoaDonChiTiet.ThanhTien) from hoadon inner join HoaDonChiTiet on hoadon.MaHoaDon = HoaDonChiTiet.MaHoaDon
where day(ngaylap) = day(getDate()) 
and month(ngaylap) = month(getdate()) 
and YEAR(ngaylap) = year(getdate())
and MaDichVu is not null
group by day(ngaylap),month(ngaylap) ,YEAR(ngaylap)
end
go

Create proc sp_doanhThuVeHomNay
as
begin
select sum(HoaDonChiTiet.ThanhTien) from hoadon inner join HoaDonChiTiet on hoadon.MaHoaDon = HoaDonChiTiet.MaHoaDon
where day(ngaylap) = day(getDate()) 
and month(ngaylap) = month(getdate()) 
and YEAR(ngaylap) = year(getdate())
and MaVe  is not null
group by day(ngaylap),month(ngaylap) ,YEAR(ngaylap)
end
go

Create proc sp_select5PhimBanChay
as begin
select top 5  Phim.TenPhim, count(ve.mave) from hoadon inner join HoaDonChiTiet on hoadon.MaHoaDon = HoaDonChiTiet.MaHoaDon
inner join ve on HoaDonChiTiet.MaVe = ve.MaVe inner join Phim on phim.MaPhim = ve.MaPhim
where day(ngaylap) = day(getDate()) 
and month(ngaylap) = month(getdate()) 
and YEAR(ngaylap) = year(getdate())
group by phim.tenphim
order by count(ve.MaVe)
end
go

create proc sp_DoanhThuTheoGio
as begin
select CONCAT( DATEPART(hour,ngaylap),':',DATEPART(minute,ngaylap)),ThanhTien from hoadon	where day(ngaylap) = day(getDate()) 
and month(ngaylap) = month(getdate()) 
and YEAR(ngaylap) = year(getdate())
order by NgayLap 
end
go