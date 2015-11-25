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
import Internacionalizacao.Idioma;
import static Internacionalizacao.Idioma.initBundle;
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
    JMenuBar rootMenu;
    JMenu menuFile, menuExperience, menuTools, menuHelp, submenu;
    JMenuItem itemsave, itemimportE, itemexit, itemstart, iteminsert, itemimportM, itemIngles, itemPortugues, itemGlossary, itemAbout;
    
    
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

        initBundle();
        
        rootMenu = new JMenuBar();
        rootMenu.setBorder(new BevelBorder(BevelBorder.RAISED));
                
        menuFile = new JMenu(Internacionalizacao.Idioma.BUNDLE.getString("Project.file.text"));
        rootMenu.add(menuFile);
        itemsave = new JMenuItem(new MenuItemAction(Internacionalizacao.Idioma.BUNDLE.getString("Project.saveToHtml.text")));
        menuFile.add(itemsave);
        itemimportE = new JMenuItem(new MenuItemAction(Internacionalizacao.Idioma.BUNDLE.getString("Project.importExperiment.text")));
        menuFile.add(itemimportE);
        
        menuFile.add(new JSeparator());
        itemexit = new JMenuItem(new MenuItemAction(Internacionalizacao.Idioma.BUNDLE.getString("Project.exit.text")));
        menuFile.add(itemexit);


        menuExperience = new JMenu(Internacionalizacao.Idioma.BUNDLE.getString("Project.experiment.text"));
        rootMenu.add(menuExperience);
        itemstart = new JMenuItem(new MenuItemAction(Internacionalizacao.Idioma.BUNDLE.getString("Project.startSimulation.text")));
        menuExperience.add(itemstart);
        iteminsert = new JMenuItem(new MenuItemAction(Internacionalizacao.Idioma.BUNDLE.getString("Project.insertMaterials.text")));
        menuExperience.add(iteminsert);
        itemimportM = new JMenuItem(new MenuItemAction(Internacionalizacao.Idioma.BUNDLE.getString("Project.importMaterials.text")));
        menuExperience.add(itemimportM);
                
        menuTools = new JMenu(Internacionalizacao.Idioma.BUNDLE.getString("Project.tools.text"));
        rootMenu.add(menuTools);
        submenu = new JMenu(new MenuItemAction(Internacionalizacao.Idioma.BUNDLE.getString("Project.idioma.text")));
        menuTools.add(submenu);
        itemIngles = new JMenuItem(new MenuItemAction(Internacionalizacao.Idioma.BUNDLE.getString("Project.ingles.text")));
        submenu.add(itemIngles);
        itemPortugues = new JMenuItem(new MenuItemAction(Internacionalizacao.Idioma.BUNDLE.getString("Project.portugues.text")));
        submenu.add(itemPortugues);
        
        menuHelp = new JMenu(Internacionalizacao.Idioma.BUNDLE.getString("Project.help.text"));
        rootMenu.add(menuHelp);
        itemGlossary = new JMenuItem(new MenuItemAction(Internacionalizacao.Idioma.BUNDLE.getString("Project.glossary.text")));
        menuHelp.add(itemGlossary);
        itemAbout = new JMenuItem(new MenuItemAction(Internacionalizacao.Idioma.BUNDLE.getString("Project.about.text")));
        menuHelp.add(itemAbout);
        
        setJMenuBar(rootMenu);
    }

    


    private void evaluateMenuItemActionPerformed(ActionEvent e) {

        if (e.getActionCommand().trim().equalsIgnoreCase(Internacionalizacao.Idioma.BUNDLE.getString("Project.saveToHtml.text"))) {
            SaveToHTML save = new SaveToHTML();
            save.setVisible(true);
            desktop.add(save);
            desktop.moveToFront(save);
        }

        if (e.getActionCommand().trim().equalsIgnoreCase(Internacionalizacao.Idioma.BUNDLE.getString("Project.importExperiment.text"))) {
            OpenExperience open = new OpenExperience();
            open.setVisible(true);
            desktop.add(open);
            desktop.moveToFront(open);
        }

        if (e.getActionCommand().trim().equalsIgnoreCase(Internacionalizacao.Idioma.BUNDLE.getString("Project.exit.text"))) {
            int resposta = JOptionPane.showConfirmDialog(this,
                    Internacionalizacao.Idioma.BUNDLE.getString("Project.exitQuestion.text"), Internacionalizacao.Idioma.BUNDLE.getString("Project.exit.text"),
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resposta == JOptionPane.YES_OPTION) {
                _quit = true;
                this.setVisible(false);
                this.setEnabled(false);
                System.exit(0);
            }
        }

        if (e.getActionCommand().trim().equalsIgnoreCase(Internacionalizacao.Idioma.BUNDLE.getString("Project.startSimulation.text"))) {
            StartSimulation start = new StartSimulation();
            start.setVisible(true);
            desktop.add(start);
            desktop.moveToFront(start);
        }     
   
        if (e.getActionCommand().trim().equalsIgnoreCase(Internacionalizacao.Idioma.BUNDLE.getString("Project.insertMaterials.text"))) {
            InsertMaterials insert = new InsertMaterials();
            insert.setVisible(true);
            desktop.add(insert);
            desktop.moveToFront(insert);
        }     
               
        if (e.getActionCommand().trim().equalsIgnoreCase(Internacionalizacao.Idioma.BUNDLE.getString("Project.importMaterials.text"))) {
            ImportMaterials importx = new ImportMaterials();
            importx.setVisible(true);
            desktop.add(importx);
            desktop.moveToFront(importx);
        }

        
        // Chama as opções de menu do separador Ferramentas
        if (e.getActionCommand().trim().equalsIgnoreCase(Internacionalizacao.Idioma.BUNDLE.getString("Project.ingles.text"))) {
            int idioma = 1;
            initBundle(idioma);
            rootMenu.repaint();
            rootMenu.revalidate();
       }
        
        if (e.getActionCommand().trim().equalsIgnoreCase(Internacionalizacao.Idioma.BUNDLE.getString("Project.portugues.text"))) {
            int idioma = 0;
            initBundle(idioma);            
            rootMenu.repaint();
            rootMenu.revalidate();
        }
        
        
        // Chama as opções de menu do separador Ajuda
        if (e.getActionCommand().trim().equalsIgnoreCase(Internacionalizacao.Idioma.BUNDLE.getString("Project.glossary.text"))) {
            Glossary glossary = new Glossary();
            glossary.setVisible(true);
            desktop.add(glossary);
            desktop.moveToFront(glossary);
       } 


        if (e.getActionCommand().trim().equalsIgnoreCase(Internacionalizacao.Idioma.BUNDLE.getString("Project.about.text"))) {
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
