/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicacao.de.desenho;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author creuma
 */
public class ApplicacaoDeDesenho {

    /**
     * @return 
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

    
    public static void criarMenuBar()
    { 
    
        JFrame frame = new JFrame("Aplicação de desenho");
        //PainelAplicacao painel = new PainelAplicacao();
        frame.setSize(larguraDimensaoDaTela()/2, alturaDimensaoDaTela()/2);
        //frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        JMenu file = new JMenu("File");
        menuBar.add(file);
        
        JMenu cvcv = new JMenu("Bla bla");
        menuBar.add(cvcv);
      
        //frame.add(painel);

    
    }        
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        criarMenuBar();
       
    }
    
}
