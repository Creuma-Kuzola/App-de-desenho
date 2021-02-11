/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicacao.de.desenho;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author creuma
 */
public class ButtonFrames extends JButton{
    
     public ArrayList<FiguraGeometrica> listaDeDesenhosNesteFrame = new ArrayList<>();
    public boolean keyFrame = false;
    public boolean blankKeyFrame = false;
    public boolean animationPrincipalFrame = false;
    public int inicioAnimation = -1;
    public int fimAnimation = -1;
    public int id;

    public  ArrayList<FiguraGeometrica> getListaDeDesenhosNesteFrame() {
        return listaDeDesenhosNesteFrame;
    }

    public  void setListaDeDesenhosNesteFrame(ArrayList<FiguraGeometrica> listaDeDesenhosNesteFrame) {
        this.listaDeDesenhosNesteFrame = listaDeDesenhosNesteFrame;
    }
    
    public void inserirFiguraGeometrica(FiguraGeometrica novaFiguraGeometrica) {
        this.listaDeDesenhosNesteFrame.add(novaFiguraGeometrica);
    }

    public boolean isKeyFrame() {
        return keyFrame;
    }

    public void setKeyFrame(boolean keyFrame) {
        this.keyFrame = keyFrame;
    }

    public boolean isBlankKeyFrame() {
        return blankKeyFrame;
    }

    public void setBlankKeyFrame(boolean blankKeyFrame) {
        this.blankKeyFrame = blankKeyFrame;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public int getID() {
        return id;
    }

    public boolean isAnimationPrincipalFrame() {
        return animationPrincipalFrame;
    }

    public void setAnimationPrincipalFrame(boolean animationPrincipalFrame) {
        this.animationPrincipalFrame = animationPrincipalFrame;
    }

    public int getInicioAnimation() {
        return inicioAnimation;
    }

    public void setInicioAnimation(int inicioAnimation) {
        this.inicioAnimation = inicioAnimation;
    }

    public int getFimAnimation() {
        return fimAnimation;
    }

    public void setFimAnimation(int fimAnimation) {
        this.fimAnimation = fimAnimation;
    }
    
    
    
    @Override
    public String toString() {
        return "Frame ID: " + id;
    }
    
   /* public FiguraGeometrica getFiguraPosicao(Point pontoClicado, int frame) {
        final int X1 = (int) pontoClicado.getX();
        final int Y1 = (int) pontoClicado.getY();
        
        for (final FiguraGeometrica figura : listaDeDesenhosNesteFrame) {
            final int X2 = (int) figura.getPosXFrame(frame);
            final int Y2 = (int) figura.getPosYFrame(frame);
            
            if ((X1 >= X2 && Y1 >= Y2) && (X1 <= (X2 + figura.largura) && Y1 <= (Y2 + figura.altura) )) {
                return figura;
            }
        }
        return null;
    }
    */
    
}
