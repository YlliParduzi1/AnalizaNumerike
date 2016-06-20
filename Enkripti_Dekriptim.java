

import javax.swing.*;

public class Enkripti_Dekriptim {

    public static int[][] answer = new int[3][3];

    public char[] G = new char[27];
    char c = 'A';

    public Enkripti_Dekriptim(int[][] A, int[][] B) {
        for (int o = 0; o < 27; o++) {
            {
                G[o] = c;
                c++;
            }
            int rows = A.length;
            int cols = B[0].length;
            if (A[0].length != B.length) {
                System.exit(0);
            } else {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        int sum = 0;
                        for (int k = 0; k < B.length; k++) {
                            sum += ((A[i][k]) * (B[k][j]));
                        }
                        answer[i][j] = sum % 27;
                        if (answer[i][j] < 0) {
                            answer[i][j] += 27;
                        }

                    }
                }

            }
        }
    }



    public static void main(String[] args) {

       String input = JOptionPane.showInputDialog("Shkruaj fjaline per enkriptim vetmem per 9 - karakter").toUpperCase();
        char[] c = new char[9];
        int[][] plain = new int [3][3];
        int[][] key = {{1, 2, 1}, {0, 1, 1}, {1, 2, 0}};
        Enkripti_Dekriptim encrypt = new Enkripti_Dekriptim(plain, key);   
        int[][] plainMatrix = {{((int)(input.charAt(0)))%65,((int)(input.charAt(1)))%65,((int)(input.charAt(2)))%65},
            {((int)(input.charAt(3)))%65,((int)(input.charAt(4)))%65,((int)(input.charAt(5)))%65},
            {((int)(input.charAt(6)))%65,((int)(input.charAt(7)))%65,((int)(input.charAt(8)))%65}};
        
        Enkripti_Dekriptim encryptT = new Enkripti_Dekriptim(plainMatrix, key);

        System.out.println("===============================" + "\n" + "Teksti i enkriptuar:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(encryptT.G[answer[i][j]] + " ");
            }
            System.out.println();
        }
        int[][] keyinverse = {{2, -2, -1}, {-1, 1, 1}, {1, 0, -1}};
        int[][] cipherMatrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cipherMatrix[i][j] = answer[i][j];
            }
        }
        Enkripti_Dekriptim decryption = new Enkripti_Dekriptim(cipherMatrix, keyinverse);
        System.out.println("=================================" + "\n" + "Teksti i dekriptuar:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(decryption.G[answer[i][j]] + " ");
            }
            System.out.println();
        }
        System.out.println("=================================");
    }
}
