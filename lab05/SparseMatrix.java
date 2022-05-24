import java.util.LinkedList;
import java.util.ListIterator;

public class SparseMatrix implements IMatrix {
  private class Item {
    int row;
    int column;
    int value;

    public Item(int row, int column, int value) {
      this.row = row;
      this.column = column;
      this.value = value;
    }

    public boolean hasItem (int row, int column) {
      return this.row == row && column == this.column;
    }

    public void set (int row, int column, int value) {
      this.row = row;
      this.column = column;
      this.value = value;
    }

    public int get () {
      return value;
    }
  }
  LinkedList<Item> matrix;
  int rows;
  int columns;

  public SparseMatrix (int row, int column) throws RuntimeException{
    if (row <= 0 || column <= 0) {
      throw new RuntimeException("You cannot create matrix with this dimension (" + row + " x " + column + ")");
    }
    rows = row;
    columns = column;

    matrix = new LinkedList<Item>();
  }

  public IMatrix sum(IMatrix term) {

    if (rows != term.getRows() || columns != term.getColumns()) {
      throw new RuntimeException("You cannot sum matrix with different dimensions");
    }

    for ( int i = 0; i < rows; i++ ) {
      for ( int j = 0; j < columns; j++ ) {
        int add = this.get(i, j) + term.get(i, j);
        this.set(i, j, add);
      }
    }
    return this;
  }

  public final IMatrix product(IMatrix term) {

    if ( columns != term.getRows() ) {
			throw new RuntimeException("You cannot product matrix with different dimensions(" +
       rows + " x " + columns + " and " + term.getRows() + " x " + term.getColumns() + ")");
		}

		LinkedList<Item> temp = new LinkedList<Item>();
    int tempValue = 0;

		for ( int i = 0; i < rows; i++ ) {
			for ( int j = 0; j < term.getColumns(); j++ ) {
				for ( int t = 0; t < columns; t++ ) {
          tempValue += this.get(i, t) * term.get(t, j);
				}
        temp.add(new Item(i, j, tempValue));
        tempValue = 0;
			}
		}
		this.matrix = temp;
    columns = term.getColumns();

		return this;
  }

  public void set ( int row, int column, int value ) {

		if ( row  >= this.rows || column >= this.columns || row < 0 || column < 0) {
      throw new RuntimeException("You cannot set value on position " + row + ", " + column);
		}

    if (value != 0) {
      Item temp;
      boolean putIn = false;
      ListIterator<Item> it = matrix.listIterator();

      for ( ; it.hasNext() ; ) {
        temp = it.next();
        if (temp.hasItem(row, column)) {
          putIn = true;
          temp.set(row, column, value);
        }
      }
      if (putIn == false) {
        it.add(new Item(row, column, value));
      }
    }
	}

	public int get ( int row, int column ) {
		if ( row  >= this.rows || column >= this.columns  || row < 0 || column < 0) {
			throw new RuntimeException("You cannot get value from position " + row + ", " + column);
		}

    ListIterator<Item> it = matrix.listIterator();
    Item temp;
    for( ; it.hasNext() ; ) {
      temp = it.next();
      if (temp.hasItem(row, column)) {
        return temp.get();
      }
    }
		return 0;
	}

  public int getRows() {
    return rows;
  }

  public int getColumns() {
    return columns;
  }

  public final boolean equals (Object t) {
    if (t instanceof SparseMatrix) {
      SparseMatrix term = (SparseMatrix) t;
      if (rows != term.getRows() || columns != term.getColumns()) {
        return false;
      }

      for (int i = 0; i < rows ; i++) {
        for (int j = 0; j < columns; j++) {
          if (this.get(i, j) != term.get(i, j)) {
            return false;
          }
        }
      }

      return true;
    } else if (t instanceof UsualMatrix) {
      UsualMatrix term = (UsualMatrix) t;
      if (rows != term.getRows() || columns != term.getColumns()) {
        return false;
      }

      for (int i = 0; i < rows ; i++) {
        for (int j = 0; j < columns; j++) {
          if (this.get(i, j) != term.get(i, j)) {
            return false;
          }
        }
      }

      return true;
    } else {
      return false;
    }
  }

	public String toString () {

		StringBuilder temp = new StringBuilder ();

		for ( int i = 0; i < rows ; i++) {
			temp.append("| ");
			for ( int j = 0; j < columns; j++ ) {
				temp.append(this.get(i, j));
				temp.append(' ');
			}
			temp.append("|\n");
		}

		return temp.toString();
	}

}
