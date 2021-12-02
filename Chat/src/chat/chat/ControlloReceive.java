/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cassina_Giorgio
 */
public class ControlloReceive {

    InetAddress connectedIP = null;

    public void execute(DatagramPacket p) throws UnknownHostException, SocketException {
        byte[] buffer = p.getData();
        String action = new String(buffer).split(";")[0];
        System.out.println("ACTION: " + action);
        if (action.equals("a")) {
            connectedIP = p.getAddress();
            System.out.println(p.getData());
        } else if (p.getAddress().equals(connectedIP)) {
            switch (action) {
                case "c": {
                    connectedIP = null;
                    break;
                }
                case "m": {
                    String[] csv = new String(p.getData()).split(";");
                    String messaggio = csv[1];
                    System.out.println(messaggio);
                    break;
                }
                case "y": {
                    connectedIP = p.getAddress();
                    byte[] messaggioRiapertutra = p.getData();

                    break;
                }
                case "n": {
                    connectedIP = null;
                    break;
                }

            }
        }
    }
}

    
