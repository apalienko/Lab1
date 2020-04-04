package com.Aleks.Lab1Netcracker;

public class CalcThread extends Thread{

	Matrix m1;
	Double[] column;
	Integer j;
	Matrix res;
	
	public CalcThread(Matrix m1, Double[] column, Integer j, Matrix res) {
		this.m1 = m1;
		this.column = column;
		this.res = res;
		this.j = j;
	}
	
	@Override
    public void run() {
		Double value = 0.0;
		
		for(int i = 0; i < m1.getM(); i++) {
			
			for(int k = 0; k < m1.getN(); j++) {
				value = value + m1.getCell(i, k) * column[k];
			}
			
			res.setCell(i, j, value);
		}
    }
	
}
