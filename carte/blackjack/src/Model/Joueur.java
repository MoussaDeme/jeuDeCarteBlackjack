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
        this.nom = nom;
    }
    
    public String getNomJoueur(){
        return this.nom;
    }
    public int getPoids() {
        return poids;
    }

    public void setMise(double gaint){
        this.mise=gaint;
    }
    
    public double getMise(){
        return this.mise;
    }
    public Paquet getMainJoueur() {
        return mainJoueur;
    }

    public void setMainJoueur(Paquet mainJoueur) {
        this.mainJoueur = mainJoueur;
    }

    public void nombrePoint() {
        this.poids = 0; 
        for (Carte carte : this.mainJoueur.getListeCarte()) {
            if(!carte.getValeur().equalsIgnoreCase("AS") && !carte.getValeur().equalsIgnoreCase("J") && !carte.getValeur().equalsIgnoreCase("K") 
                    && !carte.getValeur().equalsIgnoreCase("Q")){
                int poidsCarte = Integer.parseInt(carte.getValeur());
                 this.poids += poidsCarte;
            }else if(carte.getValeur().equalsIgnoreCase("AS")) {
                int a = this.poids +11;
                if(a <=21){
                    this.poids +=11;
                }else{
                this.poids +=1;
                }
            } else {
                this.poids += 10;
            }
        }
    }

    public void doublerSaMise()
    {
        this.mise*=2;
    }

}
