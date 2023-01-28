package pfe.nebular.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadClient extends Thread {
    
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    
    public ThreadClient(Socket tmpSocket, String tmpTitre){
        try {
            this.socket = tmpSocket;                    
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.out.println("ThreadClient failed to created.");
            
        }
    }
    
    public void write(String msg){
        try {
            //getClé, cryptage
            //writeUTF
            out.writeUTF(msg);
            System.out.println("write");
        } catch (IOException ex) {
            System.out.println("Cannot write msg");
        }
    }
    
    @Override
    public void run(){
        while(true){
            String line = "";
            while(!"CommOver".equals(line)){
                try {
                    line = in.readUTF();
                    Message msg = new Message(line);
                    msg.print();
                    Conversation conv = ThreadServer.getConv(msg.idConv);
                    ArrayList<Entity> tabEntity = ThreadServer.getTabEntity();
                    for(int idDest : conv.tabUsers){
                        for(Entity ent : tabEntity){
                            if(idDest == ent.user.id){
                                ent.threadClient.write(line);
                            }
                        }
                    }
                } catch (IOException ex) {
                    System.out.println("ReadUTF failed");
                    line = "CommOver";
                }
            }
            System.out.println("While loop exited");
        }
    }
    
}
