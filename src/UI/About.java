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

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;


public class About extends JInternalFrame{

    public About(){
        super(Internacionalizacao.Idioma.BUNDLE.getString("About.about.text"));
        Painel acerca = new Painel();
        add(acerca);
        setLocation(150,80);
        setSize(1200, 800);
        setClosable(true);
        setResizable(false);
        setVisible(true);
    }


    private class Painel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Dimension dimensaoPainel = this.getSize();
            double largura = dimensaoPainel.getWidth();
            double altura = dimensaoPainel.getHeight();
            ImageIcon i1 = new ImageIcon("imgs/about.png");
            Image i2 = i1.getImage()/*.getScaledInstance(1200, 800, Image.SCALE_DEFAULT)*/;
            Image i3 = new ImageIcon(i2).getImage();
            g.drawImage(i3, 0, 0, this);
        }
    }


    private ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            return null;
        }
    }

}