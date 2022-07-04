

package DAO;

import Entity.LichChieu;
import Utilities.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LichChieuDAO extends QLRapPhimDAO<LichChieu, String> {
    
    private String INSERT_SQL = "INSERT INTO [LichChieu]([NgayChieu],[GioChieu],[MaPhim],[MaPhong],[HIDE]) VALUES (?,?,?,?,?)";
    private String UPDATE_SQL = "UPDATE [LichChieu] SET [NgayChieu] = ?, [GioChieu] = ?,[MaPhim] = ?,[MaPhong] = ?,[HIDE] = ? WHERE [MaLichChieu] = ?";
    private String DELETE_SQL = "UPDATE [LichChieu] SET [HIDE] = 1 WHERE [MaLichChieu] = ?";
    private String SELECT_BY_ID = "SELECT * FROM LichChieu WHERE [HIDE] = 0 AND [MaLichChieu] = ?";
    private String SELECT_ALL = "SELECT * FROM LichChieu WHERE [HIDE] = 0";
    private String SELECT_BY_LC = "SELECT ph.MaPhim Phim FROM LichChieu lc INNER JOIN Phim ph ON lc.MaPhim = ph.MaPhim where NgayChieu = CONVERT(char(10), GetDate(),126) and lc.HIDE = 0 GROUP BY ph.MaPhim, NgayChieu";
    private String SELECT_ALL_BY_MaPhim = "Select * from lichchieu where maphim = ? and HIDE = 0";
    private String SELECT_ALL_BY_DATE = "Select * from Lichchieu where ngaychieu between ? and ? and hide =0";
    private String SELECT_ALL_BY_LastDateNull = "select * from LichChieu where NgayChieu between ? and (select max(ngaychieu) from lichchieu) and hide =0";
    
    @Override
    public void insert(LichChieu entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getNgayChieu(), entity.getGioChieu(), entity.getMaPhim(), entity.getMaPhong(), entity.isHIDE());
        } catch (Exception e) {
            Logger.getLogger(LichChieuDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(LichChieu entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getNgayChieu(), entity.getGioChieu(), entity.getMaPhim(), entity.getMaPhong(), entity.isHIDE(), entity.getMaLichChieu());
        } catch (Exception e) {
            Logger.getLogger(LichChieuDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(String key) {
        try {
            XJdbc.update(DELETE_SQL, key);
        } catch (Exception e) {
            Logger.getLogger(LichChieuDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<LichChieu> selectAll() {
        return this.selectBySql(SELECT_ALL);
    }

    @Override
    public LichChieu selectById(String key) {
        List<LichChieu> list = this.selectBySql(SELECT_BY_ID, key);
        if(list.isEmpty())
            return null;
        return list.get(0);
    }

    @Override
    protected List<LichChieu> selectBySql(String sql, Object... args) {
        List<LichChieu> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while(rs.next()) {
                LichChieu lc = new LichChieu();
                lc.setMaLichChieu(rs.getString("MaLichChieu"));
                lc.setMaPhim(rs.getString("MaPhim"));
                lc.setMaPhong(rs.getString("MaPhong"));
                lc.setNgayChieu(rs.getDate("NgayChieu"));
                lc.setGioChieu(rs.getString("GioChieu"));
                lc.setHIDE(rs.getBoolean("HIDE"));
                list.add(lc);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<LichChieu> selectPhongChieuTheoPhim(String maPhim)
    {
        try {
            List<LichChieu> list = new ArrayList<>();
            ResultSet rs = XJdbc.query("SELECT CONCAT(MaPhong, ' ', lc.GioChieu) as Phong FROM LichChieu lc WHERE MaPhim=? and ngaychieu = CONVERT(char(10), GETDATE(),126) and hide = 0 GROUP BY MaPhim, MaPhong, GioChieu", maPhim);
            while(rs.next()) {
                LichChieu lc = new LichChieu();
                lc.setMaPhong(rs.getString(1));
                list.add(lc);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<LichChieu> selectPhimTheoLichChieu() {
       try {
            List<LichChieu> list = new ArrayList<>();
            ResultSet rs = XJdbc.query(SELECT_BY_LC);
            while(rs.next()) {
                LichChieu lc = new LichChieu();
                lc.setMaPhim(rs.getString(1));
                list.add(lc);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<LichChieu> selectAllByMa(String ma) {
        return selectBySql(SELECT_ALL_BY_MaPhim, ma);
    }
    
    public List<LichChieu> selectByDate(Object ngayDau, Object ngayCuoi) {
        List<LichChieu> list = new ArrayList<>();
        try {
            list = selectBySql(SELECT_ALL_BY_DATE, ngayDau, ngayCuoi);
        } catch (Exception e) {
            list = selectBySql(SELECT_ALL_BY_LastDateNull, ngayDau);
        }
        return list;

        //min(ngaycuoi)
    }

    public List<LichChieu> selectByDateWithoutLastDay(Object ngayDau) {
        return selectBySql(SELECT_ALL_BY_LastDateNull, ngayDau);

        //min(ngaycuoi)
    } 
    
    public String selectLCbyTT(String maphim, String maphong, String giochieu)
    {
        String sql = "select malichchieu from LichChieu where MaPhim = ? and MaPhong = ? and GioChieu = ? and hide = 0";
        try {
            List<LichChieu> list = new ArrayList<>();
            ResultSet rs = XJdbc.query(sql,maphim,maphong,giochieu);
            while(rs.next()) {
                return rs.getString(1);
            }
            rs.getStatement().getConnection().close();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
