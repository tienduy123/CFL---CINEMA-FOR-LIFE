
package DAO;

import Entity.NhanVien;
import Utilities.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends QLRapPhimDAO<NhanVien, String> {

    private String INSERT_SQL = "INSERT INTO [NhanVien]([HoTen],[SDT],[Email],[GioiTinh],[ChucVu],[MatKhau],[Hinh],[GhiChu],[HIDE]) VALUES (?,?,?,?,?,?,?,?,?)";
    private String UPDATE_SQL = "UPDATE [NhanVien] SET [HoTen] = ?, [SDT] = ?, [Email] =?, [GioiTinh] = ?, [ChucVu] = ?, [Hinh] = ? ,[GhiChu] =? WHERE [MaNhanVien] = ?";
    private String UPDATE_PASSWORD = "UPDATE [NhanVien] SET [MatKhau] = ? Where [MaNhanVien]= ?";
    private String DELETE_SQL = "UPDATE [NhanVien] SET HIDE = 1 WHERE [MaNhanVien] = ?";
    private String SELECT_BY_ID = "SELECT * FROM NhanVien WHERE [HIDE] = 0 AND [MaNhanVien] like ?";
    private String SELECT_ALL = "SELECT * FROM NhanVien WHERE [HIDE] = 0";

    @Override
    public void insert(NhanVien entity) {
        XJdbc.update(INSERT_SQL, entity.getHoTen(), entity.getSDT(), entity.getEmail(), entity.gioitinh(), entity.chucvu(), "123", entity.getHinh(), entity.getGhiChu(), 0);
    }

    @Override
    public void update(NhanVien entity) {
        XJdbc.update(UPDATE_SQL, entity.getHoTen(), entity.getSDT(), entity.getEmail(), entity.gioitinh(), entity.chucvu(), entity.getHinh(), entity.getGhiChu(), entity.getMaNhanVien());
    }

    public void UpdatePassword(NhanVien entity) {
        XJdbc.update(UPDATE_PASSWORD, entity.getMatKhau(), entity.getMaNhanVien());
    }

    @Override
    public void delete(String key) {
        XJdbc.update(DELETE_SQL, key);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECT_ALL);
    }

    public List<NhanVien> selectbykey(String key) {
        return this.selectBySql(SELECT_BY_ID, key);
    }

    @Override
    public NhanVien selectById(String key) {
        List<NhanVien> list = selectBySql(SELECT_BY_ID, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                NhanVien nv = readFromResultSet(rs);
                list.add(nv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien nv = new NhanVien();
        nv.setMaNhanVien(rs.getString("MaNhanVien"));
        nv.setHoTen(rs.getNString("HoTen"));
        nv.setSDT(rs.getString("SDT"));
        nv.setEmail(rs.getString("Email"));
        nv.setGioiTinh(rs.getBoolean("GioiTinh"));
        nv.setChucVu(rs.getBoolean("ChucVu"));
        nv.setMatKhau(rs.getString("MatKhau"));
        nv.setHinh(rs.getString("Hinh"));
        nv.setGhiChu(rs.getString("GhiChu"));
        nv.setHIDE(rs.getBoolean("HIDE"));
        return nv;
    }
}
