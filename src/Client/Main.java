package Client;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class Main {

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {

        int portaServer = 8000;	//porta del server
        String ip = "172.16.102.168";
        String scelta = "";
        Scanner sc = new Scanner(System.in);
        socketUDP client = new socketUDP();
        String StringaDelServer="";

        while (!scelta.equals("Esci")) {
            System.out.println("Seleziona cosa fare, digita [1], per fare vedere se On/Off, [2] per accendere, [3] per spegnere, [Esci] per terminare tutto");

            scelta = sc.nextLine(); // 1 accesa o spenta, 2 lo accende, il 3 lo spegne
            System.out.println("hai selezionato " + scelta);
            
            if (scelta.equals("1")) {

                client.send("1", portaServer, ip);//invio il comando

            } else if (scelta.equals("2")) {

                client.send("2", portaServer, ip);//invio il comando

            } else if (scelta.equals("3")) {

                client.send("3", portaServer, ip);//invio il comando

            }
            //Dopo che mando il comando devo aspettare la risposta
            StringaDelServer = client.receive();
            System.out.println(StringaDelServer);
        }
        client.closeConnection();
    }
}
