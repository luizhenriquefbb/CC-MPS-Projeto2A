
package Business;

import infra.Entidade;
import infra.Produto;
import java.util.HashMap;
import util.exceptions.HashMapInvalidoException;
import util.Strings;

/**
 *
 * @author lhfba
 */
public class FabricaProduto extends Fabrica{

    /**
     * Cria um produto
     * @param map HashMap com os valores das variaveis de produto
     * @return Entidade - Produto
     * @throws HashMapInvalidoException Caso falte algum dado no Map
     */
    @Override
    public Entidade getInstancia(HashMap<String, Object> map) throws HashMapInvalidoException {
        
        double precoProduto = 0.0;
        Object preco = map.get(Strings.KEY_PRODUTO_PRECO);
        
        if (preco == null || preco == ""){
            throw new HashMapInvalidoException("preco do produto nao informado");
        }else{
            precoProduto = (double) preco;
        }
        
        if (map.get(Strings.KEY_PRODUTO_CODIGO)==null  || map.get(Strings.KEY_PRODUTO_CODIGO) == "" ){
            throw new HashMapInvalidoException("codigo do produto nao informado");
        }
        
        if (map.get(Strings.KEY_PRODUTO_NOME)==null || map.get(Strings.KEY_PRODUTO_NOME)== ""){
            throw new HashMapInvalidoException("nome do produto nao informado");
        }
        
        
        return new Produto(
            (String) map.get(Strings.KEY_PRODUTO_NOME),
            (String) map.get(Strings.KEY_PRODUTO_CODIGO),
            (Double) precoProduto
        );
    }
    
    
}
