/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Model.Croupier;
import Model.Joueur;
import Model.Robots;
import java.awt.Robot;
import model.Paquet;

/**
 *
 * @author DELL
 */
public class ControleurPiocheJoueur {

    private Croupier croupier;

    public ControleurPiocheJoueur(Croupier croupier) {

        this.croupier = croupier;
    }

    public void distribuerInit() {
        this.donnerCarte(this.croupier.getMainJoueur());
        this.donnerCarte(this.croupier.getMainJoueur());
        this.croupier.nombrePoint();
        
        for (Joueur player : this.croupier.getListPlayer()) {
            this.donnerCarte(player.getMainJoueur());
            this.donnerCarte(player.getMainJoueur());
            player.nombrePoint();
        }
    }

    public void donnerCarte(Paquet mainJoueur) {
        mainJoueur.addCardDebut(this.croupier.getTable().getPioche().getListeCarte().get(0));
        this.croupier.getTable().getPioche().getListeCarte().remove(0);
        this.croupier.getJoueurCourant().nombrePoint();
    }

    public Croupier getCroupier() {
        return this.croupier;
    }

    public void gestionRobots() {
        Robots r = ((Robots) this.croupier.getJoueurCourant());
          while(r.demanderCarte()==true)
          {
              this.donnerCarte(r.getMainJoueur());
              this.croupier.getPoids();
           
          }
       
        this.croupier.donnerTour();

    }
}
