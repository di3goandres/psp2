/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uniandes.ecos.view;

import edu.uniandes.ecos.model.Simpson;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author COCO
 */
public class PrettyPrinting {
     public static void main(String[] args) {
        test1();
    }

    public static void test1() {

      
        Simpson calculos = new Simpson(9, 1.1, 10);
         System.out.println("integral Definitiva:" + calculos.ObtenerP());
    }

    
}
