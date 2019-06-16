package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

// there's some Bugs included, try to debug the code and fix the Bugs
// there are different Bugs, wrong implementation, typos, ...
// write Test-Cases (read Queue Interface for understanding methods) and use Debugging possibilies of your IDE

/**
 * StringQueue creates an ArrayList of Strings and represent it as a Queue
 * 
 * @author Florian Tandl
 * @author Martin Zellner
 */
public class StringQueue implements Queue {

	private static final Logger logger = LogManager.getLogger(StringQueue.class);
	private List<String> elements = new ArrayList<String>();
	private int maxSize = 5;

	/**
	 * default Constructor
	 */
	public StringQueue() {
		logger.info("default constructor(maxSize = 5)");
	}
	
	/**
	 * this. was missing and maxSize was spelled wrong The maxSize is 5 so you can
	 * only add 5 Strings to the ArrayList
	 * 
	 * @param maxSize
	 */
	public StringQueue(int maxSize) {
		logger.info("constructor maxSize: " + maxSize);
		if (maxSize <= 0) {
            logger.error("New IndexOutOfBoundsException thrown: Size <= 0");
            throw new IllegalArgumentException("The size of the Queue must be greater than 0");
        }
		this.maxSize = maxSize;
	}

	/**
	 * add a String to the Array
	 * 
	 * @param obj
	 * @return true if there is space in the ArrayList
	 */
	@Override
	public boolean offer(String obj) {
		logger.info("offer new item: " + obj);
		if (elements.size() != maxSize) {
			elements.add(obj);
		}else {
			logger.error("offer maxSize is reached");
			return false;
		}
		return true;
	}

	/**
	 * elementsize must be bigger then 0
	 * 
	 * @return first added element of the ArrayList
	 */
	@Override
	public String poll() {
		String element = peek();
		logger.info("poll Element: " + element);
		if (elements.size() > 0) {
			elements.remove(0);
		}
		else {
			logger.error("poll no Element in Queue!");
		}

		return element;
	}

	/**
	 * element string would always be empty with "" 
	 * outcommented the empty string
	 * 
	 * @return first added element of ArrayList
	 */
	@Override
	public String remove() {
		String element = poll();
		logger.info("Element removed: " + element);
		 if (element == null) {
	            logger.error("NoSuchElementException thrown");
	            throw new NoSuchElementException("there's no element any more");
	        }

		return element;
	}

	/**
	 * checks if element size is bigger than zero
	 * 
	 * @return first added element of ArrayList
	 */
	@Override
	public String peek() {
		String element;
		if (elements.size() > 0) {
			element = elements.get(0);
			}
		else {
			logger.error("no peek element!");
			element = null;
		}
		logger.info("peek element: " + element);
			

		return element;
	}

	/**
	 * throws Exception if ArrayList is empty
	 * 
	 * @return first element of ArrayList
	 */
	@Override
	public String element() {
		String element = peek();
        logger.info("element: " + element);
		if (element == null) {
			logger.error("NoSuchElementException");
			throw new NoSuchElementException("there's no element any more");
		}
		return element;
	}
	
}