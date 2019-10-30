/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author 21814195
 */
public class Carte extends JComponent{
   private String valeur;
   private String couleur;

    public Carte(String valeur, String couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return valeur + " ==> " + couleur;
    }
    
   /* public Graphics2D drawCard(Carte c){
        Graphics2D g = null;
        g.drawRect(5, 5, 100, 100);
        g.setColor(Color.white);
        //int d = SystemColor.ACTIVE_CAPTION;
        g.fillRect(7, 7, 100, 100);
        return g;
    }*/
}
