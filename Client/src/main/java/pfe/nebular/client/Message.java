/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfe.nebular.client;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author user
 */
public class Message {
    
    String content, exp, date;
    boolean visible;
    int idConv;
    
    
    public Message(String tmpContent){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.date = myDateObj.format(myFormatObj);
        this.content = tmpContent;
        this.exp = "A";
        this.idConv = 1;
        this.visible = true;
    }
    
    public String Concat(){        
        return this.idConv + ";_;" + this.exp + ";_;" + this.date + ";_;" + this.content + ";_;" + this.visible;
    }
    
    public Message Deconcat(String msg){
        
        String[] tmp = msg.split(";_;", 5);
        
        this.idConv = Integer.parseInt(tmp[0]);
        this.exp = tmp[1];
        this.date = tmp[2];
        this.content = tmp[3];
        this.visible = Boolean.parseBoolean(tmp[4]);
        
        return this;
    }
}
