/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Dominio.Componente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Nuno Lemos
 */
public class StartSimulation extends JInternalFrame {

    private JTextField c_altura1, c_largura1, c_espessura1,
            j_altura1, j_largura1, j_espessura1,
            p_altura1, p_largura1, p_espessura1,
            temperaturaExterior, temperaturaInterior, temperaturaSolo, comprimentoCasa, larguraCasa, alturaCasa;
    private JLabel lb_c_metrosaltura1, lb_c_metroslargura1, lb_c_metrosespessura1, lb_c_espessura1, lb_c_material1, lb_c_largura1, lb_c_altura1,
            lb_j_metrosaltura1, lb_j_metroslargura1, lb_j_metrosespessura1, lb_j_espessura1, lb_j_material1, lb_j_largura1, lb_j_altura1,
            lb_p_metrosaltura1, lb_p_metroslargura1, lb_p_metrosespessura1, lb_p_espessura1, lb_p_material1, lb_p_largura1, lb_p_altura1,
            lb_espaco1, lb_c_espaco11, lb_c_espaco12, lb_c_espaco13, lb_c_espaco14, lb_c_espaco15,
            lb_j_espaco11, lb_j_espaco12, lb_j_espaco13, lb_j_espaco14, lb_j_espaco15,
            lb_p_espaco11, lb_p_espaco12, lb_p_espaco13, lb_p_espaco14, lb_p_espaco15,
            lb_temp_ext_unid, lb_temp_int_unid, lb_temp_sol_unid, lb_comprimento_unid, lb_largura_unid, lb_altura_unid,
            lb_temperaturas, lb_dimensoes, lb_temperaturaExterior, lb_temperaturaInterior, lb_temperaturaSolo, lb_comprimentoCasa, lb_larguraCasa, lb_alturaCasa, lb_buttondef, lb_html, lb_separadores;
    private JComboBox c_material1, j_material1, p_material1;
    private JButton c_buttonadd1, j_buttonadd1, p_buttonadd1, buttonclean1, buttonnext1, buttondefinir;
    private JList camadas1;
    private JList<Componente> listc, listj, listp;

    public StartSimulation() {
        super(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.simulation.text"),
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable

        Container contentPane = getContentPane();
        //Use the content pane's default BorderLayout.
        contentPane.setLayout(new BorderLayout()); //unnecessary

        JPanel panelLeft = new JPanel();

        JPanel panelLeftNorth = new JPanel();
        panelLeftNorth.setLayout(new GridLayout(2, 11));

        lb_temperaturas = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.temperatures.text"));
        lb_temperaturaExterior = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.outside.text"));
        temperaturaExterior = new JTextField(5);
        lb_temp_ext_unid = new JLabel("ºC");
        lb_temperaturaInterior = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.inside.text"));
        temperaturaInterior = new JTextField(5);
        lb_temp_int_unid = new JLabel("ºC");
        lb_temperaturaSolo = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.floor1.text"));
        temperaturaSolo = new JTextField(5);
        lb_temp_sol_unid = new JLabel("ºC");
        lb_buttondef = new JLabel("");

        lb_dimensoes = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.houseDimensions.text"));
        lb_comprimentoCasa = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.length.text"));
        comprimentoCasa = new JTextField(5);
        lb_comprimento_unid = new JLabel("m");
        lb_larguraCasa = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.width.text"));
        larguraCasa = new JTextField(5);
        lb_largura_unid = new JLabel("m");
        lb_alturaCasa = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.height.text"));
        alturaCasa = new JTextField(5);
        lb_altura_unid = new JLabel("m");

        buttondefinir = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.define.text"));
        buttondefinir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed
                Float comprimento = (Float.parseFloat(comprimentoCasa.getText()));
                c_largura1.setText(comprimento.toString());
                Float altura = (Float.parseFloat(alturaCasa.getText()));
                c_altura1.setText(altura.toString());
            }
        });

        panelLeftNorth.add(lb_temperaturas);
        panelLeftNorth.add(lb_temperaturaExterior);
        panelLeftNorth.add(temperaturaExterior);
        panelLeftNorth.add(lb_temp_ext_unid);
        panelLeftNorth.add(lb_temperaturaInterior);
        panelLeftNorth.add(temperaturaInterior);
        panelLeftNorth.add(lb_temp_int_unid);
        panelLeftNorth.add(lb_temperaturaSolo);
        panelLeftNorth.add(temperaturaSolo);
        panelLeftNorth.add(lb_temp_sol_unid);
        panelLeftNorth.add(lb_buttondef);

        panelLeftNorth.add(lb_dimensoes);
        panelLeftNorth.add(lb_comprimentoCasa);
        panelLeftNorth.add(comprimentoCasa);
        panelLeftNorth.add(lb_comprimento_unid);
        panelLeftNorth.add(lb_larguraCasa);
        panelLeftNorth.add(larguraCasa);
        panelLeftNorth.add(lb_largura_unid);
        panelLeftNorth.add(lb_alturaCasa);
        panelLeftNorth.add(alturaCasa);
        panelLeftNorth.add(lb_altura_unid);

        panelLeftNorth.add(buttondefinir);

        JPanel panelLeftSouth = new JPanel();

        //Espaço reservado para apresentação do HTML
//        label_html = new JLabel("Espaço reservado para HTML");
//        panelLeftSouth.add(label_html);
        panelLeft.add(panelLeftNorth,
                BorderLayout.NORTH);
        panelLeft.add(panelLeftSouth,
                BorderLayout.CENTER);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BorderLayout());
        
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("imgs/middle.gif");

        JComponent parede1 = (JComponent) makeTextPanel("Parede #1");
        tabbedPane.addTab(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall1.text"), icon, parede1, Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall1.text"));
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent parede2 = (JComponent) makeTextPanel("Parede #2");
        tabbedPane.addTab(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall2.text"), icon, parede2, Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall2.text"));
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JComponent parede3 = (JComponent) makeTextPanel("Parede #3");
        tabbedPane.addTab(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall3.text"), icon, parede3, Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall3.text"));
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        JComponent parede4 = (JComponent) makeTextPanel("Parede #4");
        parede4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall4.text"), icon, parede4, Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall4.text"));
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

        JComponent chao = (JComponent) makeTextPanel("Chão #5");
        tabbedPane.addTab(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.floor2.text"), icon, chao, Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.floor2.text"));
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);

        JComponent teto = (JComponent) makeTextPanel("Teto #6");
        tabbedPane.addTab(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.ceiling.text"), icon, teto, Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.ceiling.text"));
        tabbedPane.setMnemonicAt(5, KeyEvent.VK_6);

        panelRight.add(tabbedPane, BorderLayout.NORTH);
        
        //Espaço reservado para Parede 1
        parede1.setLayout(new GridLayout(19, 3));

        //camada
        lb_c_altura1 = new JLabel("Altura Camada");
        c_altura1 = new JTextField(5);
        c_altura1.setEnabled(false);
        lb_c_metrosaltura1 = new JLabel("m");

        lb_c_largura1 = new JLabel("Largura Camada");
        c_largura1 = new JTextField(5);
        c_largura1.setEnabled(false);
        lb_c_metroslargura1 = new JLabel("m");

        lb_c_material1 = new JLabel("Material Camada");
        c_material1 = new JComboBox();
        lb_c_espaco11 = new JLabel("");

        lb_c_espessura1 = new JLabel("Espessura Camada");
        c_espessura1 = new JTextField(5);
        lb_c_metrosespessura1 = new JLabel("m");

        lb_c_espaco12 = new JLabel("");
        listc = new JList();

        c_buttonadd1 = new JButton("Adicionar Camada");
        c_buttonadd1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed

            }
        });

        lb_c_espaco13 = new JLabel("");
        lb_c_espaco14 = new JLabel("");
        lb_c_espaco15 = new JLabel("");

        //janelas
        lb_j_altura1 = new JLabel("Altura Janela");
        j_altura1 = new JTextField(5);
        lb_j_metrosaltura1 = new JLabel("m");

        lb_j_largura1 = new JLabel("Largura Janela");
        j_largura1 = new JTextField(5);
        lb_j_metroslargura1 = new JLabel("m");

        lb_j_material1 = new JLabel("Material Janela");
        j_material1 = new JComboBox();
        lb_j_espaco11 = new JLabel("");

        lb_j_espessura1 = new JLabel("Espessura Janela");
        j_espessura1 = new JTextField(5);
        lb_j_metrosespessura1 = new JLabel("m");

        lb_j_espaco12 = new JLabel("");
        listj = new JList<>();
        j_buttonadd1 = new JButton("Adicionar Janela");
        j_buttonadd1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed

            }
        });

        lb_j_espaco13 = new JLabel("");
        lb_j_espaco14 = new JLabel("");
        lb_j_espaco15 = new JLabel("");

        //portas
        lb_p_altura1 = new JLabel("Altura Porta");
        p_altura1 = new JTextField(5);
        lb_p_metrosaltura1 = new JLabel("m");

        lb_p_largura1 = new JLabel("Largura Porta");
        p_largura1 = new JTextField(5);
        lb_p_metroslargura1 = new JLabel("m");

        lb_p_material1 = new JLabel("Material Porta");
        p_material1 = new JComboBox();
        lb_p_espaco11 = new JLabel("");

        lb_p_espessura1 = new JLabel("Espessura Porta");
        p_espessura1 = new JTextField(5);
        lb_p_metrosespessura1 = new JLabel("m");

        lb_p_espaco12 = new JLabel("");
        listp = new JList<>();
        p_buttonadd1 = new JButton("Adicionar Porta");
        p_buttonadd1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed

            }
        });

        lb_p_espaco13 = new JLabel("");
        lb_p_espaco14 = new JLabel("");
        lb_p_espaco15 = new JLabel("");

        buttonclean1 = new JButton("Limpar");
        buttonnext1 = new JButton("Seguinte");
        lb_espaco1 = new JLabel("");

        //adicionar objetos da camada à parede
        parede1.add(lb_c_altura1);
        parede1.add(c_altura1);
        parede1.add(lb_c_metrosaltura1);

        parede1.add(lb_c_largura1);
        parede1.add(c_largura1);
        parede1.add(lb_c_metroslargura1);

        parede1.add(lb_c_material1);
        parede1.add(c_material1);
        parede1.add(lb_c_espaco11);

        parede1.add(lb_c_espessura1);
        parede1.add(c_espessura1);
        parede1.add(lb_c_metrosespessura1);

        parede1.add(lb_c_espaco12);
        parede1.add(listc);
        parede1.add(c_buttonadd1);

        parede1.add(lb_c_espaco13);
        parede1.add(lb_c_espaco14);
        parede1.add(lb_c_espaco15);

        //adicionar objetos da janela à parede
        parede1.add(lb_j_altura1);
        parede1.add(j_altura1);
        parede1.add(lb_j_metrosaltura1);

        parede1.add(lb_j_largura1);
        parede1.add(j_largura1);
        parede1.add(lb_j_metroslargura1);

        parede1.add(lb_j_material1);
        parede1.add(j_material1);
        parede1.add(lb_j_espaco11);

        parede1.add(lb_j_espessura1);
        parede1.add(j_espessura1);
        parede1.add(lb_j_metrosespessura1);

        parede1.add(lb_j_espaco12);
        parede1.add(listj);
        parede1.add(j_buttonadd1);

        parede1.add(lb_j_espaco13);
        parede1.add(lb_j_espaco14);
        parede1.add(lb_j_espaco15);

        //adicionar objetos da porta à parede
        parede1.add(lb_p_altura1);
        parede1.add(p_altura1);
        parede1.add(lb_p_metrosaltura1);

        parede1.add(lb_p_largura1);
        parede1.add(p_largura1);
        parede1.add(lb_p_metroslargura1);

        parede1.add(lb_p_material1);
        parede1.add(p_material1);
        parede1.add(lb_p_espaco11);

        parede1.add(lb_p_espessura1);
        parede1.add(p_espessura1);
        parede1.add(lb_p_metrosespessura1);

        parede1.add(lb_p_espaco12);
        parede1.add(listp);
        parede1.add(p_buttonadd1);

        parede1.add(lb_p_espaco13);
        parede1.add(lb_p_espaco14);
        parede1.add(lb_p_espaco15);

        parede1.add(buttonclean1);
        parede1.add(buttonnext1);
        parede1.add(lb_espaco1);

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

        JList listaComponentes = new JList();
        DefaultListModel<Componente> componentes = new DefaultListModel<>();
        listaComponentes.setModel(componentes);
        listaComponentes.setSize(20, 20);
        listaComponentes.setBackground(Color.black);
        
        panelRight.add(listaComponentes, BorderLayout.CENTER);
        
        //define o frame
        setSize(1480, 930);
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
