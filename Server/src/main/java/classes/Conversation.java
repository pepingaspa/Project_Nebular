package classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Conversation implements Serializable {
    
    public int idConv;
    public ArrayList<Integer> tabUsers = new ArrayList<Integer>();
    public String nom;
    
    
    public Conversation(int tmpIdConv){
        this.idConv = tmpIdConv;
    }
    
    public void setNom(String tmpNom){
        this.nom = tmpNom;
    }
    
    public void addUser(int tmpId){
        this.tabUsers.add(tmpId);
    }
    
    public ArrayList<Integer> getTabUsers(){
        return tabUsers;
    }
    
}
