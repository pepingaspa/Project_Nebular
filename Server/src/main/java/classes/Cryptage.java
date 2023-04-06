package classes;

import java.math.BigInteger;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Cryptage {
    
    static byte[] salt = "MaachaouiZeGoat".getBytes();
    
    public static SecretKey generateKeyTemp(String passTmp){
        
        
        char[] pass = passTmp.toCharArray();
        
        try{
            PBEKeySpec pbeKeySpec = new PBEKeySpec(pass, salt, 5000,256);
            SecretKey secretKey = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(pbeKeySpec);
            return new SecretKeySpec(secretKey.getEncoded(), "AES");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static SecretKey generateKeyTemp(String passTmp, String ip) {
        char[] pass;
        int preSalt = 0;
        byte[] salt;
        String numberz = "0123456789";
        int count = 0;

        for(int i=0;i<ip.length();i++) {
            if(numberz.indexOf(ip.charAt(i)) != -1) {
                preSalt += ip.charAt(i)*Math.pow(10,count);
                count++;
            }
        }
        
        salt = (BigInteger.valueOf(preSalt%1000)).toByteArray();
        pass = (""+(preSalt%1000)).toCharArray();

        try{
            PBEKeySpec pbeKeySpec = new PBEKeySpec(pass, salt, 5000,256);
            SecretKey secretKey = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(pbeKeySpec);
            return new SecretKeySpec(secretKey.getEncoded(), "AES");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static SecretKey generateKeyDef(String passTmp){
        
        int max = 999999, min  = 100000;
        char[] pass = passTmp.toCharArray();
        
        try{
            PBEKeySpec pbeKeySpec = new PBEKeySpec(pass, salt, 5000,256);
            SecretKey secretKey = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(pbeKeySpec);
            return new SecretKeySpec(secretKey.getEncoded(), "AES");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static String randomPass(){
        int max = 999999, min = 100000;
        int tmp = (int) (Math.random()*(max-min+1)+min);
        return String. valueOf(tmp);
    }
    
    public static String encrypt(String target, SecretKey sK){
        try{
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, sK);
            return Base64.getEncoder().encodeToString(cipher.doFinal(target.getBytes("UTF-8")));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    
    public static String decrypt(String target, SecretKey sK){
        try{
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, sK);
            return new String(cipher.doFinal(Base64.getDecoder().decode(target)));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
}