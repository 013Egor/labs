import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sender extends Thread {

    DatagramSocket socket;
    InetAddress ipAddress;
    int port;
    String name = "Unknown";

    public Sender(DatagramSocket socket, InetAddress ipAddress, int port) {
        this.socket = socket;
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public Sender() {
        this.socket = null;
        this.ipAddress = null;
        this.port = -1;
    }

    public Sender(DatagramSocket socket, String address, int port) throws UnknownHostException {
        this.socket = socket;
        this.ipAddress = InetAddress.getByName(address);
        this.port = port;
    }

    public Sender(DatagramSocket socket, byte[] address, int port) throws UnknownHostException {
        this.socket = socket;
        this.ipAddress = InetAddress.getByAddress(address);
        this.port = port;
    }

    public void setSender(DatagramSocket socket, InetAddress ipAddress, int port) {
        this.socket = socket;
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public void run() {
        if (socket == null || ipAddress == null || port < 0) {
            return;
        }

        byte[] data = new byte[1024];
        try {
            while (true) {
                System.out.println("Input: ");
                BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
                String sentence = inFromUser.readLine();
                if (sentence.charAt(0) == '@') {

                    if (sentence.substring(1, 5).equals("quit")) {
                        socket.close();
                        break;
                    } else if (sentence.substring(1, 5).equals("name")) {
                        name = sentence.substring(6);
                    }
                } else {
                    sentence = "|from " + name + "| " + sentence; 
                    data = sentence.getBytes();
                    DatagramPacket sentData = new DatagramPacket(data, data.length, ipAddress, port);
                    socket.send(sentData);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}