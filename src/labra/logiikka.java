/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labra;

/**
 * 
 * Tämä luokka yhdistää korttipakan ja pelaajan, eli siis nytten pelaaja tuntee korttipakan.
 * Tämä on graafisen pelin ydin, jonka kanssa luokka Peli kommunikoi.
 *
 * @author tanelvir
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;

public class logiikka {
    
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;
    KorttiPakka peli; // = new KorttiPakka();
    KorttiPakka tehosekoitin;
    boolean mod;
    
    
    /**
     * KESKEN: pelaajamäärä määrää pelin logiikan.
     * 
     * @param pelaajamaara
     * @param nimi1
     * @param nimi2 
     */
    
    
    public logiikka(int pelaajamaara, String nimi1, String nimi2) {
        if (pelaajamaara==1) {
            aloitaYksinPeli(nimi1);
            mod = false;
        }
        else {
            aloitaKaksinPeli(nimi1, nimi2);
            mod = true;
        }
    }
    
    /**
     * Arvottu järjestys
     */
    
    private void aloitaPeli() {        
        peli.sekoitusArvottu();
        pelaaja2.otaVuoro();
    }
    
    /**
     * Tämä on se peli, jota pelaataan Pelissä yksinpelinä
     * 
     * @param nimi1
     */
    
    private void aloitaYksinPeli(String nimi1) {
        pelaaja1 = new Pelaaja(nimi1);
        peli = new KorttiPakka();
        tehosekoitin = new KorttiPakka();
        tehosekoitin.sekoitusArvottu();
        peli = tehosekoitin;
        
    }
    
    /**
     * Tämä on se peli, jota pelaataan Pelissä kaksinpelinä
     * 
     * @param nimi1
     * @param nimi2 
     */
    
    private void aloitaKaksinPeli(String nimi1, String nimi2) {
        System.out.println(nimi1 + " aloitaPelinalku " + nimi2);
        pelaaja1 = new Pelaaja(nimi1);
        pelaaja2 = new Pelaaja(nimi2);
        System.out.println(pelaaja1.getNimi() + "LOL" + pelaaja2.getNimi());
        peli = new KorttiPakka();
        tehosekoitin = new KorttiPakka();
        tehosekoitin.sekoitusArvottu();
        peli = tehosekoitin;
        pelaaja2.otaVuoro();
    }
    
    /**
     * Tämä on testejä varten.
     */
    
    private void aloitaHarjoituspeli() {
        pelaaja1 = new Pelaaja("Esimerkki");
        pelaaja2 = new Pelaaja("Erkki");
        peli = new KorttiPakka();
        tehosekoitin = new KorttiPakka();
        tehosekoitin.sekoitusEiArvottu();
        peli = tehosekoitin;
        pelaaja2.otaVuoro();
    }
    
    
    
    public ImageIcon kuvake(int i) {
        return peli.getKuvake(i);       
    }
    
    public int indeksi(int i) {
        return getKortti(i).getIndeksi();
    }
    
    public Kortti getKortti(int i) {
        return peli.getKortti(i);
    }
    
    public Pelaaja getPelaaja1() {
        return this.pelaaja1;
    }
    
    public Pelaaja getPelaaja2() {
        return this.pelaaja2;
    }
    
    public KorttiPakka getKP() {
        return this.peli;
    }
    
    /**
     * Etsitään kortti tämän hetken pakasta.
     * 
     * @param i
     * @return löytyikö kortti vai ei
     */
    
    public boolean etsiSeKortti(int i) {
        if (getKP().etsiKortti(i)==true)
            return true;
        else return false;
    }
    
    /**
     * Ensimmäinen kortti valittuna.
     * 
     * @param valinta
     * @param pelaaja, valintoineen
     */
    
    public void ekaKerta(int valinta, Pelaaja pelaaja) {
        pelaaja.Valinta1 = valinta;
        pelaaja.vaihdaKerta();
    }
    
    /**
     * Toinen kortti valittuna.
     * @param valinta
     * @param pelaaja 
     */
    
    public void tokakerta(int valinta, Pelaaja pelaaja) {
        pelaaja.Valinta2 = valinta;
    }
    
    public void vaihdaVuoro() {
        if (mod==true) {
            getPelaaja1().vaihdaVuoro();
            getPelaaja2().vaihdaVuoro();
        }
    }
    
    public String vuoro() {
        if (pelaaja1.getVuoro()==true)
            return "Pelaajan " + pelaaja1.getNimi() + " vuoro";
        else
            return "Pelaajan " + pelaaja2.getNimi() + " vuoro";
    }
    
    /**
     * Tämä toimii jakajana kaksinpelissä, joka tietää kumman pelaajan vuoro ja kerta on kyseessä. Erilaisia vaihtoehtoja on siis 4.
     * 
     * @param valinta 
     */
    
    public void pelaajanVastaus(int valinta) {
        if (getPelaaja1().getKerta()==1 && getPelaaja1().getVuoro()==true) {
            ekaKerta(valinta, getPelaaja1());
        }
        else if (getPelaaja1().getKerta()==2 && getPelaaja1().getVuoro()==true) {
            tokakerta(valinta, getPelaaja1());
            arvausKerta(getPelaaja1().getValinta1(), getPelaaja1().getValinta2(), peli, getPelaaja1());
            vaihdaVuoro();
        }
        else if (getPelaaja2().getKerta()==1 && getPelaaja2().getVuoro()==true) {            
            ekaKerta(valinta, getPelaaja2());
        }
        else if (getPelaaja2().getKerta()==2 && getPelaaja2().getVuoro()==true) {
            tokakerta(valinta, getPelaaja2());
            arvausKerta(getPelaaja2().getValinta1(), getPelaaja2().getValinta2(), peli, getPelaaja2());
            vaihdaVuoro();
        }
        else System.out.println("ERROR");
    }
    
    /**
     * Tämä toimii jakajana kaksinpelissä, joka tietää kumman pelaajan vuoro ja kerta on kyseessä. Erilaisia vaihtoehtoja on siis 4.
     * 
     * @param valinta 
     */
    
    public void pelaajanVastausYksin(int valinta) {
        System.out.println(getPelaaja1().getNimi() + "vuorot: " + (getPelaaja1().getKerta() + " " + getPelaaja1().getVuoro()));
        if (getPelaaja1().getKerta()==1 && getPelaaja1().getVuoro()==true) {
            ekaKerta(valinta, getPelaaja1());
        }
        else if (getPelaaja1().getKerta()==2 && getPelaaja1().getVuoro()==true) {
            tokakerta(valinta, getPelaaja1());
            arvausKerta(getPelaaja1().getValinta1(), getPelaaja1().getValinta2(), peli, getPelaaja1());
        }
    }
    
    public HashMap poistaTurhat(Kortti[] taulu) {
        for (int i = 0; i < taulu.length; i++) {
            if (taulu[i]==null)
                getHajautus().remove(taulu[i]);
        }
            return getHajautus();
    }
    
    public HashMap getHajautus() {
        System.out.println(peli.getKortit());
        return peli.getKortit();
    }
    
    /**
     * Tämä metodi katsoo onko parametreinä annetut kortit pari kyseisessä pakassa.
     * Toimii siis ikäänkuin "tuomarina" ja anta pisteet.
     * 
     * @param valinta1
     * @param valinta2
     * @param peli
     * @param pelaaja
     * @return 
     */
    
    public KorttiPakka arvausKerta(int valinta1, int valinta2, KorttiPakka peli, Pelaaja pelaaja) {
      if (peli.etsiKortti(valinta1)==true && peli.etsiKortti(valinta2)==true) {  
        if (peli.getKortti(valinta1).getIndeksi()==peli.getKortti(valinta2).getIndeksi()) {
            pelaaja.pisteet++;
            pelaaja.vaihdaKerta();
            System.out.println("1"+peli);
            peli.poista(valinta1, valinta2);
//            System.out.println(peli.getKortti(valinta1).getIndeksi() + " aK " + peli.getKortti(valinta2).getIndeksi());
            System.out.println(pelaaja.ilmoitus(true));
            System.out.println("2"+peli);
            return peli;
        }
        else {
            pelaaja.vaihdaKerta();
            System.out.println("Tulostetaan arvausKerta: " + peli.getInt(valinta1) + " " + peli.getInt(valinta2));
            System.out.println(pelaaja.ilmoitus(false));
            return peli;
        }
      }
      else return peli;
    }
}
