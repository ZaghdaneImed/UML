package frenchchic_sprint2.controleur;

import frenchchic_sprint2.metier.Client;
import frenchchic_sprint2.vue.EcranAccueilPerso;
import frenchchic_sprint2.vue.EcranPanier;
import frenchchic_sprint2.vue.VueJetable;
import java.awt.Window;

public class Session {

    public static Client clientSession;

    public enum TypeEcran {
        ECRAN_ACCUEIL,
        ECRAN_ACCUEIL_PERSO,
        ECRAN_PANIER

    }
    private TypeEcran typeEcran;

    public TypeEcran getTypeEcran() {
        return typeEcran;
    }

    public Session() {
        typeEcran = TypeEcran.ECRAN_ACCUEIL;
    }

    public static void traiterConnexion() {
        Session session = new Session();
        if (session.getTypeEcran() == Session.TypeEcran.ECRAN_ACCUEIL) {
            // TODO
            // rederiger vers l'ecran accueil
            new VueJetable();
        }
    }

    public void traiterIdentificatin(String pseudo, String password) {
        if ("marie".equals(pseudo) && "123456".equals(password)) {
            clientSession = Client.rechrcheClientParPseudo(pseudo);
            this.setTypeEcran(TypeEcran.ECRAN_ACCUEIL_PERSO);

        } else {
            System.out.println("not logged in");
        }
    }

    public void traiterAjoutPanier() {

        this.setTypeEcran(TypeEcran.ECRAN_PANIER);

    }

    public void setTypeEcran(TypeEcran typeEcran) {
        this.typeEcran = typeEcran;
        Window[] windows = Window.getWindows();
        for (int i = 0; i < windows.length; i++) {
            windows[i].dispose();
        }
        if (this.getTypeEcran() == TypeEcran.ECRAN_ACCUEIL) {
            new VueJetable();
        }
        if (this.getTypeEcran() == TypeEcran.ECRAN_ACCUEIL_PERSO) {
            new EcranAccueilPerso();
        }
        if (this.getTypeEcran() == TypeEcran.ECRAN_PANIER) {
            new EcranPanier();
        }
    }

}
