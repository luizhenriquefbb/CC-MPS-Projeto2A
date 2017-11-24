package business;

import infra.Usuario;
import java.util.HashMap;
import util.exceptions.HashMapInvalidoException;

/**
 *
 * @author lhfba
 */
public class CadastrarUsuario extends AcaoComUsuario{

    private final HashMap<String, Object> map;

    public CadastrarUsuario(HashMap<String, Object> map){
        this.map = map;
    }
    
    @Override
    protected void __realizarAcao() throws HashMapInvalidoException{
        
        
        Usuario usuario = (Usuario) this.fabrica.getInstancia(map);
        HashMap<String,Usuario> novoUsuario = new HashMap<>();
        novoUsuario.put(usuario.getLogin(), usuario);
        this.usuariosCadastrados.addUsuarios(novoUsuario);
        
        this.usuariosCadastrados.salvarLista();
        
        System.out.println(">>>> Usuario cadastrado\n"
                +           usuario.toString());
    }
    
    
}
