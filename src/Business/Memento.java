
package Business;

import view.Acao;

/**
 *
 * @author lhfba
 */
public class Memento {
    
    private Acao mem = null;
    
    public void setEstado(Acao est){
        System.out.println("Salvando memento");
        mem = est;
    }
    
    public Acao getEstado(){
        System.out.println("recuperando memento");
        return mem;
    }
    
}
