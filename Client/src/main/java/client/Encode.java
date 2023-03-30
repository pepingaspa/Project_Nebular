package client;

import java.lang.Math;

public class Encode {
    String mac = "01:23:DE:AD:BE:EF";
    long millis = System.currentTimeMillis();

    public static void main(String[] args) {
        Encode e = new Encode();
        long actuel = e.millis;
        long jour = actuel/(24*60*60*1000);
        actuel = actuel%(24*60*1000*60);
        //long heure = actuel/(60*60*1000);
        //long minute = (actuel%(60*60*1000))/(60*1000);
        //long qd = heure*4+minute/15;
        long ds = actuel/1000/10;
        //System.out.println(heure + "H" + minute + " soit le " + qd + " è quart d'heure. Au passage " + jour + " jours et on est à la " + ds + " dizaine de secondes.");
        //System.out.println("Vérification : minute : "+minute+" et minute calculée : "+ds/6);
        

        double newmac = 0;
        int compt = 0;

        for(int i=0; i<17 ; i++) {
            if (i%3 != 2) { //le test pourrait être remplacé par if mac.charAt(i) != ":"
                newmac = newmac + Character.getNumericValue(e.mac.charAt(i))*Math.pow(16,(11-compt));
                compt ++;
            }
        }
        System.out.println("0123DEADBEEF = " + newmac);

           
        double x = newmac % 25491937;
        x = (x*x) % 25491937;
        
        System.out.println(x);

        //Propal de nombre généré : (MAC modulo le nombre de jours écoulés depuis le 1e janvier 1970) * (le quart d'heure de la journée + 1). Ca rendrait : 

        int res = (int)((newmac % jour) * (ds + 1));
        System.out.println(res);
    }

}