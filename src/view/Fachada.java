package view;

import infra.Entidade;
import util.exceptions.CredenciaisErradasException;
import util.exceptions.HashMapInvalidoException;

/**
 *
 * @author lhfba
 */
public abstract class Fachada {
    
    protected Proxy acao;
    private Entidade entidade;

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }
    
    
    public abstract void agir() throws HashMapInvalidoException, CredenciaisErradasException;

    public Acao getAcao() {
        AcaoValidada acaoValidada = (AcaoValidada) this.acao;
        return  acaoValidada.getAcao();
    }

    
    
    
    
    
    
}
