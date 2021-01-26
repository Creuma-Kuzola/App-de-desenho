/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicacao.de.desenho;

import com.sun.tools.javac.Main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author creuma
 */
public class FramePrincipal extends JFrame {
    
    JPanel painelPrincipal = new JPanel();
    JPanel painelIcones = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    Border border1 = new LineBorder(new Color(173,173,173), 1);
    Border border2 = new LineBorder(new Color(173,173,173), 1);
    Font font = new Font("Sans-Serif", Font.BOLD, 12);
    
    JButton botaoSeta = new JButton();
    JLabel labelSeta = new JLabel();
            
            
    
    public FramePrincipal() throws IOException
    {
        
        this.setTitle("Aplicação de desenho");
        this.setSize(larguraDimensaoDaTela(), alturaDimensaoDaTela());
        this.getContentPane().setBackground(new Color(255,255,255));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        
        adicionarMenu(); 
        adicionarIconeNoPainelLateral();
       // adicionarPainelIcones();
        
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

    public void adicionarMenu()
    {
        
        menuBar.setBorder(border1);
        menuBar.setBackground(new Color(211,211,211));
        menuBar.setPreferredSize(new Dimension(larguraDimensaoDaTela(),30));
        file.setCursor(cursor);
        file.setFont(font);
        menuBar.add(file);
        this.setJMenuBar(menuBar);
    }        
  
    public void adicionarPainelIcones()
    {
        painelIcones.setBackground(new Color(211,211,211));
        painelIcones.setPreferredSize(new Dimension(40,alturaDimensaoDaTela()));
        painelIcones.setBorder(border2);
       // this.add(painelIcones,BorderLayout.WEST);
       
    }       
    
    /*public void adicionarIcones() throws IOException{
        
       // Image img = ImageIO.read(getClass().getResource("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/imagens/diagonal-arrow(1).png"));
       
       Icon icon = new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/imagens/diagonal-arrow(1).png");
       JButton button7 = new JButton(icon);
       
       /* Icon seta = new ImageIcon(Main.class.getResource("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/imagens/diagonal-arrow(1).png"));
        //botaoSeta.setImage(new ImageIcon("seta",arrow));
        //botaoSeta.setIcon(new ImageIcon(img));
       // painelIcones.add(button7);
                
    }*/
    
    public void adicionarIconeNoPainelLateral()
    {
        labelSeta.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/diagonal-arrow1.png"));
        labelSeta.setBackground(Color.red);
        //this.add(labelSeta,BorderLayout.EAST);
        //painelIcones.add(labelSeta);

        
        painelIcones.setBackground(new Color(211,211,211));
        painelIcones.setPreferredSize(new Dimension(40,alturaDimensaoDaTela()));
        painelIcones.setBorder(border2);
        painelIcones.add(labelSeta);
        this.add(painelIcones,BorderLayout.WEST);
        
       validate();
    }        
    
}
