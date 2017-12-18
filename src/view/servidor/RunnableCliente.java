package view.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.exceptions.CredenciaisErradasException;
import util.exceptions.HashMapInvalidoException;
import view.Fachada;
import view.FachadaGerente;

/**
 * Analogo ao "escutaCliente"
 * @author lhfba
 */
class RunnableCliente implements Runnable {

    private final Socket clienteSocket;
    /**ObjectInputStream para receber o nome do arquivo*/
    ObjectInputStream mensagemRecebida;
    ObjectOutputStream mensagemEnviada;
    
    public RunnableCliente(Socket cliente) {
        this.clienteSocket = cliente;
        try {
            mensagemRecebida = new ObjectInputStream(clienteSocket.getInputStream());
            mensagemEnviada  = new ObjectOutputStream(clienteSocket.getOutputStream());
        } catch (IOException ex) {
            System.err.println("Erro não tratado");
            Logger.getLogger(RunnableCliente.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
        
    }

    @Override
    public void run() {
        Map entrada;
        try {
            while ((entrada = (HashMap) this.mensagemRecebida.readObject()) != null){
                //TODO: verificar se eh gerente ou cliente e iniciar fachada correta
                System.out.println("mensagem recebida "+ entrada);
                Fachada fachada = new FachadaGerente(entrada);
                fachada.agir();
            }

        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Erro não tratado");
            Logger.getLogger(RunnableCliente.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        } catch (HashMapInvalidoException | CredenciaisErradasException ex){
            System.out.println("Erro: " + ex.getMessage());
        
        }finally{
            System.out.println("fechar conexao");
            //TODO:
            
        }
        
    }
      
}