import java.util.Random;

public class Waiters extends Worker {

  double tips;

  public Waiters (String name) {
    super(name);
    tips = 0;
  }

  public void work() {
    System.out.println("====================");
    System.out.println("Waiter " + name);
    Random rand = new Random();
    System.out.println("I should serve " + item);
    double temp = 0;
    for (int i = 0; i < item; i++) {
      temp = rand.nextInt() % 100;
      if (temp < 0) {
        temp = -temp;
      }
      System.out.println("Person #" + (i + 1) +  ". Got " + temp + " tips");
      tips += temp;
    }
    System.out.println("All tips: " + tips);
    System.out.println("====================");
  }

  public void giveSalary(double amount) {
    salary += amount + tips;
  }
}
