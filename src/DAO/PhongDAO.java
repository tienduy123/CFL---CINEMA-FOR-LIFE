
package DAO;

import Entity.Phong;
import Utilities.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongDAO extends QLRapPhimDAO<Phong, String> {

    static String selectall = "Select * from Phong";
    static String selectbyid = "Select * from Phong where maphong like";

    @Override
    public void insert(Phong entity) {
    }

    @Override
    public void update(Phong entity) {
    }

    @Override
    public void delete(String key) {
    }

    @Override
    public List<Phong> selectAll() {
        return selectBySql(selectall);
    }

    @Override
    public Phong selectById(String key) {
        List<Phong> list = selectBySql(selectbyid, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<Phong> selectBySql(String sql, Object... args) {
        List<Phong> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Phong p = new Phong(rs.getInt(1),rs.getString(2),rs.getBoolean(3));
                list.add(p);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public Phong readFromResultSet(ResultSet rs) throws SQLException {
       Phong obj = new Phong();
        return obj;
    }
}
