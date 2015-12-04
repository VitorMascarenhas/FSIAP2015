/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Dominio.*;
import controlador.CriarComponenteControlador;
import controlador.CriarParedeControlador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import Repositorios.Materiais;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author Nuno Lemos
 */
public class StartSimulation extends JInternalFrame {
    
    
    private JTextField altura1, largura1, espessura1, altura2, largura2, espessura2, altura3, largura3, espessura3, altura4, largura4, espessura4, altura5, largura5, espessura5, altura6, largura6, espessura6,
            details1, details2, details3, details4, details5, details6, 
            rt_parede1, rt_parede2, rt_parede3, rt_parede4, rt_chao, rt_teto, rt_total, fluxo, fluxo1, fluxo2, fluxo3, fluxo4, fluxo5, fluxo6,
            temperaturaExterior, temperaturaInterior, temperaturaSolo, comprimentoCasa, larguraCasa, alturaCasa;
    private JLabel lb_metrosaltura1, lb_metroslargura1, lb_metrosespessura1, lb_espessura1, lb_material1, lb_largura1, lb_altura1, lb_tipo1,
            lb_metrosaltura2, lb_metroslargura2, lb_metrosespessura2, lb_espessura2, lb_material2, lb_largura2, lb_altura2, lb_tipo2,
            lb_metrosaltura3, lb_metroslargura3, lb_metrosespessura3, lb_espessura3, lb_material3, lb_largura3, lb_altura3, lb_tipo3,
            lb_metrosaltura4, lb_metroslargura4, lb_metrosespessura4, lb_espessura4, lb_material4, lb_largura4, lb_altura4, lb_tipo4,
            lb_metrosaltura5, lb_metroslargura5, lb_metrosespessura5, lb_espessura5, lb_material5, lb_largura5, lb_altura5, lb_tipo5,
            lb_metrosaltura6, lb_metroslargura6, lb_metrosespessura6, lb_espessura6, lb_material6, lb_largura6, lb_altura6, lb_tipo6,
            lb_espaco10, lb_espaco11, lb_espaco12, lb_espaco13, lb_espaco14, lb_espaco15,
            lb_espaco20, lb_espaco21, lb_espaco22, lb_espaco23, lb_espaco24, lb_espaco25,
            lb_espaco30, lb_espaco31, lb_espaco32, lb_espaco33, lb_espaco34, lb_espaco35,
            lb_espaco40, lb_espaco41, lb_espaco42, lb_espaco43, lb_espaco44, lb_espaco45,
            lb_espaco50, lb_espaco51, lb_espaco52, lb_espaco53, lb_espaco54, lb_espaco55,
            lb_espaco60, lb_espaco61, lb_espaco62, lb_espaco63, lb_espaco64, lb_espaco65,
            lb_rt_parede1, lb_rt_parede2, lb_rt_parede3, lb_rt_parede4, lb_rt_chao, lb_rt_teto, lb_rt_total, lb_fluxo, lb_fluxo1, lb_fluxo2, lb_fluxo3, lb_fluxo4, lb_fluxo5, lb_fluxo6,
            lb_unid_rt1, lb_unid_rt2, lb_unid_rt3, lb_unid_rt4, lb_unid_rt5, lb_unid_rt6, lb_unid_rt7, lb_unid_rt8, lb_unid_fluxo1, lb_unid_fluxo2, lb_unid_fluxo3, lb_unid_fluxo4, lb_unid_fluxo5, lb_unid_fluxo6,
            lb_temp_ext_unid, lb_temp_int_unid, lb_temp_sol_unid, lb_comprimento_unid, lb_largura_unid, lb_altura_unid,
            lb_temperaturas, lb_dimensoes, lb_temperaturaExterior, lb_temperaturaInterior, lb_temperaturaSolo, lb_comprimentoCasa, lb_larguraCasa, lb_alturaCasa,
            lb_buttondef1, lb_buttondef2, lb_buttondef3, lb_buttondef4, lb_buttondef5, lb_buttondef6, lb_buttondef7, lb_buttondef8, lb_buttondef9, lb_buttondef10,
            lb_buttondef11, lb_buttondef12, lb_buttondef13, lb_buttondef14;
    private JComboBox material1, material2, material3, material4, material5, material6,
            tipo1, tipo2, tipo3, tipo4, tipo5, tipo6;
    private JButton buttonadd1, buttonadd2, buttonadd3, buttonadd4, buttonadd5, buttonadd6,
            buttondefinir,
            button_remove1, button_remove2, button_remove3, button_remove4, button_remove5, button_remove6,
            buttonvalidarparede1, buttonvalidarparede2, buttonvalidarparede3, buttonvalidarparede4, buttonvalidarparede5, buttonvalidarparede6;
    private JList<Componente> listaComponentes1, listaComponentes2, listaComponentes3, listaComponentes4, listaComponentes5, listaComponentes6;

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
        panelLeftNorth.setLayout(new GridLayout(5, 7, 10, 10));

        listaComponentes1 = new JList();
        final DefaultListModel<Componente> componentes1 = new DefaultListModel<>();
        listaComponentes1.setModel(componentes1);
        listaComponentes1.setPreferredSize(null);
        JScrollPane scrooll1 = new JScrollPane();
        scrooll1.getViewport().add( listaComponentes1 );
        
        listaComponentes2 = new JList();
        final DefaultListModel<Componente> componentes2 = new DefaultListModel<>();
        listaComponentes2.setModel(componentes2);
        listaComponentes2.setPreferredSize(null);
        JScrollPane scrooll2 = new JScrollPane();
        scrooll2.getViewport().add( listaComponentes2 );
        
        listaComponentes3 = new JList();
        final DefaultListModel<Componente> componentes3 = new DefaultListModel<>();
        listaComponentes3.setModel(componentes3);
        listaComponentes3.setPreferredSize(null);
        JScrollPane scrooll3 = new JScrollPane();
        scrooll3.getViewport().add( listaComponentes3 );
                
        listaComponentes4 = new JList();
        final DefaultListModel<Componente> componentes4 = new DefaultListModel<>();
        listaComponentes4.setModel(componentes4);
        listaComponentes4.setPreferredSize(null);
        JScrollPane scrooll4 = new JScrollPane();
        scrooll4.getViewport().add( listaComponentes4 );
        
        listaComponentes5 = new JList();
        final DefaultListModel<Componente> componentes5 = new DefaultListModel<>();
        listaComponentes5.setModel(componentes5);
        listaComponentes5.setPreferredSize(null);
        JScrollPane scrooll5 = new JScrollPane();
        scrooll5.getViewport().add( listaComponentes5 );
        
        listaComponentes6 = new JList();
        final DefaultListModel<Componente> componentes6 = new DefaultListModel<>();
        listaComponentes6.setModel(componentes6);
        listaComponentes6.setPreferredSize(null);
        JScrollPane scrooll6 = new JScrollPane();
        scrooll6.getViewport().add( listaComponentes6 );
        
        
        
        
        
        lb_temperaturas = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.temperatures.text"));
        lb_buttondef1 = new JLabel("");
        lb_buttondef2 = new JLabel("");
        lb_buttondef3 = new JLabel("");
        lb_temperaturaExterior = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.outside.text"));
        temperaturaExterior = new JTextField(5);
        lb_temp_ext_unid = new JLabel("ºC");
        lb_buttondef4 = new JLabel("");
        lb_temperaturaInterior = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.inside.text"));
        temperaturaInterior = new JTextField(5);
        lb_temp_int_unid = new JLabel("ºC");
        lb_buttondef5 = new JLabel("");
        lb_temperaturaSolo = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.floorS.text"));
        temperaturaSolo = new JTextField(5);
        lb_temp_sol_unid = new JLabel("ºC");
        lb_buttondef6 = new JLabel("");
        lb_dimensoes = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.houseDimensions.text"));
        lb_buttondef7 = new JLabel("");
        lb_buttondef8 = new JLabel("");
        lb_buttondef9 = new JLabel("");
        lb_comprimentoCasa = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.length.text"));
        comprimentoCasa = new JTextField(5);
        lb_comprimento_unid = new JLabel("m");
        lb_buttondef10 = new JLabel("");
        lb_larguraCasa = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.width.text"));
        larguraCasa = new JTextField(5);
        lb_largura_unid = new JLabel("m");
        lb_buttondef11 = new JLabel("");
        lb_alturaCasa = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.height.text"));
        alturaCasa = new JTextField(5);
        lb_altura_unid = new JLabel("m");
        lb_buttondef12 = new JLabel("");
        lb_buttondef13 = new JLabel("");
        lb_buttondef14 = new JLabel("");
        buttondefinir = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.define.text"));
        buttondefinir.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                if(comprimentoCasa.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo comprimento da casa está vazio.\nInsira um comprimento para a casa.");
                }
                if(alturaCasa.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo altura da casa está vazio.\nInsira uma altura para a casa.");
                }
                if(larguraCasa.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo largura da casa está vazio.\nInsira uma largura para a casa.");
                }
                if(temperaturaExterior.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo temperatura exterior da casa está vazio.\nInsira uma temperatura exterior para a casa.");
                }
                if(temperaturaInterior.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo temperatura interior da casa está vazio.\nInsira uma temperatura interior para a casa.");
                }
                if(temperaturaSolo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo temperatura do solo da casa está vazio.\nInsira uma temperatura do solo para a casa.");
                }
                //Execute when button is pressed
                Float comprimento = (Float.parseFloat(comprimentoCasa.getText()));
                largura1.setText(comprimento.toString());
                Float altura = (Float.parseFloat(alturaCasa.getText()));
                altura1.setText(altura.toString());
                
                comprimentoCasa.setEnabled(false);
                alturaCasa.setEnabled(false);
                larguraCasa.setEnabled(false);
                temperaturaExterior.setEnabled(false);
                temperaturaInterior.setEnabled(false);
                temperaturaSolo.setEnabled(false);
            }
        });

        panelLeftNorth.add(lb_temperaturas);    panelLeftNorth.add(lb_buttondef1);  panelLeftNorth.add(lb_buttondef2);  panelLeftNorth.add(lb_buttondef3);  panelLeftNorth.add(lb_dimensoes);   panelLeftNorth.add(lb_buttondef4);  panelLeftNorth.add(lb_buttondef5);
        panelLeftNorth.add(lb_temperaturaExterior); panelLeftNorth.add(temperaturaExterior);    panelLeftNorth.add(lb_temp_ext_unid);   panelLeftNorth.add(lb_buttondef6);  panelLeftNorth.add(lb_comprimentoCasa); panelLeftNorth.add(comprimentoCasa);    panelLeftNorth.add(lb_comprimento_unid);
        panelLeftNorth.add(lb_temperaturaInterior); panelLeftNorth.add(temperaturaInterior);    panelLeftNorth.add(lb_temp_int_unid);   panelLeftNorth.add(lb_buttondef7);  panelLeftNorth.add(lb_larguraCasa); panelLeftNorth.add(larguraCasa);    panelLeftNorth.add(lb_largura_unid);
        panelLeftNorth.add(lb_temperaturaSolo); panelLeftNorth.add(temperaturaSolo);    panelLeftNorth.add(lb_temp_sol_unid);   panelLeftNorth.add(lb_buttondef8);  panelLeftNorth.add(lb_alturaCasa);  panelLeftNorth.add(alturaCasa); panelLeftNorth.add(lb_altura_unid);
        panelLeftNorth.add(lb_buttondef9);  panelLeftNorth.add(lb_buttondef10); panelLeftNorth.add(lb_buttondef11); panelLeftNorth.add(lb_buttondef12); panelLeftNorth.add(lb_buttondef13); panelLeftNorth.add(lb_buttondef14); panelLeftNorth.add(buttondefinir);

        JPanel panelLeftCenter = new JPanel();

        ImageIcon image = new ImageIcon("imgs/DEI_logo_v2.png");
        JLabel label = new JLabel("", image, JLabel.CENTER);
        JPanel panelImagem = new JPanel(new BorderLayout());
        panelImagem.add(label, BorderLayout.SOUTH);

        JPanel panelLeftSouth = new JPanel();

        //Apresentação de resultados
        JPanel panelResultados = new JPanel();
        panelResultados.setLayout(new GridLayout(7, 6, 10, 10));

        lb_rt_parede1 = new JLabel((Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.rtwall.text")+" 1"));
        rt_parede1 = new JTextField(10);
        rt_parede1.setEnabled(false);
        lb_unid_rt1 = new JLabel("W-1.C");
        lb_fluxo1 = new JLabel((Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.heatflowwall.text")+" 1"));
        fluxo1 = new JTextField(10);
        fluxo1.setEnabled(false);
        lb_unid_fluxo1 = new JLabel("W");
        
        lb_rt_parede2 = new JLabel((Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.rtwall.text")+" 2"));
        rt_parede2 = new JTextField(10);
        rt_parede2.setEnabled(false);
        lb_unid_rt2 = new JLabel("W-1.C");
        lb_fluxo2 = new JLabel((Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.heatflowwall.text")+" 2"));
        fluxo2 = new JTextField(10);
        fluxo2.setEnabled(false);
        lb_unid_fluxo2 = new JLabel("W");

        lb_rt_parede3 = new JLabel((Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.rtwall.text")+" 3"));
        rt_parede3 = new JTextField(10);
        rt_parede3.setEnabled(false);
        lb_unid_rt3 = new JLabel("W-1.C");
        lb_fluxo3 = new JLabel((Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.heatflowwall.text")+" 3"));
        fluxo3 = new JTextField(10);
        fluxo3.setEnabled(false);
        lb_unid_fluxo3 = new JLabel("W");

        lb_rt_parede4 = new JLabel((Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.rtwall.text")+" 4"));
        rt_parede4 = new JTextField(10);
        rt_parede4.setEnabled(false);
        lb_unid_rt4 = new JLabel("W-1.C");
        lb_fluxo4 = new JLabel((Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.heatflowwall.text")+" 4"));
        fluxo4 = new JTextField(10);
        fluxo4.setEnabled(false);
        lb_unid_fluxo4 = new JLabel("W");

        lb_rt_chao = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.rtfloor.text"));
        rt_chao = new JTextField(10);
        rt_chao.setEnabled(false);
        lb_unid_rt5 = new JLabel("W-1.C");
        lb_fluxo5 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.heatflowfloor.text"));
        fluxo5 = new JTextField(10);
        fluxo5.setEnabled(false);
        lb_unid_fluxo5 = new JLabel("W");

        lb_rt_teto = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.rtceiling.text"));
        rt_teto = new JTextField(10);
        rt_teto.setEnabled(false);
        lb_unid_rt6 = new JLabel("W-1.C");
        lb_fluxo6 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.heatflowceiling.text"));
        fluxo6 = new JTextField(10);
        fluxo6.setEnabled(false);
        lb_unid_fluxo6 = new JLabel("W");

        lb_rt_total = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.rttotal.text"));
        rt_total = new JTextField(10);
        rt_total.setEnabled(false);
        lb_unid_rt7 = new JLabel("W-1.C");

        lb_fluxo = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.heatflowtotal.text"));
        fluxo = new JTextField(10);
        fluxo.setEnabled(false);
        lb_unid_rt8 = new JLabel("W");

        panelResultados.add(lb_rt_parede1); panelResultados.add(rt_parede1);    panelResultados.add(lb_unid_rt1);   panelResultados.add(lb_fluxo1); panelResultados.add(fluxo1);    panelResultados.add(lb_unid_fluxo1);
        panelResultados.add(lb_rt_parede2); panelResultados.add(rt_parede2);    panelResultados.add(lb_unid_rt2);   panelResultados.add(lb_fluxo2); panelResultados.add(fluxo2);    panelResultados.add(lb_unid_fluxo2);
        panelResultados.add(lb_rt_parede3); panelResultados.add(rt_parede3);    panelResultados.add(lb_unid_rt3);   panelResultados.add(lb_fluxo3); panelResultados.add(fluxo3);    panelResultados.add(lb_unid_fluxo3);
        panelResultados.add(lb_rt_parede4); panelResultados.add(rt_parede4);    panelResultados.add(lb_unid_rt4);   panelResultados.add(lb_fluxo4); panelResultados.add(fluxo4);    panelResultados.add(lb_unid_fluxo4);
        panelResultados.add(lb_rt_chao);    panelResultados.add(rt_chao);   panelResultados.add(lb_unid_rt5);   panelResultados.add(lb_fluxo5); panelResultados.add(fluxo5);    panelResultados.add(lb_unid_fluxo5);
        panelResultados.add(lb_rt_teto);    panelResultados.add(rt_teto);   panelResultados.add(lb_unid_rt6);   panelResultados.add(lb_fluxo6); panelResultados.add(fluxo6);    panelResultados.add(lb_unid_fluxo6);
        panelResultados.add(lb_rt_total);   panelResultados.add(rt_total);  panelResultados.add(lb_unid_rt7);   panelResultados.add(lb_fluxo);  panelResultados.add(fluxo); panelResultados.add(lb_unid_rt8);

        panelLeftCenter.add(panelImagem);
        panelLeftSouth.add(panelResultados);

        panelLeft.add(panelLeftNorth,
                BorderLayout.NORTH);
        panelLeft.add(panelLeftCenter,
                BorderLayout.CENTER);
        panelLeft.add(panelLeftSouth,
                BorderLayout.SOUTH);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("imgs/middle.gif");

        JComponent parede1 = (JComponent) makeTextPanel("Parede #1");
        tabbedPane.addTab((Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall.text")+" 1"), icon, parede1, (Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall.text")+" 1"));
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        JComponent parede2 = (JComponent) makeTextPanel("Parede #2");
        tabbedPane.addTab((Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall.text")+" 2"), icon, parede2, (Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall.text")+" 2"));
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JComponent parede3 = (JComponent) makeTextPanel("Parede #3");
        tabbedPane.addTab((Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall.text")+" 3"), icon, parede3, (Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall.text")+" 3"));
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        JComponent parede4 = (JComponent) makeTextPanel("Parede #4");
        parede4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab((Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall.text")+" 4"), icon, parede4, (Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall.text")+" 4"));
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

        JComponent chao = (JComponent) makeTextPanel("Chão #5");
        tabbedPane.addTab(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.floor.text"), icon, chao, Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.floor.text"));
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);

        JComponent teto = (JComponent) makeTextPanel("Teto #6");
        tabbedPane.addTab(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.ceiling.text"), icon, teto, Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.ceiling.text"));
        tabbedPane.setMnemonicAt(5, KeyEvent.VK_6);

        //panelRight.add(tabbedPane, BorderLayout.NORTH);

        //Espaço reservado para Parede 1
        parede1.setLayout(new GridLayout(7, 3, 10, 10));
        parede2.setLayout(new GridLayout(7, 3, 10, 10));
        parede3.setLayout(new GridLayout(7, 3, 10, 10));
        parede4.setLayout(new GridLayout(7, 3, 10, 10));
        chao.setLayout(new GridLayout(7, 3, 10, 10));
        teto.setLayout(new GridLayout(7, 3, 10, 10));

        
        //camada/janela/porta
        lb_tipo1 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.type.text"));
        lb_tipo2 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.type.text"));
        lb_tipo3 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.type.text"));
        lb_tipo4 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.type.text"));
        lb_tipo5 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.type.text"));
        lb_tipo6 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.type.text"));
        String[] tipoArray1 = {Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.layer.text"), Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.window.text"), Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.door.text")};
        String[] tipoArray2 = {Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.layer.text"), Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.window.text"), Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.door.text")};
        String[] tipoArray3 = {Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.layer.text"), Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.window.text"), Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.door.text")};
        String[] tipoArray4 = {Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.layer.text"), Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.window.text"), Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.door.text")};
        String[] tipoArray5 = {Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.layer.text")};
        String[] tipoArray6 = {Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.layer.text")};
        tipo1 = new JComboBox(tipoArray1);
        tipo2 = new JComboBox(tipoArray2);
        tipo3 = new JComboBox(tipoArray3);
        tipo4 = new JComboBox(tipoArray4);
        tipo5 = new JComboBox(tipoArray5);
        tipo6 = new JComboBox(tipoArray6);
        lb_espaco10 = new JLabel(""); lb_espaco20 = new JLabel(""); lb_espaco30 = new JLabel(""); lb_espaco40 = new JLabel(""); lb_espaco50 = new JLabel(""); lb_espaco60 = new JLabel("");
        
        lb_altura1 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.height.text"));
        lb_altura2 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.height.text"));
        lb_altura3 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.height.text"));
        lb_altura4 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.height.text"));
        lb_altura5 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.height.text"));
        lb_altura6 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.height.text"));
        altura1 = new JTextField(5);
        altura2 = new JTextField(5);
        altura3 = new JTextField(5);
        altura4 = new JTextField(5);
        altura5 = new JTextField(5);
        altura6 = new JTextField(5);
        lb_metrosaltura1 = new JLabel("m");
        lb_metrosaltura2 = new JLabel("m");
        lb_metrosaltura3 = new JLabel("m");
        lb_metrosaltura4 = new JLabel("m");
        lb_metrosaltura5 = new JLabel("m");
        lb_metrosaltura6 = new JLabel("m");

        lb_largura1 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.width.text"));
        lb_largura2 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.width.text"));
        lb_largura3 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.width.text"));
        lb_largura4 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.width.text"));
        lb_largura5 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.width.text"));
        lb_largura6 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.width.text"));
        largura1 = new JTextField(5);
        largura2 = new JTextField(5);
        largura3 = new JTextField(5);
        largura4 = new JTextField(5);
        largura5 = new JTextField(5);
        largura6 = new JTextField(5);        
        lb_metroslargura1 = new JLabel("m");
        lb_metroslargura2 = new JLabel("m");
        lb_metroslargura3 = new JLabel("m");
        lb_metroslargura4 = new JLabel("m");
        lb_metroslargura5 = new JLabel("m");
        lb_metroslargura6 = new JLabel("m");
        
        lb_material1 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.material.text"));
        lb_material2 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.material.text"));
        lb_material3 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.material.text"));
        lb_material4 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.material.text"));
        lb_material5 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.material.text"));
        lb_material6 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.material.text"));
        Object[] materiaisArray1 = Materiais.getInstance().getListaDeMateriais();
        Object[] materiaisArray2 = Materiais.getInstance().getListaDeMateriais();
        Object[] materiaisArray3 = Materiais.getInstance().getListaDeMateriais();
        Object[] materiaisArray4 = Materiais.getInstance().getListaDeMateriais();
        Object[] materiaisArray5 = Materiais.getInstance().getListaDeMateriais();
        Object[] materiaisArray6 = Materiais.getInstance().getListaDeMateriais();
        material1 = new JComboBox(materiaisArray1);
        material2 = new JComboBox(materiaisArray1);
        material3 = new JComboBox(materiaisArray1);
        material4 = new JComboBox(materiaisArray1);
        material5 = new JComboBox(materiaisArray1);
        material6 = new JComboBox(materiaisArray1);
        lb_espaco11 = new JLabel(""); lb_espaco21 = new JLabel(""); lb_espaco31 = new JLabel(""); lb_espaco41 = new JLabel(""); lb_espaco51 = new JLabel(""); lb_espaco61 = new JLabel("");

        lb_espessura1 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.thickness.text"));
        lb_espessura2 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.thickness.text"));
        lb_espessura3 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.thickness.text"));
        lb_espessura4 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.thickness.text"));
        lb_espessura5 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.thickness.text"));
        lb_espessura6 = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.thickness.text"));
        espessura1 = new JTextField(5);
        espessura2 = new JTextField(5);
        espessura3 = new JTextField(5);
        espessura4 = new JTextField(5);
        espessura5 = new JTextField(5);
        espessura6 = new JTextField(5);
        lb_metrosespessura1 = new JLabel("m");
        lb_metrosespessura2 = new JLabel("m");
        lb_metrosespessura3 = new JLabel("m");
        lb_metrosespessura4 = new JLabel("m");
        lb_metrosespessura5 = new JLabel("m");
        lb_metrosespessura6 = new JLabel("m");

        lb_espaco12 = new JLabel(""); lb_espaco22 = new JLabel(""); lb_espaco32 = new JLabel(""); lb_espaco42 = new JLabel(""); lb_espaco52 = new JLabel(""); lb_espaco62 = new JLabel("");
        lb_espaco13 = new JLabel(""); lb_espaco23 = new JLabel(""); lb_espaco33 = new JLabel(""); lb_espaco43 = new JLabel(""); lb_espaco53 = new JLabel(""); lb_espaco63 = new JLabel("");
        lb_espaco14 = new JLabel(""); lb_espaco24 = new JLabel(""); lb_espaco34 = new JLabel(""); lb_espaco44 = new JLabel(""); lb_espaco54 = new JLabel(""); lb_espaco64 = new JLabel("");
        
        lb_espaco15 = new JLabel(""); lb_espaco25 = new JLabel(""); lb_espaco35 = new JLabel(""); lb_espaco45 = new JLabel(""); lb_espaco55 = new JLabel(""); lb_espaco65 = new JLabel("");
        buttonadd1 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.addcomp.text"));
        buttonadd2 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.addcomp.text"));
        buttonadd3 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.addcomp.text"));
        buttonadd4 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.addcomp.text"));
        buttonadd5 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.addcomp.text"));
        buttonadd6 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.addcomp.text"));
        buttonadd1.addActionListener(new ActionListener() {
            int nComponentesParede1 = 0;

            @Override
            public void actionPerformed(ActionEvent e) {  
                int indice=tipo1.getSelectedIndex();
                String cmpnente = tipo1.getSelectedItem().toString().toUpperCase();
                CriarComponenteControlador ccc = new CriarComponenteControlador();
                switch (indice) {
                    case 2: //Porta = 2
                        if (altura1.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da porta.");
                        }
                        if (largura1.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da porta.");
                        }
                        if (espessura1.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da porta.");
                        }
                        if (Float.parseFloat(altura1.getText()) > Float.parseFloat(altura1.getText())) {
                            JOptionPane.showMessageDialog(null, "A altura da porta não pode ser superior à altura da parede.\nInsira uma nova altura para a porta.");
                        }
                        if (Float.parseFloat(largura1.getText()) > Float.parseFloat(largura1.getText())) {
                            JOptionPane.showMessageDialog(null, "A largura da porta não pode ser superior à largura da parede.\nInsira uma nova largura para a porta.");
                        }

                        componentes1.add(nComponentesParede1, ccc.criarComponente(cmpnente, altura1.getText(), largura1.getText(), espessura1.getText(), material1.getSelectedItem().toString()));
                        listaComponentes1.setVisible(true);
                        listaComponentes1.revalidate();
                        listaComponentes1.repaint();
                        nComponentesParede1++;
                        break;

                    case 1: //Janela = 1
                        if (altura1.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da janela.");
                        }
                        if (largura1.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da janela.");
                        }
                        if (espessura1.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da janela.");
                        }
                        if (Float.parseFloat(altura1.getText()) > Float.parseFloat(altura1.getText())) {
                            JOptionPane.showMessageDialog(null, "A altura da janela não pode ser superior à altura da parede.\nInsira uma nova altura para a janela.");
                        }
                        if (Float.parseFloat(largura1.getText()) > Float.parseFloat(largura1.getText())) {
                            JOptionPane.showMessageDialog(null, "A largura da janela não pode ser superior à largura da parede.\nInsira uma nova largura para a janela.");
                        }

                        componentes1.add(nComponentesParede1, ccc.criarComponente(cmpnente, altura1.getText(), largura1.getText(), espessura1.getText(), material1.getSelectedItem().toString()));
                        listaComponentes1.setVisible(true);
                        listaComponentes1.revalidate();
                        listaComponentes1.repaint();
                        nComponentesParede1++;
                        break;
                        
                    case 0: //Camada = 0
                        if (altura1.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da camada.");
                        }
                        if (largura1.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da camada.");
                        }
                        if (espessura1.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da camada.");
                        }
                        if (Float.parseFloat(altura1.getText()) > Float.parseFloat(altura1.getText())) {
                            JOptionPane.showMessageDialog(null, "A altura da porta não pode ser superior à altura da parede.\nInsira uma nova altura para a camada.");
                        }
                        if (Float.parseFloat(largura1.getText()) > Float.parseFloat(largura1.getText())) {
                            JOptionPane.showMessageDialog(null, "A largura da porta não pode ser superior à largura da parede.\nInsira uma nova largura para a camada.");
                        }

                        componentes1.add(nComponentesParede1, ccc.criarComponente(cmpnente, altura1.getText(), largura1.getText(), espessura1.getText(), material1.getSelectedItem().toString()));
                        listaComponentes1.setVisible(true);
                        listaComponentes1.revalidate();
                        listaComponentes1.repaint();
                        nComponentesParede1++;
                        break;
                }
            }
        });
        buttonadd2.addActionListener(new ActionListener() {
            int nComponentesParede2 = 0;

            @Override
            public void actionPerformed(ActionEvent e) {  
                int indice=tipo2.getSelectedIndex();
                String cmpnente = tipo2.getSelectedItem().toString().toUpperCase();
                CriarComponenteControlador ccc = new CriarComponenteControlador();
                switch (indice) {
                    case 2: //Porta = 2
                        if (altura2.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da porta.");
                        }
                        if (largura2.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da porta.");
                        }
                        if (espessura2.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da porta.");
                        }
                        if (Float.parseFloat(altura2.getText()) > Float.parseFloat(altura2.getText())) {
                            JOptionPane.showMessageDialog(null, "A altura da porta não pode ser superior à altura da parede.\nInsira uma nova altura para a porta.");
                        }
                        if (Float.parseFloat(largura2.getText()) > Float.parseFloat(largura2.getText())) {
                            JOptionPane.showMessageDialog(null, "A largura da porta não pode ser superior à largura da parede.\nInsira uma nova largura para a porta.");
                        }

                        componentes2.add(nComponentesParede2, ccc.criarComponente(cmpnente, altura2.getText(), largura2.getText(), espessura2.getText(), material2.getSelectedItem().toString()));
                        listaComponentes2.setVisible(true);
                        listaComponentes2.revalidate();
                        listaComponentes2.repaint();
                        nComponentesParede2++;
                        break;

                    case 1: //Janela = 1
                        if (altura2.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da janela.");
                        }
                        if (largura2.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da janela.");
                        }
                        if (espessura2.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da janela.");
                        }
                        if (Float.parseFloat(altura2.getText()) > Float.parseFloat(altura2.getText())) {
                            JOptionPane.showMessageDialog(null, "A altura da janela não pode ser superior à altura da parede.\nInsira uma nova altura para a janela.");
                        }
                        if (Float.parseFloat(largura2.getText()) > Float.parseFloat(largura2.getText())) {
                            JOptionPane.showMessageDialog(null, "A largura da janela não pode ser superior à largura da parede.\nInsira uma nova largura para a janela.");
                        }

                        componentes2.add(nComponentesParede2, ccc.criarComponente(cmpnente, altura2.getText(), largura2.getText(), espessura2.getText(), material2.getSelectedItem().toString()));
                        listaComponentes2.setVisible(true);
                        listaComponentes2.revalidate();
                        listaComponentes2.repaint();
                        nComponentesParede2++;
                        break;
                        
                    case 0: //Camada = 0
                        if (altura2.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da camada.");
                        }
                        if (largura2.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da camada.");
                        }
                        if (espessura2.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da camada.");
                        }
                        if (Float.parseFloat(altura2.getText()) > Float.parseFloat(altura2.getText())) {
                            JOptionPane.showMessageDialog(null, "A altura da porta não pode ser superior à altura da parede.\nInsira uma nova altura para a camada.");
                        }
                        if (Float.parseFloat(largura2.getText()) > Float.parseFloat(largura2.getText())) {
                            JOptionPane.showMessageDialog(null, "A largura da porta não pode ser superior à largura da parede.\nInsira uma nova largura para a camada.");
                        }

                        componentes2.add(nComponentesParede2, ccc.criarComponente(cmpnente, altura2.getText(), largura2.getText(), espessura2.getText(), material2.getSelectedItem().toString()));
                        listaComponentes2.setVisible(true);
                        listaComponentes2.revalidate();
                        listaComponentes2.repaint();
                        nComponentesParede2++;
                        break;
                }
            }
        });
        buttonadd3.addActionListener(new ActionListener() {
            int nComponentesParede3 = 0;

            @Override
            public void actionPerformed(ActionEvent e) {  
                int indice=tipo3.getSelectedIndex();
                String cmpnente = tipo3.getSelectedItem().toString().toUpperCase();
                CriarComponenteControlador ccc = new CriarComponenteControlador();
                switch (indice) {
                    case 2: //Porta = 2
                        if (altura3.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da porta.");
                        }
                        if (largura3.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da porta.");
                        }
                        if (espessura3.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da porta.");
                        }
                        if (Float.parseFloat(altura3.getText()) > Float.parseFloat(altura3.getText())) {
                            JOptionPane.showMessageDialog(null, "A altura da porta não pode ser superior à altura da parede.\nInsira uma nova altura para a porta.");
                        }
                        if (Float.parseFloat(largura3.getText()) > Float.parseFloat(largura3.getText())) {
                            JOptionPane.showMessageDialog(null, "A largura da porta não pode ser superior à largura da parede.\nInsira uma nova largura para a porta.");
                        }

                        componentes3.add(nComponentesParede3, ccc.criarComponente(cmpnente, altura3.getText(), largura3.getText(), espessura3.getText(), material3.getSelectedItem().toString()));
                        listaComponentes3.setVisible(true);
                        listaComponentes3.revalidate();
                        listaComponentes3.repaint();
                        nComponentesParede3++;
                        break;

                    case 1: //Janela = 1
                        if (altura3.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da janela.");
                        }
                        if (largura3.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da janela.");
                        }
                        if (espessura3.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da janela.");
                        }
                        if (Float.parseFloat(altura3.getText()) > Float.parseFloat(altura3.getText())) {
                            JOptionPane.showMessageDialog(null, "A altura da janela não pode ser superior à altura da parede.\nInsira uma nova altura para a janela.");
                        }
                        if (Float.parseFloat(largura3.getText()) > Float.parseFloat(largura3.getText())) {
                            JOptionPane.showMessageDialog(null, "A largura da janela não pode ser superior à largura da parede.\nInsira uma nova largura para a janela.");
                        }

                        componentes3.add(nComponentesParede3, ccc.criarComponente(cmpnente, altura3.getText(), largura3.getText(), espessura3.getText(), material3.getSelectedItem().toString()));
                        listaComponentes3.setVisible(true);
                        listaComponentes3.revalidate();
                        listaComponentes3.repaint();
                        nComponentesParede3++;
                        break;
                        
                    case 0: //Camada = 0
                        if (altura3.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da camada.");
                        }
                        if (largura3.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da camada.");
                        }
                        if (espessura3.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da camada.");
                        }
                        if (Float.parseFloat(altura3.getText()) > Float.parseFloat(altura3.getText())) {
                            JOptionPane.showMessageDialog(null, "A altura da porta não pode ser superior à altura da parede.\nInsira uma nova altura para a camada.");
                        }
                        if (Float.parseFloat(largura3.getText()) > Float.parseFloat(largura3.getText())) {
                            JOptionPane.showMessageDialog(null, "A largura da porta não pode ser superior à largura da parede.\nInsira uma nova largura para a camada.");
                        }

                        componentes3.add(nComponentesParede3, ccc.criarComponente(cmpnente, altura3.getText(), largura3.getText(), espessura3.getText(), material3.getSelectedItem().toString()));
                        listaComponentes3.setVisible(true);
                        listaComponentes3.revalidate();
                        listaComponentes3.repaint();
                        nComponentesParede3++;
                        break;
                }
            }
        });
        buttonadd4.addActionListener(new ActionListener() {
            int nComponentesParede4 = 0;

            @Override
            public void actionPerformed(ActionEvent e) {  
                int indice=tipo4.getSelectedIndex();
                String cmpnente = tipo4.getSelectedItem().toString().toUpperCase();
                CriarComponenteControlador ccc = new CriarComponenteControlador();
                switch (indice) {
                    case 2: //Porta = 2
                        if (altura4.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da porta.");
                        }
                        if (largura4.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da porta.");
                        }
                        if (espessura4.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da porta.");
                        }
                        if (Float.parseFloat(altura4.getText()) > Float.parseFloat(altura4.getText())) {
                            JOptionPane.showMessageDialog(null, "A altura da porta não pode ser superior à altura da parede.\nInsira uma nova altura para a porta.");
                        }
                        if (Float.parseFloat(largura4.getText()) > Float.parseFloat(largura4.getText())) {
                            JOptionPane.showMessageDialog(null, "A largura da porta não pode ser superior à largura da parede.\nInsira uma nova largura para a porta.");
                        }

                        componentes4.add(nComponentesParede4, ccc.criarComponente(cmpnente, altura4.getText(), largura4.getText(), espessura4.getText(), material4.getSelectedItem().toString()));
                        listaComponentes4.setVisible(true);
                        listaComponentes4.revalidate();
                        listaComponentes4.repaint();
                        nComponentesParede4++;
                        break;

                    case 1: //Janela = 1
                        if (altura4.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da janela.");
                        }
                        if (largura4.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da janela.");
                        }
                        if (espessura4.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da janela.");
                        }
                        if (Float.parseFloat(altura4.getText()) > Float.parseFloat(altura4.getText())) {
                            JOptionPane.showMessageDialog(null, "A altura da janela não pode ser superior à altura da parede.\nInsira uma nova altura para a janela.");
                        }
                        if (Float.parseFloat(largura4.getText()) > Float.parseFloat(largura4.getText())) {
                            JOptionPane.showMessageDialog(null, "A largura da janela não pode ser superior à largura da parede.\nInsira uma nova largura para a janela.");
                        }

                        componentes4.add(nComponentesParede4, ccc.criarComponente(cmpnente, altura4.getText(), largura4.getText(), espessura4.getText(), material4.getSelectedItem().toString()));
                        listaComponentes4.setVisible(true);
                        listaComponentes4.revalidate();
                        listaComponentes4.repaint();
                        nComponentesParede4++;
                        break;
                        
                    case 0: //Camada = 0
                        if (altura4.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da camada.");
                        }
                        if (largura4.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da camada.");
                        }
                        if (espessura4.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da camada.");
                        }
                        if (Float.parseFloat(altura4.getText()) > Float.parseFloat(altura4.getText())) {
                            JOptionPane.showMessageDialog(null, "A altura da porta não pode ser superior à altura da parede.\nInsira uma nova altura para a camada.");
                        }
                        if (Float.parseFloat(largura4.getText()) > Float.parseFloat(largura4.getText())) {
                            JOptionPane.showMessageDialog(null, "A largura da porta não pode ser superior à largura da parede.\nInsira uma nova largura para a camada.");
                        }

                        componentes4.add(nComponentesParede4, ccc.criarComponente(cmpnente, altura4.getText(), largura4.getText(), espessura4.getText(), material4.getSelectedItem().toString()));
                        listaComponentes4.setVisible(true);
                        listaComponentes4.revalidate();
                        listaComponentes4.repaint();
                        nComponentesParede4++;
                        break;
                }
            }
        });
        buttonadd5.addActionListener(new ActionListener() {
            int nComponentesParede5 = 0;

            @Override
            public void actionPerformed(ActionEvent e) {  
                String cmpnente = tipo5.getSelectedItem().toString().toUpperCase();
                CriarComponenteControlador ccc = new CriarComponenteControlador();
                
                        if (altura5.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da porta.");
                        }
                        if (largura5.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da porta.");
                        }
                        if (espessura5.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da porta.");
                        }
                        if (Float.parseFloat(altura5.getText()) > Float.parseFloat(altura5.getText())) {
                            JOptionPane.showMessageDialog(null, "A altura da porta não pode ser superior à altura da parede.\nInsira uma nova altura para a porta.");
                        }
                        if (Float.parseFloat(largura5.getText()) > Float.parseFloat(largura5.getText())) {
                            JOptionPane.showMessageDialog(null, "A largura da porta não pode ser superior à largura da parede.\nInsira uma nova largura para a porta.");
                        }

                        componentes5.add(nComponentesParede5, ccc.criarComponente(cmpnente, altura5.getText(), largura5.getText(), espessura5.getText(), material5.getSelectedItem().toString()));
                        listaComponentes5.setVisible(true);
                        listaComponentes5.revalidate();
                        listaComponentes5.repaint();
                        nComponentesParede5++;
            }
        });
        buttonadd6.addActionListener(new ActionListener() {
            int nComponentesParede6 = 0;

            @Override
            public void actionPerformed(ActionEvent e) {  
                String cmpnente = tipo6.getSelectedItem().toString().toUpperCase();
                CriarComponenteControlador ccc = new CriarComponenteControlador();
                        if (altura6.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da porta.");
                        }
                        if (largura6.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da porta.");
                        }
                        if (espessura6.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da porta.");
                        }
                        if (Float.parseFloat(altura6.getText()) > Float.parseFloat(altura6.getText())) {
                            JOptionPane.showMessageDialog(null, "A altura da porta não pode ser superior à altura da parede.\nInsira uma nova altura para a porta.");
                        }
                        if (Float.parseFloat(largura6.getText()) > Float.parseFloat(largura6.getText())) {
                            JOptionPane.showMessageDialog(null, "A largura da porta não pode ser superior à largura da parede.\nInsira uma nova largura para a porta.");
                        }

                        componentes6.add(nComponentesParede6, ccc.criarComponente(cmpnente, altura6.getText(), largura6.getText(), espessura6.getText(), material6.getSelectedItem().toString()));
                        listaComponentes6.setVisible(true);
                        listaComponentes6.revalidate();
                        listaComponentes6.repaint();
                        nComponentesParede6++;                        
            }
        });
        
        //adicionar objetos da camada à parede 1
        parede1.add(lb_tipo1);      parede1.add(tipo1);         parede1.add(lb_espaco10);
        parede1.add(lb_altura1);    parede1.add(altura1);       parede1.add(lb_metrosaltura1);
        parede1.add(lb_largura1);   parede1.add(largura1);      parede1.add(lb_metroslargura1);
        parede1.add(lb_material1);  parede1.add(material1);     parede1.add(lb_espaco11);
        parede1.add(lb_espessura1); parede1.add(espessura1);    parede1.add(lb_metrosespessura1);
        parede1.add(lb_espaco12);   parede1.add(lb_espaco13);   parede1.add(buttonadd1);
        
        //adicionar objetos da camada à parede 2
        parede2.add(lb_tipo2);      parede2.add(tipo2);         parede2.add(lb_espaco20);
        parede2.add(lb_altura2);    parede2.add(altura2);       parede2.add(lb_metrosaltura2);
        parede2.add(lb_largura2);   parede2.add(largura2);      parede2.add(lb_metroslargura2);
        parede2.add(lb_material2);  parede2.add(material2);     parede2.add(lb_espaco21);
        parede2.add(lb_espessura2); parede2.add(espessura2);    parede2.add(lb_metrosespessura2);
        parede2.add(lb_espaco22);   parede2.add(lb_espaco23);   parede2.add(buttonadd2);
        
        //adicionar objetos da camada à parede 3
        parede3.add(lb_tipo3);      parede3.add(tipo3);         parede3.add(lb_espaco30);
        parede3.add(lb_altura3);    parede3.add(altura3);       parede3.add(lb_metrosaltura3);
        parede3.add(lb_largura3);   parede3.add(largura3);      parede3.add(lb_metroslargura3);
        parede3.add(lb_material3);  parede3.add(material3);     parede3.add(lb_espaco31);
        parede3.add(lb_espessura3); parede3.add(espessura3);    parede3.add(lb_metrosespessura3);
        parede3.add(lb_espaco32);   parede3.add(lb_espaco33);   parede3.add(buttonadd3);
        
        //adicionar objetos da camada à parede 4
        parede4.add(lb_tipo4);      parede4.add(tipo4);         parede4.add(lb_espaco40);
        parede4.add(lb_altura4);    parede4.add(altura4);       parede4.add(lb_metrosaltura4);
        parede4.add(lb_largura4);   parede4.add(largura4);      parede4.add(lb_metroslargura4);
        parede4.add(lb_material4);  parede4.add(material4);     parede4.add(lb_espaco41);
        parede4.add(lb_espessura4); parede4.add(espessura4);    parede4.add(lb_metrosespessura4);
        parede4.add(lb_espaco42);   parede4.add(lb_espaco43);   parede4.add(buttonadd4);
        
        //adicionar objetos da camada ao chão
        chao.add(lb_tipo5);      chao.add(tipo5);         chao.add(lb_espaco50);
        chao.add(lb_altura5);    chao.add(altura5);       chao.add(lb_metrosaltura5);
        chao.add(lb_largura5);   chao.add(largura5);      chao.add(lb_metroslargura5);
        chao.add(lb_material5);  chao.add(material5);     chao.add(lb_espaco51);
        chao.add(lb_espessura5); chao.add(espessura5);    chao.add(lb_metrosespessura5);
        chao.add(lb_espaco52);   chao.add(lb_espaco53);   chao.add(buttonadd5);
        
        //adicionar objetos da camada ao teto
        teto.add(lb_tipo6);      teto.add(tipo6);         teto.add(lb_espaco60);
        teto.add(lb_altura6);    teto.add(altura6);       teto.add(lb_metrosaltura6);
        teto.add(lb_largura6);   teto.add(largura6);      teto.add(lb_metroslargura6);
        teto.add(lb_material6);  teto.add(material6);     teto.add(lb_espaco61);
        teto.add(lb_espessura6); teto.add(espessura6);    teto.add(lb_metrosespessura6);
        teto.add(lb_espaco62);   teto.add(lb_espaco63);   teto.add(buttonadd6);



        //Painel principal dividido em 2 - (Centro e Este)
        contentPane.add(panelLeft,
                BorderLayout.CENTER);
        contentPane.add(panelRight,
                BorderLayout.EAST);

               
        
        
        
        
        JPanel panelGlobalInferior = new JPanel();
        panelGlobalInferior.setLayout(new GridLayout(3, 2));
        
        
      
        
       //Painel 1
        JPanel panelcenter1 = new JPanel();
        GridLayout pc1 = new GridLayout(2, 1);
        panelcenter1.setLayout(pc1);
        
        JPanel panellist1 = new JPanel();
        GridLayout pl1 = new GridLayout(2, 1);
        panellist1.setLayout(pl1);
        
        button_remove1 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.removecomp.text"));
        button_remove1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
            
        panellist1.add(listaComponentes1);
        panellist1.add(button_remove1);
        
        JPanel panelvalidar1 = new JPanel();
        GridLayout pv1 = new GridLayout(2, 1);
        panellist1.setLayout(pv1);
        
        tipo1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(tipo1.getSelectedItem().toString().equalsIgnoreCase("camada")) {
                    largura1.setText(larguraCasa.getText());
                    largura1.setEnabled(false);
                    altura1.setText(alturaCasa.getText()+"");
                    altura1.setEnabled(false);
                } else {
                    largura1.setEnabled(true);
                    altura1.setEnabled(true);
                }
            }
        });
        
        details1 = new JTextField(20);
        buttonvalidarparede1 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.validatewall.text")+" 1");
        buttonvalidarparede1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CriarParedeControlador ccp = new CriarParedeControlador();
                ccp.criarParede(comprimentoCasa.getText(), alturaCasa.getText(), componentes1, 0);
                rt_parede1.setText(Float.toString(Casa.getResistenciaTotalParede(0)));
            }
        });
        
        panelvalidar1.add(details1);
        panelvalidar1.add(buttonvalidarparede1);

        panelcenter1.add(panellist1);
        panelcenter1.add(panelvalidar1);        
        
        
        
                
        //Painel 2
        JPanel panelcenter2 = new JPanel();
        GridLayout pc2 = new GridLayout(2, 1);
        panelcenter2.setLayout(pc2);
        
        JPanel panellist2 = new JPanel();
        GridLayout pl2 = new GridLayout(2, 1);
        panellist2.setLayout(pl2);
        
        button_remove2 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.removecomp.text"));
        button_remove2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
            
        panellist2.add(listaComponentes2);
        panellist2.add(button_remove2);
        
        JPanel panelvalidar2 = new JPanel();
        GridLayout pv2 = new GridLayout(2, 1);
        panellist2.setLayout(pv2);
        
        tipo2.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(tipo2.getSelectedItem().toString().equalsIgnoreCase("camada")) {
                    largura2.setText(larguraCasa.getText());
                    largura2.setEnabled(false);
                    altura2.setText(alturaCasa.getText()+"");
                    altura2.setEnabled(false);
                } else {
                    largura2.setEnabled(true);
                    altura2.setEnabled(true);
                }
            }
        });
        
        details2 = new JTextField(20);
        buttonvalidarparede2 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.validatewall.text")+" 2");
        buttonvalidarparede2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CriarParedeControlador ccp = new CriarParedeControlador();
                ccp.criarParede(comprimentoCasa.getText(), alturaCasa.getText(), componentes2, 0);
                rt_parede2.setText(Float.toString(Casa.getResistenciaTotalParede(0)));
            }
        });
        
        panelvalidar2.add(details2);
        panelvalidar2.add(buttonvalidarparede2);

        panelcenter2.add(panellist2);
        panelcenter2.add(panelvalidar2);

        
        
        
        
        //Painel 3
        JPanel panelcenter3 = new JPanel();
        GridLayout pc3 = new GridLayout(2, 1);
        panelcenter3.setLayout(pc3);
                
        JPanel panellist3 = new JPanel();
        GridLayout pl3 = new GridLayout(2, 1);
        panellist1.setLayout(pl3);
        
        button_remove3 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.removecomp.text"));
        button_remove3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
            
        panellist3.add(listaComponentes3);
        panellist3.add(button_remove3);
        
        JPanel panelvalidar3 = new JPanel();
        GridLayout pv3 = new GridLayout(2, 1);
        panellist3.setLayout(pv3);
        
        tipo3.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(tipo3.getSelectedItem().toString().equalsIgnoreCase("camada")) {
                    largura3.setText(larguraCasa.getText());
                    largura3.setEnabled(false);
                    altura3.setText(alturaCasa.getText()+"");
                    altura3.setEnabled(false);
                } else {
                    largura1.setEnabled(true);
                    altura1.setEnabled(true);
                }
            }
        });
        
        details3 = new JTextField(20);
        buttonvalidarparede3 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.validatewall.text")+" 3");
        buttonvalidarparede3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CriarParedeControlador ccp = new CriarParedeControlador();
                ccp.criarParede(comprimentoCasa.getText(), alturaCasa.getText(), componentes3, 0);
                rt_parede3.setText(Float.toString(Casa.getResistenciaTotalParede(0)));
            }
        });
        
        panelvalidar3.add(details3);
        panelvalidar3.add(buttonvalidarparede3);

        panelcenter3.add(panellist3);
        panelcenter3.add(panelvalidar3);
        
        
        
        
        
        
        //Painel 4
        JPanel panelcenter4 = new JPanel();
        GridLayout pc4 = new GridLayout(2, 1);
        panelcenter4.setLayout(pc4);
                
        JPanel panellist4 = new JPanel();
        GridLayout pl4 = new GridLayout(2, 1);
        panellist4.setLayout(pl4);
        
        button_remove4 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.removecomp.text"));
        button_remove4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
            
        panellist4.add(listaComponentes4);
        panellist4.add(button_remove4);
        
        JPanel panelvalidar4 = new JPanel();
        GridLayout pv4 = new GridLayout(2, 1);
        panellist4.setLayout(pv4);
        
        tipo4.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(tipo4.getSelectedItem().toString().equalsIgnoreCase("camada")) {
                    largura4.setText(larguraCasa.getText());
                    largura4.setEnabled(false);
                    altura4.setText(alturaCasa.getText()+"");
                    altura4.setEnabled(false);
                } else {
                    largura4.setEnabled(true);
                    altura4.setEnabled(true);
                }
            }
        });
        
        details4 = new JTextField(20);
        buttonvalidarparede4 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.validatewall.text")+" 4");
        buttonvalidarparede4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CriarParedeControlador ccp = new CriarParedeControlador();
                ccp.criarParede(comprimentoCasa.getText(), alturaCasa.getText(), componentes4, 0);
                rt_parede4.setText(Float.toString(Casa.getResistenciaTotalParede(0)));
            }
        });
        
        panelvalidar4.add(details4);
        panelvalidar4.add(buttonvalidarparede4);

        panelcenter4.add(panellist4);
        panelcenter4.add(panelvalidar4);
        
        
        
        
        
        
        //Painel 5
        JPanel panelcenter5 = new JPanel();
        GridLayout pc5 = new GridLayout(2, 1);
        panelcenter5.setLayout(pc1);
                
        JPanel panellist5 = new JPanel();
        GridLayout pl5 = new GridLayout(2, 1);
        panellist5.setLayout(pl5);
        
        button_remove5 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.removecomp.text"));
        button_remove5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
            
        panellist5.add(listaComponentes1);
        panellist5.add(button_remove1);
        
        JPanel panelvalidar5 = new JPanel();
        GridLayout pv5 = new GridLayout(2, 1);
        panellist5.setLayout(pv1);
        
        tipo5.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(tipo5.getSelectedItem().toString().equalsIgnoreCase("camada")) {
                    largura5.setText(larguraCasa.getText());
                    largura5.setEnabled(false);
                    altura5.setText(alturaCasa.getText()+"");
                    altura5.setEnabled(false);
                } else {
                    largura5.setEnabled(true);
                    altura5.setEnabled(true);
                }
            }
        });
        
        details5 = new JTextField(20);
        buttonvalidarparede5 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.validatefloor.text"));
        buttonvalidarparede5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CriarParedeControlador ccp = new CriarParedeControlador();
                ccp.criarParede(comprimentoCasa.getText(), alturaCasa.getText(), componentes5, 0);
                rt_chao.setText(Float.toString(Casa.getResistenciaTotalParede(0)));
            }
        });
        
        panelvalidar5.add(details5);
        panelvalidar5.add(buttonvalidarparede5);

        panelcenter5.add(panellist5);
        panelcenter5.add(panelvalidar5);
        
        
        
        
        
        
        
        //Painel 6
        JPanel panelcenter6 = new JPanel();
        GridLayout pc6 = new GridLayout(2, 1);
        panelcenter6.setLayout(pc1);
                
        JPanel panellist6 = new JPanel();
        GridLayout pl6 = new GridLayout(2, 1);
        panellist6.setLayout(pl1);
        
        button_remove6 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.removecomp.text"));
        button_remove6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
            
        panellist6.add(listaComponentes6);
        panellist6.add(button_remove6);
        
        JPanel panelvalidar6 = new JPanel();
        GridLayout pv6 = new GridLayout(2, 1);
        panellist6.setLayout(pv6);
        
        tipo1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(tipo6.getSelectedItem().toString().equalsIgnoreCase("camada")) {
                    largura6.setText(larguraCasa.getText());
                    largura6.setEnabled(false);
                    altura6.setText(alturaCasa.getText()+"");
                    altura6.setEnabled(false);
                } else {
                    largura6.setEnabled(true);
                    altura6.setEnabled(true);
                }
            }
        });
        
        details6 = new JTextField(20);
        buttonvalidarparede6 = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.validateceiling.text"));
        buttonvalidarparede6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CriarParedeControlador ccp = new CriarParedeControlador();
                ccp.criarParede(comprimentoCasa.getText(), alturaCasa.getText(), componentes6, 0);
                rt_teto.setText(Float.toString(Casa.getResistenciaTotalParede(0)));
            }
        });
        
        panelvalidar6.add(details6);
        panelvalidar6.add(buttonvalidarparede6);

        panelcenter6.add(panellist6);
        panelcenter6.add(panelvalidar6);
        
        
        
        
        
        
                
        panelGlobalInferior.add(panelcenter1);
        panelGlobalInferior.add(panelcenter2);
        panelGlobalInferior.add(panelcenter3);
        panelGlobalInferior.add(panelcenter4);
        panelGlobalInferior.add(panelcenter5);
        panelGlobalInferior.add(panelcenter6);
        
        
        //panelRight.add(panelGlobalInferior, BorderLayout.CENTER);
        
        
        WallPanel panelParedes = new WallPanel();
        panelRight.add(panelParedes);

        //define o frame
        pack();
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
