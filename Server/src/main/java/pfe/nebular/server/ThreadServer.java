package pfe.nebular.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadServer extends Thread {

    ServerSocket serverSocket;
    boolean create = false, running = false;
    int totClient = 0;
    
    static ArrayList<Entity> tabEntity = new ArrayList<Entity>();
    
    
    Conversation conv1 = new Conversation(1);
    Conversation conv2 = new Conversation(2);
    Conversation conv3 = new Conversation(3);
    static ArrayList<Conversation> tabConv = new ArrayList<Conversation>();
    
    public ThreadServer(int port){
        try {
            this.serverSocket = new ServerSocket(port);
            
            tabConv.add(conv1);
            tabConv.add(conv2);
            tabConv.add(conv3);
            
            conv1.addUser(1);
            conv1.addUser(2);
            
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
                
                //TODO Authentification
                
                //TODO Envoi historique discussion
                
                //ThreadClient
                totClient++;
                
                ThreadClient threadClient = new ThreadClient(socket, totClient+"");
                threadClient.start();
                
                User user = new User(totClient);
                
                Entity ent = new Entity(threadClient, user);
                
                //Monitoring

                Server.getServer().MonitTotClient.setText(totClient+"");
                
                tabEntity.add(ent);
                
                System.out.println("New Client accepted !");                
                
            } catch (IOException ex) {
                System.out.println("Server failed to accept client !");
            }
        }
        System.out.println("Exit while loop.");
    }
    
    
    static ArrayList<Entity> getTabEntity(){
        return tabEntity;
    }
        
    static Conversation getConv(int id){
        for(Conversation conv : tabConv){
            if(conv.idConv == id){
                return conv;
            }
        }
        return null;
    }
}
