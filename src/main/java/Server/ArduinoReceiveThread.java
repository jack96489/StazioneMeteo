package Server;


import Shared.Settings;
import Shared.SocketUDP;

/**
 * Riceve i dati dal client collegato all'Arduone e li elabora
 *
 * @author Giacomo Orsenigo
 */
public class ArduinoReceiveThread extends Thread {

    private final SocketUDP socket;

    public ArduinoReceiveThread() {
        socket = new SocketUDP(Settings.SERVER_ARDUINO_PORT);
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        final ServerManager dati = ServerManager.getInstance();
        while (true) {

            final String ris = socket.receiveString();

            switch (ris.charAt(0)) {
                case '2':
                    if (dati.isLuceAccesa())
                        dati.setLuce(false);
                    break;
                case '3':
                    if (!dati.isLuceAccesa())
                        dati.setLuce(true);
                    break;
                case '4':
                    final int pot = Integer.parseInt(ris.split(":")[1]);
                    dati.setPotenziometro(pot);
                    break;
                default:
                    System.out.println(ris);
                    break;
            }
        }
    }
}
