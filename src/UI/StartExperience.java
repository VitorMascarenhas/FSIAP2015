/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author Nuno Lemos
 */
public class StartExperience extends JInternalFrame {
    
    

    //construtor
    public StartExperience (){
        super("StartExperience",
          true, //resizable
          true, //closable
          true, //maximizable
          true);//iconifiable
        
        
        
        
        //define o frame
        setSize(1000, 800);
        setClosable(true);
        setResizable(true);
        setVisible(true);
        setMinimumSize(new Dimension(1000, 800));
    }
    
}