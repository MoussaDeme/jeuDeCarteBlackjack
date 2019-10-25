/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import cartes.Carte;


/**
 *
 * @author 21912873
 */
public class MainClass {
    public static void main(String[] args)
    {
        Carte c5 = new Carte("blackJack", "pique");
        System.out.println(c5.toString());
        
    }
}
