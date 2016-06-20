import javax.swing.*;

public class PageRank {
	static int t = new Integer(JOptionPane.showInputDialog("Tregoni numrin e rreshtave(shtyllave) te matrices: ")).intValue();
	static int[][] v = new int[t][t];
	static double[][] rez = new double[t][t];

	public static void main(String[] args) {
		int t1 = new Integer(JOptionPane.showInputDialog("Sa faqe keni per ti vizituar: ")).intValue();

		for (int i = 0; i < t1; i++) {
			int h1 = new Integer(JOptionPane.showInputDialog("Lidhni faqen numer: ")).intValue();
			int h2 = new Integer(JOptionPane.showInputDialog(" me faqen numer: ")).intValue();
			v[h1][h2]++;
		}

		System.out.println("Matrica: ");

		for (int i = 0; i < t; i++) {
			for (int j = 0; j < t; j++) {
				int l = rreshti(i);
				if (l == 0) {
					l = 1;
				}
				rez[i][j] = v[i][j] * (90.0 / l) + 2;
				System.out.print(rez[i][j] + "      ");
				if (j == t - 1) {
					System.out.println();
				}
			}
		}

	}

	public static int rreshti(int x) {
		int shuma = 0;
		for (int i = 0; i < t; i++) {
			shuma = shuma + v[x][i];
		}
		return shuma;
	}
}
