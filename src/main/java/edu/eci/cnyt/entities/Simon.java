package edu.eci.cnyt.entities;

public class Simon {

    public static void simonAlg () {
        int[][] mat = new int[64][64];

        for (int j = 0; j < mat.length; j++) {
            for (int i = 0; i < mat.length; i++) {
                int xIn = j>>3;
                int tIn = calcFunc(xIn);
                int yIn = calcY(j);

                int xOut = i>>3;
                int tOut = calcFunc(xOut);
                int yOut = calcY(i);
                boolean xor = (yIn^tIn) == yOut;
                if(xIn == xOut && xor){
                    mat[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if(mat[i][j] ==1) System.out.print("-");
                System.out.print(mat[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }



    }

    public static int calcFunc(int x){

        if (x == 0) return 0;
        if (x == 1) return 7;
        if (x == 2) return 7;
        if (x == 3) return 0;
        if (x == 4) return 4;
        if (x == 5) return 1;
        if (x == 6) return 1;
        if (x == 7) return 4;


        return x;
    }

    public static int calcY(int j){


        int temp = j >> 3;
        temp = temp << 3;
        int y = j^temp;
        return y;
    }
}
