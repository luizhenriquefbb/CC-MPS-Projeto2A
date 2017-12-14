
package util;

import java.io.File;

/**
 * lista das Strings usadas em mais de um local
 * @author lhfba
 */
public class Strings {
    
    //usuario
    public static final String KEY_USUARIO_NOME         =        "nome";
    public static final String KEY_USUARIO_NASCIMENTO   =        "nascimento";
    public static final String KEY_USUARIO_CPF          =        "cpf";
    public static final String KEY_USUARIO_SENHA        =        "senha";
    public static final String KEY_USUARIO_LOGIN        =        "login";	 
    
    //produto
    public static final String KEY_PRODUTO_NOME         =       "nome";
    public static final String KEY_PRODUTO_CODIGO       =       "codigo";
    public static final String KEY_PRODUTO_PRECO        =       "preco";
    
    //acoes
    public static final String ACAO_GERAR_RELATORIO_PRODUTOS		= "gerarRelatorioProdutos";
    public static final String ACAO_GERAR_RELATORIO_CLIENTES_ATIVOS	= "gerarRelatorioClientesAtivos";
    public static final String ACAO_GERAR_LINK_DE_PRODUTO_A		= "gerarLinkDeProdutoA";
    public static final String ACAO_GERAR_LINK_DE_PRODUTO_B		= "gerarLinkDeProdutoB";
    public static final String ACAO_BUSCAR_PRODUTO			= "buscarProduto";
    public static final String ACAO_CADASTRAR_PRODUTO			= "cadastrarProduto";
    public static final String ACAO_CADASTRAR_USUARIO                   = "cadastrarUsuario";
    public static final String ACAO_EDITAR_PERFIL                       = "editarPerfil";
    
    
    //json de entrada do cliente
    public static final String ENTRADA_ACAO                             = "acao";

    //diretorios
    public static final String DIRETORIO_RAIZ                           = "persistencia"+(File.separator);
           
    
    public static final String DIRETORIO_USUARIOS_CADASTRADOS           = DIRETORIO_RAIZ+"usuarios.object";
    public static final String DIRETORIO_RELATORIO_CLIENTES             = DIRETORIO_RAIZ+"relatorio_usuarios.txt";
    public static final String DIRETORIO_RELATORIO_PRODUTOS             = DIRETORIO_RAIZ+"relatorio_produtos.txt";
    public static final String DIRETORIO_PRODUTOS_CADASTRADOS           = DIRETORIO_RAIZ+"produtos.object";
    
    
    // protocolos de comunicacao
    public static final String IP_SERVIDOR = "localhost";
    public static final int PORTA_PRINCIPAL = 4444;
    public static final int PORTA_CLIENTE = 4445;


}
