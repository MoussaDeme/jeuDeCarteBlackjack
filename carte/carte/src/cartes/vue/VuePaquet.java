/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartes.vue;

import cartes.Paquet;
import util.EcouteurPaquet;

/**
 *
 * @author Pc
 */
public abstract class VuePaquet implements EcouteurPaquet{
    private Paquet p;
    public VuePaquet(Paquet p) {
        this.p = p;
    }

    @Override
    public void paquetMiseAJour(Object p) {
       Paquet p1 = (Paquet)p;
       for(int i=0; i<p1.getListeCarte().size(); i++){
           System.out.println(p1.getListeCarte().get(i).toString());
       }
    }
  public Paquet getP(){
      return this.p;
  }
}
