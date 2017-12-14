package guiCliente;


import business.Memento;
import view.Fachada;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
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
    Map<String, Object> entrada = new HashMap<>();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        botaoRelatorioClientes.setText("Relatorio De Clientes");
        botaoRelatorioClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRelatorioClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(botaoRelatorioClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(botaoRelatorioClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoRelatorioClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRelatorioClientesActionPerformed
        this.entrada.put(Strings.ENTRADA_ACAO, Strings.ACAO_GERAR_RELATORIO_CLIENTES_ATIVOS);
        this.entrada.put(Strings.KEY_USUARIO_LOGIN, login);
        this.entrada.put(Strings.KEY_USUARIO_SENHA, senha);
     
        // antes: sem modelo cilente-servidor
//        this.fachada = new FachadaGerente(entrada);
//        
//        try {
//            this.fachada.agir();
//            JOptionPane.showMessageDialog(null, "relatorio salvo em "+Strings.DIRETORIO_RELATORIO_CLIENTES);
//        } catch (HashMapInvalidoException | CredenciaisErradasException ex) {
//            Logger.getLogger(Gerente_novo.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
//        }

        // modelo cliente-servidor
        //enviar hash para o servidor
        try {
            out.writeObject(this.entrada);
            out.flush();
        } catch (IOException ex) {
            //TODO
            System.err.println("Erro não tratado");
            Logger.getLogger(Gerente_novo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_botaoRelatorioClientesActionPerformed

    static boolean estrategia = true;
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
    private javax.swing.JToggleButton botaoRelatorioClientes;
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
