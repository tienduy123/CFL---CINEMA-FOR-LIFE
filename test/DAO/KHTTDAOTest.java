/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import Entity.KHTT;
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
public class KHTTDAOTest {
    
    public KHTTDAOTest() {
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
     * Test of insert method, of class KHTTDAO.
     */
    @Test
    public void testInsertcase1() {
        System.out.println("insert");
        KHTT entity = new KHTT("KH1", "Tien Duy", "0123456789", "duy@gmail.com", new Date(), 0, 0, "NV1", true);
        KHTTDAO instance = new KHTTDAO();
        instance.insert(entity);
    }
    @Test
    public void testInsertcase2() {
        System.out.println("insert");
        KHTT entity = new KHTT(null, "Tien Duy", "0123456789", "duy@gmail.com", new Date(), 0, 0, "NV1", true);
        KHTTDAO instance = new KHTTDAO();
        instance.insert(entity);
    }
    @Test
    public void testInsertcase3() {
        System.out.println("insert");
        KHTT entity = new KHTT("null", "Tien Duy", "0123456789", null,null, 0, 0, "null", true);
        KHTTDAO instance = new KHTTDAO();
        instance.insert(entity);
    }
}
