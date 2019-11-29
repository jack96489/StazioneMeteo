package Arduone;

import purejavacomm.CommPortIdentifier;
import purejavacomm.PortInUseException;
import purejavacomm.SerialPort;
import purejavacomm.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.util.*;

public class Seriale {
    private final SerialPort port;
    private final InputStream inputStream;
    private final OutputStream outputStream;

    public Seriale() throws PortInUseException, IOException, UnsupportedCommOperationException {
        port = selectSerialPort();
        port.notifyOnDataAvailable(true);
        port.notifyOnOutputEmpty(true);
        port.setFlowControlMode(SerialPort.FLOWCONTROL_XONXOFF_IN + SerialPort.FLOWCONTROL_XONXOFF_OUT);
        port.setSerialPortParams(9600, 8, 2, 0);
        inputStream = port.getInputStream();
        outputStream = port.getOutputStream();
    }

    private SerialPort selectSerialPort() throws PortInUseException {
        final Scanner scanner = new Scanner(System.in);
        final Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();
        List<CommPortIdentifier> porte = Collections.list(portList);
        System.out.println("Seleziona una porta tra le seguenti:");
        for (int i = 0; i < porte.size(); i++) {
            CommPortIdentifier portId = porte.get(i);
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                System.out.println(i + 1 + ". " + portId.getName());
                i++;
            } else {
                porte.remove(i);
                i--;
            }
        }

        int scelta = scanner.nextInt();
        scanner.nextLine();
        while (scelta <= 0 || scelta > porte.size()) {
            scelta = scanner.nextInt();
            scanner.nextLine();
        }

        return (SerialPort) porte.get(scelta - 1).open("Stazione meteo", 2000);
    }


    public void send(byte[] buffer) throws IOException {
        outputStream.write(buffer);
    }

    public void send(byte byteToSend) throws IOException {
        outputStream.write(byteToSend);
    }

    public String receiveString() throws IOException {
        byte[] buffer = new byte[128];
        byte read;
        int i = 0;
        do {
            read = (byte) inputStream.read();
            if (read != '\n' && read != '\r')
                buffer[i++] = read;
        } while (read != '\n' && read != '\r');
        return new String(buffer).substring(0, i);
    }

    public SerialPort getPort() {
        return port;
    }
}
