package view;

import Business.CadastrarProduto;
import Business.CadastrarUsuario;
import Business.editarPerfil;
import Business.GerarRelatorio;
import Business.RelatorioDeClientesAtivos;
import Business.RelatorioDeProdutos;
import java.util.HashMap;
import java.util.Map;
import util.exceptions.HashMapInvalidoException;
import util.Strings;

/**
 * 
 * @author lhfba
 */
public class FachadaCliente extends Fachada{
    private Acao acao;
    private final Map<String, Acao> listaAcoes = new HashMap<>();
    private Map<String, Object> entrada = new HashMap<>();
    
    public FachadaCliente(Map<String, Object> map) {
        this.entrada = map;
        this.construirHashDeAcoes();
    }

    public FachadaCliente() {
    }
    
    
    
    @Override
    public void agir() throws HashMapInvalidoException{
        String entradaAcao = (String) this.entrada.get(Strings.ENTRADA_ACAO);
        
        // verifica se o comando está correto
        if (entradaAcao == null){
            throw new HashMapInvalidoException("acao nao definida");
        }
        
        this.acao = this.listaAcoes.get(entradaAcao);
        
        if(this.acao == null){
            throw new HashMapInvalidoException("comando não encontrado");
        }
        
        this.acao.agir();
    }
    
    private void construirHashDeAcoes(){
        //listaAcoes.put(Strings.ACAO_BUSCAR_PRODUTO, );
        //listaAcoes.put(Strings.ACAO_CADASTRAR_PRODUTO,new CadastrarProduto((HashMap<String, Object>) entrada));
        listaAcoes.put(Strings.ACAO_GERAR_LINK_DE_PRODUTO,new CadastrarProduto((HashMap<String, Object>) entrada));
        //listaAcoes.put(Strings.ACAO_GERAR_RELATORIO_VENDAS, new GerarRelatorio(new RelatorioDeVendas()));
        //listaAcoes.put(Strings.ACAO_GERAR_RELATORIO_CLIENTES_ATIVOS, new GerarRelatorio(new RelatorioDeClientesAtivos()));
        listaAcoes.put(Strings.ACAO_CADASTRAR_USUARIO, new CadastrarUsuario((HashMap<String, Object>) entrada));
        listaAcoes.put(Strings.ACAO_EDITAR_PERFIL, new editarPerfil((HashMap<String, Object>) entrada));
    }
}
