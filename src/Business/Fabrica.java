package Business;

import infra.Entidade;
import java.util.HashMap;
import util.exceptions.HashMapInvalidoException;

/**
 *
 * @author lhfba
 */
public abstract class Fabrica {
    //singleton pt-1
    private static final Fabrica FABRICA_USUARIO = new FabricaUsuario();
    private static final Fabrica FABRICA_PRODUTO = new FabricaProduto();
    
    //singleton pt-2
    /**
     * @return sempre a mesa instancia de uma fábrica de usuários
     */
    public static synchronized Fabrica getFabricaUsuario(){
        return FABRICA_USUARIO;
    }
    
    /**
     * @return sempre a mesa instancia de uma fábrica de produtos
     */
    public static synchronized Fabrica getFabricaProduto(){
        return FABRICA_PRODUTO;
    }
    
    /**
     * Retorna uma instancia do elemento solicitado
     * @param map
     * @return 
     * @throws util.exceptions.HashMapInvalidoException 
     */
    public abstract Entidade getInstancia(HashMap<String, Object> map) throws HashMapInvalidoException;
}
