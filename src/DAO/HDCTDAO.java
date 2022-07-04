
package DAO;

import Entity.HDCT;
import Utilities.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HDCTDAO extends QLRapPhimDAO<HDCT, String> {

    String insertSqlVe = "INSERT INTO [HoaDonChiTiet]([MaVe],[GiaTien],[SoLuong],[ThanhTien],[MaHoaDon],[HIDE]) VALUES (?,?,?,?,?,?)";
    String insertSqlDichVu = "INSERT INTO [HoaDonChiTiet]([MaDichVu],"
            + "               [GiaTien],[SoLuong],[ThanhTien],[MaHoaDon],[HIDE]) "
            + "               VALUES (?,?,?,?,?,?)";
    String updateSql = "UPDATE [HoaDonChiTiet] SET [MaDichVu] = ?, [GiaTien] = ?, "
            + "                                    [SoLuong] = ?, [ThanhTien] = ?, [MaHoaDon] = ?, "
            + "                                    [HIDE] = ? WHERE [MaHoaDonChiTiet] = ?";
    String deleteSql = "UPDATE [HoaDonChiTiet] SET [HIDE] = 1 WHERE [MaHoaDonChiTiet] = ?";
    String select_All_Sql = "Select * from [HoaDonChiTiet] where hide = 0";
    String select_sql_byID = "Select * from [HoaDonChiTiet] WHERE [MaHoaDon] = ? and hide = 0 ORDER BY MaHoaDon ASC";

    @Override
    public void insert(HDCT entity) {
       
        
    }

    @Override
    public void update(HDCT entity) {
        XJdbc.update(updateSql, entity.getMaDichVu(),entity.getGiaTien(),
                entity.getSoLuong(),entity.getThanhTien(),entity.getMaHoaDon(),
                entity.isHIDE(),entity.getMaHoaDonChiTiet());       
    }

    @Override
    public void delete(String key) {
        XJdbc.update(deleteSql, key);
    }

    @Override
    public List<HDCT> selectAll() {
        return  selectBySql(select_All_Sql);
    }

    @Override
    public HDCT selectById(String key) {
        return selectBySql(select_sql_byID, key).get(0);
    }

    @Override
    protected List<HDCT> selectBySql(String sql, Object... args) {
        List<HDCT> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                HDCT hdct = new HDCT();
                hdct.setMaHoaDonChiTiet(rs.getString("MaHoaDonChiTiet"));
                if(rs.getString("MaVe") == (null)) {
                    hdct.setMaDichVu(rs.getString("MaDichVu"));
                }
                else {
                    hdct.setMaDichVu(rs.getString("MaVe"));
                }
                hdct.setGiaTien(rs.getDouble("GiaTien"));
                hdct.setSoLuong(rs.getInt("SoLuong"));
                hdct.setThanhTien(rs.getDouble("ThanhTien"));
                hdct.setMaHoaDon(rs.getString("MaHoaDon"));
                hdct.setHIDE(rs.getBoolean("HIDE"));
                list.add(hdct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public void insertVe(HDCT entity) {
        XJdbc.update(insertSqlVe,entity.getMaDichVu(),entity.getGiaTien(),entity.getSoLuong(),entity.getThanhTien(),entity.getMaHoaDon(),entity.isHIDE());
    }
    public void insertDichVu(HDCT entity) {
        XJdbc.update(insertSqlDichVu, entity.getMaDichVu(),entity.getGiaTien(),entity.getSoLuong(),entity.getThanhTien(),entity.getMaHoaDon(),entity.isHIDE());
    }
    public List<HDCT> selectByID(String id) {
        return this.selectBySql(select_sql_byID, id);
    }
    
    public double getTongTien(String maHD) {
        String sql = "select sum(ThanhTien) from HoaDonChiTiet where MaHoaDon = ?";
        try {
            ResultSet rs = XJdbc.query(sql, maHD);
            while(rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

}
