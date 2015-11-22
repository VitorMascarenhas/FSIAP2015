/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.JInternalFrame;

/**
 *
 * @author Nuno Lemos
 */
public class StartExperience extends JInternalFrame {
    private JTextField temperaturaExterior, temperaturaInterior, temperaturaSolo, comprimentoCasa, larguraCasa, alturaCasa;
    private JLabel label_temperaturas, label_dimensoes, label_temperaturaExterior, label_temperaturaInterior, label_temperaturaSolo, label_comprimentoCasa, label_larguraCasa, label_alturaCasa, label_html, label_separadores;

    public StartExperience() {
        super("StartExperience",
          true, //resizable
          true, //closable
          true, //maximizable
          true);//iconifiable
        
        Container contentPane = getContentPane();
        //Use the content pane's default BorderLayout.
        contentPane.setLayout(new BorderLayout()); //unnecessary

        JPanel panelLeft = new JPanel();
        
        JPanel panelLeftNorth = new JPanel();
        panelLeftNorth.setLayout( new GridLayout(2,10) );
        
        label_temperaturas = new JLabel("Temperaturas:");
        label_temperaturaExterior = new JLabel("Exterior");
        temperaturaExterior = new JTextField(5);
        label_temperaturaInterior = new JLabel("Interior");
        temperaturaInterior = new JTextField(5);
        label_temperaturaSolo = new JLabel("Solo");
        temperaturaSolo = new JTextField(5);
        
        label_dimensoes = new JLabel("Dimensões Casa:");
        label_comprimentoCasa = new JLabel("Comprimento");
        comprimentoCasa = new JTextField(5);
        label_larguraCasa = new JLabel("Largura");
        larguraCasa = new JTextField(5);
        label_alturaCasa = new JLabel("Altura");
        alturaCasa = new JTextField(5);
        
        panelLeftNorth.add(label_temperaturas);
        panelLeftNorth.add(label_temperaturaExterior);
        panelLeftNorth.add(temperaturaExterior);
        panelLeftNorth.add(label_temperaturaInterior);
        panelLeftNorth.add(temperaturaInterior);
        panelLeftNorth.add(label_temperaturaSolo);
        panelLeftNorth.add(temperaturaSolo);
        panelLeftNorth.add(label_dimensoes);
        panelLeftNorth.add(label_comprimentoCasa);
        panelLeftNorth.add(comprimentoCasa);
        panelLeftNorth.add(label_larguraCasa);
        panelLeftNorth.add(larguraCasa);
        panelLeftNorth.add(label_alturaCasa);
        panelLeftNorth.add(alturaCasa);
        
        
        JPanel panelLeftSouth = new JPanel();
        
        label_html = new JLabel("Espaço reservado para HTML");
        panelLeftSouth.add(label_html);
        
        
        
        
        panelLeft.add(panelLeftNorth,
                        BorderLayout.NORTH);
        panelLeft.add(panelLeftSouth,
                        BorderLayout.CENTER);
        
        
        JPanel panelRight = new JPanel();
        
        label_separadores = new JLabel("Espaço reservado para Separadores");
        panelRight.add(label_separadores);
        
        
        
        contentPane.add(panelLeft,
                        BorderLayout.CENTER);
        contentPane.add(panelRight,
                        BorderLayout.EAST);
                
        //define o frame
        setSize(800, 600);
        setMinimumSize(new Dimension(800, 600));
        Dimension paneSize = contentPane.getSize();   
        Dimension screenSize = contentPane.getToolkit().getScreenSize();   
        
        setVisible(true);
    }
}