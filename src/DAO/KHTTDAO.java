
package DAO;

import Entity.KHTT;
import Utilities.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KHTTDAO extends QLRapPhimDAO<KHTT, String> {

    String Insert = "INSERT INTO [KhachHangThanThiet]([Ten],[SDT],[Email],[NgayDK],[MucGiamGia],[SoLanSuDung],[MaNhanVien],[HIDE]) "
            + "VALUES (?,?,?,?,?,?,?,?)";
    String Update = "UPDATE [KhachHangThanThiet] SET "
            + "  [Ten] = ?"
            + ", [SDT] = ?"
            + ", [Email] = ?"
            + ", [NgayDK] = ? "
            + ", [MucGiamGia] = ?"
            + ", [SoLanSuDung] = ?"
            + ", [MaNhanVien] = ?"
            + "  WHERE [MaKHTT] = ?";
    String Delete = "UPDATE [KhachHangThanThiet] SET [HIDE] = 1 WHERE [MaKHTT] = ?";
    String SelectAll = "Select * from [KhachHangThanThiet] where hide = 0";
    String Selectbyid = "Select * from [KhachHangThanThiet] where [MaKHTT] = ? and hide = 0";
    String selectmakhbyid = "select MaKHTT from KhachHangThanThiet";
    String selectmucgiamgia = "select MucGiamGia from KhachHangThanThiet WHERE MaKHTT = ?";

    @Override
    public void insert(KHTT entity) {
        XJdbc.update(Insert, entity.getTen(), entity.getSDT(), entity.getEmail(),
                entity.getNgayDK(), entity.getMucGiacGia(), entity.getSoLanSuDung(),
                entity.getMaNhanVien(), 0);

    }

    @Override
    public void update(KHTT entity) {
        XJdbc.update(Update, entity.getTen(), entity.getSDT(), entity.getEmail(),
                entity.getNgayDK(), entity.getMucGiacGia(), entity.getSoLanSuDung(),
                entity.getMaNhanVien(), entity.getMAKHTT());
    }

    @Override
    public void delete(String key) {
        XJdbc.update(Delete, key);
    }

    @Override
    public List<KHTT> selectAll() {
        return selectBySql(SelectAll);
    }

    @Override
    public KHTT selectById(String key) {
        return selectBySql(Selectbyid, key).get(0);
    }

    public List<KHTT> selectbykey(String key) {
        return this.selectBySql(Selectbyid, key);
    }

    @Override
    protected List<KHTT> selectBySql(String sql, Object... args) {
        List<KHTT> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                list.add(readFromResultSet(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int selectMucGiamGia(String maKHTT) {

        try {
            ResultSet rs = XJdbc.query(selectmucgiamgia, maKHTT);
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public List<String> selectMaKHTT() {
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(selectmakhbyid);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public KHTT readFromResultSet(ResultSet rs) throws SQLException {
        KHTT obj = new KHTT();
        obj.setMAKHTT(rs.getString("MaKHTT"));
        obj.setTen(rs.getString("Ten"));
        obj.setSDT(rs.getString("SDT"));
        obj.setEmail(rs.getString("Email"));
        obj.setNgayDK(rs.getDate("NgayDK"));
        obj.setMucGiacGia(rs.getFloat("MucGiamGia"));
        obj.setSoLanSuDung(rs.getInt("SolanSuDung"));
        obj.setMaNhanVien(rs.getString("MaNhanVien"));
        obj.setHIDE(rs.getBoolean("Hide"));
        return obj;
    }
}
