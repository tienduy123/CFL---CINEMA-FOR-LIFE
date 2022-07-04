
package DAO;

import Entity.DichVu;
import Utilities.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DichVuDAO extends QLRapPhimDAO<DichVu, String> {

    String insertSql = "INSERT INTO [DichVu]([MaDichVu],[TenDichVu],[GiaDichVu],[HIDE]) VALUES (?,?,?,?)";
    String updateSql = "UPDATE [DichVu] SET [TenDichVu] = ?, [GiaDichVu] = ?, [HIDE] = ? WHERE [MaDichVu] = ?";
    String deleteSql = "UPDATE [DichVu] SET [HIDE] = 1 WHERE [MaDichVu] = ?";
    String select_All_Sql = "Select * from [DichVu] where hide = 0";
    String select_sql_byID = "Select * from [DichVu] where [MaDichVu] = ? and hide = 0";

    @Override
    public void insert(DichVu entity) {
        XJdbc.update(insertSql, entity.getMaDichVu(), entity.getTenDichVu(), entity.getGiaDichVu(), entity.isHIDE());
    }

    @Override
    public void update(DichVu entity) {
        XJdbc.update(updateSql, entity.getTenDichVu(), entity.getGiaDichVu(), entity.isHIDE(), entity.getMaDichVu());
    }

    @Override
    public void delete(String key) {
        XJdbc.update(deleteSql, key);
    }

    @Override
    public List<DichVu> selectAll() {
        return  selectBySql(select_All_Sql);
    }

    @Override
    public DichVu selectById(String key) {
        return selectBySql(select_sql_byID, key).get(0);
    }

    @Override
    protected List<DichVu> selectBySql(String sql, Object... args) {
        List<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                list.add(new DichVu(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getBoolean(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<DichVu> selectByMaDV(String ma) {
        return selectBySql(select_sql_byID, ma);
    }
    public double selectByMaDichVu(String maDV)
    {
        String sql = "SELECT GiaDichVu FROM DichVu WHERE MaDichVu=? AND HIDE=0";
        try {
            ResultSet rs = XJdbc.query(sql, maDV);
            while(rs.next())
            {
                return rs.getDouble(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
