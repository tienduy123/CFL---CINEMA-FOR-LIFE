
package DAO;

import Entity.Phim;
import Entity.TheLoai;
import Utilities.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TheLoaiDAO extends QLRapPhimDAO<TheLoai, String> {
    
    private String INSERT_SQL = "INSERT INTO [TheLoai]([TenTheLoai], [HIDE]) VALUES (?,?)";
    private String UPDATE_SQL = "UPDATE [TheLoai] SET [MaTheLoai] = ?,[TheLoai] = ?,[HIDE] = ? WHERE [MaTheLoai]";
    private String DELETE_SQL = "UPDATE [TheLoai] SET [HIDE] = 1 WHERE [MaTheLoai] = ?";
    private String SELECT_BY_ID = "SELECT * FROM TheLoai WHERE [HIDE] = 0 AND [MaTheLoai] = ?";
    private String SELECT_ALL = "SELECT * FROM TheLoai WHERE [HIDE] = 0";
    
    @Override
    public void insert(TheLoai entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getTenTheLoai() , entity.isHIDE());
        } catch (Exception e) {
            Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(TheLoai entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getTenTheLoai() , entity.isHIDE());
        } catch (Exception e) {
            Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
    }

    @Override
    public void delete(String key) {
        try {
            XJdbc.update(DELETE_SQL, key);
        } catch (Exception e) {
            Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<TheLoai> selectAll() {
        return this.selectBySql(SELECT_ALL);
    }

    @Override
    public TheLoai selectById(String key) {
        List<TheLoai> list = this.selectBySql(SELECT_BY_ID, key);
        if(list.isEmpty())
            return null;
        return list.get(0);
    }

    @Override
    protected List<TheLoai> selectBySql(String sql, Object... args) {
        List<TheLoai> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while(rs.next()) {
                TheLoai tl = new TheLoai();
                tl.setMaTheLoai(rs.getString("MaTheLoai"));
                tl.setTenTheLoai(rs.getString("TenTheLoai"));
                tl.setHIDE(rs.getBoolean("HIDE"));
                list.add(tl);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
