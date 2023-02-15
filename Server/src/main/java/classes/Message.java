package classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    
    public String content, date;
    public boolean visible;
    public int idConv, exp, id;
    
    public Message(String tmpContent, int tmpId, int tmpConv){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.date = myDateObj.format(myFormatObj);
        this.content = tmpContent;
        this.exp = tmpId;
        this.idConv = tmpConv;
        this.visible = true;
        this.id = 0;
    }
    
    public Message(int tmpId, int tmpConv, int tmpExp, String tmpDate, String tmpCont,boolean tmpVi){
        this.id = tmpId;
        this.idConv = tmpConv;
        this.exp = tmpExp;
        this.visible = tmpVi;
        this.content = tmpCont;
        this.date = tmpDate;
    }
    
    public String concat(){
        return this.id + ";M;" + this.idConv + ";M;" + this.exp + ";M;" + this.date + ";M;" + this.content + ";M;" + this.visible;
    }
    
    public static Message deconcat(String concat){
        String[] split = concat.split(";M;");
        Message message = new Message(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]),split[3],split[4],Boolean.parseBoolean(split[5]));       
        return message;
    }
    
    public void print(){
        System.out.println(this.exp + " -> " + this.idConv + " | " + this.date + " | " + this.visible + " | " + this.content);
    }
    
}
