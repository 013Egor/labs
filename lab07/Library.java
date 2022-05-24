import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Library {
    private class Book {
        String name;
        String author;
        int year;

        public Book(String name, String author, int year) {
            this.name = name;
            this.author = author;
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public int getYear() {
            return year;
        }

        public String getData() {
            return name + "|" + author + "|" + year + "\n";
        }

        public String toString() {
            return "Name: " + name +  "\nAuthor: " + author + "\nYear: " + year; 
        }
    }

    LinkedList<Book> list;

    public Library() {
        list = new LinkedList<Book>();
    }

    public void add(String name, String author, int year) {
        Book book = new Book(name, author, year);
        list.add(book);
    }

    public void remove(String name) {
        ListIterator<Book> it = list.listIterator();

        while (it.hasNext()) {
            if (it.next().getName().equals(name)) {
                it.previous().getName();
                it.remove();
                break;
            }
        }
    }

    public String find(String name) {
        Iterator<Book> it = list.iterator();
        Book temp = null;

        while (it.hasNext()) {
            temp = it.next();
            if (temp.getName().equals(name)) {
                return temp.toString();
            }
        }

        return "I cannot find this book";
    }

    public String find(int minYear) {
        Iterator<Book> it = list.iterator();
        Book temp = null;
        StringBuilder bookList = new StringBuilder();

        while (it.hasNext()) {
            temp = it.next();
            if (temp.getYear() > minYear) {
                bookList.append(temp);
                bookList.append("\n----------------\n");
            }
        }

        return bookList.toString();
    }

    public void save(String filename) {
        BufferedWriter dis = null;
        try {
            dis = new BufferedWriter(new FileWriter(filename));

            Iterator<Book> it = list.iterator();

            while (it.hasNext()) {
                dis.write(it.next().getData());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                dis.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void load(String filename) {
        BufferedReader dis = null;
        Book book = null;
        try {
            dis = new BufferedReader(new FileReader(filename));
            String line;
            String[] temp;
            int value;
            while ((line = dis.readLine())!= null) {
                temp = line.split("[|]");
                if (temp.length != 3) {
                    throw new Exception("Wrong input file");
                }
                value = Integer.parseInt(temp[2]);
                book = new Book(temp[0], temp[1], value);
                list.add(book);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                dis.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String toString() {
        Iterator<Book> it = list.iterator();
        StringBuilder bookList = new StringBuilder();

        while (it.hasNext()) {
            bookList.append(it.next());
            bookList.append("\n----------------\n");
        }

        return bookList.toString();
    }
}