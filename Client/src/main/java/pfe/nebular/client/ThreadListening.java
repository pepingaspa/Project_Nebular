package pfe.nebular.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ThreadListening extends Thread {
    
    Socket socket;
    DataInputStream in;
    JTextField msgText;
    JLabel msgLabel;
    
    public ThreadListening(Socket tmpSocket, JTextField tmpMsgText, JLabel tmpMsgLabel) throws IOException{
        this.socket = tmpSocket;
        this.in = new DataInputStream(socket.getInputStream());
        this.msgText = tmpMsgText;
        this.msgLabel = tmpMsgLabel;
    }
    
    @Override
    public void run(){
        try {
            String line = "";
            while(!line.equals("EndOfComm")){
                line = in.readUTF();
                Message msg = new Message(line);
                System.out.println(line);
                msgLabel.setText(msg.Concat());
            }
        } catch (IOException ex) {
            System.out.println("failed listening");
        }
    }
    
}
