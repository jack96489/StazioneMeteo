package Server;


import Shared.Settings;
import Shared.SocketUDP;

/**
 * Riceve i dati dall'Arduone e li salva
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

            //Riceve il valore del potenziometro aggiornato
            if (ris.startsWith("4:")) {
                System.out.println(ris.split(":")[1]);
                final int pot = Integer.parseInt(ris.split(":")[1]);
                dati.setPotenziometro(pot);
                System.out.println(pot + "---" + dati.getPotenziometro());
                continue;
            }

            //Riceve dall'Arduone i dati sullo stato della luce
            switch (ris) {
                case "luce spenta":
                    if (dati.isLuceAccesa())
                        dati.setLuce(false);
                    break;
                case "luce accesa":
                    if (!dati.isLuceAccesa())
                        dati.setLuce(true);
                    break;
            }
        }
    }
}
