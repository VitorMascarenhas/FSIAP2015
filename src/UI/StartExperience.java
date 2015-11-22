/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
        
        // paineis para dados das paredes
        JPanel painelParedeA = new JPanel();
        JPanel painelParedeB = new JPanel();
        JPanel painelParedeC = new JPanel();
        JPanel painelParedeD = new JPanel();
        JPanel painelSolo = new JPanel();
        JPanel painelTeto = new JPanel();
        
        JLabel lblAlturaPrdA = new JLabel("Altura");
        JLabel lblAlturaValPrdA = new JLabel();
        JLabel lblLarguraPrdA = new JLabel("Largura");
        JLabel lblLarguraValPrdA = new JLabel();
        JLabel lblEspessuraPrdA = new JLabel("Espessura");
        JTextField txtEspCamPrdA = new JTextField();
        JLabel lblMaterialPrdA = new JLabel("Material");
        JComboBox cmbMaterialPrdA = new JComboBox();
        JButton btnValidaCamadaA = new JButton("Valida Parede");
        
        painelParedeA.setLayout(new FlowLayout());
        painelParedeA.add(lblAlturaPrdA);
        painelParedeA.add(lblAlturaValPrdA);
        painelParedeA.add(lblLarguraPrdA);
        painelParedeA.add(lblLarguraValPrdA);
        
        
        JTabbedPane separadores = new JTabbedPane();
        separadores.add(painelParedeA, 0);
        separadores.setTitleAt(0, "Parede A");
        separadores.add(painelParedeB, 1);
        separadores.setTitleAt(1, "Parede B");
        separadores.add(painelParedeC, 2);
        separadores.setTitleAt(2, "Parede C");
        separadores.add(painelParedeD, 3);
        separadores.setTitleAt(3, "Parede D");
        separadores.add(painelSolo, 4);
        separadores.setTitleAt(4, "Chão");
        separadores.add(painelTeto, 5);
        separadores.setTitleAt(5, "Této");
        separadores.setMaximumSize(null);
        
        JPanel painelSeparadores = new JPanel();
        painelSeparadores.add(separadores);
        
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
        
        
        
        
        panelLeft.add(panelLeftNorth, BorderLayout.NORTH);
        panelLeft.add(panelLeftSouth, BorderLayout.CENTER);
        
        
        JPanel panelRight = new JPanel();
        
        //label_separadores = new JLabel("Espaço reservado para Separadores");
        //panelRight.add(label_separadores);
        panelRight.setLayout(new BorderLayout());
        panelRight.add(painelSeparadores, BorderLayout.NORTH);
        panelRight.add(painelParedeA, BorderLayout.CENTER);
        
        
        contentPane.add(panelLeft, BorderLayout.CENTER);
        contentPane.add(panelRight, BorderLayout.EAST);
                
        //define o frame
        setSize(800, 600);
        setMinimumSize(new Dimension(800, 600));
        Dimension paneSize = contentPane.getSize();   
        Dimension screenSize = contentPane.getToolkit().getScreenSize();   
        
        setVisible(true);
    }
}