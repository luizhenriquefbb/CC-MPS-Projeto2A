
package business;

import util.FileManager;
import util.Strings;
import view.Acao;

/**
 *
 * @author lhfba
 */
public class GerarRelatorio extends Acao{

    TemplateRelatorio relatorio;

    public GerarRelatorio(TemplateRelatorio templateRelatorio) {
        this.relatorio = templateRelatorio;
    }
    
    
    @Override
    public void __realizarAcao(){
        System.out.println(relatorio.gerarRelatorio());
        
        relatorio.salvarRelatorio();
        
    }
}
