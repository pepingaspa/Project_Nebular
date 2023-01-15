/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfe.nebular.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ThreadServer extends Thread {

    ServerSocket serverSocket;
    boolean create = false, running = false;
    ArrayList<Client> tabClient;
    int totClient = 0;
    
    public ThreadServer(int port){
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server launching on port : " + port);
            create = true;
        } catch (IOException ex) {
            System.out.println("Server can not launch !");
            create = false;
        }
    }
    
    @Override
    public void run() {
        running = true;
        System.out.println("running");
        while(running){
            try {
                Socket socket = serverSocket.accept();
                
                totClient++;
                Client client = new Client(totClient, socket);
                tabClient.add(client);
                
                
            } catch (IOException ex) {
                System.out.println("Server failed to accept client !");
            }
        }
        System.out.println("Exit while loop.");
    }
    

}
