package pfe.nebular.server;

import java.net.SocketAddress;

public class Client {
    
    int idClient;
    SocketAddress ipClient;
    
    public Client(int tmpId, SocketAddress tmpIp){
        this.idClient = tmpId;
        this.ipClient = tmpIp;
    }
       
}
