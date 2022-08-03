import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver extends Thread {

    DatagramSocket socket;
    byte[] data = new byte[1024];
    DatagramPacket receivedPacket = new DatagramPacket(data, data.length);
    public boolean isReceived = false;

    public Receiver(DatagramSocket socket) throws Exception {
        if (socket.isClosed()) {
            throw new Exception("Caanot open recieving socket");
        }
        this.socket = socket;
    }

    public void run() {
        try {
            while (true) {
                    socket.receive(receivedPacket);
                    isReceived = true;
                    System.out.println("RECEIVED: " + new String(receivedPacket.getData()));
            }
        } catch (IOException e) {
        System.out.println(e.getMessage());
        }
    }
}