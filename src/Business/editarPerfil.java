package Business;

import infra.Usuario;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.exceptions.HashMapInvalidoException;
import util.exceptions.EntidadeNaoPodeSerAtualizadaException;

/**
 *
 * @author lhfba
 */
public class EditarPerfil extends AcaoComUsuario{

    private final HashMap<String, Object> map;

    public EditarPerfil(HashMap<String, Object> map){
        this.map = map;
    }
    
    @Override
    protected void __realizarAcao() throws HashMapInvalidoException{
        
        Usuario novoUsuario = (Usuario) fabrica.getInstancia(map);
        try {
            this.usuariosCadastrados.atualizarUsuario(novoUsuario);
            
            System.out.println(">>>> Usuario atualizado\n"
                +           novoUsuario.toString());
        } catch (EntidadeNaoPodeSerAtualizadaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(EditarPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    public HashMap<String, Object> getMap() {
        return map;
    }
    
    
}
