/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import vue.VuePaquet;
import vue.VuePaquetCache;
import vue.VuePaquetVisible;
import model.Carte;
import model.Paquet;
import model.PaquetFactory;
import util.EcouteurPaquet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Pc
 */
    public class GUI extends JFrame implements EcouteurPaquet, MouseListener{
    private String[] valeur ={"2", "3", "4", "5", "6", "7", "8", "9", "10", "VALET", "DAME", "ROI", "AS"};
    private String[] couleur ={"PIQUE", "COEUR", "CARREAU", "TREFLE"};
   
    public GUI(){
       JFrame fen = new JFrame("BlackJack");
       // Graphics g = new Rectangle(20, 30);
       /* JTextArea sortie = new JTextArea();
        sortie.setEditable(false);
        getContentPane().add(new JScrollPane(sortie), BorderLayout.NORTH);*/
        
        
        VuePaquet pioche = new VuePaquetCache(PaquetFactory.createPaquet(52));
        
        /**
         * Crée un paquet initialement vide 
         * 0 ne signifie pas que le paquet a une taille de 0 mais plutôt vide
         * (Voir dans la classe PquetFactory
         */
        VuePaquet main = new VuePaquetVisible(PaquetFactory.createPaquet(0));
        VuePaquet defausse = new VuePaquetVisible(PaquetFactory.createPaquet(0));
        double k = 5;
        int cpt=0;
        for(int i=0; i<this.valeur.length; i++){
           
                /**
                 * Création des 52 cartes pour la pioche
                 */
               for(int j=0; j<this.couleur.length; j++){
                   Carte c = new Carte(this.valeur[i], this.couleur[j]);
                    //pioche.getP().addCardFin(c);
                   Canvas canvas = new Canvas(k, k);
                 //  canvas.add(c);
                   pioche.getP().addCardFin(c);
                   //pioche.getP().getListeCarte().set(i*j, c);
                   pioche.getP().setCarte(c, cpt);
                   fen.getContentPane().add(canvas);
                   k+=5;
                   cpt+=1;
                   //this.paintComponent(g);           
               }
               /* pioche.getP().addCardFin(new Carte(this.valeur[i], this.couleur[0]));
                fen.getContentPane().add(new Canvas());
                pioche.getP().addCardFin(new Carte(this.valeur[i], this.couleur[1]));
                fen.getContentPane().add(new Canvas());
                pioche.getP().addCardFin(new Carte(this.valeur[i], this.couleur[2]));
                fen.getContentPane().add(new Canvas());
                pioche.getP().addCardFin(new Carte(this.valeur[i], this.couleur[3]));
                fen.getContentPane().add(new Canvas());*/
        }
        
        System.out.println(pioche.getP().getListeCarte().size());
        
       // pioche.getP().melanger();
        
        
      fen.setSize(800, 500);
      fen.setLocation(100, 100);
      fen.setVisible(true);
      fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   /*  public void paintComponent(Graphics g){
         super.paintComponents(g);
         for(int i=0; i<this.valeur.length; i++){
             for(int j=0; j<this.couleur.length; j++){
                 g.drawRect(i+10, j+10, 50, 50);
             }
         }
    }*/
    
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
