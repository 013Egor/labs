package src.client;

import src.message.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.LinkedList;

public class ClientReceiver extends Thread {
    
    LinkedList<Message> received;
    Socket socket;
    BufferedReader inServer;

    public ClientReceiver(Socket socket, LinkedList<Message> messages) throws IOException {
        this.received = messages;
        this.socket = socket;
        inServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() {
        String fromServer;

        try {
            while ((fromServer = inServer.readLine()) != null) {
                processInput(fromServer);
                fromServer = null;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Receiver is crushed. Please reload.");
        }
    }

    private synchronized void processInput(String input) {
        if (input.charAt(0) == '1') {
            input = input.substring(2);
            received.add(new Message(input));
        } else if (input.charAt(0) == '2'){
            input = input.substring(1);
            System.out.println(input.replace('|', '\n'));
        } else {
            System.out.println("Server: " + input.replace('|', '\n'));
        }
    }
}
