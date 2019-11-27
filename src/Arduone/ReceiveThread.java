package Arduone;

import Shared.Settings;
import Shared.SocketUDP;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

import java.io.IOException;
import java.util.Arrays;

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
        seriale = new SerialPort("COM3");
        try {
            seriale.openPort();
            seriale.setParams(9600, 8, 2, 0);   //valori a caso che sembrano andare
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        while (true) {
            final byte ris = socket.receiveByte();
            System.out.println(ris);
            try {
                seriale.writeByte(ris);
                sleep(50);
                System.out.println(seriale.readString());
                sleep(1);
            } catch (SerialPortException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
