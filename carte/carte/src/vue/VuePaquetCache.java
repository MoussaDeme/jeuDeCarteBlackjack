/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import model.Paquet;
import model.PaquetFactory;
import util.AbstractPaquetEcoutable;

/**
 *
 * @author Pc
 */
public class VuePaquetCache extends VuePaquet{
    private int epaisseur;
    public VuePaquetCache(Paquet p){
        super(p);
        this.epaisseur = p.getListeCarte().size();
        p.ajoutEcouteur(this);
    }

    @Override
    public void paquetMiseAJour(Object p) {
        super.paquetMiseAJour(p); //To change body of generated methods, choose Tools | Templates.
    }
    
     
}
