
package business;

import java.util.HashMap;
import javax.swing.JOptionPane;
import util.exceptions.HashMapInvalidoException;

/**
 *
 * @author lhfba
 */
public class GerarLinkDoProdutoEstrategiaA extends GerarLinkDoProduto{
    
    public GerarLinkDoProdutoEstrategiaA(HashMap<String, Object> map) {
        super(map);
    }
    
    @Override
    protected void __realizarAcao() throws HashMapInvalidoException {
        JOptionPane.showMessageDialog(null, ">>>> Link do produto criado [[ESTRATEGIA A]]\n"
                +           ">>> para fins de cadeira, a implementação nao importa\n");
    }
}
