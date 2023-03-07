package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Message {
    
    public int id, idConv, idExp;
    boolean type, vis;
    String content, date, ext, name;
    
    
    public Message(int tmpid, int tmpConv, int tmpExp, boolean tmpType, String tmpContent, boolean tmpVis, String tmpDate){
        this.id = tmpid;
        this.idConv = tmpConv;
        this.idExp = tmpExp;
        this.type = tmpType;
        this.content = tmpContent;
        this.vis = tmpVis;
        this.date = tmpDate;
        this.ext = "";
        this.name = "";
    }

    
    public Message(int tmpid, int tmpConv, int tmpExp, boolean tmpType, File tmpFile, boolean tmpVis, String tmpDate){
        this.id = tmpid;
        this.idConv = tmpConv;
        this.idExp = tmpExp;
        this.type = tmpType;
        this.vis = tmpVis;
        this.date = tmpDate;
        
        String[] split = tmpFile.getName().split("\\.");
        this.name = split[0];
        this.ext = split[1];
        this.content = "";
        try {
            byte[] fileContent = Files.readAllBytes(tmpFile.toPath());
            this.content = Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    private static void constructFile(String name, String ext, String content) throws FileNotFoundException{
        byte[] fileContent = Base64.getDecoder().decode(content);
        FileOutputStream fos = new FileOutputStream("/home/cytech/Bureau/" + name + "." + ext);
        try {
            fos.write(fileContent);
            fos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String concat(){
        return this.id + ";M;" + this.idConv + ";M;" + this.idExp + ";M;" + this.type + ";M;" + this.content + ";M;" + this.name + ";M;" + this.ext + ";M;" + this.vis + ";M;" + this.date;
    }
    
    public static Message deconcat(String concat){
        String[] split = concat.split(";M;");
        Message msg;
        
        int id = Integer.parseInt(split[0]);
        int idConv = Integer.parseInt(split[1]);
        int idExp = Integer.parseInt(split[2]);
        boolean type = Boolean.parseBoolean(split[3]);
        String cont = split[4];
        String name = split[5];
        String ext = split[6];
        boolean vis = Boolean.parseBoolean(split[7]);
        String date = split[8];
        if(type){
            msg = new Message(id, idConv, idExp, type, cont, vis, date);         
        }else{
            try {
                constructFile(name, ext, cont);
                msg = new Message(id, idConv, idExp, type, name+"."+ext+" received.", vis, date);
            } catch (IOException ex) {
                msg = new Message(id, idConv, idExp, type, "FAILED RECEIVED FILE.", vis, date);
            }
        }
        return msg;
    }
    
    public void print(){
        System.out.println(this.idExp+ " -> " + this.idConv + " | " + this.date + " | " + this.content);
    }
    
}
