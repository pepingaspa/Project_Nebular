/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfe.nebular.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JLabel;



public class ThreadListening extends Thread {
    
    Socket socket;
    Server server;
    JLabel affLabel;
    DataInputStream in;
    
    public ThreadListening(Socket tmpSocket)throws IOException{
        this.socket = tmpSocket;
        server = Server.getServer();
        this.in = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run(){
        String line = "";
        
        while(!line.equals("EndOfComm")){
            try {
                line = in.readUTF();
            } catch (IOException ex) {
                System.out.println("test raté");
            }
            System.out.println(line);
        }
    }
    
}
