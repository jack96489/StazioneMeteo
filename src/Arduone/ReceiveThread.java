package Arduone;

import Shared.Settings;
import Shared.SocketUDP;

/**
 * Ascolta le richieste provenienti dal server e destinate ad Arduone
 */
public class ReceiveThread extends Thread {

    private SocketUDP socket;

    public ReceiveThread() {
        socket = new SocketUDP(Settings.ARDUINO_PORT);
    }

    @Override
    public void run() {
        while (true) {
            final String ris = socket.receive();
            System.out.println(ris);
        }
    }
}
