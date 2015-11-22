/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import javax.swing.*;
import Persistencia.ToHTML;

/**
 *
 * @author Nuno Lemos
 */
public class SaveToHTML extends JInternalFrame {

public SaveToHTML() {

        JFileChooser chooser = new JFileChooser();
        FileFilter filter = new ExtensionFileFilter("html",".html");
        //chooser.setFileFilter(filter);
        int option = chooser.showSaveDialog(SaveToHTML.this);
        if (option == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                String f = selectedFile.getParent() + File.separator + selectedFile.getName();
                if(!f.toLowerCase().endsWith(".html")){
                    f += ".html";
                }
            ToHTML file = new ToHTML();
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