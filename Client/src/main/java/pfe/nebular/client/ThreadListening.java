package pfe.nebular.client;

import classes.Message;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JTextArea;

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
                JTextArea convArea = Client.getArea(msg.idConv);
                if(convArea != null){
                    convArea.setText(convArea.getText()+"\n"+msg.Concat());
                }else{
                    System.out.println("Failed message reception");
                }
                
                
            }
        } catch (IOException ex) {
            System.out.println("failed listening");
        }
    }
    
}
