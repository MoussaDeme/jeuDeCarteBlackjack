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
    
    public static Paquet createPaquet(int taille){
        if((taille==32) || (taille == 52)){
            return new Paquet(taille);
        }else{
            /**
             * Pour une main initialement vide
             */
            return new Paquet(); 
        }
    }
}
