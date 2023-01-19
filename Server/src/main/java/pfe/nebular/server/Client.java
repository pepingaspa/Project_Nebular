/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfe.nebular.server;

import java.net.SocketAddress;

/**
 *
 * @author user
 */
public class Client {
    
    ThreadListening listening;
    ThreadWriting writing;
    int idClient;
    SocketAddress ipClient;
    ConvPanel convPanel;

    
    public Client(int tmpId, ThreadListening tmpListening, ThreadWriting tmpWriting, SocketAddress tmpIp, ConvPanel tmpConvPanel){
        this.idClient = tmpId;
        this.listening = tmpListening;
        this.writing = tmpWriting;
        this.ipClient = tmpIp;
        this.convPanel = tmpConvPanel;
    }
    
    
}
