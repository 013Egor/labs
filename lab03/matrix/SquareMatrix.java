package lab03.matrix;

import lab03.exception.MyException;

public class SquareMatrix extends Matrix {

  private int size;

  public SquareMatrix(int size) {
    super(size, size);

    this.size = size;

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (i == j) {
          matrix[i][j] = 1;
        } else {
          matrix[i][j] = 0;
        }
      }
    }
  }

  public final SquareMatrix sum(SquareMatrix term) {
    if ( size != term.size ) {
      throw new MyException("You cannot sum matrix with different dimensions");
		}

    for ( int i = 0; i < size; i++ ) {
      for ( int j = 0; j < size; j++ ) {
        matrix[i][j] += term.matrix[i][j];
      }
    }

    return this;
  }

  public int getColumns() {
    return size;
  }

  public int getRows() {
    return size;
  }
}
