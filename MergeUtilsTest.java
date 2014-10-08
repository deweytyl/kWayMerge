import static org.junit.Assert.*;

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

import org.junit.Test;

public class MergeUtilsTest {
    public static final int MAX_NUM_ARRAYS = 15;
    public static final int MAX_SIZE_ARRAY = 1000;

    /**
     * 
     */
    public ArrayList<ArrayList<Integer>> arrs;

    /**
     * 
     * @param arr
     */
    public static void assertArrayAscending(ArrayList<Integer> arr) {
	for (int i = 0; i < arr.size() - 1; i++) {
	    // assert every member is smaller than its successor
	    assertTrue(arr.get(i) <= arr.get(i + 1));
	} // for each member
    } // assertArrayAscending(ArrayList<Integer>)


    public void setup() {
	Random rand = new Random();
	int k = rand.nextInt(MAX_NUM_ARRAYS);

	this.arrs = new ArrayList<>(k);
	ArrayList<Integer> arr;

	for (int i = 0; i < k; i++) {
	    int sz = rand.nextInt(MAX_SIZE_ARRAY);
	    arr = new ArrayList<Integer>(sz);

	    for (int j = 0; j < sz; j++) {
		arr.add(rand.nextInt());
	    } // for

	    Collections.sort(arr);
	    
	    this.arrs.add(arr);
	} // for each array
    } // setup()

    @Test
    public void testMergeRands() {
	int i;
	
	setup();
	
	ArrayList<Integer> result = MergeUtils.merge(this.arrs);
	
	assertArrayAscending(result);
	
	// Ensure contains
	for (ArrayList<Integer> arr : arrs) {
	    for (Integer e : arr) {
		i = result.indexOf(e);
		
		if (i < 0) {
		    fail("Element was not found in result");
		} else {
		    result.remove(i);
		}
	    } // for each integer
	} // for each array
    } // testMergeRands()

} // class MergeUtilsTest
