/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labra;

/**
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
    Kortti[] taulukko;
    
    
    public logiikka() {
        peli = new KorttiPakka();
        aloitaHarjoituspeli();
    }
    
    public Pelaaja Pelaajan1Nimi(String nimi) {
        pelaaja1 = new Pelaaja(nimi);
        return pelaaja1;
    }
    
    public Pelaaja Pelaajan2Nimi(String nimi) {
        pelaaja2 = new Pelaaja(nimi);
        return pelaaja2;
    }
    
    public void aloitaPeli() {        
        peli.sekoitusArvottu();
        pelaaja2.otaVuoro();
    }
    
    public void aloitaHarjoituspeli() {
        Pelaajan1Nimi("Esimerkki");
        Pelaajan2Nimi("Erkki");
        peli = new KorttiPakka();
        tehosekoitin = new KorttiPakka();
        tehosekoitin.sekoitusEiArvottu();
        peli = tehosekoitin;
        taulukko = luoTaulukko(peli);
        pelaaja2.otaVuoro();
    }
    
    public Kortti[] luoTaulukko(KorttiPakka peli) {
        Kortti[] taulu = new Kortti[peli.korttejaYhteensa()];
        for (int i = 0; i < peli.korttejaYhteensa(); i++) {
            taulu[i] = peli.getKortti(i);
        }      
        return taulu;
    }
    
   /** public void valitseEnsimmainenPelaaja1(int valinta) {
        pelaaja1.ekaKerta(valinta);
    }
    
    public void valitseEnsimmainenPelaaja2(int valinta) {
        pelaaja2.ekaKerta(valinta);
    }
    
    public void valitseToinenPelaaja1(int valinta) {
        pelaaja1.tokakerta(valinta);
    }
    
    public void valitseToinenPelaaja2(int valinta) {
        pelaaja2.tokakerta(valinta);
    }
    
    
    public int pelaajan1Valinta1() {
        return pelaaja1.getValinta1();
    }
    
    public int pelaajan1Valinta2() {
        return pelaaja1.getValinta2();
    }
    
    public int pelaajan2Valinta1() {
        return pelaaja2.getValinta1();
    }
    
    public int pelaajan2Valinta2() {
        return pelaaja2.getValinta2();
    }
    
    public int palautaPelaajan1Pisteet() {
        return pelaaja1.getPisteet();
    }
    
    public int palautaPelaajan2Pisteet() {
        return pelaaja2.getPisteet();
    } **/
    
    public void Arvaus(int vastaus1, int vastaus2, Kortti[] peli) {
        if (getPelaaja1().getVuoro()==true) {
            pelaaja1.arvausTaulu(vastaus1, vastaus2, taulukko);
            vaihdaVuoro();
            System.out.println(pelaaja2.getVuoro());
            System.out.println(vastaus1 + " :: " + vastaus2);
        }
        else { 
            pelaaja2.arvausTaulu(vastaus1, vastaus2, peli);           
            vaihdaVuoro();
            System.out.println(pelaaja2.getVuoro());
            System.out.println(vastaus1 + " :: " + vastaus2);
        }
    }
    
    public ImageIcon kuvake(int i) {
        return taulukko[i].getKuva();       
    }
    
    public int indeksi(int i) {
        return taulukko[i].getIndeksi();
    }
    
    public Kortti getKortti(int i) {
        return taulukko[i];
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
    
    public boolean etsiSeKortti(int i) {
        if (getKP().etsiKortti(i)==true)
            return true;
        else return false;
    }
    
    public void ekaKerta(int valinta, Pelaaja pelaaja) {
        pelaaja.Valinta1 = valinta;
        pelaaja.vaihdaKerta();
    }
    
    public void tokakerta(int valinta, Pelaaja pelaaja) {
        pelaaja.Valinta2 = valinta;
    }
    
    public void vaihdaVuoro() {
        getPelaaja1().vaihdaVuoro();
        getPelaaja2().vaihdaVuoro();
    }
    
    public String vuoro() {
        if (pelaaja1.getVuoro()==true)
            return "Pelaajan " + pelaaja1.getNimi() + " vuoro";
        else
            return "Pelaajan " + pelaaja2.getNimi() + " vuoro";
    }
    
    public void pelaajanVastaus(int valinta) {
        System.out.println("Pelaaja1 vuorot: " + (getPelaaja1().getKerta() + " " + getPelaaja1().getVuoro()));
        System.out.println("Pelaaja2 vuorot: " + (getPelaaja2().getKerta() + " " + getPelaaja2().getVuoro()));
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
