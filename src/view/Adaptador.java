
package view;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import util.exceptions.CredenciaisErradasException;
import util.exceptions.HashMapInvalidoException;

/**
 * 
 * Adaptador que vai colocar as informações passadas pelo cliente em um hasmap esperado pela aplicação
 * @author lhfba
 */
public class Adaptador extends FachadaGerente{
    
    private Map<String, Object> map;

    private FachadaGerente fachada;

    public Adaptador(Map<String, Object> map) {
        super(map);
    }
    
    
    public Adaptador(JSONObject json){
        this.setJson(json);
    }

    
    
    private void setJson(JSONObject json) {
        this.map = this.convertJsonToHash(json);
        this.fachada = new FachadaGerente((HashMap<String, Object>) map);
    }
    
    private Map<String, Object> convertJsonToHash(JSONObject json){
        this.map = json.toMap();
        return this.map;
    }

    @Override
    public void agir() throws HashMapInvalidoException, CredenciaisErradasException{
        fachada.agir();
    }
    
    
    
    
}
