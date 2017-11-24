package business;

import infra.Produto;
import java.util.HashMap;
import util.exceptions.HashMapInvalidoException;

/**
 *
 * @author lhfba
 */
public class CadastrarProduto extends AcaoComProduto{

    private final HashMap<String, Object> map;

    public CadastrarProduto(HashMap<String, Object> map){
        this.map = map;
    }
    
    
    
    @Override
    protected void __realizarAcao() throws HashMapInvalidoException{
        Produto produto = (Produto) this.fabrica.getInstancia(map);
        this.produtosCadastrados.addProdutos(produto);
        
        this.produtosCadastrados.salvarLista();
        
        System.out.println(">>>> Produtos cadastrado\n"
                +           produto.toString());
    }
        
        
        
    
}
