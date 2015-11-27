/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
//
//
public class ImportMaterials extends JInternalFrame {
//     
    public ImportMaterials()
         {
         super("Import Materials",
          true, //resizable
          true, //closable
          true, //maximizable
          true);//iconifiable

        
//        JPanel content = new JPanel();
//        content.setLayout(new BorderLayout());
//        
//        JButton importar = new JButton("Import");
//        
//        content.add(importar);
//        add(content);
//
//        content.add(importar, BorderLayout.WEST);
//
//        setContentPane(content);
//        pack();
//         
//         
//        
        setSize(1480, 930);
        setClosable(true);
        setResizable(true);
        setVisible(true);
        setMinimumSize(new Dimension(1000, 800));
         
     }    
}
