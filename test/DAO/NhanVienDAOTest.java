/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import Entity.NhanVien;
import java.sql.ResultSet;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DELL
 */
public class NhanVienDAOTest {
    
    public NhanVienDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of insert method, of class NhanVienDAO.
     */
    @Test
    public void testInsertNVcase1() {
        System.out.println("insert");
        NhanVien entity = new NhanVien("NV4", "Ngô Tiến Duy", "0123456789", "email@email.com", true, true, "123", "duy.jpg", true);
        NhanVienDAO instance = new NhanVienDAO();
        instance.insert(entity);
    }
    @Test
    public void testInsertNVcase2() {
        System.out.println("insert");
        NhanVien entity = new NhanVien(null, "Ngô Tiến Duy", "0123456789", "email@email.com", true, true, "123", "duy.jpg", true);
        NhanVienDAO instance = new NhanVienDAO();
        instance.insert(entity);
    }
    @Test
    public void testInsertNVcase3() {
        System.out.println("insert");
        NhanVien entity = new NhanVien(null, null, "0123456789", null, true, true, "123", null, true);
        NhanVienDAO instance = new NhanVienDAO();
        instance.insert(entity);
    }
}
