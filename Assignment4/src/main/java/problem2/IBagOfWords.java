package problem2;

public interface IBagOfWords {
    /**
     * The size of empty bag of words
     * {@value #EMPTY} EMPTY is the size of an empty bag of words, EMPTY = 0.
     */
    public static final int EMPTY = 0;
    /**
     * Creates an empty BagOfWords.
     * @return an empty BagOfWords.
     */
     static BagOfWords emptyBagOfWords(){
         return new BagOfWords(new String[EMPTY]);
     }

    /**
     * Calling isEmpty() on an empty BagOfWords returns true.Calling isEmpty() on a non-empty
     * BagOfWords  returns false.
     * @return true if the BagOfWords is empty, otherwise return false.
     */
    Boolean isEmpty();

    /**
     * Calling size() on an empty BagOfWordss returns 0.Calling size() on an non-empty BagOfWords
     * returns the number of elements in that BagOfWords.
     * @return the number of elements in that BagOfWords.
     */
    Integer size();

    /**
     * Calling add(s) on an empty BagOfWords returns a new BagOfWords that holds only one
     * element, s.a non-empty BagOfWords returns a BagOfWords that contains all the elements of
     * and the newly added element s.
     * @param s - the string wanted to be added in the BagOfWords
     * @return - a new BagofWords that all the elements of and the newly added element s. Returns a new BagOfWords that holds only one
     * element, s
     */
    BagOfWords add(String s);

    /**
     *Calling contains(s) on an empty BagOfWords returns false, for a non-empty BagOfWords returns true if the element exists in that BagOfWords
     *for a non-empty BagOfWords returns false if the element does not exist in that BagOfWords.
     * @param s- the string wanted to check whether it is contains in the BagOfWords
     * @return true if the specific string s contains in the BagOfWords, otherwise return false.
     */
    Boolean contains(String s);

}