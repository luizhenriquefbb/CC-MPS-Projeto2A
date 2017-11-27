package business;

import infra.Produto;
import java.util.Map;
import util.exceptions.HashMapInvalidoException;
import util.Strings;

/**
 *
 * @author lhfba
 */
public class BuscarProduto extends AcaoComProduto{

    private final Map<String, Object> map;

    public BuscarProduto(Map<String, Object> map) {
        this.map = map;
    }
    
    @Override
    protected void __realizarAcao() throws HashMapInvalidoException {
        Map<String, Produto> produtos = produtosCadastrados.getProdutos();
        
        String codigoProdutoBuscado = (String) this.map.get(Strings.KEY_PRODUTO_CODIGO);
        
        //buscarProduto
        setEntidade(produtos.get(codigoProdutoBuscado));
       
    }
    
    
}
