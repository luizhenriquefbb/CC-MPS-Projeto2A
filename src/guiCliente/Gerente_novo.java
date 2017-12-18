package guiCliente;


import business.Memento;
import view.Fachada;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.Strings;


/**
 * Classe principal gerente da aplicação. Ele tem total acesso a todas as funcionalidades do sistema
 * @author lhfba
 */
public class Gerente_novo extends javax.swing.JFrame implements Runnable{

    Fachada fachada;
    /**Hasmap que sera enviado para o servidor*/
    Map<String, Object> mensagem = new HashMap<>();
    Memento memento;
    
    static String senha;
    static String login;
    
    Socket socketGerente;
    /** variavel para mandar msgs para o servidor*/
    ObjectOutputStream out;
    /** Receber as msgs do servidor */
    ObjectInputStream in;
    
    String msgRecebida = "";
    
    public Gerente_novo() {
        memento = new Memento();
        configurarRede();
        initComponents();
    }
    
    private void configurarRede(){
        try {
            socketGerente = new Socket (Strings.IP_SERVIDOR, Strings.PORTA_PRINCIPAL); //inicia o socketGerente do cliente
            
            out = new ObjectOutputStream(socketGerente.getOutputStream()); //mandar mensagens
            in = new ObjectInputStream (socketGerente.getInputStream()); //receber msgs
            
           // new Thread(new EscutaServidor()).start(); //uma thread para mandar e outra para receber msgs
        
        
        } catch (IOException ex) {
            Logger.getLogger(Gerente_novo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoRelatorioClientes = new javax.swing.JToggleButton();
        botaoRelatorioProdutos = new javax.swing.JToggleButton();
        botaoBuscarProduto = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        botaoRelatorioClientes.setText("Relatorio De Clientes");
        botaoRelatorioClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRelatorioClientesActionPerformed(evt);
            }
        });

        botaoRelatorioProdutos.setText("Relatorio de Produtos");
        botaoRelatorioProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRelatorioProdutosActionPerformed(evt);
            }
        });

        botaoBuscarProduto.setText("BuscarUmProduto");
        botaoBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoRelatorioProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoRelatorioClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(botaoBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(botaoRelatorioProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(botaoRelatorioClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoRelatorioClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRelatorioClientesActionPerformed
        this.mensagem.put(Strings.ENTRADA_ACAO, Strings.ACAO_GERAR_RELATORIO_CLIENTES_ATIVOS);
        this.mensagem.put(Strings.KEY_USUARIO_LOGIN, login);
        this.mensagem.put(Strings.KEY_USUARIO_SENHA, senha);
     
        this.enviarMsg();
        
    }//GEN-LAST:event_botaoRelatorioClientesActionPerformed

    private void botaoRelatorioProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRelatorioProdutosActionPerformed
        this.mensagem.put(Strings.ENTRADA_ACAO, Strings.ACAO_GERAR_RELATORIO_PRODUTOS);
        this.mensagem.put(Strings.KEY_USUARIO_LOGIN, login);
        this.mensagem.put(Strings.KEY_USUARIO_SENHA, senha);
        

        this.enviarMsg();

    }//GEN-LAST:event_botaoRelatorioProdutosActionPerformed
    
    private void botaoBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarProdutoActionPerformed
        this.mensagem.put(Strings.ENTRADA_ACAO, Strings.ACAO_BUSCAR_PRODUTO);
        this.mensagem.put(Strings.KEY_USUARIO_LOGIN, login);
        this.mensagem.put(Strings.KEY_USUARIO_SENHA, senha);

        // insrir o codigo de barras a ser procurado
        String codigoProdutoBuscado = JOptionPane.showInputDialog(null, "Qual o codigo do produto buscado?");
        if (codigoProdutoBuscado == null){
            JOptionPane.showMessageDialog(null, "codigo invalido");
            return; // nao pesquisar
        }
        this.mensagem.put(Strings.KEY_PRODUTO_CODIGO, codigoProdutoBuscado);
        
        
       this.enviarMsg();
       
    }//GEN-LAST:event_botaoBuscarProdutoActionPerformed

    /**
     * Envia map para o servidor
     */
    private void enviarMsg(){
        // modelo cliente-servidor
        //enviar hash para o servidor
        try {
            out.writeObject(this.mensagem);
            System.out.println("mensagem enviada "+ this.mensagem);
            out.flush();
        } catch (IOException ex) {
            //TODO
            System.err.println("Erro não tratado");
            Logger.getLogger(Gerente_novo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void main(String args[]){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gerente_novo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gerente_novo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gerente_novo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gerente_novo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        // antes de criar a janela, fazer login:
        login = JOptionPane.showInputDialog(null, "login (padrão: admin)");
        senha = JOptionPane.showInputDialog(null, "senha (padrão: 123)");

        if(    !("admin".equalsIgnoreCase(login) && "123".equals(senha))    ){
            System.out.println("entrou com o login ou senha inválido");
        }
        else{
        }
       /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gerente_novo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botaoBuscarProduto;
    private javax.swing.JToggleButton botaoRelatorioClientes;
    private javax.swing.JToggleButton botaoRelatorioProdutos;
    // End of variables declaration//GEN-END:variables

    public static String getSenha() {
        return senha;
    }

    public static String getLogin() {
        return login;
    }

    public static void setSenha(String senha) {
        Gerente_novo.senha = senha;
    }

    public static void setLogin(String login) {
        Gerente_novo.login = login;
    }

    
    
    @Override
    public void run () {
    }
    
}
