/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared;

import java.io.IOException;
import java.net.*;

/**
 * @author turati_marco
 */
public class SocketUDP {
    // buffer di spedizione e ricezione
//    private byte[] bufferOUT = new byte[1024];
//    private byte[] bufferIN = new byte[1024];
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

    public void sendString(String msg, int port, String ip) {
        sendString(msg, new InetSocketAddress(ip, port));
    }

    public void sendString(String msg, SocketAddress address) {
        send(msg.getBytes(), address);
    }

    public String receiveString() {
        String ricevuto = new String(receive());

        // elaborazione dei dati ricevuti eliminando i caratteri in eccesso
        return ricevuto.substring(0, ultimoPacchettoRicevuto.getLength());
    }

    public void send(byte[] buffer, SocketAddress address) {
        try {
            //Creo il pacchetto da inviare
            DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, address);
            //Invio
            socket.send(sendPacket);

        } catch (IOException e) {
            System.out.println("Errore socket: " + e.toString());
        }
    }

    public void send(byte[] buffer, int port, String ip) {
        send(buffer, new InetSocketAddress(ip, port));
    }

    public byte[] receive() {
        try {
            //Creo l'allocazione del pacchetto da ricevere
            byte[] bufferIN = new byte[1024];
            ultimoPacchettoRicevuto = new DatagramPacket(bufferIN, bufferIN.length);

            //Aspetto il pacchetto
            socket.receive(ultimoPacchettoRicevuto);

            return bufferIN;

        } catch (IOException e) {
            System.out.println("Errore socket: " + e.toString());
            return null;
        }
    }

    public void sendByte(byte b, SocketAddress address) {
        send(new byte[]{b}, address);
    }

    public void sendByte(byte b, int port, String ip) {
        send(new byte[]{b}, new InetSocketAddress(ip, port));
    }

    public byte receiveByte() {
        return receive()[0];
    }

    public int getPort() {
        return ultimoPacchettoRicevuto.getPort();
    }

    public String getIP() {
        return ultimoPacchettoRicevuto.getAddress().toString();
    }

    public SocketAddress getSocketAddress() {
        return ultimoPacchettoRicevuto.getSocketAddress();
    }

    public void closeConnection() {
        socket.close();
    }
}
