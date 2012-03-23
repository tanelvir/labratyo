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
    
    public KorttiNappula(int numero) {
        kortti = new Kortti(numero);
    }
    
    public ImageIcon getKuvake(){
        return kortti.getKuva();
    }
    
    public int getIndeksi(){
        return kortti.getIndeksi();
    }
            
}
