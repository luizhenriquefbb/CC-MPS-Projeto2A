package business;

import infra.UsuariosCadastrados;
import util.exceptions.HashMapInvalidoException;
import view.Acao;

/**
 *
 * @author lhfba
 */
public abstract class AcaoComUsuario extends Acao {

    UsuariosCadastrados usuariosCadastrados = UsuariosCadastrados.getInstanciaUsuariosCadastrados();
    
    protected AcaoComUsuario() {
        super();
        this.fabrica = Fabrica.getFabricaUsuario();
    }
      
    @Override
    protected abstract void __realizarAcao() throws HashMapInvalidoException;
}
