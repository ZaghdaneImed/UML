package frenchchic_sprint1.controleur;

import frenchchic_sprint1.vue.VueJetable;

public class Session {

    public enum TypeEcran {
        ECRAN_ACCUEIL,
        ECRAN_ACCUEIL_PERSO

    }
    private TypeEcran typeEcran;

    public TypeEcran getTypeEcran() {
        return typeEcran;
    }
    
    
    public Session() {
        typeEcran = TypeEcran.ECRAN_ACCUEIL;
    }

    public TypeEcran afficherEcranAccueil() {
        return TypeEcran.ECRAN_ACCUEIL;
    }

    public TypeEcran afficherEcranLogin() {
        return TypeEcran.ECRAN_ACCUEIL_PERSO;
    }
    
    public static void traiterConnexion(){
        Session session = new Session();
        if(session.getTypeEcran() == Session.TypeEcran.ECRAN_ACCUEIL ){
            // TODO
            // rederiger vers l'ecran accueil
            new VueJetable();
        }
    }

}
