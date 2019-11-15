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
public class ControleurPiocheVersPaquet implements MouseListener {

    private VuePaquet vuepaquet;
    private VuePaquet paquetDestation;

    //private Carte carte;
    public ControleurPiocheVersPaquet(VuePaquet vuePaquet, VuePaquet paquetDestation) {
        this.vuepaquet = vuePaquet;
        this.paquetDestation = paquetDestation;
        
    }

    public void mouseClicked(MouseEvent e) {
        paquetDestation.getP().addCardDebut(vuepaquet.getP().getListeCarte().get(0));
        vuepaquet.getP().getListeCarte().remove(vuepaquet.getP().getListeCarte().get(0));

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

}
