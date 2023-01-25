package pfe.nebular.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadServer extends Thread {

    ServerSocket serverSocket;
    boolean create = false, running = false;
    int totClient = 0;
    ArrayList<Client> tabClient = new ArrayList<Client>();
    
    public ThreadServer(int port){
        try {
            this.serverSocket = new ServerSocket(port);
            
            System.out.println("Server launching on port : " + port);
            this.create = true;
        } catch (IOException ex) {
            System.out.println("Server can not launch !");
            this.create = false;
        }
    }
    
    @Override
    public void run() {
        running = true;
        System.out.println("Server started !");
        while(running){
            try {
                Socket socket = serverSocket.accept();
                
                //TODO Authentification
                
                //ThreadClient
                totClient++;
                
                ThreadClient threadClient = new ThreadClient(socket, totClient+"");
                threadClient.start();
                
                //Monitoring
                
                
                Server.getServer().MonitTotClient.setText(totClient+"");               
                
                Client client = new Client(totClient, socket.getRemoteSocketAddress());
                
                tabClient.add(client);
                
                System.out.println("New Client accepted !");                
                
            } catch (IOException ex) {
                System.out.println("Server failed to accept client !");
            }
        }
        System.out.println("Exit while loop.");
    }

}
