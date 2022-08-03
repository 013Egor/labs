package src;

import java.lang.Exception;

public class ParallelMatrixProduct {
  int threadsAmount;
  Product[] threads;
  int[][] matrix;
  int columns;
  int rows;

  public ParallelMatrixProduct(int threadsAmount) {
    this.threadsAmount = threadsAmount;
    threads = new Product[threadsAmount];
  }

  public void startProduct(ParallelMatrixProduct m) {
    if (columns != m.getRows()) {
      System.out.println("You cannot product these matrixes");
      return;
    }
    try {
      for (int i = 0; i < matrix.length; i += threadsAmount) {
        for (int j = 0; j < threadsAmount && j < matrix.length - i; j++) {
          threads[j] = new Product(matrix[i + j], m.matrix);
          threads[j].start();
        }
        for (int j = 0; j < threadsAmount && j < matrix.length - i; j++) {
          threads[j].join();
          matrix[j + i] = threads[j].getResult();
        }
      }
    } catch (Exception e){
      System.out.println(e.getMessage());
    }
  }

  public void set(int row, int column, int value) throws Exception {

    if ( row  >= this.rows || column >= this.columns ) {
      throw new Exception("You cannot set value on position " + row + ", " + column);
    }

    this.matrix[row][column] = value;
  }

  public void setDimension(int rows, int columns) {
    this.columns = columns;
    this.rows = rows;
    matrix = new int[rows][columns];
  }

  public int get ( int row, int column ) throws Exception{
    if ( row  >= this.rows || column >= this.columns ) {
      throw new Exception("You cannot get value from position " + row + ", " + column);
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
    if (t instanceof ParallelMatrixProduct) {
      ParallelMatrixProduct term = (ParallelMatrixProduct) t;

      if (rows != term.getRows() || columns != term.getColumns()) {
        return false;
      }

      for (int i = 0; i < rows ; i++) {
        for (int j = 0; j < columns; j++) {
          if (matrix[i][j] != term.matrix[i][j]) {
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
    try {
  		StringBuilder temp = new StringBuilder ();

  		for ( int i = 0; i < matrix.length ; i++) {
  			temp.append("| ");
  			for ( int j = 0; j < matrix[i].length; j++ ) {
  				temp.append(matrix[i][j]);
  				temp.append(' ');
  			}
  			temp.append("|\n");
  		}

  		return temp.toString();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return " ";
    }
	}
}
