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
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
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
        //distrubuer au croupier
        this.donnerCarte(this.croupier);
        this.donnerCarte(this.croupier);
       
        //this.croupier.nombrePoint();
        //distribuer aux joueurs
        for (Joueur player : this.croupier.getListPlayer()) {
            this.donnerCarte(player);
            this.donnerCarte(player);
            //player.nombrePoint();
        }
    }

    public void donnerCarte(Joueur joueur) {
        if(joueur instanceof Croupier){
          this.croupier.getMainJoueur().addCardDebut(this.croupier.getTable().getPioche().getListeCarte().get(0));
          this.croupier.getTable().getPioche().getListeCarte().remove(0);
          this.croupier.nombrePoint();
        }else if(this.croupier.getListPlayer().contains(joueur)){
            
            joueur.getMainJoueur().addCardDebut(this.croupier.getTable().getPioche().getListeCarte().get(0));
            this.croupier.getTable().getPioche().getListeCarte().remove(0);
            joueur.nombrePoint();
            } 
//        //System.out.println(this.croupier.getJoueurCourant().getNomJoueur()+" : "+this.croupier.getJoueurCourant().getPoids());
    }

    public Croupier getCroupier() {
        return this.croupier;
    }

    public void gestionRobots() {
        Robots r = ((Robots) this.croupier.getJoueurCourant());
          while(r.demanderCarte()==true)
          {
              this.donnerCarte(r);
              this.croupier.getPoids();
              this.attente(1);
          }
          this.croupier.donnerTour();
       this.supprimeJoueursPerdants(this.croupier.getListPlayer());
  
    }
    
    public boolean gameOver() {
        if (this.croupier.getPoids() > 17) {
            return true;
        }
        if (this.croupier.getListPlayer().isEmpty()) {
            return true;
        }
      
        return false;
    }

    public void supprimeJoueursPerdants(List<Joueur> listeJoueurs) {

        for (int i = 0; i < listeJoueurs.size(); i++) {
            if (listeJoueurs.get(i).getPoids() > 21) {
                 System.out.println("ce joueur est suprimer "+listeJoueurs.get(i).getNomJoueur()); 
                this.operationsSurMise(listeJoueurs.get(i), croupier);
                
                listeJoueurs.remove(i);
            }
        }
        
        System.out.println("Liste ");
       for(Joueur j: listeJoueurs){
           System.out.println(j.getNomJoueur());
       } 
    }

    public void operationsSurMise(Joueur joueurPerdant, Joueur joueurGagnant) {
        if (joueurPerdant instanceof Croupier){
            this.croupier.setMise(this.croupier.getMise()-joueurGagnant.getMise());
            double gaintJoueur = joueurGagnant.getMise()*2;
            joueurGagnant.setMise(gaintJoueur);
        } else {
            double caisseBanque = joueurPerdant.getMise() + joueurGagnant.getMise();
            joueurGagnant.setMise(caisseBanque);
        }
    }

    public Set<Joueur> gagnant() {
        Set<Joueur> listeGagnants = new HashSet<Joueur>();

        if (this.gameOver() == true) {
            this.supprimeJoueursPerdants(this.croupier.getListPlayer());
            if (this.croupier.getPoids() > 21) {
                for (Joueur j : this.croupier.getListPlayer()) {
                    this.operationsSurMise(croupier, j);
                    listeGagnants.add(j);
                }
            } else {
                for (Joueur j : this.croupier.getListPlayer()) {
                    if (j.getPoids() > this.croupier.getPoids()) {
                        listeGagnants.add(j);
                        this.operationsSurMise(croupier, j);
                    } else {
                        listeGagnants.add(this.croupier);
                        this.operationsSurMise(j, this.croupier);
                    }
                }
            }
            return listeGagnants;
        }
        return null;
    }
    
    public void attente(int nbreSecondes)
	{
		int wait = nbreSecondes*1000;
		Date date = new Date();
		long debut = date.getTime();
		long somme = debut + wait;
		
		while(debut<somme)
		{
			date = new Date();
			debut = date.getTime();
		}
	}
}
