
package view;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import util.exceptions.HashMapInvalidoException;

/**
 * Adaptador que vai colocar as informações passadas pelo cliente em um hasmap esperado pela aplicação
 * @author lhfba
 */
public class Adaptador extends FachadaCliente{
    
    private Map<String, Object> map;

    private FachadaCliente fachada;

    public Adaptador(Map<String, Object> map) {
        super(map);
    }
    
    
    public Adaptador(){}

    
    
    public void setJson(JSONObject json) {
        this.map = this.convertJsonToHash(json);
        this.fachada = new FachadaCliente((HashMap<String, Object>) map);
    }
    
    private Map<String, Object> convertJsonToHash(JSONObject json){
        this.map = json.toMap();
        return this.map;
    }

    @Override
    public void agir() throws HashMapInvalidoException{
        fachada.agir();
    }
    
    
    
    
}
