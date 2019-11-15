/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc
 */
public class PaquetFactory {
    private static String[] valeur ={"2", "3", "4", "5", "6", "7", "8", "9", "10", "VALET", "DAME", "ROI", "AS"};
    private static String[] couleur ={"PIQUE", "COEUR", "CARREAU", "TREFLE"};
    public static Paquet createPaquet(int taille){
        if((taille==32) || (taille == 52)){
            Paquet paquet = new Paquet(taille);
            if(taille==52){
                for(int i=0; i<valeur.length; i++){
                    for(int j=0; j<couleur.length; j++){
                       paquet.addCardFin(new Carte(valeur[i], couleur[j]));
                     }
                }
            }else{
                for(int i=5; i<valeur.length; i++){
                    for(int j=0; j<couleur.length; j++){
                       paquet.addCardFin(new Carte(valeur[i], couleur[j]));
                     }
                }
            }
            return paquet;
        }else{
            /**
             * Pour une main initialement vide
             */
            return new Paquet(); 
        }
    }
}
