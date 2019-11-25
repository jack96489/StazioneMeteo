package Server;

import Shared.Settings;
import Shared.SocketUDP;

public class ServerManager {
    private static ServerManager INSTANCE;
    private final SocketUDP socket;

    public static ServerManager getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ServerManager();
        return INSTANCE;
    }

    private ServerManager() {
        this.luce = false;
        socket = new SocketUDP();
    }

    private boolean luce;

    public boolean isLuceAccesa() {
        return luce;
    }

    public synchronized void accendiLuce() {
        this.luce = true;
        socket.send("accendi luce", Settings.ARDUINO_PORT, "localhost");
    }

    public synchronized void spegniLuce() {
        this.luce = false;
        socket.send("spegni luce", Settings.ARDUINO_PORT, "localhost");
    }

    public synchronized void setLuce(boolean luce) {
        this.luce = luce;
    }
}
