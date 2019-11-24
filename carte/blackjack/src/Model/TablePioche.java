/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import model.Paquet;

/**
 *
 * @author DELL
 */
public class TablePioche{
    private Paquet pioche;
    
    public TablePioche(Paquet pioche){
        this.pioche=pioche;
    }

    public Paquet getPioche(){
        return this.pioche;
    }
    
}
