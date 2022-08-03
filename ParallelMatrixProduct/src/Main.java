package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] argv) {

    int threadsAmount = getThreads();

    ParallelMatrixProduct parallelTermFirst = new ParallelMatrixProduct(threadsAmount);
    ParallelMatrixProduct parallelTermSecond = new ParallelMatrixProduct(threadsAmount);

    fillMatrix(parallelTermFirst);
    fillMatrix(parallelTermSecond);

    Long begin;
    Long end;

    begin = System.currentTimeMillis();
    parallelTermFirst.startProduct(parallelTermSecond);
    end = System.currentTimeMillis();
  

    System.out.println("Product(" + (end - begin)/100.0 + "):\n" + parallelTermFirst);
  }

  public static void fillMatrix(ParallelMatrixProduct matrix) {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int rows = 0, columns = 0;

      System.out.println("Enter amount of rows of matrix:");
      rows =  Integer.parseInt(in.readLine());
      System.out.println("Enter amount of columns of matrix:");
      columns =  Integer.parseInt(in.readLine());
      matrix.setDimension(rows, columns);

      for (int i = 0; i < rows; i++) {
        System.out.println("Row #" + i + ":");
        String[] line = in.readLine().split(" ");
        int value;
        if (line.length == columns) {
          for (int j = 0; j < columns; j++) {
            value = Integer.parseInt(line[j]);
            matrix.set(i, j, value);
          }
        } else {
          System.out.println("There is " + columns + " elements!");
          i--;
        }    
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static int getThreads() {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int threadsAmount;
      System.out.println("Enter amount of threads:");
      threadsAmount =  Integer.parseInt(in.readLine());
      return threadsAmount;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return 1;
    }
  }
}
