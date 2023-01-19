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
    int totClient = 0;
    ArrayList<Client> tabClient = new ArrayList<Client>();
    
    public ThreadServer(int port){
        try {
            this.serverSocket = new ServerSocket(port);
            
            System.out.println("Server launching on port : " + port);
            this.create = true;
        } catch (IOException ex) {
            System.out.println("Server can not launch !");
            this.create = false;
        }
    }
    
    @Override
    public void run() {
        running = true;
        System.out.println("Server started !");
        while(running){
            try {
                Socket socket = serverSocket.accept();
                
                ThreadListening listening = new ThreadListening(socket);
                ThreadWriting writing = new ThreadWriting(socket);
                
                listening.start();
                writing.start();
                
                ConvPanel convPanel = new ConvPanel(writing);
                
                Server.getServer().add(convPanel).setVisible(true);
                
                
                totClient++;
                
                Client client = new Client(totClient, listening, writing, socket.getRemoteSocketAddress(), convPanel);
                
                tabClient.add(client);
                
                System.out.println("New Client accepted !");                
                
            } catch (IOException ex) {
                System.out.println("Server failed to accept client !");
            }
        }
        System.out.println("Exit while loop.");
    }

}
