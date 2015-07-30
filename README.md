A Matrix solving algorithm implemented in java.


If you pass a string to the Java class.

The string represent the DNA, and it has four different combinations using the ACTG, letters representing the nitrogen bases from DNA:



dna = {"AAAAGA", "CAGTGC", "TTATGT", "AGAAGG", "TCACTG", "CCCTAT"};


The method will construct the matrix, and search for 4 adjacent equal bases, either in the columns, rows or diagonals.

It counts these groups of 4 adjacent bases and return, Mutant if the algorithm finds 2 or more groups of 4, returns True if not it returns falsee.

