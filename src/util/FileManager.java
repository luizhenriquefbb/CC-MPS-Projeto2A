package util;




import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que le e salva de arquivo
 * @author luiz
 */
public class FileManager {

    // singleton
    private static final FileManager FILE_MANAGER = new FileManager();
            
    public static synchronized FileManager getFileMager(){
        return FILE_MANAGER;
    }
    
    private FileManager() {
    }

    
    
    /**
     * Ler um arquivo txt, e retorna uma lista com suas linhas
     * @param path String
     * @return list
     */
    public List loadFile(String path){
        List text = new ArrayList<>();
        Scanner p = new Scanner(System.in);
        do{
            try{
                BufferedReader br = new BufferedReader(new FileReader(path));
                while(br.ready()){
                    text.add(br.readLine());
                }
             br.close();
             return text;
            }catch(IOException ioe){
                System.err.println("File not found");
                ioe.printStackTrace();
            }
           
        }while(true);
    }
    
     
    
    /**
     * Salvar uma string no formato de String
     * @param path
     * @param content 
     */
    public void saveFile(String path, String content){
        FileWriter arq;
        try {
            arq = new FileWriter(path);
        
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf(content);
            arq.close();
        } catch (IOException ex) {
            System.err.println("Cannot save file");
            ex.printStackTrace();
        }
        
    }
    
    /**
     * Salvar uma lista de strings no formato de string
     * @param path
     * @param content 
     */
    public void saveFile(String path, List<String> content){
        FileWriter arq;
        try {
            arq = new FileWriter(path);
        
            PrintWriter gravarArq = new PrintWriter(arq);
            
            for (String line : content){
                gravarArq.printf(line + "\n");
            }
            
            arq.close();
        } catch (IOException ex) {
            System.err.println("Cannot save file");
            ex.printStackTrace();
        }
        
    }
    
    public void saveObject(Object object, String filename) throws IOException{
        File file = new File(filename);
        
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
                throw new IOException("Erro ao criar arquivo de persistencia");
            }
        }
        
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            objectOut.writeObject(object);
        }
    }
    
    public void saveXML(Object f, String filename) throws IOException{
        File file = new File(filename);
        
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
                throw new IOException("Erro ao criar arquivo de persistencia");
            }
        }
        
        FileOutputStream FileOutoutStream = new FileOutputStream(filename);
        BufferedOutputStream bufferedReader = new BufferedOutputStream (FileOutoutStream);
        
        try (XMLEncoder encoder = new XMLEncoder(bufferedReader)) {
            encoder.writeObject(f);
        }
    }
    
    

    public Object readObject(String filename) throws IOException, ClassNotFoundException{
        File file = new File(filename);
        
        if (!file.exists()){
            throw new IOException("Arquivo nao encontrado");
        }
        
        ObjectInputStream objectIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
            return objectIn.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new ClassNotFoundException("ERRO: Erro de classe ao ler o arquivo");
        }finally{
            objectIn.close();
        }
        
    }
    
    public Object readXML(String filename) throws IOException{
        File file = new File(filename);
        
        if (!file.exists()){
            throw new IOException("Arquivo nao encontrado");
        }
        
        FileInputStream fileInputStream = new FileInputStream(filename);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        XMLDecoder decoder = new XMLDecoder(bufferedInputStream);
        
        
        Object o = (Object)decoder.readObject();
        decoder.close();
        return o;
    }

    
}
