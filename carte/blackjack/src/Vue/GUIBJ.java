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

    private static JButton boutonCommencer = new JButton("commencer");
    private static JButton boutonDemanderCarte = new JButton("demandé une carte");
    private static JButton boutonPasserTour = new JButton("passer son tour ");
    private static JButton boutonDoublerMise = new JButton("doublé la mise");
    private static Joueur humain;
    private static TablePioche tablePioche;
    private static Croupier croupier;
    private static ControleurPiocheJoueur controleJeu;
    private static Joueur robot;
    private static Joueur robot2;
    private static Container cp;
    private static JOptionPane message;
    private static Set<Joueur> listeGagnants;
    private static JLabel jMise;

    public GUIBJ() {

        humain = new JoueurHumain("Humain", 30);
        robot = new Robots("Joueur1", 10);
        robot2 = new Robots("Joueur2", 50);
        List<Joueur> listJoueurs = new ArrayList<Joueur>();
        listJoueurs.add(humain);
        listJoueurs.add(robot);
        listJoueurs.add(robot2);
        tablePioche = new TablePioche(PaquetFactory.createPaquet(52));
        tablePioche.getPioche().melanger();
        croupier = new Croupier("Croupier", 5000, listJoueurs, tablePioche);
        controleJeu = new ControleurPiocheJoueur(croupier);
        
        VueTablePioche vuePioche = new VueTablePioche(tablePioche.getPioche());
        VueJoueur vueMainJoueur = new VueJoueur(humain.getMainJoueur());
        VueJoueur vueRobot = new VueJoueur(robot.getMainJoueur());
        VueJoueur vueCroupier = new VueJoueur(croupier.getMainJoueur());
        VueJoueur vueRobot2 = new VueJoueur(robot2.getMainJoueur());
        
        jMise = new JLabel("Humain, "+" Mise : "+controleJeu.getCroupier().getListPlayer().get(0).getMise());
        
        vueCroupier.add(new JLabel("Croupier"));
        vueMainJoueur.add(jMise);
        vueRobot.add(new JLabel("Joueur1, "+" Mise : "+robot.getMise()));
        vueRobot2.add(new JLabel("Joueur2, "+" Mise : "+robot2.getMise()));

        boutonDemanderCarte.setEnabled(false);
        boutonPasserTour.setEnabled(false);
        
        boutonCommencer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controleJeu.distribuerInit();
                boutonCommencer.setEnabled(false);
                boutonDoublerMise.setEnabled(true);
                boutonDemanderCarte.setEnabled(true);
                boutonPasserTour.setEnabled(true);
            }
        });
        
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(0,1,0,5));

        
        boutonDemanderCarte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                controleJeu.supprimeJoueursPerdants(controleJeu.getCroupier().getListPlayer());
                controleJeu.donnerCarte(humain);
                
                boutonDoublerMise.setEnabled(false);
                
            }

        });
        
        boutonDoublerMise.setEnabled(false);
        boutonDoublerMise.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if(controleJeu.getCroupier().getJoueurCourant()instanceof JoueurHumain){
                    controleJeu.getCroupier().getListPlayer().get(0).doublerSaMise();
                    jMise.setText("humain, "+" Mise : "+controleJeu.getCroupier().getListPlayer().get(0).getMise());
                    boutonDoublerMise.setEnabled(false);
                    boutonDemanderCarte.setEnabled(false);
                }
            }
        });
            boutonPasserTour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controleJeu.getCroupier().donnerTour();

                boutonDemanderCarte.setEnabled(false);
                boutonPasserTour.setEnabled(false);

                while (controleJeu.getCroupier().getJoueurCourant() != humain && controleJeu.gameOver() == false){

                     if (controleJeu.getCroupier().getPoids() < 17){
                        controleJeu.donnerCarte(controleJeu.getCroupier());
                    }
                }
                if (controleJeu.gameOver() == false) {
                    /*
                    if (controleJeu.getCroupier().getPoids() < 17){
                        controleJeu.donnerCarte(controleJeu.getCroupier());
                    }*/
                    boutonDemanderCarte.setEnabled(true);
                    boutonPasserTour.setEnabled(true);
                    } else{
                        listeGagnants = new HashSet<Joueur>(controleJeu.gagnants());

                        String chaine ="le(s) gagnant(s):";
                        for(Joueur j: listeGagnants){
                            if(j instanceof Croupier){
                                chaine+="\n"+j.getNomJoueur()+" CAISSE :"+j.getMise()+"\n";
                            }else{
                                chaine+="\n"+j.getNomJoueur()+"  Gain :"+j.getMise()/2+"\n";
                            }
                        }
                    JOptionPane.showMessageDialog(cp, chaine, "Game Over", JOptionPane.INFORMATION_MESSAGE);
                   
                }
            }
        });

        cp.add(vueCroupier);
        cp.add(vueRobot);
        cp.add(vueRobot2);
        
        Dimension d =new Dimension(50, 30);
        boutonDemanderCarte.setSize(d);
        boutonCommencer.setSize(d);
        boutonPasserTour.setSize(d);
        
        //BorderLayout blayout = new BorderLayout();
        JPanel pan1 = new JPanel(new GridLayout(0,4,5,0));
        pan1.add(boutonDemanderCarte );
        pan1.add(boutonCommencer);
        pan1.add(boutonPasserTour);
        pan1.add(boutonDoublerMise);
        
        vueMainJoueur.setBackground(Color.pink);
        cp.add(vueMainJoueur);
        cp.add(pan1);

        this.setSize(1000, 700);
        this.setVisible(true);
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
