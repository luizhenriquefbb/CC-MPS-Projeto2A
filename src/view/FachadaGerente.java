 package view;

import business.BuscarProduto;
import business.CadastrarProduto;
import business.CadastrarUsuario;
import business.EditarPerfil;
import business.GerarLinkDoProdutoEstrategiaA;
import business.GerarLinkDoProdutoEstrategiaB;
import business.GerarRelatorio;
import business.RelatorioDeClientesAtivos;
import business.RelatorioDeProdutos;
import java.util.HashMap;
import java.util.Map;
import util.exceptions.HashMapInvalidoException;
import util.Strings;
import util.exceptions.CredenciaisErradasException;

/**
 * 
 * @author lhfba
 */
public class FachadaGerente extends Fachada{
    private final Map<String, Acao> listaAcoes = new HashMap<>();
    private Map<String, Object> entrada = new HashMap<>();
    
    public FachadaGerente(Map<String, Object> map) {
        this.entrada = map;
        construirHashDeAcoes();
    }

    public FachadaGerente() {
    }
    
    
    
    @Override
    public void agir() throws HashMapInvalidoException, CredenciaisErradasException{
        String entradaAcao = (String) this.entrada.get(Strings.ENTRADA_ACAO);
        
        // verifica se o comando está correto
        if (entradaAcao == null){
            throw new HashMapInvalidoException("acao nao definida");
        }
        
        this.acao = new AcaoValidada((Acao) this.listaAcoes.get(entradaAcao));
        
        if(this.acao == null){
            throw new HashMapInvalidoException("comando não encontrado");
        }
        
        this.acao.agir();
        
        this.setEntidade(this.acao.getEntidade());
    }
    
    private void construirHashDeAcoes(){
        listaAcoes.put(Strings.ACAO_BUSCAR_PRODUTO,                     new BuscarProduto((HashMap<String, Object>) entrada));
        listaAcoes.put(Strings.ACAO_CADASTRAR_PRODUTO,                  new CadastrarProduto((HashMap<String, Object>) entrada));
        listaAcoes.put(Strings.ACAO_GERAR_LINK_DE_PRODUTO_A,            new GerarLinkDoProdutoEstrategiaA((HashMap<String, Object>) entrada));
        listaAcoes.put(Strings.ACAO_GERAR_LINK_DE_PRODUTO_B,            new GerarLinkDoProdutoEstrategiaB((HashMap<String, Object>) entrada));
        listaAcoes.put(Strings.ACAO_GERAR_RELATORIO_PRODUTOS,           new GerarRelatorio(new RelatorioDeProdutos()));
        listaAcoes.put(Strings.ACAO_GERAR_RELATORIO_CLIENTES_ATIVOS,    new GerarRelatorio(new RelatorioDeClientesAtivos()));
        listaAcoes.put(Strings.ACAO_CADASTRAR_USUARIO,                  new CadastrarUsuario((HashMap<String, Object>) entrada));
        listaAcoes.put(Strings.ACAO_EDITAR_PERFIL,                      new EditarPerfil((HashMap<String, Object>) entrada));
    }

        
}
