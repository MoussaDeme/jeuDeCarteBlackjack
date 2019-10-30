/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import model.Carte;
import vue.VuePaquet;
import vue.VuePaquetVisible;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Pc
 */
public class ControleurPiocheVersPaquet implements MouseListener{
    private VuePaquet paquet;
    private VuePaquet paquetDestation;
    private Carte carte;
    public ControleurPiocheVersPaquet(VuePaquet vuePaquet, VuePaquet paquetDestation) {
       if(vuePaquet.getP().getListeCarte().contains(this.carte))
       {
           paquetDestation.getP().addCardDebut(vuePaquet.getP().getListeCarte().get(0));
           vuePaquet.getP().getListeCarte().remove(vuePaquet.getP().getListeCarte().get(0));
       }           
    }
  
    
    public void mouseClicked(MouseEvent e) {
         this.carte = (Carte)e.getSource();
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
