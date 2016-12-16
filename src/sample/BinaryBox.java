package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Joshua on 12/15/2016.
 */
public class BinaryBox {

    public boolean writeBinaryStringToFile(String outputPath, StringBuilder outputString){

        //pad to multiple of 8 since we had to pad with zeros we add these to make a final complete char
        if (outputString.length() % 200 == 100) {
            outputString.append("0000");
        }
        try {

            java.io.File file = new java.io.File(outputPath);
            if (file.exists()) {
//       System.out.println("File already exists");
//       System.exit(0);
                // auto-delete file for convenience
                file.delete();
            }

            // Create a file
            java.io.PrintWriter output = new java.io.PrintWriter(file);

            //String bin = "011010000110010101111001";
            StringBuilder b = new StringBuilder();
            int len = outputString.length();
            int i = 0;

            //get 8 bits convert to chars
            while (i + 8 < len) {
                char c = convert(outputString.substring(i, i + 8));
                i += 8;
                b.append(c);
                output.append(c);
            }

            //Clear all the string builders
           // sb.delete(0,sb.length());
            //outputString.delete(0, outputString.length());

            // Write formatted output to the file
            //output.append(b.toString());
            // Close the file
            output.close();





            //Convert to chars and write to file
            //BinaryStringToChars();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BinaryBox.class.getName()).log(Level.SEVERE, null, ex);
        }


        return true;
    }

    private static char convert(String bs) {
        return (char) Integer.parseInt(bs, 2);
    }

    public StringBuilder buildBinaryString(String inputPath) {

        StringBuilder stringbuilder = new StringBuilder();
        int integerValue, missingZeros;
        String binary;
        FileInputStream inputstream = null;

        try {
            //New file input stream with file name
            // this should not be done here at the button.

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

            System.out.println(stringbuilder);

        } catch (Exception ex) {
            // if any error occurs
            ex.printStackTrace();
        } finally {

            // releases all system resources from the streams
            if (inputstream != null) {
                try {
                    inputstream.close();
                } catch (Exception ex) {
                }
            }
        }

        return stringbuilder;
    }

//    void BinaryStringToChars() throws FileNotFoundException {
//
//
//
//    }


}
