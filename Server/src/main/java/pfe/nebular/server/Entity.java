package pfe.nebular.server;

import classes.User;

public class Entity {
    
    ThreadClient threadClient;
    User user = null;
    
    public Entity(ThreadClient tmpThread){
        this.threadClient = tmpThread;
    }
    
    public Entity(ThreadClient tmpThread, User tmpUser){
        this.threadClient = tmpThread;
        this.user = tmpUser;
    }
    
    public void addUser(User tmpUser){
        this.user = tmpUser;
    }
    
}
