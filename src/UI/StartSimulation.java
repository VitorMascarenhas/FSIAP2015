/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Dominio.Componente;
import controlador.CriarComponenteControlador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import Repositorios.Materiais;
/**
 *
 * @author Nuno Lemos
 */
public class StartSimulation extends JInternalFrame {

    private JTextField altura1, largura1, espessura1, details, rt_parede1, rt_parede2, rt_parede3, rt_parede4, rt_chao, rt_teto, rt_total, fluxo,          
            temperaturaExterior, temperaturaInterior, temperaturaSolo, comprimentoCasa, larguraCasa, alturaCasa;
    private JLabel lb_metrosaltura1, lb_metroslargura1, lb_metrosespessura1, lb_espessura1, lb_material1, lb_largura1, lb_altura1, lb_tipo1,         
            lb_espaco1, lb_espaco00, lb_espaco11, lb_espaco12, lb_espaco13, lb_espaco14, lb_espaco15,
            lb_rt_parede1, lb_rt_parede2, lb_rt_parede3, lb_rt_parede4, lb_rt_chao, lb_rt_teto, lb_rt_total, lb_fluxo,
            lb_unid_rt1, lb_unid_rt2, lb_unid_rt3, lb_unid_rt4, lb_unid_rt5, lb_unid_rt6, lb_unid_rt7, lb_unid_rt8,
            lb_temp_ext_unid, lb_temp_int_unid, lb_temp_sol_unid, lb_comprimento_unid, lb_largura_unid, lb_altura_unid,
            lb_temperaturas, lb_dimensoes, lb_temperaturaExterior, lb_temperaturaInterior, lb_temperaturaSolo, lb_comprimentoCasa, lb_larguraCasa, lb_alturaCasa,
            lb_buttondef1, lb_buttondef2, lb_buttondef3, lb_buttondef4, lb_buttondef5, lb_buttondef6, lb_buttondef7, lb_buttondef8, lb_buttondef9, lb_buttondef10, 
            lb_buttondef11, lb_buttondef12, lb_buttondef13, lb_buttondef14,
            lb_componentes1, lb_espacocomp1;
    private JComboBox material1, tipo1;
    private JButton buttonadd1, buttonclean1, buttonnext1, buttondefinir, button_remove1, buttonvalidarparede1;
    private JList<Componente> list1, listaComponentes;

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
        
        
        
        listaComponentes = new JList();
        final DefaultListModel<Componente> componentes = new DefaultListModel<>();
        listaComponentes.setModel(componentes);
        listaComponentes.setPreferredSize(null);
        listaComponentes.setBackground(Color.black);
        
        
                
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
        lb_temperaturaSolo = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.floor1.text"));
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
                //Execute when button is pressed
                Float comprimento = (Float.parseFloat(comprimentoCasa.getText()));
                largura1.setText(comprimento.toString());
                Float altura = (Float.parseFloat(alturaCasa.getText()));
                altura1.setText(altura.toString());
            }
        });

        panelLeftNorth.add(lb_temperaturas);
        panelLeftNorth.add(lb_buttondef1);
        panelLeftNorth.add(lb_buttondef2);
        panelLeftNorth.add(lb_buttondef3);
        panelLeftNorth.add(lb_dimensoes);
        panelLeftNorth.add(lb_buttondef4);
        panelLeftNorth.add(lb_buttondef5);
        
        panelLeftNorth.add(lb_temperaturaExterior);
        panelLeftNorth.add(temperaturaExterior);
        panelLeftNorth.add(lb_temp_ext_unid);
        panelLeftNorth.add(lb_buttondef6);
        panelLeftNorth.add(lb_comprimentoCasa);
        panelLeftNorth.add(comprimentoCasa);
        panelLeftNorth.add(lb_comprimento_unid);
        
        panelLeftNorth.add(lb_temperaturaInterior);
        panelLeftNorth.add(temperaturaInterior);
        panelLeftNorth.add(lb_temp_int_unid);
        panelLeftNorth.add(lb_buttondef7);
        panelLeftNorth.add(lb_larguraCasa);
        panelLeftNorth.add(larguraCasa);
        panelLeftNorth.add(lb_largura_unid);
        
        panelLeftNorth.add(lb_temperaturaSolo);
        panelLeftNorth.add(temperaturaSolo);
        panelLeftNorth.add(lb_temp_sol_unid);
        panelLeftNorth.add(lb_buttondef8);
        panelLeftNorth.add(lb_alturaCasa);
        panelLeftNorth.add(alturaCasa);
        panelLeftNorth.add(lb_altura_unid);
        
        panelLeftNorth.add(lb_buttondef9);
        panelLeftNorth.add(lb_buttondef10);
        panelLeftNorth.add(lb_buttondef11);
        panelLeftNorth.add(lb_buttondef12);
        panelLeftNorth.add(lb_buttondef13);
        panelLeftNorth.add(lb_buttondef14);
        panelLeftNorth.add(buttondefinir);
 

        JPanel panelLeftCenter = new JPanel();
        
        ImageIcon image = new ImageIcon("imgs/resultados.jpg");
        JLabel label = new JLabel("", image, JLabel.CENTER);
        JPanel panelImagem = new JPanel(new BorderLayout());
        panelImagem.add( label, BorderLayout.SOUTH );
        
        
        JPanel panelLeftSouth = new JPanel();
             
        
        //Apresentação de resultados
        
               
        
        JPanel panelResultados = new JPanel();
        panelResultados.setLayout(new GridLayout(8, 3, 10, 10));
        
        lb_rt_parede1 = new JLabel("RT Parede 1");
        rt_parede1 = new JTextField(10);
        rt_parede1.setEnabled(false);
        lb_unid_rt1 = new JLabel("W-1.C");
        
        lb_rt_parede2 = new JLabel("RT Parede 2");
        rt_parede2 = new JTextField(10);
        rt_parede2.setEnabled(false);
        lb_unid_rt2 = new JLabel("W-1.C");

        lb_rt_parede3 = new JLabel("RT Parede 3");
        rt_parede3 = new JTextField(10);
        rt_parede3.setEnabled(false);
        lb_unid_rt3 = new JLabel("W-1.C");

        lb_rt_parede4 = new JLabel("RT Parede 4");
        rt_parede4 = new JTextField(10);
        rt_parede4.setEnabled(false);
        lb_unid_rt4 = new JLabel("W-1.C");

        lb_rt_chao = new JLabel("RT Chão");
        rt_chao = new JTextField(10);
        rt_chao.setEnabled(false);
        lb_unid_rt5 = new JLabel("W-1.C");

        lb_rt_teto = new JLabel("RT Teto");
        rt_teto = new JTextField(10);
        rt_teto.setEnabled(false);
        lb_unid_rt6 = new JLabel("W-1.C");

        lb_rt_total = new JLabel("RT Total");
        rt_total = new JTextField(10);
        rt_total.setEnabled(false);
        lb_unid_rt7 = new JLabel("C/W");

        lb_fluxo = new JLabel("Fluxo de Calor");
        fluxo = new JTextField(10);
        fluxo.setEnabled(false);
        lb_unid_rt8 = new JLabel("W");
        

        panelResultados.add(lb_rt_parede1);
        panelResultados.add(rt_parede1);
        panelResultados.add(lb_unid_rt1);

        panelResultados.add(lb_rt_parede2);
        panelResultados.add(rt_parede2);
        panelResultados.add(lb_unid_rt2);

        panelResultados.add(lb_rt_parede3);
        panelResultados.add(rt_parede3);
        panelResultados.add(lb_unid_rt3);

        panelResultados.add(lb_rt_parede4);
        panelResultados.add(rt_parede4);
        panelResultados.add(lb_unid_rt4);

        panelResultados.add(lb_rt_chao);
        panelResultados.add(rt_chao);
        panelResultados.add(lb_unid_rt5);

        panelResultados.add(lb_rt_teto);
        panelResultados.add(rt_teto);
        panelResultados.add(lb_unid_rt6);

        panelResultados.add(lb_rt_total);
        panelResultados.add(rt_total);
        panelResultados.add(lb_unid_rt7);

        panelResultados.add(lb_fluxo);
        panelResultados.add(fluxo);
        panelResultados.add(lb_unid_rt8);
        
        
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
        parede1.setLayout(new GridLayout(8, 3, 10, 10));

        //camada/janela/porta
        
        lb_tipo1 = new JLabel("Tipo");
        String[] tipoArray = {"Camada", "Janela", "Porta"};
        tipo1 = new JComboBox(tipoArray);
        lb_espaco00 = new JLabel("");
        
        lb_altura1 = new JLabel("Altura");
        altura1 = new JTextField(5);
        lb_metrosaltura1 = new JLabel("m");

        lb_largura1 = new JLabel("Largura");
        largura1 = new JTextField(5);
        lb_metroslargura1 = new JLabel("m");

        lb_material1 = new JLabel("Material");
        String[] materiaisArray = {"", "Tijolo", "Cimento", "Madeira"};
        material1 = new JComboBox(materiaisArray);
        DefaultListModel<String> mdl = new DefaultListModel();
        for(String str : Materiais.getInstance().getNomesMateriais()) {
            int i = 0;
            mdl.add(i, str);
            i++;
        }
        //p_material1.setModel(mdl);
        
        lb_espaco11 = new JLabel("");

        lb_espessura1 = new JLabel("Espessura");
        espessura1 = new JTextField(5);
        lb_metrosespessura1 = new JLabel("m");
        
        lb_espaco12 = new JLabel("");
        list1 = new JList();

        buttonadd1 = new JButton("Adicionar");
        buttonadd1.addActionListener(new ActionListener() {
        int nComponentesParede1 = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tipo1.getSelectedItem().equals("Porta")) {
                    if(Float.parseFloat(altura1.getText()) > Float.parseFloat(altura1.getText())) {
                        JOptionPane.showMessageDialog(null, "A altura da porta não pode ser superior à altura da parede.\nInsira uma nova altura para a porta.");
                    }
                    if(Float.parseFloat(largura1.getText()) > Float.parseFloat(largura1.getText())) {
                        JOptionPane.showMessageDialog(null, "A largura da porta não pode ser superior à largura da parede.\nInsira uma nova largura para a porta.");
                    }
                    CriarComponenteControlador ccc = new CriarComponenteControlador();
                    componentes.add(nComponentesParede1, ccc.criarComponente("Porta", altura1.getText(), largura1.getText(), espessura1.getText(), material1.getSelectedItem().toString()));
                    listaComponentes.repaint();
                    nComponentesParede1++;
                }
            }
        });

        lb_espaco13 = new JLabel("");
        lb_espaco14 = new JLabel("");
        lb_espaco15 = new JLabel("");

        buttonclean1 = new JButton("Limpar");
        buttonnext1 = new JButton("Seguinte");
        lb_espaco1 = new JLabel("");

        //adicionar objetos da camada à parede
        parede1.add(lb_tipo1);
        parede1.add(tipo1);
        parede1.add(lb_espaco00);
        
        parede1.add(lb_altura1);
        parede1.add(altura1);
        parede1.add(lb_metrosaltura1);

        parede1.add(lb_largura1);
        parede1.add(largura1);
        parede1.add(lb_metroslargura1);

        parede1.add(lb_material1);
        parede1.add(material1);
        parede1.add(lb_espaco11);

        parede1.add(lb_espessura1);
        parede1.add(espessura1);
        parede1.add(lb_metrosespessura1);

        parede1.add(lb_espaco12);
        parede1.add(list1);
        parede1.add(buttonadd1);

        parede1.add(lb_espaco13);
        parede1.add(lb_espaco14);
        parede1.add(lb_espaco15);
        
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
        
        
        
        JPanel panelcenter = new JPanel();
        GridLayout pc = new GridLayout(2,1);
        panelcenter.setLayout(pc);
        panelRight.add(panelcenter, BorderLayout.CENTER);
        
        JPanel panellist = new JPanel();
        GridLayout pl = new GridLayout(2,2);
        panellist.setLayout(pl);
        
        lb_componentes1 = new JLabel("Componentes");
        lb_espacocomp1 = new JLabel("");
        
        
        button_remove1 = new JButton("Remover Componente");
              
        
        panellist.add(lb_componentes1);
        panellist.add(lb_espacocomp1);
        panellist.add(listaComponentes);
        panellist.add(button_remove1);
        
        
        
        JPanel panelvalidar = new JPanel();
        GridLayout pv = new GridLayout(2,1);
        panellist.setLayout(pv);
        
        
        details = new JTextField(30);
        buttonvalidarparede1 = new JButton("Validar Parede 1");
        buttonvalidarparede1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed
                
            }
        });
        
        panelvalidar.add(details);
        panelvalidar.add(buttonvalidarparede1);
        

        panelcenter.add(panellist);
        panelcenter.add(panelvalidar);
        
        
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