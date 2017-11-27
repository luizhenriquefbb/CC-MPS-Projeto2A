package business;

import infra.Usuario;
import infra.UsuariosCadastrados;
import java.util.Map;
import java.util.Set;
import util.FileManager;
import util.Strings;

/**
 *
 * @author lhfba
 */
public class RelatorioDeClientesAtivos extends TemplateRelatorio {

    @Override
    protected String getDados() {
        
        UsuariosCadastrados usuariosCadastrados = UsuariosCadastrados.getInstanciaUsuariosCadastrados();
        
        Map<String, Usuario> usuarios = usuariosCadastrados.getUsuarios();
        
        Set<Map.Entry<String, Usuario>> conjutos = usuarios.entrySet();
        
        String retorno = "";
        for (Map.Entry<String, Usuario> conjunto : conjutos){
            retorno += conjunto.getValue().toString() + "\n";
        }
        
        return      ">>> Relação de usuários\n"
                +   retorno;
    }
    
    @Override
    protected void salvarRelatorio() {
        FileManager fileManager = FileManager.getFileMager();
        fileManager.saveFile(Strings.DIRETORIO_RELATORIO_CLIENTES, this.gerarRelatorio());
    }
    
}
