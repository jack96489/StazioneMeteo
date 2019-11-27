package Arduone;

import Shared.Settings;
import Shared.SocketUDP;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

import java.io.IOException;

/**
 * Ascolta le richieste provenienti dal server e destinate ad Arduone
 */
public class ReceiveThread extends Thread {

    private final SocketUDP socket;
    private final SerialPort seriale;

    public ReceiveThread() {
        socket = new SocketUDP(Settings.ARDUINO_PORT);
        // getting serial ports list into the array
        String[] portNames = SerialPortList.getPortNames();

        if (portNames.length == 0) {
            System.out.println("There are no serial-ports :( You can use an emulator, such ad VSPE, to create a virtual serial port.");
        }

        for (String portName : portNames) {
            System.out.println(portName);
        }
        seriale = new SerialPort("COM1");
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        while (true) {
            final String ris = socket.receive();
            System.out.println(ris);
            try {
                seriale.writeString(ris);
            } catch (SerialPortException e) {
                e.printStackTrace();
            }
        }
    }
}
