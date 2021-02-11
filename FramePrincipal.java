package applicacao.de.desenho;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


/**
 *
 * @author creuma
 */
public class FramePrincipal extends JFrame implements ActionListener{
    
    JPanel painelIcones = new JPanel(); 
    JPanel painelItensKeyFrames = new JPanel();
    
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    Border border1 = new LineBorder(new Color(173,173,173), 1);
    Border border2 = new LineBorder(new Color(173,173,173), 1);
    Font font = new Font("Sans-Serif", Font.BOLD, 12);
   
    JLabel labelSeta = new JLabel();
    JLabel labelLimpar = new JLabel();
    JLabel labelBorracha = new JLabel();    
    JLabel labelLinha = new JLabel();  
    JLabel labelTexto = new JLabel();  
    JLabel labelPincel = new JLabel();  
    JLabel labelQuadrado = new JLabel();
    JLabel labelCirculo = new JLabel();
    JLabel labelQuadradoRedondo = new JLabel();
    
    JLabel labelAdicionaKeyFrame = new JLabel();
    JLabel labelPlayAnimacao = new JLabel();
    JLabel labelBlankKeyframe = new JLabel();
    JLabel labelAdicionarAnimacao = new JLabel();
    JLabel labelRemoverAnimacao = new JLabel();
    
    
    //JLabel labelKeyframes = new JLabel("Painel KeyFram");
    
    JButton setAnimation = new JButton();
    JButton setKeyFrame = new JButton();
    JButton play = new JButton();
   
    JButton botaoBaldeDeTinta = new JButton();  
    
    boolean flagDeDesenhoLabelSeta, flagDeDesenhoLabelLimpar, flagDeDesenhoLabelPincel
            ,flagDeDesenhoLabelBorracha, flagDeDesenhoLabelTexto,flagDeDesenhoLabelLinha
            ,flagDeDesenhoBotaoBaldeDeTinta,flagDeDesenhoLabelQuadrado,flagDeDesenhoLabelCirculo, flagDeDesenhoLabelQuadradoRedondo,
            flagDeDesenhoLabelTriangulo, flagDeAnimacaolabelAdicionaKeyFrame,flagDeAnimacaolabelPlayAnimacao,
            flagDeAnimacaolabelBlankKeyframe, flagDeAnimacaolabelAdicionarAnimacao,flagDeAnimacaolabelRemoverAnimacao;
            
    int formaGeometrica = 0;
    Color cor;
    int posXAntiga, posYAntiga,posXActual, posYActual;
    Graphics2D g2;
     
    PainelDeDesenho painelDesenho = new PainelDeDesenho();
    Timeline painelTimeline = new Timeline();
    
    public FramePrincipal() throws IOException
    {
        
        this.setTitle("Aplicação de desenho");
        this.setSize(larguraDimensaoDaTela(), alturaDimensaoDaTela());
        this.getContentPane().setBackground(new Color(211,211,211));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        
       flagDeDesenhoLabelSeta = flagDeDesenhoLabelLimpar = flagDeDesenhoLabelPincel = flagDeDesenhoLabelBorracha =
       flagDeDesenhoLabelTexto = flagDeDesenhoLabelLinha = flagDeDesenhoBotaoBaldeDeTinta = flagDeDesenhoLabelQuadrado =
       flagDeDesenhoLabelCirculo = flagDeDesenhoLabelTriangulo = flagDeAnimacaolabelAdicionaKeyFrame = flagDeAnimacaolabelPlayAnimacao=
        flagDeAnimacaolabelBlankKeyframe = flagDeAnimacaolabelAdicionarAnimacao = flagDeAnimacaolabelRemoverAnimacao = false;

        
        adicionarMenu(); 
        adicionarPainelIcones();
        adicionarPainelItensKeyframes();
        criarPainelTimeline();
        adicionarPainelDeDesenho();
        
        adicionarIconesNoPainelIcones();
        adicionarIconesNoPainelItensKeyframes();
        
        efeitoHoverDaLabel(labelSeta);
        efeitoHoverDaLabel(labelBorracha);
        efeitoHoverDaLabel(labelLimpar);
        efeitoHoverDaLabel(labelLinha);
        efeitoHoverDaLabel(labelQuadrado);
        efeitoHoverDaLabel(labelCirculo);
        efeitoHoverDaLabel(labelPincel);
        efeitoHoverDaLabel(labelTexto);
        efeitoHoverDoBotao(botaoBaldeDeTinta); 
        efeitoHoverDaLabel(labelQuadradoRedondo);
        
        efeitoHoverDaLabel(labelAdicionaKeyFrame);
        efeitoHoverDaLabel(labelAdicionarAnimacao);
        efeitoHoverDaLabel(labelBlankKeyframe);
        efeitoHoverDaLabel(labelPlayAnimacao);
        efeitoHoverDaLabel(labelRemoverAnimacao);
        
        escutarEventoNaLabelRemoverAnimacao();
        escutarEventoNaLabelBlankKeyframe();
        escutarEventoNaLabelPlayAnimacao();
        escutarEventoNaLabelAdicionarAnimacao();
        escutarEventoNaLabelAdicionaKeyFrame();
        
        
        
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
        //this.setJMenuBar(menuBar);
        this.add(menuBar, BorderLayout.NORTH);
    }        
  
    public void adicionarPainelIcones()
    {
        painelIcones.setBackground(new Color(211,211,211));
        painelIcones.setPreferredSize(new Dimension(40,alturaDimensaoDaTela()));
        painelIcones.setBorder(border2);
        painelIcones.setLayout(new GridLayout(12,0,1,0));
        this.add(painelIcones,BorderLayout.WEST);
    }       
    
    public void adicionarPainelDeDesenho()
    {
        painelDesenho.setPreferredSize(new Dimension(100,100));
        this.add(painelDesenho, BorderLayout.CENTER);
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
        
        labelLimpar.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/sweeping.png"));
        labelLimpar.setCursor(cursor);
       
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

        labelQuadrado.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/rectangle_3.png"));        
        labelQuadrado.setCursor(cursor); 
        
        labelCirculo.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/circle.png"));        
        labelCirculo.setCursor(cursor); 
       
        labelQuadradoRedondo.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/rounded-rectangle.png"));        
        labelQuadradoRedondo.setCursor(cursor); 
        
        painelIcones.add(labelSeta);
        painelIcones.add(labelLimpar);
        painelIcones.add(labelPincel); 
        painelIcones.add(labelBorracha); 
        painelIcones.add(labelTexto); 
        painelIcones.add(labelLinha); 
        painelIcones.add(labelQuadrado); 
        painelIcones.add(labelQuadradoRedondo);
        painelIcones.add(labelCirculo);
        painelIcones.add(botaoBaldeDeTinta); 
      
        validate();
    }     
    
    public void adicionarIconesNoPainelItensKeyframes()
    {
       labelAdicionaKeyFrame.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/plus.png"));
       labelAdicionaKeyFrame.setCursor(cursor);
       
       labelBlankKeyframe.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/blank-page.png"));
       labelBlankKeyframe.setCursor(cursor);
       
       labelAdicionarAnimacao.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/button.png"));
       labelAdicionarAnimacao.setCursor(cursor);
       
       labelRemoverAnimacao.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/delete.png"));
       labelRemoverAnimacao.setCursor(cursor);
       
       labelPlayAnimacao.setIcon(new ImageIcon("/home/creuma/NetBeansProjects/Applicacao de desenho/src/applicacao/de/desenho/play-button-arrowhead.png"));
       labelPlayAnimacao.setCursor(cursor);

       painelItensKeyFrames.add(labelAdicionaKeyFrame);
       painelItensKeyFrames.add(labelBlankKeyframe);
       painelItensKeyFrames.add(labelAdicionarAnimacao);
       painelItensKeyFrames.add(labelRemoverAnimacao);
       painelItensKeyFrames.add(labelPlayAnimacao);
       
       validate();

    }
    
    public void adicionarPainelItensKeyframes()
    {
        painelItensKeyFrames.setBackground(new Color(211,211,211));
        painelItensKeyFrames.setPreferredSize(new Dimension(40,alturaDimensaoDaTela()));
        painelItensKeyFrames.setBorder(border2);
        painelItensKeyFrames.setLayout(new GridLayout(12,0,1,0));
        this.add(painelItensKeyFrames,BorderLayout.EAST);
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
            System.out.println("Cor: "+cor);
        }
    }

    /***************************** Métodos ouvidores**************************/
    
    public void escutarEventoNaLabelSeta()
    {
        labelSeta.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                
                flagDeDesenhoLabelSeta = !flagDeDesenhoLabelSeta;
            }
        }); 
        
    }        
    
    public void escutarEventoNaLabelLimpar()
    {
        labelLimpar.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                
                flagDeDesenhoLabelLimpar = !flagDeDesenhoLabelLimpar;
            }
        }); 
        
    }        
    
    public void escutarEventoNaLabelPincel()
    {
        labelPincel.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeDesenhoLabelPincel= !flagDeDesenhoLabelPincel;
            }
        }); 
        
    }  
    
    public void escutarEventoNaLabelBorracha()
    {
        labelBorracha.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeDesenhoLabelBorracha = !flagDeDesenhoLabelBorracha;
            }
        }); 
        
    }
    
    public void escutarEventoNaLabelTexto()
    {
        labelTexto.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeDesenhoLabelTexto = !flagDeDesenhoLabelTexto;
            }
        }); 
        
    }   
    
    public void escutarEventoNaLabelLinha()
    {
        labelLinha.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                
                flagDeDesenhoLabelLinha = !flagDeDesenhoLabelLinha;
                formaGeometrica = 1;
            }
        }); 
        
    }        
   
    public void escutarEventoNoBotaoBaldeDeTinta()
    {
        botaoBaldeDeTinta.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                
               flagDeDesenhoBotaoBaldeDeTinta = !flagDeDesenhoBotaoBaldeDeTinta;
            }
        }); 
        
    }    
    
    public void escutarEventoNaLabelCirculo()
    {
        labelCirculo.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeDesenhoLabelCirculo = !flagDeDesenhoLabelCirculo;
                formaGeometrica = 3;
            }
        }); 
        
    }    
    
    public void escutarEventoNaLabelQuadrado()
    {
        labelQuadrado.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeDesenhoLabelQuadrado = !flagDeDesenhoLabelQuadrado;
                formaGeometrica = 2;
            }
        }); 
        
    } 
    
    public void escutarEventoNaLabelQuadradoRedondo()
    {
        labelQuadradoRedondo.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeDesenhoLabelQuadradoRedondo = !flagDeDesenhoLabelQuadradoRedondo;
                formaGeometrica = 4;
            }
        }); 
        
    } 

    public void escutarEventoNaLabelAdicionaKeyFrame()
    {
        labelAdicionaKeyFrame.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeAnimacaolabelAdicionaKeyFrame = !flagDeAnimacaolabelAdicionaKeyFrame;
            }
        }); 
        
    } 
    
    public void escutarEventoNaLabelAdicionarAnimacao()
    {
        labelAdicionarAnimacao.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeAnimacaolabelAdicionarAnimacao = !flagDeAnimacaolabelAdicionarAnimacao;
            }
        }); 
        
    } 
    
    public void escutarEventoNaLabelPlayAnimacao()
    {
        labelPlayAnimacao.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeAnimacaolabelPlayAnimacao = !flagDeAnimacaolabelPlayAnimacao;
            }
        }); 
        
    } 

    public void escutarEventoNaLabelBlankKeyframe()
    {
        labelBlankKeyframe.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeAnimacaolabelBlankKeyframe = !flagDeAnimacaolabelBlankKeyframe;
            }
        }); 
        
    } 
    
    public void escutarEventoNaLabelRemoverAnimacao()
    {
        labelRemoverAnimacao.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flagDeAnimacaolabelRemoverAnimacao = !flagDeAnimacaolabelRemoverAnimacao;
            }
        }); 
        
    }
    
    
    public void criarPainelTimeline(){
        
        painelTimeline = new Timeline();
        JScrollPane scrollPane = new JScrollPane(painelTimeline);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize( new Dimension(larguraDimensaoDaTela(),100 ));
        scrollPane.setBackground(Color.BLACK);
        this.add(scrollPane,BorderLayout.SOUTH);
    }
    
    public class PainelDeDesenho extends JPanel implements ActionListener, MouseListener, MouseMotionListener
    {
        
        int posXAntiga, posYAntiga,posXActual, posYActual;
        ArrayList<FiguraGeometrica>listaDeObjectosDesenhadosNaTela;
        boolean CliqueLabel;
        FiguraGeometrica figura,figuraSelecionada;
        public AffineTransform aft;
        Graphics2D g2d;
        boolean desenharTudo = true;

        int i = 0;
        Thread thread;
        public PainelDeDesenho()
        {
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
            this.setBackground(new Color(255,255,255));
            this.setPreferredSize(new Dimension(100,300));
            listaDeObjectosDesenhadosNaTela = new ArrayList<FiguraGeometrica>();
            
            escutarEventoNaLabelSeta();
            escutarEventoNaLabelLimpar();
            escutarEventoNaLabelPincel();
            escutarEventoNaLabelBorracha();
            escutarEventoNaLabelTexto();
            escutarEventoNaLabelLinha();
            escutarEventoNoBotaoBaldeDeTinta();
            escutarEventoNaLabelQuadrado();
            escutarEventoNaLabelCirculo();
            escutarEventoNaLabelQuadradoRedondo();
            limparPainelDesenho();
           
        }

         @Override
         public void paintComponent(Graphics g) {
             
           super.paintComponent(g);
           g2d = (Graphics2D) g;
           aft = g2d.getTransform();
           g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
           
            listaDeObjectosDesenhadosNaTela.forEach((objecto) -> {
              desenharFormas(objecto);
              g2d.setTransform(aft);
             });
           
            if(!flagDeDesenhoLabelSeta){
            
             if (formaGeometrica == 1 || formaGeometrica == 2 || formaGeometrica == 3 || formaGeometrica
                      == 4) {
                 if (formaGeometrica == 1) {
                    desenharFormas(new FiguraGeometrica(posXActual, posYActual, posXAntiga, posYAntiga,cor, formaGeometrica));
                 } else {
                    int x, y, largura, altura;

                    if (posXAntiga < posXActual) {
                        x = posXAntiga;
                        largura = posXActual - posXAntiga;
                    } else {
                        x = posXActual;
                        largura = posXAntiga - posXActual;
                    }
                    
                    if (posYAntiga < posYActual) {
                        y = posYAntiga;
                        altura = posYActual - posYAntiga;
                    } else {
                        y = posYActual;
                        altura = posYAntiga - posYActual;
                    }

                    desenharFormas(new FiguraGeometrica(x, y, largura, altura, cor, formaGeometrica));
                 }
                
             }
             
          }   
           
          if(flagDeDesenhoLabelPincel){
           
               
           }
           
         }   
        
       
        @Override
        public void actionPerformed(ActionEvent arg0) {
             
        }

        @Override
        public void mouseClicked(MouseEvent arg0) {
           
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
            if(!flagDeDesenhoLabelSeta)
            {    
                posXActual = posXAntiga = e.getX();
                posYActual = posYAntiga = e.getY(); 
                repaint();
            } 
            else {

                figuraSelecionada = null;
                int x1 = e.getX();
                int y1 = e.getY();
                
                for(FiguraGeometrica fg: listaDeObjectosDesenhadosNaTela)
                { 
                    int x2 = fg.getxPos();
                    int y2 = fg.getyPos();
                    
                    if(fg.getForma() == 1)
                    {
                       if(x1 <= x2 && x1>= fg.getLargura())
                        {
                            if(y1<= y2 && y1 >= fg.getAltura())
                            {
                               figuraSelecionada = fg;
                               break;

                            }    
                        }   
                    
                    }     
                     
                    else if(fg.getForma() != 1)
                    {
                        if(x1 >= x2 && x1<= x2+fg.getLargura())
                        {
                            if(y1 >= y2 && y1<= y2+fg.getAltura())
                            {
                               figuraSelecionada = fg;
                               break;
                            }    
                        }
                    } 
                
            }
            
       } 
            
       if(flagDeDesenhoLabelPincel)
            {
                
             g2d.setColor(cor);  
             g2d.fillOval (e.getX (), e.getY (), 10, 10 );
            
            }       
            
            /*if(flagDeDesenhoLabelPincel)
            {
                 desenharOvalLivremente(e);
                
                /*Graphics g = getGraphics ();  
               g.setColor (Color.BLUE);  
               g.fillOval (e.getX (), e.getY (), 10, 10 );
                
                /*posXActual = e.getX();
                posYActual = e.getY(); 
               
               /*posXActual = e.getX();
               posYActual = e.getY();*/  
                /*repaint();
                desenharOvalLivremente(e);
            }*/
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
            if(!flagDeDesenhoLabelSeta){
            
            if (formaGeometrica == 1 || formaGeometrica == 2 || formaGeometrica == 3 || formaGeometrica == 4) {
                if (formaGeometrica == 1) {
                    figura = new FiguraGeometrica(posXActual, posYActual, posXAntiga, posYAntiga,cor, formaGeometrica);
                } else {
                    
                   int x, y, largura, altura;
                   
                   if (posXAntiga < posXActual) {
                       x = posXAntiga;
                       largura = posXActual - posXAntiga;
                   } else {
                       x = posXActual;
                       largura = posXAntiga - posXActual;
                   }
                   
                   if (posYAntiga < posYActual) {
                       y = posYAntiga;
                       altura = posYActual - posYAntiga;
                   } else {
                       y = posYActual;
                       altura = posYAntiga - posYActual;
                   }

                   figura = new FiguraGeometrica(x, y, largura, altura, cor, formaGeometrica);
                }
                listaDeObjectosDesenhadosNaTela.add(figura);
            }
           
        }
            
            
            
            
            
       repaint(); 
    }
           
        @Override
        public void mouseEntered(MouseEvent arg0) {
            
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            
            if(!flagDeDesenhoLabelSeta)
            {    
                posXActual = e.getX();
                posYActual = e.getY(); 
            }
            else
            {
                if(figuraSelecionada!= null)
                {
                    if(figuraSelecionada.getForma() != 1)
                    {
                        figuraSelecionada.setxPos(e.getX());
                        figuraSelecionada.setyPos(e.getY());
                        repaint();
                    }
                    else if(figuraSelecionada.getForma()==1)
                    {
                        int largura = figuraSelecionada.getLargura() - figuraSelecionada.getxPos();
                        int altura = figuraSelecionada.getAltura() - figuraSelecionada.getyPos();
                        
                        figuraSelecionada.setxPos(e.getX());
                        figuraSelecionada.setyPos(e.getY());
                        figuraSelecionada.setLargura(largura + figuraSelecionada.getxPos());
                        figuraSelecionada.setAltura(altura + figuraSelecionada.getyPos());
                        repaint();
                    }    
                }
                                
            }
            repaint();
            
            if(flagDeDesenhoLabelPincel)
            {
           
              g2d.setColor(cor);  
              g2d.fillOval (e.getX (), e.getY (), 10, 10 );
            
            }    
            
           /*if(flagDeDesenhoLabelPincel)
           {
               desenharOvalLivremente(e);
               
               /*Graphics g = getGraphics ();  
               g.setColor (Color.BLUE);  
               g.fillOval (e.getX (), e.getY (), 10, 10 );
               
             /*  posXAntiga = e.getX();
               posYAntiga = e.getY();
               repaint();
               /*desenharOvalLivremente(e);
           }*/

           
        }

        public void desenharOvalLivremente(MouseEvent e)
        {
            Graphics g = getGraphics ();  
            g.setColor (Color.BLUE);  
            g.fillOval (e.getX (), e.getY (), 10, 10 );
        } 
        
        @Override
        public void mouseMoved(MouseEvent arg0) {
             
        }
        
          
        public void desenharFormas(FiguraGeometrica figura)
        {       
            g2d.setColor(figura.getCorFigura());
            
            switch (figura.getForma()) {
                case 1:
                    g2d.drawLine(figura.getxPos(), figura.getyPos(), figura.getLargura(), figura.getAltura());
                    break;
                case 2:
                    g2d.fillRect(figura.getxPos(), figura.getyPos(), figura.getLargura(), figura.getAltura());
                    break;
                case 3:
                    g2d.fillOval(figura.getxPos(), figura.getyPos(), figura.getLargura(), figura.getAltura());
                    break;
                 case 4:   
                      g2d.fillRoundRect(figura.getxPos(), figura.getyPos(), figura.getLargura(), figura.getAltura(),18,18);
                    break;
            }
        }
        
        
        public void limparPainelDesenho()
        { 
            if(flagDeDesenhoLabelLimpar)
            {
                listaDeObjectosDesenhadosNaTela.clear();
            }    
        
        }        
        
    }
    
    public final class Timeline extends JPanel{
    
        public ArrayList<ButtonFrames> listaDeFrames;
        public ArrayList<JLabel> containerDeLabel;
         
         public Timeline() {
            super();
            this.listaDeFrames = inicializarListaDeFrames();
            this.setLayout(new BoxLayout(this, 0));
            this.construirParteVisual();
        }
         
        private ArrayList<ButtonFrames> inicializarListaDeFrames(){
            ArrayList<ButtonFrames> lista = new ArrayList<>();
            
            for (int i = 0; i < 25; i++) {
                lista.add(new ButtonFrames());
            }
        return lista;
        
        }
        
        public void construirParteVisual() {
            for(int i = 0; i < this.listaDeFrames.size(); i++) {
                
                final ButtonFrames auxButton = new ButtonFrames();
                auxButton.setMinimumSize(new Dimension(300,200));
                auxButton.setMaximumSize(new Dimension(300,200));
                auxButton.setAlignmentY(TOP_ALIGNMENT);
                auxButton.setFont(new Font("Arial", Font.PLAIN, 10));
                auxButton.id = i;
                auxButton.setText("" + i);
                
                if (i % 5 == 0) {
                    auxButton.setBackground(Color.decode("#41abc3"));
                } else {
                    auxButton.setBackground(new Color(255, 255, 255));
                }    
        }
        
    }    
     
  }


}

