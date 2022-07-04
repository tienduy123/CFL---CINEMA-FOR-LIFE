


package com.GUI.form.CustomerAnalysis;

import DAO.QLRapPhimDAO;
import Utilities.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO extends QLRapPhimDAO<Customer, String>{

    String insertSql = "INSERT INTO [Customer]([Gender],[Age],[Date]) VALUES (?,?,?)";
    String selectAll = "SELECT *FROM [Customer]";
    String selectNu = "select gender, avg(age) as ' avgAge', CONVERT(char(10), date,126) as 'day' from [Customer] where gender =0 group by CONVERT(char(10), date,126) , gender";
    String selectNam = "select gender, avg(age) as ' avgAge', CONVERT(char(10), date,126) as 'day' from [Customer] where gender =1 group by CONVERT(char(10), date,126) , gender";

    @Override
    public void insert(Customer entity) {
        XJdbc.update(insertSql, entity.isGender(), entity.getAge(), entity.getDate());
    }

    @Override
    public void update(Customer entity) {
    }

    @Override
    public void delete(String key) {
    }

    @Override
    public List<Customer> selectAll() {
        return selectBySql(selectAll);
    }

    @Override
    public Customer selectById(String key) {
        return null;
    }

    @Override
    protected List<Customer> selectBySql(String sql, Object... args) {
        List<Customer> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                list.add(new Customer(rs.getBoolean(1), rs.getInt(2), rs.getDate(3)));
            }
        } catch (SQLException ex) {
        }
        return list;
    }
    
    public List<Customer> selectNam() {
        return selectBySql(selectNam);
    }
    
    public List<Customer> selectNu() {
        return selectBySql(selectNu);
    }
    
}
