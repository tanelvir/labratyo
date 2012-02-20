package labra;


import java.util.*;
import labra.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * Tämä on oikeastaan kortti(pakka). Eli siis tällä hetkellä tämä käsittää HashMapin, 
 * jossa on kortteja.
 * Teen todennäköisesti pakalle oman luokan kun pääsen graafiselle puolelle.
 *
 * @author tanelvir
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Kortti {
    
    ImageIcon kuva;
    
    
    /**
     * 
     * Katsotaan mikä kuva vastaa mitäkin numeroa. 
     * Tulen muuttamaan systeemin vielä järkeväksi esim. mathRandomilla.
     * 
     * @param syötetty luku;
     * @return lukua vastaava symboli.
     * 
     */
    
    
    public Kortti (int numero) {
        if (numero==1 || numero==9) {
           kuva = new ImageIcon("omena.png");
           kuva.setDescription("omena");
        }
        else if (numero==2 || numero==10) {
            kuva = new ImageIcon("tuoli.png");
            kuva.setDescription("tuoli");
        }
        else if (numero==3 || numero==11) {
            kuva = new ImageIcon("hevonen.png");
            kuva.setDescription("hevonen");
        }
        else if (numero==4 || numero==12) {
            kuva = new ImageIcon("kivi.png");
            kuva.setDescription("kivi");
        }
        else if (numero==5 || numero==13) {
            kuva = new ImageIcon("kenka.png");
            kuva.setDescription("kenka");
        }
        else if (numero==6 || numero==14) {
            kuva = new ImageIcon("porkkana.png");
            kuva.setDescription("porkkana");
        }
        else if (numero==7 || numero==15) {
            kuva = new ImageIcon("koira.png");
            kuva.setDescription("koira");
        }
        else if (numero==8 || numero==16) {
            kuva = new ImageIcon("ovi.png");
            kuva.setDescription("ovi");
        }
        else { 
            kuva = new ImageIcon("hellpari.jpg");
            kuva.setDescription("ERROR");
        }          
    }
    
    /**
     * 
     * @return kyseisen kortin kuva 
     */
    
    public ImageIcon getKuva() {
        return kuva;
    }
    
    /**
     * Pelkkä tulostus
     * 
     * 
     * @param valitsema numero
     * @return numeroa vastaava symboli
     */
    
    public String toString(){
        return ""+kuva.getDescription();
    }   
}
