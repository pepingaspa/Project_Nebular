package server;

import classes.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;

public class ThreadClient extends Thread {
    
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    SecretKey keyDef;
    
    public ThreadClient(Socket tmpSocket, SecretKey tmpKey){
        try {
            this.socket = tmpSocket;                    
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.keyDef = tmpKey;
        } catch (IOException ex) {
            System.out.println("ThreadClient failed to created.");
            
        }
    }
    
    public void write(String msg){
        try {
            msg = Cryptage.encrypt(msg, keyDef);
            out.writeUTF(msg);
            System.out.println("write");
        } catch (IOException ex) {
            System.out.println("Cannot write msg");
        }
    }
    
    @Override
    public void run(){
        boolean running = true;
        while(running){
            String line = "";
            while(!"CommOver".equals(line)){
                try {
                    line = in.readUTF();
                    System.out.println(line);
                    line = Cryptage.decrypt(line, keyDef);
                    Message msg = Message.deconcat(line);
                    msg.print();
                    Conversation conv = ThreadServer.getConv(msg.idConv);
                    ArrayList<Entity> tabEntity = ThreadServer.getTabEntity();
                    for(int idDest : conv.tabUsers){
                        for(Entity ent : tabEntity){
                            if(idDest == ent.user.id && this != ent.threadClient){
                                ent.threadClient.write(line);
                            }
                        }
                    }
                } catch (IOException ex) {
                    System.out.println("ReadUTF failed");
                    break;
                }
            }
            System.out.println("While loop exited");
            running = false;
        }
    }
    
}
