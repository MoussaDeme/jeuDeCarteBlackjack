/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc
 */
public abstract class AbstractPaquetEcoutable implements PaquetEcoutable
{
    private List<EcouteurPaquet> ecouteur;
    
    public AbstractPaquetEcoutable(){
        this.ecouteur  = new ArrayList<EcouteurPaquet>();
    }
    
    public void ajoutEcouteur(EcouteurPaquet e){
        this.ecouteur.add(e);
    }
    public void retraitEcouteur(EcouteurPaquet e){
        this.ecouteur.remove(e);
    }
    
    public void changement(){
        for(EcouteurPaquet e: this.ecouteur){
            e.paquetMiseAJour(this);
        }
    }

}
