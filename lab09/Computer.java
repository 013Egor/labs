public class Computer extends Thread {
    
    double time;
    int user;

    public Computer() {}

    public void setUser(int user) {
        this.user = user;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void run() {
        try {
            sleep((int)time * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}