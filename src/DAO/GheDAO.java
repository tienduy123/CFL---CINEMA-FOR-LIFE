
package DAO;

import Entity.Ghe;
import Utilities.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GheDAO extends QLRapPhimDAO<Ghe, String>{

    private String INSERT_SQL = "INSERT INTO [Ghe]([MaGhe], [LoaiGhe], [GiaGhe], [MaPhong], [TrangThai]) VALUES (?,?,?,?,?)";
    private String UPDATE_SQL = "UPDATE [Ghe] SET [TrangThai] = 1 WHERE [MaGhe] = ? and [MaPhong] = ? and [GioChieu] = ?";
    private String DELETE_SQL = "DELETE FROM Ghe WHERE [MaGhe] = ?";
    private String SELECT_BY_ID = "SELECT * FROM Ghe WHERE [MaGhe] = ?";
    private String SELECT_ALL = "SELECT * FROM Ghe";
    private String SELECT_BY_MaPhong = "SELECT * FROM Ghe WHERE MaPhong = ? and GioChieu = ? ORDER BY SUBSTRING(MaGhe,1,1), cast(SUBSTRING(MaGhe,2,len(MaGhe)-1) as int) asc";
    private String SELECT_EMPTY_SEAT = "SELECT COUNT(Ghe.MaGhe) as count FROM Ghe WHERE MaPhong = ? and TrangThai = 0 and GioChieu = ?";

    @Override
    public void insert(Ghe entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Ghe entity) {
        XJdbc.update(UPDATE_SQL, entity.getMaGhe(), entity.getMaPhong(), entity.getGioChieu());
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ghe> selectAll() {
        return this.selectBySql(SELECT_ALL);
    }

    @Override
    public Ghe selectById(String key) {
        List<Ghe> list = this.selectBySql(SELECT_BY_ID, key);
        return list.isEmpty() ? list.get(0) : null;
    }

    @Override
    protected List<Ghe> selectBySql(String sql, Object... args) {
        List<Ghe> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while(rs.next()) {
                Ghe gh = new Ghe();
                gh.setMaGhe(rs.getString(1));
                gh.setLoaiGhe(rs.getBoolean(2));
                gh.setGiaGhe(rs.getDouble(3));
                gh.setMaPhong(rs.getString(4));
                gh.setGioChieu(rs.getString(5));
                gh.setTrangThai(rs.getBoolean(6));
                list.add(gh);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Ghe> selectByMaPhong(String maPhong, String gioChieu){
        return this.selectBySql(SELECT_BY_MaPhong, maPhong, gioChieu);
    }
    public int selectEmptySeat(String maPhong, String gioChieu){
        String sql = SELECT_EMPTY_SEAT;
        try {
            ResultSet rs = XJdbc.query(sql, maPhong, gioChieu);
            while(rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
}
