/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfe.nebular.server;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author user
 */
public class ThreadWriting extends Thread {
    
    Socket socket;
    DataOutputStream out;
    Server server = Server.getServer();
    
    public ThreadWriting(Socket tmpSocket) throws IOException{
        this.socket = tmpSocket;
        this.out = new DataOutputStream(socket.getOutputStream());
    }
    
    @Override
    public void run(){
        
        
    }

    void sendMsg(String text) {
        try {
            out.writeUTF(text);
            out.flush();
        } catch (IOException ex) {
            System.out.println("Can not send messages !");
        }
    }
    
    
}
