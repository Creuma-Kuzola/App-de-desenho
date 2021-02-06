/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicacao.de.desenho;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


/**
 *
 * @author creuma
 */
public class FramePrincipal extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
    
    JPanel painelIcones = new JPanel();
    JPanel painelDeDesenho = new JPanel();
 
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    Border border1 = new LineBorder(new Color(173,173,173), 1);
    Border border2 = new LineBorder(new Color(173,173,173), 1);
    Font font = new Font("Sans-Serif", Font.BOLD, 12);
   
    JLabel labelSeta = new JLabel();
    JLabel labelLapis = new JLabel();
    JLabel labelBorracha = new JLabel();    
    JLabel labelLinha = new JLabel();  
    JLabel labelTexto = new JLabel();  
    JLabel labelPincel = new JLabel();  
    
    JButton botaoBaldeDeTinta = new JButton();  
    
    boolean flagDeDesenhoLabelSeta, flagDeDesenhoLabelLapis, flagDeDesenhoLabelPincel
            ,flagDeDesenhoLabelBorracha, flagDeDesenhoLabelTexto,flagDeDesenhoLabelLinha
            ,flagDeDesenhoBotaoBaldeDeTinta;
    
    Color cor;
    int posXInicial, posYInicial,posXFinal, posYFinal, numClique; 
     
    public FramePrincipal() throws IOException
    {
        
        this.setTitle("Aplicação de desenho");
        this.setSize(larguraDimensaoDaTela(), alturaDimensaoDaTela());
        this.getContentPane().setBackground(new Color(211,211,211));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
      
        adicionarMenu(); 
        adicionarPainelIcones();
        adicionarPainelDeDesenho();
        
        
        adicionarIconesNoPainelIcones();
        
        efeitoHoverDaLabel(labelSeta);
        efeitoHoverDaLabel(labelBorracha);
        efeitoHoverDaLabel(labelLapis);
        efeitoHoverDaLabel(labelLinha);
        efeitoHoverDaLabel(labelPincel);
        efeitoHoverDaLabel(labelTexto);
        
        efeitoHoverDoBotao(botaoBaldeDeTinta);
        
        escutarEventoNaLabelSeta();
        escutarEventoNaLabelLapis();
        escutarEventoNaLabelPincel();
        escutarEventoNaLabelBorracha();
        escutarEventoNaLabelTexto();
        escutarEventoNaLabelLinha();
        escutarEventoNoBotaoBaldeDeTinta();
        
        //desenharAposCliqueLabelLapis();
        //desenharNoPainelDeDesenho();
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
    
    public void adicionarPainelDeDesenho()
    {
        painelDeDesenho.setBackground(new Color(255,255,255));
        painelDeDesenho.addMouseListener(this);
        painelDeDesenho.addMouseMotionListener(this);
        painelDeDesenho.setPreferredSize(new Dimension(300,300));
        this.add(painelDeDesenho,BorderLayout.CENTER);
    }        
    
    public void fazerBotaoParecerLabel(JButton botao)
    {
        botao.setFocusPainted(false);
        botao.setMargin(new Insets(0, 0, 0, 0));
        botao.setContentAreaFilled(false);
        botao.setBorderPainted(false);
        botao.setOpaque(false);
        botao.addActionListener(this);
    }        
    
    public void adicionarIconesNoPainelIcones()
    {
        labelSeta.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/diagonal-arrow1.png"));
        labelSeta.setCursor(cursor);
        
        labelLapis.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/draw.png"));
        labelLapis.setCursor(cursor);
       
        labelBorracha.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/rubber1.png"));
        labelBorracha.setCursor(cursor);     
        
        labelLinha.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/diagonal-line3.png"));
        labelLinha.setCursor(cursor);     
        
        labelTexto.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/text.png"));
        labelTexto.setCursor(cursor);   
        
        labelPincel.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/paint-brush.png"));
        labelPincel.setCursor(cursor); 
        
        botaoBaldeDeTinta.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/paint-bucket1.png"));        
        botaoBaldeDeTinta.setCursor(cursor); 
        fazerBotaoParecerLabel(botaoBaldeDeTinta);
                
        painelIcones.add(labelSeta);
        painelIcones.add(labelLapis);
        painelIcones.add(labelPincel); 
        painelIcones.add(labelBorracha); 
        painelIcones.add(labelTexto); 
        painelIcones.add(labelLinha); 
        painelIcones.add(botaoBaldeDeTinta); 
        
        validate();
    }     
    
    public void efeitoHoverDaLabel(JLabel label)
    {
        
        label.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent arg0) {
                
                label.setOpaque(true);
                label.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                
                label.setOpaque(true);
                label.setBackground(new Color(211,211,211));
            }
          
        });
       
    }
    
    public void efeitoHoverDoBotao(JButton botao)
    {
        
        botao.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent arg0) {
                
                botao.setOpaque(true);
                botao.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                
                botao.setBackground(new Color(211,211,211));
                
            }
          
        });
        
    }
 
    /************* Action Performed ************/
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource() == botaoBaldeDeTinta)
        {
            cor = JColorChooser.showDialog(this,"Escolha uma cor",Color.BLACK);
        }
    }

    /***************************** Métodos ouvidores**************************/
    
    public void escutarEventoNaLabelSeta()
    {
        labelSeta.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeDesenhoLabelSeta= true;
            }
        }); 
        
    }        
    
    public void escutarEventoNaLabelLapis()
    {
        labelLapis.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.out.println("Cliquei na label Lapis");
                flagDeDesenhoLabelLapis= true;
            }
        }); 
        
    }        
    
    public void escutarEventoNaLabelPincel()
    {
        labelPincel.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeDesenhoLabelPincel= true;
            }
        }); 
        
    }  
    
    public void escutarEventoNaLabelBorracha()
    {
        labelBorracha.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeDesenhoLabelBorracha= true;
            }
        }); 
        
    }
    
    public void escutarEventoNaLabelTexto()
    {
        labelTexto.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeDesenhoLabelTexto= true;
            }
        }); 
        
    }   
    
    public void escutarEventoNaLabelLinha()
    {
        labelTexto.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeDesenhoLabelLinha= true;
            }
        }); 
        
    }        
   
    public void escutarEventoNoBotaoBaldeDeTinta()
    {
        botaoBaldeDeTinta.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeDesenhoBotaoBaldeDeTinta = true;
            }
        }); 
        
    }         
     
    
    
    public void desenharNoPainelDeDesenho(){
    
        painelDeDesenho.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                 
            }

            @Override
            public void mousePressed(MouseEvent e) {

                if(flagDeDesenhoLabelLapis)
                     desenharOvalLivremente(e,cor);

            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
               
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                 
            }

       
        });
        
        
        painelDeDesenho.addMouseMotionListener(new MouseMotionListener() {
            
            @Override
            public void mouseDragged(MouseEvent e) {
                
                  if(flagDeDesenhoLabelLapis)
                     desenharOvalLivremente(e,cor);
               
            }

            @Override
            public void mouseMoved(MouseEvent arg0) {
                
                
            }
        });
    
    }

    public void desenharOvalLivremente(MouseEvent e, Color cor)
    {
       Graphics2D g2d = (Graphics2D) getGraphics (); 
       int xActual = e.getX ();
       int yActual = e.getY();
       
       g2d.setColor (cor);  
       g2d.drawLine(e.getX (), e.getY (), 5, 5);
    }    


    
    
    @Override
    public void mouseClicked(MouseEvent arg0) {
       
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
         
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
        
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {

    }

   
}