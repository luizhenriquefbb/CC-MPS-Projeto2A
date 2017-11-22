package Business;

import infra.Produto;
import java.util.HashMap;
import util.exceptions.HashMapInvalidoException;


public class GerarLinkDoProduto extends AcaoComProduto{

    private final HashMap<String, Object> map;

    public GerarLinkDoProduto(HashMap<String, Object> map) {
        super();
        this.map = map;
    }
    
    

    @Override
    protected void __realizarAcao() throws HashMapInvalidoException {
        Produto produto = (Produto) this.fabrica.getInstancia(map);
        System.out.println(">>>> Link do produto criado\n"
                +           ">>> para fins de cadeira, a implementação nao importa\n"
                +           produto.toString());
    }
    
}
