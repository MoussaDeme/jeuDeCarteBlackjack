/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author Pc
 */
public class Regles {
    
    private Croupier croupier;
    
    public Regles(Croupier c){
        this.croupier = c;
    }
    
    public boolean gameOver(){
        if(this.croupier.getPoids()>=17){
            return true;
        }
        if(this.croupier.getListPlayer().isEmpty()){
            return true;
        }
        if(this.croupier.getJoueurCourant().getPoids()==21){
            return true;
        }
        return false;
    }
    
    public void supprimeJoueursPerdants(List<Joueur> listeJoueurs){
       for(int i=0; i<listeJoueurs.size(); i++){
           if(listeJoueurs.get(i).getPoids()>21){
               listeJoueurs.remove(i);
           }
       }
    }
    
    
}
