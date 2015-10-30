/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Nuno Lemos
 */

import javax.swing.JInternalFrame;
import javax.swing.JPanel;


public class About extends JInternalFrame{

    public About(){
        super("Acerca da Aplicação");
        Painel acerca = new Painel();
        add(acerca);
        setLocation(250,80);
        setSize(1000, 800);
        setClosable(true);
        setResizable(false);
        setVisible(true);
    }


    private class Painel extends JPanel{

        
    }
}