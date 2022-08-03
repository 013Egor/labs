package src.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.ListIterator;

public class InputServer extends Thread {

    ServerSocket socket;
    LinkedList<User> users;

    public InputServer(ServerSocket socket, LinkedList<User> users) {
        this.socket = socket;
        this.users = users;
    }
    
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String command;
        try {
            while (true) {
                command = in.readLine();
                processInput(command);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }

    private void processInput(String line) throws Exception {
        if (line.equals("users")) {
            showUsers();
        } else if (line.equals("stop")) {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } 
            throw new Exception("Server is stoped");
        }
    }

    private void showUsers() {
        synchronized (users) {
            ListIterator<User> iterator = users.listIterator();
            User temp;
            System.out.println("------------------------");
            System.out.println("Availiable users: ");
            while (iterator.hasNext()) {
                temp = iterator.next();
                if (temp.isAlive()) {
                    System.out.println(temp.getUserName());
                } else {
                    iterator.previous();
                    iterator.remove();
                }
            }
            System.out.println("------------------------");
        }
    }
}
