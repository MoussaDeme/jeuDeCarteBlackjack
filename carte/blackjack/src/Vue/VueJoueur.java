/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import model.Paquet;
import vue.VuePaquetVisible;

/**
 *
 * @author DELL
 */
public class VueJoueur extends VuePaquetVisible{
    
    public VueJoueur(Paquet mainJoueur) {
        super(mainJoueur);
    }
    
    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    
    }
}
