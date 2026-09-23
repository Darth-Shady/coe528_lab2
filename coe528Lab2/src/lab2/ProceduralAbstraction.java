package lab2;



public class ProceduralAbstraction {
    //Requires: None
    //Modifies: None
    //Effects: Returns the smallest positive integer n for which n!
    // (i.e. 1*2*3**n) is greater than or equal to x, for positive
    // integer x. Otherwise returns 1.
    public static int reverseFactorial(int x) {
        if (x <= 0) {
            return 1; //since 1 factorial is greater than or equal to 0 and negative ints
        } else {
            int factorial = 0; // set factorial count to 0
            int factorial_sum = 1; // set factorial sum to compare to x
            
            for(int fact = 1; x > factorial_sum; fact++) { // increment factorial until
                
                factorial_sum *= fact ; // initial activation will lead to 1 * 1 = 1 for factorial sum, accounted for by setting factorial to 0
                factorial++; // increment factorial along with fact
                
                // ask TA if there's a way to make this more memory efficient by using the factorial var in this for loop instead of fact
                
            }
            
            return (factorial); // return the factorial
        }
    }
    
    
    
    //Requires: None
    //Modifies: None
    //Effects: If the matrix arr satisfies Nice property, prints the sum and
    // returns true. Otherwise returns false.
    public static boolean isMatrixNice(int[][] arr) {
        // first requirement, has to be a square matrix
        // sum of ints in each column row and diagonal have to be the same, that's 2 diagonals + 2n columns/rows to check, n being the dimension of the matrix
        
        
        if (arr == null || arr.length == 0) { // making sure there's > 0 rows and that it's not an empty array
            return false;
        }
        
        // check for squareness
        int columns = arr[0].length; // gets length of row 1 in elements
        for (int rows = 0; rows < arr.length;rows++) {
            
            if (columns != arr[rows].length) { // gets length of each row, compares to length of row 1
                System.out.println("not square");
                return false;
            }  
            // if any row array has more or less columns than the initial row, 2D array will be deemed not square
        }
        
        
        // ... now confirmed squareness, can move on to checking nice-ness ...
        int fwd_diag_sum = 0;
        int bkd_diag_sum = 0;
        int row_sum = 0;
        int col_sum = 0;
        
        int key_sum = 0;
        
//        System.out.println("columns:  " + columns);  // debug
        // to get key_sum
        for (int j = 0; j < columns; j++) {
                key_sum += arr[0][j];
            }
        
//        System.out.println("key_sum:  " + key_sum); //debug
        
        //checking rows
        
        for (int row = 0; row < arr.length;row++){
            for (int j = 0; j < columns; j++) {
                row_sum += arr[row][j]; // adding each element of the row to row_sum
            }
            
            if (row_sum != key_sum) { //check each row
                return false;
            }
            row_sum = 0; // resetting the sum var for each row
        } 
        
        
        
        
        //checking columns
        for (int column = 0; column < arr.length;column++){

            for (int j = 0; j < columns; j++) {
                col_sum += arr[j][column]; 
            // this is a bit confusing but I just copy pasted the last loop and swapped the order of 
            // which indices increment first, now the row (j) will increment first and then the columns (row) will increment after
            // terrible for readability though
            }
            
            if (col_sum != key_sum) {
                return false;
            }
            
            col_sum = 0;
            
        }
        
        
        //check diagonals
        //check the forward diagonal
        for (int i = 0; i < arr.length;i++){
            fwd_diag_sum += arr[i][i];
        }
        
        if (fwd_diag_sum != key_sum) {
                return false;
            }
        
        //check the backward diagonal
//        int row = 0;
//        for(int col = (arr.length -1); col >= 0; col--) {
//            
//            bkd_diag_sum += arr[row][col];
//            
//            row++; // increment row while decrementing column
//        }
        
        //Alternatively check bckwd diag could be simplified to:
        
        for(int i = 0; i < arr.length; i++) {
            bkd_diag_sum += arr[i][(arr.length-1-i)];
        } // better memory usage
        
        
        if (bkd_diag_sum != key_sum) {
                return false;
            }
        System.out.println("the key sum is:   " + key_sum);

        return true;
        
    }
    
    public static void main(String[] args) {

    // Test reverseFactorial
    System.out.println(reverseFactorial(24));   // expected: 4
    System.out.println(reverseFactorial(119));  // expected: 5
    System.out.println(reverseFactorial(-3));   // expected: 1

    // Test isMatrixNice
    int[][] niceMatrix = {
        {2, 7, 6},
        {9, 5, 1},
        {4, 3, 8}
    };

    int[][] MeanMatrix = {
        {-3, 1, 0},
        {4, -3, 4},
        {7, -9, 0}
    };

    System.out.println(isMatrixNice(niceMatrix));     
    System.out.println(isMatrixNice(MeanMatrix));  
    }
    
}


