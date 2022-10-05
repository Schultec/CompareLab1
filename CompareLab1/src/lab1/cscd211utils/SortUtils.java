package lab1.cscd211utils;



/**
 * Basic SortUtil class that will be used throughout
 * the rest of the quarter for CSCD 211.<br>
 *
 * <br>@NOTE: All passed parameters are always final!
 * <br>@NOTE: I provided SortUtils for this lab.
 */
public class SortUtils<T extends Comparable<? super T>>
{
    /* ignore this, it is here so it doesn't appear in the JavaDocs */
    public SortUtils(){}


    /**
     * The selectSort method sorts the array in ascending order. The
     * array is of a type that has a compareTo method.
     *
     * @param <T> This describes a generic type
     * @param array The array to be sorted
     *
     * @throws IllegalArgumentException if the array is null or if the array.length <= 0
     */
    public static <T extends Comparable<? super T>> void selectionSort(T [] array)
    {
        throw new UnsupportedOperationException("Method not implemented");

    }// end SortUtil


}// end class