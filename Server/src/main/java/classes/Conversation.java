package classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Conversation implements Serializable {
    
    public int id;
    public String nom, desc;
    public ArrayList<Integer> tabUsers = new ArrayList<Integer>();    
    
    public Conversation(int tmpIdConv, String tmpNom, String tmpDesc, ArrayList<Integer> tmp){
        this.id = tmpIdConv;
        this.nom = tmpNom;
        this.desc = tmpDesc;
        this.tabUsers = tmp;
    }
    
    public void setNom(String tmpNom){
        this.nom = tmpNom;
    }
    
    public void setDesc(String tmpDesc){
        this.desc = tmpDesc;
    }
    
    public void addUser(int tmpId){
        this.tabUsers.add(tmpId);
    }
    
    public ArrayList<Integer> getTabUser(){
        return this.tabUsers;
    }
    
    public String concat(){
        String tmp = this.id + ";C;" + this.nom + ";C;" + this.desc + ";C;";
        for(Integer i : this.tabUsers){
            if(i<this.tabUsers.size()-1){
                tmp = tmp + i + ";Ct;";
            }else{
                tmp = tmp + i;
            }
        }
        System.out.println(tmp);
        return tmp;
    }
    
    public static Conversation deconcat(String concat){
        String[] split = concat.split(";C;");
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        String[] split2 = split[3].split(";Ct;");
        for(String str : split2){
            tmp.add(Integer.parseInt(str));
        }
        Conversation conv = new Conversation(Integer.parseInt(split[0]), split[1], split[2], tmp);
        return conv;
    }
    
    public static ArrayList<Conversation> getAllConv(){
        ArrayList<Conversation> tabUser = new ArrayList<Conversation>();
        
        ArrayList<Integer> tab1 = new ArrayList<Integer>();
        tab1.add(1); tab1.add(2);
        Conversation conv1 = new Conversation(1,"Conv1", "Cool", tab1);
        
        ArrayList<Integer> tab2 = new ArrayList<Integer>();
        tab2.add(1); tab2.add(3);
        Conversation conv2 = new Conversation(1,"Conv1", "Cool", tab2);
        
        ArrayList<Integer> tab3 = new ArrayList<Integer>();
        tab1.add(2); tab1.add(3);
        Conversation conv3 = new Conversation(1,"Conv1", "Cool", tab3);
        
        tabUser.add(conv1); tabUser.add(conv2); tabUser.add(conv3);
        
        return tabUser;
    }
    
    public static String concat(ArrayList<Conversation> tabConv){
        String tmp = "";
        for(int i=0; i<tabConv.size(); i++){
            if(i < tabConv.size()-1){
                tmp = tmp + tabConv.get(i).concat() + ";T;";
            }else{
                tmp = tmp + tabConv.get(i).concat();
            }
        }
        return tmp;
    }
    
}
