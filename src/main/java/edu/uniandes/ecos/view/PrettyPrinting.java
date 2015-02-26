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

package edu.uniandes.ecos.view;

import edu.uniandes.ecos.model.Simpson;
import java.util.LinkedList;
import java.util.List;

/**
* 
* @author Diego Andres Montealegre Garcia
* @version 1.0, 02/22/05
* @since 1.0
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
