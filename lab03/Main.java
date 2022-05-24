package lab03;
import lab03.matrix.*;
import lab03.exception.MyException;

public class Main {

  public static void main(String[] arg) {
    try {
      Matrix firstMatrix = new Matrix(2, 3);
      Matrix secondMatrix = new Matrix(3, 3);
      SquareMatrix firstSquareMatrix = new SquareMatrix(3);
      SquareMatrix secondSquareMatrix = new SquareMatrix(3);

      int temp = 1;
      for (int i = 0; i < 2 ; i++) {
        for (int j = 0; j < 3; j++) {
          firstMatrix.set(i, j, temp++);
        }
      }
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          secondMatrix.set(i, j, temp++);
        }
      }

      for (int i = 0; i < 3 ; i++) {
        for (int j = 0; j < 3; j++) {
          firstSquareMatrix.set(i, j, i+j);
        }
      }
      for (int i = 0; i < 3 ; i++) {
        for (int j = 0; j < 3; j++) {
          secondSquareMatrix.set(i, j, i-j);
        }
      }

      System.out.println("Matrix product");
      System.out.print(firstMatrix + "*\n" + secondMatrix);
      firstMatrix.product(secondMatrix);
      System.out.println("=\n" + firstMatrix);

      System.out.println("Matrix sum:");
      System.out.println(firstSquareMatrix + "+\n" + secondSquareMatrix);
      firstSquareMatrix.sum(secondSquareMatrix);
      System.out.println("=\n" + firstSquareMatrix);

      ColumnMatrix c1 = new ColumnMatrix(3, 4);
      ColumnMatrix c2 = new ColumnMatrix(3, 4);

      for (int i = 0; i < 3 ; i++) {
        for (int j = 0; j < 4; j++) {
          c1.set(i, j, i+j);
        }
      }
      int t = 9;
      for (int i = 0; i < 3 ; i++) {
        for (int j = 0; j < 4; j++) {
          c2.set(i, j, i + t - j);
        }
      }

      System.out.println("Matrix sum:");
      System.out.println(c1 + "+\n" + c2);
      c1.sum(c2);
      System.out.println("=\n" + c1);

    } catch(MyException exception) {
      System.out.println(exception);
    }
  }
}
