package business;

import infra.Produto;
import infra.ProdutosCadastrados;
import java.util.Map;
import java.util.Set;
import util.FileManager;
import util.Strings;

/**
 *
 * @author lhfba
 */
public class RelatorioDeProdutos extends TemplateRelatorio{

    @Override
    protected String getDados() {
        
        ProdutosCadastrados produtosCadastrados = ProdutosCadastrados.getInstanciaProdutosCadastrados();
        Set<Map.Entry<String, Produto>> dados = produtosCadastrados.getProdutos().entrySet();
        String retorno = "";
        
        for (Map.Entry<String, Produto> dado : dados){
            retorno += dado.toString() + "\n";
        }
        
        return      ">>> Produtos Cadastrados\n"
                +   retorno;
        
        
    }

    @Override
    protected void salvarRelatorio() {
        FileManager fileManager = FileManager.getFileMager();
        fileManager.saveFile(Strings.DIRETORIO_RELATORIO_PRODUTOS, this.gerarRelatorio());
    }
    
}
