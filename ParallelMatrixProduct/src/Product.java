package src;

public class Product extends Thread {

  int[] line;
  int[][] matrix;
  int[] result;

  public Product(int[] line, int[][] matrix) {
    this.line = line;
    this.matrix = matrix;
    result = new int[matrix[0].length];
  }

  public void run() {
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < line.length; j++) {
        result[i] += line[j] * matrix[j][i];
      }
    }
  }

  public int[] getResult(){
    return result;
  }
}
