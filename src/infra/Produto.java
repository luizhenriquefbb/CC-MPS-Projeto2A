
package infra;

/**
 *
 * @author lhfba
 */


public class Produto extends Entidade{
    
    private String nome;
    private String codigo;
    private double preco;
    
    private String link = null;

    public Produto(String nome, String codigo, double preco){
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        
    }

    public Produto() {
    }

    
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
    @Override
    public String toString() {
        return this.link == null ?
                "Produto{" + "nome=" + nome + ", codigo=" + codigo + ", preco=" + preco + '}' : 
                "Produto{" + "nome=" + nome + ", codigo=" + codigo + ", preco=" + preco +
                    "link="+link+'}';
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
    
    
    
}
