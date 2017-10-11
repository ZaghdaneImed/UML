package frenchchic_sprint1.controleur;

import frenchchic_sprint1.metier.Client;
import frenchchic_sprint1.vue.EcranAccueilPerso;
import frenchchic_sprint1.vue.VueJetable;
import java.awt.Window;

public class Session {

    public static Client clientSession;

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

    public static void traiterConnexion() {
        Session session = new Session();
        if (session.getTypeEcran() == Session.TypeEcran.ECRAN_ACCUEIL) {
            // TODO
            // rederiger vers l'ecran accueil
            new VueJetable();
        }
    }

    public void setTypeEcran(TypeEcran typeEcran) {
        this.typeEcran = typeEcran;
        Window[] windows = Window.getWindows();
        for (int i = 0; i < windows.length; i++) {
            windows[i].dispose();
        }
        if (this.getTypeEcran() == TypeEcran.ECRAN_ACCUEIL) {
            VueJetable.getWindows()[0].setVisible(true);
        }
        if (this.getTypeEcran() == TypeEcran.ECRAN_ACCUEIL_PERSO) {
            new EcranAccueilPerso().setVisible(true);
        }
    }

    public void traiterIdentificatin(String pseudo, String password) {
        System.out.println("inf given " + pseudo + " " + password);
        if (pseudo == "marie" && password == "123456") {
            clientSession = Client.rechrcheClientParPseudo(pseudo);
            this.setTypeEcran(TypeEcran.ECRAN_ACCUEIL_PERSO);
            
        } else {
            System.out.println("not logged in");
        }
    }

}
