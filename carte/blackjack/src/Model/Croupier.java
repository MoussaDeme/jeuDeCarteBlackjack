/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import model.Paquet;

/**
 *
 * @author deme
 */
public class Croupier extends Joueur {

    private List<Joueur> listPlayer=new ArrayList<Joueur>();
    private TablePioche table;
    private Joueur joueurCourant;

    public Croupier(String nom, double mise, List<Joueur> listplayer,TablePioche table){
        super(nom, mise);
        this.table=table;
        this.listPlayer = listplayer;
        this.joueurCourant = listplayer.get(0);
    }

    
    public void donnerTour(){
        int nbrJoueur=this.listPlayer.size();
        int indexJoueurCourant=this.listPlayer.indexOf(this.joueurCourant);
        if(indexJoueurCourant==nbrJoueur-1){
            indexJoueurCourant=0;
        }
        else{
            indexJoueurCourant++;
        }
        if(!this.listPlayer.isEmpty()){
        this.joueurCourant=listPlayer.get(indexJoueurCourant);
        }
    }

    public List<Joueur> getListPlayer() {
    return this.listPlayer;
    }

    public TablePioche getTable() {
        return this.table;
    }
    
    public Joueur getJoueurCourant(){
        return this.joueurCourant;
    }
}
