package guiCliente;

import java.util.Map;
import javax.swing.JFrame;
import view.Fachada;

/**
 *
 * @author lhfba
 */
public class PainelDeAcoesAbstrato extends javax.swing.JPanel{
    protected Map<String, Object> entrada;
    protected Fachada fachada;
    protected JFrame pai;

    public PainelDeAcoesAbstrato(Map<String, Object> entrada, Fachada fachada) {
        this.entrada = entrada;
        this.fachada = fachada;
    }

    public void setPai(JFrame pai) {
        this.pai = pai;
    }
    
    
    
    
}
