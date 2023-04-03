package server;

public class Encode {
    long millis = System.currentTimeMillis();

    public int tempKey(String mac) {
        Encode e = new Encode();
        long actuel = e.millis;
        long jour = actuel/(24*60*60*1000);
        actuel = actuel%(24*60*1000*60);
        long ds = actuel/1000/10;
        double newmac = 0;
        int compt = 0;
        for(int i=0; i<17 ; i++) {
            if (i%3 != 2) { //le test pourrait être remplacé par if mac.charAt(i) != ":", à adapter en cas de besoin
                newmac = newmac + Character.getNumericValue(mac.charAt(i))*Math.pow(16,(11-compt));
                compt ++;
            }
        }
        int res = (int)((newmac % jour) * (ds + 1));
        return(res);
    }
}