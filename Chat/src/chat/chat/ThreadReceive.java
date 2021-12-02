/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cassina_Giorgio
 */
public class ThreadReceive extends Thread {

    udp udp;
    
    public ThreadReceive(udp udp) {
        this.udp = udp;
    }

    @Override
    public void run() {

        while (true) {

            try {
                udp.UDP_receive();
            } catch (SocketException ex) {
                Logger.getLogger(ThreadReceive.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ThreadReceive.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String messaggio = new String(udp.UDP_getData());

            System.out.println(messaggio.trim());


        }

    }
}
