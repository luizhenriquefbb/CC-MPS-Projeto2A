/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import util.FileManager;
import infra.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author lhfba
 */
public class FileManagerTest {
    FileManager fileManager;
    
    File file_map = new File("map_teste_salvamento.objeto");
    File file_usuario = new File("map_teste_salvamento.objeto");
    
    public FileManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        fileManager = FileManager.getFileMager();
    }
    
    /**
     * Quando acabar o metodo
     */
    @After
    public void tearDown() {
        
        file_map.delete();
        file_usuario.delete();
       
    }

    @Test
    public void testarSalvarObjeto(){
        System.out.println("testando salvar Usuario");
        
        Usuario pessoa = new Usuario("nome1", new Date(), "cpf1", new ArrayList(), "login1", "senha1");
        
        try {
            fileManager.saveObject(pessoa, file_usuario.getPath());
        } catch (IOException ex) {
            Logger.getLogger(FileManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Nao deveria dar erro");
        }
        
        setUp();
        System.out.println("testando salvar um map");
        
        HashMap<String, Object> map = new HashMap();
        map.put("Chave1", "valor1");
        map.put("Chave2", "valor2");
        
        try {
            fileManager.saveObject(map, file_map.getPath());
        } catch (IOException ex) {
            Logger.getLogger(FileManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Nao deveria dar erro");
        }
    }
    
    @Test
    public void testarCarregarObjeto(){
        System.out.println("testando carregar Objeto");
        
        this.testarSalvarObjeto();
        
        Usuario pessoa = null;
        
        try {
            pessoa = (Usuario) fileManager.readObject("pessoa_teste_salvamento.objeto");
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FileManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Nao deveria dar erro");
        }
        
        System.out.println(pessoa);
        
        
        Object map=null;
        try {
            map = fileManager.readObject("map_teste_salvamento.objeto");
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FileManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Nao deveria dar erro");
        }
        
        System.out.println(map);
        
    }


    
}
