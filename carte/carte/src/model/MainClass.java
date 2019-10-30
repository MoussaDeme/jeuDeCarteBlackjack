/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import gui.GUI;
import util.AbstractPaquetEcoutable;

/**
 *
 * @author 21814195
 */
public class MainClass {
      
    public static void main(String[] args)
    {
      // Carte c1 = new Carte("as", "pique");
      // Carte c2 = new Carte("Carreau", "valCarreau");
      // System.out.println(c1.toString());
       
      // Paquet p = new Paquet();
     GUI gui = new GUI();
        //AbstractPaquetEcoutable  p = PaquetFactory.createPaquet(32);
        
        //PaquetFactory fact = new PaquetFactory();
        /*Paquet p = PaquetFactory.createPaquet(52);
        System.out.println(p.getListeCarte().size());
        for(int i=0; i<p.getListeCarte().size(); i++){
            System.out.println(p.getListeCarte().get(i).toString());
        }*/
    }
}
