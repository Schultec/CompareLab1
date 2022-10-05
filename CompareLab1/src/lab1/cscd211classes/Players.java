package lab1.cscd211classes;

import java.util.Date;

/**
 * Represents a player class that contains information about the player
 * The class implements Comparable and uses the Generic
 *
 * @Note final must be used on all parameters passed to the method
 */
public final class Players implements Comparable<Players>{
    /**
     * String of the playerID
     */
    private String playerID;
    /**
     * String of the player's birthyear
     */
    private int birthYear;
    /**
     * String of the player's birthmonth
     */
    private int birthMonth;
    /**
     * String of the player's birthday
     */
    private int birthDay;
    /**
     *  String of players birth country
     */
    private String birthCountry;
    /**
     * String of the player's birthState
     */
    private String birthState;
    /**
     * String of the player's birthCity
     */
    private String birthCity;
    /**
     * String of the player's name
     */
    private String firstName;
    /**
     * String of the player's last name
     */
    private String lastName;
    /**
     * String of the players given name
     */
    private String nameGiven;
    /**
     *  int of the players weight
     */
    private int weight;
    /**
     * int of the players height in inches
     */
    private int height;
    /**
     * char indicated if the player bats left or right
     */
    private char bats;
    /**
     * char indicated if the player throws left or right
     */
    private char throwsHand;
    /**
     * Date of the players baseball debut
     */
    private Date debut;
    /**
     * Date of the players final game
     */
    private Date finalGame;
    /**
     * String of the players retroID
     */
    private String retroID;
    /**
     * String of the players baseball reference ID
     */
    private String bbrefID;

    /**
     * Constructor for the Players class
     * @param playerID String of the player's ID
     * @param birthYear int of the player's birth year
     * @param birthMonth int of the player's birth month
     * @param birthDay int of the player's birth day
     * @param birthCountry String of the players birth country
     * @param birthState String of the player's birth state
     * @param birthCity String of the player's birth city
     * @param firstName String of the player's first name
     * @param lastName String of the player's last name
     * @param nameGiven String of the player's given name
     * @param weight int of the player's weight
     * @param height int of the player's height
     * @param bats char of the player's bats
     * @param throwsHand char of the player's throws hand
     * @param debut Date of the player's baseball debut
     * @param finalGame Date of the player's final game
     * @param retroID String of the player's retro ID
     * @param bbrefID String of the player's baseball reference ID
     *
     * @throws IllegalArgumentException if the playerID is null
     * @throws IllegalArgumentException if birth state is null or empty
     * @throws IllegalArgumentException if birth city is null or empty
     * @throws IllegalArgumentException if first name is null or empty
     * @throws IllegalArgumentException if last name is null or empty
     * @throws IllegalArgumentException if name given is null or empty
     * @throws IllegalArgumentException if retro ID is null or empty
     * @throws IllegalArgumentException if baseball reference ID is null or empty
     */
    public Players(final String playerID, final int birthYear, final int birthMonth, final int birthDay, final String birthCountry, final String birthState, final String birthCity,
                   final String firstName, final String lastName, final String nameGiven, final int weight, final int height, final char bats,
                   final char throwsHand, final Date debut, final Date finalGame, final String retroID, final String bbrefID) {
        if(playerID.isEmpty() || playerID == null || birthCountry.isEmpty() || birthCountry == null || firstName.isEmpty() || firstName == null ||
        lastName.isEmpty() || lastName == null || nameGiven.isEmpty() || nameGiven == null || retroID.isEmpty() || retroID == null || bbrefID.isEmpty() || bbrefID == null)
            throw new IllegalArgumentException("Strings cannot be empty or null for the player class");
        this.playerID = playerID;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthState = birthState;
        this.birthCity = birthCity;
        this.birthCountry = birthCountry;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nameGiven = nameGiven;
        this.weight = weight;
        this.height = height;
        this.bats = bats;
        this.throwsHand = throwsHand;
        this.debut = debut;
        this.finalGame = finalGame;
        this.retroID = retroID;
        this.bbrefID = bbrefID;
    }//end EVC

    /**
     * The compareTo method is guaranteed a player based on the class header. The method compares the players last name, first name and finally the given name.
     * @param o representing the other player being compared
     * @return int representing the difference between the two players
     * @throws IllegalArgumentException if the o is null
     */
    @Override
    public int compareTo(final Players o) {
        if (o == null)
            throw new IllegalArgumentException("Cannot compare to null");

        if(this.lastName.compareTo(o.lastName) == 0) {
            if(this.firstName.compareTo(o.firstName) == 0) {
                return this.nameGiven.compareTo(o.nameGiven);
            }
            return this.firstName.compareTo(o.firstName);
        }
        return this.lastName.compareTo(o.lastName);
    }//end compareTo

    /**
     * The toString prints Players first, last, bats, throws and date debuted
     *
     * @return String A string as shown in the output file
     *
     * @NOTE CR Means Carriage Return
     */

    @Override
    public String toString() {
        return "Player "+ firstName +" " + lastName + " bats " + bats + " and throws " + throwsHand + " and debuted " + debut;
    }//end toString

    /**
     * The equals method checks:
     * <br>returns false if obj == null
     * <br>returns true if obj == this
     * <br>returns false if obj is not an instance of Players
     * <br>returns true if the players are equivalent and all fields match
     * @param o Representing the potential players passed in
     * @return boolean Representing true or false as stated above
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Players players = (Players) o;

        if (birthYear != players.birthYear) return false;
        if (birthMonth != players.birthMonth) return false;
        if (birthDay != players.birthDay) return false;
        if (weight != players.weight) return false;
        if (height != players.height) return false;
        if (bats != players.bats) return false;
        if (throwsHand != players.throwsHand) return false;
        if (!playerID.equals(players.playerID)) return false;
        if (!birthCountry.equals(players.birthCountry)) return false;
        if (!birthState.equals(players.birthState)) return false;
        if (!birthCity.equals(players.birthCity)) return false;
        if (!firstName.equals(players.firstName)) return false;
        if (!lastName.equals(players.lastName)) return false;
        if (!nameGiven.equals(players.nameGiven)) return false;
        if (!debut.equals(players.debut)) return false;
        if (!finalGame.equals(players.finalGame)) return false;
        if (!retroID.equals(players.retroID)) return false;
        return bbrefID.equals(players.bbrefID);
    }
    /**
     * The hashCode method returns the hash code of the Players object
     *
     * @return int Representing the hash code
     */
    @Override
    public int hashCode() {
        int result = playerID.hashCode();
        result = 31 * result + birthYear;
        result = 31 * result + birthMonth;
        result = 31 * result + birthDay;
        result = 31 * result + birthCountry.hashCode();
        result = 31 * result + birthState.hashCode();
        result = 31 * result + birthCity.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + nameGiven.hashCode();
        result = 31 * result + weight;
        result = 31 * result + height;
        result = 31 * result + (int) bats;
        result = 31 * result + (int) throwsHand;
        result = 31 * result + debut.hashCode();
        result = 31 * result + finalGame.hashCode();
        result = 31 * result + retroID.hashCode();
        result = 31 * result + bbrefID.hashCode();
        return result;
    }

    public String getBirthCountry(){
        return this.birthCountry;
    }
}
