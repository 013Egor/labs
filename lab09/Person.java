public class Person extends Thread {
    String name;
    Person relative;

    public Person(String name) {
        this.name = name;
    }

    void setRelative(Person person) {
        relative = person;
    }

    public synchronized void talk(Person person) {
        System.out.println("I want to talk with " + person.name + " but I dont want do it first");
        person.talk(this);
    }

    public void run() {
        this.talk(relative);
    }
}