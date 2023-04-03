package server;

import classes.Conversation;
import classes.Cryptage;
import classes.User;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.crypto.SecretKey;
import static server.ThreadServer.tabConv;
import static server.ThreadServer.tabEntity;
import static server.ThreadServer.tabUser;

public class ThreadAuthent extends Thread{
    
    Socket socket;
    DataInputStream inData;
    DataOutputStream outData;
    SecretKey keyDef;
    
    public ThreadAuthent(Socket socket){
        this.socket = socket;
    }
    
    @Override
    public void run(){
        long n = 25491937;
        try{
            //Variable
            System.out.println("Var creation");

            inData = new DataInputStream(socket.getInputStream());
            outData = new DataOutputStream(socket.getOutputStream());
            String input, send;
            String[] split;
            User userLog = new User();
            int min = 1, max = 500000, alea;


            String mac = new String();
            //init clé
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = networkInterfaces.nextElement();
                byte[] hardwareAddress = ni.getHardwareAddress();
                if (hardwareAddress != null) {
                    String[] hexadecimalFormat = new String[hardwareAddress.length];
                    for (int i = 0; i < hardwareAddress.length; i++) {
                        hexadecimalFormat[i] = String.format("%02X", hardwareAddress[i]);
                    }
                    mac = String.join("-", hexadecimalFormat);
                }
            }
            
            Encode e = new Encode();
            String passtmp = String.valueOf(e.tempKey(mac));
            
            SecretKey secretKeyTmp = Cryptage.generateKeyTemp(passtmp);
            String pass = Cryptage.randomPass();
            keyDef = Cryptage.generateKeyDef(pass);

            //Echange Clé
            System.out.println("Echange clés");
            alea = (int) (Math.random()*(max-min+1)+min);
            send = alea + ";_;" + pass;
            send = Cryptage.encrypt(send, secretKeyTmp);
            
            outData.writeUTF(send);
            outData.flush();
            alea++;
            input = Cryptage.decrypt(inData.readUTF(), keyDef);
            if(Integer.parseInt(input) != alea){
                inData.close();
                outData.close();
                socket.close();
                System.out.println("Verification failed");
            }


            //Authentification
            System.out.println("Authentification");
            int alan = 100;
            input = Cryptage.decrypt(inData.readUTF(), keyDef);
            split = input.split(";");

            long x = Long.parseLong(split[0]);
            long[] tabV2 = new long[alan];

            for(int i = 1; i<split.length; i++){
                tabV2[i-1] = Long.parseLong(split[i]);
            }

            int[] tabBy = new int[100];
            for(int i=0; i<100; i++){
                tabBy[i] = (int) (Math.round(Math.random()));
            }

            send = tabBy[0] +"";
            for(int i=1; i<alan; i++){
                send = send + ";" + tabBy[i];
            }

            write(send);

            input = Cryptage.decrypt(inData.readUTF(), keyDef);
            split = input.split(";");

            long[] tabZ = new long[alan];
            for(int i=0; i<alan; i++){
                tabZ[i] = Long.parseLong(split[i]);
            }

            int cmp = 0;
            for(int i=0; i<alan; i++){
                if(tabBy[i] == 0){
                    if(((tabZ[i] * tabZ[i]) % n) != tabV2[i]){
                        cmp ++;
                    }
                }
                if(tabBy[i] == 1){
                    if(((tabZ[i] * tabZ[i]) % n) != ((x * tabV2[i]) % n)){
                        cmp ++;
                    }
                }
            }


            if(cmp == 0){
                send = "true";
                //encrypt
            }else{
                send = "false";
                write(send);
                outData.close();
                inData.close();
                socket.close();
            }

            write(send);               

            //SAISIE
            System.out.println("Saisie");
            input = Cryptage.decrypt(inData.readUTF(), keyDef);
            split = input.split(";_;");


            //USER
            System.out.println("User");
            tabUser = User.getAllUser();
            for(User user : tabUser){
                if(split[0].equals(user.pseudo) || split[1].equals(user.email)){
                    if(Integer.parseInt(split[1]) == user.mdp.hashCode()){
                        System.out.println("Login Done");
                        userLog = user;
                        userLog.logged = true;
                        alea = (int) (Math.random()*(max-min+1)+min);
                        send = alea + ";_;" + userLog.concat();
                        break;
                    }else{
                        alea = (int) (Math.random()*(max-min+1)+min);
                        send = alea + ";_;" + false;
                        break;
                    }
                }else{
                    alea = (int) (Math.random()*(max-min+1)+min);
                    send = alea + ";_;" + false;
                }
            }

            write(send);

            alea++;
            input = Cryptage.decrypt(inData.readUTF(), keyDef);
            if(Integer.parseInt(input) != alea){
                inData.close();
                outData.close();
                socket.close();
                System.out.println("Verification failed");
            }


            //CONV
            System.out.println("Conv sending");

            tabConv = Conversation.getAllConv();
            ArrayList<Conversation> tmpConv = new ArrayList<>();
            for(Conversation conv : tabConv){
                for(Integer i : conv.tabUsers){
                    if(i == userLog.id){
                        tmpConv.add(conv);
                        break;
                    }
                }
            }
            alea = (int) (Math.random()*(max-min+1)+min);
            send = alea + ";_;" + Conversation.concat(tmpConv);
            write(send);

            alea++;
            input = Cryptage.decrypt(inData.readUTF(), keyDef);
            if(Integer.parseInt(input) != alea){
                inData.close();
                outData.close();
                socket.close();
                System.out.println("Verification failed");
            }


            //TABUSER
            System.out.println("Tab sending");

            
            
            //MESSAGE
            System.out.println("Msg sending");


            //Final Treatment
            System.out.println("Final Treatment");

            ThreadServer.increClient();

            ThreadClient threadClient = new ThreadClient(socket, keyDef);
            threadClient.start();

            Entity ent = new Entity(threadClient, userLog);

            tabEntity.add(ent);

            System.out.println("New Client accepted !");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
        private void write(String send){
        send = Cryptage.encrypt(send, keyDef);
        try{
            outData.writeUTF(send);
            outData.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
