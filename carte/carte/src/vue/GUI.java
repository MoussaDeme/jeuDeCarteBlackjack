/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.ControleurVuePaquetVisibleVersPaquet;
import controleur.ControleurPiocheVersPaquet;
import model.PaquetFactory;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
 

/*
 *
 * @author Pc
 */
public class GUI extends JFrame implements /*EcouteurPaquet,*/ MouseListener {

        
    public GUI(){
        
        final VuePaquetVisible vueMainJoueur = new VuePaquetVisible(PaquetFactory.createPaquet(0));
        final VuePaquet vuePioche = new VuePaquetCache(PaquetFactory.createPaquet(52));
        final VuePaquet vueDefausse = new VuePaquetVisible(PaquetFactory.createPaquet(0));
        vuePioche.getP().melanger();
        Container cp = this.getContentPane();

        new ControleurVuePaquetVisibleVersPaquet(vueMainJoueur,vueDefausse.getP());
        
        cp.setLayout(new BorderLayout());
        
        final  ControleurPiocheVersPaquet piochePaquet = new ControleurPiocheVersPaquet(vuePioche, vueMainJoueur);
        vuePioche.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
               if((e.getX()<150) && (e.getY()<200)){
               
               piochePaquet.mouseClicked(e);
              //System.out.println(pioche.getP().getListeCarte().size());
              //System.out.println(mainJoueur.getP().getListeCarte().size());
              vuePioche.paquetMiseAJour(vuePioche.getP());
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
        });
        vueMainJoueur.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
              /*  if(mainJoueur.getSelectedCard() !=-1)
                {
                    
                }*/
               //ControleurChoixCarteVersPaquet
                //mainDefausse.mouseClicked(e);
                System.out.println(vueDefausse.getP().getListeCarte().size());
                System.out.println(vueMainJoueur.getP().getListeCarte().size());
                vueMainJoueur.paquetMiseAJour(vueMainJoueur.getP());
            
                }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
        
        
         
        /*
         * Crée un paquet initialement vide 
         * 0 ne signifie pas que le paquet a une taille de 0 mais plutôt vide
         * (Voir dans la classe PquetFactory
         */
        
        //dimensionner borderLayout Center
        cp.add(vueMainJoueur,BorderLayout.CENTER);
        
        vuePioche.setPreferredSize( new Dimension(400,200));
        cp.add(vuePioche,BorderLayout.PAGE_START);
        
        this.setSize(800, 500);
        this.setLocation(100, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mouseClicked(MouseEvent e) {
      
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void paquetMiseAJour(Object ob) {
        this.repaint();
    }
}
