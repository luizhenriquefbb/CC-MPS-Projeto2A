/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import business.Fabrica;
import infra.Entidade;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.exceptions.HashMapInvalidoException;
import util.Strings;

/**
 *
 * @author lhfba
 */
public class FabricaProdutoTest {
    
    public FabricaProdutoTest() {
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
     * Test of getInstancia method, of class FabricaProduto.
     */
    @Test
    public void testGetInstancia(){
        System.out.println("getInstancia");
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> map2 = new HashMap<>();
        
        Fabrica fabricaDeProdutos = Fabrica.getFabricaProduto();
        
        Entidade pr;
        Entidade pr2;
        
        // exemplo que funciona
        map.put(Strings.KEY_PRODUTO_CODIGO, "codigo");
        map.put(Strings.KEY_PRODUTO_NOME, "nome");
        map.put(Strings.KEY_PRODUTO_PRECO, 2.5);
        
        //exemplo que nao funciona
        map2.put(Strings.KEY_PRODUTO_NOME, "nome");
        
        try {
            pr = fabricaDeProdutos.getInstancia(map);
        } catch (HashMapInvalidoException ex) {
            Logger.getLogger(FabricaUsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("nao deveria dar erro");
        }
        
        System.out.println("sucesso");
        
        try {
            pr2 = fabricaDeProdutos.getInstancia(map2);
            fail("deveria dar erro de codigo");
        } catch (HashMapInvalidoException ex) {
            System.out.println("sucesso! deu erro");
            Logger.getLogger(FabricaProdutoTest.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }
    
}
