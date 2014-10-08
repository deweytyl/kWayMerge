public class PQItem
    implements Comparable<PQItem>
{
  /**
   * corresponds to array from which the item was drawn (i.e. its source)
   */
  public int source;

  /**
   * the value of the item
   */
  public int value;
  
  /**
   * Construct a new PQItem with value val and source k
   * @param val the value
   * @param k the source array
   */
  public PQItem(int val, int k)
  {
    value = val;
    source = k;
  }

  /**
   * Compares the integer value of this PQItem with another
   * @param o
   */
  public int compareTo(PQItem o)
  {
    // Doesn't account for overflow
    return Integer.compare(this.value, o.value);
  }
}