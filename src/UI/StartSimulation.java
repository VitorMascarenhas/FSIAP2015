/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.JInternalFrame;

/**
 *
 * @author Nuno Lemos
 */
public class StartSimulation extends JInternalFrame {
    private JTextField altura1, largura1, espessura1, temperaturaExterior, temperaturaInterior, temperaturaSolo, comprimentoCasa, larguraCasa, alturaCasa;
    private JLabel label_metrosaltura1, label_metroslargura1, label_metrosespessura1, label_espessura1, label_espaco1, label_material1, label_largura1, label_altura1, label_temperaturas, label_dimensoes, label_temperaturaExterior, label_temperaturaInterior, label_temperaturaSolo, label_comprimentoCasa, label_larguraCasa, label_alturaCasa, label_html, label_separadores;
    private JComboBox material1;
    private JButton buttonclean1, buttonadd1, buttonnext1;
    private JList camadas1;
    
    public StartSimulation() {
        super("StartSimulation",
          true, //resizable
          true, //closable
          true, //maximizable
          true);//iconifiable
        
        Container contentPane = getContentPane();
        //Use the content pane's default BorderLayout.
        contentPane.setLayout(new BorderLayout()); //unnecessary

        JPanel panelLeft = new JPanel();
        
        JPanel panelLeftNorth = new JPanel();
        panelLeftNorth.setLayout( new GridLayout(2,7) );
        
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
        
        
        
        //Espaço reservado para apresentação do HTML
        
//        label_html = new JLabel("Espaço reservado para HTML");
//        panelLeftSouth.add(label_html);
        
        
        
        
        panelLeft.add(panelLeftNorth,
                        BorderLayout.NORTH);
        panelLeft.add(panelLeftSouth,
                        BorderLayout.CENTER);
        
        
        JPanel panelRight = new JPanel();
        
            
        
        
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("imgs/middle.gif");

        JComponent parede1 = (JComponent) makeTextPanel("");
        tabbedPane.addTab("Parede1", icon, parede1, "Parede #1");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent parede2 = (JComponent) makeTextPanel("Parede #2");
        tabbedPane.addTab("Parede2", icon, parede2, "Parede 2");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JComponent parede3 = (JComponent) makeTextPanel("Parede #3");
        tabbedPane.addTab("Parede3", icon, parede3, "Parede 3");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        JComponent parede4 = (JComponent) makeTextPanel("Parede #4");
        parede4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Parede4", icon, parede4, "Parede 4");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        
        JComponent chao = (JComponent) makeTextPanel("Chão #5");
        tabbedPane.addTab("Chão", icon, chao, "Chão");
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);
        
        JComponent teto = (JComponent) makeTextPanel("Teto #6");
        tabbedPane.addTab("Teto", icon, teto, "Teto");
        tabbedPane.setMnemonicAt(5, KeyEvent.VK_6);
        
        panelRight.add(tabbedPane);


        //Espaço reservado para Parede 1
        
        parede1.setLayout( new GridLayout(6,3) );
        
        label_altura1 = new JLabel("Altura");
        altura1 = new JTextField(5);
        label_metrosaltura1 = new JLabel("mts");
        
        label_largura1 = new JLabel("Largura");
        largura1 = new JTextField(5);
        label_metroslargura1 = new JLabel("mts");
        
        label_material1 = new JLabel("Material");
        material1 = new JComboBox();
        label_espaco1 = new JLabel("");
        
        label_espessura1 = new JLabel("Espessura");
        espessura1 = new JTextField(5);
        label_metrosespessura1 = new JLabel("mts");
             
        buttonclean1 = new JButton("Limpar");
        buttonadd1 = new JButton("Adicionar");
        buttonnext1 = new JButton("Seguinte");

        
//        final DefaultListModel model_camadas;
//        model_camadas = new DefaultListModel();
//        
//        camadas1 = new JList(model_camadas); //data has type Object[]
//        camadas1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//        camadas1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
//        camadas1.setVisibleRowCount(-1);
//       
//        JScrollPane listScroller = new JScrollPane(camadas1);
//        listScroller.setPreferredSize(new Dimension(250, 80));
        
        
        
        
        parede1.add(label_altura1);
        parede1.add(altura1);
        parede1.add(label_metrosaltura1);
        
        parede1.add(label_largura1);
        parede1.add(largura1);
        parede1.add(label_metroslargura1);
        
        parede1.add(label_material1);
        parede1.add(material1);
        parede1.add(label_espaco1);
        
        parede1.add(label_espessura1);
        parede1.add(espessura1);
        parede1.add(label_metrosespessura1);

        parede1.add(buttonclean1);
        parede1.add(buttonadd1);
        parede1.add(buttonnext1);

//        parede1.add(camadas1);
        
        
//        for (int i = 0; i < 15; i++){
//            model_camadas.addElement("Element " + i);
//        }
//
//            buttonadd1.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    model_camadas.addElement("Element");                    
//                }
//            });
        
                
       
             
        
        
        
        

        //Painel principal dividido em 2 - (Centro e Este)
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
    
    protected Component makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
//        JLabel filler = new JLabel(text);
//        filler.setHorizontalAlignment(JLabel.CENTER);
//        panel.setLayout(new GridLayout(1, 1));
//        panel.add(filler);
        return panel;
    }
    
    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
       
}