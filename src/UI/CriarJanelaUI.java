/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author vitoralexandremascarenhasmascarenhas
 */
public class CriarJanelaUI extends JDialog {
    
    private JButton btnCriarPorta = new JButton("Criar");
    private JButton btnCancelar = new JButton("Cancelar");
    private JLabel lblAltura = new JLabel("Altura");
    private JLabel lblLargura = new JLabel("Largura");
    private JLabel lblEspessura = new JLabel("Espessura");
    private JLabel lblMaterial = new JLabel("Material");
    private JTextField txtAltura = new JTextField(4);
    private JTextField txtLargura = new JTextField(4);
    private JTextField txtEspessura = new JTextField(4);
    private JComboBox cmbMaterial = new JComboBox();
    
    public CriarJanelaUI() {
        
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.getContentPane();
        this.setLayout(gbl);
        gbc.insets = new Insets(10, 10, 10, 10);
        
        this.add(lblAltura, gbc);
        this.add(txtAltura, gbc);
        this.add(lblLargura, gbc);
        this.add(txtLargura, gbc);
        gbc.gridy = 1;
        this.add(lblEspessura, gbc);
        this.add(txtEspessura, gbc);
        this.add(lblMaterial, gbc);
        this.add(cmbMaterial, gbc);
        gbc.gridy = 2;
        gbc.gridx = 1;
        this.add(btnCriarPorta, gbc);
        gbc.gridx = 2;
        this.add(btnCancelar, gbc);
        
        this.setSize(400, 200);
        
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setVisible(true);
    }
}