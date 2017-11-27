package view;

import gui.Gerente;
import infra.Entidade;
import javax.swing.JOptionPane;
import util.exceptions.CredenciaisErradasException;
import util.exceptions.HashMapInvalidoException;

/**
 *
 * @author lhfba
 */
public class AcaoValidada implements Proxy{
    
    Acao acao;

    public AcaoValidada(Acao acao) {
        this.acao = acao;
    }

    
    @Override
    public void agir() throws HashMapInvalidoException, CredenciaisErradasException {
        // validar acao
        if (acao == null){
            throw new HashMapInvalidoException("Acao nao informada");
        }
        
        if(    !("admin".equalsIgnoreCase(Gerente.getLogin()) && "123".equals(Gerente.getSenha()))    ){
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
