package problem1;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IStackImplTest {
    private IStackImpl stack;
    private List<Integer> list;
    private Integer item;



    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void push() {
        item = 5;
        list = new LinkedList<>();
        int count = 0;

        while(!stack.isEmpty()) {
            list.add(stack.pop());
            count++;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }

        list.add(0,item);
        stack.push(item);

        assertEquals((int)list.size(), (int)count + 1);

        while (count > 0) {
            if ((int)list.remove(0) == (int)stack.pop());
            count--;
        }
    }

    @Test
    public void pop() throws EmptyStackException {
        try{
            list = new LinkedList<>();
            int count = 0;

            while(!stack.isEmpty()) {
                list.add(stack.pop());
                count++;
            }

            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }

            list.remove(0);
            stack.pop();
            count -= 1;

            assertEquals((int)list.size(), (int)count);


            while (count > 0) {
                assertEquals((int)list.remove(0), (int)stack.pop());
                count--;
            }

        }catch (EmptyStackException e){
            fail("An exception should not have been thrown.");
        }
    }

    @Test(expected = EmptyStackException.class)
    public void popFail() throws EmptyStackException{
        stack.pop();

    }

    @Test
    public void top() throws EmptyStackException {
        try{
            list = new LinkedList<>();
            int count = 0;

            while(!stack.isEmpty()) {
                list.add(stack.pop());
                count++;
            }

            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
            assertEquals(list.get(0), stack.top());

            while(count > 0) {
                assertEquals(list.remove(0), stack.pop());
                count--;
            }

        }catch (EmptyStackException e){
            fail("An exception should not have been thrown.");
        }
    }

    @Test(expected = EmptyStackException.class)
    public void topFail() throws EmptyStackException{
        stack.top();


    }

    @Test
    public void isEmpty() {
        if(stack.top() == null){
            assertEquals(stack.isEmpty(), true);
        }else{
            assertEquals(stack.isEmpty(), false);
        }
    }
}