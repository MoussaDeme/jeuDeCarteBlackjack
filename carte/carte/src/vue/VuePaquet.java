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
import javax.swing.JPanel;
import model.Paquet;
import util.EcouteurPaquet;

/**
 *
 * @author Pc
 */
public abstract class VuePaquet extends JPanel implements EcouteurPaquet {

    protected Paquet p;

    public VuePaquet(Paquet p) {
        this.p = p;

        p.ajoutEcouteur(this);
    }

    @Override
    public void paquetMiseAJour(Object o) {
        
        repaint();
       
    }
        

    public Paquet getP(){
        return this.p;
    }

   

}
