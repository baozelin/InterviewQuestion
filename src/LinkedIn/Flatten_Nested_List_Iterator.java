package LinkedIn;


//Input: nestedList = [[1,1],2,[1,1]]
//Output: [1,1,2,1,1]
//Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be:
// [1,1,2,1,1].
public class Flatten_Nested_List_Iterator {

    /**

     import java.util.NoSuchElementException;
     public class NestedIterator implements Iterator<Integer> {

     private List<Integer> integers = new ArrayList<Integer>();
     private int position = 0; // Pointer to next integer to return.

     public NestedIterator(List<NestedInteger> nestedList) {
     flattenList(nestedList);
     }

     private void flattenList(List<NestedInteger> nestedList) {
     for (NestedInteger nestedInteger : nestedList) {
     if (nestedInteger.isInteger()) {
     integers.add(nestedInteger.getInteger());
     } else {
     flattenList(nestedInteger.getList());
     }
     }
     }

     @Override
     public Integer next() {
     if (!hasNext()) throw new NoSuchElementException();
     // Return int at current position, and then *after*, increment position.
     return integers.get(position++);
     }

     @Override
     public boolean hasNext() {
     return position < integers.size();
     }
     */
}
