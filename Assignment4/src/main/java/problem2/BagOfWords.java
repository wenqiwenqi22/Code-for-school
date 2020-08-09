package problem2;

import java.util.Objects;

/**
 * BagOfWords is an object that implements IBagOfWords interface, it has all the methods the interface has.
 * Such as emptyBagOfWords(), isEmpty(), size(), add(String s) and contains(String s).
 *
 */

public class BagOfWords implements IBagOfWords {
    private String[] words;
    private int size;
    /**{@value #SIZE_CHANGES} SIZE_CHANGES is the changes of the size of the BagOfWords after adding one element in it. SIZE_CHANGES = 1.
     *
     */
    public static final int SIZE_CHANGES = 1;


    /**
     * Construct a BagOfWords object which has words represented a string array and size represented by an integer.
     * size below means the number of words.
     * @param words - words is a string array that contains words wanted to put in the BagOfWords
     */
    public BagOfWords(String[] words) {
        this.words = words;
        this.size = words.length;

    }

    /**
     * Returns the list(array) of words of the BagOfWords object.
     * @return the list(array) of words of the BagOfWords object.
     */
    // this is an extract method for test purpose
    public String[] getWords() {
        return words;
    }

    /**
     * Returns true is the BagOfWords is empty, otherwise returns false .
     * @return true is the BagOfWords is empty, otherwise returns false .
     */
    @Override
    public Boolean isEmpty() {
        return this.words == null || this.size == 0;
    }

    /**
     * Returns the size of the BagOfWords, meaning the number of words in the BagOfWords.
     * @return the size of the BagOfWords, meaning the number of words in the BagOfWords.
     */
    @Override
    public Integer size() {
        return this.size;
    }

    /**
     * Add a specific word in the argument filed to the BagOfWords and return the BagOfWords.
     * @param s - the string wanted to be added in the BagOfWords
     *{@value #SIZE_CHANGES} SIZE_CHANGES is the changes of the size of the BagOfWords after adding one element in it. SIZE_CHANGES = 1.
     * @return return the BagOfWords after  adding a specific word in the argument filed to the BagOfWords
     */
    @Override
    public BagOfWords add(String s) {
        int oldSize = this.size;
        int newSize = oldSize + SIZE_CHANGES;
        String[] newWords = new String[newSize];
        //copy the old words in order to the new list of words.
        for (int i = 0; i < oldSize ; i++) {
            newWords[i] = this.words[i];

        }
        //add s to the last index in newWords
        newWords[oldSize] = s;
        return new BagOfWords(newWords);
    }

    /**
     * Returns true if a specific word is in the BagOfWords.
     * @param s- the string wanted to check whether it is contains in the BagOfWords
     * @return true if a specific word is in the BagOfWords.
     */
    @Override
    public Boolean contains(String s) {
        for (String word: this.words){
            if(s.equals(word)){
                return true;
            }

        }
        return false;
    }

    /**
     * Return true if two BagOfWords has the same words and shows exactly the same number of times(if there are duplicates).
     * @param o - the object that we want to compare with the BagOfWords.
     * @return true if two BagOfWords has the same words and shows exactly the same number of times(if there are duplicates).
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BagOfWords)) return false;
        BagOfWords that = (BagOfWords) o;
        if(this.size != that.size){
            return false;
        }
        //copy of that
        int sizeOfThat = that.size;
        String[] sArray = new String[sizeOfThat];

        for (int i = 0; i < sizeOfThat; i++) {
            sArray[i] = that.words[i];
        }

        for (String s: this.words) {
            for (int i = 0; i < sizeOfThat ; i++) {
                if(s.equals(sArray[i])){
                    sArray[i] = null;
                    break;
                }
            }
        }
        return true;
    }

    /**
     * Returns true if the hash code of bagOfWords is the same(meaning it has the same words
     * and shows exactly the same number of times(if there are duplicates).
     * @return  true if the hash code of bagOfWords is the same(meaning it has the same words and shows exactly the same number of times(if there are duplicates).
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        for (int i = 0; i < this.size; i++) {
            result =  result + words[i].hashCode();
        }
        return result;
    }



}
