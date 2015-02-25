/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.model;

/**
 *
 * @author COCO
 */
public class Simpson {

    public double factorialnum = 0d;
    public double dof = 9d;
    private double parameterE = 0.00001;
    private double num_seg = 0;
    private double parameterW = 0;
    private double integralInicialP = 0;
    private double integralDefinitiva = 0;

    /**
     * Constructor de la clase
     *
     * @param dofP son los grados de libertad(degrees of freedom)
     * @param parameterXP parametro de la x que es necesario para los calculos
     * de hasta donde se debe ir
     * @param parameterNumSeg parametro numero de segmentos en los cuales se va
     * dividir
     */
    public Simpson(double parameterXP, double parameterNumSeg) {

        if (parameterNumSeg == 0) {
            this.integralDefinitiva = 0;
        } else {
            this.integralInicialP = Calcular(parameterXP, parameterNumSeg);
            parameterNumSeg *= 2;
            this.integralDefinitiva = Calcular(parameterXP, parameterNumSeg);

            double diferencia = Math.abs(integralInicialP - integralDefinitiva);

            while (diferencia > this.parameterE) {
                parameterNumSeg *= 2;
                this.integralInicialP = this.integralDefinitiva;
                this.integralDefinitiva = Calcular(parameterXP, parameterNumSeg);
                diferencia = Math.abs(integralInicialP - integralDefinitiva);
            }
        }

    }

    private Double Calcular(double parameterXP, double parameterNumSeg) {
        double calculos = 0d;
        this.num_seg = parameterNumSeg;

        this.parameterW = parameterXP / this.num_seg;
        double sumatorias = 0.0;
        double parameterF = 0;
        for (int i = 0; i <= this.num_seg; i++) {
            parameterF = this.parameterW;
            parameterF = parameterF * i;
            sumatorias += Multiplier(functionFx(parameterF), i);
        }
        calculos = (this.parameterW / 3) * sumatorias;
        return calculos;

    }

    /**
     * metodo que retorna ya el valor calculado del parametro P
     *
     * @return
     */
    public double ObtenerP() {

        return this.integralDefinitiva;
    }

    /**
     * Metodo que se encarga de calcular las funcion FX
     *
     * @param parameterX, recibe como parametro para el calculo la parte de x
     * que se requiere calcular
     * @return funcinoFx, retorna el resultado de todos los calculos para la
     * funcion Fx
     */
    private double functionFx(double parameterX) {
        double funcionFx = 0d;
        double partOne = 0d;
        double partTwo = 0d;
        partOne = ((CalcularFactorial((dof + 1) / 2))) / (Math.pow((dof * Math.PI), 0.5D) * (CalcularFactorial((dof / 2))));
        partTwo = Math.pow(((1 + ((Math.pow(parameterX, 2)) / this.dof))), ((-1) * ((dof + 1) / 2)));

        funcionFx = partOne * partTwo;
        return funcionFx;
    }

    /**
     * Metodo que se encarga de multiplicar si es par o impar
     *
     * @param parameterXP recibe como parametro el valor de X
     * @param segmentoActual de acuerdo al segmento actual se va calcular si es
     * par o impar para su respectiva multiplicacion
     * @return si es cero o es el ultimo segmento se retorna el parametro
     * parameterXP, tal cual como llego de lo contrario si es impar se
     * multiplica por el numero dos (2) de lo contrario por el numero cuatro (4)
     */
    private double Multiplier(double parameterXP, int segmentoActual) {
        int espar = segmentoActual / 2;
        espar = espar * 2;
        if (segmentoActual == 0 || segmentoActual == this.num_seg) {
            return parameterXP;
        } else {
            if (espar == segmentoActual) {
                return parameterXP * 2;
            } else {
                return parameterXP * 4;
            }
        }
    }

    /**
     * Metodo que encapsula el calculo del factorial
     *
     * @param numero es el numero el cual se le quiere hacer el factorial
     * @return el calculo del factorial de (n-1)!
     */
    public double CalcularFactorial(double numero) {
        return functionFactorial(numero - 1);
    }

    /**
     * Metodo recursivo para el calculo del factorial (n-1)! si el numero es 0.5
     * (1/2) el factorial se multiplca por raiz de pi
     *
     * @param numero numero al cual se le va hacer el calculo del factorial
     *
     * @return factorial de numero
     */
    private double functionFactorial(double numero) {
        double resultado = 0;
        if (numero == 0 || numero == 1) {
            return 1;
        } else if (numero == 0.5D) {
            return (double) numero * (Math.sqrt(Math.PI));
        } else {
            resultado = numero * functionFactorial(numero - 1);
        }
        return resultado;
    }

}
