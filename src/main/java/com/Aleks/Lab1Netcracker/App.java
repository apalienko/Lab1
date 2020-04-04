package com.Aleks.Lab1Netcracker;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        BigDecimal timeStart;
		BigDecimal nanos;
		BigDecimal millis;
		
    	Integer m1 = 500;
    	Integer n2 = 600;
    	Integer mn = 400;
    	
        System.out.println("Creating two matrix");
        
        Matrix matr1 = new Matrix(m1, mn, 0.0, 100.0);
        Matrix matr2 = new Matrix(mn, n2, 0.0, 100.0);

        Matrix resMatr;
        
        System.out.println("Starting to multiply in one thread");
        
		timeStart = new BigDecimal(System.nanoTime());
        
        resMatr = MatrixProcedures.multOneThr(matr1, matr2);
        
        nanos = new BigDecimal(System.nanoTime()).subtract(timeStart);
		millis = nanos.divide(new BigDecimal(1000000));
		
		System.out.println("Время выполнения: " + millis + " милисекунд");
        
        System.out.println("Ended multiplying in one thread");
        
        System.out.println("Starting to multiply in many thread");
        timeStart = new BigDecimal(System.nanoTime());
        
        resMatr = MatrixProcedures.multManyThr(matr1, matr2);
        
        nanos = new BigDecimal(System.nanoTime()).subtract(timeStart);
		millis = nanos.divide(new BigDecimal(1000000));
		
		System.out.println("Время выполнения: " + millis + " милисекунд");
    }
}
