public class Main {
  public static void main(String[] argv) {
    test2();
    test1();
  }

  public static void test1(){
    FormattedInput f = new FormattedInput();
    System.out.println("-----------------");
    System.out.println("|     test #2   |");
    System.out.println("-----------------");
    System.out.println("float, C3, string, string");
    Object[] t = f.scanf("%f %C3 %s %s");

    System.out.println("\nOutput: ");
    for (int i = 0; i < t.length; i++) {
      System.out.println(t[i]);
    }

    String line = "21 1 23 abcd";
    System.out.println("\nInput from line: " + line);
    t = f.sscanf("%f %f %d %s", line);
    
    System.out.println("\nOutput: ");
    for (int i = 0; i < t.length; i++) {
      System.out.println(t[i]);
    }
    System.out.println();
    System.out.println("-----------------");
  }

  public static void test2(){
    FormattedInput f = new FormattedInput();

    System.out.println("-----------------");
    System.out.println("|     test #1   |");
    System.out.println("-----------------");

    System.out.println("Input: char, string, decimal, char");
    Object[] t = f.scanf("%c %s %d %c");

    System.out.println("\nOutput: ");
    for (int i = 0; i < t.length; i++) {
      System.out.println(t[i]);
    }

    String line = "21 1 23.22 123.23";
    System.out.println("\nInput from line: " + line);
    t = f.sscanf("%d %d %f %s", line);

    System.out.print("\nOutput: ");
    for (int i = 0; i < t.length; i++) {
      System.out.println(t[i]);
    }
    System.out.println();

    System.out.println("-----------------");
  }
}
