/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import model.Paquet;
import vue.VuePaquetCache;

/**
 *
 * @author DELL
 */
public class VueTablePioche extends VuePaquetCache {
    
    public VueTablePioche(Paquet pioche){
        super(pioche);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
