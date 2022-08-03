package src.server;

import java.net.*;
import java.util.LinkedList;


import java.io.*;

public class TCPServer {

    private static LinkedList<User> users = new LinkedList<User>();

    public static void main(String[] argv) {
        int portNumber = Integer.parseInt(argv[0]);

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = null;
            InputServer input = new InputServer(serverSocket, users);
            input.start();

            while (serverSocket.isClosed() == false) {
                clientSocket = serverSocket.accept();
                User user = new User(clientSocket, users);
                users.add(user);
                user.start();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
            }
        }
        }
    }
}