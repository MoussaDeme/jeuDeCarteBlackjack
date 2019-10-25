/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Pc
 */
public interface PaquetEcoutable {
    public void ajoutEcouteur(EcouteurPaquet e);
    public void retraitEcouteur(EcouteurPaquet e);
}
