/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfe.nebular.server;

import java.net.Socket;

/**
 *
 * @author user
 */
public class Client {
    
    Socket socket;
    int id;
    
    public Client(int tmpId, Socket tmpSocket){
        this.id = tmpId;
        this.socket = tmpSocket;
    }
}
