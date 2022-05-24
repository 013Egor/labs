public class UsualMatrix implements IMatrix{

  protected int[][] matrix;
  protected int rows;
  protected int columns;

  public UsualMatrix(int row, int column) throws RuntimeException{
    if (row <= 0 || column <= 0) {
      throw new RuntimeException("You cannot create matrix with this dimension (" + row + " x " + column + ")");
    }
    rows = row;
    columns = column;

    matrix = new int [rows][column];
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

		int[][] temp = new int [rows][term.getColumns()];

		for ( int i = 0; i < rows; i++ ) {
			for ( int j = 0; j < term.getColumns(); j++ ) {
				for ( int t = 0; t < columns; t++ ) {
          temp[i][j] += this.get(i, t) * term.get(t, j);
				}
			}
		}
		this.matrix = temp;
    columns = term.getColumns();

		return this;
  }

  public void set ( int row, int column, int value ) {

		if ( row  >= this.rows || column >= this.columns  || row < 0 || column < 0) {
      throw new RuntimeException("You cannot set value on position " + row + ", " + column);
		}

    this.matrix[row][column] = value;
	}

	public int get ( int row, int column ) {
		if ( row  >= this.rows || column >= this.columns  || row < 0 || column < 0) {
			throw new RuntimeException("You cannot get value from position " + row + ", " + column);
		}

		return this.matrix[row][column];
	}

  public int getRows() {
    return rows;
  }

  public int getColumns() {
    return columns;
  }

  public final boolean equals (Object t) {
    if (t instanceof UsualMatrix ) {
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
    } else if (t instanceof SparseMatrix){
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
