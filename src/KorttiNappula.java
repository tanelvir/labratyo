/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * Tämä on JButtonin korvaava korttinappula, johon siis liittyy kortti.
 *
 * @author tanelvir
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import labra.logiikka;
import labra.KorttiPakka;
import labra.Kortti;
import labra.Pelaaja;

public class KorttiNappula extends JButton {

    Kortti kortti;
    int index;
    JButton painike;
    
    /**
     * Luodaan nappula, jolla on oma JButton ja indeksi.
     * 
     * @param numero
     * @param indeksi
     * @param nappula 
     */

    public KorttiNappula(int numero, int indeksi, JButton nappula) {
        kortti = new Kortti(numero);
        index = indeksi;
        painike = nappula;
    }

    public ImageIcon getKuvake() {
        return this.kortti.getKuva();
    }

    public JButton setKuvake() {
        ImageIcon ikoni;
        ikoni = getKuvake();
        System.out.println("Nappulassa: " + ikoni);
        painike.setIcon(ikoni);
        painike.setText(null);
        painike.setEnabled(false);
        return painike;
    }
    
    /**
     * Ikoni katoaa. Ja teksti tulee takaisin.
     * 
     * @param teksti
     * @return kortti kuvapuoli alaspäin.
     */
    public JButton kaannaKortti(String teksti) {
        painike.setText(teksti);
        painike.setIcon(null);
        painike.setEnabled(true);
        return painike;
    }

    public int getIndeksi() {
        return this.kortti.getIndeksi();
    }
    
    /**
     * Korttia ei voi painaa toista kertaa.
     * 
     * @return kortti sumennettuna.
     */

    public JButton sumenna() {
        painike.setEnabled(false);
        return painike;
    }
    
    /**
     * Palauttaa kortin indeksin.
     * @return 
     */

    public int index() {
        return this.index;
    }

    public Kortti getKortti() {
        return kortti;
    }
}
