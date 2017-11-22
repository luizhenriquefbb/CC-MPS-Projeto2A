package view;

import infra.Entidade;
import util.exceptions.HashMapInvalidoException;

/**
 *
 * @author lhfba
 */
public abstract class Fachada {
    
    protected Acao acao;
    private Entidade entidade;

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }
    
    
    public abstract void agir() throws HashMapInvalidoException;

    public Acao getAcao() {
        return acao;
    }

    
    
    
    
    
    
}
