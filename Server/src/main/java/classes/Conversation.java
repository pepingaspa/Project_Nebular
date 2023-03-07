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
            if(i == this.tabUsers.size()-1){
                tmp = tmp + i + ";Ct;";
            }else{
                tmp = tmp + i;
            }
        }
        //System.out.println(tmp);
        return tmp;
    }
    
    public static Conversation deconcat(String concat){
        String[] split = concat.split(";C;");
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        String[] split2 = split[3].split(";Ct;");
        for(String str : split2){
            tmp.add(Integer.valueOf(str));
        }
        Conversation conv = new Conversation(Integer.parseInt(split[0]), split[1], split[2], tmp);
        return conv;
    }
    
    public void print(){
        String tmp = this.id + " " + this.nom + " " + this.desc + " " + this.tabUsers.toString();
        System.out.println(tmp);
    }
    
    public static ArrayList<Conversation> getAllConv(){
        ArrayList<Conversation> tabConv = new ArrayList<Conversation>();
        
        ArrayList<Integer> tab1 = new ArrayList<Integer>();
        tab1.add(1); tab1.add(2);
        Conversation conv1 = new Conversation(1,"Conv1", "Cool", tab1);
        
        ArrayList<Integer> tab2 = new ArrayList<Integer>();
        tab2.add(1); tab2.add(3);
        Conversation conv2 = new Conversation(2,"AAACC", "Toto", tab2);
        
        ArrayList<Integer> tab3 = new ArrayList<Integer>();
        tab3.add(2); tab3.add(3);
        Conversation conv3 = new Conversation(3,"BCBCB", "Yeas", tab3);
        
        
//        Conversation convA = new Conversation(1,"A", "Cool", tab1);
//        Conversation convB = new Conversation(1,"B", "Cool", tab1);
//        Conversation convC = new Conversation(1,"C", "Cool", tab1);
//        Conversation convD = new Conversation(1,"D", "Cool", tab1);
//        Conversation convE = new Conversation(1,"E", "Cool", tab1);
//        Conversation convF = new Conversation(1,"F", "Cool", tab1);
//        Conversation convG = new Conversation(1,"G", "Cool", tab1);
//        Conversation convH = new Conversation(1,"H", "Cool", tab1);
//        Conversation convI = new Conversation(1,"I", "Cool", tab1);
//        Conversation convJ = new Conversation(1,"J", "Cool", tab1);

//        tabConv.add(convA);
//        tabConv.add(convB);
//        tabConv.add(convC);
//        tabConv.add(convD);
//        tabConv.add(convE);
//        tabConv.add(convF);
//        tabConv.add(convG);
//        tabConv.add(convH);
//        tabConv.add(convI);
//        tabConv.add(convJ);

        tabConv.add(conv1);
        tabConv.add(conv2);
        tabConv.add(conv3);

        
        
        
        
        return tabConv;
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
        System.out.println(tmp);
        return tmp;
    }
    
    public static ArrayList<Conversation> deconcatTab(String concat){
        ArrayList<Conversation> tmpConv = new ArrayList<Conversation>();
        String[] split = concat.split(";T;");
        for(String str : split){
            Conversation conv = Conversation.deconcat(str);
            tmpConv.add(conv);
        }
        return tmpConv;
    }
    
}
