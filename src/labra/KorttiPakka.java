/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labra;

import java.util.*;

/**
 *
 * @author tanelvir
 */
public class KorttiPakka {
    
    public ArrayList<Kortti> kortit;
    public Kortti kuvake;
    
    /**
     * 
     * Luodaan korttipakka.
     * 
     * @return kortit.
     * 
     */
    
    public KorttiPakka() {
        kortit = new ArrayList();
    }
    
     /**
     * 
     * sekoitetaan pakkaa, eli luodaan ns. koko pakka.
     * 
     * @return kortit, joissa on symbolit (kuvat):
     * 
     */
    
    public ArrayList sekoitus() {
        for (int i = 1; i <= 16; i++) {
            kuvake = new Kortti(i);
            kortit.add(kuvake);
        }
        return kortit;
    }
    
    /**
     * Kun pari ollaan löydetty, molemmat arvot avaimineen poistetaan.
     * 
     * @param numero1
     * @param numero2 
     */
    
    public void poista(int numero1, int numero2) {
        kortit.remove(numero1);
        kortit.remove(numero2);
    }
    
     /**
     * Etsitään löytyykö kortti pakasta. Varmaan korvaa tarkistaNumeron.
     * 
     * @param luku
     * 
     * @return löytyikö kortti vai ei? 
     */
    
    
    public boolean etsiKortti(int luku) {
        if (kortit.contains(kortit.get(luku-1))) {
            return true;
        }
        else return false;                 
    }
    
    /**
     * Palauttaa valitseman kortin.
     * 
     * @param luku
     * 
     * @return kortti? 
     */
    
    public Kortti getKortti(int luku) {
        return kortit.get(luku-1);
    }
    
    
    /**
     * Tämän hetken korttien lukumäärä (aina parillinen):
     * 
     * @return korttien määrä
     */
    public int korttejaYhteensa() {
       return kortit.size();
    }
    
}
