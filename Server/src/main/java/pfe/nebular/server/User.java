package pfe.nebular.server;

public class User {
    
    int id;
    String nom, prenom, mdp, email, pseudo, statut;
    

    public User(int tmpId, String tmpNom, String tmpPrenom, String tmpEmail, String tmpPseudo) {
        this.id = tmpId;
        this.nom = tmpNom;
        this.prenom = tmpPrenom;
        this.email = tmpEmail;
        this.pseudo = tmpPseudo;
    }

    public User(int tmpId){
        this.id = tmpId;
    }
}
