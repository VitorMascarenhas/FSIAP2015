/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Dominio.Casa;
import Dominio.Componente;
import Dominio.Parede;
import Repositorios.Materiais;
import controlador.CriarComponenteControlador;
import controlador.CriarParedeControlador;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author suq-madik
 */
public class WallPanel extends javax.swing.JPanel {

    /**
     * Creates new form WallPanel
     */
    private String altura, largura, comprimento;

    static DefaultListModel<Componente> componentes1 = new DefaultListModel<>();
    static DefaultListModel<Componente> componentes2 = new DefaultListModel<>();
    final DefaultListModel<Componente> componentes3 = new DefaultListModel<>();
    final DefaultListModel<Componente> componentes4 = new DefaultListModel<>();
    final DefaultListModel<Componente> componentes5 = new DefaultListModel<>();
    final DefaultListModel<Componente> componentes6 = new DefaultListModel<>();

    public WallPanel() {
        initComponents();
        btnValidar2.setEnabled(false);
        btnValidar3.setEnabled(false);
        btnValidar4.setEnabled(false);
        btnValidar5.setEnabled(false);
        btnValidar6.setEnabled(false);
        listaComponentes1.setModel(componentes1);
        listaComponentes2.setModel(componentes2);
        listaComponentes3.setModel(componentes3);
        listaComponentes4.setModel(componentes4);
        listaComponentes5.setModel(componentes5);
        listaComponentes6.setModel(componentes6);
        preencheComboBoxMAteriais();
        preencheComboBoxTipo();
        disableTextField();

        tipo1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (tipo1.getSelectedItem().toString().equalsIgnoreCase("Camada") || tipo1.getSelectedItem().toString().equalsIgnoreCase("Layer")) {
                    disableTextField1();
                    getDimParede1(altura, largura);
                } else {
                    enableTextField1();
                    limparTextField(altura1);
                    limparTextField(largura1);
                }
            }
        });

        tipo2.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (tipo2.getSelectedItem().toString().equalsIgnoreCase("Camada") || tipo1.getSelectedItem().toString().equalsIgnoreCase("Layer")) {
                    disableTextField2();
                    getDimParede2(altura, comprimento);
                } else {
                    enableTextField2();
                    getDimParede2(altura, comprimento);
                    limparTextField(altura2);
                    limparTextField(largura2);
                }
            }
        });

        tipo3.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (tipo3.getSelectedItem().toString().equalsIgnoreCase("Camada") || tipo1.getSelectedItem().toString().equalsIgnoreCase("Layer")) {
                    disableTextField3();
                    getDimParede3(altura, largura);
                } else {
                    enableTextField3();
                    getDimParede3(altura, largura);
                    limparTextField(altura3);
                    limparTextField(largura3);
                }
            }
        });

        tipo4.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (tipo4.getSelectedItem().toString().equalsIgnoreCase("Camada") || tipo1.getSelectedItem().toString().equalsIgnoreCase("Layer")) {
                    disableTextField4();
                    getDimParede4(altura, comprimento);
                } else {
                    enableTextField4();
                    getDimParede4(altura, comprimento);
                    limparTextField(altura4);
                    limparTextField(largura4);
                }
            }
        });

        btnAdicionar2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionar2ActionPerformed(evt);
            }
        });

        btnAdicionar3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionar3ActionPerformed(evt);
            }
        });
        btnAdicionar4.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionar4ActionPerformed(evt);
            }
        });
        btnAdicionar5.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionar5ActionPerformed(evt);
            }
        });
        btnAdicionar6.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionar6ActionPerformed(evt);
            }
        });

        btnValidar2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidar2ActionPerformed(evt);
            }
        });

        btnValidar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidar3ActionPerformed(evt);
            }
        });

        btnValidar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidar4ActionPerformed(evt);
            }
        });

        btnValidar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidar5ActionPerformed(evt);
            }
        });

        btnValidar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidar6ActionPerformed(evt);
            }
        });
    }

    private void preencheComboBoxMAteriais() {
        String[] materiaisArray = Materiais.getInstance().getListaDeMateriais();
        for (String string : materiaisArray) {
            tipoMaterial1.addItem(string);
            tipoMaterial2.addItem(string);
            tipoMaterial3.addItem(string);
            tipoMaterial4.addItem(string);
            tipoMaterial5.addItem(string);
            tipoMaterial6.addItem(string);
        }

    }

    private void preencheComboBoxTipo() {
        String[] tipoArray = {Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.layer.text"), Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.window.text"), Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.door.text")};
        for (String string : tipoArray) {
            tipo1.addItem(string);
            tipo2.addItem(string);
            tipo3.addItem(string);
            tipo4.addItem(string);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelParede1 = new javax.swing.JPanel();
        tipo1 = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        altura1 = new javax.swing.JTextField();
        largura1 = new javax.swing.JTextField();
        tipoMaterial1 = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        espessura1 = new javax.swing.JTextField();
        btnAdicionar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaComponentes1 = new javax.swing.JList<Componente>();
        btnRemover1 = new javax.swing.JButton();
        btnValidar1 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        painelParede2 = new javax.swing.JPanel();
        tipo2 = new javax.swing.JComboBox<String>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        altura2 = new javax.swing.JTextField();
        largura2 = new javax.swing.JTextField();
        tipoMaterial2 = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();
        espessura2 = new javax.swing.JTextField();
        btnAdicionar2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaComponentes2 = new javax.swing.JList<Componente>();
        btnRemover2 = new javax.swing.JButton();
        btnValidar2 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        painelParede3 = new javax.swing.JPanel();
        tipo3 = new javax.swing.JComboBox<String>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        altura3 = new javax.swing.JTextField();
        largura3 = new javax.swing.JTextField();
        tipoMaterial3 = new javax.swing.JComboBox<String>();
        jLabel17 = new javax.swing.JLabel();
        espessura3 = new javax.swing.JTextField();
        btnAdicionar3 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaComponentes3 = new javax.swing.JList<Componente>();
        btnRemover3 = new javax.swing.JButton();
        btnValidar3 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        painelParede4 = new javax.swing.JPanel();
        tipo4 = new javax.swing.JComboBox<String>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        altura4 = new javax.swing.JTextField();
        largura4 = new javax.swing.JTextField();
        tipoMaterial4 = new javax.swing.JComboBox<String>();
        jLabel23 = new javax.swing.JLabel();
        espessura4 = new javax.swing.JTextField();
        btnAdicionar4 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaComponentes4 = new javax.swing.JList<Componente>();
        btnRemover4 = new javax.swing.JButton();
        btnValidar4 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        painelParede5 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        altura5 = new javax.swing.JTextField();
        largura5 = new javax.swing.JTextField();
        tipoMaterial5 = new javax.swing.JComboBox<String>();
        jLabel29 = new javax.swing.JLabel();
        espessura5 = new javax.swing.JTextField();
        btnAdicionar5 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaComponentes5 = new javax.swing.JList<Componente>();
        btnRemover5 = new javax.swing.JButton();
        btnValidar5 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        painelParede6 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        altura6 = new javax.swing.JTextField();
        largura6 = new javax.swing.JTextField();
        tipoMaterial6 = new javax.swing.JComboBox<String>();
        jLabel35 = new javax.swing.JLabel();
        espessura6 = new javax.swing.JTextField();
        btnAdicionar6 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaComponentes6 = new javax.swing.JList<Componente>();
        btnRemover6 = new javax.swing.JButton();
        btnValidar6 = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();

        tipo1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tipo1ComponentShown(evt);
            }
        });

        jLabel1.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.type.text")+":");

        jLabel2.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.height.text")+":");

        jLabel3.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.width.text")+":");

        jLabel4.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.material.text")+":");

        jLabel5.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.thickness.text")+":");

        btnAdicionar1.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.addcomp.text"));
        btnAdicionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionar1ActionPerformed(evt);
            }
        });

        jLabel6.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.complist.text"));

        jScrollPane1.setViewportView(listaComponentes1);

        btnRemover1.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.removecomp.text"));
        btnRemover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemover1ActionPerformed(evt);
            }
        });

        btnValidar1.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.validatewall.text")+" 1");
        btnValidar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidar1ActionPerformed(evt);
            }
        });

        jLabel38.setText("m");

        jLabel39.setText("m");

        jLabel40.setText("m");

        javax.swing.GroupLayout painelParede1Layout = new javax.swing.GroupLayout(painelParede1);
        painelParede1.setLayout(painelParede1Layout);
        painelParede1Layout.setHorizontalGroup(
            painelParede1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParede1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelParede1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnValidar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelParede1Layout.createSequentialGroup()
                        .addGap(0, 237, Short.MAX_VALUE)
                        .addComponent(btnRemover1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdicionar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(painelParede1Layout.createSequentialGroup()
                        .addGroup(painelParede1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(painelParede1Layout.createSequentialGroup()
                                .addGroup(painelParede1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelParede1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tipo1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(altura1)
                                    .addComponent(largura1)
                                    .addComponent(tipoMaterial1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(espessura1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelParede1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel40))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelParede1Layout.setVerticalGroup(
            painelParede1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParede1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelParede1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(altura1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(largura1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tipoMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(espessura1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdicionar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemover1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnValidar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall.text")+" 1", painelParede1);

        jLabel7.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.type.text")+":");

        jLabel8.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.height.text")+":");

        jLabel9.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.width.text")+":");

        jLabel10.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.material.text")+":");

        largura2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                largura2ActionPerformed(evt);
            }
        });

        jLabel11.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.thickness.text")+":");

        btnAdicionar2.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.addcomp.text"));

        jLabel12.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.complist.text"));

        jScrollPane2.setViewportView(listaComponentes2);

        btnRemover2.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.removecomp.text"));
        btnRemover2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemover2ActionPerformed(evt);
            }
        });

        btnValidar2.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.validatewall.text")+" 2");

        jLabel25.setText("m");

        jLabel31.setText("m");

        jLabel37.setText("m");

        javax.swing.GroupLayout painelParede2Layout = new javax.swing.GroupLayout(painelParede2);
        painelParede2.setLayout(painelParede2Layout);
        painelParede2Layout.setHorizontalGroup(
            painelParede2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParede2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelParede2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnValidar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelParede2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemover2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdicionar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel12)
                    .addGroup(painelParede2Layout.createSequentialGroup()
                        .addGroup(painelParede2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelParede2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tipo2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(altura2)
                            .addComponent(largura2)
                            .addComponent(tipoMaterial2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(espessura2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelParede2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel31)
                            .addComponent(jLabel37))))
                .addContainerGap())
        );
        painelParede2Layout.setVerticalGroup(
            painelParede2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParede2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelParede2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(altura2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(largura2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tipoMaterial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(espessura2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdicionar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemover2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnValidar2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelParede2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(painelParede2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 67, Short.MAX_VALUE))
        );

        painelParede2.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall.text")+" 2", jPanel2);

        jLabel13.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.type.text")+":");

        jLabel14.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.height.text")+":");

        jLabel15.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.width.text")+":");

        jLabel16.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.material.text")+":");

        jLabel17.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.thickness.text")+":");

        btnAdicionar3.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.addcomp.text"));

        jLabel18.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.complist.text"));

        jScrollPane3.setViewportView(listaComponentes3);

        btnRemover3.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.removecomp.text"));
        btnRemover3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemover3ActionPerformed(evt);
            }
        });

        btnValidar3.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.validatewall.text")+" 3");

        jLabel47.setText("m");

        jLabel48.setText("m");

        jLabel49.setText("m");

        javax.swing.GroupLayout painelParede3Layout = new javax.swing.GroupLayout(painelParede3);
        painelParede3.setLayout(painelParede3Layout);
        painelParede3Layout.setHorizontalGroup(
            painelParede3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParede3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelParede3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnValidar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelParede3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemover3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdicionar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(painelParede3Layout.createSequentialGroup()
                        .addGroup(painelParede3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(painelParede3Layout.createSequentialGroup()
                                .addGroup(painelParede3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelParede3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tipo3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(altura3)
                                    .addComponent(largura3)
                                    .addComponent(tipoMaterial3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(espessura3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelParede3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47)
                                    .addComponent(jLabel48)
                                    .addComponent(jLabel49))))
                        .addGap(0, 163, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelParede3Layout.setVerticalGroup(
            painelParede3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParede3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelParede3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(altura3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(largura3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tipoMaterial3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(espessura3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdicionar3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemover3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnValidar3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelParede3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(painelParede3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 67, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall.text")+" 3", jPanel3);

        jLabel19.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.type.text")+":");

        jLabel20.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.height.text")+":");

        jLabel21.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.width.text")+":");

        jLabel22.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.material.text")+":");

        jLabel23.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.thickness.text")+":");

        btnAdicionar4.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.addcomp.text"));

        jLabel24.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.complist.text"));

        jScrollPane4.setViewportView(listaComponentes4);

        btnRemover4.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.removecomp.text"));
        btnRemover4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemover4ActionPerformed(evt);
            }
        });

        btnValidar4.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.validatewall.text")+" 4");

        jLabel44.setText("m");

        jLabel45.setText("m");

        jLabel46.setText("m");

        javax.swing.GroupLayout painelParede4Layout = new javax.swing.GroupLayout(painelParede4);
        painelParede4.setLayout(painelParede4Layout);
        painelParede4Layout.setHorizontalGroup(
            painelParede4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParede4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelParede4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnValidar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelParede4Layout.createSequentialGroup()
                        .addGap(0, 237, Short.MAX_VALUE)
                        .addComponent(btnRemover4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdicionar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(painelParede4Layout.createSequentialGroup()
                        .addGroup(painelParede4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addGroup(painelParede4Layout.createSequentialGroup()
                                .addGroup(painelParede4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelParede4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tipo4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(altura4)
                                    .addComponent(largura4)
                                    .addComponent(tipoMaterial4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(espessura4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelParede4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel46))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelParede4Layout.setVerticalGroup(
            painelParede4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParede4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelParede4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(altura4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(largura4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(tipoMaterial4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(espessura4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdicionar4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemover4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnValidar4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.wall.text")+" 4", painelParede4);

        jLabel26.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.height.text")+":");

        jLabel27.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.width.text")+":");

        jLabel28.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.material.text")+":");

        jLabel29.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.thickness.text")+":");

        btnAdicionar5.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.addcomp.text"));

        jLabel30.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.complist.text"));

        jScrollPane5.setViewportView(listaComponentes5);

        btnRemover5.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.removecomp.text"));
        btnRemover5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemover5ActionPerformed(evt);
            }
        });

        btnValidar5.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.validatefloor.text"));

        jLabel41.setText("m");

        jLabel42.setText("m");

        jLabel43.setText("m");

        javax.swing.GroupLayout painelParede5Layout = new javax.swing.GroupLayout(painelParede5);
        painelParede5.setLayout(painelParede5Layout);
        painelParede5Layout.setHorizontalGroup(
            painelParede5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParede5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelParede5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnValidar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelParede5Layout.createSequentialGroup()
                        .addGap(0, 237, Short.MAX_VALUE)
                        .addComponent(btnRemover5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdicionar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5)
                    .addGroup(painelParede5Layout.createSequentialGroup()
                        .addGroup(painelParede5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addGroup(painelParede5Layout.createSequentialGroup()
                                .addGroup(painelParede5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelParede5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(altura5)
                                    .addComponent(largura5)
                                    .addComponent(tipoMaterial5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(espessura5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelParede5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel42)
                                    .addComponent(jLabel43))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelParede5Layout.setVerticalGroup(
            painelParede5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParede5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(painelParede5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(altura5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(largura5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(tipoMaterial5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(espessura5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdicionar5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemover5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnValidar5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.floor.text"), painelParede5);

        jLabel32.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.height.text")+":");

        jLabel33.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.width.text")+":");

        jLabel34.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.material.text")+":");

        jLabel35.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.thickness.text")+":");

        btnAdicionar6.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.addcomp.text"));

        jLabel36.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.complist.text"));

        jScrollPane6.setViewportView(listaComponentes6);

        btnRemover6.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.removecomp.text"));
        btnRemover6.setActionCommand(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.removecomp.text"));
        btnRemover6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemover6ActionPerformed(evt);
            }
        });

        btnValidar6.setText(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.validateceiling.text"));

        jLabel50.setText("m");

        jLabel51.setText("m");

        jLabel52.setText("m");

        javax.swing.GroupLayout painelParede6Layout = new javax.swing.GroupLayout(painelParede6);
        painelParede6.setLayout(painelParede6Layout);
        painelParede6Layout.setHorizontalGroup(
            painelParede6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParede6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelParede6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnValidar6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelParede6Layout.createSequentialGroup()
                        .addGap(0, 237, Short.MAX_VALUE)
                        .addComponent(btnRemover6, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdicionar6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6)
                    .addGroup(painelParede6Layout.createSequentialGroup()
                        .addGroup(painelParede6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addGroup(painelParede6Layout.createSequentialGroup()
                                .addGroup(painelParede6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel35))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelParede6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(altura6)
                                    .addComponent(largura6)
                                    .addComponent(tipoMaterial6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(espessura6, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelParede6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel52))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelParede6Layout.setVerticalGroup(
            painelParede6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelParede6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(painelParede6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(altura6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(largura6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(tipoMaterial6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelParede6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(espessura6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdicionar6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemover6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnValidar6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(Internacionalizacao.Idioma.BUNDLE.getString("StartSimulation.ceiling.text"), painelParede6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemover4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemover4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemover4ActionPerformed

    private void btnRemover3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemover3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemover3ActionPerformed

    private void btnRemover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemover2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemover2ActionPerformed

    private void btnRemover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemover1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemover1ActionPerformed

    private void btnRemover5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemover5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemover5ActionPerformed

    private void btnRemover6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemover6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemover6ActionPerformed

    private void btnAdicionar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionar1ActionPerformed
        int nComponentesParede1 = 0;
        int indice = tipo1.getSelectedIndex();
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

                componentes1.add(nComponentesParede1, ccc.criarComponente(cmpnente, altura1.getText(), largura1.getText(), espessura1.getText(), tipoMaterial1.getSelectedItem().toString()));
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

                componentes1.add(nComponentesParede1, ccc.criarComponente(cmpnente, altura1.getText(), largura1.getText(), espessura1.getText(), tipoMaterial1.getSelectedItem().toString()));
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
                componentes1.add(nComponentesParede1, ccc.criarComponente(cmpnente, altura1.getText(), largura1.getText(), espessura1.getText(), tipoMaterial1.getSelectedItem().toString()));
                listaComponentes1.setVisible(true);
                listaComponentes1.revalidate();
                listaComponentes1.repaint();
                nComponentesParede1++;
                break;
        }
    }//GEN-LAST:event_btnAdicionar1ActionPerformed

    private void btnAdicionar2ActionPerformed(java.awt.event.ActionEvent evt) {
        int nComponentesParede2 = 0;
        int indice = tipo2.getSelectedIndex();
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

                componentes2.add(nComponentesParede2, ccc.criarComponente(cmpnente, altura2.getText(), largura2.getText(), espessura2.getText(), tipoMaterial2.getSelectedItem().toString()));
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

                componentes2.add(nComponentesParede2, ccc.criarComponente(cmpnente, altura2.getText(), largura2.getText(), espessura2.getText(), tipoMaterial2.getSelectedItem().toString()));
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
                componentes2.add(nComponentesParede2, ccc.criarComponente(cmpnente, altura2.getText(), largura2.getText(), espessura2.getText(), tipoMaterial2.getSelectedItem().toString()));
                listaComponentes2.setVisible(true);
                listaComponentes2.revalidate();
                listaComponentes2.repaint();
                nComponentesParede2++;
                break;
        }
    }

    private void btnAdicionar3ActionPerformed(java.awt.event.ActionEvent evt) {
        int nComponentesParede3 = 0;
        int indice = tipo3.getSelectedIndex();
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

                componentes3.add(nComponentesParede3, ccc.criarComponente(cmpnente, altura3.getText(), largura3.getText(), espessura3.getText(), tipoMaterial3.getSelectedItem().toString()));
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

                componentes3.add(nComponentesParede3, ccc.criarComponente(cmpnente, altura3.getText(), largura3.getText(), espessura3.getText(), tipoMaterial3.getSelectedItem().toString()));
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
                componentes3.add(nComponentesParede3, ccc.criarComponente(cmpnente, altura3.getText(), largura3.getText(), espessura3.getText(), tipoMaterial3.getSelectedItem().toString()));
                listaComponentes3.setVisible(true);
                listaComponentes3.revalidate();
                listaComponentes3.repaint();
                nComponentesParede3++;
                break;
        }
    }

    private void btnAdicionar4ActionPerformed(java.awt.event.ActionEvent evt) {
        int nComponentesParede4 = 0;
        int indice = tipo4.getSelectedIndex();
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

                componentes4.add(nComponentesParede4, ccc.criarComponente(cmpnente, altura4.getText(), largura4.getText(), espessura4.getText(), tipoMaterial4.getSelectedItem().toString()));
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

                componentes4.add(nComponentesParede4, ccc.criarComponente(cmpnente, altura4.getText(), largura4.getText(), espessura4.getText(), tipoMaterial4.getSelectedItem().toString()));
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
                componentes4.add(nComponentesParede4, ccc.criarComponente(cmpnente, altura4.getText(), largura4.getText(), espessura4.getText(), tipoMaterial4.getSelectedItem().toString()));
                listaComponentes4.setVisible(true);
                listaComponentes4.revalidate();
                listaComponentes4.repaint();
                nComponentesParede4++;
                break;
        }
    }

    private void btnAdicionar5ActionPerformed(java.awt.event.ActionEvent evt) {
        int nComponentesParede5 = 0;
        int indice = 0; //Chão é tratado apenas como camada (indice 0)
        String cmpnente = "CAMADA";
        CriarComponenteControlador ccc = new CriarComponenteControlador();
        switch (indice) {
            case 2: //Porta = 2
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

                componentes5.add(nComponentesParede5, ccc.criarComponente(cmpnente, altura5.getText(), largura5.getText(), espessura5.getText(), tipoMaterial5.getSelectedItem().toString()));
                listaComponentes5.setVisible(true);
                listaComponentes5.revalidate();
                listaComponentes5.repaint();
                nComponentesParede5++;
                break;
            case 1: //Janela = 1
                if (altura5.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da janela.");
                }
                if (largura5.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da janela.");
                }
                if (espessura5.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da janela.");
                }
                if (Float.parseFloat(altura5.getText()) > Float.parseFloat(altura5.getText())) {
                    JOptionPane.showMessageDialog(null, "A altura da janela não pode ser superior à altura da parede.\nInsira uma nova altura para a janela.");
                }
                if (Float.parseFloat(largura5.getText()) > Float.parseFloat(largura5.getText())) {
                    JOptionPane.showMessageDialog(null, "A largura da janela não pode ser superior à largura da parede.\nInsira uma nova largura para a janela.");
                }

                componentes5.add(nComponentesParede5, ccc.criarComponente(cmpnente, altura5.getText(), largura5.getText(), espessura5.getText(), tipoMaterial5.getSelectedItem().toString()));
                listaComponentes5.setVisible(true);
                listaComponentes5.revalidate();
                listaComponentes5.repaint();
                nComponentesParede5++;
                break;
            case 0: //Camada = 0
                if (altura5.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da camada.");
                }
                if (largura5.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da camada.");
                }
                if (espessura5.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da camada.");
                }
                if (Float.parseFloat(altura5.getText()) > Float.parseFloat(altura5.getText())) {
                    JOptionPane.showMessageDialog(null, "A altura da porta não pode ser superior à altura da parede.\nInsira uma nova altura para a camada.");
                }
                if (Float.parseFloat(largura5.getText()) > Float.parseFloat(largura5.getText())) {
                    JOptionPane.showMessageDialog(null, "A largura da porta não pode ser superior à largura da parede.\nInsira uma nova largura para a camada.");
                }
                componentes5.add(nComponentesParede5, ccc.criarComponente(cmpnente, altura5.getText(), largura5.getText(), espessura5.getText(), tipoMaterial5.getSelectedItem().toString()));
                listaComponentes5.setVisible(true);
                listaComponentes5.revalidate();
                listaComponentes5.repaint();
                nComponentesParede5++;
                break;
        }
    }

    private void btnAdicionar6ActionPerformed(java.awt.event.ActionEvent evt) {
        int nComponentesParede6 = 0;
        int indice = 0; //Chão é tratado apenas como camada (indice 0)
        String cmpnente = "CAMADA";
        CriarComponenteControlador ccc = new CriarComponenteControlador();
        switch (indice) {
            case 2: //Porta = 2
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

                componentes6.add(nComponentesParede6, ccc.criarComponente(cmpnente, altura6.getText(), largura6.getText(), espessura6.getText(), tipoMaterial6.getSelectedItem().toString()));
                listaComponentes6.setVisible(true);
                listaComponentes6.revalidate();
                listaComponentes6.repaint();
                nComponentesParede6++;
                break;
            case 1: //Janela = 1
                if (altura6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da janela.");
                }
                if (largura6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da janela.");
                }
                if (espessura6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da janela.");
                }
                if (Float.parseFloat(altura6.getText()) > Float.parseFloat(altura6.getText())) {
                    JOptionPane.showMessageDialog(null, "A altura da janela não pode ser superior à altura da parede.\nInsira uma nova altura para a janela.");
                }
                if (Float.parseFloat(largura6.getText()) > Float.parseFloat(largura6.getText())) {
                    JOptionPane.showMessageDialog(null, "A largura da janela não pode ser superior à largura da parede.\nInsira uma nova largura para a janela.");
                }

                componentes6.add(nComponentesParede6, ccc.criarComponente(cmpnente, altura6.getText(), largura6.getText(), espessura6.getText(), tipoMaterial6.getSelectedItem().toString()));
                listaComponentes6.setVisible(true);
                listaComponentes6.revalidate();
                listaComponentes6.repaint();
                nComponentesParede6++;
                break;
            case 0: //Camada = 0
                if (altura6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo altura está vazio.\nInsira um valor para a altura da camada.");
                }
                if (largura6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo largura está vazio.\nInsira um valor para a largura da camada.");
                }
                if (espessura6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo espessura está vazio.\nInsira um valor para a espessura da camada.");
                }
                if (Float.parseFloat(altura6.getText()) > Float.parseFloat(altura6.getText())) {
                    JOptionPane.showMessageDialog(null, "A altura da porta não pode ser superior à altura da parede.\nInsira uma nova altura para a camada.");
                }
                if (Float.parseFloat(largura6.getText()) > Float.parseFloat(largura6.getText())) {
                    JOptionPane.showMessageDialog(null, "A largura da porta não pode ser superior à largura da parede.\nInsira uma nova largura para a camada.");
                }
                componentes6.add(nComponentesParede6, ccc.criarComponente(cmpnente, altura6.getText(), largura6.getText(), espessura6.getText(), tipoMaterial6.getSelectedItem().toString()));
                listaComponentes6.setVisible(true);
                listaComponentes6.revalidate();
                listaComponentes6.repaint();
                nComponentesParede6++;
                break;
        }
    }


    private void largura2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_largura2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_largura2ActionPerformed

    private void tipo1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tipo1ComponentShown

    }//GEN-LAST:event_tipo1ComponentShown

    private void btnValidar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidar1ActionPerformed
        CriarParedeControlador cpc = new CriarParedeControlador();
        cpc.criarParede(altura1.getText(), largura1.getText(), componentes1, 0);
        btnValidar2.setEnabled(true);
        StartSimulation.rt_parede1.setText(Casa.getResistenciaTotalParede(0) + "");
        StartSimulation.fluxo1.setText(Casa.getFluxoPorParede(0) + "");
    }//GEN-LAST:event_btnValidar1ActionPerformed

    private void btnValidar2ActionPerformed(java.awt.event.ActionEvent evt) {
        CriarParedeControlador cpc = new CriarParedeControlador();
        cpc.criarParede(altura2.getText(), largura2.getText(), componentes2, 1);
        btnValidar3.setEnabled(true);
        StartSimulation.rt_parede2.setText(Casa.getResistenciaTotalParede(1) + "");
        StartSimulation.fluxo2.setText(Casa.getFluxoPorParede(1) + "");
    }

    private void btnValidar3ActionPerformed(java.awt.event.ActionEvent evt) {
        CriarParedeControlador cpc = new CriarParedeControlador();
        cpc.criarParede(altura3.getText(), largura3.getText(), componentes3, 2);
        btnValidar4.setEnabled(true);
        StartSimulation.rt_parede3.setText(Casa.getResistenciaTotalParede(2) + "");
        StartSimulation.fluxo3.setText(Casa.getFluxoPorParede(2) + "");
    }

    private void btnValidar4ActionPerformed(java.awt.event.ActionEvent evt) {
        CriarParedeControlador cpc = new CriarParedeControlador();
        cpc.criarParede(altura4.getText(), largura4.getText(), componentes4, 3);
        btnValidar5.setEnabled(true);
        StartSimulation.rt_parede4.setText(Casa.getResistenciaTotalParede(3) + "");
        StartSimulation.fluxo4.setText(Casa.getFluxoPorParede(3) + "");
    }

    private void btnValidar5ActionPerformed(java.awt.event.ActionEvent evt) {
        CriarParedeControlador cpc = new CriarParedeControlador();
        cpc.criarParede(altura5.getText(), largura5.getText(), componentes5, 4);
        btnValidar6.setEnabled(true);
        StartSimulation.rt_chao.setText(Casa.getResistenciaTotalParede(4) + "");
        StartSimulation.fluxo5.setText(Casa.getFluxoPorParede(4) + "");
    }

    private void btnValidar6ActionPerformed(java.awt.event.ActionEvent evt) {
        CriarParedeControlador cpc = new CriarParedeControlador();
        cpc.criarParede(altura6.getText(), largura6.getText(), componentes6, 5);
        StartSimulation.rt_teto.setText(Casa.getResistenciaTotalParede(5) + "");
        StartSimulation.fluxo6.setText(Casa.getFluxoPorParede(5) + "");
    }

    private void tipo2ComponentShown(java.awt.event.ComponentEvent evt) {
        if (tipo2.getSelectedItem().toString().equalsIgnoreCase("Camada")) {
            disableTextField2();
        } else {
            enableTextField2();
        }
    }

    private void tipo3ComponentShown(java.awt.event.ComponentEvent evt) {
        if (tipo3.getSelectedItem().toString().equalsIgnoreCase("Camada")) {
            disableTextField3();
        } else {
            enableTextField3();
        }
    }

    private void tipo4ComponentShown(java.awt.event.ComponentEvent evt) {
        if (tipo4.getSelectedItem().toString().equalsIgnoreCase("Camada")) {
            disableTextField4();
        } else {
            enableTextField4();

        }
    }

    public void getDim(String comprimento, String largura, String altura) {
        altura1.setText(altura);
        largura1.setText(largura);
        altura2.setText(altura);
        largura2.setText(comprimento);
        altura3.setText(altura);
        largura3.setText(largura);
        altura4.setText(altura);
        largura4.setText(comprimento);
        altura5.setText(comprimento);
        largura5.setText(largura);
        altura6.setText(comprimento);
        largura6.setText(largura);
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    private void getDimParede1(String altura, String largura) {
        altura1.setText(altura);
        largura1.setText(largura);
    }

    private void getDimParede2(String altura, String comprimento) {
        altura2.setText(altura);
        largura2.setText(comprimento);
    }

    private void getDimParede3(String altura, String largura) {
        altura3.setText(altura);
        largura3.setText(largura);
    }

    private void getDimParede4(String altura, String comprimento) {
        altura4.setText(altura);
        largura4.setText(comprimento);
    }

    private void getDimParede5(String comprimento, String largura) {
        altura5.setText(comprimento);
        largura5.setText(largura);
    }

    private void getDimParede6(String comprimento, String largura) {
        altura6.setText(comprimento);
        largura6.setText(largura);
    }

    private void limparTextField(JTextField tf) {
        tf.setText("");
    }

    private void disableTextField() {
        disableTextField1();
        disableTextField2();
        disableTextField3();
        disableTextField4();
        disableTextField5();
        disableTextField6();
    }

    private void disableTextField1() {
        largura1.setEnabled(false);
        altura1.setEnabled(false);
    }

    private void disableTextField2() {
        largura2.setEnabled(false);
        altura2.setEnabled(false);
    }

    private void disableTextField3() {
        largura3.setEnabled(false);
        altura3.setEnabled(false);
    }

    private void disableTextField4() {
        largura4.setEnabled(false);
        altura4.setEnabled(false);
    }

    private void disableTextField5() {
        largura5.setEnabled(false);
        altura5.setEnabled(false);
    }

    private void disableTextField6() {
        largura6.setEnabled(false);
        altura6.setEnabled(false);
    }

    private void enableTextField1() {
        largura1.setEnabled(true);
        altura1.setEnabled(true);
    }

    private void enableTextField2() {
        largura2.setEnabled(true);
        altura2.setEnabled(true);
    }

    private void enableTextField3() {
        largura3.setEnabled(true);
        altura3.setEnabled(true);
    }

    private void enableTextField4() {
        largura4.setEnabled(true);
        altura4.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField altura1;
    private javax.swing.JTextField altura2;
    private javax.swing.JTextField altura3;
    private javax.swing.JTextField altura4;
    private javax.swing.JTextField altura5;
    private javax.swing.JTextField altura6;
    private javax.swing.JButton btnAdicionar1;
    private javax.swing.JButton btnAdicionar2;
    private javax.swing.JButton btnAdicionar3;
    private javax.swing.JButton btnAdicionar4;
    private javax.swing.JButton btnAdicionar5;
    private javax.swing.JButton btnAdicionar6;
    private javax.swing.JButton btnRemover1;
    private javax.swing.JButton btnRemover2;
    private javax.swing.JButton btnRemover3;
    private javax.swing.JButton btnRemover4;
    private javax.swing.JButton btnRemover5;
    private javax.swing.JButton btnRemover6;
    private javax.swing.JButton btnValidar1;
    private javax.swing.JButton btnValidar2;
    private javax.swing.JButton btnValidar3;
    private javax.swing.JButton btnValidar4;
    private javax.swing.JButton btnValidar5;
    private javax.swing.JButton btnValidar6;
    private javax.swing.JTextField espessura1;
    private javax.swing.JTextField espessura2;
    private javax.swing.JTextField espessura3;
    private javax.swing.JTextField espessura4;
    private javax.swing.JTextField espessura5;
    private javax.swing.JTextField espessura6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField largura1;
    private javax.swing.JTextField largura2;
    private javax.swing.JTextField largura3;
    private javax.swing.JTextField largura4;
    private javax.swing.JTextField largura5;
    private javax.swing.JTextField largura6;
    private javax.swing.JList<Componente> listaComponentes1;
    private javax.swing.JList<Componente> listaComponentes2;
    private javax.swing.JList<Componente> listaComponentes3;
    private javax.swing.JList<Componente> listaComponentes4;
    private javax.swing.JList<Componente> listaComponentes5;
    private javax.swing.JList<Componente> listaComponentes6;
    private javax.swing.JPanel painelParede1;
    private javax.swing.JPanel painelParede2;
    private javax.swing.JPanel painelParede3;
    private javax.swing.JPanel painelParede4;
    private javax.swing.JPanel painelParede5;
    private javax.swing.JPanel painelParede6;
    private javax.swing.JComboBox<String> tipo1;
    private javax.swing.JComboBox<String> tipo2;
    private javax.swing.JComboBox<String> tipo3;
    private javax.swing.JComboBox<String> tipo4;
    private javax.swing.JComboBox<String> tipoMaterial1;
    private javax.swing.JComboBox<String> tipoMaterial2;
    private javax.swing.JComboBox<String> tipoMaterial3;
    private javax.swing.JComboBox<String> tipoMaterial4;
    private javax.swing.JComboBox<String> tipoMaterial5;
    private javax.swing.JComboBox<String> tipoMaterial6;
    // End of variables declaration//GEN-END:variables

    public void preencheSimulacao(Casa c1) {
        Parede p1 = c1.getAllParedes().get(0);
        System.out.println(p1);
        listaComponentes1 = new JList(p1.getComponentes().toArray());
        Parede p2 = c1.getAllParedes().get(1);
        listaComponentes2 = new JList(p2.getComponentes().toArray());
        Parede p3 = c1.getAllParedes().get(2);
        listaComponentes3 = new JList(p3.getComponentes().toArray());
        Parede p4 = c1.getAllParedes().get(3);
        listaComponentes4 = new JList(p4.getComponentes().toArray());
        Parede p5 = c1.getAllParedes().get(4);
        listaComponentes5 = new JList(p5.getComponentes().toArray());
        Parede p6 = c1.getAllParedes().get(5);
        listaComponentes6 = new JList(p6.getComponentes().toArray());
    }

}
