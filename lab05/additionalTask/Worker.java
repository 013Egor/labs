public abstract class Worker implements IWorker {
  protected String name;
  protected double salary;
  protected int item;

  public Worker(String name) {
    this.name = name;
    salary = 0;
  }

  public void work() {
    System.out.println("====================");
    System.out.println("I start working");
    System.out.println("But I dont know what to do :(");
    System.out.println("====================");
  }

  public void giveSalary(int amount) {
    salary = amount;
  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return salary;
  }

  public void set(int amount) {
    item = amount;
  }
}
