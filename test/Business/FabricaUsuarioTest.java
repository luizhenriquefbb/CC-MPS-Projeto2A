/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import business.Fabrica;
import infra.Entidade;
import java.util.Date;
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
public class FabricaUsuarioTest {
    
    public FabricaUsuarioTest() {
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
     * Test of getInstancia method, of class FabricaUsuario.
     */
    @Test
    public void testGetInstancia() {
        System.out.println("getInstancia");
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> map2 = new HashMap<>();
        
        Fabrica fabricaDeUsuario = Fabrica.getFabricaUsuario();
        
        Entidade us1;
        Entidade us2;
        
        // exemplo que funciona
        map.put(Strings.KEY_USUARIO_NOME, "luizin");
        map.put(Strings.KEY_USUARIO_CPF, "cpf qualquer");
        map.put(Strings.KEY_USUARIO_NASCIMENTO, new Date());
        map.put(Strings.KEY_USUARIO_LOGIN, "login1");
        map.put(Strings.KEY_USUARIO_SENHA, "senha");
        
        map2.put(Strings.KEY_USUARIO_NOME, "luizin2");
        map2.put(Strings.KEY_USUARIO_CPF, "cpf qualquer2");
        map2.put(Strings.KEY_USUARIO_NASCIMENTO, new Date());
        map2.put(Strings.KEY_USUARIO_LOGIN, "login1");
        map2.put(Strings.KEY_USUARIO_SENHA, "senha");
        
        try {
            us1 = fabricaDeUsuario.getInstancia(map);
            us2 = fabricaDeUsuario.getInstancia(map2);
        } catch (HashMapInvalidoException ex) {
            Logger.getLogger(FabricaUsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("nao deveria dar erro");
        }
        
        assertTrue(true);
        
        // erro de cpf
        map.clear();
        map2.clear();
        map.put("nome", "luizin");
        map2.put("nome", "luizin");
        
        try {
            us1 = fabricaDeUsuario.getInstancia(map);
            us2 = fabricaDeUsuario.getInstancia(map2);
            fail("devria dar erro de cpf");
        } catch (HashMapInvalidoException ex) {
            System.out.println("deu erro! sucesso");
            assertTrue(true);
        }
    }
    
}
