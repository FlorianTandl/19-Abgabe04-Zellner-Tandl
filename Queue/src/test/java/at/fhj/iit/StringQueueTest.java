package at.fhj.iit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class StringQueueTest {
    /**
     * TODO Write your own tests
     */

    private StringQueue one;
    private StringQueue sq;

    /**
     * initializes 2 {@link StringQueue}
     */
    @Before
    public void setUp(){
    StringQueue three = new StringQueue();
    StringQueue sq = new StringQueue(2);
    }

    /**
     * Tests {@link StringQueue#StringQueue(int)} for Exception, when maxSize is 0
     */
    @Test (expected = IllegalArgumentException.class)
    public void StringQueueEmpty(){
        StringQueue empty = new StringQueue(0);
    }
    
    /**
     * Tests if {@link StringQueue#remove()} removes the right object
     */
    @Test
    public void fiveRemove() {
    	StringQueue sq = new StringQueue(2);
    	String add ="1";
    	sq.offer(add);
    	assertEquals(sq.remove(), add);
    }
    
    /**
     * Tests {@link StringQueue#remove()} if Queue is empty
     */
    @Test (expected = NoSuchElementException.class)
    public void removeEmpty(){
    	StringQueue one = new StringQueue(1);
        one.remove();
        one.remove();
    }

    /**
     * Tests {@link StringQueue#offer(String)} when maxSize is reached
     */

    @Test
    public void offerFull(){
    	StringQueue one = new StringQueue(1);
        one.offer("");
        
        assertFalse("No space to offer",one.offer(""));
    }
    
    /**
     * Tests {@link StringQueue#poll()} when there is nothing to poll
     */
    @Test 
    public void pollTest(){
    	StringQueue one = new StringQueue(2);
        one.poll();
    }

    /**
     * Tests {@link StringQueue#peek()} when Queue is empty
     */
    @Test
    public void peekEmpty(){
    	StringQueue one = new StringQueue(2);
        one.peek();
    }

    /**
     * Tests {@link StringQueue#element()} when Queue is empty
     */
    @Test (expected = NoSuchElementException.class)
    public void elementEmpty(){
    	StringQueue one = new StringQueue(2);
        one.element();
    }
    
    /**
     * Tests if {@link StringQueue#element()} returns the right element
     */
    @Test
    public void element() {
    	StringQueue one = new StringQueue(2);
    	one.offer("3");
    	assertEquals(one.element(), "3");
    }

    /**
     * Sets {@link StringQueue} objects to null
     */
    @After
    public void teardown(){
        one = null;
        sq = null;
    }

}