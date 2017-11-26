package business;

import java.util.HashMap;


public abstract class GerarLinkDoProduto extends AcaoComProduto{

    protected HashMap<String, Object> map;

    public GerarLinkDoProduto(HashMap<String, Object> map) {
        super();
        this.map = map;
    }
    
       
}
