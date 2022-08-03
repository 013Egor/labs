package src.client;

import src.message.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;

public class ClientInput extends Thread {
    
    private static final String[] options = {"Send message", 
        "Show available users", "Show received messages", 
        "Show sent messages", "quit" };
    
    Socket socket;
    String name;
    LinkedList<Message> sent;
    LinkedList<Message> received;
    BufferedReader in;
    PrintWriter out;
    

    public ClientInput (Socket socket, LinkedList<Message> sent, LinkedList<Message> recevied) throws IOException {
        this.socket = socket;
        this.sent = sent;
        this.received = recevied;
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void run() {
        String line;

        try {
            while ((line = in.readLine()) != null) {
                processInput(line);
                if (line.equals("help")) {
                    getMenu();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getMenu() {
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + ": " + options[i]);
        }
    }

    public void processInput(String input) throws IOException {
        if (input.length() < 1) {
            return;
        }
        switch (input.charAt(0)) {
            case '0':
                sendMessage();
                break;
            case '1':
                out.println("1");
                break;
            case '2':
                showReceivedMessage();
                break;
            case '3':
                showSentMessage();
                break;
            case '4':
                socket.close();
                throw new IOException("Client is closed");
            case '@':
                name = input.substring(1);
                out.println("@" + name);
                break;
            default:
                System.out.println("You made mistake. Try again");
                break;
        }
    }

    private void sendMessage() {
        try {
            System.out.print("Whom you want to text: ");
            String to = in.readLine();
            System.out.println("Enter text of message:");
            StringBuilder text = new StringBuilder();
            String line;
            while (true) {
                line = in.readLine();
                if (line.equals("quit")) {
                    break;
                }
                text.append(line);
            } 
            Message message = new Message(name, to, text.toString());
            sent.add(message);
            out.println("0|" + message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void showReceivedMessage() {
        Iterator<Message> itReceived = received.iterator();
        System.out.println("---------------------------\nReceived messages:");
        while (itReceived.hasNext()) {
            System.out.println("---------------------------");
            itReceived.next().showMessage();;
        }
        System.out.println("---------------------------");
    }

    private void showSentMessage() {
        Iterator<Message> itSent = sent.iterator();
        System.out.println("---------------------------\nSent messages:");
        while (itSent.hasNext()) {
            System.out.println("---------------------------");
            itSent.next().showMessage();
        }
        System.out.println("---------------------------");
    }
}