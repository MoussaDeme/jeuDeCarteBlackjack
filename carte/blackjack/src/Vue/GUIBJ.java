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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    public static JOptionPane message;
    public static Set<Joueur> listeGagnants;

    public GUIBJ() {

        humain = new JoueurHumain("humain", 30);
        robot = new Robots("Robot", 10);
        robot2 = new Robots("Robot2", 50);
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
        vueMainJoueur.add(new JLabel("humain, "+" Mise : "+humain.getMise()));
        vueRobot.add(new JLabel("robot 1, "+" Mise : "+robot.getMise()));
        vueRobot2.add(new JLabel("robot 2, "+" Mise : "+robot2.getMise()));

        controleJeu = new ControleurPiocheJoueur(croupier);

        this.bouttonCommencer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                controleJeu.distribuerInit();
                bouttonCommencer.setEnabled(false);
            }
        });
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(0, 1,0,5));

        buttonDemanderCarte.setEnabled(true);
        buttonPasserTour.setEnabled(true);
        this.buttonDemanderCarte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                controleJeu.supprimeJoueursPerdants(controleJeu.getCroupier().getListPlayer());
                controleJeu.donnerCarte(humain);
            }

        });

        this.buttonPasserTour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controleJeu.getCroupier().donnerTour();
                //System.out.println("go to sleep");

                buttonDemanderCarte.setEnabled(false);
                buttonPasserTour.setEnabled(false);

                // System.out.println(croupier.getJoueurCourant().getNomJoueur()+":"+croupier.getJoueurCourant().getPoids());
                while (controleJeu.getCroupier().getJoueurCourant() != humain && controleJeu.gameOver() == false) {
                    controleJeu.gestionRobots();
                }
                if (controleJeu.gameOver() == false) {

                    if (controleJeu.getCroupier().getPoids() < 17) {
                        controleJeu.donnerCarte(controleJeu.getCroupier());
                    }

                    buttonDemanderCarte.setEnabled(true);
                    buttonPasserTour.setEnabled(true);
                    //controleJeu.gestionRobots();
                } else {
                    listeGagnants = new HashSet<Joueur>(controleJeu.gagnant());
                    System.out.println("Gagnants :");
                    String chaine ="";
                    for(Joueur j: listeGagnants){
                        System.out.println(j.getNomJoueur());
                        chaine+=j.getNomJoueur()+"  ---------  ";
                    }
                    System.out.println("");
                    JOptionPane.showMessageDialog(cp, chaine, "Game Over", JOptionPane.INFORMATION_MESSAGE);

                }

            }

        });

        cp.add(vueCroupier);
        cp.add(vueRobot);
        cp.add(vueRobot2);
        
        Dimension d =new Dimension(50, 30);
        buttonDemanderCarte.setSize(d);
        bouttonCommencer.setSize(d);
        buttonPasserTour.setSize(d);
        
        //BorderLayout blayout = new BorderLayout();
        JPanel pan1 = new JPanel(new GridLayout(0,3,5,0));
        pan1.add(buttonDemanderCarte );
        pan1.add(bouttonCommencer);
        pan1.add(buttonPasserTour);
        
       vueMainJoueur.setBackground(Color.pink);
        cp.add(vueMainJoueur);
        cp.add(pan1);

        this.setSize(1000, 700);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
