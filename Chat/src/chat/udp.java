/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author User
 */
public class udp {
    
    private DatagramSocket socket_Server;
    private DatagramPacket pack_Client; //pacchetti che arrivano dal client
    private DatagramPacket data_Server;
    private byte buffer[] = new byte[8192];
    private int PORTclient;
    private InetAddress IPclient;
    
    public udp(int PORT) throws SocketException{
        
        socket_Server = new DatagramSocket(PORT);
        
    }
    
    public void UDP_datagram_packet(){
    
        data_Server = new DatagramPacket(buffer,buffer.length);
    }
    
    public void UDP_recive() throws IOException{
    
        pack_Client = new DatagramPacket(buffer,buffer.length);
        socket_Server.receive(pack_Client);
        
    }
    public void UDP_send(String message) throws IOException{
    
        data_Server = new DatagramPacket(message.getBytes(),message.length(),IPclient,PORTclient);
        socket_Server.send(data_Server);
    }
    public String UDP_getData(){
    
        int numByte = pack_Client.getLength();
        PORTclient = pack_Client.getPort();
        IPclient = pack_Client.getAddress();
        String Message = pack_Client.toString();
        
        return Message;
    }
    
}
