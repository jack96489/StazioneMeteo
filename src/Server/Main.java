package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main {

    private static final DatiCondivisi dc = new DatiCondivisi();

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {

        try {
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
