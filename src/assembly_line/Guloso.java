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
		for (j = 0; j < NUM_STATION - 1; j++) {
			if (i == 0) {
				t1 = a[1][j + 1] + t[0][j + 1];
				t0 = a[0][j + 1];
			} else if (i == 1) {
				t0 = a[0][j + 1] + t[1][j + 1];
				t1 = a[1][j + 1];
			}
			totalTime += min(t0, t1);
			i = t0 < t1 ? 0 : 1;
		}
		totalTime += x[i];
		return totalTime;
	}

	public static void main(String[] args) {
		int a[][] = { { 7, 9, 3, 4, 8, 4 }, 
					  { 8, 5, 6, 4, 5, 7 } };
		int t[][] = { { 2, 3, 1, 3, 4 }, 
				      { 2, 1, 2, 2, 1 } };
		int e[] = { 2, 4 }, x[] = { 3, 2 };
		System.out.println(assemblyProduct(a, t, e, x));
	}
}