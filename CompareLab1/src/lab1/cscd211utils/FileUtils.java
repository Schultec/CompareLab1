package lab1.cscd211utils;

import java.io.File;
import java.util.Scanner;



/**
 * Basic FileUtil class that will be used throughout
 * the quarter for CSCD 211.<br>
 *
 * <br>NOTE: All passed parameters are always final!
 */
public class FileUtils
{

    private FileUtils(){}

    /**
     * The countRecords method counts the number of lines in the file
     * and returns the count divided by the number of lines per record
     *
     * <b>Post</b> The Scanner is at the EOF and will need to be reset
     *
     * @param fin The Scanner object representing the file
     * @param linesPer The number of lines per each record
     * @return int - Representing the number of records in the file
     *
     * @throws IllegalArgumentException if the Scanner object is null
     * @throws IllegalArgumentException if the lines per record is &lt;= 0
     * @throws RuntimeException if the count of lines is 0
     */
    public static int countRecords(final Scanner fin, final int linesPer)
    {
        //throw new UnsupportedOperationException("Method not implemented");
        int countOfLines = 0;
        if(fin == null){
            throw new IllegalArgumentException("scanner cannot be null");
        }
        if(linesPer <= 0 ){
            throw new IllegalArgumentException("lines per record cannot be 0");
        }
        while(fin.hasNextLine()) {
            fin.nextLine();
            countOfLines++;
        }
        if(countOfLines == 0){
            throw new RuntimeException("count of lines cannot be zero");
        }
        return countOfLines;
    }// end countRecords


    /**
     * The openInputFile method prompts the user for a filename, attempts
     * to open that filename, if successful a File object containing information
     * on the file is returned.
     *
     * <b>Post</b> The carriage return is stripped from the input buffer at exit of the
     * method - Meaning the input buffer is left empty
     *
     * @param kb The Scanner object representing the keyboard
     * @return File - Representing an object to the open file
     *
     * @throws IllegalArgumentException if the Scanner object is null
     */
    public static File openInputFile(final Scanner kb)
    {
        if(kb == null)
            throw new IllegalArgumentException("Scanner can't be null");

        String fn = null;
        File fin = null;

        do
        {
            System.out.print("Please enter the name of the file ");
            fn = kb.nextLine();

            fin = new File(fn);

            if(! fin.exists())
                System.out.println("The file does not exist");

        }while(! fin.exists());

        return fin;

    }// end openInputFile

    /**
     * The openInputFile method receives a filename, attempts
     * to open that filename, if succesful a File object containing information
     * on the file is returned.
     *
     * @param filename The String representing the filename
     * @return File - Representing an object to the open file
     *
     * @throws IllegalArgumentException if the String object is null
     * @throws IllegalArgumentException if the String is empty
     * @throws RuntimeException if the file could not be opened
     */

    public static File openInputFile(final String filename)
    {
        if(filename == null)
            throw new IllegalArgumentException("filename is null");

        if(filename.isEmpty())
            throw new IllegalArgumentException("filename is empty");


        File inf = new File(filename);
        if(inf.exists())
            return inf;

        throw new RuntimeException("File could not be opened");


    }// end openInputFile

}// end class

