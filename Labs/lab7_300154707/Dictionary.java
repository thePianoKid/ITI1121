import java.util.Arrays;

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
        elems = new Pair[INITIAL_CAPACITY];
        count = 0;
    }

    @Override
    public void put(String key, Integer value) {
        if (count == elems.length) {
            increaseCapacity();
        }

        elems[count] = new Pair(key, value);
        count++;
    }

    private void increaseCapacity() {
        Pair[] expandedStack = new Pair[elems.length + INCREMENT];
        for (int i = 0; i < elems.length; i++) {
            expandedStack[i] = elems[i];
        }
        elems = expandedStack;
    }

    @Override
    public boolean contains(String key) {
        for (int i = 0; i < elems.length; i++) {
            if (elems[i] != null) {
                if (elems[i].getKey().equals(key)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Integer get(String key) {
        for (int i = elems.length-1; i >= 0; i--) {
            if (elems[i] != null) {
                if (elems[i].getKey().equals(key)) {
                    return elems[i].getValue();
                }
            }
        }

        return 0;
    }

    @Override
    public void replace(String key, Integer value) {
        for (int i = elems.length-1; i >= 0; i--) {
            if (elems[i] != null) {
                if (elems[i].getKey().equals(key)) {
                    elems[i] = new Pair(key, value);
                }
            }
        }
    }

    @Override
    public Integer remove(String key) {
        int index = 0;
        int result = 0;

        for (int i = 0; i < elems.length; i++) {
            if (elems[i] != null) {
                if (elems[i].getKey().equals(key)) {
                    index = i;
                    result = elems[i].getValue();
                }
            }
        }

        Pair[] tmp = new Pair[elems.length-1];
        
        for (int i = 0; i < tmp.length; i++) {
            if (i != index) {
                tmp[i] = elems[i];
            }
        }

        elems = tmp;
        count--;

        return result;
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