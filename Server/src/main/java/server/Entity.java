package server;

import classes.*;
import javax.crypto.SecretKey;

public class Entity {
    
    ThreadClient threadClient;
    User user;
    SecretKey secretKey;
    
    
    public Entity(ThreadClient tmpThread, User tmpUser, SecretKey tmpKey){
        this.threadClient = tmpThread;
        this.user = tmpUser;
        this.secretKey = tmpKey;
    }
    
}
