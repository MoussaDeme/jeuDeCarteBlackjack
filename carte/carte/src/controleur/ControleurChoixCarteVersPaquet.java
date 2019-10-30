/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import model.Carte;
import model.Paquet;
import vue.VuePaquetVisible;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Pc
 */
public class ControleurChoixCarteVersPaquet implements MouseListener{
   private Carte carteSource;
   private VuePaquetVisible vuesource;
   private Paquet destination;
   
    public ControleurChoixCarteVersPaquet(VuePaquetVisible vueSource, Paquet destination){
        
        if(vueSource.getP().getListeCarte().contains(this.carteSource))   
        {
          destination.addCardDebut(carteSource);
          vuesource.getP().getListeCarte().remove(carteSource);
        }
        this.vuesource = vueSource;
        this.destination = destination;
     }
    
    

    public void mouseClicked(MouseEvent e) {
       this.carteSource = (Carte)e.getSource();
    }

    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
