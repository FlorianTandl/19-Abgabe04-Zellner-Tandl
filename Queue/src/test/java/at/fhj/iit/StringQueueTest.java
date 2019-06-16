package at.fhj.iit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class StringQueueTest {
    /**
     * TODO Write your own tests
     */

    private StringQueue one;
    private StringQueue three;

    @Before
    public void setUp(){
    StringQueue three = new StringQueue(3);
    StringQueue one = new StringQueue(1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void StringQueueEmpty(){
        StringQueue empty = new StringQueue(0);
    }

    @Test (expected = NoSuchElementException.class)
    public void removeEmpty(){
        one.remove();
        one.remove();
    }

    @Test
    public void offerFull(){
        one.offer("");
        assertFalse("Max size is reached",one.offer(""));
    }

    @Test (expected = NoSuchElementException.class)
    public void pollEmpty(){
        one.poll();
        one.poll();
    }

    @Test
    public void peekEmpty(){
        one.peek();
        assertNull("Element size is zero",one.peek());
    }

    @Test (expected = NoSuchElementException.class)
    public void elementEmpty(){
        one.element();
        one.element();
    }

    @After
    public void teardown(){
        one = null;
        three = null;
    }

}
