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

public class logiikka {
    
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;
    KorttiPakka peli;
    
    
    public Pelaaja Pelaajan1Nimi(String nimi) {
        pelaaja1 = new Pelaaja(nimi);
        return pelaaja1;
    }
    
    public Pelaaja Pelaajan2Nimi(String nimi) {
        pelaaja2 = new Pelaaja(nimi);
        return pelaaja2;
    }
    
    public void aloitaPeli() {
        peli = new KorttiPakka();
        peli.sekoitusArvottu();
        pelaaja2.otaVuoro();
    }
    
    public void aloitaHarjoituspeli() {
        Pelaajan1Nimi("Esimerkki");
        Pelaajan2Nimi("Erkki");
        peli = new KorttiPakka();
        peli.sekoitusArvottu();
        pelaaja2.otaVuoro();
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
    
    public void Arvaus() {
        if (getPelaaja1().getVuoro()==true) {
            pelaaja1.arvausKerta(getPelaaja1().getValinta1(), getPelaaja1().getValinta2(), getKP());
            vaihdaVuoro();
            System.out.println(pelaaja1.getVuoro());
            System.out.println(getPelaaja1().getValinta1() + " " + getPelaaja1().getValinta2());
        }
        else { 
            pelaaja2.arvausKerta(getPelaaja2().getValinta1(), getPelaaja2().getValinta2(), getKP());           
            vaihdaVuoro();
            System.out.println(pelaaja1.getVuoro());
            System.out.println(getPelaaja2().getValinta1() + " " + getPelaaja2().getValinta2());
        }
    }
    
    public ImageIcon kuvake(int i) {
        return getKP().getKuvake(i);       
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
    
    public void vaihdaVuoro() {
        getPelaaja1().vaihdaVuoro();
        getPelaaja2().vaihdaVuoro();
    }
    
    public void pelaajanVastaus(int valinta) {
        if (getPelaaja1().getKerta()==1 && getPelaaja1().getVuoro()==true) {
            getPelaaja1().ekaKerta(valinta);
        }
        else if (getPelaaja1().getKerta()==2 && getPelaaja1().getVuoro()==true) {
            getPelaaja1().tokakerta(valinta);
            Arvaus();
        }
        else if (getPelaaja2().getKerta()==1 && getPelaaja2().getVuoro()==true) {
            getPelaaja2().ekaKerta(valinta);
        }
        else if (getPelaaja2().getKerta()==2 && getPelaaja2().getVuoro()==true) {
            getPelaaja2().tokakerta(valinta);
            Arvaus();
        }
        else System.out.println("ERROR");
    }
}
