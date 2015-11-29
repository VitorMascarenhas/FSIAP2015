/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Dominio.Casa;
import java.io.File;
import java.io.FileFilter;
import javax.swing.*;
import Persistencia.ToHTML;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Nuno Lemos
 */
public class SaveToHTML extends JInternalFrame {

public SaveToHTML(Casa c1) throws FileNotFoundException {

        JFileChooser chooser = new JFileChooser(new File("c:\\"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("HTML FIles", "html");
        chooser.addChoosableFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false); 
        int result = chooser.showSaveDialog(null);
        
        //int option = chooser.showSaveDialog(SaveToHTML.this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String content = ToHTML.exportExp("Experiencia", c1);
            File fi = chooser.getSelectedFile();
            try{
                FileWriter fw = new FileWriter(fi.getPath()+".html");
                fw.write(content);
                fw.flush();
                fw.close();
            }catch(Exception e2){
                JOptionPane.showMessageDialog(null, e2.getMessage());
            }
        }
//                File selectedFile = chooser.getSelectedFile();
//                String f = selectedFile.getParent() + File.separator + selectedFile.getName();
//                if(!f.toLowerCase().endsWith(".html")){
//                    f += ".html";
//                }
//            ToHTML file = new ToHTML();
//            } else if (option == JFileChooser.CANCEL_OPTION) {
//                System.out.println(JFileChooser.CANCEL_OPTION);
//            }

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