package Client;

import Shared.Settings;
import Shared.SocketUDP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {

        int portaServer = Settings.SERVER_PORT;    //porta del server
        String ip = "localhost";
        String scelta = "";
        Scanner sc = new Scanner(System.in);
        SocketUDP client = new SocketUDP();
        String StringaDelServer = "";

        while (!scelta.equals("Esci")) {
            System.out.println("Seleziona cosa fare, digita [1], per fare vedere se On/Off, [2] per accendere, [3] per spegnere, [Esci] per terminare tutto");

            scelta = sc.nextLine(); // 1 accesa o spenta, 2 lo accende, il 3 lo spegne
            System.out.println("hai selezionato " + scelta);

            switch (scelta) {
                case "1":
                    client.send("1", portaServer, ip);//invio il comando
                    break;
                case "2":
                    client.send("2", portaServer, ip);//invio il comando
                    break;
                case "3":
                    client.send("3", portaServer, ip);//invio il comando
                    break;
            }
            //Dopo che mando il comando devo aspettare la risposta
            StringaDelServer = client.receive();
            System.out.println(StringaDelServer);
        }
        client.closeConnection();
    }
}
