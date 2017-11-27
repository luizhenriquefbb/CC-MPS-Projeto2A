package view;

import infra.Entidade;
import util.exceptions.CredenciaisErradasException;
import util.exceptions.HashMapInvalidoException;

/**
 *
 * @author lhfba
 */
public interface Proxy {
    
    void agir() throws HashMapInvalidoException, CredenciaisErradasException;

    public Entidade getEntidade();
    
}
