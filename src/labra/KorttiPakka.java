/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labra;

import java.util.HashMap;
import labra.Kortti;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * Tämä on korteita muodostuva pakka, joka tuntee korttinsa.
 *
 * @author tanelvir
 */
public class KorttiPakka {
    
    HashMap<Integer,Kortti> kortit;   
    ArrayList<Integer> arvotut;
    Kortti kuvake;
    Kortti[] taulukko;
    
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
    
    /**
     * 
     * Luo pakan jossa on arvotut kortit.
     * 
     * @param arvotut 
     */
    public void setArvotut(ArrayList<Integer> arvotut) {
        arvotut = kuvanArpoja();
        this.arvotut = arvotut;
    }
    
    /**
     * Arpoo satunnaisluvun perusteella kortille kuvan.
     * @return 
     */
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
        arvotut = kuvanArpoja();
        for (int i = 0; i <= 15; i++) {
            kuvake = new Kortti(arvotut.get(i));
            kortit.put(i+1, kuvake);
        }
        return kortit;
    }
    
    /**
     * Ei arvottu pakka.
     * @return 
     */
    
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
    
    public boolean etsiItseKortti(Kortti kortti) {
        if (kortit.containsValue(kortti)) {
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
    
    public HashMap getKortit() {
        return kortit;
    }
    
    public ImageIcon getKuvake(int luku) {
        return kortit.get(luku).getKuva();       
    }
    
    public int getInt(int luku) {
        return kortit.get(luku).getIndeksi();
    }
    
    
    /**
     * Tämän hetken korttien lukumäärä (aina parillinen):
     * 
     * @return korttien määrä
     */
    public int korttejaYhteensa() {
       return kortit.size();
    }
    
    /**
     * Tulostetaan kyseinen pakka.
     * @return 
     */
    
    public String toString() {
        return ""+kortit;
    }
    
}
