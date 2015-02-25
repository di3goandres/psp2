/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uniandes.ecos.model;

import junit.framework.TestCase;

/**
 *
 * @author COCO
 */
public class SimpsonTest extends TestCase {
    
    public SimpsonTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of ObtenerP method, of class Simpson.
     */
    public void testObtenerP() {
        System.out.println("ObtenerP");
        Simpson instance = new Simpson(1.1D, 10D);
        
        double expResult = 0.350058636897201D;
        double result = instance.ObtenerP();
        
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and rem  fail("The test case is a prototype.");
    }

    /**
     * Test of CalcularFactorial method, of class Simpson.
     */
    public void testCalcularFactorial() {
        System.out.println("CalcularFactorial");
        double numero = 4.5D;
         Simpson instance = new Simpson(1.1D, 10D);
        double expResult = 11.63173;
        double result = instance.CalcularFactorial(numero);
        assertEquals(expResult, result, 0.00001);
        // TODO review the generated test code and remove the default call to fail.
    
    }
    
}
