package server;

import classes.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class BddObject {
    
    private static BddObject instance;
    boolean flag = false;
    private Connection conn;
    private Statement stat;
    private ResultSet res;
    
    private BddObject(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Nebular", "admin", "newPassword1!");
            flag = true;
        }
        catch (SQLException ex) {
            Logger.getLogger(BddObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static BddObject getInstance(){
        if(instance == null){
            instance = new BddObject();
        }
        return instance;
    }
    
    
    //fonction interne
    public void close(){
        try {
            if (res != null)
                res.close();
            if (stat != null)
                stat.close();
            if (conn != null)
                conn.close();
        } catch (SQLException ignore) {
        }
    }    
    
    
    //FONCTIONS CREATE
    
    public boolean createClient(Client client){
        try{
            stat = conn.createStatement();
            res = stat.executeQuery("INSERT INTO Clients VALUES ('"+client.x+"','"+client.mac+"');");
            if(res.next()){
                System.out.println(res);
            }
            return true;
        }
        catch(SQLException ex){
            Logger.getLogger(BddObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean createUser(User user){
        try{
            stat = conn.createStatement();
            res = stat.executeQuery("INSERT INTO Users VALUES ('"+user.nom+"','"+user.prenom+"','"+user.pseudo+"','"+user.email+"','"+user.mdp.hashCode()+"','0');");
            if(res.next()){
                System.out.println(res);
            }
            return true;
        }
        catch(SQLException ex){
            Logger.getLogger(BddObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean createConversation(Conversation conv){
        try {
            stat = conn.createStatement();
            res = stat.executeQuery("INSERT INTO Conversation VALUES ('"+conv.nom+"','"+conv.desc+"','"+conv.tabUsers+"');");
            if(res.next()){
                System.out.println(res);
            }
            return true;
        } 
        catch(SQLException ex){
            Logger.getLogger(BddObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean createMessage(Message msg){
        try {
            stat = conn.createStatement();
            res = stat.executeQuery("INSERT INTO Messages VALUE ('"+msg.idConv+"','"+msg.idExp+"','"+msg.type+"','"+msg.vis+"','"+msg.content+"','"+msg.date+"','"+msg.ext+"','"+msg.name+"');");
        } 
        catch(SQLException ex){
            Logger.getLogger(BddObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //FONCTIONS READ
    public ArrayList<Client> selectAllClient(){
        try{
            ArrayList<Client> listClient = new ArrayList<>();
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT * FROM Clients;");
            while(res.next()){
                Client client = new Client(res.getInt("id"), res.getLong("x"), res.getString("macAddress"));
                listClient.add(client);
            }
            return listClient;
        }
        catch(SQLException ex){
            Logger.getLogger(BddObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Client selectClient(int xClient){
        try{
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT * FROM Clients WHERE x="+xClient+";");
            while(res.next()){
                Client client = new Client(res.getInt("id"), res.getLong("x"), res.getString("macAddress"));
                return client;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(BddObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Client selectClient(String macAddress){
        try{
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT * FROM Clients WHERE macAddress="+macAddress+";");
            while(res.next()){
                Client client = new Client(res.getInt("id"), res.getLong("x"), res.getString("macAddress"));
                return client;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(BddObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public ArrayList<User> selectAllUser(){
        try {
            ArrayList<User> listUser = new ArrayList();
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT * FROM Users;");
            while(res.next()){
                System.out.println(res.getString("pseudo"));
            }
            return listUser;
        } catch (SQLException ex) {
            Logger.getLogger(BddObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public User selectUser(int idClient){
        try{
            User user;
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT * FROM Users WHERE id = "+idClient +";");
            if(res.next()){
                user = new User(Integer.parseInt(res.getString("id")), res.getString("nom"), res.getString("prenom"), res.getString("email"), res.getString("pseudo"), res.getString("mdp"), Integer.parseInt(res.getString("logged")), flag);
                return user;
            }
            
        } catch (SQLException ex){
            Logger.getLogger(BddObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public User selectUser(String pseudo){
        try{
            User user;
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT * FROM Users WHERE pseudo = "+pseudo +";");
            if(res.next()){
                user = new User(Integer.parseInt(res.getString("id")), res.getString("nom"), res.getString("prenom"), res.getString("email"), res.getString("pseudo"), res.getString("mdp"), Integer.parseInt(res.getString("logged")), flag);
                return user;
            }
        } catch (SQLException ex){
            Logger.getLogger(BddObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public ArrayList<Conversation> selectAllConversation(){
        try{
            ArrayList<Conversation> listConv = new ArrayList();
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT * FROM Conversations;");
            while(res.next()){
                String[] split = res.getString("listUser").split(";");
                ArrayList<Integer> list = new ArrayList();
                for(int i=0; i<split.length; i++){
                    list.add(Integer.valueOf(split[i]));
                }
                Conversation conv = new Conversation(res.getInt("id"), res.getString("name"), res.getString("desc"), list);
                listConv.add(conv);
            }
            return listConv;
        } catch (SQLException ex){
            Logger.getLogger(BddObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Conversation selectConversation(int idConv){
        try{
            Conversation conv;
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT * FROM Conversations WHERE id = "+idConv+";");
            if(res.next()){
                String[] split = res.getString("listUser").split(";");
                ArrayList<Integer> list = new ArrayList();
                for(int i=0; i<split.length; i++){
                    list.add(Integer.valueOf(split[i]));
                }
                return new Conversation(res.getInt("id"), res.getString("name"), res.getString("desc"), list);
            }
        } catch(SQLException ex) {
            Logger.getLogger(BddObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Message> selectAllMessage(){
        return null;
    }
    
    public Message selectMessage(){
        return null;
    }
    
    //FONCTIONS UPDATE
    public boolean updateClient(){
        return true;
    }
    
    public boolean updateUser(User user){
        return true;
    }
    
    public boolean updateConversation(){
        return true;
    }
    
    public boolean updateMessage(){
        return true;
    }
    
    //FONCTIONS DELETE
    public boolean deleteClient(){
        return true;
    }
    
    public boolean deleteUser(){
        return true;
    }
    
    public boolean deleteConversation(){
        return true;
    }
    
    public boolean deleteMessage(){
        return true;
    }
    
}
