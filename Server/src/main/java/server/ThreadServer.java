package server;

import classes.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadServer extends Thread {

    ServerSocket serverSocket;
    boolean create = false, running = false;
    int totClient = 0;
    int n = 1926305761;
    
    static ArrayList<Entity> tabEntity = new ArrayList<Entity>();
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
                
                //Variable
                System.out.println("Var creation");
                
                DataInputStream inData = new DataInputStream(socket.getInputStream());
                DataOutputStream outData = new DataOutputStream(socket.getOutputStream());
                String input = "",send = "";
                String[] split;
                User userLog = new User();
                int min = 1, max = 500000, alea = 0;
                
                //init clé
                
                
                //Echange Clé
                System.out.println("Echange clés");
                alea = (int) (Math.random()*(max-min+1)+min);
                send = alea + ";_;" + "COUCOU";
                outData.writeUTF(send);
                outData.flush();
                alea++;
                input = inData.readUTF();
                //decryptage input
                if(Integer.parseInt(input) != alea){
                    inData.close();
                    outData.close();
                    socket.close();
                    System.out.println("NOP");
                }
                

                //Authentification
                System.out.println("Authentification");
                
                input = inData.readUTF();
                split = input.split(";");
                
                long x = Long.parseLong(split[0]);
                long[] tabV2 = new long[100];
                
                for(int i = 1; i<split.length; i++){
                    tabV2[i-1] = Long.parseLong(split[i]);
                }
                   
                int[] tabBy = new int[100];
                for(int i=0; i<100; i++){
                    tabBy[i] = (int) (Math.round(Math.random()));
                }
                
                send = tabBy[0] +"";
                for(int i=1; i<100; i++){
                    send = send + ";" + tabBy[i];
                }
                
                outData.writeUTF(send);
                outData.flush();
                
                input = inData.readUTF();
                split = input.split(";");
                
                long[] tabZ = new long[100];
                for(int i=0; i<100; i++){
                    tabZ[i] = Long.parseLong(split[i]);
                }
                
                int cmp = 0;
                for(int i=0; i<100; i++){
                    if(tabBy[i] == 0){
                        if(((tabZ[i] * tabZ[i]) % n) != tabV2[i]){
                            cmp ++;
                        }
                    }
                    if(tabBy[i] == 1){
                        if(((tabZ[i] * tabZ[i]) % n) != ((x * tabV2[i]) % n)){
                            cmp ++;
                        }
                    }
                }
                System.out.println("CMP "+cmp);
                
                //SAISIE
                System.out.println("Saisie");
                input = inData.readUTF();
                //input = cypher.decrypt(input);
                split = input.split(";_;");
                System.out.println(split[0] + "   " + split[1]);
                
                
                //USER
                System.out.println("User");
                tabUser = User.getAllUser();
                for(User user : tabUser){
                    if(split[0].equals(user.pseudo) || split[1].equals(user.email)){
                        if(Integer.parseInt(split[1]) == user.mdp.hashCode()){
                            System.out.println("Login Done");
                            userLog = user;
                            userLog.logged = true;
                            alea = (int) (Math.random()*(max-min+1)+min);
                            send = alea + ";_;" + userLog.concat();
                            break;
                        }else{
                            System.out.println("mdp");
                            alea = (int) (Math.random()*(max-min+1)+min);
                            send = alea + ";_;" + false;
                            break;
                        }
                    }else{
                        System.out.println("log");
                        alea = (int) (Math.random()*(max-min+1)+min);
                        send = alea + ";_;" + false;
                    }
                }
                
                //cryptage send
                outData.writeUTF(send);
                outData.flush();
                
                alea++;
                input = inData.readUTF();
                //decryptage input
                if(Integer.parseInt(input) != alea){
                    inData.close();
                    outData.close();
                    socket.close();
                    System.out.println("NOP");
                }
                
                
                //CONV
                System.out.println("Conv sending");
               
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
                //cryptage send
                outData.writeUTF(send);
                outData.flush();
                
                alea++;
                input = inData.readUTF();
                //decryptage input
                if(Integer.parseInt(input) != alea){
                    inData.close();
                    outData.close();
                    socket.close();
                    System.out.println("NOP");
                }
                
                
                //TABUSER
                System.out.println("Tab sending");

                //MESSAGE
                System.out.println("Msg sending");


                //Final Treatment
                System.out.println("Final Treatment");
                
                totClient++;
                Server.getServer().MonitTotClient.setText(totClient+"");
                
                ThreadClient threadClient = new ThreadClient(socket);
                threadClient.start();
                
                Entity ent = new Entity(threadClient, userLog);
                
                tabEntity.add(ent);
                
                System.out.println("New Client accepted !");                
                
            } catch (IOException ex) {
                System.out.println("Server failed to accept client !");
            } catch (Exception ex) {
                Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
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
