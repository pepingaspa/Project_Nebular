package server;

import classes.Client;
import classes.Conversation;
import classes.Cryptage;
import classes.User;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

            String stringIP = socket.getInetAddress().toString();
            
            SecretKey keyIp = Cryptage.generateKeyTemp("tmp",stringIP);
            
            input = inData.readUTF();
            
            //decode
            input = Cryptage.decrypt(input, keyIp);
            System.out.println(input);
            Client client = BddObject.getInstance().selectClient(Integer.parseInt(input));
            String passtmp;
            boolean noted = false;
            System.out.println("flag 1");
            if(client == null){
                System.out.println("client null");
                outData.writeUTF("07856");
                outData.flush();
                
                client.mac = inData.readUTF();
                
                
                
                passtmp = "ttt";
                noted = true;
                
            }else{
                System.out.println("client existing");
                Encode e = new Encode();
                passtmp = String.valueOf(e.tempKey(client.mac));
                
                outData.writeUTF("02541");
                outData.flush();
                noted = false;
            }
            
                

                SecretKey secretKeyTmp = Cryptage.generateKeyTemp(passtmp);
                String pass = Cryptage.randomPass();
                keyDef = Cryptage.generateKeyDef(pass);

                //Echange Clé
                System.out.println("Echange clés");
                alea = (int) (Math.random()*(max-min+1)+min);
                send = alea + ";_;" + pass;
                send = Cryptage.encrypt(send, secretKeyTmp);
                System.out.println("flag 2");
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
                input = inData.readUTF();
                input = Cryptage.decrypt(input, keyDef);
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
            tabUser = BddObject.getInstance().selectAllUser();
            for(User user : tabUser){
                if(split[0].equals(user.pseudo) && user.logged == false){
                    if(Integer.parseInt(split[1]) == user.mdp.hashCode()){
                        System.out.println("Login Done");
                        userLog = user;
                        userLog.logged = true;
                        BddObject.getInstance().updateUser(userLog);
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
        catch (Exception ex){
            Logger.getLogger(BddObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        private void write(String send){
        send = Cryptage.encrypt(send, keyDef);
        try{
            outData.writeUTF(send);
            outData.flush();
        }catch(Exception ex){
            Logger.getLogger(BddObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
