package src.client;

import src.message.*;

import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;

public class TCPClient {

    private static LinkedList<Message> sent = new LinkedList<Message>();
    private static LinkedList<Message> received = new LinkedList<Message>();

    public static void main(String[] argv) {

        if (argv.length != 2) { return; }

        try {
            InetAddress ip = InetAddress.getByAddress(getIP(argv[0]));
            int port = Integer.parseInt(argv[1]);


            Socket socket = new Socket(ip, port);
            ClientReceiver receiver = new ClientReceiver(socket, received);
            ClientInput input = new ClientInput(socket, sent, received);

            receiver.start();
            input.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static byte[] getIP(String a) {
        String[] address = a.split("[.]");
        byte[] ipAddress = new byte[address.length];

        for (int i = 0; i < ipAddress.length; i++) {
            ipAddress[i] = Byte.parseByte(address[i]);
        }

        return ipAddress;
    } 
}