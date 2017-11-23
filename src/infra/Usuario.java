package infra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lhfba
 */
public class Usuario extends Entidade implements Serializable{
    
    private String nome = "nomeGenrico";
    private Date nascimento = new Date();
    private String cpf = "cpfGenrico";
    private String login;
    private String senha = "senhaGenterico";
    
    private List<String> lugaresFavoritos = new ArrayList<>();

    public Usuario(String nome, Date nascimento, String cpf, List<String> lugaresFavoritos, String login, String senha){
            this.nome = nome;
            this.nascimento = nascimento;
            this.cpf = cpf;
            this.lugaresFavoritos = lugaresFavoritos;
            this.login = login;
            this.senha = senha;
    }
    
    public Usuario(String nome, Date nascimento, String cpf, String login, String senha){
            this.nome = nome;
            this.nascimento = nascimento;
            this.cpf = cpf;
            this.lugaresFavoritos = new ArrayList<>();
            this.login = login;
            this.senha = senha;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", nascimento=" + nascimento + ", cpf=" + cpf +
                ", login=" + login + ", senha=" + senha + ", lugaresFavoritos=" + lugaresFavoritos + '}';
    }
    
    

    

    public String getNome() {
        return nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public List<String> getLugaresFavoritos() {
        return lugaresFavoritos;
    }

    
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setLugaresFavoritos(List<String> lugaresFavoritos) {
        this.lugaresFavoritos = lugaresFavoritos;
    }

    
    
    
    
    
    
    
}
