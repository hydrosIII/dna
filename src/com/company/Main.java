package com.company;



import java.util.Arrays;

public class Main {

    public void main{


    }


    public  void creatematrix(String[] args) {
        String[] dna = {"AAAAGA", "CAGTGC", "TTATGT", "AGAAGG", "TCACTG", "CCCTAT"};
        // obtain matrix dimensions from string array.

        // Counter no know coincidences in dna.
        int contador = 0;
        // medidas de la matriz
        int x = dna.length;
        int y = dna[1].length();
        // rows es x
        //columnas es y
        // creates memory space of matrix
        int[][] dnamatrix;
        dnamatrix = new int[x][y];
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

        System.out.println(dnastring);
        System.out.println(Arrays.toString(intArray));


/// constructs the matrix from the string array

        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++) {
                dnamatrix[i][j] = intArray[j % y + i * y];

            }
        return dnamatrix;
    }
        System.out.println(Arrays.deepToString(dnamatrix));


        // algorithm to see of there are tow letters repeated.

// busca en x




        //for (int row = 0; row < x; row++) {
        //int contadorfila = 0;
        //{
        //int fila[] = dnamatrix[row];
        //for (int character = 0; character < fila.length; character++) {
        //int comp = (character + 1);
        //System.out.println(comp);
        //System.out.println(fila[character]);

        //while (comp <= x) {
        //      System.out.println(fila[character]);

        //}
        //if (fila[character] == fila[comp])

        int contadorfila = 0;
        //System.out.println(contadorfila);

        public void cuentafilas(dnamatrix, x, y, contador) {

        for (int k = 0; k < y; k++) {
            //int contadorfila = 0;
            if (contadorfila >= 3)
                contador = contador + 1;
            for (int l = 0; l < x; l++) {
                int g = l + 1;
                if (g == x)
                    return;if (dnamatrix[k][l] == dnamatrix[k][g])
                    contadorfila = contadorfila + 1;


            }

        }
    }

    public void cuentacolumnas(dnamatrix, x, y, contador){

            for (int k = 0; k < y; k++) {
                //int contadorfila = 0;
                if (contadorfila >= 3)
                    contador = contador + 1;
                for (int l = 0; l < x; l++) {
                    int g = l + 1;
                    if (g == x)
                        return;
                    if (dnamatrix[k][l] == dnamatrix[k][g])
                        contadorfila = contadorfila + 1;


                }

            }

            }

        System.out.println(contadorfila);
        System.out.println(contador);

    }
}




//
 //           if (contadorfila >= 4)

   //             contador = contador + 1;

     //   }
    //}
//}

 //       System.out.println(contador);

// busca en y

        //    for(int k =0 ; k < x ; k++) {
        //       int contadorcolumna = 0;
        //       for (int l = 0; l < y; l++) {
        //          if (dnamatrix[k][l] == dnamatrix[k][l-1])
        //              contadorcolumna = contadorcolumna + 1;
        //     }
        //    if (contadorcolumna >= 4)
        //       contador = contador + 1;

//        }

        //  }







