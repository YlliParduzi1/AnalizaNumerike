public class GaussSeidelIterative {

	public static void metoda(double[][] A, double[] B, int N, double TOL, double[] X) {
		int k = 1;
		double sum1 = 0;
		double sum2 = 0;
		double[] x = new double[A.length];
		while (k <= N) {
			for (int i = 0; i < A.length; i++) {
				sum1 = 0;
				sum2 = 0;
				for (int j = 0; j <= i - 1; j++) {
					sum1 += A[i][j] * x[j];
				}
				for (int c = i+1; c < A.length; c++) {
					sum2 += A[i][c] * X[c];
				}
				x[i] = (B[i] - sum1 - sum2) / A[i][i];
				
				  if (distanceBetweenTwoVectorsLinfinit(x, X) < TOL) {
				  System.exit(0); }
				
				X[i] = x[i];
				System.out.print(x[i] + "    ");

				if ((i+1)%A.length == 0) {
					System.out.println();

				}

			}
			k++;

		}

	}

	public static double distanceBetweenTwoVectorsLinfinit(double[] A, double[] B) {
		double rezultati = Math.abs(A[0] - B[0]);

		for (int i = 0; i < A.length; i++) {

			if (Math.abs(A[i] - B[i]) > Math.abs(rezultati)) {
				rezultati = Math.abs(A[i] - B[i]);
			}
		}
		return rezultati;

	}

	public static void main(String[] args) {
		double[][] A = { { 10, -1, 2, 0 }, { -1, 11, -1, 3 }, { 2, -1, 10, -1 }, { 0, 3, -1, 8 } };
		double[] B = { 6, 25, -11, 15 };
		double[] X = new double[A.length];
      double toleranca = 0.001;
		metoda(A, B, 6, toleranca, X);
	}

}
