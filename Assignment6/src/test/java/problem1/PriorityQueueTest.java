package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest {
    private PriorityQueue pq;
    private PriorityQueue pq1;
    private PriorityQueue emptyPq;

    @Before
    public void setUp() throws Exception {
        //happy path
        emptyPq = new PriorityQueue();
        pq = new PriorityQueue(3, "S", emptyPq);
        pq1 = new PriorityQueue(4, "E", pq);
        //throw an exception
        try {
            PriorityQueue pq2 = new PriorityQueue(null, "S", emptyPq);
            fail("This is an expected exception.");
        }catch (Exception e) {

        }
    }

    @Test
    public void createEmpty() {
        assertEquals(IImmutablePriorityQueue.createEmpty(), emptyPq);
    }

    @Test
    public void getPriority() {

        assertEquals((int)pq.getPriority(), 3);
    }

    @Test
    public void getValue() {

        assertEquals(pq.getValue(), "S");
    }

    @Test
    public void getRest() {
        assertEquals(pq.getRest(), emptyPq);
    }

    @Test
    public void isEmpty() {
        assertEquals(emptyPq.isEmpty(), true);
        assertEquals(pq.isEmpty(), false);
    }

    @Test
    public void add() throws InvalidPriorityQueueElement {
        PriorityQueue newPq = pq.add(4, "E");
        assertEquals(newPq, pq1);
        PriorityQueue pq3 = new PriorityQueue(1, "E", emptyPq);
        pq3 = new PriorityQueue(2, "E", pq3);
        pq3 = new PriorityQueue(3, "S", pq3);

        PriorityQueue newPq1 = pq.add(2,"E");
        newPq1 = newPq1.add(1, "E");
        assertEquals(newPq1, pq3);
    }

    @Test
    public void peek() throws InvalidPriorityQueueElement {
        assertEquals(pq.peek(), "S");
    }

    @Test(expected = InvalidPriorityQueueElement.class)
    public void peekFail() throws InvalidPriorityQueueElement {
        emptyPq.peek();
    }

    @Test
    public void pop() throws InvalidPriorityQueueElement {
        assertEquals(pq.pop(), pq.getRest());
    }

    @Test(expected = InvalidPriorityQueueElement.class)
    public void popFail() throws InvalidPriorityQueueElement {
        emptyPq.pop();
    }

    @Test
    public void equalsTest() throws InvalidPriorityQueueElement {
        assertEquals(pq, new PriorityQueue(3, "S", emptyPq));
    }

    @Test
    public void hashCodeTest() throws InvalidPriorityQueueElement {
        assertEquals(pq.hashCode(), new PriorityQueue(3, "S", emptyPq).hashCode());
    }

    @Test
    public void toStringTest() {
        String s = "PriorityQueue{priority=3, value='S', rest=PriorityQueue{priority=null, value='null', rest=null}}";
        assertEquals(pq.toString(), s);
    }
}