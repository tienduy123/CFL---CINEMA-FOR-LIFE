
package DAO;

import Utilities.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThongKeDAO {

    private List<Object[]> getList(String sql, String cols[], Object... args) throws SQLException {
        List<Object[]> list = new ArrayList<>();
        ResultSet rs = XJdbc.query(sql, args);
        while (rs.next()) {
            Object[] vals = new Object[cols.length];
            for (int i = 0; i < vals.length; i++) {
                vals[i] = rs.getObject(cols[i]);                                        
            }
            list.add(vals);
        }
        return list;
    }

    public List<Object[]> getDoanhThuNam() throws SQLException {
        List<Object[]> list = new ArrayList<>();
        String sql = "{CALL SP_DOANHTHUNAM}";
        ResultSet rs = XJdbc.query(sql);
        while (rs.next()) {
            Object[] a = {rs.getString(2), rs.getString(3)};
            list.add(a);
        }
        return list;
    }

    public Double[] getDoanhThuTheoVeVaDichvu() {
        Double[] db = new Double[2];
        try {
            String sql = "select count(mave), count(madichvu) from HoaDonChiTiet";
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                db[0] = rs.getDouble(1);
                db[1] = rs.getDouble(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return db;
    }

    public List<Object[]> getDTTungThangTheoNam(String year) {
        List<String> fullMonthList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            fullMonthList.add(String.valueOf(i + 1));
        }
        List<Object[]> list = new ArrayList<>();
        for(int i = 0 ; i < 12 ; i ++){
            list.add(new Object[]{i+1,0});
        }
        try {
            String sql = "{CALL sp_TKDT_TungThangTheoNam(?)}";
            ResultSet rs = XJdbc.query(sql, year);
            while (rs.next()) {
                Object[] a = {rs.getString(1), rs.getString(2)};
                for(int i = 0 ; i < list.size();i++){
                    if(rs.getString(1).equals((String.valueOf(list.get(i)[0])).trim())){
                        list.set(i, a);
                    }
                }
            }            
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    public List<Object[]> getDTTungNgayTheoThang(String year, String month){
        try {
            String sql = "{CALL sp_TKDT_TungNgayTheoThang(?,?)}";
            String cols[] = {"Ngay","TongVe","TongDichVu","TongTienNgay"};
            return this.getList(sql, cols, year, month);
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Object[]> getDTTungNam() throws SQLException{
        String sql = "{CALL sp_DTTungNam}";
        String cols[] = {"Nam","TongVe","TongDichVu","TongTien"};
        return getList(sql, cols);
    }
    public List<Object[]> getDTTungThang(int nam) throws SQLException{
        String sql = "{CALL sp_DTTungThang(?)}";
        String cols[] = {"Thang","TongVe","TongDichVu","TongTien"};
        return getList(sql, cols, nam);
    }
    public List<Object[]> getDTThang(int nam, int thang) throws SQLException{
        String sql = "{CALL sp_DTThang(?,?)}";
        String cols[] = {"Ngay","TongVe","TongDichVu","TongTien"};
        return getList(sql, cols, nam, thang);
    }
    public List<Object[]> getTKLX(String Month, String Year) throws SQLException {
            
            List<Object[]> list = new ArrayList<>();
            String sql = "{CALL sp_TKLX_TheoThang(?,?)}";
            ResultSet rs = XJdbc.query(sql, Month, Year);
            while (rs.next()) {
                Object[] a = {rs.getString(2), rs.getString(1)};
                list.add(a);
                }
        return list;
    }
    public List<Object[]> getTKLX_TheoNam(int Year) throws SQLException {  
            List<Object[]> list = new ArrayList<>();
            String sql = "{CALL sp_TKLX_TheoNam(?)}";
            try {
                ResultSet rs = XJdbc.query(sql, Year);
            while (rs.next()) {
                
                Object[] a = {rs.getString("Thang"), rs.getString("LuotXem")};
                System.out.println(rs.getString("Thang")+ rs.getString("LuotXem"));
                list.add(a);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public double doanhThuHomNay() {
        double doanhThu = 0;
        try {
            String sql = "{CALL sp_doanhThuHomNay}";
            ResultSet rs = XJdbc.query(sql);
            if (rs.next()) {
                doanhThu = rs.getDouble(1);
            } else {
                doanhThu = 0;
            }
            return doanhThu;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doanhThu;
    }

    public double doanhThuHomQua() {
        double doanhThu = 0;
        try {
            String sql = "{CALL sp_doanhThuHomQua}";
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                doanhThu = rs.getDouble(1);
            }
            return doanhThu;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doanhThu;
    }

    public double doanhThuDVHomNay() {
        double doanhThu = 0;
        try {
            String sql = "{CALL sp_doanhThuDichVuHomNay}";//
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                doanhThu = rs.getDouble(1);
            }
            return doanhThu;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doanhThu;
    }

    public double doanhThuVeHomNay() {
        double doanhThu = 0;
        try {
            String sql = "{CALL sp_doanhThuVeHomNay}";//
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                doanhThu = rs.getDouble(1);
            }
            return doanhThu;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doanhThu;
    }

    public List<String> select5PhimBanChay() {
        List<String> list = new ArrayList<>();
        try {
            String sql = "{CALL sp_select5PhimBanChay}";//
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Object[]> doanhThuTheoGio() {
        List<Object[]> list = new ArrayList<>();
        try {
            String sql = "{CALL sp_DoanhThuTheoGio}";//
            ResultSet rs = XJdbc.query(sql);
            while(rs.next()){
                list.add(new Object[]{rs.getString(1),rs.getString(2)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
