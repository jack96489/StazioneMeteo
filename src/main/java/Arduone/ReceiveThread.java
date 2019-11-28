package Arduone;

import Shared.Settings;
import Shared.SocketUDP;
import purejavacomm.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Ascolta le richieste provenienti dal server e destinate ad Arduone
 */
public class ReceiveThread extends Thread {

    private final SocketUDP socket;
    private final SerialPort seriale;
    final OutputStream outs;
    final InputStream ins;

    public ReceiveThread() throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, IOException {
        socket = new SocketUDP(Settings.ARDUINO_PORT);
        // getting serial ports list into the array
        CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier("COM3");


        seriale = (SerialPort) portId.open("test", 2000);
        seriale.notifyOnDataAvailable(true);
        seriale.notifyOnOutputEmpty(true);
        seriale.setFlowControlMode(SerialPort.FLOWCONTROL_XONXOFF_IN + SerialPort.FLOWCONTROL_XONXOFF_OUT);
        seriale.setSerialPortParams(9600, 8, 2, 0);
        outs = seriale.getOutputStream();
        ins = seriale.getInputStream();

//        try {
//            seriale.openPort();
//            seriale.setParams(9600, 8, 2, 0);   //valori a caso che sembrano andare
//        } catch (SerialPortException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        while (true) {
            final byte ris = socket.receiveByte();
            System.out.println(ris);
            try {
                outs.write(ris);
                sleep(50);
                System.out.println(ins.read());
                sleep(1);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
