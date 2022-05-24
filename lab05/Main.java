import java.util.Random;

public class Main {

  public static void main (String[] argv) {
    Random rand = new Random();
    try {
      System.out.println("-------------");
      System.out.println("SparseMatrix:\n");
      SparseMatrix temp1 = new SparseMatrix(5, 5);
      SparseMatrix temp2 = new SparseMatrix(5, 5);
      int t1 = rand.nextInt() % 20;
      int t2 = rand.nextInt() % 20;
      int t3 = rand.nextInt() % 20;
      int t4 = rand.nextInt() % 20;
      int t5 = rand.nextInt() % 20;
      int t6 = rand.nextInt() % 20;
      int t7 = rand.nextInt() % 20;
      int t8 = rand.nextInt() % 20;
      int t9 = rand.nextInt() % 20;
      int t10 = rand.nextInt() % 20;


      temp1.set(1, 2, t1);
      temp1.set(1, 1, t2);
      temp1.set(4, 3, t3);
      temp1.set(1, 3, t4);
      temp1.set(4, 1, t5);

      temp2.set(3, 2, t6);
      temp2.set(1, 4, t7);
      temp2.set(3, 0, t8);
      temp2.set(1, 2, t9);
      temp2.set(1, 1, t10);

      System.out.println("First:");
      System.out.println(temp1);
      System.out.println("Second:");
      System.out.println(temp2);


      temp1.product(temp2);
      System.out.println("First = First * Second:");
      System.out.println(temp1);
      temp1.sum(temp2);
      System.out.println("First = First + Second:");
      System.out.println(temp1);

      System.out.println("-------------");
      System.out.println("UsualMatrix:\n");

      UsualMatrix tempUsual1 = new UsualMatrix(5, 5);
      SquareMatrix tempUsual2 = new SquareMatrix(5);

      tempUsual1.set(1, 2, t1);
      tempUsual1.set(1, 1, t2);
      tempUsual1.set(4, 3, t3);
      tempUsual1.set(1, 3, t4);
      tempUsual1.set(4, 1, t5);

      tempUsual2.set(3, 2, t6);
      tempUsual2.set(1, 4, t7);
      tempUsual2.set(3, 0, t8);
      tempUsual2.set(1, 2, t9);
      tempUsual2.set(1, 1, t10);

      System.out.println("First:");
      System.out.println(tempUsual1);
      System.out.println("Second:");
      System.out.println(tempUsual2);

      tempUsual1.product(tempUsual2);
      System.out.println("First = First * Second:");
      System.out.println(tempUsual1);
      tempUsual1.sum(tempUsual2);
      System.out.println("First = First + Second:");
      System.out.println(tempUsual1);

      System.out.println(temp1.equals(tempUsual1));


    } catch(RuntimeException exception) {
      System.out.println(exception);
    }
  }
}
