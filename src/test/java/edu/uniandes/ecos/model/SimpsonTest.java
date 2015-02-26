/*
 * Copyright (C) 2015 Diego Andres Montealegre Garcia
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
        Simpson instance = new Simpson(9, 1.1D, 10D);
        
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
         Simpson instance = new Simpson();
        double expResult = 11.63173;
        double result = instance.CalcularFactorial(numero);
        assertEquals(expResult, result, 0.00001);
        // TODO review the generated test code and remove the default call to fail.
    
    }
    
}
