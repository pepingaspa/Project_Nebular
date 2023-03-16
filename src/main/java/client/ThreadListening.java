package client;

import classes.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadListening extends Thread {
    
    Socket socket;
    DataInputStream in;
    
    public ThreadListening(Socket tmpSocket) throws IOException{
        this.socket = tmpSocket;
        this.in = new DataInputStream(socket.getInputStream());
    }
    
    @Override
    public void run(){
        try {
            String line = "";
            while(!line.equals("EndOfComm")){
                line = in.readUTF();
                //decrypt line
                Message msg = Message.deconcat(line);
                System.out.print("RECEIVED : ");
                ArrayList<Entity> tabEnt = Client.getTabEntity();
                for(Entity ent : tabEnt){
                    if(ent.conv.id == msg.idConv){
                        ent.convPanel.ConvArea.setText(ent.convPanel.ConvArea.getText() + msg.affichage() + "\n");
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("failed listening");
        }
    }
    
}
