package view;

import guiCliente.Gerente;
import infra.Entidade;
import util.exceptions.CredenciaisErradasException;
import util.exceptions.HashMapInvalidoException;

/**
 *
 * @author lhfba
 */
public class AcaoValidada implements Proxy{
    
    Acao acao;
    private final String login;
    private final String senha;

    public AcaoValidada(Acao acao, String login, String senha) {
        this.acao = acao;
        this.login = login;
        this.senha = senha;
    }

    
    @Override
    public void agir() throws HashMapInvalidoException, CredenciaisErradasException {
        // validar acao
        if (acao == null){
            throw new HashMapInvalidoException("Acao nao informada");
        }
        
        if(    !("admin".equalsIgnoreCase(this.login) && "123".equals(this.senha))    ){
            throw new CredenciaisErradasException("login ou senha inválido");
        }else{
            acao.agir();
        }
        
    }

    
    @Override
    public Entidade getEntidade() {
        return acao.getEntidade();
    }

    public Acao getAcao() {
        return acao;
    }

    
    
}
