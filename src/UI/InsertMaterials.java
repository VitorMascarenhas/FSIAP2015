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
import Dominio.Material;
import Repositorios.Materiais;
import javax.swing.JList;
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
    private JList listbox;
    

    //construtor
    public InsertMaterials (){
    super("Inserir Materiais",
          true, //resizable
          true, //closable
          true, //maximizable
          true);//iconifiable

        //instância campos para exibir os valores
        label_nome = new JLabel("Nome do Material");
        nome = new JTextField(25);
        label_condutividade = new JLabel("Condutividade");
        condutividade = new JTextField(20);
        
        //instância botões da calculadora
        botton_inserir = new JButton("Inserir");
        
        lista_materiais = new JScrollPane();
        lista_materiais.getViewport().add( listbox );
        
        //instância uma janela para os componetes
        Container janela = getContentPane();
        janela.setLayout(new GridLayout(7,1,1,1));
        //inclusão dos elementos no container
        janela.add(label_nome);
        janela.add(nome);
        janela.add(label_condutividade);
        janela.add(condutividade);        
        janela.add(botton_inserir);
        janela.add(lista_materiais);
        
//associa receptor de ação aos botões
        botton_inserir.addActionListener(this);
        //define o frame
        setSize(400, 600);
        setMinimumSize(new Dimension(200, 400));
        Dimension paneSize = janela.getSize();   
        Dimension screenSize = janela.getToolkit().getScreenSize();   
        setLocation((screenSize.width - paneSize.width) / 4, (screenSize.height - paneSize.height) / 5);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botton_inserir){
            
            if(nome.getText().isEmpty() || condutividade.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Tem de introduziz dados para inserir.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                
                
                //Implementar gravação de dados
                Materiais  materiais = Materiais.getInstance();
                float cond = Float.parseFloat(condutividade.getText());
                materiais.inserirMaterial(nome.getText(), cond);
            }
            
            if(nome.getText() == "" && condutividade.getText() == ""){
                JOptionPane.showMessageDialog(null, "Rectifique os dados introduzidos.", "Erro", JOptionPane.ERROR_MESSAGE);                    
            }
            
            
            
			// Get the text field value
			String stringValue = nome.getText();
			nome.setText( "" );

			// Add this item to the list and refresh
			if( stringValue != null )
			{
                             
                                Materiais.getInstance().inserirMaterial(nome.getText(), Float.parseFloat(condutividade.getText()));
				listbox.setListData( Materiais.getInstance().getListMateriais().toArray());
				listbox.setVisible(true);
//                                listData.addElement( stringValue );
//				listbox.setListData( listData );
                                lista_materiais.revalidate();
				lista_materiais.repaint();
			}
		
            
            
        }
    }

   
}