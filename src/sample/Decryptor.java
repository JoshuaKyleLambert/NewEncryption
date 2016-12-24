package sample;

import java.util.Arrays;

/**
 * Created by Joshua on 12/19/2016.
 * Decryptor Class constructed with a binary string
 * and a set of keys will ..  I think its pretty obvious.
 */
public class Decryptor {
    private String key1, key2, key3, key4, bigKey;
    private StringBuilder encryptedString;


    Decryptor(StringBuilder encryptedString, String key1, String key2, String key3, String key4, String bigKey) {
        System.out.println("decryptro constructor called");
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
        this.key4 = key4;
        this.bigKey = bigKey;
        this.encryptedString = encryptedString;
    }

    public StringBuilder transform100(StringBuilder input) {
        //read 100 char's at a time transform and append to output String
        StringBuilder output = new StringBuilder();
        String[][] preTransform10 = new String[10][10];
        String[][] postTransform10 = new String[10][10];
        StringBuilder tempString = new StringBuilder(input.toString());


        while (tempString.length()  >= 100) {
                System.out.println(tempString.length());
            //fill the matrix with the string
            //This stringlength % 100 > 4
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    preTransform10[i][j] = String.valueOf(tempString.charAt(j));
                    System.out.println(tempString.charAt(j) + "  " + j );
                }
                tempString.delete(0, 10);
            }
            // copy array
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) postTransform10[i][j] = preTransform10[i][j];
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
                    //System.out.print(postTransform10[i][j]);
                    output.append(postTransform10[i][j]);
                }
            }
        }

        return output;
    }

    public StringBuilder transform25(StringBuilder input) {
        StringBuilder output = new StringBuilder();
        //read 100 char's at a time transform and append to output String
        String[][] preTransform5 = new String[5][5];
        String[][] postTransform5 = new String[5][5];
        StringBuilder tempString = new StringBuilder(input.toString());
        int keyNumber = 1;
        String key = "";

        while (tempString.length() >= 25) {
            System.out.println(tempString.length());
            //fill the matrix with the string
            //This stringlength % 100 > 4
            //Select the proper key to use
            if (keyNumber == 1) {
                key = key1;
                keyNumber++;
            }
            if (keyNumber == 2) {
                key = key2;
                keyNumber++;
            }
            if (keyNumber == 3) {
                key = key3;
                keyNumber++;
            }
            if (keyNumber == 4) {
                key = key4;
                keyNumber = 1;
            }


            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    preTransform5[i][j] = String.valueOf(tempString.charAt(j));
                }

            }

            tempString.delete(0, 25);
            // copy array
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) postTransform5[i][j] = preTransform5[i][j];
            }

            // Check for and Do transforms
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
            //build output string
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    //System.out.print(postTransform10[i][j]);
                    output.append(postTransform5[i][j]);
                }
            }
        }
        return output;
    }

    //Returns a decrypted binary String
    public StringBuilder decrypt() {
        StringBuilder temp1, temp2, temp3;
        temp1 = padZeros(encryptedString);
        temp2 = transform100(temp1);
        temp3 = transform25(temp2);

        //temp = transform25(transform100(padZeros(encryptedString)));
        System.out.println("padZeros     : " + temp1);
        System.out.println("transform 100: " + temp2);
        System.out.println("transform  25: " + temp3);

        return temp1;
    }

    private StringBuilder padZeros(StringBuilder binaryInput) {
        StringBuilder string = new StringBuilder(binaryInput);
        //System.out.print(string);
        //Capacity of the binary string and padding size determined
        int cap = binaryInput.length();
        int padding = 100 - (cap % 100);

        //Padding final matrix so that it is full
        for (int i = 0; i < padding; i++) {
            string.append("0");
        }
        //System.out.println(binaryInput);
        return string;

    }


}
