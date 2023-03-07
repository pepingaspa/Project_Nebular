package server;

import classes.*;

public class Entity {
    
    ThreadClient threadClient;
    User user;
    
    public Entity(ThreadClient tmpThread, User tmpUser){
        this.threadClient = tmpThread;
        this.user = tmpUser;
    }
    
}
