/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.*; 
import java.util.*; 
/**
 *
 * @author joelalves
 */
public  class BinaryFile {
       public static void readObject() throws IOException, ClassNotFoundException {
           try {
           ObjectInputStream in = new ObjectInputStream (new FileInputStream("objects.dat"));
           
           System.out.println("I have read:"); 
           while(in.available() > 0){
               Date d1 = (Date) in.readObject();
                System.out.println("A Date object: "+d1);
           }
//           RandomClass rc1 = (RandomClass)in.readObject();
//           RandomClass rc2 = (RandomClass)in.readObject(); 
           
           System.out.println("Two Group of randoms"); 
//           rc1.printout(); 
//           rc2.printout(); 
           }
           catch (IOException io) {
            System.out.println("Error Open");
        }catch (ClassNotFoundException  Not) {
            System.out.println("Error Not found file");
        }

        
    }
 
    public static void writeObject() throws IOException {

        try {
            //create a stream chain with object stream at the top.
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objects.dat"));
            Date now = new Date(System.currentTimeMillis());
            Date now2 = new Date(System.currentTimeMillis());

            out.writeObject(now);
            out.writeObject(now2);
//            out.writeObject(rc1);
//            out.writeObject(rc2);

        } catch (IOException io) {
            System.out.println("Error Save");
        }

        System.out.println("I have written:");

    }
}
