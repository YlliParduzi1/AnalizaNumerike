
public class Newton
{
	// L2 norma e vektorve
   public static double norma2eVektorit(double[] vector)
   {
      double rezultati = 0;
      for(int i=0;i<vector.length;i++)
      {
         rezultati = rezultati + Math.pow(vector[i], 2);
      }
      return Math.sqrt(rezultati);
   }
	
   public static double[][] zbritMatricat(double[][] matrix1,double[][] matrix2)
   {
      double[][] result = new double[matrix1.length][matrix1.length];
      for(int i=0;i<matrix1.length;i++)
      {
         for(int j=0;j<matrix1.length;j++)
         {
            result[i][j] = matrix1[i][j] - matrix2[i][j];
         }
      }
      return result;
   }
	
	// Matrica inverze e rendit 3
   public static double[][] matricaInverze(double[][] A) {
      double[][] rez = new double[3][3];
      double detA = A[0][0] * A[1][1] * A[2][2] + A[0][2] * A[1][0] * A[2][1]
         		+ A[2][0] * A[1][2] * A[0][1]- A[2][0] * A[1][1] * A[0][2] 
         		- A[2][2] * A[1][0] * A[0][1] - A[0][0] * A[2][1] * A[1][2]; 
                      
      rez[0][0] = 1 / detA * (A[1][1] * A[2][2] - A[2][1] * A[1][2]);
      rez[0][1] = 1 / detA * (A[0][2] * A[2][1] - A[2][2] * A[0][1]);
      rez[0][2] = 1 / detA * (A[0][1] * A[1][2] - A[1][1] * A[0][2]);
      rez[1][0] = 1 / detA * (A[1][2] * A[2][0] - A[2][2] * A[1][0]);
      rez[1][1] = 1 / detA * (A[0][0] * A[2][2] - A[2][0] * A[0][2]);
      rez[1][2] = 1 / detA * (A[0][2] * A[1][0] - A[1][2] * A[0][0]);
      rez[2][0] = 1 / detA * (A[1][0] * A[2][1] - A[2][0] * A[1][1]);
      rez[2][1] = 1 / detA * (A[0][1] * A[2][0] - A[2][1] * A[0][0]);
      rez[2][2] = 1 / detA * (A[0][0] * A[1][1] - A[1][0] * A[0][1]);
        
      return rez;
   }
	
   public static double[][] shumzoMatricat(double[][] A, double[][] B) 
   {
      double[][] rez = new double[A.length][B[0].length];
      for (int i = 0; i < A.length; i++) 
      {
         for (int j = 0; j < B[0].length; j++) 
         {
            for (int k = 0; k < A[0].length; k++) 
            {
               rez[i][j] += A[i][k] * B[k][j];
            }
         }
      }
      return rez;
   }
	
	
   public static double[][] funksioni(double x1,double x2,double x3)
   {
      double[][] rez = new double[3][3];		
      rez[0][0] = 3.0*x1 - Math.cos(x2*x3) - 1.0/2;
      rez[1][0] = x1*x1 - 81.0*Math.pow(x2+0.1,2) + Math.sin(x3) + 1.06;
      rez[2][0] = Math.exp(-x1*x2) + 20.0*x3 + (10*Math.PI - 3)/3.0;
      return rez;
   }
	
   public static double[][] derivatiIfunksionit(double x1,double x2,double x3)
   {
      double[][] rez = new double[3][3];
      rez[0][0] = 3;
      rez[0][1] = x3*Math.sin(x2*x3);
      rez[0][2] = x2*Math.sin(x2*x3);
      rez[1][0] = 2*x1;
      rez[1][1] = -162*(x2+0.1);
      rez[1][2] = Math.cos(x3);
      rez[2][0] = -1*x2*Math.exp(-1*x1*x2);
      rez[2][1] = -1*x1*Math.exp(-1*x1*x2);
      rez[2][2] = 20;
      return rez;
   }
	
	// kthen zgjidhjet xi te ekuacionit
   public static double[][] ekuacioneteNjutonit(int N, double[][] x, double TOL)
   {
      double[][] y = new double[x.length][x.length];
      int k = 0;
      while(k<N)
      {
         double[][] inverz = matricaInverze(derivatiIfunksionit(x[0][0],x[1][0],x[2][0]));
         y = shumzoMatricat(inverz,funksioni(x[0][0],x[1][0],x[2][0]));
         x = zbritMatricat(x,y);
         double[] y1 = {y[0][0],y[1][0],y[2][0]};
         if(norma2eVektorit(y1)<TOL)
         {
            return x;}
         k++;
      }
      return x;
   }
	
   // Main method 
   public static void main(String[] args)
   {
      double[][] A = {{0.1,0,0},	
         			    {0.1,0,0},
         		       {-0.1,0,0}};
      double Tol = 0.1;
      double[][] x = ekuacioneteNjutonit(6,A,Tol);
      System.out.println("Zgjidhjet "+"\n======================================");
      
      System.out.println("x1: "+x[0][0] + "\nx2: " +x[1][0] + "\nx3: " + x[2][0]);
      
      System.out.println("\n===============================================");
      System.out.println("Ekuacioni i pare "+(3.0 * x[0][0] - Math.cos(x[1][0] * x[2][0]) - 1.0 / 2)+" = 0"); 
      System.out.println("Ekuacioni i dyte "+(x[0][0] * x[0][0] - 81.0 * Math.pow(x[1][0] + 0.1, 2) + Math.sin(x[2][0]) + 1.06)+" = 0"); 
      System.out.println("Ekuacioni i tret  "+(Math.exp(-x[0][0]*x[1][0]) + 20.0*x[2][0] + (10*Math.PI - 3)/3.0)+" = 0"); 
      System.out.println("\n===============================================");
   }

}
