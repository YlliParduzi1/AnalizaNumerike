public class SOR 
{
		public static double[] MetodaSor(double[][] A, double[] B, double[] X0, double w, int N, double TOL) 
	{
		double sum = 0;
		int k = 1;
		double[] x = new double[A.length];
		while (k <= N) 
		{
			for (int i = 0; i < A.length; i++) 
			{
				sum = 0;
				for (int j = 0; j < A.length; j++) 
				{
					if (j!=i) 			
					{sum = sum + A[i][j]*X0[j];}
				}
				x[i] = (1 - w) * X0[i] + (w * (B[i] - sum)) / A[i][i];
				if (distancaLinfinit(x, X0) < TOL) 
				{return x;}
				X0[i] = x[i];
			}
		k++;
		}
		return x;
	}
	
	
	public static double distancaLinfinit(double[] v1,double[] v2)
	{
		double max = Math.abs(v1[0] - v2[0]);
		for(int i=1;i<v1.length;i++)
		{
			if(max<Math.abs(v1[i] - v2[i]))
			{max = Math.abs(v1[i] - v2[i]);}
		}
		return max;
	}
	
	

	public static void main(String[] args)
	{
		double[][] A = { { 3, 2, 5 }, { 8, 4, 2 }, { 13, -6, 2 } };
		double[] B = { 13, 11, -16 };
		double[] X = { 1, 1, 1 };
      double Tol = 0.00000000001;
      double w = 1.25;
		double[] result = MetodaSor(A, B, X, w, 7,Tol);	
		System.out.println("Zgjidhja e perafruar eshte ");
			for(int j=0;j<result.length;j++)
			{
				System.out.print(result[j]+"\t");
			}
	}
}
