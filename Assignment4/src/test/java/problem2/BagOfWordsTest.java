package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BagOfWordsTest {
    private BagOfWords bagOfWords;
    private String[] words;

    @Before
    public void setUp() throws Exception {
        words = new String[]{"cat", "cat", "car"};
        bagOfWords = new BagOfWords(words);
    }

    @Test
    public void emptyBagOfWords() {
        bagOfWords = IBagOfWords.emptyBagOfWords();
        assertEquals((int)bagOfWords.size(),0 );

    }

    @Test
    public void isEmpty() {
        assertEquals(bagOfWords.isEmpty(), false);
        bagOfWords = IBagOfWords.emptyBagOfWords();
        assertEquals(bagOfWords.isEmpty(), true);
    }

    @Test
    public void size() {
        assertEquals((int)bagOfWords.size(), 3);
    }

    @Test
    public void add() {
        bagOfWords.add("car");
        String[] newWords = {"cat", "cat", "car", "car"};
        for (int i = 0; i < bagOfWords.size() ; i++) {
            assertEquals(bagOfWords.getWords()[i], newWords[i]);
        }

    }

    @Test
    public void contains() {
        assertEquals(bagOfWords.contains("cat"), true);
        assertEquals(bagOfWords.contains("dog"), false);
    }

    @Test
    public void testEquals() {
        String[] newWords1 = {"car", "cat", "cat"};
        BagOfWords newBagOfWords1 = new BagOfWords(newWords1);
        String[] newWords2 = {"car", "cat"};
        BagOfWords newBagOfWords2 = new BagOfWords(newWords2);
        assertTrue(bagOfWords.equals(newBagOfWords1));
        assertTrue(!bagOfWords.equals(newBagOfWords2));
    }

    @Test
    public void testHashCode() {
        String[] newWords1 = {"car", "cat", "cat"};
        BagOfWords newBagOfWords1 = new BagOfWords(newWords1);
        assertTrue(newBagOfWords1.hashCode() == bagOfWords.hashCode());
    }

}