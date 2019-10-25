/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartes;

/**
 *
 * @author 21912873
 */
public class Carte {
   private String valeur;
   private String couleur;

    public Carte(String valeur, String couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "valeur=" + valeur + ", couleur=" + couleur;
    }
}
