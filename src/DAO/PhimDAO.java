

package DAO;

import Entity.Phim;
import Utilities.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PhimDAO extends QLRapPhimDAO<Phim, String> {
    
    private String INSERT_SQL = "INSERT INTO [Phim]([TenPhim],[NgayKhoiChieu],[NgayKetThuc],[QuocGia],[MaTheLoai],[DinhDang],[Hinh],[MaNhanVien],[HIDE]) VALUES (?,?,?,?,?,?,?,?,?)";
    private String UPDATE_SQL = "UPDATE [Phim] SET [TenPhim] = ?, [NgayKhoiChieu] = ?, [NgayKetThuc] = ?, [QuocGia] = ?, [MaTheLoai] = ?,[DinhDang] = ?, [Hinh] = ?, [MaNhanVien] = ?, [HIDE] = ? WHERE [MaPhim] = ?";
    private String DELETE_SQL = "UPDATE [Phim] SET [HIDE] = 1 WHERE [MaPhim] = ?";
    private String SELECT_BY_ID = "SELECT * FROM [Phim] WHERE [HIDE] = 0 AND [MaPhim] = ?";
    private String SELECT_ALL = "SELECT * FROM [Phim] WHERE [HIDE] = 0";

    @Override
    public void insert(Phim entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getTenPhim(), entity.getNgayKhoiChieu(), entity.getNgayKetThuc(), entity.getQuocGia(), entity.getMaTheLoai(), entity.getDinhDang(), entity.getHinh(), entity.getMaNhanVien(), entity.isHIDE());
        } catch (Exception e) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Phim entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getTenPhim(), entity.getNgayKhoiChieu(), entity.getNgayKetThuc(), entity.getQuocGia(), entity.getMaTheLoai(), entity.getDinhDang(), entity.getHinh(), entity.getMaNhanVien(), entity.isHIDE(), entity.getMaPhim());
        } catch (Exception e) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(String key) {
        try {
            XJdbc.update(DELETE_SQL, key);
        } catch (Exception e) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<Phim> selectAll() {
        return this.selectBySql(SELECT_ALL);
    }

    @Override
    public Phim selectById(String key) {
        List<Phim> list = this.selectBySql(SELECT_BY_ID, key);
        if(list.isEmpty())
            return null;
        return list.get(0);
    }

    @Override
    protected List<Phim> selectBySql(String sql, Object... args) {
        List<Phim> list = new ArrayList<Phim>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while(rs.next()) {
                Phim ph = new Phim();
                ph.setMaPhim(rs.getString("MaPhim"));
                ph.setTenPhim(rs.getNString("TenPhim"));
                ph.setNgayKhoiChieu(rs.getDate("NgayKhoiChieu"));
                ph.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                ph.setQuocGia(rs.getNString("QuocGia"));
                ph.setMaTheLoai(rs.getString("MaTheLoai"));
                ph.setDinhDang(rs.getString("DinhDang"));
                ph.setHinh(rs.getString("Hinh"));
                ph.setHIDE(rs.getBoolean("HIDE"));
                list.add(ph);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Phim> selectPhimTheoLichChieu(String ma)
    {
        try {
            List<Phim> list = new ArrayList<>();
            ResultSet rs = XJdbc.query("SELECT ph.TenPhim FROM Phim ph INNER JOIN LichChieu lc ON ph.MaPhim = lc.MaPhim WHERE ph.MaPhim=? and NgayChieu = CONVERT(char(10), GetDate(),126) GROUP BY ph.TenPhim, lc.MaPhim", ma);
            while(rs.next()) {
                Phim ph = new Phim();
                ph.setTenPhim(rs.getString(1));
                list.add(ph);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
