package Business;

import infra.Entidade;
import infra.Usuario;
import java.util.Date;
import java.util.HashMap;
import util.exceptions.HashMapInvalidoException;
import util.Strings;

/**
 *
 * @author lhfba
 */
public class FabricaUsuario extends Fabrica{

    /**
     * Cria um usuário
     * @param map HashMap com os valores das variaveis de usuario
     * @return Entidade - Usuario
     * @throws HashMapInvalidoException Caso falte algum dado no Map
     */
    @Override
    public Entidade getInstancia(HashMap<String, Object> map) throws HashMapInvalidoException{
        
        if(map.get(Strings.KEY_USUARIO_CPF)==null || map.get(Strings.KEY_USUARIO_CPF) == ""){
            throw new HashMapInvalidoException("cpf do usuario nao informado");
        }
        if(map.get(Strings.KEY_USUARIO_NASCIMENTO)==null || map.get(Strings.KEY_USUARIO_NASCIMENTO)==""){
            throw new HashMapInvalidoException("data de nascimento do usuario nao informado");
        }
        if(map.get(Strings.KEY_USUARIO_NOME)==null || map.get(Strings.KEY_USUARIO_NOME) == ""){
            throw new HashMapInvalidoException("nome do usuario nao informado");
        }
        
        if(map.get(Strings.KEY_USUARIO_LOGIN)==null || map.get(Strings.KEY_USUARIO_LOGIN) == ""){
            throw new HashMapInvalidoException("login do usuario nao informado");
        }
        
        if(map.get(Strings.KEY_USUARIO_SENHA)==null || map.get(Strings.KEY_USUARIO_SENHA) == ""){
            throw new HashMapInvalidoException("senha do usuario nao informado");
        }
        
        return new Usuario(
                (String) map.get(Strings.KEY_USUARIO_NOME),
                (Date) map.get(Strings.KEY_USUARIO_NASCIMENTO),
                (String) map.get(Strings.KEY_USUARIO_CPF),
                (String) map.get(Strings.KEY_USUARIO_LOGIN),
                (String) map.get(Strings.KEY_USUARIO_SENHA)
                
        );
    }
    
}
