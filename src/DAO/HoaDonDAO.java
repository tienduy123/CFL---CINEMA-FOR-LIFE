
package DAO;

import Entity.HoaDon;
import Utilities.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HoaDonDAO extends QLRapPhimDAO<HoaDon, String> {

    String insertSql = "INSERT INTO [HoaDon]([TongTien],[MaKM],[MaKHTT],[MucGiamGia],[ThanhTien],"
            + "                     [NgayLap],[TrangThai],[MaNhanVien],[HIDE]) "
            + "                      VALUES (?,?,?,?,?,?,?,?,?)";
    
    String updateSql = "UPDATE [HoaDon] SET [TongTien] = ?, [MaKM] = ?, [MaKHTT] = ?, [MucGiamGia] = ?, "
            + "                             [ThanhTien] = ?, [NgayLap] = ?,[TrangThai] = ?, [MaNhanVien] = ?, [HIDE] = ? "
            + "                             WHERE [MaHoaDon] = ?";
    String deleteSql = "UPDATE [HoaDon] SET [HIDE] = 1 WHERE [MaHoaDon] = ?";
    String select_All_Sql = "Select * from [HoaDon] where hide = 0";
    String select_sql_byID = "Select * from [HoaDon] WHERE [MaHoaDon] = ? and hide = 0";
    String select_newHD = "Select top(1) MaHoaDon from [HoaDon] order by cast(SUBSTRING(MaHoaDon,3,len(MaHoaDon)) as int) desc";
    String select_year = " select distinct(year(ngaylap)) from HoaDon";

    @Override
    public void insert(HoaDon entity) {
        XJdbc.update(insertSql, entity.getTongTien(), entity.getMaKM(), entity.getMaKHTT(), 
                                entity.getMucGiamGia(),entity.getThanhTien(),entity.getNgayLap(),entity.isTrangThai(),
                                entity.getMaNhanVien(),entity.isHIDE());
        
    }

    @Override
    public void update(HoaDon entity) {
        XJdbc.update(updateSql, entity.getTongTien(), entity.getMaKM(), entity.getMaKHTT(), 
                                entity.getMucGiamGia(),entity.getThanhTien(),entity.getNgayLap(),entity.isTrangThai(),
                                entity.getMaNhanVien(),entity.isHIDE(),entity.getMaHoaDon());
    }

    @Override
    public void delete(String key) {
        XJdbc.update(deleteSql, key);
    }

    @Override
    public List<HoaDon> selectAll() {
        return selectBySql(select_All_Sql);
    }

    @Override
    public HoaDon selectById(String key) {
        return selectBySql(select_sql_byID, key).get(0);
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString("MaHoaDon"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setMaKM(rs.getString("MaKM"));
                hd.setMaKHTT(rs.getString("makhtt"));
                hd.setMucGiamGia(rs.getInt("Mucgiamgia"));
                hd.setThanhTien(rs.getDouble("ThanhTien"));
                hd.setNgayLap(rs.getDate("ngaylap"));
                hd.setHIDE(rs.getBoolean("TrangThai"));
                hd.setMaNhanVien(rs.getString("Manhanvien"));
                hd.setHIDE(rs.getBoolean("hide"));
                list.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public String selectNewHD(){
        String sql = select_newHD;
        try {
            ResultSet rs = XJdbc.query(sql);
            while(rs.next()) {
                return rs.getString("MaHoaDon");
            }
        } catch (Exception e) {
        }
        return null;
    }
    public List<Integer> selectYear(){
          List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(select_year);
            while(rs.next()) {
               list.add(rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return list;        
    }
}
