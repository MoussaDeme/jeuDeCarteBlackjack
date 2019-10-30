/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import util.EcouteurPaquet;

/**
 *
 * @author Pc
 */
public class Fenetre extends JFrame implements EcouteurPaquet, MouseListener{
    
    public Fenetre(){
        JFrame fen = new JFrame("Jeux de cartes");
        fen.setSize(300, 500);
        fen.setVisible(true);
        fen.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void paintComponent(Graphics g){
        g.drawRect(100, 100, 50, 50);
    }

    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public void paquetMiseAJour(Object ob) {
        this.repaint();
    }
}
