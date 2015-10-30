/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


/**
 *
 * @author Nuno Lemos
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;


public class Project extends JFrame {

    private boolean _quit = false;
    JDesktopPane desktop;

    public Project() {

        super("ISEP - FSIAP - Termodinâmica");
        desktop = new JDesktopPane();
        desktop.setBackground(Color.DARK_GRAY);

        this.setContentPane(desktop);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setMainMenuBar();

        setSize(1500, 1000); //Tamanho da janela
        setVisible(true);

    }

    private void setMainMenuBar() {

        JMenuBar rootMenu = new JMenuBar();
        rootMenu.setBorder(new BevelBorder(BevelBorder.RAISED));

        JMenu menu;
        JMenuItem item;


        menu = new JMenu("File");
        rootMenu.add(menu);
        item = new JMenuItem(new MenuItemAction("Save To HTML"));
        menu.add(item);
        item = new JMenuItem(new MenuItemAction("Open Experience"));
        menu.add(item);
        
        menu.add(new JSeparator());
        item = new JMenuItem(new MenuItemAction("Exit"));
        menu.add(item);


        menu = new JMenu("Experience");
        rootMenu.add(menu);
        item = new JMenuItem(new MenuItemAction("Start Experience"));
        menu.add(item);
        item = new JMenuItem(new MenuItemAction("Insert Materials"));
        menu.add(item);
        item = new JMenuItem(new MenuItemAction("Import Materials"));
        menu.add(item);
        

        menu = new JMenu("Help");
        rootMenu.add(menu);
        item = new JMenuItem(new MenuItemAction("Glossary"));
        menu.add(item);
        item = new JMenuItem(new MenuItemAction("About"));
        menu.add(item);
        
        
        setJMenuBar(rootMenu);
    }

    


    private void evaluateMenuItemActionPerformed(ActionEvent e) {

        if (e.getActionCommand().trim().equalsIgnoreCase("Save To HTML")) {
            SaveToHTML save = new SaveToHTML();
            save.setVisible(true);
            desktop.add(save);
            desktop.moveToFront(save);
        }

        if (e.getActionCommand().trim().equalsIgnoreCase("Open Experience")) {
            OpenExperience open = new OpenExperience();
            open.setVisible(true);
            desktop.add(open);
            desktop.moveToFront(open);
        }

        if (e.getActionCommand().trim().equalsIgnoreCase("Exit")) {
            int resposta = JOptionPane.showConfirmDialog(this,
                    "Tem a certeza que pretende sair?", "Exit",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resposta == JOptionPane.YES_OPTION) {
                _quit = true;
                this.setVisible(false);
                this.setEnabled(false);
                System.exit(0);
            }
        }

        if (e.getActionCommand().trim().equalsIgnoreCase("Start Experience")) {
            StartExperience start = new StartExperience();
            start.setVisible(true);
            desktop.add(start);
            desktop.moveToFront(start);
        }     
   
        if (e.getActionCommand().trim().equalsIgnoreCase("Insert Materials")) {
            InsertMaterials insert = new InsertMaterials();
            insert.setVisible(true);
            desktop.add(insert);
            desktop.moveToFront(insert);
        }     
               
        if (e.getActionCommand().trim().equalsIgnoreCase("Import Materials")) {
            ImportMaterials importx = new ImportMaterials();
            importx.setVisible(true);
            desktop.add(importx);
            desktop.moveToFront(importx);
        }

        
                // Chama as opções de menu do separador Ajuda
        if (e.getActionCommand().trim().equalsIgnoreCase("Glossary")) {
            Glossary glossary = new Glossary();
            glossary.setVisible(true);
            desktop.add(glossary);
            desktop.moveToFront(glossary);
       } 


        if (e.getActionCommand().trim().equalsIgnoreCase("About")) {
            About about = new About();
            about.setVisible(true);
            desktop.add(about);
            desktop.moveToFront(about);
        }


    }

    class MenuItemAction extends AbstractAction {

        public MenuItemAction(String text) {
            super(text);
        }

        public void actionPerformed(ActionEvent e) {
            evaluateMenuItemActionPerformed(e);
        }
    }
}