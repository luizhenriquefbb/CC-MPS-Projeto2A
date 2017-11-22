/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lhfba
 */
public class FabricaTest {
    
    public FabricaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFabricaUsuario method, of class Fabrica.
     */
    @Test
    public void testGetFabricaUsuario() {
        System.out.println("getFabricaUsuario");
        
        //testando singleton
        Fabrica fabricaUsuario1 = Fabrica.getFabricaUsuario();
        Fabrica fabricaUsuario2 = Fabrica.getFabricaUsuario();
        
        assertTrue(fabricaUsuario1 == (fabricaUsuario2));
    }
    
}
