package business;

import infra.ProdutosCadastrados;
import util.exceptions.HashMapInvalidoException;
import view.Acao;

/**
 *
 * @author lhfba
 */
public abstract class AcaoComProduto extends Acao{

    ProdutosCadastrados produtosCadastrados = ProdutosCadastrados.getInstanciaProdutosCadastrados();
    
    protected AcaoComProduto() {
        super();
        this.fabrica = Fabrica.getFabricaProduto();
        
    }

    
    @Override
    protected abstract void __realizarAcao() throws HashMapInvalidoException;
    
}
