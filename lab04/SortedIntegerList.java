import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class SortedIntegerList {

  private LinkedList<Integer> list;
  private boolean repeat;
  private int size;

  public SortedIntegerList (boolean allowRepeat) {

    list = new LinkedList<Integer>();
    repeat = allowRepeat;
    size = 0;
  }

  public void add (int value) {
    Integer temp;
    boolean putIn = false;

    if (list.size() == 0) {
      list.add(value);
      size++;
    } else {
      ListIterator<Integer> it = list.listIterator();
      temp = list.get(0);
      for ( ; it.hasNext(); ) {

        if (temp >= value) {
          if (repeat == false && temp == value) {
            putIn = true;
            break;
          }
          it.add(value);
          size++;
          putIn = true;
          break;
        }
        temp = (Integer) it.next();
      }

      if (putIn == false) {
        it.add(value);
        size++;
     }
    }
  }

  public void remove (int value) {
    int temp;
    ListIterator<Integer> it = list.listIterator();
    if (list.size() != 0) {
      temp = list.get(0);
      for ( ; it.hasNext(); ) {

        if (temp == value) {
          it.remove();
          size--;
          break;
        }
        temp = (Integer) it.next();
      }
    }
  }

  public boolean equals (SortedIntegerList object) {

    Iterator it = list.iterator();
    Iterator it2 = object.list.iterator();
    int dump = 0;

    for ( ; it.hasNext() && it2.hasNext(); dump++) {
      if ((Integer) it.next() != (Integer) it2.next()) {
        return false;
      }
    }

    if (dump == size) {
      return true;
    } else {
      return false;
    }

  }

  public String toString () {
    StringBuilder str = new StringBuilder();
    Iterator it = list.iterator();

    for ( ; it.hasNext(); ) {
      str.append((Integer) it.next());
      str.append(' ');
    }

    return str.toString();
  }
}
