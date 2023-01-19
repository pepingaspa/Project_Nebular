/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfe.nebular.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
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
                msgLabel.setText(line);
                line = in.readUTF();
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadListening.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
