package client;

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
                Message msg = new Message(line);
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println("failed listening");
        }
    }
    
}
