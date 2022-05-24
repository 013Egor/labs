public class Main {
  public static void main(String[] argv) {
    Accountant accountant = new Accountant("John", true);
    //Waiters waiter = new Waiters("Dima");
    Salesman salesman = new Salesman("Vova", 0.1);

    double money = 0;
    //waiter.set(14);
    salesman.set(9);
    //waiter.work();
    salesman.work();


    salesman.giveSalary(100);
    //waiter.giveSalary(30);

    money += salesman.getSalary();
    //money += waiter.getSalary();

    accountant.set(money);
    accountant.work();

    accountant.giveSalary(1000);

    money += accountant.getSalary();
    System.out.println("total = " + money);
  }
}
