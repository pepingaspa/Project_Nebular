package client;

import classes.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

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
                msg.print();
            }
        } catch (IOException ex) {
            System.out.println("failed listening");
        }
    }
    
}
