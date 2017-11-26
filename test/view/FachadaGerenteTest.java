/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.Memento;
import infra.Produto;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.exceptions.HashMapInvalidoException;
import util.Strings;

/**
 *
 * @author lhfba
 */
public class FachadaGerenteTest {
    
    
    HashMap<String, Object> entrada;
    Fachada fachada;
    
    public FachadaGerenteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * Antes dos métodos
     */
  @Before
    public void setUp() {
        entrada = new HashMap<>();
        fachada = null;
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testarGerarRelatorioDeProdutos(){
        System.out.println("gerando relatorio de produtos");
        
        // exemplo que funciona
        entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_GERAR_RELATORIO_PRODUTOS);
        fachada = new FachadaGerente(entrada);
        try {
            fachada.agir();
        } catch (HashMapInvalidoException ex) {
            Logger.getLogger(FachadaGerenteTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("nao deveria dar erro");
        }
        
        //exemplo que nao funciona
        entrada.clear();
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
            fail("deveria dar erro de acao");
        } catch (HashMapInvalidoException ex) {
            System.out.println("sucesso, deu erro!");
            
        }
        
        
    }
    
    @Test
    public void testarGerarRelatorioDeClientesAtivos(){
        System.out.println("gerando relatorio de clientes ativos");
        
        
        // exemplo que funciona
        entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_GERAR_RELATORIO_CLIENTES_ATIVOS);
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
        } catch (HashMapInvalidoException ex) {
            Logger.getLogger(FachadaGerenteTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("nao deveria dar erro");
        }
        
        //exemplo que nao funciona
        entrada.clear();
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
            fail("deveria dar erro de acao");
        } catch (HashMapInvalidoException ex) {
            System.out.println("sucesso, deu erro!");
        }
    }

    
    @Test
    public void testarCadastrarUmProduto(){
        System.out.println("cadastrando um produto");
        
        
        
        // exemplo que funciona
        entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_CADASTRAR_PRODUTO);
        entrada.put(Strings.KEY_PRODUTO_NOME, "Produto2");         
        entrada.put(Strings.KEY_PRODUTO_CODIGO, "codigo2");
        entrada.put(Strings.KEY_PRODUTO_PRECO, 2.50);
        
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
        } catch (HashMapInvalidoException ex) {
            Logger.getLogger(FachadaGerenteTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("nao deveria dar erro");
        }
        
        //exemplo que nao funciona
        entrada.clear();
        entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_CADASTRAR_PRODUTO);
        //entrada.put(Strings.KEY_NOME_PRODUTO, "Produto1");         
        entrada.put(Strings.KEY_PRODUTO_CODIGO, "codigo1");
        entrada.put(Strings.KEY_PRODUTO_PRECO, 2.50);
        
        fachada = new FachadaGerente(entrada);
        try {
            fachada.agir();
            fail("deveria dar erro");
        } catch (HashMapInvalidoException ex) {
            System.out.println("sucesso, deu erro!");
        }
        
        //exemplo que nao funciona
        entrada.clear();
        entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_CADASTRAR_PRODUTO);
        entrada.put(Strings.KEY_PRODUTO_NOME, "Produto1");         
        //entrada.put(Strings.KEY_CODIGO_PRODUTO, "codigo1");
        entrada.put(Strings.KEY_PRODUTO_PRECO, 2.50);
        
        fachada = new FachadaGerente(entrada);
        try {
            fachada.agir();
            fail("deveria dar erro");
        } catch (HashMapInvalidoException ex) {
            System.out.println("sucesso, deu erro!");
        }
        
        //exemplo que nao funciona
        entrada.clear();
        entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_CADASTRAR_PRODUTO);
        entrada.put(Strings.KEY_PRODUTO_NOME, "Produto1");         
        entrada.put(Strings.KEY_PRODUTO_CODIGO, "codigo1");
       //entrada.put(Strings.KEY_PRECO_PRODUTO, 2.50);
        
       fachada = new FachadaGerente(entrada);
        try {
            fachada.agir();
            fail("deveria dar erro");
        } catch (HashMapInvalidoException ex) {
            System.out.println("sucesso, deu erro!");
        }
    }
    
    @Test
    public void testarBuscarUmProduto(){
        System.out.println("Testando buscar um produto");
        
        String codigoProdutoBuscado = "codigo1";
        
        //cadastrar o produto que vou procurar
        entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_CADASTRAR_PRODUTO);
        entrada.put(Strings.KEY_PRODUTO_NOME, "Produto2");         
        entrada.put(Strings.KEY_PRODUTO_CODIGO, codigoProdutoBuscado);
        entrada.put(Strings.KEY_PRODUTO_PRECO, 2.50);
        
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
        } catch (HashMapInvalidoException ex) {
            Logger.getLogger(FachadaGerenteTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //buscar o produto
        entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_BUSCAR_PRODUTO);
        entrada.put(Strings.KEY_PRODUTO_CODIGO, codigoProdutoBuscado);
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
        } catch (HashMapInvalidoException ex) {
            Logger.getLogger(FachadaGerenteTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Produto produto = (Produto) fachada.getEntidade();
        System.out.println(produto);
        assertTrue("produto null", produto!=null);
       
    }
    
    
    
    @Test
    public void testarGerarLinkDoProduto(){
        
        System.out.println("Gerando link do produto");
        
        
        
        // exemplo que funciona
        entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_GERAR_LINK_DE_PRODUTO_A);
        entrada.put(Strings.KEY_PRODUTO_CODIGO, "codigo1");
        
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
        } catch (HashMapInvalidoException ex) {
            Logger.getLogger(FachadaGerenteTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("nao deveria dar erro");
        }
    
       // exemplo que não funciona
        entrada.clear();
        entrada.put(Strings.ENTRADA_ACAO, "comando errado");
        entrada.put(Strings.KEY_PRODUTO_NOME, "Produto1");         
        entrada.put(Strings.KEY_PRODUTO_CODIGO, "codigo1");
        entrada.put(Strings.KEY_PRODUTO_PRECO, 2.50);
        
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
            fail("Deveria dar erro: sem o comando");
        } catch (HashMapInvalidoException ex) {
            System.out.println("sucesso: erro esperado");
        }
        
        // exemplo que não funciona
        entrada.clear();
        entrada.put(Strings.ENTRADA_ACAO, "comando errado");
        entrada.put(Strings.KEY_PRODUTO_NOME, "Produto1");         
        //entrada.put(Strings.KEY_PRODUTO_CODIGO, "codigo1");
        entrada.put(Strings.KEY_PRODUTO_PRECO, 2.50);
        
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
            fail("Deveria dar erro: Sem o codigo do produto");
        } catch (HashMapInvalidoException ex) {
            System.out.println("sucesso: erro esperado");
        }
    }
   
    
    @Test
    public void testarCadastrarUsuario(){
        System.out.println("cadastrando usuario");
        
        // exemplo que funciona
        entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_CADASTRAR_USUARIO);
        entrada.put(Strings.KEY_USUARIO_CPF, "CPF2");         
        entrada.put(Strings.KEY_USUARIO_NASCIMENTO, new Date());
        entrada.put(Strings.KEY_USUARIO_NOME, "luiz2");
        entrada.put(Strings.KEY_USUARIO_LOGIN, "luiz2");
        entrada.put(Strings.KEY_USUARIO_SENHA, "luiz2");
        
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
        } catch (HashMapInvalidoException ex) {
            Logger.getLogger(FachadaGerenteTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("nao deveria dar erro");
        }
        
        
        // exemplo que não funciona
        entrada.clear();
        entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_CADASTRAR_USUARIO);
        //entrada.put(Strings.KEY_USUARIO_CPF, "CPF");         
        entrada.put(Strings.KEY_USUARIO_NASCIMENTO, new Date());
        entrada.put(Strings.KEY_USUARIO_NOME, "luiz");
        entrada.put(Strings.KEY_USUARIO_LOGIN, "luiz");
        entrada.put(Strings.KEY_USUARIO_SENHA, "luiz");
        
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
            fail("deveria dar erro: faltando CPF");
        } catch (HashMapInvalidoException ex) {
            System.out.println("Sucesso: erro esperado");
            
        }
        
        // exemplo que não funciona
        //entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_CADASTRAR_USUARIO);
        entrada.clear();
        entrada.put(Strings.KEY_USUARIO_CPF, "CPF");         
        entrada.put(Strings.KEY_USUARIO_NASCIMENTO, new Date());
        entrada.put(Strings.KEY_USUARIO_NOME, "luiz");
        entrada.put(Strings.KEY_USUARIO_LOGIN, "luiz");
        entrada.put(Strings.KEY_USUARIO_SENHA, "luiz");
        
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
            fail("deveria dar erro: faltando comando");
        } catch (HashMapInvalidoException ex) {
            System.out.println("Sucesso: erro esperado");
            
        }
        
        // exemplo que não funciona
        entrada.put(Strings.ENTRADA_ACAO, "comando errado");
        entrada.clear();
        entrada.put(Strings.KEY_USUARIO_CPF, "CPF");         
        entrada.put(Strings.KEY_USUARIO_NASCIMENTO, new Date());
        entrada.put(Strings.KEY_USUARIO_NOME, "luiz");
        entrada.put(Strings.KEY_USUARIO_LOGIN, "luiz");
        entrada.put(Strings.KEY_USUARIO_SENHA, "luiz");
        
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
            fail("deveria dar erro: comando errado");
        } catch (HashMapInvalidoException ex) {
            System.out.println("Sucesso: erro esperado");
            
        }
    }
    
    @Test
    public void testarEditarPerfil(){
        System.out.println("testando editar perfil");
        System.out.println("exemplo que funciona");
        
        entrada.put(Strings.ENTRADA_ACAO,Strings.ACAO_CADASTRAR_USUARIO);
        entrada.put(Strings.KEY_USUARIO_CPF,"cpf_qualquer");
        entrada.put(Strings.KEY_USUARIO_NASCIMENTO ,new Date());
        entrada.put(Strings.KEY_USUARIO_NOME ,"Nome qualquer");
        entrada.put(Strings.KEY_USUARIO_LOGIN, "luiz");
        entrada.put(Strings.KEY_USUARIO_SENHA, "luiz");
        
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
        } catch (HashMapInvalidoException ex) {
            Logger.getLogger(FachadaGerenteTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Nao deveria dar erro");
        }
        
        
        
        System.out.println("Exemplos que nao funcionam");
        setUp();
        entrada.put(Strings.ENTRADA_ACAO,Strings.ACAO_CADASTRAR_USUARIO);
        //entrada.put(Strings.KEY_USUARIO_CPF,"cpf_qualquer");
        entrada.put(Strings.KEY_USUARIO_NASCIMENTO ,new Date());
        entrada.put(Strings.KEY_USUARIO_NOME ,"Nome qualquer");
        entrada.put(Strings.KEY_USUARIO_LOGIN, "luiz");
        entrada.put(Strings.KEY_USUARIO_SENHA, "luiz");
        
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
            fail("deveria dar erro: sem CPF");
        } catch (HashMapInvalidoException ex) {
            System.out.println("Sucesso: Erro esperado");
            
        }
        
        
        setUp();
        //entrada.put(Strings.ENTRADA_ACAO,Strings.ACAO_CADASTRAR_USUARIO);
        entrada.put(Strings.KEY_USUARIO_CPF,"cpf_qualquer");
        entrada.put(Strings.KEY_USUARIO_NASCIMENTO ,new Date());
        entrada.put(Strings.KEY_USUARIO_NOME ,"Nome qualquer");
        entrada.put(Strings.KEY_USUARIO_LOGIN, "luiz");
        entrada.put(Strings.KEY_USUARIO_SENHA, "luiz");
        
        fachada = new FachadaGerente(entrada);
        
        try {
            fachada.agir();
            fail("deveria dar erro: sem comando");
        } catch (HashMapInvalidoException ex) {
            System.out.println("Sucesso: Erro esperado");
            
        }
    }
    
    @Test
    public void testarMemento(){
                
        Memento memento = new Memento();
        
        

    }
    
   
    
}