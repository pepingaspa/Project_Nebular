package server;

import classes.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadServer extends Thread {

    ServerSocket serverSocket;
    boolean create = false, running = false;
    int totClient = 0;
    
    static ArrayList<Entity> tabEntity;
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
            try {
                Socket socket = serverSocket.accept();
                
                //Variable
                System.out.println("Var creation");
                
                DataInputStream inData = new DataInputStream(socket.getInputStream());
                DataOutputStream outData = new DataOutputStream(socket.getOutputStream());
                
                String input = "",send = "";
                String[] split;
                User userLog = new User();
                int min = 1, max = 500000, alea = 0;
                
                tabConv.get(0).concat();
                
                //Echange Clé
                System.out.println("Echange clés");


                //Authentification
                System.out.println("Authentification");
                

                //Reception saisie
                System.out.println("Saisie reception");
                
                input = inData.readUTF();
                //decryptage input
                split = input.split(";_;");
                
                tabUser = User.getAllUser();
                for(User user : tabUser){
                    if(user.pseudo == split[0] || user.email == split[0]){
                        if(user.mdp.hashCode() == Integer.parseInt(split[1]) && user.logged == false){
                            userLog = user;
                            alea = (int) (Math.random()*(max-min+1)+min);
                            send = alea + ";_;" + user.concat();
                            user.logged = true;
                            userLog.logged = true;
                        }
                    }
                }
                
                //Send user
                System.out.println("User Sending");
                //cryptage send
                outData.writeUTF(send);
                outData.flush();
                
                input = inData.readUTF();
                //decryptage input
                if(!input.equals(alea)){
                    inData.close();
                    outData.close();
                    socket.close();
                }
                
                tabConv = Conversation.getAllConv();
                ArrayList<Conversation> tmpConv = new ArrayList<Conversation>();
                for(Conversation conv : tabConv){
                    for(Integer i : conv.tabUsers){
                        if(i == userLog.id){
                            tmpConv.add(conv);
                            break;
                        }
                    }
                }
                
                alea = (int) (Math.random()*(max-min+1)+min);
                send = alea + ";_;" + Conversation.concat(tmpConv);
                
                //Send Conv
                System.out.println("Conv sending");
                //cryptage send
                outData.writeUTF(send);
                outData.flush();
                
                input = inData.readUTF();
                //decryptage
                if(!input.equals(alea)){
                    inData.close();
                    outData.close();
                    socket.close();
                }
                
                alea = (int) (Math.random()*(max-min+1)+min);
                send = alea + ";_;" + User.getAllUserConcat(tabUser);
                
                //Send tabUsers
                System.out.println("Tab sending");
                outData.writeUTF(send);
                outData.flush();

                //Send Message
                System.out.println("Msg sending");


                //Final Treatment
                totClient++;
                Server.getServer().MonitTotClient.setText(totClient+"");
                
                ThreadClient threadClient = new ThreadClient(socket);
                threadClient.start();
                Entity ent = new Entity(threadClient, userLog);
                
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
            if(conv.id == id){
                return conv;
            }
        }
        return null;
    }
}
