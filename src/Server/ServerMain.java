package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerMain {

    private static final ServerManager dc = ServerManager.getInstance();

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {

        try {

            new ArduinoReceiveThread().start();

            final DatagramSocket socket = new DatagramSocket(8000);

            while (true) {
                byte[] bufferIN = new byte[1024];
                DatagramPacket dp = new DatagramPacket(bufferIN, bufferIN.length);
                socket.receive(dp);
                new ClientCommunicationThread(dp, socket, dc).start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
