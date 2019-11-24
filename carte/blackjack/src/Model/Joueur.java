/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import model.Carte;
import model.Paquet;
import model.PaquetFactory;

/**
 *
 * @author deme
 */
public abstract class Joueur {

    private Paquet mainJoueur;
    private String nom;
    private int poids;
    private double mise;

    public Joueur(String nom, double mise) {
        this.mainJoueur = PaquetFactory.createPaquet(0);
        this.poids = 0;
        this.mise = mise;
    }
    
    
    public int getPoids() {
        return poids;
    }

    public Paquet getMainJoueur() {
        return mainJoueur;
    }

    public void setMainJoueur(Paquet mainJoueur) {
        this.mainJoueur = mainJoueur;
    }

    public int nombrePoint() {

        for (Carte carte : this.mainJoueur.getListeCarte()) {
            int poidsCarte = Integer.parseInt(carte.getValeur());
            if (poidsCarte > 1 && poidsCarte <= 9) {// poids réel d'une carte (numero)
                this.poids += poidsCarte;
            } else if (carte.getValeur().equalsIgnoreCase("AS")) {
                if(this.poids +11 <=21){
                    this.poids+=11;
                }else{
                this.poids+=1;
                }
            } else {
                this.poids += 10;
            }
        }
        return this.poids;
    }

    public void doublerSaMise(boolean c)
    {
        if(c){
        this.mise*=2;
        }
    }
    
    /*public boolean passerSonTour()
    {
      // tu ne fais rien pour l'instant 
    }*/

            
}
