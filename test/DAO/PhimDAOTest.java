/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import Entity.Phim;
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
public class PhimDAOTest {
    
    public PhimDAOTest() {
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
     * Test of insert method, of class PhimDAO.
     */
    @Test
    public void testInsertcase3() {
        System.out.println("insert");
        Phim entity = new Phim(MP1, TenPhim, NgayKhoiChieu, NgayKetThuc, QuocGia, MaTheLoai, DinhDang, Hinh, MaNhanVien, true);
        PhimDAO instance = new PhimDAO();
        instance.insert(entity);
    }
}
