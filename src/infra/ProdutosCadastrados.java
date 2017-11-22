package infra;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.FileManager;
import util.Strings;
import util.exceptions.EntidadeNaoPodeSerAtualizadaException;

/**
 *
 * @author lhfba
 */
public class ProdutosCadastrados implements Serializable{
    /**
     * hash de entidades, onde a chave é o identificador e o valor é a Entidade em si
     */
    private Map<String, Produto> produtos;
    private final FileManager fileManager = FileManager.getFileMager();
    private static final ProdutosCadastrados PRODUTOS_CADASTRADOS = new ProdutosCadastrados();
    
    
    /**
     * Construtor que iniciar o hash de produtos lendo do HD
     */
    private ProdutosCadastrados() {
        try {
            produtos = (Map<String, Produto>) fileManager.readObject(Strings.DIRETORIO_PRODUTOS_CADASTRADOS);
        } catch (IOException ex) {
            System.out.println("arquivo nao encontrado, criando novo:");
            produtos = new HashMap<>();
            //Logger.getLogger(ProdutosCadastrados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro na leitura do arquivo, criando novo:");
            produtos = new HashMap<>();
        }
    }
    

    /**
     * Retorna sempre a mesma instancia desta classe
     * @return 
     */
    public synchronized static ProdutosCadastrados getInstanciaProdutosCadastrados() {
        return PRODUTOS_CADASTRADOS;
    }
    
    
    /**
     * Salva lista no HD
     */
    public void salvarLista(){
        try {
            fileManager.saveObject(produtos, Strings.DIRETORIO_PRODUTOS_CADASTRADOS);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo");
            Logger.getLogger(ProdutosCadastrados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Carrega lista do HD
     * @return 
     */
    private Map<String, Produto> carregarLista(){
        try {
            return (Map<String, Produto>) fileManager.readObject(Strings.DIRETORIO_PRODUTOS_CADASTRADOS);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar arquivo");
            Logger.getLogger(ProdutosCadastrados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * dado o codigo, busca informações de um produto
     * @param codigo
     * @return 
     */
    public Produto getProduto(String codigo) {
        return produtos.get(codigo);
    }
    
    /**
     * atualiza um produto existente, caso ele exista.
     * Se nao existir, ele informa um erro
     * @param novoProduto 
     * @throws util.exceptions.EntidadeNaoPodeSerAtualizadaException 
     */
    public void atualizarProduto(Produto novoProduto) throws EntidadeNaoPodeSerAtualizadaException{
        // verifica se o produto existe
        if (this.produtos.containsKey(novoProduto.getCodigo())){
            // atualizar
            this.addProdutos(novoProduto);
            
        }
        // caso nao exista: informa um ero
        throw new EntidadeNaoPodeSerAtualizadaException("Produto não existe");
        
    }

    /**
     * adiciona um produto ao hash
     * @param produtos formato do hash: <br>
     * "String, Produto"
     */
    public void addProdutos(Map<String, Produto> produtos) {
        this.produtos.putAll(produtos);
    }

    /**
     * adiciona um produto ao hash
     * @param novoProduto
     */
    public void addProdutos(Produto novoProduto) {
        this.produtos.put(novoProduto.getCodigo(), novoProduto);
    }

    public Map<String, Produto> getProdutos() {
        return produtos;
    }
}
