package gui;


import Business.EditarPerfil;
import Business.Memento;
import infra.Produto;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.exceptions.HashMapInvalidoException;
import util.Strings;
import view.Fachada;
import view.FachadaGerente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lhfba
 */
public class Gerente extends javax.swing.JFrame {

    Fachada fachada;
    Map<String, Object> entrada = new HashMap<>();
    Memento memento;
    
    /**
     * Creates new form Main2
     */
    public Gerente() {
        memento = new Memento();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoRelatorioClientes = new javax.swing.JToggleButton();
        botaoCadastrarCliente = new javax.swing.JToggleButton();
        botaoEditarPerfil = new javax.swing.JButton();
        botaoCadastrarProduto = new javax.swing.JToggleButton();
        botaoRelatorioProdutos = new javax.swing.JToggleButton();
        botaoBuscarProduto = new javax.swing.JToggleButton();
        botaoDesfazerEditarPerfil = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        botaoRelatorioClientes.setText("Relatorio De Clientes");
        botaoRelatorioClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRelatorioClientesActionPerformed(evt);
            }
        });

        botaoCadastrarCliente.setText("Cadastrar Cliente");
        botaoCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarClienteActionPerformed(evt);
            }
        });

        botaoEditarPerfil.setText("Editar Perfil");
        botaoEditarPerfil.setPreferredSize(new java.awt.Dimension(81, 23));
        botaoEditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarPerfilActionPerformed(evt);
            }
        });

        botaoCadastrarProduto.setText("Cadastrar Produto");
        botaoCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarProdutoActionPerformed(evt);
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

        botaoDesfazerEditarPerfil.setText("DesfazerEditarPerfil");
        botaoDesfazerEditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDesfazerEditarPerfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botaoEditarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoRelatorioClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoRelatorioProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(botaoDesfazerEditarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(botaoEditarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(botaoCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(botaoRelatorioClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(botaoRelatorioProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoDesfazerEditarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoRelatorioClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRelatorioClientesActionPerformed
        this.entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_GERAR_RELATORIO_CLIENTES_ATIVOS);
        this.fachada = new FachadaGerente(entrada);
        
        try {
            this.fachada.agir();
            JOptionPane.showMessageDialog(null, "relatorio salvo em "+Strings.DIRETORIO_RELATORIO_CLIENTES);
        } catch (HashMapInvalidoException ex) {
            Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        
        
        
    }//GEN-LAST:event_botaoRelatorioClientesActionPerformed

    private void botaoCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarClienteActionPerformed
        this.entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_CADASTRAR_USUARIO);

        FrameDeAcoes FrameDeAcoes = new FrameDeAcoes(this, new PainelDeCadastro(entrada, fachada));

    }//GEN-LAST:event_botaoCadastrarClienteActionPerformed

    private void botaoEditarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarPerfilActionPerformed
        this.entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_EDITAR_PERFIL);
        FrameDeAcoes FrameDeAcoes = new FrameDeAcoes(this, new PainelDeEditarPerfil(entrada,fachada, memento));
    }//GEN-LAST:event_botaoEditarPerfilActionPerformed

    private void botaoCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarProdutoActionPerformed
       
        this.entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_CADASTRAR_PRODUTO);
        this.fachada = new FachadaGerente(entrada);
        
        FrameDeAcoes FrameDeAcoes = new FrameDeAcoes(this, new PainelNovoProduto(entrada,fachada));
        

        
        
    }//GEN-LAST:event_botaoCadastrarProdutoActionPerformed

    private void botaoRelatorioProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRelatorioProdutosActionPerformed
        this.entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_GERAR_RELATORIO_PRODUTOS);
        this.fachada = new FachadaGerente(entrada);
        
        try {
            this.fachada.agir();
            JOptionPane.showMessageDialog(null, "relatorio salvo em "+Strings.DIRETORIO_RELATORIO_PRODUTOS);
        } catch (HashMapInvalidoException ex) {
            Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        
        
        
        
    }//GEN-LAST:event_botaoRelatorioProdutosActionPerformed

    private void botaoBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarProdutoActionPerformed
        this.entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_BUSCAR_PRODUTO);
        
        
        String codigoProdutoBuscado = JOptionPane.showInputDialog(null, "Qual o codigo do produto buscado?");
        if (codigoProdutoBuscado == null){
            JOptionPane.showMessageDialog(null, "codigo invalido");
            return;
        }
        
        this.entrada.put(Strings.KEY_PRODUTO_CODIGO, codigoProdutoBuscado);
        
        this.fachada = new FachadaGerente(entrada);
        
        try {
            this.fachada.agir();
        } catch (HashMapInvalidoException ex) {
            
            Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
        }
        Produto produtoAchado = (Produto) fachada.getEntidade();
        if (produtoAchado == null){
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }else{
            JOptionPane.showMessageDialog(null, "produto achado\n"
                    + produtoAchado.toString());
        }
    }//GEN-LAST:event_botaoBuscarProdutoActionPerformed

    private void botaoDesfazerEditarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDesfazerEditarPerfilActionPerformed
        
        EditarPerfil estado = (EditarPerfil) memento.getEstado();
        memento.setEstado(null);
        
        System.out.println("desfazendo operação");
        
        this.entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_EDITAR_PERFIL);
        
        // camopos recuperados
        String nome =  (String) estado.getMap().get(Strings.KEY_USUARIO_NOME);
        String login = (String) estado.getMap().get(Strings.KEY_USUARIO_LOGIN);
        String cpf = (String) estado.getMap().get(Strings.KEY_USUARIO_CPF);
        String senha = (String) estado.getMap().get(Strings.KEY_USUARIO_SENHA);

        Date nascimento = (Date) (estado.getMap().get(Strings.KEY_USUARIO_NASCIMENTO));
        
        this.entrada.put(Strings.KEY_USUARIO_NOME, nome);
        this.entrada.put(Strings.KEY_USUARIO_SENHA, senha);
        this.entrada.put(Strings.KEY_USUARIO_CPF, cpf);
        this.entrada.put(Strings.KEY_USUARIO_LOGIN, login);
        this.entrada.put(Strings.KEY_USUARIO_NASCIMENTO, nascimento);

        fachada = new FachadaGerente(this.entrada);

        try {
            fachada.agir();
        } catch (HashMapInvalidoException ex) {
            Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        
    }//GEN-LAST:event_botaoDesfazerEditarPerfilActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
       /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botaoBuscarProduto;
    private javax.swing.JToggleButton botaoCadastrarCliente;
    private javax.swing.JToggleButton botaoCadastrarProduto;
    private javax.swing.JToggleButton botaoDesfazerEditarPerfil;
    private javax.swing.JButton botaoEditarPerfil;
    private javax.swing.JToggleButton botaoRelatorioClientes;
    private javax.swing.JToggleButton botaoRelatorioProdutos;
    // End of variables declaration//GEN-END:variables
}
