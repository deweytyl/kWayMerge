import java.util.ArrayList;
import java.util.Iterator;

public class MergeUtils {

	/**
	 * 
	 * @param arrays an array of arrays
	 * @return an array of the iterators of the members of arrays in the same order
	 */
	protected static ArrayList<Iterator<Integer>> getIterators(
			ArrayList<ArrayList<Integer>> arrays) {
		ArrayList<Iterator<Integer>> arrIterators = new ArrayList<Iterator<Integer>>(
				arrays.size());

		for (ArrayList<Integer> arr : arrays) {
			arrIterators.add(arr.iterator());
		}

		return arrIterators;
	} // getIterators(ArrayList<ArrayList<Integer>>)

	/**
	 * 
	 * @param arrays
	 *            the sorted array to merge
	 * @return a sorted array of the values from arrays
	 */
	public static ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> arrays) {
		int sz;
		Iterator<Integer> iterator;
		ArrayList<Integer> arr;
		PQItem item;

		// create the queue
		PriorityQueue queue = new PriorityQueue(arrays.size());
		int output_size = 0;
		ArrayList<Iterator<Integer>> arrIterators = getIterators(arrays);

		// fill the queue with initial values & get total number of values
		for (int i = 0; i < arrays.size(); i++) {
			arr = arrays.get(i);
			iterator = arrIterators.get(i);

			sz = arr.size();

			if (sz > 0) {
				output_size += sz;
				queue.insert(new PQItem(iterator.next(), i));
			} // while
		} // for

		ArrayList<Integer> output = new ArrayList<>(output_size);

		// begin merging!
		while (!queue.isEmpty()) {
			// get the smallest item
			item = queue.remove();

			// merge item
			output.add(item.value);

			// get another item from item's source array
			iterator = arrIterators.get(item.source);

			if (iterator.hasNext()) {
				queue.insert(new PQItem(iterator.next(), item.source));
			} // if
		} // while

		return output;
	} // merge(ArrayList<ArrayList<Integer>>)
} // class MergeUtils