/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfe.nebular.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class ThreadServer extends Thread {

    ServerSocket serverSocket;
    boolean create = false, running = false;
    ArrayList<Client> tabClient;
    int totClient = 0;
    JTextField MsgText;
    
    public ThreadServer(int port, JTextField TmpMsgText){
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("Server launching on port : " + port);
            this.create = true;
            this.MsgText = TmpMsgText;
        } catch (IOException ex) {
            System.out.println("Server can not launch !");
            this.create = false;
        }
    }
    
    @Override
    public void run() {
        running = true;
        System.out.println("running");
        while(running){
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New Client accepted !");
                totClient++;
                Client client = new Client(totClient, socket);
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                try {
                    Message msg = (Message) in.readObject();
                    System.out.println(msg.exp +" -> " + msg.dest + "|" + msg.date + "|" + msg.content);
                } catch (ClassNotFoundException ex) {
                    System.out.println("raté");
                }
                
            } catch (IOException ex) {
                System.out.println("Server failed to accept client !");
            }
        }
        System.out.println("Exit while loop.");
    }
    

}
