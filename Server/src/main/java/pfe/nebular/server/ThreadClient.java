package pfe.nebular.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;

public class ThreadClient extends Thread {
    
    Socket socket;
    JButton button;
    ConvPanel convPanel;
    DataInputStream in;
    DataOutputStream out;
    
    public ThreadClient(Socket tmpSocket, String tmpTitre){
        try {
            this.socket = tmpSocket;
            this.button = new JButton("Client");
            
            
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("test");
                }
            });
            
            
            button.setSize(150,75);
            Server.getServer().SidePanel.add(button).setVisible(true);
            
            this.convPanel = new ConvPanel();
            Server.getServer().CenterPanel.add(convPanel).setVisible(true);
            
            Server.getServer().CommPanel.updateUI();
                    
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.out.println("ThreadClient failed to created.");
        }
    }
    
    public void write(){
        
    }
    
    @Override
    public void run(){
        while(true){
            String line = "";
            while(!"CommOver".equals(line)){
                try {
                    line = in.readUTF();
                    System.out.println(line);
                } catch (IOException ex) {
                    System.out.println("ReadUTF failed");
                }
            }
            System.out.println("While loop exited");
        }
    }
    
}
