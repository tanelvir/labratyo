/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labra;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author tanelvir
 */
public class KorttiPakka {
    
    public HashMap<Integer,Kortti> kortit;

    
    ArrayList<Integer> arvotut;
    public Kortti kuvake;
    
    /**
     * 
     * Luodaan korttipakka.
     * 
     * @return kortit.
     * 
     */
    
    public KorttiPakka() {
        kortit = new HashMap();
        arvotut = new ArrayList();
    }
    public void setArvotut(ArrayList<Integer> arvotut) {
        arvotut = kuvanArpoja();
        this.arvotut = arvotut;
    }
    public ArrayList kuvanArpoja() {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for (int i = 1; i <= 16; i++) {
            lista.add(i);
        }
        Collections.shuffle(lista);
        return lista;
    }
    
     /**
     * 
     * sekoitetaan pakkaa, eli luodaan ns. koko pakka.
     * 
     * @return kortit, joissa on symbolit (kuvat):
     * 
     */
    
    public HashMap sekoitusArvottu() {
        int luku;
        arvotut = kuvanArpoja();
        for (int i = 0; i <= 15; i++) {
            kuvake = new Kortti(arvotut.get(i));
            kortit.put(i, kuvake);
        }
        return kortit;
    }
    
    public HashMap sekoitusEiArvottu() {
        for (int i = 1; i <= 16; i++) {
            kuvake = new Kortti((i));
            kortit.put(i, kuvake);
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
        if (kortit.containsKey(luku)) {
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
        return kortit.get(luku);
    }
    
    
    /**
     * Tämän hetken korttien lukumäärä (aina parillinen):
     * 
     * @return korttien määrä
     */
    public int korttejaYhteensa() {
       return kortit.size();
    }
    
    public String toString() {
        return ""+kortit;
    }
    
}
