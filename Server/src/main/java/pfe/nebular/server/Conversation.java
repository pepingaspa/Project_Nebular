package pfe.nebular.server;

import java.util.ArrayList;

public class Conversation {
    
    int idConv;
    ArrayList<Integer> tabUsers = new ArrayList<Integer>();
    
    public Conversation(int tmpIdConv){
        this.idConv = tmpIdConv;
    }
    
    public void addUser(int tmpId){
        this.tabUsers.add(tmpId);
    }
    
    public ArrayList<Integer> getTabUsers(){
        return tabUsers;
    }
    
}
