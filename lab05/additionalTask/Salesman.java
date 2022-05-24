public class Salesman extends Worker {

  double coef;
  double addSalary;

  public Salesman (String name, double coef) {
    super(name);
    this.coef = coef;
  }

  public void work() {
    System.out.println("====================");
    System.out.println("Salesman " + name);
    System.out.println("I start working. I got " + item + " products");
    for (int i = 0; i < item; i++) {
      addSalary += coef * (i + 20);
    }
    System.out.println("====================");
  }

  public void giveSalary(int amount) {
    salary += amount + addSalary;
  }
}
