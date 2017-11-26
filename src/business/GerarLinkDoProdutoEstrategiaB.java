
package business;

import java.util.HashMap;
import javax.swing.JOptionPane;
import util.exceptions.HashMapInvalidoException;

/**
 *
 * @author lhfba
 */
public class GerarLinkDoProdutoEstrategiaB extends GerarLinkDoProduto{
    
    public GerarLinkDoProdutoEstrategiaB(HashMap<String, Object> map) {
        super(map);
    }
    
    @Override
    protected void __realizarAcao() throws HashMapInvalidoException {
        JOptionPane.showMessageDialog(null, ">>>> Link do produto criado [[ESTRATEGIA - B]]\n"
                +           ">>> para fins de cadeira, a implementação nao importa\n");
    }
}
