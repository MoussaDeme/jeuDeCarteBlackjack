/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import model.Paquet;

/**
 *
 * @author Pc
 */
public class VuePaquetVisible extends VuePaquet{
   private int longueur;
    public VuePaquetVisible(Paquet p){
        super(p);
        p.ajoutEcouteur(this);
        this.longueur = p.getListeCarte().size();
   }
    
    @Override
    public void paquetMiseAJour(Object p) {
        this.paquetMiseAJour(p); //To change body of generated methods, choose Tools | Templates.
    }
}
