package assembly_line;

import java.io.*;

class Dinâmico {
	static int NUM_LINE = 2;
	static int NUM_STATION = 6;

	static int min(int a, int b) {
		return a < b ? a : b;

	}

	static int assemblyProduct(int a[][], int t[][], int e[], int x[]) {
		int T1[] = new int[NUM_STATION];
		int T2[] = new int[NUM_STATION];
		int i;

		T1[0] = e[0] + a[0][0];
		T2[0] = e[1] + a[1][0];

		for (i = 1; i < NUM_STATION; ++i) {
			T1[i] = min(T1[i - 1] + a[0][i], T2[i - 1] + t[1][i] + a[0][i]);
			T2[i] = min(T2[i - 1] + a[1][i], T1[i - 1] + t[0][i] + a[1][i]);
		}

		return min(T1[NUM_STATION - 1] + x[0], T2[NUM_STATION - 1] + x[1]);
	}

	public static void main(String[] args) {
		int a[][] = { { 7, 9, 3, 4, 8, 4 }, { 8, 5, 6, 4, 5, 7 } };
		int t[][] = { { 0, 2, 3, 1, 3, 4 }, { 0, 2, 1, 2, 2, 1 } };
		int e[] = { 2, 4 }, x[] = { 3, 2 };

		System.out.println(assemblyProduct(a, t, e, x));

	}
}