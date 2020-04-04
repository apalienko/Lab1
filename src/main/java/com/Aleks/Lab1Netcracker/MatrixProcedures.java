package com.Aleks.Lab1Netcracker;

public class MatrixProcedures {

	public static Matrix multOneThr(Matrix m1, Matrix m2) {
		
		Integer m = m1.getM();
		Integer n = m2.getN();
		
		if(m1.getN() != m2.getM()) {
			return null;
		}
		
		Integer maxK = m1.getN();
		
		Matrix res = new Matrix(m, n);
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				
				Double resCell = 0.0;
				
				for(int k = 0; k < maxK; k++) {
					resCell = resCell + m1.getCell(i, k) * m2.getCell(k, j); 
				}
				
				res.setCell(i, j, resCell);
			}
		}
		
		return res;
	}
	
	public static Matrix multManyThr(Matrix m1, Matrix m2) {
		
		Integer m = m1.getM();
		Integer n = m2.getN();

		if(m1.getN() != m2.getM()) {
			return null;
		}

		Integer maxK = m1.getN();
		CalcThread[] threads = new CalcThread[maxK];
		
		Matrix res = new Matrix(m, n);
		
		Double[] column;
		
		
		for(int k = 0; k < maxK; k++) {
			
			column = new Double[m2.getM()];
			for(int i = 0; i < maxK; i++) {
				column[i] = m2.getCell(i, k);
			}
			
			threads[k] = new CalcThread(m1, column, k, res);
			threads[k].start();
			
		}
		
		/*
		for(int i = 0; i < maxK; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/*
		for(int k = 0; k < m; k++) {
			
			line = new Double[m];
			
			for(int i = 0; i < m; i++) {
				line[i] = m1.getCell(i, k);
				column[i] = m2.getCell(k, i);
			}
			
			threads[k] = new CalcThread(line, column, k, res);
			threads[k].start();
		}
		
		for(int i = 0; i < countOfProc; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		*/
		
		
		return res;
		
	}
	
}
