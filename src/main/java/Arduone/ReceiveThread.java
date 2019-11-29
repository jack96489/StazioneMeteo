package Arduone;

import Shared.Settings;
import Shared.SocketUDP;
import purejavacomm.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Ascolta le richieste provenienti dal server e destinate ad Arduone
 */
public class ReceiveThread extends Thread {

    private final SocketUDP socket;
    private final Seriale seriale;

    public ReceiveThread(Seriale seriale) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, IOException {
        socket = new SocketUDP(Settings.ARDUINO_PORT);
        this.seriale = seriale;

    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        while (true) {
            final byte ris = socket.receiveByte();
            System.out.println(ris);
            try {
                seriale.send(ris);
                sleep(50);
//                System.out.println(ins.read());
//                sleep(1);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
