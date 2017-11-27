
package infra;

import util.FileManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.Strings;
import util.exceptions.EntidadeNaoPodeSerAtualizadaException;

/**
 * Classe de persistencia. Ela salva e carrega coleções de usuarios
 * @author lhfba
 */
public class UsuariosCadastrados {
    /**
     * colecao de usuarios.
     * um hash onde a chave pe o login, e o valor é o objeto usuário
     */
    private Map<String, Usuario> usuarios;
    private final FileManager fileManager = FileManager.getFileMager();
    
    private static final UsuariosCadastrados USUARIOS_CADASTRADOS = new UsuariosCadastrados();

   
    /**
     * Construtor que iniciar o hash de usuarios lendo do HD
     */
    private UsuariosCadastrados() {
        try {
            usuarios = (Map<String, Usuario>) fileManager.readObject(Strings.DIRETORIO_USUARIOS_CADASTRADOS);
        } catch (IOException ex) {
            System.out.println("arquivo nao encontrado, criando novo:");
            usuarios = new HashMap<>();
            //Logger.getLogger(UsuariosCadastrados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao abrir arquivo, criando novo:");
            usuarios = new HashMap<>();
        }
    }

    /**
     * Retorna sempre a mesma instancia desta classe
     * @return 
     */
    public synchronized static UsuariosCadastrados getInstanciaUsuariosCadastrados() {
        return USUARIOS_CADASTRADOS;
    }
    
    
    /**
     * Salva lista no HD
     */
    public void salvarLista(){
        try {
            fileManager.saveObject(usuarios, Strings.DIRETORIO_USUARIOS_CADASTRADOS);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo");
            Logger.getLogger(UsuariosCadastrados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Carrega lista do HD
     * @return 
     */
    private Map<String, Usuario> carregarLista(){
        try {
            return (Map<String, Usuario>) fileManager.readObject(Strings.DIRETORIO_USUARIOS_CADASTRADOS);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar arquivo");
            Logger.getLogger(UsuariosCadastrados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * dado o login, busca informações de um usuário
     * @param login
     * @return 
     */
    public Usuario getUsuario(String login) {
        return usuarios.get(login);
    }
    
    /**
     * atualiza um usuario existente, caso ele exista.
     * Se nao existir, ele informa um erro
     * @param novoUsuario 
     * @throws util.exceptions.EntidadeNaoPodeSerAtualizadaException 
     */
    public void atualizarUsuario(Usuario novoUsuario) throws EntidadeNaoPodeSerAtualizadaException{
        // verifica se o usuario existe
        if (this.usuarios.containsKey(novoUsuario.getLogin())){
            // atualizar
            this.addUsuarios(novoUsuario);
            
        }else{
            // caso nao exista: informa um ero
            throw new EntidadeNaoPodeSerAtualizadaException("Usuario não existe");
        }
    }

    /**
     * adiciona um usuário ao hash
     * @param usuarios formato do hash: <br>
     * "String, Usuario"
     */
    public void addUsuarios(Map<String, Usuario> usuarios) {
        this.usuarios.putAll(usuarios);
    }

    /**
     * adiciona um usuário ao hash
     * @param novoUsuario
     */
    public void addUsuarios(Usuario novoUsuario) {
        this.usuarios.put(novoUsuario.getLogin(), novoUsuario);
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }
    
    
    
}
