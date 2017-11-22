package Business;

import java.util.Date;

/**
 *
 * @author lhfba
 */
public abstract class TemplateRelatorio {
    
    /**
     * Cabelaçalho que inicia todos os relatorios
     * @return 
     */
    protected String getCabecalho(){
        return "=========RELATORIO=============\n"
                + "data: "+new Date()+"\n"
                + "Aplicativo: BARTENDER\n"
                + "Autores: Luiz Henrique, Aline Araújo\n\n\n";
    }
    
    /**
     * Fechamento que todos os relatorios têm
     * @return 
     */
    protected String getFechamento(){
        return "===============================\n";
    }
    
    /**
     * metodo que mudará de relatorio para relatorio
     * @return 
     */
    protected abstract String getDados();
    
    public String gerarRelatorio(){
        return this.getCabecalho()+this.getDados()+this.getFechamento();
    }
    
    protected abstract void salvarRelatorio();
}
