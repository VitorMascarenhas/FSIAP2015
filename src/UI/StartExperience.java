/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
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
        
        JPanel painelNorte = new JPanel();
        
        GridBagConstraints constDimTmp = new GridBagConstraints();
        GridBagLayout layoutDimTmp = new GridBagLayout();
        painelNorte.setLayout(layoutDimTmp);
        
        contentPane.add(painelNorte, BorderLayout.NORTH);
        
        JPanel painelDireito = new JPanel();
        contentPane.add(painelDireito, BorderLayout.EAST);
        //JPanel panelLeft = new JPanel();
        
        // paineis para dados das paredes
        JPanel painelParedeA = new JPanel();
        JPanel painelParedeB = new JPanel();
        JPanel painelParedeC = new JPanel();
        JPanel painelParedeD = new JPanel();
        JPanel painelSolo = new JPanel();
        JPanel painelTeto = new JPanel();
        
        JLabel lblAlturaPrdA = new JLabel("Altura");
        JLabel lblAlturaValPrdA = new JLabel("__");
        JLabel lblLarguraPrdA = new JLabel("Largura");
        JLabel lblLarguraValPrdA = new JLabel("__");
        JLabel lblEspessuraPrdA = new JLabel("Espessura");
        JTextField txtEspCamPrdA = new JTextField();
        JLabel lblMaterialPrdA = new JLabel("Material");
        JComboBox cmbMaterialPrdA = new JComboBox();
        JButton btnValidaCamadaA = new JButton("Valida Parede");
        
        GridBagConstraints constParedeA = new GridBagConstraints();
        GridBagLayout layoutParedeA = new GridBagLayout();
        painelParedeA.setLayout(layoutParedeA);
        constParedeA.insets = new Insets(10, 10, 10, 10);
        painelParedeA.add(lblAlturaPrdA, constParedeA);
        constParedeA.gridx = 1;
        painelParedeA.add(lblLarguraPrdA, constParedeA);
        constParedeA.gridx = 2;
        painelParedeA.add(lblEspessuraPrdA, constParedeA);
        constParedeA.gridx = 3;
        painelParedeA.add(lblMaterialPrdA, constParedeA);
        constParedeA.gridx = 0;
        constParedeA.gridy = 1;
        
        painelParedeA.add(lblAlturaValPrdA, constParedeA);
        constParedeA.gridx = 1;
        painelParedeA.add(lblLarguraValPrdA, constParedeA);
        constParedeA.gridx = 2;
        painelParedeA.add(txtEspCamPrdA, constParedeA);
        constParedeA.gridx = 3;
        painelParedeA.add(cmbMaterialPrdA, constParedeA);
        // Cria o objeto parede
        JButton btnValidarParedeA = new JButton("Validar parede A");
        constParedeA.gridx = 0;
        constParedeA.gridy = 2;
        constParedeA.gridheight = 3;
        painelParedeA.add(btnValidaCamadaA, constParedeA);
        constParedeA.gridy = 3;
        constParedeA.gridx = 0;
        JLabel lblLstCompPrdA = new JLabel("Lista de componentes");
        constParedeA.gridy = 4;
        painelParedeA.add(lblLstCompPrdA, constParedeA);
        JList lstCompPrdA = new JList();
        constParedeA.gridy = 5;
        painelParedeA.add(lstCompPrdA, constParedeA);
        
        constDimTmp.gridx = 6;
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
        constDimTmp.gridy = 3;
        painelDireito.add(separadores, constDimTmp);
        
        
        /*
        JPanel painelSeparadores = new JPanel();
        painelSeparadores.add(separadores);
        */
        /*
        JPanel panelLeftNorth = new JPanel();
        panelLeftNorth.setLayout( new GridLayout(2,10) );
        */
        constDimTmp.gridx = 0;
        constDimTmp.gridy = 1;
        
        label_temperaturas = new JLabel("Temperaturas:");
        label_temperaturaExterior = new JLabel("Exterior");
        temperaturaExterior = new JTextField(5);
        label_temperaturaInterior = new JLabel("Interior");
        temperaturaInterior = new JTextField(5);
        label_temperaturaSolo = new JLabel("Solo");
        temperaturaSolo = new JTextField(5);
        
        constDimTmp.gridx = 0;
        constDimTmp.gridy = 0;
        
        painelNorte.add(label_temperaturas, constDimTmp);
        constDimTmp.gridx = 1;
        painelNorte.add(label_temperaturaExterior, constDimTmp);
        constDimTmp.gridx = 2;
        painelNorte.add(temperaturaExterior, constDimTmp);
        constDimTmp.gridx = 3;
        painelNorte.add(label_temperaturaInterior, constDimTmp);
        constDimTmp.gridx = 4;
        painelNorte.add(temperaturaInterior, constDimTmp);
        constDimTmp.gridx = 5;
        painelNorte.add(label_temperaturaSolo, constDimTmp);
        constDimTmp.gridx = 6;
        painelNorte.add(temperaturaSolo, constDimTmp);
        
        label_dimensoes = new JLabel("Dimensões Casa:");
        label_comprimentoCasa = new JLabel("Comprimento");
        comprimentoCasa = new JTextField(5);
        label_larguraCasa = new JLabel("Largura");
        larguraCasa = new JTextField(5);
        label_alturaCasa = new JLabel("Altura");
        alturaCasa = new JTextField(5);
        
        constDimTmp.gridx = 0;
        constDimTmp.gridy = 2;
        
        painelNorte.add(label_dimensoes, constDimTmp);
        constDimTmp.gridx = 1;
        painelNorte.add(label_alturaCasa, constDimTmp);
        constDimTmp.gridx = 2;
        painelNorte.add(alturaCasa, constDimTmp);
        constDimTmp.gridx = 3;
        painelNorte.add(label_larguraCasa, constDimTmp);
        constDimTmp.gridx = 4;
        painelNorte.add(larguraCasa, constDimTmp);
        constDimTmp.gridx = 5;
        painelNorte.add(label_comprimentoCasa, constDimTmp);
        constDimTmp.gridx = 6;
        painelNorte.add(comprimentoCasa, constDimTmp);
        constDimTmp.gridx = 7;
        
        constDimTmp.gridx = 6;
        constDimTmp.gridy = 4;
        painelNorte.add(separadores, constDimTmp);
        
        
                /*
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
        */
        /*
        JPanel panelLeftSouth = new JPanel();
        
        label_html = new JLabel("Espaço reservado para HTML");
        panelLeftSouth.add(label_html);
        
        
        
        
        panelLeft.add(panelLeftNorth, BorderLayout.NORTH);
        panelLeft.add(panelLeftSouth, BorderLayout.CENTER);
        */
        
        //JPanel panelRight = new JPanel();
        
        //label_separadores = new JLabel("Espaço reservado para Separadores");
        //panelRight.add(label_separadores);
        /*panelRight.setLayout(new BorderLayout());
        panelRight.add(painelSeparadores, BorderLayout.NORTH);
        panelRight.add(painelParedeA, BorderLayout.CENTER);
        */
        
        //contentPane.add(panelLeft, BorderLayout.CENTER);
        //contentPane.add(panelRight, BorderLayout.EAST);
                
        //define o frame
        setSize(800, 600);
        setMinimumSize(new Dimension(800, 600));
        Dimension paneSize = contentPane.getSize();   
        Dimension screenSize = contentPane.getToolkit().getScreenSize();   
        
        setVisible(true);
    }
}