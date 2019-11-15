/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import model.Paquet;
 
/**
 *
 * @author Pc
 */
public class VuePaquetCache extends VuePaquet{
    
    private  Rectangle2D rec;
 
    public VuePaquetCache(Paquet p){
        super(p);
        this.rec = new Rectangle2D.Double(1,1,70,100);
    }

    @Override
    public void paquetMiseAJour(Object p) {
        super.paquetMiseAJour(p); 
         
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g);

        for (int i = 0; i < p.getListeCarte().size(); i++) {   
           g2D.drawRoundRect((int)rec.getX()+i, (int)rec.getY()+i, (int)rec.getWidth(), (int)rec.getHeight(),10, 10);
           if(i<p.getListeCarte().size()-1){
               g2D.setColor(Color.black);
           }else{
               g2D.setColor(Color.white);
               g2D.fillRoundRect((int)rec.getX()+i, (int)rec.getY()+i, (int)rec.getWidth(), (int)rec.getHeight(),10, 10);
           }
        }
  }
}
