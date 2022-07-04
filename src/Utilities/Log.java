package Utilities;

import java.util.Date;

public class Log {
      private String user;
      private String maHoaDon;
      private Date thoiGian;
      public String lichSuDangNhap() {
            return this.user;
      }
      public void setLogDangNhap(String user) {
            this.user = user;
      }
      public String lichSuThanhToan() {
            return this.maHoaDon;
      }
      public void setLogThanhToan(String maHoaDon) {
            this.maHoaDon = maHoaDon;
      }
      public Date thoiGianThucHien() {
            return thoiGian;
      }
      public void setLogThoiGian(Date date) {
            this.thoiGian = date;
      }
}