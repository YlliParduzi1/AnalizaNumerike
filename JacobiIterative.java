
public class JacobiIterative {

	public static void metoda(double[][] A, double[] B, double[] X, double TOL, int N) {
		int k = 1;
		double sum = 0;
		double[] x = new double[A.length];
		while (k <= N) {
			for (int i = 0; i < A.length; i++) {
				sum = 0;
				for (int j = 0; j < A.length; j++) {
					if (j != i) {
						sum += A[i][j] * X[j];
						x[i] = (B[i] - sum) / A[i][i];

					}
				}
				if (distanceBetweenTwoVectorsLinfinit(x, X) < TOL) {
					
					System.exit(0);
				}
			}
			
			for (int i = 0; i < A.length; i++) {
				X[i] = x[i];
				System.out.print(x[i] + "  ");
				if ((i + 1) % A.length == 0) {
					System.out.println();
				}

			}

		}
		k++;
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
		double[] X = new double[A.length];
		double[] B = { 6, 25, -11, 15 };
		int N = 10;
		double TOL = 1E-3;
		metoda(A, B, X, TOL, N);
	}

}
