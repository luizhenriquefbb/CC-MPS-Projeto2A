package view;

import business.Fabrica;
import infra.Entidade;
import util.exceptions.HashMapInvalidoException;

/**
 *
 * @author lhfba
 */
public abstract class Acao implements Proxy {
    protected Fabrica fabrica;
    private Entidade entidade;
    
    @Override
    public void agir() throws HashMapInvalidoException{
        this.__realizarAcao();
        
    }
   
    protected abstract void __realizarAcao() throws HashMapInvalidoException;

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }
    
    
    
}
