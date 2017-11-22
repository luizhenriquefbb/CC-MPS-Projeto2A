package Business;

import infra.Usuario;
import infra.UsuariosCadastrados;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.exceptions.HashMapInvalidoException;
import util.Strings;
import util.exceptions.EntidadeNaoPodeSerAtualizadaException;

/**
 *
 * @author lhfba
 */
public class editarPerfil extends AcaoComUsuario{

    private final HashMap<String, Object> map;

    public editarPerfil(HashMap<String, Object> map){
        this.map = map;
    }
    
    @Override
    protected void __realizarAcao() throws HashMapInvalidoException{
        
        Usuario novoUsuario = (Usuario) fabrica.getInstancia(map);
        try {
            this.usuariosCadastrados.atualizarUsuario(novoUsuario);
        } catch (EntidadeNaoPodeSerAtualizadaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(editarPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println(">>>> Usuario atualizado\n"
                +           novoUsuario.toString());
    }
    
}
