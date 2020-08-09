package problem1;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IQueueTest {
    private IQueueImpl queue;
    private List<Integer> list;
    private int size;
    private Integer item;

    @Before
    public void setup() {

    }


    @Test
    public void enqueueTest() throws EmptyQueueException {
        item = 5;

        list = new LinkedList<>();
        //list:     1, 2, 3, 3
        // queue:   1, 2, 3, 4

        while (queue.size() > 0) {
            list.add(queue.dequeue());
        }

        for (int i = 0; i < list.size(); i++) {
            queue.enqueue(list.get(i));
        }

        list.add(item);
        queue.enqueue(item);

        assertEquals((int)list.size(), (int)queue.size());


        while (queue.size() > 0) {
            assertEquals((int)list.remove(0), (int)queue.dequeue());
        }
    }

    @Test
    public void dequeueTest() throws EmptyQueueException{
        try{
            list = new LinkedList<>();

            while (queue.size() > 0) {
                list.add(queue.dequeue());
            }

            for (int i = 0; i < list.size(); i++) {
                queue.enqueue(list.get(i));
            }
            list.remove(list.get(0));
            queue.dequeue();

            assertEquals((int)list.size(), (int)queue.size());


            while (queue.size() > 0) {
                assertEquals((int)list.remove(0), (int)queue.dequeue());
            }

        }catch (EmptyQueueException e){
            fail("An exception should not have been thrown.");
        }
    }

    @Test(expected =EmptyQueueException.class )
    public void dequeueTestFail() throws EmptyQueueException{
        queue.dequeue();

    }

    @Test
    public void front() throws EmptyQueueException{
        try {
            size = queue.size();
            Integer i = queue.front();

            assertEquals(queue.front(), i);
            assertEquals((int)queue.size(), (int)size);
        }catch (EmptyQueueException e){
            fail("An exception should not have been thrown.");
        }
    }

    @Test(expected = EmptyQueueException.class)
    public void frontFail() throws EmptyQueueException{
        queue.front();

    }

    @Test
    public void size() throws EmptyQueueException{
        int count = 0;
        int size = queue.size();

        while (queue.size() > 0) {
            queue.dequeue();
            count += 1;
        }
        assertEquals(size, count);
    }
}
