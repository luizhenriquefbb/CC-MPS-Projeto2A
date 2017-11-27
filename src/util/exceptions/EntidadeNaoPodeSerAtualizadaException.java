package util.exceptions;

/**
 *
 * @author lhfba
 */
public class EntidadeNaoPodeSerAtualizadaException extends Exception{

    public EntidadeNaoPodeSerAtualizadaException() {
    }

    public EntidadeNaoPodeSerAtualizadaException(String string) {
        super("erro: "+ string);
    }
    
}
