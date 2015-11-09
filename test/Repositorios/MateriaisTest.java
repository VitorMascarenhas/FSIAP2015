/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 11011_000
 */
public class MateriaisTest {
   private Materiais sone = null, stwo = null;
   private static final Logger logger = Logger.getGlobal();
     
    public MateriaisTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
      logger.info("getting singleton...");
      sone = Materiais.getInstance();
      logger.log(Level.INFO, "...got singleton: {0}", sone);
      logger.info("getting singleton...");
      stwo = Materiais.getInstance();
      logger.log(Level.INFO, "...got singleton: {0}", stwo);    
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testUnique() {
      logger.info("checking singletons for equality");
      Assert.assertEquals(true, sone == stwo);
   }


    /**
     * Test of inserirMaterial method, of class Materiais.
     */
    @Test
    public void testInserirMaterial() {
        System.out.println("inserirMaterial");
        Materiais instance = Materiais.getInstance();
        instance.inserirMaterial("Ferro", 80.2F);
        instance.inserirMaterial("Cobre", 401F);
        instance.inserirMaterial("Vidro", 0.79F);
        assertTrue("Ferro tem condutividade 80.2", instance.obterCondutividade("ferro")==80.2F);
        assertTrue("Vidro tem condutividade 0.79", instance.obterCondutividade("vidro")==0.79F);
        assertTrue("Cobre não tem condutividade 10", instance.obterCondutividade("ferro")!=10F);
    }

    /**
     * Test of obterCondutividade method, of class Materiais.
     */
    @Test
    public void testObterCondutividade() {
        System.out.println("obterCondutividade");
        String nomeMaterial = "";
        Materiais instance = null;
        float expResult = 0.0F;
        float result = instance.obterCondutividade(nomeMaterial);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
