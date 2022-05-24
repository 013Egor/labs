import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class SortedColorList {

  private LinkedList<Colors> list;
  private boolean repeat;
  private int size;

  public SortedColorList (boolean allowRepeat) {

    list = new LinkedList<Colors>();
    repeat = allowRepeat;
    size = 0;
  }

  public void add (Colors value) {
    Colors temp;
    boolean putIn = false;

    if (list.size() == 0) {
      list.add(value);
      size++;
    } else {
      ListIterator<Colors> it = list.listIterator();
      for ( int i = 0; it.hasNext(); i++) {
        temp = (Colors) it.next();
        Double a = temp.getYFactor();
        Double b = value.getYFactor();
        if (a >= b) {
          putIn = true;
          if (repeat == false && temp.equals(value)) {
            break;
          }
          it.previous();
          it.add(value);
          size++;
          break;
        }
      }

      if (putIn == false) {
        it.add(value);
        size++;
     }
    }
  }

  public void remove (Colors value) {
    Colors temp;
    ListIterator<Colors> it = list.listIterator();

    if (list.size() != 0) {
      for ( ; it.hasNext(); ) {
        temp = (Colors) it.next();
        if (temp.equals(value)) {
          it.previous();
          it.remove();
          size--;
          break;
        }
      }
    }
  }

  public boolean equals (Object o) {
    if (o instanceof SortedColorList) {
      SortedColorList object = (SortedColorList) o;
      Iterator it = list.iterator();
      Iterator it2 = object.list.iterator();
      Colors colorOne;
      Colors colorTwo;
      int dump = 0;

      for ( ; it.hasNext() && it2.hasNext(); dump++) {
        colorOne = (Colors) it.next();
        colorTwo = (Colors) it2.next();
        if (colorOne.equals(colorTwo) == false) {
          return false;
        }
      }

      if (dump == size) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  public String toString () {
    StringBuilder str = new StringBuilder();
    Iterator it = list.iterator();

    for ( ; it.hasNext(); ) {
      str.append((Colors) it.next());
      str.append(' ');
    }

    return str.toString();
  }
}
