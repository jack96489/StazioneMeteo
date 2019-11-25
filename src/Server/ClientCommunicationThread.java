package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ClientCommunicationThread extends Thread {

    private final DatagramPacket packet;
    private final DatiCondivisi dati;
    private final DatagramSocket socket;

    public ClientCommunicationThread(DatagramPacket packet, DatagramSocket socket, DatiCondivisi dati) {
        this.packet = packet;
        this.dati = dati;
        this.socket = socket;
    }


    @Override
    public void run() {
        final int ricevuto = Integer.parseInt(new String(packet.getData()).substring(0, packet.getLength()));
        System.out.println("Ricevuto: " + ricevuto);
        String response = "";
        switch (ricevuto) {
            case 1:
                response = dati.isLuceAccesa() ? "Accesa" : "Spenta";
                break;
            case 2:
                dati.accendiLuce();
                response = "Luce accesa";
                break;
            case 3:
                dati.spegniLuce();
                response = "Luce spenta";
                break;
            default:
                System.err.println("OOOOO");
                break;
        }
        DatagramPacket dp = new DatagramPacket(response.getBytes(), response.length(), packet.getSocketAddress());
        try {
            socket.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
