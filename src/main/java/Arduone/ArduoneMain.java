package Arduone;

import Shared.Settings;
import Shared.SocketUDP;
import purejavacomm.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.TooManyListenersException;

//import jssc.SerialPort;

public class ArduoneMain {
    //SerialPort a;

    public static void main(String[] args) {

        try {
            final Seriale seriale = new Seriale();
            new ReceiveThread(seriale).start();
            SocketUDP socket = new SocketUDP();
            seriale.getPort().addEventListener(event -> {
                if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
                    try {
                        String receive = seriale.receiveString();
                        System.out.println(receive);
                        System.out.println(receive.length());
                        if (receive.startsWith("4:")) {
                            socket.sendString(receive, Settings.SERVER_ARDUINO_PORT, Settings.SERVER_IP);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (PortInUseException | UnsupportedCommOperationException | IOException | TooManyListenersException | NoSuchPortException e) {
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
