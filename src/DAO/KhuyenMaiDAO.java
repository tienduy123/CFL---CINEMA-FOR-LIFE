
package DAO;

import Entity.KhuyenMai;
import Utilities.XDate;
import Utilities.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhuyenMaiDAO extends QLRapPhimDAO<KhuyenMai, String> {

    static String insert = "INSERT INTO [KhuyenMai]([MaKM],[TenKM],[ThongTinKM],[MucGiamGia],[NgayBatDau],[NgayKetThuc],[MaNhanVien],[HIDE]) VALUES (?,?,?,?,?,?,?,0)";
    static String update = "Update KhuyenMai Set  [TenKM]=?, ThongTinKM=?,MucGiamGia=?,NgayBatDau=?,NgayKetThuc=? Where MaKM like ?";
    static String updatehide ="Update KhuyenMai Set Hide = 0 Where MaKM like ?";
    static String delete = "Update KhuyenMai Set Hide = 1 Where MaKM like ?";
    static String selectall = "Select * from KhuyenMai Where HIDE = 0;";
    static String selectallbydate = "{CALL SP_SUKIENDANGDIENRA (?)}";
    static String selectbyid = "Select * from KhuyenMai Where MaKM like ? and HIDE = 0";
    private String SELECT_MAKM = "SELECT MaKM FROM KhuyenMai where CONVERT(char(10), GetDate(),126) <= NgayKetThuc and HIDE = 0";

    @Override
    public void insert(KhuyenMai entity) {
        XJdbc.update(insert, entity.getMaKM(), entity.getTenKM(), entity.getThongTinKM(), entity.getMucGiamGia(), entity.getNgayBatDau(), entity.getNgayKetThuc(), entity.getMaNhanVien());
    }

    @Override
    public void update(KhuyenMai entity) {
        XJdbc.update(update, entity.getTenKM(), entity.getThongTinKM(), entity.getMucGiamGia(), entity.getNgayBatDau(), entity.getNgayKetThuc(), entity.getMaKM());
    }

    @Override
    public void delete(String key) {
        XJdbc.update(delete, key);
    }
    public void updatehide(String key) {
        XJdbc.update(updatehide, key);
    }

    @Override
    public List<KhuyenMai> selectAll() {
        return selectBySql(selectall);
    }

    public List<KhuyenMai> selectallbydate() {
        return selectBySql(selectallbydate, new XDate().now());
    }

    @Override
    public KhuyenMai selectById(String key) {
        List<KhuyenMai> list = selectBySql(selectbyid, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<KhuyenMai> selectBySql(String sql, Object... args) {
        List<KhuyenMai> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                KhuyenMai km = readFromResultSet(rs);
                list.add(km);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public KhuyenMai readFromResultSet(ResultSet rs) throws SQLException {
        KhuyenMai obj = new KhuyenMai();
        obj.setMaKM(rs.getString("MaKM"));
        obj.setTenKM(rs.getString("TenKM"));
        obj.setThongTinKM(rs.getString("ThongTinKM"));
        obj.setMucGiamGia(rs.getFloat("MucGiamGia"));
        obj.setNgayBatDau(rs.getDate("NgayBatDau"));
        obj.setNgayKetThuc(rs.getDate("NgayKetThuc"));
        obj.setMaNhanVien(rs.getString("MaNhanVien"));
        obj.setHIDE(rs.getBoolean("HIDE"));
        return obj;
    }
    public List<String> listKhuyenMai()
    {
        try {
            List<String> list = new ArrayList<>();
            ResultSet rs = XJdbc.query(SELECT_MAKM);
            while(rs.next()) {
                list.add(rs.getString(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<KhuyenMai> selectByMaKM(String id) {
        String sql = "SELECT * FROM KhuyenMai WHERE MaKM = ? and hide = 0";
        return this.selectBySql(sql, id);
    }
    
    public int selectMucGiamGia(String maKM){
        String sql = "select MucGiamGia from KhuyenMai where MaKM = ? and hide = 0";
        try {
            ResultSet rs = XJdbc.query(sql, maKM);
            while(rs.next()) {
                return rs.getInt(1);
            }
            rs.getStatement().getConnection().close();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
