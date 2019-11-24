/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Model.Croupier;
import Model.Joueur;
import model.Carte;
import model.Paquet;
import vue.VuePaquetCache;
import util.*;

/**
 *
 * @author DELL
 */
public class ControleurPiocheJoueur{
    private Croupier croupier;
    
   
    public ControleurPiocheJoueur(Croupier croupier) {
        
        this.croupier=croupier;
    }
    public void distribuerInit() {
        for (Joueur player : this.croupier.getListPlayer()){
            this.donnerCarte(player.getMainJoueur());
            this.donnerCarte(player.getMainJoueur());
        }
    }

    public void donnerCarte(Paquet mainJoueur) {
        mainJoueur.addCardDebut(this.croupier.getTable().getPioche().getListeCarte().get(0));
        this.croupier.getTable().getPioche().getListeCarte().remove(0);
    }
    
    
    
    
    
    
}
