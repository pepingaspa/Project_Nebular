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
public class Message implements Serializable {
    
    String content, exp, dest, date;
    boolean visible;
    
    
    public Message(String tmpContent, String tmpExp, String tmpDest){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.date = myDateObj.format(myFormatObj);
        this.content = tmpContent;
        this.exp = tmpExp;
        this.dest = tmpDest;
        this.visible = true;
    }
    
    
}
