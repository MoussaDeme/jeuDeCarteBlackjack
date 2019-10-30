/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import vue.VuePaquetVisible;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import util.AbstractPaquetEcoutable;

/**
 *
 * @author 21912873
 */
public class Paquet extends AbstractPaquetEcoutable {

    private List<Carte> listCarte;
  
    public Paquet(int taille) {
        this.listCarte = new ArrayList<Carte>(taille);
    }
    public Paquet(){
        this.listCarte = new ArrayList<Carte>();
    }
    //ajout debut
    public void addCardDebut(Carte c) {
        listCarte.add(0, c);
        changement();
    }

    //ajout fin
    public void addCardFin(Carte c) {
        listCarte.add(c);
        changement();
    }

    //tirer une carte au hasard
    public Carte tirerAuHasard() {
        Random ran = new Random();
        int aleatoire = ran.nextInt(listCarte.size());

        return listCarte.get(aleatoire);
    }

    public void melanger() {
        Random ran = new Random();

        for(int i = 0; i < this.listCarte.size(); i++) {
            int index1 = ran.nextInt(listCarte.size());
            int index2 = ran.nextInt(listCarte.size());
            Carte tmp = listCarte.get(index1);
            listCarte.set(index1, listCarte.get(index2));
            listCarte.set(index2, tmp);
        }
      
        changement();
    }

    public void coupeAleatoire() {
        List<Carte> lc = new ArrayList<Carte>();
        List<Carte> lc1 = new ArrayList<Carte>();
        Random ran = new Random();
        int rand = 3+ran.nextInt(this.listCarte.size()-6);
        for(int i=0;i<rand;i++)
        {
            listCarte.add(listCarte.get(i));
            listCarte.remove(i);
        }
        changement();
    }
    public void setCarte(Carte c, int i){
        this.listCarte.set(i, c);
    }
    public List<Carte> getListeCarte(){
        return this.listCarte;
    }

    public Carte getCarte(int index){
        return this.listCarte.get(index);
    }
    
    
}
