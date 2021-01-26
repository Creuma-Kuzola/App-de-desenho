/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicacao.de.desenho;

import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author creuma
 */
public class MenuBar extends JMenuBar {
    
    JMenu file = new JMenu("File");
    
    public MenuBar()
    {
        this.add(file);
        this.setBackground(Color.BLUE);
    
    }        
    
  
   
}
