/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
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
    
    public KorttiNappula(int numero, int indeksi) {
        kortti = new Kortti(numero);
        index = indeksi;
    }
    
    public ImageIcon getKuvake(){
        return this.kortti.getKuva();
    }
    
    public void setKuvake() {
        ImageIcon ikoni;
        ikoni = getKuvake();
        this.setIcon(ikoni);
        this.setText(null);
        this.setEnabled(false);
    }
    
    public int getIndeksi(){
        return this.kortti.getIndeksi();
    }
    
    public void sumenna(){
        this.setVisible(false);
    }
    
    public int index(){
        return this.index;
    }
    
    public Kortti getKortti() {
        return kortti;
    }
            
}
