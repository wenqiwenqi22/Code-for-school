package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    private Item item;
    protected int maximumWidth = 10;
    protected int maximumHeight = 10;
    protected int maximumDepth = 10;

    @Before
    public void setUp() throws Exception {
        //happy path
        try {
            item = new Item(maximumWidth, maximumHeight, maximumDepth);
            assertEquals(item.maximumWidth, 10);
            assertEquals(item.maximumHeight, 10);
            assertEquals(item.maximumDepth, 10);
        }catch(Exception e){
            fail("An exception should not have been thrown.");
        }
        // case 2: invalid item
        try {
            Item item2 = new Item(-10, maximumHeight, maximumDepth);
            assertEquals(item.maximumWidth, 10);
            assertEquals(item.maximumHeight, 10);
            assertEquals(item.maximumDepth, 10);
            fail("An exception should have been thrown.");
        }catch(Exception e){
        }

    }

    @Test
    public void getMaximumWidth() {
        assertEquals(item.getMaximumWidth(), maximumWidth);
    }

    @Test
    public void getMaximumHeight() {
        assertEquals(item.getMaximumHeight(), maximumHeight);
    }

    @Test
    public void getMaximumDepth() {
        assertEquals(item.getMaximumDepth(), maximumDepth);
    }
}