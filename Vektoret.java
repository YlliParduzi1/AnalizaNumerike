
import javax.swing.*;

public class Vektoret {
   public static int k = new Integer(JOptionPane.showInputDialog("Numri i rreshtave(shtyllave)"));
   public static int hyrja = new Integer(JOptionPane.showInputDialog("Shtyp 1 per Vektor \nShtyp 2 per Matric "));
   public static double[] vector = new double[k];
   public static double[] vector1 = new double[k];
   public static double[][] A = new double[k][k];

   public Vektoret() {
      switch(hyrja){
      
         case 1 : 
            {
               for (int i = 0; i < vector.length; i++) {
                  int hyrje = new Integer(JOptionPane.showInputDialog("Shtype vleren e vektorit te pare ne poziten :  " + i));
                  vector[i] = hyrje;
               }
               for (int i = 0; i < vector1.length; i++) {
                  double hyrje = new Double(JOptionPane.showInputDialog("Shtype vleren e vektorit te dyt ne poziten :  " + i));
                  vector1[i] = hyrje;
               }
               int hyrja = new Integer(JOptionPane.showInputDialog("Shtyp 1 per te gjetur L2 dhe L-infinit normen\n" + "Shtyp 2 per te gjetur distancen ne mes dy vektorve L2 dhe L-infinit "));
               if (hyrja == 1) {
                  System.out.print("L_2 norma per vektorin = (");
                  for (int i = 0; i < vector.length; i++) {
                     System.out.print(vector[i] + ", ");
                  }
                  System.out.println("), L_2 = " + l2Norm(vector));
                  System.out.print("L_infinit norm for vector = (");
                  for (int i = 0; i < vector.length; i++) {
                     System.out.print(vector[i] + ", ");
                  }
                  System.out.println("), L_infinit = " + lInfinit(vector));
               } 
               else {
                  System.out.print("L_2 norma dhe L_infinit distanca per vektorin 1  = (");
                  for (int i = 0; i < vector.length; i++) {
                     System.out.print(vector[i] + ", ");
                  }
                  System.out.print("), dhe  vektori 2 = (");
                  for (int i = 0; i < vector1.length; i++) {
                     System.out.print(vector1[i] + ", ");
                  }
                  System.out.println("), \ndistanca L2 = " + distanceBetweenTwoVectorsL2(vector, vector1) + "\n" + "distanca-Linfinit = " + distanceBetweenTwoVectorsLinfinit(vector, vector1));
               }
            }
         
         case 2 : 
            {
               for (int i = 0; i < A.length; i++) {
                  for (int j = 0; j < A[0].length; j++) {
                     A[i][j] = new Integer(JOptionPane.showInputDialog("Shtyp vleren e matrices ne poziten : " + i + ", " + j));
                  }
               }
               int hyrja = new Integer(JOptionPane.showInputDialog("Shtyp 1 per ta qetur L-infinit normen\n shtyp 2 per ta qetur normen Forbenius "));
               if(hyrja == 1)
               {
                  for (int i = 0; i < A.length; i++) {
                     System.out.print("|");
                     for (int j = 0; j < A.length; j++) {
                        System.out.print(A[i][j] + "  ");
                     }
                     System.out.println("|");
                  }
                  System.out.println("Norma L-infinit e matrices per matricen e dhen eshte : " + lInfinitNormMatrix(A));
               }
               if(hyrja == 2)
               {
                  for (int i = 0; i < A.length; i++) {
                     System.out.print("|");
                     for (int j = 0; j < A.length; j++) {
                        System.out.print(A[i][j] + "  ");
                     }
                     System.out.println("|");
                  }
               
                  System.out.println("Norma Forbenius per matricen e dhen eshte : " + forbeniusNorm(A));}
            }
         default : 
            {System.exit(0);}
      }
   }
 
   public static void fillMatrix() {
      for (int i = 0; i < A.length; i++) {
         for (int j = 0; j < A[0].length; j++) {
            A[i][j] = new Integer(JOptionPane.showInputDialog("Shtyp vleren e matrices ne Poziten : " + i + ", " + j));
         }
      }
   
   }
//----------------------------------------------------------------------------------------------------
   public static void shumaEmatricave(int[][] A, int[][] B) {
      if ((A.length == B.length) && (A[0].length == B[0].length)) {
         for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
               int[][] C = new int[A.length][A[0].length];
               C[i][j] = A[i][j] + B[i][j];
               System.out.print(C[i][j] + "  ");
            }
            System.out.println();
         }
      } 
      else {
         System.err.println("Gabim ");
      }
   }
//----------------------------------------------------------------------------------------------------
   public static void shumaEvektorve(int[] vector, int[] vectorB) {
      for (int i = 0; i < vectorB.length; i++) {
         int[] shuma = new int[vector.length];
         shuma[i] = vector[i] + vectorB[i];
      }
   }
//----------------------------------------------------------------------------------------------------
   public static double getMaxValue(double[] vector) {
      double max = Math.abs(vector[0]);
      for (int i = 1; i < vector.length; i++) {
         if (Math.abs(vector[i]) > Math.abs(max)) {
            max = Math.abs(vector[i]);
         }
      }
      return max;
   }
//----------------------------------------------------------------------------------------------------
    

   public static double lInfinit(double[] A) {   
      return getMaxValue(A);
   }
//----------------------------------------------------------------------------------------------------
   public static double l2Norm(double[] A) {
      double rez = 0.0;
      for (int i = 0; i < vector.length; i++) {
         rez += Math.pow(vector[i], 2);
      }
      return Math.sqrt(rez);
   }
//----------------------------------------------------------------------------------------------------
   public static double distanceBetweenTwoVectorsL2(double[] A, double[] B) {
      double rez = 0.0;
      for (int i = 0; i < A.length; i++) {
         rez += Math.pow((A[i] - B[i]), 2);
      }
      return Math.sqrt(rez);
   }
//----------------------------------------------------------------------------------------------------
   public static double distanceBetweenTwoVectorsLinfinit(double[] A, double[] B) {
      double rez = Math.abs(A[0] - B[0]);
   
      for (int i = 1; i < A.length; i++) {
      
         if (Math.abs(A[i] - B[i]) > Math.abs(rez)) {
            rez = Math.abs(A[i] - B[i]);
         }
      }
      return rez;
   
   }
//----------------------------------------------------------------------------------------------------
   public static double lInfinitNormMatrix(double[][] A) {
      double[] rez = new double[A.length];
      for (int i = 0; i < A.length; i++) {
         for (int j = 0; j < A.length; j++) {
            rez[i] += Math.abs(A[i][j]);
         }
      }
      return getMaxValue(rez);
   }
//----------------------------------------------------------------------------------------------------
   public static double forbeniusNorm(double[][] A) {
      double rez = 0.0;
      for (int i = 0; i < A.length; i++) {
         for (int j = 0; j < A.length; j++) {
            rez += Math.pow(Math.abs(A[i][j]), 2);
         }
      }
      return Math.sqrt(rez);
   }
//----------------------------------------------------------------------------------------------------
   public static void main(String[] args) {
      new Vektoret();
   }
}
//----------------------------------------------------------------------------------------------------