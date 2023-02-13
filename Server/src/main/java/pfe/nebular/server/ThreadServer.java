package pfe.nebular.server;

import classes.User;
import classes.Conversation;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ThreadServer extends Thread {

    ServerSocket serverSocket;
    boolean create = false, running = false;
    int totClient = 0;
    
    static ArrayList<Entity> tabEntity = new ArrayList<Entity>();
    
    static ArrayList<Conversation> tabConv = new ArrayList<Conversation>();
    
    public ThreadServer(int port){
        try {
            this.serverSocket = new ServerSocket(port);
            
            constructVar();
            
            
            System.out.println("Server launching on port : " + port);
            this.create = true;
        } catch (IOException ex) {
            System.out.println("Server can not launch !");
            this.create = false;
        }
    }
    
    
    public void constructVar(){
        
        Conversation conv1 = new Conversation(1);
        Conversation conv2 = new Conversation(2);
        
        conv1.addUser(1);
        conv1.addUser(2);
        conv2.addUser(1);
        conv2.addUser(3);
        
        conv1.setNom("Conv A");
        conv2.setNom("Biliblu");
        
        tabConv.add(conv1);
        tabConv.add(conv2);
        
        
    }
    
    @Override
    public void run() {
        running = true;
        System.out.println("Server started !");
        while(running){
            try {
                Socket socket = serverSocket.accept();
                totClient++;
                //TODO Authentification
                
                
                //reception login
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String tmp = in.readUTF();
                String[] split = tmp.split(";;;");
                
                //verification login
                
                //getUser BDD
                if(split[0].equals("aze") && split[1].equals("48690")){
                    //renvoie verif
                    out.writeUTF(""+totClient);
                    out.flush();
                }else{
                    out.writeUTF("0");
                    out.flush();
                }
                
                //System.out.println(split[0] + " " + split[1]);
                
                ObjectOutputStream out2 = new ObjectOutputStream(socket.getOutputStream());
                
                List<Conversation> list = new ArrayList<>();
                for(Conversation conv : tabConv){
                    for(int id : conv.tabUsers){
                        if(id == totClient){
                            list.add(conv);
                        }
                    }
                }
                
                out2.writeObject(list);
                out2.flush();
                
                //ThreadClient
                
                
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
