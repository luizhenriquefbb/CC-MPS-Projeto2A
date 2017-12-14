package view.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
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
    
    
    public RunnableCliente(Socket cliente) {
      this.clienteSocket = cliente; 
    }

    @Override
    public void run() {
        
        try {
            //ObjectInputStream para receber o nome do arquivo
            ObjectInputStream in = new ObjectInputStream(clienteSocket.getInputStream());
            ObjectOutputStream saida  = new ObjectOutputStream(clienteSocket.getOutputStream());
            
            //TODO: verificar se eh gerente ou cliente e iniciar fachada correta
            HashMap entrada = (HashMap) in.readObject();
            Fachada fachada = new FachadaGerente(entrada);
            fachada.agir();
            
        } catch (IOException | ClassNotFoundException | HashMapInvalidoException | CredenciaisErradasException ex) {
            System.err.println("Erro não tratado");
            Logger.getLogger(RunnableCliente.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }
      
}