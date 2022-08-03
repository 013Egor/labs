package src.server;

import src.message.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class User extends Thread {

    String name = "undefind";
    LinkedList<User> users;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;
    Protocol protocol;

    public User(Socket socket, LinkedList<User> users) { 
        this.clientSocket = socket; 
        this.users = users;
        protocol = new Protocol();
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        try {
            String inputLine, outputLine;
            out.println("Enter your name (input: @name):");
            
            while ((inputLine = in.readLine()) != null) {
                outputLine = protocol.processInput(inputLine);
                out.println(outputLine);
            } 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getUserName() { return name; }

    public void send(String message) {
        out.println(message);
    }

    private class Protocol {
        
        public String processInput(String message) {
            String[] lines = message.split("[|]");

            if (name.equals("undefind")){
                return setName(lines[0]);

            } else {
                if (lines[0].charAt(0) == '0') {
                    sendMessage(getMessage(lines));
                    return "OK: Got message";
                
                } else if (lines[0].charAt(0) == '1') {
                    return getUserList();
                } 
            }

            return "ERROR";
        }

        private String setName(String line) {
            if (line.charAt(0) == '@') {
                if (isActive(line.substring(1))) {
                    return "You cannot use this name. Try again";
                } else {
                    name = line.substring(1);
                    return "Name " + name + " is received";
                }            
            } else {
                return "Cannot read your name (expected: @name)";
            }
        }

        private Message getMessage(String[] lines) {
            StringBuilder tempMessage = new StringBuilder();
            for (int i = 1; i < lines.length; i++) {
                tempMessage.append(lines[i] + "|");
            }

            return new Message(tempMessage.toString());
        }

        private void sendMessage(Message message) {
            Iterator<User> iteratorUsers = users.iterator();
            User user = null;
            while (iteratorUsers.hasNext()) {
                user = iteratorUsers.next();
                if (user.getUserName().equals(message.getNameTo())) {
                    user.send("1|" + message);
                    break;
                }
            } 
        }

        private String getUserList() {
            StringBuilder list = null;
            synchronized (users) {
                list = new StringBuilder();

                list.append("2|Availiable users:|");
                list.append("------------------------");
                ListIterator<User> iterator = users.listIterator();
                User temp;
                while (iterator.hasNext()) {
                    temp = iterator.next();
                    if (temp.isAlive()) {
                        list.append("|" + temp.getUserName());
                    } else {
                        iterator.previous();
                        iterator.remove();
                    }
                }
                list.append("|------------------------|");
                return list.toString();
            }
        }

        private boolean isActive(String name) {
            ListIterator<User> iterator = users.listIterator();

            while (iterator.hasNext()) {
                if (iterator.next().getUserName().equals(name)) {
                    return true;
                }
            }

            return false;
        }  
    }
}