/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Repositorios.Materiais;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 *
 * @author Nuno Lemos
 */
public class InsertMaterials extends JInternalFrame implements ActionListener {
    private JTextField nome, condutividade;
    private JLabel label_nome, label_condutividade;
    private JButton botton_inserir;
    private JScrollPane lista_materiais;
    private JList listbox  = new JList();
    

    //construtor
    public InsertMaterials (){
    super(Internacionalizacao.Idioma.BUNDLE.getString("InsertMaterials.insertMaterials.text"),
          false, //resizable
          true, //closable
          false, //maximizable
          false);//iconifiable

        //instância campos para exibir os valores
        label_nome = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("InsertMaterials.nameMaterial.text"));
        nome = new JTextField(25);
        label_condutividade = new JLabel(Internacionalizacao.Idioma.BUNDLE.getString("InsertMaterials.conductivity.text"));
        condutividade = new JTextField(20);
        
        //instância botões da calculadora
        botton_inserir = new JButton(Internacionalizacao.Idioma.BUNDLE.getString("InsertMaterials.insert.text"));
        
        lista_materiais = new JScrollPane();
        lista_materiais.getViewport().add( listbox );
        
        //instância uma janela para os componetes
        JPanel painel = new JPanel();
        JPanel paineltemp = new JPanel();
        Container janela = getContentPane();
        GridLayout grid = new GridLayout(1,2);
        //janela.setLayout(new GridLayout(3,1));
        //inclusão dos elementos no container
        painel.setLayout(grid);
        paineltemp.add(label_nome);
        painel.add(paineltemp);
        
        paineltemp.add(nome);
        painel.add(paineltemp);
        
        paineltemp.add(label_condutividade);
        painel.add(paineltemp);
        
        paineltemp.add(condutividade);
        painel.add(paineltemp);
        
        paineltemp.add(botton_inserir);
        painel.add(paineltemp);
        
        paineltemp.add(lista_materiais);
        painel.add(paineltemp);
        
        janela.add(painel);
        
        //associa receptor de ação aos botões
        botton_inserir.addActionListener(this);
        //define o frame
        setSize(300, 400);
        setMinimumSize(new Dimension(300, 400));
        Dimension paneSize = janela.getSize();   
        Dimension screenSize = janela.getToolkit().getScreenSize();   
        setLocation((screenSize.width - paneSize.width) / 4, (screenSize.height - paneSize.height) / 5);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == botton_inserir){
            
            if(nome.getText().isEmpty() || condutividade.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, Internacionalizacao.Idioma.BUNDLE.getString("InsertMaterials.fraseEmpety1.text"), Internacionalizacao.Idioma.BUNDLE.getString("InsertMaterials.error.text"), JOptionPane.ERROR_MESSAGE);
            } else {
                //Implementar gravação de dados
                try{                
                    Materiais  materiais = Materiais.getInstance();
                    String strCond = condutividade.getText().replace(",", ".");
                    float cond = Float.parseFloat(strCond);
                    materiais.inserirMaterial(nome.getText(), cond);
                }
                catch(NumberFormatException ex) {
                    throw new IllegalArgumentException("Valor de condutividade inválido");
                }
            }
            
            if(nome.getText().equals("") && condutividade.getText().equals("")){
                JOptionPane.showMessageDialog(null, Internacionalizacao.Idioma.BUNDLE.getString("InsertMaterials.fraseEmpety2.text"), Internacionalizacao.Idioma.BUNDLE.getString("InsertMaterials.error.text"), JOptionPane.ERROR_MESSAGE);                    
            }
            
            
			// Get the text field value
			String stringValue = nome.getText();
			nome.setText( "" );
                        float condValue = Float.parseFloat(condutividade.getText().replace(",", "."));

			// Add this item to the list and refresh
			if( stringValue != null )
			{
                             
                                Materiais.getInstance().inserirMaterial(stringValue, condValue);
                                
                                try {
                                Object[] list = Materiais.getInstance().getListMateriais().toArray();    
                                listbox.setListData(list);
                                listbox.setVisible(true);
                            } catch (NullPointerException npe) {
                                    System.out.println(Internacionalizacao.Idioma.BUNDLE.getString("InsertMaterials.error.text"));
                            }
				
//                              listData.addElement( stringValue );
//				listbox.setListData( listData );
                                lista_materiais.revalidate();
				lista_materiais.repaint();
			}
            
        }
    }

   
}