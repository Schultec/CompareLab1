package lab1.cscd211comparators;

import lab1.cscd211classes.Players;

import java.util.Comparator;

/**
 *  The comparator ensures we only get Players as the incoming parameter and
 *  check the birthcountry of the players
 */
public class PlayerComparator implements Comparator<Players> {

    /**
     * The compare method compares the birth country of o1 and o2
     * @param o1 Represents the first player to be compared
     * @param o2 Represents the second player to be compared
     * @return int Guaranteed to be <0 >0 or =0
     */
    @Override
    public int compare(Players o1, Players o2) {
        if(o1.getBirthCountry().compareTo(o2.getBirthCountry()) == 0){
            return 0;
        }
        return o1.getBirthCountry().compareTo(o2.getBirthCountry());
    }
}
