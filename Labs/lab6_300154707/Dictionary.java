public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
        /* Your code here */
    }

    @Override
    public void put(String key, Integer value) {
        /* Your code here */
    }

    private void increaseCapacity() {
        /* Your code here.  Use this in put() where necessary. */
    }

    @Override
    public boolean contains(String key) {
        /* Your code here. */
    }

    @Override
    public Integer get(String key) {
        /* Your code here. */
    }

    @Override
    public void replace(String key, Integer value) {
        /* Your code here. */
    }

    @Override
    public Integer remove(String key) {
        /* Your code here. */
    }

    @Override
    public String toString() {
      String res;
      res = "Dictionary: {elems = [";
      for (int i = count-1; i >= 0 ; i--) {
          res += elems[i];
          if(i > 0) {
              res += ", ";
          }
      }
      return res +"]}";
    }

}