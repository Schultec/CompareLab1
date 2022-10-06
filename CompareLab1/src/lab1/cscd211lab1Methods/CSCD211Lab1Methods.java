package lab1.cscd211lab1Methods;

import lab1.cscd211classes.Players;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * The class contains a set of methods required for the lab to work properly
 *
 * @NOTE All parameters passed to method must be passed as final.  You don't need to write a default value constructor
 * since we don't have any class level variable.
 */
public class CSCD211Lab1Methods {
    /**
     * The fillArray method first creates an array of players, and then fills each index of the player array with
     * a new player object.
     *
     * @param fin Representing the Scanner object to the file
     * @param total Representing the total number of elements to be contained in the array
     * @return Player [] Representing array filled with Player objects
     *
     * @throws IllegalArgumentException if fin is null
     * @throws IllegalArgumentException if total is < 1
     *
     * @NOTE The file contents are comma separated values in the order title, isbn, pages, authors
     */
    public static Players[] fillArray(final Scanner fin,final int total) throws ParseException {
        //throw new UnsupportedOperationException("Method not implemented");
        if(fin == null){
            throw new IllegalArgumentException("fin cannot be null");
        }
        if(total < 1){
            throw new IllegalArgumentException("total cannot be less than one");
        }
        Players Players[];
        Players = new Players[total];
        int i;
        for (i = 0; i < Players.length; i++){
            String data = fin.nextLine().trim();
            String[] playerData =  data.split(",");
            Players[i] = new Players(
                    playerData[0],
                    Integer.parseInt(playerData[1]),
                    Integer.parseInt(playerData[2]),
                    Integer.parseInt(playerData[3]),
                    playerData[4],
                    playerData[5],
                    playerData[6],
                    playerData[7],
                    playerData[8],
                    playerData[9],
                    Integer.parseInt(playerData[10]),
                    Integer.parseInt(playerData[11]),
                    playerData[12].charAt(0),
                    playerData[13].charAt(0),
                    new SimpleDateFormat("MM/dd/yyyy").parse(playerData[14]),
                    new SimpleDateFormat("MM/dd/yyyy").parse(playerData[15]),
                    playerData[16],
                    playerData[17]
            );
        }
        return Players;
    }//end fillArray

    /**
     * The menu method offers the user a choice from:<br>
     * 1) Print the players to the screen<br>
     * 2) Print the players to a file<br>
     * 3) Sort the players based on natural order<br>
     * 4) Sort the players based on total order<br>
     * 5) Add a new player to the players<br>
     * 6) Search the players for a player<br>
     * 7) Quit<br>
     *
     * @param kb Representing the Scanner object to the keyboard
     * @return int Representing the menu choice which is ensured by you
     * to be between 1 and 7 inclusive
     *
     * @throws IllegalArgumentException if kb is null
     *
     * @NOTE You must ensure the input buffer is empty at the end of the method
     */
    public static int menu(final Scanner kb)
    {
        if(kb == null)
            throw new IllegalArgumentException("bad scanner menu");

        int choice;
        do
        {
            System.out.println("Please choose from the following");
            System.out.println("1) Print the players to the screen");
            System.out.println("2) Print the players to a file");
            System.out.println("3) Sort the players based on natural order");
            System.out.println("4) Sort the players based on total order");
            System.out.println("5) Add a new player to the players");
            System.out.println("6) Search the players for a player");
            System.out.println("7) Quit");
            System.out.print("Choice --> ");
            choice = Integer.parseInt(kb.nextLine());
            System.out.println();
        }while(choice < 1 || choice > 7);

        return choice;
    }// end menu

    /**
     * The printplayers calls the toString method of players and prints each player out followed by a CR
     *
     * @param myPlayers Representing the array of players
     * @param out Representing the PrintStream object to the screen or the file
     *
     * @throws IllegalArgumentException if array is null or the length is &lt; 1
     * @throws IllegalArgumentException if output stream is null
     */
    public static void printPlayers(Players[] myPlayers, PrintStream out) {
        //throw new UnsupportedOperationException("Method not implemented");
        int i;
        for (i = 0; i < myPlayers.length; i++){
            String s = myPlayers[i].toString() + "\r\n";
            System.out.println(s);
        }
    }//end printPlayers

    /**
     * The readOutputFilename calls the readString to read a output filename
     *
     * @param kb Representing the Scanner object to the keyboard
     * @return String Representing the output filename
     *
     * @throws IllegalArgumentException if kb is null
     *
     * @NOTE You must ensure the input buffer is empty at the end of the method
     */
    public static String readOutputFilename(final Scanner kb) {
        if(kb == null)
            throw new IllegalArgumentException("Bad param readOutputFilename");

        return readString("output filename",kb);
    }
    /**
     * The addPlayer method makes a new array of the old size plus one<br>
     * Next it copies the players from the old array to the new array<br>
     * Next it adds the new player in last index of the new array
     *
     * @param players Representing the old array to be copied
     * @param aPlayer Representing the player to add to the array
     * @return Players [] Representing the new array with the old players copied over
     * and the new player in the last index of the new array.
     *
     * @throws IllegalArgumentException if array is null or length < 1
     * @throws IllegalArgumentException if aPlayer is null
     *
     * @NOTE You must ensure the input buffer is empty at the end of the method
     */
    public static Players[] addPlayer(Players[] players, final Players aPlayer) {
        //throw new UnsupportedOperationException("Method not implemented");
        if(players == null || players.length < 1){
            throw new IllegalArgumentException("array cannot be null or less than one");
        }
        if(aPlayer == null) {
            throw new IllegalArgumentException("aPlayer cannot be null");
        }
        Players[] Players;
        Players = new Players[(players.length + 1)];
        int i;
        for (i = 0; i <= Players.length; i++){
            Players[i] = players[i];
            if(i == (players.length + 1)){
                Players[i] = aPlayer;
            }
        }
        return Players;
    }//end addPlayer
    /**
     * The createPlayer method prompts the user to enter information to create a new player
     * Entering the information is done by the private method readString.
     *
     * @param kb Representing the Scanner object to the keyboard
     * @return Players Representing a new player object
     *
     * @throws IllegalArgumentException if kb is null
     * @throws ParseException if the date cannot be parsed correctly
     * @NOTE You must ensure the input buffer is empty at the end of the method
     */
    public static Players createPlayer(final Scanner kb) throws ParseException {
        if(kb == null) {
            throw new IllegalArgumentException("kb cannot be null");
        }
        String playerID = readString("playerID", kb);
        int birthYear = Integer.parseInt(readString("birthYear", kb));
        int birthMonth = Integer.parseInt(readString("birthMonth", kb));
        int birthday = Integer.parseInt(readString("birthday", kb));
        String birthCountry = readString("birthCountry", kb);
        String birthState = readString("birthState", kb);
        String birthCity = readString("birthCity", kb);
        String firstName = readString("firstName", kb);
        String lastName = readString("lastName", kb);
        String nameGiven = readString("nameGiven", kb);
        int weight = Integer.parseInt(readString("weight", kb));
        int height = Integer.parseInt(readString("height", kb));
        char bats = readString("bats", kb).charAt(0);
        char throwsHand = readString("throwsHand", kb).charAt(0);
        Date debut = new SimpleDateFormat("MM/dd/yyyy").parse(readString("debut", kb));
        Date finalGame = new SimpleDateFormat("MM/dd/yyyy").parse(readString("finalGame", kb));
        String retroID = readString("retroID", kb);
        String bbrefID = readString("bbref", kb);
        //throw new UnsupportedOperationException("Method not implemented");
        return new Players(playerID, birthYear, birthMonth, birthday, birthCountry, birthState, birthCity, firstName, lastName, nameGiven, weight, height, bats, throwsHand, debut, finalGame, retroID, bbrefID);
    }//end createPlayer

    /**
     * The readString reads a string from the keyboard and ensures the string is not null or empty
     *
     * @param type Representing a String for the prompt on what to enter
     * @param kb Representing the Scanner object to the keyboard
     * @return String Representing the appropriate String
     *
     * @throws IllegalArgumentException if kb is null
     *
     * @NOTE You must ensure the input buffer is empty at the end of the method
     */
    private static String readString(final String type, final Scanner kb)
    {
        if(type == null || type.isEmpty() || kb == null)
            throw new IllegalArgumentException("Bad param readString");

        String str="";
        do
        {
            System.out.print("Please enter the " + type + " ");
            str = kb.nextLine().trim();
        }while(str == null || str.isEmpty());

        return str;
    }// end readString
}//end class
