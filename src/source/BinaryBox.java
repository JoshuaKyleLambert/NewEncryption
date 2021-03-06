package source;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Joshua on 12/15/2016.
 * Create a binary box with a file path and it will generate
 * a binary string from it or vice versa.
 */
class BinaryBox {

    StringBuilder writeBinaryStringToFile(String outputPath, StringBuilder outputString) {
        StringBuilder characterString = new StringBuilder();
        //pad to multiple of 8 since we had to pad with zeros we add these to make a final complete char
        if (outputString.length() % 200 == 100) {
            outputString.append("0000");
        }
        try {
            java.io.File file = new java.io.File(outputPath);
            if (file.exists())
                if (file.delete())
                    System.out.println("File delete successful.");


            java.io.PrintWriter output = new java.io.PrintWriter(file);
            int len = outputString.length();
            int i = 0;

            //get 8 bits convert to chars
            while (i + 8 < len) {
                char c = convert(outputString.substring(i, i + 8));
                i += 8;
                characterString.append(c);

            }
            output.append(characterString.toString());
            output.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BinaryBox.class.getName()).log(Level.SEVERE, null, ex);
        }
        return characterString;
    }

    private static char convert(String bs) {
        return (char) Integer.parseInt(bs, 2);
    }

    StringBuilder buildBinaryString(String inputPath) {

        StringBuilder stringbuilder = new StringBuilder();
        int integerValue, missingZeros;
        String binary;
        FileInputStream inputstream = null;

        try {
            //New file input stream with file name

            inputstream = new FileInputStream(inputPath);
            // read till the end of the file
            while ((integerValue = inputstream.read()) != -1) {
                // converts integer to binary char
                binary = Integer.toBinaryString(integerValue);

                //Appends leading zeros
                missingZeros = 8 - binary.length();
                for (int inc = 0; inc < missingZeros; inc++) {
                    stringbuilder.append("0");
                }
                stringbuilder.append(binary);  //System.out.println(001000);
            }

            //System.out.println(stringbuilder);

        } catch (Exception ex) {
            // if any error occurs
            ex.printStackTrace();
        } finally {

            // releases all system resources from the streams
            if (inputstream != null) try {
                inputstream.close();
            } catch (Exception ex) {
                System.out.println("Inputstream.close() failed");
            }
        }

        return stringbuilder;
    }

    String binarytoCharString(StringBuilder outputString){
        StringBuilder b = new StringBuilder();
        //pad to multiple of 8 since we had to pad with zeros we add these to make a final complete char
        if (outputString.length() % 200 == 100) {
            outputString.append("0000");
        }
            int len = outputString.length();
            int i = 0;

            //get 8 bits convert to chars
            while (i + 8 < len) {
                char c = convert(outputString.substring(i, i + 8));
                i += 8;
                b.append(c);
            }

        return b.toString();
    }


}
