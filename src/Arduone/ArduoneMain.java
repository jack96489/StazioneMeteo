package Arduone;

import Shared.Settings;
import Shared.SocketUDP;
//import jssc.SerialPort;

import java.util.Random;

public class ArduoneMain {
    //SerialPort a;

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        new ReceiveThread().start();


        //Mando a caso luce accesa e spenta
        SocketUDP socket = new SocketUDP();
        Random rn = new Random();
        while (true) {

            if (rn.nextBoolean()) {
                System.out.println("Accendo la luce...");
                socket.send("luce accesa", Settings.SERVER_ARDUINO_PORT, "localhost");
            } else {
                System.out.println("Spengo la luce...");
                socket.send("luce spenta", Settings.SERVER_ARDUINO_PORT, "localhost");
            }

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
} 
