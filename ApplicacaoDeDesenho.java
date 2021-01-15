/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicacao.de.desenho;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author creuma
 */
public class ApplicacaoDeDesenho {

    /**
     * @param args the command line arguments
     */
     public static int larguraDimensaoDaTela(){
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanhoTela = kit.getScreenSize();   
        return tamanhoTela.width;   
    }
    
    public static int alturaDimensaoDaTela(){
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanhoTela = kit.getScreenSize();
        return tamanhoTela.height;
     
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        JFrame frame = new JFrame("Sol com gradiente e detalhes");
        PainelAplicacao painel = new PainelAplicacao();
        
        frame.setSize(larguraDimensaoDaTela()/2, alturaDimensaoDaTela()/2);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(painel);

    }
    
}
