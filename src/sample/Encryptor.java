package sample;

import java.io.FileInputStream;

/**
 * Created by Joshua on 12/15/2016.
 */
public class Encryptor {

    public boolean writeBinaryStringToFile(String outputPath){




        return true;
    }

    public StringBuilder buildBinaryString(String inputPath) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        String c;
        int missingzeros = 0;
        FileInputStream fis = null;

        try {
            //New file input stream with file name
            // this should not be done here at the button.

            fis = new FileInputStream(inputPath);
            // read till the end of the file
            while ((i = fis.read()) != -1) {
                // converts integer to binary char
                c = Integer.toBinaryString(i);

                //Appends leading zeros
                missingzeros = 8 - c.length();
                for (int inc = 0; inc < missingzeros; inc++) {
                    sb.append("0");
                }
                sb.append(c);  //System.out.println(001000);
            }

            System.out.println(sb);

        } catch (Exception ex) {
            // if any error occurs
            ex.printStackTrace();
        } finally {

            // releases all system resources from the streams
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception ex) {
                }
            }
        }

        return sb;
    }

}
