package pfe.nebular.client;

import classes.Conversation;

public class Entity {
    
    ConvPanel convPanel;
    Conversation conv;
    
    public Entity(ConvPanel tmpPanel, Conversation tmpConv){
        this.convPanel = tmpPanel;
        this.conv = tmpConv;
    }
    
}
