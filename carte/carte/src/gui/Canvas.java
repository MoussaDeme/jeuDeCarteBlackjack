/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.time.Clock;
import javax.swing.JComponent;

/**
 *
 * @author Pc
 */
public class Canvas extends JComponent{
    
   // private Ellipse2D ellipse = new Ellipse2D.Double();
    private Rectangle2D rect = new Rectangle2D.Double();
    
    public Canvas(double i, double j){
         Rectangle2D rec = new Rectangle2D.Double(i, j, 70, 100);
         this.rect = rec;
         System.out.println("x="+i+", y="+j);
    }
    public void paint(Graphics g){
        g = (Graphics2D)g;
        g.drawRect((int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight());
        g.setColor(Color.white);
        //int d = SystemColor.ACTIVE_CAPTION;
        g.fillRect((int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight());
    }
}
