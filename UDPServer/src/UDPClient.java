import java.net.DatagramSocket;

public class UDPClient {

    public static void main(String[] argv) {
        if (argv.length != 3) {
            return;
        }

        String[] ip = argv[0].split("[.]");
        int portReceiver = Integer.parseInt(argv[1]);
        int portSender = Integer.parseInt(argv[2]);
        byte[] ipAddress = new byte[4];
        for (int i = 0; i < ip.length; i++) {
            ipAddress[i] = (byte) Integer.parseInt(ip[i]);
        }


        try {
            DatagramSocket clientSocket = new DatagramSocket(portReceiver);
            Receiver receiver = new Receiver(clientSocket);
            Sender sender = new Sender(clientSocket, ipAddress, portSender);
            receiver.start();
            sender.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
