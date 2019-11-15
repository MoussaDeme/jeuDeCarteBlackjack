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
public class VuePaquetVisible extends VuePaquet {

    
    private Rectangle2D rec;
    private int selectedCard=-1;

    public VuePaquetVisible(Paquet p) {
        super(p);
        p.ajoutEcouteur(this);
        this.rec = new Rectangle2D.Double(1, 1, 70, 100);

    }

    public Rectangle2D getRec()
    {
        return rec;
    }
    
    @Override
    public void paquetMiseAJour(Object p) {
        super.paquetMiseAJour(p); 
    }

    

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
         super.paintComponent(g);
        int k = 10;
        for (int i = 0; i < this.p.getListeCarte().size(); i++) {
            
            g2D.setColor(Color.white);
            g2D.fillRoundRect((int) rec.getX() + k, (int) rec.getY() +50, (int) rec.getWidth(), (int) rec.getHeight(), 10, 10);
            System.out.println("i="+i+" boolean="+(i== selectedCard ));
            g2D.setColor(i== selectedCard ? Color.GREEN : Color.black);
            g2D.drawRoundRect((int) rec.getX()+k,(int) rec.getY()+50, (int) rec.getWidth(), (int) rec.getHeight(), 10, 10);
            g2D.drawString(p.getListeCarte().get(i).getValeur(), (int) rec.getX() +k+7, (int) rec.getY() + 70);
            g2D.drawString(p.getListeCarte().get(i).getCouleur(), (int) rec.getX() +k+7, (int) rec.getY() + 90);
           
            k += 80;
        }
    }

    public int getSelectedCard()
    {
        return selectedCard;
    }
    public void setSelectedCard(int i)
    {
        this.selectedCard=i;
        System.out.println("Dans Vue carte numero "+selectedCard);

        repaint();
    }
 

}
