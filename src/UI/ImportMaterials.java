/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Dominio.Casa;
import Persistencia.FromHTML;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
//
//
public class ImportMaterials extends JInternalFrame {
//     
   public ImportMaterials() {

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("HTML Files", "html");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Text Files", "txt");
        chooser.addChoosableFileFilter(filter);
        chooser.addChoosableFileFilter(filter2);
        chooser.setAcceptAllFileFilterUsed(false); 
        //chooser.setFileFilter(filter);
        int option = chooser.showOpenDialog(ImportMaterials.this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try{
                File fi = chooser.getSelectedFile();
                FromHTML.leMateriais(fi);
            }catch(Exception e2){
                JOptionPane.showMessageDialog(null, e2);
            }
        } else if (option == JFileChooser.CANCEL_OPTION) {
            System.out.println(JFileChooser.CANCEL_OPTION);
        }

    }



class ExtensionFileFilter implements FileFilter {

        String description;
        String extensions[];

        public ExtensionFileFilter(String description, String extension) {
            this(description, new String[]{extension});
        }

        public ExtensionFileFilter(String description, String extensions[]) {
            if (description == null) {
                this.description = extensions[0];
            } else {
                this.description = description;
            }
            this.extensions = (String[]) extensions.clone();
            toLower(this.extensions);
        }

        private void toLower(String array[]) {
            for (int i = 0, n = array.length; i < n; i++) {
                array[i] = array[i].toLowerCase();
            }
        }

        public String getDescription() {
            return description;
        }

        public boolean accept(File file) {
            if (file.isDirectory()) {
                return true;
            } else {
                String path = file.getAbsolutePath().toLowerCase();
                for (int i = 0, n = extensions.length; i < n; i++) {
                    String extension = extensions[i];
                    if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
