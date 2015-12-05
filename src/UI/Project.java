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
import Internacionalizacao.Idioma;


public class Project extends JFrame{

    private boolean _quit = false;
    private JDesktopPane desktop;
    JMenuBar rootMenu;
    JMenu menuFile, menuExperience, menuTools, menuHelp, submenu;
    JMenuItem itemsave, itemimportE, itemexit, itemstart, iteminsert, itemimportM, itemexportM, itemIngles, itemPortugues, itemGlossary, itemAbout;
        
    public Project() {

        super("ISEP - FSIAP - Termodinâmica");
        desktop = new JDesktopPane();
        desktop.setBackground(Color.DARK_GRAY);
        
        this.setExtendedState(MAXIMIZED_BOTH);
        
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
                
        menuFile = new JMenu();
        rootMenu.add(menuFile);
        itemsave = new JMenuItem(new MenuItemAction(Idioma.BUNDLE.getString("Project.saveToHtml.text")));
        menuFile.add(itemsave);
        itemimportE = new JMenuItem(new MenuItemAction(Idioma.BUNDLE.getString("Project.importExperiment.text")));
        menuFile.add(itemimportE);
        
        menuFile.add(new JSeparator());
        itemexit = new JMenuItem(new MenuItemAction(Idioma.BUNDLE.getString("Project.exit.text")));
        menuFile.add(itemexit);


        menuExperience = new JMenu();
        rootMenu.add(menuExperience);
        itemstart = new JMenuItem(new MenuItemAction(Idioma.BUNDLE.getString("Project.startSimulation.text")));
        menuExperience.add(itemstart);
        iteminsert = new JMenuItem(new MenuItemAction(Idioma.BUNDLE.getString("Project.insertMaterials.text")));
        menuExperience.add(iteminsert);
        itemimportM = new JMenuItem(new MenuItemAction(Idioma.BUNDLE.getString("Project.importMaterials.text")));
        menuExperience.add(itemimportM);
        itemexportM = new JMenuItem(new MenuItemAction(Idioma.BUNDLE.getString("Project.exportMaterials.text")));
        menuExperience.add(itemexportM);
                
        menuTools = new JMenu();
        rootMenu.add(menuTools);
        submenu = new JMenu(new MenuItemAction(Idioma.BUNDLE.getString("Project.idioma.text")));
        menuTools.add(submenu);
        itemIngles = new JMenuItem(new MenuItemAction(Idioma.BUNDLE.getString("Project.ingles.text")));
        submenu.add(itemIngles);
        itemPortugues = new JMenuItem(new MenuItemAction(Idioma.BUNDLE.getString("Project.portugues.text")));
        submenu.add(itemPortugues);
        
        menuHelp = new JMenu();
        rootMenu.add(menuHelp);
        itemGlossary = new JMenuItem(new MenuItemAction(Idioma.BUNDLE.getString("Project.glossary.text")));
        menuHelp.add(itemGlossary);
        itemAbout = new JMenuItem(new MenuItemAction(Idioma.BUNDLE.getString("Project.about.text")));
        menuHelp.add(itemAbout);
        
        setJMenuBar(rootMenu);
        setText();
    }

    


    private void evaluateMenuItemActionPerformed(ActionEvent e) {

        if (e.getActionCommand().trim().equalsIgnoreCase(Idioma.BUNDLE.getString("Project.saveToHtml.text"))) {
            SaveToHTML save = new SaveToHTML();
            save.setVisible(true);
            desktop.add(save);
            desktop.moveToFront(save);
        }

        if (e.getActionCommand().trim().equalsIgnoreCase(Idioma.BUNDLE.getString("Project.importExperiment.text"))) {
            OpenExperience open = new OpenExperience();
            open.setVisible(true);
            desktop.add(open);
            desktop.moveToFront(open);
        }

        if (e.getActionCommand().trim().equalsIgnoreCase(Idioma.BUNDLE.getString("Project.exit.text"))) {
            int resposta = JOptionPane.showConfirmDialog(this,
                    Idioma.BUNDLE.getString("Project.exitQuestion.text"), Idioma.BUNDLE.getString("Project.exit.text"),
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resposta == JOptionPane.YES_OPTION) {
                _quit = true;
                this.setVisible(false);
                this.setEnabled(false);
                System.exit(0);
            }
        }

        if (e.getActionCommand().trim().equalsIgnoreCase(Idioma.BUNDLE.getString("Project.startSimulation.text"))) {
            StartSimulation start = new StartSimulation();
            start.setVisible(true);
            //submenu.setEnabled(false);
            desktop.add(start);
            desktop.moveToFront(start);
        }     
   
        if (e.getActionCommand().trim().equalsIgnoreCase(Idioma.BUNDLE.getString("Project.insertMaterials.text"))) {
            InsertMaterials insert = new InsertMaterials();
            insert.setVisible(true);
            //submenu.setEnabled(false);
            desktop.add(insert);
            desktop.moveToFront(insert);
        }     
               
        if (e.getActionCommand().trim().equalsIgnoreCase(Idioma.BUNDLE.getString("Project.importMaterials.text"))) {
            ImportMaterials importx = new ImportMaterials();
            importx.setVisible(true);
            //submenu.setEnabled(false);
            desktop.add(importx);
            desktop.moveToFront(importx);
        }
        
        if (e.getActionCommand().trim().equalsIgnoreCase(Idioma.BUNDLE.getString("Project.exportMaterials.text"))) {
            ExportMaterials exportx = new ExportMaterials();
            exportx.setVisible(true);
            //submenu.setEnabled(false);
            desktop.add(exportx);
            desktop.moveToFront(exportx);
        }

        
        // Chama as opções de menu do separador Ferramentas
        if (e.getActionCommand().trim().equalsIgnoreCase(Idioma.BUNDLE.getString("Project.ingles.text"))) {
            Idioma.IDIOMA = 1;
            initBundle();
            setText();
       }
        
        if (e.getActionCommand().trim().equalsIgnoreCase(Idioma.BUNDLE.getString("Project.portugues.text"))) {
            Idioma.IDIOMA = 0;
            initBundle();            
            setText();
        }
        
        
        // Chama as opções de menu do separador Ajuda
        if (e.getActionCommand().trim().equalsIgnoreCase(Idioma.BUNDLE.getString("Project.glossary.text"))) {
            Glossary glossary = new Glossary();
            glossary.setVisible(true);
            //submenu.setEnabled(false);
            desktop.add(glossary);
            desktop.moveToFront(glossary);
       } 


        if (e.getActionCommand().trim().equalsIgnoreCase(Idioma.BUNDLE.getString("Project.about.text"))) {
            About about = new About();
            about.setVisible(true);
            //submenu.setEnabled(false);
            desktop.add(about);
            desktop.moveToFront(about);
        }
    }

    class MenuItemAction extends AbstractAction {
        public MenuItemAction(String text) {
            super(text);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            evaluateMenuItemActionPerformed(e);
        }
    }
    

    
    private void setText() {
        menuFile.setText(Idioma.BUNDLE.getString("Project.file.text"));
        itemsave.setText(Idioma.BUNDLE.getString("Project.saveToHtml.text"));
        itemimportE.setText(Idioma.BUNDLE.getString("Project.importExperiment.text"));
        itemexit.setText(Idioma.BUNDLE.getString("Project.exit.text"));
        menuExperience.setText(Idioma.BUNDLE.getString("Project.experiment.text"));
        itemstart.setText(Idioma.BUNDLE.getString("Project.startSimulation.text"));
        iteminsert.setText(Idioma.BUNDLE.getString("Project.insertMaterials.text"));
        itemimportM.setText(Idioma.BUNDLE.getString("Project.importMaterials.text"));
        itemexportM.setText(Idioma.BUNDLE.getString("Project.exportMaterials.text"));
        menuTools.setText(Idioma.BUNDLE.getString("Project.tools.text")); 
        submenu.setText(Idioma.BUNDLE.getString("Project.idioma.text"));
        itemIngles.setText(Idioma.BUNDLE.getString("Project.ingles.text"));
        itemPortugues.setText(Idioma.BUNDLE.getString("Project.portugues.text"));        
        menuHelp.setText(Idioma.BUNDLE.getString("Project.help.text"));
        itemGlossary.setText(Idioma.BUNDLE.getString("Project.glossary.text"));
        itemAbout.setText(Idioma.BUNDLE.getString("Project.about.text"));
        
    }
    public JDesktopPane getJDesktopPane(){
        return desktop;
    }

}
