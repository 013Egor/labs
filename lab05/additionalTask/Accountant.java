public class Accountant extends Worker{

  boolean additive;

  double allMoney;

  double add;

  public Accountant(String name, boolean additive) {
    super(name);
    this.additive = additive;
    this.allMoney = 0;
    this.add = 0;
  }

  public void work() {
    System.out.println("====================");
    System.out.println("Accountant " + name);
    if (allMoney > 100) {
      System.out.println("I am done");
      add = 100;
    }
    System.out.println("====================");
  }

  public void giveSalary(double amount) {
    salary += amount + add;
  }

  public void set(double amount) {
    allMoney += amount;
  }
}
