/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Internacionalizacao.Idioma;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import Internacionalizacao.Idioma;
import java.awt.Toolkit;

/**
 *
 * @author Nuno Lemos
 */
public class Glossary extends JInternalFrame {
     
    public Glossary()
         {
         super(Internacionalizacao.Idioma.BUNDLE.getString("Glossary.glossary.text"),
          true, //resizable
          true, //closable
          true, //maximizable
          true);//iconifiable

        //... Create content pane, set layout, add components
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        JScrollPane pane = new JScrollPane();
        JTextPane textpane = new JTextPane();
        textpane.setContentType("text/html");
        textpane.setEditable(false);
        String cd = System.getProperty("user.dir") + "/";
        try {
            if(Idioma.IDIOMA == 1){
                textpane.setPage("File:///" + cd + "glossary.html");
            } else {
                textpane.setPage("File:///" + cd + "glossario.html");
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
        textpane.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        pane.getViewport().add(textpane);
        content.add(pane);
        add(content);

        content.add(pane, BorderLayout.CENTER);

        setContentPane(content);
        pack();
        
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension screenMinus50 = new Dimension(screenSize.width - inset*2, screenSize.height - inset*2);
        this.setPreferredSize(screenMinus50);
        this.pack();
        this.setSize(screenMinus50);
        //setSize(1480, 930);
        setClosable(true);
        setResizable(true);
        setVisible(true);
        setMinimumSize(new Dimension(1000, 800));
         
     }    
}