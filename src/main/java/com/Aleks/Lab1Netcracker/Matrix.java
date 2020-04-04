package com.Aleks.Lab1Netcracker;

import java.util.Random;

public class Matrix {

	// Matrix size
	Integer n, m;
	
	Double mtr[][];
	
	/**
	 * Creates matix with random values
	 * 
	 * @param m number of lines
	 * @param n number of columns
	 * @param rangeMin min value
	 * @param rangeMax max value
	 */
	public Matrix(Integer m, Integer n, Double rangeMin, Double rangeMax){
		Random r = new Random();
		
		this.m = m;
		this.n = n;
		
		mtr = new Double[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				mtr[i][j] = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			}
		}
	}
	
	/**
	 * Creates matrix with all values equals zero
	 * 
	 * @param m number of lines
	 * @param n number of columns
	 */
	public Matrix(Integer m, Integer n) {
		mtr = new Double[m][n];
		
		this.m = m;
		this.n = n;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				mtr[i][j] = 0.0;
			}
		}
	}
	
	/**
	 * @return number of lines
	 */
	public Integer getM() {
		return m;
	}
	
	/**
	 * @return number if columns
	 */
	public Integer getN() {
		return n;
	}
	
	/**
	 * @param i line position 
	 * @param j column position
	 * @return  cell of the matrix at [i,j] position
	 */
	public Double getCell(Integer i, Integer j) {
		return mtr[i][j];
	}
	
	/**
	 * @param i line position 
	 * @param j column position
	 * @param value shoulb be set at [i,j] position
	 */
	public void setCell(Integer i, Integer j, Double value) {
		mtr[i][j] = value;
	}
	
	
}
