/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author turati_marco
 */
public class SocketUDP {
    // buffer di spedizione e ricezione
    private byte[] bufferOUT = new byte[1024];
    private byte[] bufferIN = new byte[1024];
    private DatagramSocket socket;
    private DatagramPacket ultimoPacchettoRicevuto;

    public SocketUDP() {
        try {
            socket = new DatagramSocket();
            System.out.println("Client ready!");

        } catch (SocketException e) {
            System.out.println("Errore socket: " + e.toString());
        }

    }

    public SocketUDP(int port) {
        try {
            socket = new DatagramSocket(port);
            System.out.println("Server ready!");

        } catch (SocketException e) {
            System.out.println("Errore socket: " + e.toString());
        }

    }

    public void send(String msg, int port, String ip) {
        try {
            //Preparo il buffer output
            bufferOUT = msg.getBytes();
            //Creo il pacchetto da inviare
            DatagramPacket sendPacket = new DatagramPacket(bufferOUT, bufferOUT.length, InetAddress.getByName(ip), port);
            //Invio
            socket.send(sendPacket);

        } catch (IOException e) {
            System.out.println("Errore socket: " + e.toString());
        }
    }

    public String receive() {
        try {
            //Creo l'allocazione del pacchetto da ricevere
            ultimoPacchettoRicevuto = new DatagramPacket(bufferIN, bufferIN.length);

            //Aspetto il pacchetto
            socket.receive(ultimoPacchettoRicevuto);

            String ricevuto = new String(ultimoPacchettoRicevuto.getData());

            // elaborazione dei dati ricevuti eliminando i caratteri in eccesso
            return ricevuto.substring(0, ultimoPacchettoRicevuto.getLength());

        } catch (IOException e) {
            System.out.println("Errore socket: " + e.toString());
            return null;
        }
    }

    public int getPort() {
        return ultimoPacchettoRicevuto.getPort();
    }

    public String getIP() {
        return ultimoPacchettoRicevuto.getAddress().toString();
    }

    public void closeConnection() {
        socket.close();
    }
}
