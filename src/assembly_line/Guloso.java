package assembly_line;

import java.io.*;

class Guloso {
	static int NUM_LINE = 2;
	static int NUM_STATION = 4;

	static int min(int a, int b) {
		return a < b ? a : b;

	}

	static int assemblyProduct(int a[][], int t[][], int e[], int x[]) {
		int j = 0;
		int t0 = e[0] + a[0][j]; 
		int t1 = e[1] + a[1][j];
		int totalTime = min(t0, t1);
		int i = t0 < t1 ? 0 : 1;	
		for (j = 0; j < NUM_STATION-1; j++) {
			//System.out.println("linha=" + i + " estação=" + j);
			if (i == 0) {
				t1 = a[1][j+1] + t[0][j+1];
				t0 = a[0][j+1];				
			} else if (i == 1) {
				t0 = a[0][j+1] + t[1][j+1];
				t1 = a[1][j+1];								
			}
 			totalTime += min(t0, t1);
			i = t0 < t1 ? 0 : 1;			
		}		
		totalTime += x[i];
		return totalTime;
	}

	public static void main(String[] args) {
		int a[][] = { { 1, 1, 1, 20 }, 
				      { 1, 1, 10, 2 } };
		int t[][] = { { 0, 0, 0, 20 }, 
				      { 0, 0, 0, 0 } };
		int e[] = { 1, 0 };
		int x[] = { 0, 0 };

		System.out.println(assemblyProduct(a, t, e, x));
	}
}