/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controlleur.ControleurPiocheJoueur;
import Model.Croupier;
import Model.Joueur;
import Model.JoueurHumain;
import java.util.concurrent.TimeUnit;
import Model.Robots;
import Model.TablePioche;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.PaquetFactory;

/**
 *
 * @author DELL
 */
public class GUIBJ extends JFrame {

    public static JButton bouttonCommencer = new JButton("commencer");
    public static JButton buttonDemanderCarte = new JButton("demandé carte");
    public static JButton buttonPasserTour = new JButton("passer son tour ");
    public static Joueur humain;
    public static TablePioche tablePioche;
    public static Croupier croupier;
    public static ControleurPiocheJoueur controleJeu;
    public static Joueur robot;
    public static Joueur robot2;
    public static Container cp;

    public GUIBJ() {

        humain = new JoueurHumain("humain", 30);
        robot = new Robots("Robot", 30);
        robot2 = new Robots("Robot2",10000);
        List<Joueur> listJoueurs = new ArrayList<Joueur>();
        listJoueurs.add(humain);
        listJoueurs.add(robot);
        listJoueurs.add(robot2);
        tablePioche = new TablePioche(PaquetFactory.createPaquet(52));
        tablePioche.getPioche().melanger();
        croupier = new Croupier("BlackJack", 5000, listJoueurs, tablePioche);

        VueTablePioche vuePioche = new VueTablePioche(tablePioche.getPioche());
        VueJoueur vueMainJoueur = new VueJoueur(humain.getMainJoueur());
        VueJoueur vueRobot = new VueJoueur(robot.getMainJoueur());
        VueJoueur vueCroupier = new VueJoueur(croupier.getMainJoueur());
        VueJoueur vueRobot2 = new VueJoueur(robot2.getMainJoueur());
        
        vueCroupier.add(new JLabel("Croupier"));
        vueMainJoueur.add(new JLabel("humain"));
        vueRobot.add(new JLabel("robot"));
        vueRobot2.add(new JLabel("robot2"));

        controleJeu = new ControleurPiocheJoueur(croupier);

        this.bouttonCommencer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                controleJeu.distribuerInit();
                bouttonCommencer.setEnabled(false);
            }
        });
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(5, 1));
        
        buttonDemanderCarte.setEnabled(true);
        buttonPasserTour.setEnabled(true);
        this.buttonDemanderCarte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                controleJeu.donnerCarte(humain);
            }

        });

        this.buttonPasserTour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controleJeu.getCroupier().donnerTour();
                //System.out.println("go to sleep");
                
                buttonDemanderCarte.setEnabled(false);
                buttonPasserTour.setEnabled(false);
                try {
                    // System.out.println(croupier.getJoueurCourant().getNomJoueur()+":"+croupier.getJoueurCourant().getPoids());
                   while(controleJeu.getCroupier().getJoueurCourant()!= humain){
                    controleJeu.gestionRobots();
              
                   }
                   if(controleJeu.getCroupier().getPoids()<17){
                       controleJeu.donnerCarte(controleJeu.getCroupier());
                   }
                  
                } catch (InterruptedException ex) {
                    Logger.getLogger(GUIBJ.class.getName()).log(Level.SEVERE, null, ex);
                }
                buttonDemanderCarte.setEnabled(true);
                buttonPasserTour.setEnabled(true);
                //controleJeu.gestionRobots();
                
            }

        });
        
        
        
        cp.add(vueCroupier);
        cp.add(buttonDemanderCarte);
        cp.add(vueMainJoueur);
        cp.add(vueRobot);
        cp.add(vueRobot2);
        
        //cp.add(vueCroupier);
        cp.add(bouttonCommencer);
        cp.add(buttonPasserTour);

        this.setSize(1000, 1000);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    }

}
