package com.company;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.util.Arrays;


public class Main {

    static String[] dna = {"AAAAGA", "CAGTGC", "TTATGT", "AGAAGG", "TCACTG", "CCCTAT"};
    // Counter no know coincidences in dna.
    static int contador = 0;
    // // obtain matrix dimensions from string array.
    static int x = (dna.length -1); // counts from 0
    static int y = (dna[1].length()-1); // counts from 0
    /// initiziles the matrix in memory
    static int[][] dnamatrix = new int[x][y];
    //static boolean mutante = new boolean[];


    public static void main(String[] args) {
        creatematrix(dna);

        System.out.println(Arrays.deepToString(dnamatrix));


        cuentafilas();
        //if (contador == 2)
        //    return
        cuentacolumnas();
        cuentadiagonalesy();

        System.out.println(contador);

    }


    public static int[][] creatematrix(String[] args) {
        int[] ejemplo = new int[10];
        // changes the array into string and changes number to letters.
        String dnastring = Arrays.toString(dna)
                .replace(",", "")
                .replaceAll("\\s+", "")
                .replace("A", "1")
                .replace("C", "2")
                .replace("G", "3")
                .replace("T", "4")
                .replace("[", "")
                .replace("]", "");


        // Converts the string to an array of numbers
        int strLength = dnastring.length();
        int[] intArray = new int[strLength];
        for (int m = 0; m < strLength; m++) {
            intArray[m] = Integer.parseInt(String.valueOf(dnastring.charAt(m)));
        }



        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++) {
                dnamatrix[i][j] = intArray[j % y + i * y];

            }
        return dnamatrix;
    }



    public static int cuentafilas() {
        //int[][] dnamatrix;
        //dnamatrix = new int[x][y];
        int contadorfila = 0;
        for (int k = 0; k < y; k++) {
            //int contadorfila = 0;
            if (contadorfila >= 3)
                contador = contador + 1;
            contadorfila = 0;
            for (int l = 0; l < x; l++) {
                int g = l + 1;
                if (g == x)
                    break;
                if (dnamatrix[k][l] == dnamatrix[k][g])
                    contadorfila = contadorfila + 1;


            }

        }
       return contadorfila;

    }


    public static int cuentacolumnas() {
        //int[][] dnamatrix;
        //dnamatrix = new int[x][y];
        int contadorcolumna = 0;
        for (int k = 0; k < x; k++) {
            if (contadorcolumna >= 3)
                contador = contador + 1;
            contadorcolumna = 0;
            for (int l = 0; l < y; l++) {
                int g = l + 1;
                if (g == x)
                    break;
                if (dnamatrix[k][l] == dnamatrix[k][g])
                    contadorcolumna = contadorcolumna + 1;
            }


        }

        return contadorcolumna;

    }


    public static int cuentadiagonalesy() {
        System.out.println("las diagonales");
        int contadordiagonal = 0;

        for (int k = 0; k < y; k++) {


            for (int l = 0; l < x; l++) {
                int g = l + 1; /// variables for diagonals
                int h = k + 1;

                /// variables for the while loop
                int r = l;
                int f = k;
                int t = h;
                int z = g;

                //if (contadordiagonal >= 3) // agrega al contador final
                //    contador = contador + 1;
                System.out.println(contadordiagonal);
                contadordiagonal = 0;

                if (t == x  || z == y  ) //defines the boundaries of the matrix
                    break;

                while (dnamatrix[f][r] == dnamatrix[t][z]) {  //check diagonals starting from 0, then with the for loop it moves to the nest column.
                    contadordiagonal = contadordiagonal + 1;
                    System.out.println(contadordiagonal);

                    if (z == x  || t == y ) // defines the boundaries of the matrix
                        break;
                    if (contadordiagonal >= 3) {
                    contador = contador + 1;
                    break;}
                    f = f + 1;
                    r = r + 1;
                    t = r + 1;
                    z = z + 1;

                }

            }





        }

        return contadordiagonal;
    }
}





















