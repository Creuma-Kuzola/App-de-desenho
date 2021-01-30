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
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author creuma
 */
public class FramePrincipal extends JFrame implements MouseListener, MouseMotionListener{
    
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
    JLabel labelLapis = new JLabel();
    JLabel labelBorracha = new JLabel();    
    
    boolean flagLabelLapis = false;
            
    
    public FramePrincipal() throws IOException
    {
        
        this.setTitle("Aplicação de desenho");
        this.setSize(larguraDimensaoDaTela(), alturaDimensaoDaTela());
        this.getContentPane().setBackground(new Color(255,255,255));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        
        adicionarMenu(); 
        adicionarPainelIcones();
        adicionarIconeNoPainelLateral();
        //escutarPainel();
        mudarACorDaLabel();
        
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
        painelIcones.setLayout(new GridLayout(13,0,1,0));
        this.add(painelIcones,BorderLayout.WEST);
    }       
    
    public void adicionarIconeNoPainelLateral()
    {
        labelSeta.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/diagonal-arrow1.png"));
        labelSeta.setCursor(cursor);
        
        labelLapis.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/draw.png"));
        labelLapis.setCursor(cursor);
       
        labelBorracha.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/rubber1.png"));
        labelBorracha.setCursor(cursor);     
        
        painelIcones.add(labelSeta);
        painelIcones.add(labelLapis);
        painelIcones.add(labelBorracha); 
        
        validate();
    }     
    
    
    public void mudarACorDaLabel()
    {
        
        labelLapis.addMouseListener(new MouseListener(){
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
               
                flagLabelLapis = true;
            }

            @Override
            public void mousePressed(MouseEvent e) {
        
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                
               
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                
                labelLapis.setOpaque(true);
                labelLapis.setBackground(Color.GRAY);
                System.out.println("Entrei na Label");
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                
                labelLapis.setOpaque(true);
                labelLapis.setBackground(new Color(211,211,211));
                System.out.println("Entrei na Label");
            }
          
        });
        
    }  
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        System.out.println("Cliquei no mouse");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
       if(flagLabelLapis)
          desenharOvalLivremente(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        System.out.println("Relead  o mouse");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
     
        System.out.println("Entrei no mouse");
    }

    @Override
    public void mouseExited(MouseEvent e) {
     
        System.out.println("Saí do mouse");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
       if(flagLabelLapis)
          desenharOvalLivremente(e);

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    
    public void desenharOvalLivremente(MouseEvent e)
    {
        Graphics g = getGraphics ();  
        g.setColor (Color.BLUE);  
        g.fillOval (e.getX (), e.getY (), 10, 10 );
    }        

}