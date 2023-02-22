package classes;

import java.util.ArrayList;

public class User {
    
    public int id, statut;
    public String nom, prenom, mdp, email, pseudo;
    public boolean logged;
    
    public User(){
        this.id = 0;
    }
    
    public User(int tmpId, String tmpNom, String tmpPrenom, String tmpEmail, String tmpPseudo, String tmpMdp, int tmpStatut, boolean tmpLog) {
        this.id = tmpId;
        this.nom = tmpNom;
        this.prenom = tmpPrenom;
        this.email = tmpEmail;
        this.pseudo = tmpPseudo;
        this.mdp = tmpMdp;
        this.statut = tmpStatut;
        this.logged = tmpLog;
    }
    
    public User(int tmpId, String tmpNom, String tmpPrenom, String tmpEmail, String tmpPseudo, int tmpStatut, boolean tmpLog) {
        this.id = tmpId;
        this.nom = tmpNom;
        this.prenom = tmpPrenom;
        this.email = tmpEmail;
        this.pseudo = tmpPseudo;
        this.mdp = null;
        this.statut = tmpStatut;
        this.logged = tmpLog;
    }
    
    public String concat(){
        return this.id + ";U;" + this.nom + ";U;" + this.prenom + ";U;" + this.email + ";U;" + this.pseudo + ";U;" + this.statut + ";U;" + this.logged;
    }
    
    public static User deconcat(String concat){
        String[] split = concat.split(";U;");
        User user = new User(Integer.parseInt(split[0]), split[1],split[2],split[3],split[4],Integer.parseInt(split[5]), Boolean.parseBoolean(split[6]));
        return user;
    }

    
    public static ArrayList<User> getAllUser(){
        ArrayList<User> tabUser = new ArrayList<User>();
        
        User user1 = new User(1,"A", "A", "a@a.a", "A", "123", 1, false);
        User user2 = new User(1,"B", "B", "b@b.b", "B", "123", 1, false);
        User user3 = new User(1,"C", "C", "c@c.c", "C", "123", 1, false);
        
        tabUser.add(user1); tabUser.add(user2); tabUser.add(user3);
        
        return tabUser;
    }
    
    
    public static String getAllUserConcat(ArrayList<User> tabUser) {
        String tmp = "";
        
        for(int i=0; i < tabUser.size(); i++){
            if(i<tabUser.size()){
                tmp = tmp + tabUser.get(i).concat() + ";T;";
            }else{
                tmp = tmp + tabUser.get(i).concat();
            }
        }
        
        return tmp;
    }
    
    public static void saveTab(ArrayList<User> tabUser){
        
    }
    
}
