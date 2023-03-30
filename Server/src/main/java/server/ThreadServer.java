package server;

import classes.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadServer extends Thread {

    ServerSocket serverSocket;
    boolean create = false, running = false;
    static int totClient = 0;
    
    static ArrayList<Entity> tabEntity = new ArrayList<>();
    static ArrayList<Conversation> tabConv;
    static ArrayList<User> tabUser;
    
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
            Socket socket;
            try {
                socket = serverSocket.accept();
                
                ThreadAuthent threadAuthent = new ThreadAuthent(socket);
                threadAuthent.start();
                
            } catch (IOException ex) {
                Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Exit while loop.");
    }
    
    
    static ArrayList<Entity> getTabEntity(){
        return tabEntity;
    }
    
    public static void increClient(){
        totClient++;
        Server.getServer().MonitTotClient.setText(totClient+"");
    }
    
    static Conversation getConv(int id){
        for(Conversation conv : tabConv){
            if(conv.id == id){
                return conv;
            }
        }
        return null;
    }
}
