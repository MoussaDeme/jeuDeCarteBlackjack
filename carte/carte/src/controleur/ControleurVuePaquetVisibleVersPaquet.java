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
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Pc
 */
public class ControleurVuePaquetVisibleVersPaquet implements MouseListener, MouseMotionListener {

    //private Carte carteSource;
    private VuePaquetVisible vueSource;
    private Paquet destination;

    public ControleurVuePaquetVisibleVersPaquet(VuePaquetVisible vueSource, Paquet destination) {

        
        this.vueSource = vueSource;
        vueSource.addMouseMotionListener(this);
        vueSource.addMouseListener(this);
        this.destination = destination;
    }

    public void mouseClicked(MouseEvent e) {
        //destination.addCardDebut(carteSource);
        /*int j=0;
        while(carteSource!=vuesource.getP().getListeCarte().get(j)){
            j++;
        }*/
       // vueSource.getP().getListeCarte().remove(e.getSource());
       
       if(vueSource.getSelectedCard()!=-1){
           this.destination.addCardDebut(vueSource.getP().getListeCarte().get(vueSource.getSelectedCard()));
           this.vueSource.getP().getListeCarte().remove(vueSource.getSelectedCard());
       }
    }

    public void mousePressed(MouseEvent e) {
        
        
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
   public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    int selectedCard = (int) (e.getX()/(vueSource.getRec().getWidth()+7));
   vueSource.setSelectedCard(selectedCard);
    System.out.println("carte numero "+selectedCard);
      }
}
