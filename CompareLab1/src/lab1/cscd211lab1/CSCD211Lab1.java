package lab1.cscd211lab1;

import lab1.cscd211classes.Players;
import lab1.cscd211comparators.PlayerComparator;
import lab1.cscd211lab1Methods.CSCD211Lab1Methods;
import lab1.cscd211utils.FileUtils;
import lab1.cscd211utils.SearchUtils;
import lab1.cscd211utils.SortUtils;

import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;


/**
 *  This class contains main
 * @NOTE You cannot modify this class or methods in any fashion
 */
public class CSCD211Lab1 {
    public static void main(String[] args) throws Exception
    {
        Players[] myPlayers = null;
        int choice, total, results;
        Scanner kb = new Scanner(System.in);
        File inf = FileUtils.openInputFile(kb); //you write done
        Scanner fin = new Scanner(inf);
        total = FileUtils.countRecords(fin,1); //you write done
        fin.close();
        fin = new Scanner(inf);
        myPlayers = CSCD211Lab1Methods.fillArray(fin,total); //you write
        fin.close();

        do{
            choice = CSCD211Lab1Methods.menu(kb); 
            switch(choice){
                case 1:
                    CSCD211Lab1Methods.printPlayers(myPlayers,System.out); //you write done
                    break;
                case 2:
                    PrintStream fout = new PrintStream(CSCD211Lab1Methods.readOutputFilename(kb));
                    CSCD211Lab1Methods.printPlayers(myPlayers,fout);
                    break;
                case 3:
                    SortUtils.selectionSort(myPlayers); //you write
                    break;
                case 4:
                    Arrays.sort(myPlayers, new PlayerComparator());     //you write PlayerComparator done
                    break;
                case 5:
                    myPlayers = CSCD211Lab1Methods.addPlayer(myPlayers, CSCD211Lab1Methods.createPlayer(kb)); //you write addPlayer done and createPlayer done
                    break;
                case 6: results = SearchUtils.linearSearch(myPlayers, CSCD211Lab1Methods.createPlayer(kb)); //you write linearsearch
                        if(results != -1)
                            System.out.println("Player Information: " + myPlayers[results]);
                        else
                            System.out.println("Player was not found");
                    break;
                case 7:
                    System.out.println("Program Ending");

            }//end choice
        }while (choice != 7);

    }//end main
}//end class
