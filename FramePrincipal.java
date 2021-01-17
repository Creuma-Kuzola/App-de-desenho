/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicacao.de.desenho;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *
 * @author creuma
 */
public class FramePrincipal extends JFrame {
    
    JPanel painelPrincipal = new JPanel();
    JPanel painelIcones = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    
    public FramePrincipal()
    {
        
        this.setTitle("Aplicação de desenho");
        this.setSize(larguraDimensaoDaTela(), alturaDimensaoDaTela());
        this.getContentPane().setBackground(new Color(255,255,255));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        
        painelPrincipal.setBackground(Color.red);
        this.add(painelPrincipal,BorderLayout.NORTH);
    }
    
    public void criarPainelPrincipal()
    {
        
        
        
    }        
  
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


    
}
