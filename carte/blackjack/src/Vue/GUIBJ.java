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
import Model.Robots;
import Model.TablePioche;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import model.PaquetFactory;

/**
 *
 * @author DELL
 */
public class GUIBJ extends JFrame {

    public GUIBJ() {

        final Joueur humain = new JoueurHumain("HAMID", 30);
        Joueur robot = new Robots("Rachid", 30);
        List<Joueur> listJoueurs = new ArrayList();
        listJoueurs.add(humain);
        listJoueurs.add(robot);
        final TablePioche tablePioche = new TablePioche(PaquetFactory.createPaquet(52));
        tablePioche.getPioche().melanger();
        Croupier croupier = new Croupier("BlackJack", 0, listJoueurs, tablePioche);

        VueTablePioche vuePioche = new VueTablePioche(tablePioche.getPioche());
        VueJoueur vueMainJoueur = new VueJoueur(humain.getMainJoueur());
        VueJoueur vueRobot = new VueJoueur(robot.getMainJoueur());

        final ControleurPiocheJoueur distribuer = new ControleurPiocheJoueur(croupier);

        final JButton buttonCommence = new JButton("commencer");
        buttonCommence.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                distribuer.distribuerInit();
                buttonCommence.setEnabled(true);
            }
        });

        final JButton buttonDemanderCarte = new JButton("demandé carte");

        buttonDemanderCarte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                distribuer.donnerCarte(humain.getMainJoueur());
               
                    System.out.println(tablePioche.getPioche().getListeCarte().size());
            }
        });

        Container cp = this.getContentPane();
        cp.setLayout(new GridLayout(5, 1));
        cp.add(vuePioche);
        cp.add(buttonDemanderCarte);
        cp.add(vueMainJoueur);
        cp.add(vueRobot);
        cp.add(buttonCommence);
        //vuePioche.setBackground(Color.green);

        this.setSize(700, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
