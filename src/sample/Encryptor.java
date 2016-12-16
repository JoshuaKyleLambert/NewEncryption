package sample;

/**
 * Created by Joshua on 12/15/2016.
 */
 class Encryptor {
    private String key1;
    private String key2, key3, key4, bigKey;
    private int[][] preTransform10 = new int[10][10];
    private StringBuilder outputString = new StringBuilder();
    //StringBuilder plainBinary;

    Encryptor(StringBuilder plainBinary, String key1, String key2, String key3, String key4, String bigKey) {
//                this.plainBinary = plainBinary;
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
        this.key4 = key4;
        this.bigKey = bigKey;
        buildMatrix(plainBinary);
    }

    StringBuilder getOutputString() {
        return outputString;
    }

    private void buildMatrix(StringBuilder s) {

        //Capacity of the binary string and padding size determined
        int cap = s.length();
        int padding = 100 - (cap % 100);

        //Padding final matrix so that it is full
        for (int i = 0; i < padding; i++) {
            s.append("0");
        }

        //Determing number of sub matrices
        int numOfMatrices = s.length() / 100;

        //Stack of sub matrices to be filled as 10x10 is broken down
        String[][][] matrix = new String[numOfMatrices][10][10];

        int counter = 0;
        String ss = s.toString();

        //Filling each sub matrix with contents from 10x10 matrix
        for (int m = 0; m < numOfMatrices; m++) {
            for (int row = 0; row < 10; row++) {
                for (int column = 0; column < 10; column++) {
                    matrix[m][row][column] = String.valueOf(ss.charAt(counter));
                    counter++;
                }
            }
        }

        for (int m = 0; m < numOfMatrices; m++) {
            copyTo5x5(matrix, 0, 0, m, key1);    //Quad 1
            copyTo5x5(matrix, 0, 5, m, key2);    //Quad 2
            copyTo5x5(matrix, 5, 0, m, key3);    //Quad 3
            copyTo5x5(matrix, 5, 5, m, key4);    //Quad 4

            outputString.append(transform10x10());

        }

    }

    private void copyTo5x5(String[][][] s, int row, int column, int matrixNum, String key) {

        String[][] preTransform5 = new String[5][5];
        String[][] postTransform5 = new String[5][5];

        //Splitting 10x10 matrix into 5x5 and copying into a 5x5
        for (int r = row, i = 0; r < row + 5; r++, i++) {
            for (int c = column, j = 0; c < column + 5; c++, j++) {
                preTransform5[i][j] = s[matrixNum][r][c];
            }
        }
        for (int r0 = 0; r0 < 5; r0++) {
            System.arraycopy(preTransform5[r0], 0, postTransform5[r0], 0, 5);
        }


        if (key.charAt(0) == '1') {
            postTransform5[0][0] = preTransform5[4][4];
            postTransform5[4][4] = preTransform5[0][0];
        }

        if (key.charAt(1) == '1') {
            postTransform5[0][1] = preTransform5[3][4];
            postTransform5[1][0] = preTransform5[4][3];
            postTransform5[3][4] = preTransform5[0][1];
            postTransform5[4][3] = preTransform5[1][0];
        }

        if (key.charAt(2) == '1') {
            postTransform5[2][0] = preTransform5[4][2];
            postTransform5[1][1] = preTransform5[3][3];
            postTransform5[0][2] = preTransform5[2][4];
            postTransform5[4][2] = preTransform5[2][0];
            postTransform5[3][3] = preTransform5[1][1];
            postTransform5[2][4] = preTransform5[0][2];
        }

        if (key.charAt(3) == '1') {
            postTransform5[0][3] = preTransform5[1][4];
            postTransform5[1][2] = preTransform5[2][3];
            postTransform5[2][1] = preTransform5[3][2];
            postTransform5[3][0] = preTransform5[4][1];
            postTransform5[4][1] = preTransform5[3][0];
            postTransform5[3][2] = preTransform5[2][1];
            postTransform5[2][3] = preTransform5[1][2];
            postTransform5[1][4] = preTransform5[0][3];
        }

        //Write transforms to 10 x 10 pretransformed matrix
        for (int r = row, i = 0; r < row + 5; r++, i++) {
            for (int c = column, j = 0; c < column + 5; c++, j++) {
                preTransform10[r][c] = Integer.parseInt(postTransform5[i][j]);
            }
        }
    }

    private StringBuilder transform10x10() {
        StringBuilder tempString = new StringBuilder();

        int[][] postTransform10 = new int[10][10];

        for (int i = 0; i < 10; i++) {
            System.arraycopy(preTransform10[i], 0, postTransform10[i], 0, 10);
        }

            if (bigKey.charAt(0) == '1') {
                postTransform10[0][0] = preTransform10[9][9];
                postTransform10[9][9] = preTransform10[0][0];
            }

            if (bigKey.charAt(1) == '1') {
                postTransform10[1][0] = preTransform10[9][8];
                postTransform10[0][1] = preTransform10[8][9];
                postTransform10[9][8] = preTransform10[1][0];
                postTransform10[8][9] = preTransform10[0][1];
            }

            if (bigKey.charAt(2) == '1') {
                postTransform10[1][2] = preTransform10[7][9];
                postTransform10[1][1] = preTransform10[8][8];
                postTransform10[2][0] = preTransform10[9][7];
                postTransform10[7][9] = preTransform10[1][2];
                postTransform10[8][8] = preTransform10[1][1];
                postTransform10[9][7] = preTransform10[2][0];

            }
            if (bigKey.charAt(3) == '1') {
                postTransform10[0][3] = preTransform10[6][9];
                postTransform10[1][2] = preTransform10[7][8];
                postTransform10[2][1] = preTransform10[8][7];
                postTransform10[3][0] = preTransform10[9][6];
                postTransform10[9][6] = preTransform10[3][0];
                postTransform10[8][7] = preTransform10[2][1];
                postTransform10[7][8] = preTransform10[1][2];
                postTransform10[6][9] = preTransform10[0][3];

            }
            if (bigKey.charAt(4) == '1') {
                postTransform10[0][4] = preTransform10[5][9];
                postTransform10[1][3] = preTransform10[6][8];
                postTransform10[2][2] = preTransform10[7][7];
                postTransform10[3][1] = preTransform10[8][6];
                postTransform10[4][0] = preTransform10[9][5];
                postTransform10[5][9] = preTransform10[0][4];
                postTransform10[6][8] = preTransform10[1][3];
                postTransform10[7][7] = preTransform10[2][2];
                postTransform10[8][6] = preTransform10[3][1];
                postTransform10[9][5] = preTransform10[4][0];

            }
            if (bigKey.charAt(5) == '1') {
                postTransform10[0][5] = preTransform10[4][9];
                postTransform10[1][4] = preTransform10[5][8];
                postTransform10[2][3] = preTransform10[6][7];
                postTransform10[3][2] = preTransform10[7][6];
                postTransform10[4][1] = preTransform10[8][5];
                postTransform10[5][0] = preTransform10[9][4];
                postTransform10[4][9] = preTransform10[0][5];
                postTransform10[5][8] = preTransform10[1][4];
                postTransform10[6][7] = preTransform10[2][3];
                postTransform10[7][6] = preTransform10[3][2];
                postTransform10[8][5] = preTransform10[4][1];
                postTransform10[9][4] = preTransform10[5][0];

            }
            if (bigKey.charAt(6) == '1') {
                postTransform10[0][6] = preTransform10[3][9];
                postTransform10[1][5] = preTransform10[4][8];
                postTransform10[2][4] = preTransform10[5][7];
                postTransform10[3][3] = preTransform10[6][6];
                postTransform10[4][2] = preTransform10[7][5];
                postTransform10[5][1] = preTransform10[8][4];
                postTransform10[6][0] = preTransform10[9][3];
                postTransform10[3][9] = preTransform10[0][6];
                postTransform10[4][8] = preTransform10[1][5];
                postTransform10[5][7] = preTransform10[2][4];
                postTransform10[6][6] = preTransform10[3][3];
                postTransform10[7][5] = preTransform10[4][2];
                postTransform10[8][4] = preTransform10[5][1];
                postTransform10[9][3] = preTransform10[6][0];

            }
            if (bigKey.charAt(7) == '1') {
                postTransform10[0][7] = preTransform10[2][9];
                postTransform10[1][6] = preTransform10[3][8];
                postTransform10[2][5] = preTransform10[4][7];
                postTransform10[3][4] = preTransform10[5][6];
                postTransform10[4][3] = preTransform10[6][5];
                postTransform10[5][2] = preTransform10[7][4];
                postTransform10[6][1] = preTransform10[8][3];
                postTransform10[7][0] = preTransform10[9][2];
                postTransform10[2][9] = preTransform10[0][7];
                postTransform10[3][8] = preTransform10[1][6];
                postTransform10[4][7] = preTransform10[2][5];
                postTransform10[5][6] = preTransform10[3][4];
                postTransform10[6][5] = preTransform10[4][3];
                postTransform10[7][4] = preTransform10[5][2];
                postTransform10[8][3] = preTransform10[6][1];
                postTransform10[9][2] = preTransform10[7][0];

            }
            if (bigKey.charAt(8) == '1') {
                postTransform10[0][8] = preTransform10[1][9];
                postTransform10[1][7] = preTransform10[2][8];
                postTransform10[2][6] = preTransform10[3][7];
                postTransform10[3][5] = preTransform10[4][6];
                postTransform10[4][4] = preTransform10[5][5];
                postTransform10[5][3] = preTransform10[6][4];
                postTransform10[6][2] = preTransform10[7][3];
                postTransform10[7][1] = preTransform10[8][2];
                postTransform10[8][0] = preTransform10[9][1];
                postTransform10[9][1] = preTransform10[8][0];
                postTransform10[8][2] = preTransform10[7][1];
                postTransform10[7][3] = preTransform10[6][2];
                postTransform10[6][4] = preTransform10[5][3];
                postTransform10[5][5] = preTransform10[4][4];
                postTransform10[4][6] = preTransform10[3][5];
                postTransform10[3][7] = preTransform10[2][6];
                postTransform10[2][8] = preTransform10[1][7];
                postTransform10[1][9] = preTransform10[0][8];

            }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tempString.append(postTransform10[i][j]);
            }
        }
        return tempString;
    }

}
