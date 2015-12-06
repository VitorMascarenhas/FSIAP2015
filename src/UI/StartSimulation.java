/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controlador.ExperienciaController;
import Dominio.*;
import Persistencia.BinaryFile;
import Persistencia.ToHTML;
import controlador.CriarComponenteControlador;
import controlador.CriarParedeControlador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Repositorios.Materiais;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author Nuno Lemos
 */
public class StartSimulation extends JInternalFrame {
    
    
    public static JTextField rt_parede1, rt_parede2, rt_parede3, rt_parede4, rt_chao, rt_teto, rt_total, fluxo, fluxo1, fluxo2, fluxo3, fluxo4, fluxo5, fluxo6,
            temperaturaExterior, temperaturaInterior, temperaturaSolo, comprimentoCasa, larguraCasa, alturaCasa;
    private JLabel lb_rt_parede1, lb_rt_parede2, lb_rt_parede3, lb_rt_parede4, lb_rt_chao, lb_rt_teto, lb_rt_total, lb_fluxo, lb_fluxo1, lb_fluxo2, lb_fluxo3, lb_fluxo4, lb_fluxo5, lb_fluxo6,
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
            buttonvalidarparede1, buttonvalidarparede2, buttonvalidarparede3, buttonvalidarparede4, buttonvalidarparede5, buttonvalidarparede6,buttonSaveBinary ;
    private JList<Componente> listaComponentes1, listaComponentes2, listaComponentes3, listaComponentes4, listaComponentes5, listaComponentes6;
    private  final WallPanel panelWalls;
    private JButton buttondefinir, buttonSaveBinary ;

    public final WallPanel panelWalls;
    
    
    public StartSimulation() {
        super(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.simulation.text"),
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout()); //unnecessary
        
         panelWalls = new WallPanel();
        
        JPanel panelLeft = new JPanel();

        JPanel panelLeftNorth = new JPanel();
        panelLeftNorth.setLayout(new GridLayout(5, 7, 10, 10));
        
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
            ExperienciaController ec = new ExperienciaController();
            
            @Override
            public void actionPerformed(ActionEvent e) {
                /*try {
                    float numero = Float.parseFloat(temperaturaExterior.getText());
                } catch(NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Existem campos com valores inválidos.\nAltere os campos e volte a tentar.");
                }
                try {
                    float numero1 = Float.parseFloat(alturaCasa.getText());
                } catch(NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Existem campos com valores inválidos.\nAltere os campos e volte a tentar.");
                }
                try {
                    float numero2 = Float.parseFloat(larguraCasa.getText());
                } catch(NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Existem campos com valores inválidos.\nAltere os campos e volte a tentar.");
                }
                try {
                    float numero3 = Float.parseFloat(temperaturaInterior.getText());
                } catch(NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Existem campos com valores inválidos.\nAltere os campos e volte a tentar.");
                }
                try {
                    float numero4 = Float.parseFloat(temperaturaSolo.getText());
                } catch(NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Existem campos com valores inválidos.\nAltere os campos e volte a tentar.");
                }
                try {
                    float numero5 = Float.parseFloat(comprimentoCasa.getText());
                } catch(NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Existem campos com valores inválidos.\nAltere os campos e volte a tentar.");
                }*/
                if(comprimentoCasa.getText().isEmpty()
                        || alturaCasa.getText().isEmpty()
                        || larguraCasa.getText().isEmpty()
                        || temperaturaExterior.getText().isEmpty()
                        || temperaturaInterior.getText().isEmpty()
                        || temperaturaSolo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Existem campos por preencher.\nPreencha os campos e volte a tentar.");
                } else {
                    ec.criarExperiencia(temperaturaExterior.getText(), temperaturaInterior.getText(), temperaturaSolo.getText(), alturaCasa.getText(), larguraCasa.getText(), comprimentoCasa.getText());
                    panelWalls.getDim(comprimentoCasa.getText(), larguraCasa.getText(), alturaCasa.getText());
                    buttondefinir.setEnabled(false);
                }
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
        panelResultados.setLayout(new GridLayout(8, 6, 10, 10));
        
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
        
        buttonSaveBinary = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("Project.guardar.text"));
        buttonSaveBinary.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser(new File("c:\\"));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Binary Files", "bin");
                chooser.addChoosableFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false); 
                int result = chooser.showSaveDialog(null);

                //int option = chooser.showSaveDialog(SaveToHTML.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File fi = chooser.getSelectedFile();
                    //chama o controlador para ir boscar o objecto casa
                    System.out.println(fi.getName());
                    try{
                        BinaryFile.writeFile(null, fi);
                    }catch(Exception e2){
                        JOptionPane.showMessageDialog(null, e2.getMessage());
                    }
                }
            }
        });
        
        panelResultados.add(lb_rt_parede1); panelResultados.add(rt_parede1);    panelResultados.add(lb_unid_rt1);   panelResultados.add(lb_fluxo1); panelResultados.add(fluxo1);    panelResultados.add(lb_unid_fluxo1);
        panelResultados.add(lb_rt_parede2); panelResultados.add(rt_parede2);    panelResultados.add(lb_unid_rt2);   panelResultados.add(lb_fluxo2); panelResultados.add(fluxo2);    panelResultados.add(lb_unid_fluxo2);
        panelResultados.add(lb_rt_parede3); panelResultados.add(rt_parede3);    panelResultados.add(lb_unid_rt3);   panelResultados.add(lb_fluxo3); panelResultados.add(fluxo3);    panelResultados.add(lb_unid_fluxo3);
        panelResultados.add(lb_rt_parede4); panelResultados.add(rt_parede4);    panelResultados.add(lb_unid_rt4);   panelResultados.add(lb_fluxo4); panelResultados.add(fluxo4);    panelResultados.add(lb_unid_fluxo4);
        panelResultados.add(lb_rt_chao);    panelResultados.add(rt_chao);   panelResultados.add(lb_unid_rt5);   panelResultados.add(lb_fluxo5); panelResultados.add(fluxo5);    panelResultados.add(lb_unid_fluxo5);
        panelResultados.add(lb_rt_teto);    panelResultados.add(rt_teto);   panelResultados.add(lb_unid_rt6);   panelResultados.add(lb_fluxo6); panelResultados.add(fluxo6);    panelResultados.add(lb_unid_fluxo6);
        panelResultados.add(lb_rt_total);   panelResultados.add(rt_total);  panelResultados.add(lb_unid_rt7);   panelResultados.add(lb_fluxo);  panelResultados.add(fluxo); panelResultados.add(lb_unid_rt8);
        
        panelResultados.add(buttonSaveBinary);
        
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
        
        panelRight.add(panelWalls);
        
        
        //Painel principal dividido em 2 - (Centro e Este)
        contentPane.add(panelLeft,
                BorderLayout.CENTER);
        contentPane.add(panelRight,
                BorderLayout.EAST);
        
        rt_parede1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(Casa.getParede(0) != null) {
                    float resistencia = Casa.getResistenciaTotalParede(0);
                    rt_parede1.setText(resistencia + "");
                }
            }
        });
        
        
        
        //define o frame
        pack();
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension screenMinus50 = new Dimension(screenSize.width - inset*2, screenSize.height - inset*2);
        this.setPreferredSize(screenMinus50);
        this.pack();
        this.setSize(screenMinus50);
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
    
    public void preencheSimulacao(Casa c1){
        temperaturaExterior.setText(c1.getTemperaturaExterior()+"");
        temperaturaInterior.setText(c1.getTemperaturaInterior()+"");
        temperaturaSolo.setText(c1.getTemperaturaTerra()+"");
        comprimentoCasa.setText(c1.getCompr()+"");
        larguraCasa.setText(c1.getLar()+"");
        alturaCasa.setText(c1.getAlt()+"");
    }
}
