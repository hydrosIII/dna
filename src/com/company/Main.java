package com.company;


import java.util.Arrays;

// there could be bugs due to the implementation of variables x and y and the java counter in 0. Needs some rechecking.

public class Main {

    static String[] dna = {"AAAAGA", "CAGTGC", "TTATGT", "AGAAGG", "TCACTG", "CCCTAT"};
    // Counter no know coincidences in dna.
    static int contador = 0;
    // // obtain matrix dimensions from string array.
    static int x = (dna.length -1); // counts from 0
    static int y = (dna[1].length()-1); // counts from 0
    /// initiziles the matrix in memory
    static int[][] dnamatrix = new int[x+1][y+1];
    //static boolean mutante = new boolean[];


    public static boolean main(String[] args) {
        creatematrix(dna);

        // if you want to print the newly created matrix, uncomment this line.
        //System.out.println(Arrays.deepToString(dnamatrix));


        cuentafilas();
        cuentacolumnas();
        cuentadiagonalesy();
        cuentadiagonalesx();

        /// If you wnat to know how many adjacent 4 letters count, uncomment this line.

        //System.out.println(contador);


        if (contador >= 2) {
            //System.out.println("Mutante!!");
            return true;
        }

        else return false;

            //System.out.println("No mutante");


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



        for (int i = 0; i < x + 1; i++)
            for (int j = 0; j < y + 1; j++) {
                dnamatrix[i][j] = intArray[j % (y + 1) + i * (y + 1)];

            }
        return dnamatrix;
    }



    public static int cuentafilas() {

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
        //System.out.println("las diagonales");
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


                contadordiagonal = 0;

                if (t == y  || z == x  ) //defines the boundaries of the matrix
                    break;

                while (dnamatrix[f][r] == dnamatrix[t][z]) {  //check diagonals starting from 0, then with the for loop it moves to the next column.
                    contadordiagonal = contadordiagonal + 1;


                    if (t == y   || z == x ) // defines the boundaries of the matrix
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

// same method as above but starting from the other side
    // then going backwards

    public static int cuentadiagonalesx() {
        //System.out.println("las diagonales x");
        int contadordiagonalx = 0;

        for (int k = 0; k < y; k++) {


            for (int l = x; l >= 0; l--) {
                int g = l - 1; /// variables for diagonals
                int h = k + 1;

                /// variables for the while loop
                int r = l;
                int f = k;
                int t = h;
                int z = g;

                contadordiagonalx = 0;
                if (t == y  || z == 0  ) //defines the boundaries of the matrix
                    break;
                while (dnamatrix[f][r] == dnamatrix[t][z]) {  //check diagonals starting from 0, then with the for loop it moves to the nest column.
                    contadordiagonalx = contadordiagonalx + 1;
                    //System.out.println(contadordiagonalx);

                    if (t == y  || z == 0 ) // defines the boundaries of the matrix
                        break;
                    if (contadordiagonalx >= 3) {
                        contador = contador + 1;
                        break;}
                    f = f + 1;
                    r = r - 1;
                    t = t + 1;
                    z = z - 1;

                }

            }





        }

        return contadordiagonalx;
    }


}
