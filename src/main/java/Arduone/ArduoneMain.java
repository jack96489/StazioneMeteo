package Arduone;

import purejavacomm.NoSuchPortException;
import purejavacomm.PortInUseException;
import purejavacomm.UnsupportedCommOperationException;

import java.io.IOException;

//import jssc.SerialPort;

public class ArduoneMain {
    //SerialPort a;

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        try {
            new ReceiveThread().start();
        } catch (NoSuchPortException | UnsupportedCommOperationException | IOException | PortInUseException e) {
            e.printStackTrace();
        }

//
//        //Mando a caso luce accesa e spenta ogni 10 secondi
//        //Simula dei comandi mandati da Arduino via seriale
//        SocketUDP socket = new SocketUDP();
//        Random rn = new Random();
//        while (true) {
//
//            if (rn.nextBoolean()) {
//                System.out.println("Accendo la luce...");
//                socket.send("luce accesa", Settings.SERVER_ARDUINO_PORT, "localhost");
//            } else {
//                System.out.println("Spengo la luce...");
//                socket.send("luce spenta", Settings.SERVER_ARDUINO_PORT, "localhost");
//            }
//
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
} 
