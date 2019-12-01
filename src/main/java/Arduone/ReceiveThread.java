package Arduone;

import Shared.Settings;
import Shared.SocketUDP;

import java.io.IOException;

/**
 * Ascolta le richieste provenienti dal server e destinate ad Arduone
 *
 * @author Giacomo Orsenigo
 */
public class ReceiveThread extends Thread {

    private final SocketUDP socket;
    private final Seriale seriale;

    public ReceiveThread(Seriale seriale) {
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
