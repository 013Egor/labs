import java.util.Random;

public class Main {
    public static void main(String[] argv) {
        Person masha = new Person("Masha");
        Person vasya = new Person("Vasya");
        masha.setRelative(vasya);
        vasya.setRelative(masha);
        masha.start();
        vasya.start();

        /*Random rand = new Random();
        
        int computerAmount = 5;
        int userAmount = 3;
        Computer[] pc = new Computer[computerAmount];
        double time;

        System.out.println("Available PC:");

        for (int i = 0; i < computerAmount; i++) {
            pc[i] = new Computer();
            System.out.println("-- PC #" + i);
        }
        System.out.println("---------------------");
        int j = 0;
        for (int i = 0; i < userAmount; i++) {
            while (true){
                j = j % computerAmount;
                if (pc[j].isAlive() == false) {
                    pc[j] = new Computer();
                    pc[j].setUser(i);
                    time = rand.nextInt(30);
                    if (time < 4) time = 5;
                    pc[j].setTime(time);
                    System.out.println("++ PC #" + j + " is unavailable for " + time * 4 + " min" + "(user " + i + ")"); 
                    pc[j].start();
                    break;
                }
                j++;
            }
        }*/
    }
}